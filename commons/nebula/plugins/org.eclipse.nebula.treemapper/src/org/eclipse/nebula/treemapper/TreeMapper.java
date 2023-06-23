/*******************************************************************************
* Copyright (c) 2011, 2016 PetalsLink
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v2.0
* which accompanies this distribution, and is available at
* https://www.eclipse.org/legal/epl-2.0/
*
* Contributors:
* Mickael Istria, PetalsLink - initial API and implementation
*******************************************************************************/

package org.eclipse.nebula.treemapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.nebula.treemapper.internal.LinkFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TreeDragSourceEffect;
import org.eclipse.swt.dnd.TreeDropTargetEffect;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;

/**
 * A TreeMapper is a composite viewer the creates 2 {@link TreeViewer} (left and right)
 * and an area to display mappings between tree nodes.
 * It relies on a {@link ISemanticTreeMapperSupport} to create your business mapping objects,
 * and to resolve the bounds of a mapping object to object that are provided in the trees.
 * 
 * @author Mickael Istria (PetalsLink)
 * @since 0.1.0
 * @noextend This class is not intended to be subclassed by clients.
 *
 * @param <M> The type of the business <b>M<b>apping object
 * @param <L> The type of the left bound of the mapping (as provided by <b>L</b>eft {@link ITreeContentProvider})
 * @param <R> The type of the left bound of the mapping (as provided by <b>R</>ight {@link ITreeContentProvider})
 */
public class TreeMapper<M, L, R> implements ISelectionProvider {

	private SashForm control;
	private TreeMapperUIConfigProvider uiConfig;
	
	private TreeViewer leftTreeViewer;
	private TreeViewer rightTreeViewer;
	private TreeItem leftTopItem;
	private TreeItem rightTopItem;

	private Canvas linkCanvas;
	private LightweightSystem linkSystem;
	private Figure linkRootFigure;
	private boolean canvasNeedRedraw;
	
	private List<M> mappings;
	private Map<LinkFigure, M> figuresToMappings;
	private Map<M, LinkFigure> mappingsToFigures;
	private List<LinkFigure> selectedFigures = new ArrayList<LinkFigure>();
	private List<M> selectedMappings = new ArrayList<M>();
	private ISemanticTreeMapperSupport<M, L, R> semanticSupport;

	
	public TreeMapper(Composite parent, ISemanticTreeMapperSupport<M, L, R> semanticSupport, TreeMapperUIConfigProvider uiConfig) {
		this.uiConfig = uiConfig;
		this.semanticSupport = semanticSupport;
		control = new SashForm(parent, SWT.HORIZONTAL);
		control.setLayout(new FillLayout());
		// left
		leftTreeViewer = new TreeViewer(control);
		//center
		linkCanvas = new Canvas(control, SWT.NONE);
		linkCanvas.setLayout(new FillLayout());
		linkCanvas.setBackground(ColorConstants.white);
		linkSystem = new LightweightSystem(linkCanvas);
		linkRootFigure = new Figure();
		linkRootFigure.setLayoutManager(new XYLayout());
		linkSystem.setContents(linkRootFigure);
		// right
		rightTreeViewer = new TreeViewer(control);
		
		figuresToMappings = new HashMap<LinkFigure, M>();
		mappingsToFigures = new HashMap<M, LinkFigure>();
		
		// Resize
		ControlListener resizeListener = new ControlListener() {
			public void controlResized(ControlEvent e) {
				canvasNeedRedraw = true;
			}
			public void controlMoved(ControlEvent e) {
				canvasNeedRedraw = true;
			}
		};
		leftTreeViewer.getTree().addControlListener(resizeListener);
		rightTreeViewer.getTree().addControlListener(resizeListener);
		linkCanvas.addControlListener(resizeListener);
		// Scroll
		leftTreeViewer.getTree().addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (canvasNeedRedraw || leftTreeViewer.getTree().getTopItem() != leftTopItem) {
					leftTopItem = leftTreeViewer.getTree().getTopItem();
					redrawMappings();
				}
			}
		});
		rightTreeViewer.getTree().addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (canvasNeedRedraw || rightTreeViewer.getTree().getTopItem() != rightTopItem) {
					rightTopItem = rightTreeViewer.getTree().getTopItem();
					redrawMappings();
					canvasNeedRedraw = false;
				}
			}
		});
		// Expand
		TreeListener treeListener = new TreeListener() {
			public void treeExpanded(TreeEvent e) {
				canvasNeedRedraw = true;
			}
			public void treeCollapsed(TreeEvent e) {
				canvasNeedRedraw = true;	
			}
		};
		leftTreeViewer.getTree().addTreeListener(treeListener);
		rightTreeViewer.getTree().addTreeListener(treeListener);
		
		control.setWeights(new int[] { 1, 2, 1} );
		
		bindTreeForDND(leftTreeViewer, rightTreeViewer, SWT.LEFT_TO_RIGHT);
		bindTreeForDND(rightTreeViewer, leftTreeViewer, SWT.RIGHT_TO_LEFT);
		
		linkCanvas.addKeyListener(new KeyListener() {
			public void keyReleased(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.DEL) { // Del
					fireMappingsDeletion(selectedMappings);
				} else if (e.keyCode == 'a' && (e.stateMask & SWT.CTRL) != 0) { // Ctrl + A
					selectAllMappings();
				} else if (e.keyCode == 'd' && (e.stateMask & SWT.CTRL) != 0) { // Ctrl + D
					fireMappingsDeletion(selectedMappings);
				}
			}
		});
	}
	
	/**
	 * Set the content providers for both trees.
	 * Both tree provides MUST HAVE their {@link ITreeContentProvider#getParent(Object)} method implemeneted.
	 * @param leftContentProvider An {@link ITreeContentProvider} that node are instances of the <b>L<b> type parameter.
	 * @param rightTreeContentProvider An {@link ITreeContentProvider} that node are instances of the <b>R<b> type parameter.
	 */
	public void setContentProviders(ITreeContentProvider leftContentProvider, ITreeContentProvider rightTreeContentProvider) {
		leftTreeViewer.setContentProvider(leftContentProvider);
		rightTreeViewer.setContentProvider(rightTreeContentProvider);
	}
	
	public void setLabelProviders(IBaseLabelProvider leftLabelProvider, IBaseLabelProvider rightLabelProvider) {
		leftTreeViewer.setLabelProvider(leftLabelProvider);
		rightTreeViewer.setLabelProvider(rightLabelProvider);
	}
	
	/**
	 * Sets the input of the widget.
	 * @param leftTreeInput The input for left {@link TreeViewer}
	 * @param rightTreeInput The input for right {@link TreeViewer}
	 * @param mappings The list containing the mapping. It will be used as a working copy and
	 * then MODIFIED by the tree mapper. If you don't want to pass a modifiable list, then pass
	 * a copy of the default mapping list, and prefer using {@link TreeMapper}{@link #addNewMappingListener(INewMappingListener)}
	 * and {@link INewMappingListener} to track the creation of mapping.
	 */
	public void setInput(Object leftTreeInput, Object rightTreeInput, List<M> mappings) {
		clearFigures();
		if (leftTreeInput != null) {
			leftTreeViewer.setInput(leftTreeInput);
		}
		if (rightTreeInput != null) {
			rightTreeViewer.setInput(rightTreeInput);
		}
		if (mappings != null) {
			this.mappings = mappings;
			canvasNeedRedraw = true;
		} else {
			this.mappings = new ArrayList<M>();
		}
		// Hacky way to synchronize tree and viewers for mappings:
		// Expand left and right items of mappings, and then restore
		// tree to previous state
		for (M mapping : this.mappings) {
			L leftItem = semanticSupport.resolveLeftItem(mapping);
			leftTreeViewer.expandToLevel(leftItem, 0);
			R rightItem = semanticSupport.resolveRightItem(mapping);
			rightTreeViewer.expandToLevel(rightItem, 0);
		}

	}

	/**
	 * DO NOT USE IN CODE. Prefer setting "canvasNeedsRedraw" field to true to
	 * avoid useless operations.
	 * @param mappings
	 */
	private void redrawMappings() {
		if (this.mappings == null || this.mappings.size() == 0) {
			return;
		}
		
		for (M mapping : this.mappings) {
			drawMapping(mapping);
			selectedFigures.clear();
			if (selectedMappings.contains(mapping)) {
				LinkFigure newSelectedFigure = mappingsToFigures.get(mapping);
				applySelectedMappingFeedback(newSelectedFigure);
				selectedFigures.add(newSelectedFigure);
			}
		}
	}

	/**
	 * @param sourceTreeViewer
	 * @param targetTreeViewer
	 * @param direction
	 */
	private void bindTreeForDND(final TreeViewer sourceTreeViewer, final TreeViewer targetTreeViewer, final int direction) {
		final LocalSelectionTransfer sourceTransfer = LocalSelectionTransfer.getTransfer();
		final LocalSelectionTransfer targetTransfer = LocalSelectionTransfer.getTransfer();
		sourceTreeViewer.addDragSupport(DND.DROP_LINK, new Transfer[] { sourceTransfer }, new TreeDragSourceEffect(sourceTreeViewer.getTree()) {
			@Override
			public void dragStart(DragSourceEvent event) {
				event.doit = !sourceTreeViewer.getSelection().isEmpty();
			}
		});
		targetTreeViewer.addDropSupport(DND.DROP_LINK, new Transfer[] { targetTransfer }, new TreeDropTargetEffect(targetTreeViewer.getTree()) {
			@Override
			public void dragEnter(DropTargetEvent event) {
				event.feedback = DND.FEEDBACK_EXPAND | DND.FEEDBACK_SCROLL | DND.FEEDBACK_SELECT;
				event.detail = DND.DROP_LINK;
				super.dragEnter(event);
			}
			
			@Override
			public void drop(DropTargetEvent event) {
				performMappingByDrop(sourceTreeViewer, sourceTreeViewer.getSelection(), targetTreeViewer, (TreeItem) getItem(event.x, event.y), direction);
			}
		});
	}

	/**
	 * @param targetTreeViewer 
	 * @param data
	 * @param widget
	 */
	@SuppressWarnings("unchecked")
	protected void performMappingByDrop(TreeViewer sourceTreeViewer, ISelection sourceData, TreeViewer targetTreeViewer, TreeItem targetTreeItem, int direction) {
		Object resolvedTargetItem = resolveTreeViewerItem(targetTreeViewer, targetTreeItem);
		for (Object sourceItem : ((IStructuredSelection)sourceData).toList()) {
			if (direction == SWT.LEFT_TO_RIGHT) {
				createMapping((L)sourceItem, (R)resolvedTargetItem);
			} else if (direction == SWT.RIGHT_TO_LEFT) {
				createMapping((L)resolvedTargetItem, (R)sourceItem);
			}
		}
	}

	/**
	 * @param leftItem
	 * @param resolvedTargetItem
	 */
	private void createMapping(L leftItem, R rightItem) {
		if (!semanticSupport.canCreateSemanticMappingObject(leftItem, rightItem)) {
			return;
		}
		M newMapping = semanticSupport.createSemanticMappingObject(leftItem, rightItem);
		if (newMapping != null) {
			mappings.add(newMapping);
			refresh();
			drawMapping(newMapping);
			for (INewMappingListener<M> listener : creationListeners) {
				listener.mappingCreated(newMapping);
			}
			setSelection(new StructuredSelection(newMapping));
		}
	}
	
	private void deleteMapping(M mapping) {
		LinkFigure figure = mappingsToFigures.get(mapping);
		mappings.remove(mapping);
		selectedMappings.remove(mapping);
		mappingsToFigures.remove(mapping);
		selectedFigures.remove(figure);
		figuresToMappings.remove(figure);
		semanticSupport.deleteSemanticMappingObject(mapping);
		if (figure != null) {
			figure.deleteFromParent();

		}
		refresh();
		for (IDeletedMappingListener<M> listener : deletionListeners) {
			listener.mappingDeleted(mapping);
		}
		setSelection(new StructuredSelection());
	}

	/**
	 * @param leftItem
	 * @param rightItem
	 */
	private void drawMapping(final M mapping) {
		LinkFigure previousFigure = mappingsToFigures.get(mapping);
		if (previousFigure != null) {
			previousFigure.deleteFromParent();
			mappingsToFigures.remove(mapping);
			figuresToMappings.remove(previousFigure);
		}
		
		boolean leftItemVisible = true;
		TreeItem leftTreeItem = (TreeItem) leftTreeViewer.testFindItem(semanticSupport.resolveLeftItem(mapping));
		TreeItem lastVisibleLeftTreeItem = leftTreeItem;
		if (leftTreeItem != null) {
			while (leftTreeItem.getParentItem() != null) {
				if (!leftTreeItem.getParentItem().getExpanded()) {
					lastVisibleLeftTreeItem = leftTreeItem.getParentItem();
					leftItemVisible = false;
				}
				leftTreeItem = leftTreeItem.getParentItem();
			}
		}
		
		boolean rightItemVisible = true;
		TreeItem rightTreeItem = (TreeItem) rightTreeViewer.testFindItem(semanticSupport.resolveRightItem(mapping));
		TreeItem lastVisibleRightTreeItem = rightTreeItem;
		if (rightTreeItem != null) {
			while (rightTreeItem.getParentItem() != null) {
				if (!rightTreeItem.getParentItem().getExpanded()) {
					lastVisibleRightTreeItem = rightTreeItem.getParentItem();
					rightItemVisible = false;
				}
				rightTreeItem = rightTreeItem.getParentItem();
			}
		}
		
		if (lastVisibleLeftTreeItem == null || lastVisibleRightTreeItem == null) {
			return;
		}
		final LinkFigure arrowFigure = new LinkFigure(linkRootFigure);
		// store it
		figuresToMappings.put(arrowFigure, mapping);
		mappingsToFigures.put(mapping, arrowFigure);
		
		arrowFigure.setLeftPoint(0, lastVisibleLeftTreeItem.getBounds().y + lastVisibleLeftTreeItem.getBounds().height / 2);
		arrowFigure.setLeftMappingVisible(leftItemVisible);
		arrowFigure.setRightPoint(linkRootFigure.getBounds().width, lastVisibleRightTreeItem.getBounds().y + rightTreeItem.getBounds().height / 2);
		arrowFigure.setRightMappingVisible(rightItemVisible);
		
		arrowFigure.setLineWidth(uiConfig.getDefaultArrowWidth());
		arrowFigure.seLineColor(uiConfig.getDefaultMappingColor());
		arrowFigure.addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent me) {
				boolean addToSelection = ((me.getState() & SWT.CONTROL) > 0); 
				fireMappingSelection(mapping, arrowFigure, addToSelection);
			}
			public void mouseReleased(MouseEvent me) {
			}

			public void mouseDoubleClicked(MouseEvent me) {
				//if (arrowFigure.)
			}
		});
		arrowFigure.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent me) {
			}

			public void mouseEntered(MouseEvent me) {
				fireMouseEntered(mapping, arrowFigure);
			}

			public void mouseExited(MouseEvent me) {
				fireMouseExited(mapping, arrowFigure);
			}

			public void mouseHover(MouseEvent me) {
			}

			public void mouseMoved(MouseEvent me) {
			}
			
		});
	}

	/**
	 * @param treeViewer
	 * @param treeItem
	 * @return
	 */
	private Object resolveTreeViewerItem(TreeViewer treeViewer, TreeItem treeItem) {
		//return treeItem.getData();
		ITreeContentProvider contentProvider = (ITreeContentProvider) treeViewer.getContentProvider();
		List<Integer> locations = new ArrayList<Integer>();
		TreeItem parentTreeItem = treeItem.getParentItem();
		while (parentTreeItem != null) {
			int index = Arrays.asList(parentTreeItem.getItems()).indexOf(treeItem);
			locations.add(index);
			treeItem = parentTreeItem;
			parentTreeItem = treeItem.getParentItem();
		}
		// root
		if (treeItem != null) {
			int rootIndex = Arrays.asList(treeViewer.getTree().getItems()).indexOf(treeItem);
			locations.add(rootIndex);
		}
		Collections.reverse(locations);
		Object current = contentProvider.getElements(treeViewer.getInput())[locations.get(0)];
		locations.remove(0);
		for (int index : locations) {
			current = contentProvider.getChildren(current)[index];
		}
		return current;
	}

	/**
	 * @return
	 */
	public SashForm getControl() {
		return control;
	}
	
	
	//
	// Selection management
	//
	
	private List<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();
	private IStructuredSelection currentSelection = new StructuredSelection();
	
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		this.selectionChangedListeners.add(listener);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 */
	public IStructuredSelection getSelection() {
		return currentSelection;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	public void setSelection(ISelection selection) {
		IStructuredSelection strSelection = (IStructuredSelection)selection;
		if (strSelection.isEmpty()) {
			// Deselect all figures and mappings
			currentSelection = new StructuredSelection();
			for (M selectedMapping : selectedMappings) {
				applyDefaultMappingStyle(mappingsToFigures.get(selectedMapping));
			}
			selectedFigures.clear();
			selectedMappings.clear();
		} else {
			currentSelection = strSelection;
			// Deselect previously selected mappings
			List<M> previouslySelectedMappings = new ArrayList<M>(selectedMappings);
			for (M previouslySelectedMapping : previouslySelectedMappings) {
				LinkFigure arrowFigure = mappingsToFigures.get(previouslySelectedMapping);
				if (!strSelection.toList().contains(previouslySelectedMapping)) {
					selectedFigures.remove(arrowFigure);
					selectedMappings.remove(previouslySelectedMapping);
					applyDefaultMappingStyle(arrowFigure);
				}
			}
			// Display new selected mappings 
			for (Object newSelectedObject : strSelection.toList()) {
				@SuppressWarnings("unchecked")
				M newSelectedMapping = (M)newSelectedObject;
				if (!selectedMappings.contains(newSelectedMapping)) {
					LinkFigure arrowFigure = mappingsToFigures.get(newSelectedMapping);
					selectedFigures.add(arrowFigure);
					selectedMappings.add(newSelectedMapping);
					applySelectedMappingFeedback(arrowFigure);
				}
			}
		}
		// Notify listeners that the selection changed
		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, currentSelection));
		}
	}
	
	/**
	 * @param mapping
	 * @param arrowFigure
	 */
	@SuppressWarnings("unchecked")
	protected void fireMappingSelection(M mapping, LinkFigure arrowFigure, boolean addToSelection) {
		if (addToSelection == false) {
			currentSelection = new StructuredSelection(mapping);
		} else {
			List<M> mappings = new ArrayList<M>(getSelection().toList());
			mappings.add(mapping);
			currentSelection = new StructuredSelection(mappings);
		}
		setSelection(getSelection());
	}
	
	private void selectAllMappings() {
		setSelection(new StructuredSelection(mappings));
	}
	
	protected void fireMappingsDeletion(Collection<M> mappings) {
		Collection<M> existingMappings = new ArrayList<M>(mappings);
		if (semanticSupport.canDeleteSemanticMappingObjects(existingMappings)) {
			for (M mapping : existingMappings) {
				deleteMapping(mapping);
			}
		}
	}
	
	private void unselect(M mapping) {
		if (selectedMappings.contains(mapping)) {
			selectedMappings.remove(mapping);
			selectedFigures.remove(mappingsToFigures.get(mapping));
		}
		currentSelection = new StructuredSelection(selectedMappings);
		for (ISelectionChangedListener listener : selectionChangedListeners) {
			listener.selectionChanged(new SelectionChangedEvent(this, currentSelection));
		}
	}

	
	//
	// Creation and deletion management
	//
	
	private List<INewMappingListener<M>> creationListeners = new ArrayList<INewMappingListener<M>>();
	private List<IDeletedMappingListener<M>> deletionListeners = new ArrayList<IDeletedMappingListener<M>>();
	
	/**
	 * @param iNewMappingListener
	 */
	public void addNewMappingListener(INewMappingListener<M> listener) {
		this.creationListeners.add(listener);
	}
	
	/**
	 * @param iDeletedMappingListener
	 */
	public void addDeletedMappingListener(IDeletedMappingListener<M> listener) {
		this.deletionListeners.add(listener);
	}
	
	/**
	 * 
	 */
	protected void applyDefaultMappingStyle(LinkFigure figure) {
		if (figure == null) {
			return;
		}
		figure.seLineColor(uiConfig.getDefaultMappingColor());
		figure.setLineWidth(uiConfig.getDefaultArrowWidth());
	}

	/**
	 * @param arrowFigure
	 */
	protected void applySelectedMappingFeedback(LinkFigure arrowFigure) {
		if (arrowFigure == null) {
			return;
		}
		arrowFigure.seLineColor(uiConfig.getSelectedMappingColor());
		arrowFigure.setLineWidth(uiConfig.getHoverArrowWidth());
	}
	
	/**
	 * @param mapping
	 * @param arrowFigure
	 */
	protected void fireMouseExited(M mapping, LinkFigure arrowFigure) {
		if (!selectedFigures.contains(arrowFigure)) {
			applyDefaultMappingStyle(arrowFigure);
		}
	}

	/**
	 * @param mapping
	 * @param arrowFigure
	 */
	protected void fireMouseEntered(M mapping, LinkFigure arrowFigure) {
		if (!selectedFigures.contains(arrowFigure)) {
			arrowFigure.setLineWidth(uiConfig.getHoverArrowWidth());
		}
	}

	/**
	 * @return
	 */
	public TreeViewer getLeftTreeViewer() {
		return leftTreeViewer;
	}
	
	/**
	 * @return
	 */
	public TreeViewer getRightTreeViewer() {
		return rightTreeViewer;
	}

	
	/**
	 * Refresh the widget by resetting the setInput value
	 */
	public void refresh() {
		setInput(leftTreeViewer.getInput(), rightTreeViewer.getInput(), mappings);
		
		List<M> alreadySelectedMapping = new ArrayList<M>(selectedMappings);
		for (M selectedMapping : alreadySelectedMapping) {
			if (!mappings.contains(selectedMapping)) {
				unselect(selectedMapping);
			}
		}
		leftTreeViewer.refresh();
		rightTreeViewer.refresh();
		canvasNeedRedraw = true;
		control.layout(true);
	}

	/**
	 * 
	 */
	private void clearFigures() {
		for (Entry<M, LinkFigure> entry : mappingsToFigures.entrySet()) {
			entry.getValue().deleteFromParent();
		}
		mappingsToFigures.clear();
		figuresToMappings.clear();
	}

	/**
	 * @return the mappings
	 */
	protected List<M> getMappings() {
		return mappings;
	}
}
