/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.wizards;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.sirius.common.tools.api.util.StringMatcher;
import org.eclipse.sirius.common.ui.tools.api.selection.page.AbstractSelectionWizardPage;
import org.eclipse.sirius.common.ui.tools.api.util.SWTUtil;
import org.eclipse.sirius.diagram.ui.provider.DiagramUIPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.obeonetwork.utils.common.ui.handlers.SelectionHelper;

public class ISObjectSelectionWizardPage extends AbstractSelectionWizardPage {

    private Composite pageComposite;

    private ISObjectTreeItemWrapper treeRoot;

    private final AdapterFactoryLabelProvider defaultAdapterFactoryLabelProvider;
    
    private ISObjectCustomLabelProvider customLabelProvider = null;

	private Set<ISObjectTreeItemWrapper> selectedTreeItemWrapers = new HashSet<>();

    private Set<ISObjectTreeItemWrapper> ungrayedTreeItemWrapers = new HashSet<>();
    
    private Set<ISObjectTreeItemWrapper> preSelectedTreeItemWrappers = new HashSet<>();
    
    private Set<ISObjectTreeItemWrapper> alwaysSelectedTreeItemWrappers = new HashSet<>();
    
    private boolean many = false;
    
    private TreeViewer treeViewer;

	private ISObjectSelectionFilter viewerFilter;

	private boolean expanded = true;
	
	private Integer levelToExpand = null;
	
	private ISelectionInductor selectionInductor = null;

	private IPageCompleteTester pageCompleteTester = null;
	
	public enum SelectMode {
		HIERARCHIC, PICK_ANY
	}
	private SelectMode treeSelectMode = SelectMode.HIERARCHIC;

	private ICheckBoxFilter checkBoxFilter = null;

    public ISObjectSelectionWizardPage(
    		String pageName, 
    		String title, 
    		ImageDescriptor imageTitle, 
    		ISObjectTreeItemWrapper treeRoot, 
    		boolean many) {
        super(pageName, title, imageTitle);
        this.treeRoot = treeRoot;
        this.many = many;
        this.defaultAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(DiagramUIPlugin.getPlugin().getItemProvidersAdapterFactory());
    }

    /**
     * Determines whether the tree should be unfolded by default.
     * Default is true.
     * @see ISObjectSelectionWizardPage#setExpandedByDefault
     * 
     * @param expanded
     */
	public void setExpandedByDefault(boolean expanded) {
		this.expanded  = expanded;
	}
	
	public void setLevelToExpand(int levelToExpand) {
		setExpandedByDefault(false);
		this.levelToExpand = levelToExpand;
	}
    
	/**
	 * Set the behavior of the selection in the tree.
	 * Valid values are HIERARCHIC and PICK_ANY.
	 * Default value is HIERARCHIC.
	 * 
	 * @param treeSelectMode
	 */
	public void setTreeSelectMode(SelectMode treeSelectMode) {
		this.treeSelectMode  = treeSelectMode;
	}
	
	public void setCheckBoxFilter(ICheckBoxFilter checkBoxFilter) {
		this.checkBoxFilter  = checkBoxFilter;
	}
	
    /**
     * Sets the ISObjectCustomLabelProvider. If ISObjectCustomLabelProvider.getText returns
     * null or an empty string, or if the customLabelProvider is set to null, the text label
     * generation falls back to the default label provider.
     * 
     * @param customLabelProvider
     */
    public void setCustomLabelProvider(ISObjectCustomLabelProvider customLabelProvider) {
		this.customLabelProvider = customLabelProvider;
	}

    @Override
    public void createControl(final Composite parent) {
    	
    	preSelectedTreeItemWrappers.addAll(alwaysSelectedTreeItemWrappers);
    	
        initializeDialogUnits(parent);

        pageComposite = new Composite(parent, SWT.NONE);
        pageComposite.setLayout(new GridLayout());
        pageComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        if(checkBoxFilter != null) {
        	createFilterCheckBox(pageComposite);
        }
        
        createSelectionGroup(pageComposite);
        
        treeViewer = createTreeViewer(pageComposite);

        treeViewer.setInput(this.treeRoot);
        
        viewerFilter.setTreeViewer(treeViewer);
        
        // We need to expand all the tree to be able to find the preselected TreeItems
        // any other idea is welcomed
        treeViewer.expandAll();
        
//        initRootPrefix(); 
        
        if(!preSelectedTreeItemWrappers.isEmpty()) {
        	ArrayList<TreeItem> preSelectedTreeItems = new ArrayList<>();
        	collectPreSelectedTreeItems(preSelectedTreeItems, treeViewer.getTree().getItems());
        	treeViewer.getTree().setSelection(preSelectedTreeItems.toArray(new TreeItem[] {}));
        	selectedTreeItemWrapers.addAll(preSelectedTreeItems.stream()
        			.map(item -> item.getData())
        			.map(ISObjectTreeItemWrapper.class::cast)
        			.collect(toList()));
        }
        
        if(checkBoxFilter != null) {
    		viewerFilter.setFilterActive(checkBoxFilter.getDefaultCheckValue());
        }

        // Expand the tree according to the 'expanded' and 'levelToExpand' values
        treeViewer.collapseAll();
        expandTreeViewer();
        
        treeViewer.refresh();
        
        if(pageCompleteTester != null) {
        	setPageComplete(pageCompleteTester.isPageComplete(getSelectedTreeItemWrappers(), getPartiallySelectedTreeItemWrappers()));
        }
        
        setControl(pageComposite);
    }
    
	private void expandTreeViewer() {
		if(expanded) {
            treeViewer.expandAll();
        } else if(levelToExpand != null) {
            
    		// Ensure checked elements are visible in the expanded tree
    		
    		// Unicity is needed for the 'elementsToExpand' collection because there may be 
            // common ancestors in the tree of several checked elements. Insertion order 
            // is also needed for the higher nodes to expand first. 
    		LinkedHashSet<ISObjectTreeItemWrapper> elementsToExpand = new LinkedHashSet<>();
    		for(ISObjectTreeItemWrapper tiw : selectedTreeItemWrapers) {
    			elementsToExpand.addAll(tiw.getAncestors());
    			elementsToExpand.add(tiw);
    		}
    		treeViewer.setExpandedElements(elementsToExpand.toArray());
    		
    		// Expand at least to the required level
            treeViewer.expandToLevel(levelToExpand);
        }
		
	}

    private Control createFilterCheckBox(Composite parent) {
		Button checkButton = new Button(parent, SWT.CHECK);

		checkButton.setText(checkBoxFilter.getLabel());
		
		checkButton.setSelection(checkBoxFilter.getDefaultCheckValue());

		checkButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				viewerFilter.setFilterActive(checkButton.getSelection());
				expandTreeViewer();
				treeViewer.refresh();
			}
			
		});		
		
		return checkButton;
	}

	private void collectPreSelectedTreeItems(List<TreeItem> preSelectedItems, TreeItem[] items) {
		for(int i = 0; i < items.length; i++) {
			if(preSelectedTreeItemWrappers.contains((ISObjectTreeItemWrapper)items[i].getData()) && ! preSelectedItems.contains(items[i])) {
				preSelectedItems.add(items[i]);
			}
			collectPreSelectedTreeItems(preSelectedItems, items[i].getItems());
		}
	}

	public void setPreSelectedObjects(Collection<? extends Object> preSelectedObjects) {
		preSelectedTreeItemWrappers = new HashSet<>();
		collectTreeItemWrappers(preSelectedTreeItemWrappers, preSelectedObjects, treeRoot);
	}

	private void collectTreeItemWrappers(Collection<ISObjectTreeItemWrapper> treeItemWrappers, Collection<? extends Object> objects, ISObjectTreeItemWrapper treeItemWrapper) {
		if(objects.contains(treeItemWrapper.getWrappedObject())) {
			treeItemWrappers.add(treeItemWrapper);
		}
		for(ISObjectTreeItemWrapper childTreeItemWrapper : treeItemWrapper.getChildren()) {
			collectTreeItemWrappers(treeItemWrappers, objects, childTreeItemWrapper);
		}
	}

	public void setPreSelectedTreeItemWrappers(Collection<ISObjectTreeItemWrapper> preSelectedTreeItemWrappers) {
		this.preSelectedTreeItemWrappers = new HashSet<>(preSelectedTreeItemWrappers);
	}
	
	public void setAlwaysSelectedObjects(Collection<? extends Object> alwaysSelectedObjects) {
		alwaysSelectedTreeItemWrappers = new HashSet<>();
		collectTreeItemWrappers(alwaysSelectedTreeItemWrappers, alwaysSelectedObjects, treeRoot);
	}
	
	public void setAlwaysSelectedTreeItemWrappers(Collection<ISObjectTreeItemWrapper> alwaysSelectedTreeItemWrappers) {
		this.alwaysSelectedTreeItemWrappers = new HashSet<>(alwaysSelectedTreeItemWrappers);
	}

	protected Composite createSelectionGroup(final Composite parent) {
        final Composite composite = SWTUtil.createCompositeHorizontalFill(parent, 1, false);
        SWTUtil.createLabel(composite, "Enter prefix or pattern (? = any character, * = any String): ");
        elementsToSelectText = new Text(composite, SWT.BORDER | SWT.SEARCH);
        elementsToSelectText.setMessage("Filter elements");
        final GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        elementsToSelectText.setLayoutData(gridData);
        elementsToSelectText.addModifyListener(new ISObjectSelectionModifyAdapter());

        return composite;

    }
    
    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.jface.wizard.WizardPage#isCurrentPage()
     */
    @Override
    public boolean isCurrentPage() {
        // increases visibility
        return super.isCurrentPage();
    }

    /**
     * Create a tableViewer
     * 
     * @param parent
     *            the parent composite
     * @return the created tableViewer
     */
    private TreeViewer createTreeViewer(final Composite parent) {
        TreeViewer viewer = null;
        if (!many) {
            viewer = new TreeViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
            viewer.addSelectionChangedListener(new ISObjectSelectionChangedListener());
            
            viewer.getTree().addMouseListener(MouseListener.mouseDoubleClickAdapter(evt -> {

                ISObjectSelectionWizard wizard = (ISObjectSelectionWizard) this.getWizard();
                if (wizard.getDialog() != null) {
                    wizard.getDialog().finishPressed();
                }
            }));
        } else {
        	CheckboxTreeViewer checkboxTreeViewer = new CheckboxTreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
            checkboxTreeViewer.addCheckStateListener(new ISObjectSelectionCheckStateListener());
            checkboxTreeViewer.setCheckStateProvider(new ISObjectSelectionCheckStateProvider());
        	viewer = checkboxTreeViewer;
        }
        
        final GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        viewer.getControl().setLayoutData(gridData);
        viewer.getTree().setHeaderVisible(false);
        viewer.getTree().setLinesVisible(false);
        viewer.setContentProvider(new ISTreeItemWrapperContentProvider());
        viewer.setLabelProvider(new ISObjectSelectionLabelProvider());
        // Sorting the tree nodes doesn't seem a good idea. We usually want to see the tree contents
        // in the same sorting order than in the Model Explorer
//        viewer.setComparator(new ViewerComparator());
        viewerFilter = new ISObjectSelectionFilter();
        viewer.addFilter(viewerFilter);

        return viewer;
    }

//    /**
//     * Compute a common prefix for all items.
//     */
// FIXME Doesn't work with the checkbox filter. The appropriate behavior would probably be
//       to reinitialize the root prefix when the filter checkbox is unselected but it doesn't
//       work as expected. No time to dig further into that right now. Topic stays open.
//    private void initRootPrefix() {
//        String prefix = null;
//        boolean again = true;
//
//        final int count = this.treeViewer.getTree().getItemCount();
//
//        for (int i = 0; i < count && again; i++) {
//            final TreeItem treeItem = this.treeViewer.getTree().getItem(i);
//            prefix = computeCommonPrefix(prefix, treeItem);
//            if (prefix == null) {
//                again = false;
//            } else {
//                prefix = computeChildrenPrefix(prefix, treeItem);
//                if (prefix == null) {
//                    again = false;
//                }
//            }
//
//        }
//        if (prefix != null) {
//            this.elementsToSelectText.setText(prefix);
//            this.elementsToSelectText.setSelection(prefix.length());
//        }
//    }
//
//    private String computeChildrenPrefix(final String oldPrefix, final TreeItem parent) {
//        String prefix = oldPrefix;
//        boolean again = true;
//
//        final int count = parent.getItemCount();
//
//        for (int i = 0; i < count && again; i++) {
//            final TreeItem treeItem = parent.getItem(i);
//            prefix = computeCommonPrefix(prefix, treeItem);
//            if (prefix == null) {
//                again = false;
//            } else {
//                prefix = computeChildrenPrefix(prefix, treeItem);
//                if (prefix == null) {
//                    again = false;
//                }
//            }
//        }
//        return prefix;
//    }
//
//    private String computeCommonPrefix(final String oldPrefix, final TreeItem treeItem) {
//        String prefix = oldPrefix;
//        if (prefix == null) {
//            // the prefix is equal to the first item (default)
//            prefix = treeItem.getText();
//        } else {
//            if (!treeItem.getText().startsWith(prefix)) {
//                // we must find a new prefix.
//                int searchIndex = Math.min(prefix.length() - 1, treeItem.getText().length());
//                String newPrefix = null;
//                while (searchIndex > 0 && newPrefix == null) {
//                    if (treeItem.getText().startsWith(prefix.substring(0, searchIndex))) {
//                        newPrefix = prefix.substring(0, searchIndex);
//                    } else {
//                        searchIndex--;
//                    }
//                }
//                if (newPrefix != null) {
//                    prefix = newPrefix;
//                } else {
//                    // no common prefix found.
//                    prefix = null;
//                }
//            }
//        }
//        return prefix;
//    }

    public ISObjectTreeItemWrapper getSelectedTreeItemWrapper() {
        return selectedTreeItemWrapers.stream().findFirst().orElse(null);
    }
    
    /**
     * Get the selected Object. If several objects are selected, return any one of them.
     * 
     * @return the selected Object
     */
    public Object getSelectedObject() {
        return Optional.ofNullable(getSelectedTreeItemWrapper()).map(tiw -> tiw.getWrappedObject()).orElse(null);
    }

    public Collection<ISObjectTreeItemWrapper> getSelectedTreeItemWrappers() {
        return selectedTreeItemWrapers;
    }
    
    public Collection<ISObjectTreeItemWrapper> getAlwaysSelectedTreeItemWrappers() {
        return alwaysSelectedTreeItemWrappers;
    }
    
    /**
     * Get the selected {@link Object}s.
     * 
     * @return the list of selected objects.
     */
    public Collection<Object> getSelectedObjects() {
        return getSelectedTreeItemWrappers().stream().map(tiw -> tiw.getWrappedObject()).collect(toList());
    }

    public Collection<ISObjectTreeItemWrapper> getPartiallySelectedTreeItemWrappers() {
    	List<ISObjectTreeItemWrapper> partiallySelectedTreeItemWrappers = new ArrayList<>();
    	collectPartiallySelectedTreeItemWrappers(partiallySelectedTreeItemWrappers, treeRoot);
        return partiallySelectedTreeItemWrappers;
    }
    
	private void collectPartiallySelectedTreeItemWrappers(List<ISObjectTreeItemWrapper> partiallySelectedTreeItemWrappers, ISObjectTreeItemWrapper treeItemWrapper) {
		if(treeItemWrapper.getWrappedObject() != null && isPartiallySelected(treeItemWrapper)) {
			partiallySelectedTreeItemWrappers.add(treeItemWrapper);
		}
		for(ISObjectTreeItemWrapper childTreeItemWrapper : treeItemWrapper.getChildren()) {
			collectPartiallySelectedTreeItemWrappers(partiallySelectedTreeItemWrappers, childTreeItemWrapper);
		}
	}

    public Collection<Object> getPartiallySelectedObjects() {
        return getPartiallySelectedTreeItemWrappers().stream().map(tiw -> tiw.getWrappedObject()).collect(toList());
    }
    
    /**
     * Dispose the created swt resources. {@inheritDoc}
     * 
     * @see org.eclipse.jface.dialogs.DialogPage#dispose()
     */
    @Override
    public void dispose() {

        defaultAdapterFactoryLabelProvider.dispose();

        if (pageComposite != null && !pageComposite.isDisposed()) {
            pageComposite.dispose();
        }

        super.dispose();
    }
    
    private class ISObjectSelectionChangedListener implements ISelectionChangedListener {

        @Override
        public void selectionChanged(final SelectionChangedEvent event) {
            if (!(event.getSelection() instanceof IStructuredSelection)) {
                selectedTreeItemWrapers.clear();
                return;
            }
            
        	ISObjectTreeItemWrapper selectedTreeItemWrapper = SelectionHelper.uwrapSingleSelection(event.getSelection(), ISObjectTreeItemWrapper.class);
        	if(selectedTreeItemWrapper != null) {
            	if(selectedTreeItemWrapers.contains(selectedTreeItemWrapper) || !selectedTreeItemWrapper.isSelectable()) {
            		selectedTreeItemWrapers.clear();
            		treeViewer.getTree().deselectAll();
            	} else {
            		selectedTreeItemWrapers.clear();
            		selectedTreeItemWrapers.add(selectedTreeItemWrapper);
            	}
        	}
        	
	        if(pageCompleteTester != null) {
	        	setPageComplete(pageCompleteTester.isPageComplete(getSelectedTreeItemWrappers(), getPartiallySelectedTreeItemWrappers()));
	        }
        }
    }
    
    public static interface ISObjectCustomLabelProvider {
    	 public String getText(Object wrappedObject);
    }

    private class ISObjectSelectionLabelProvider extends LabelProvider implements IColorProvider, IFontProvider {

        @Override
        public Image getImage(final Object element) {
            Image image = null;
            if (element instanceof ISObjectTreeItemWrapper) {
                Object wrappedObject = ((ISObjectTreeItemWrapper) element).getWrappedObject();
				image = defaultAdapterFactoryLabelProvider.getImage(wrappedObject);
            }
            return image;
        }

        @Override
        public String getText(final Object element) {
            String text = null;
            if (element instanceof ISObjectTreeItemWrapper) {
                Object wrappedObject = ((ISObjectTreeItemWrapper) element).getWrappedObject();
                if(customLabelProvider != null) {
                	text = customLabelProvider.getText(wrappedObject);
                }
                if(text == null || text.isEmpty()) {
    				text = defaultAdapterFactoryLabelProvider.getText(wrappedObject);
                }
            }
            return text;
        }

		@Override
		public Color getForeground(Object element) {
			if(alwaysSelectedTreeItemWrappers.contains(element)) {
				return treeViewer.getControl().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY);
			}
			return null;
		}

		@Override
		public Color getBackground(Object element) {
			return null;
		}

		@Override
		public Font getFont(Object element) {
			if(alwaysSelectedTreeItemWrappers.contains(element)) {
				Font defaultFont = treeViewer.getControl().getFont();
				FontData[] defaultFontData = defaultFont.getFontData();
				return SWTResourceManager.getFont(defaultFontData[0].getName(), defaultFontData[0].getHeight(), SWT.ITALIC);
			}
			return null;
		}
    }

    private static final Object[] EMPTY_ARRAY = {};
    private class ISTreeItemWrapperContentProvider extends ArrayContentProvider implements ITreeContentProvider {

        public Object getParent(final Object element) {
            return ((ISObjectTreeItemWrapper) element).getParent();
        }

        public Object[] getChildren(final Object parentElement) {
            if (parentElement instanceof ISObjectTreeItemWrapper) {
                return ((ISObjectTreeItemWrapper) parentElement).getChildren().toArray();
            }
            return EMPTY_ARRAY;
        }

        public boolean hasChildren(final Object element) {
            return ((ISObjectTreeItemWrapper) element).getChildren().size() > 0;
        }

        @Override
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
            // Nop
        }

        @Override
        public Object[] getElements(final Object inputElement) {
            if (inputElement instanceof ISObjectTreeItemWrapper) {
                return ((ISObjectTreeItemWrapper) inputElement).getChildren().toArray();
            }
            return super.getElements(inputElement);
        }
    }

    private class ISObjectSelectionFilter extends ViewerFilter {

        /**
         * The regular expression (for example '?a?' or 'abc' or '*c') ;
         * <code>null</code> or empty regular expression will be replaced by '*'
         */
        private String regExp;

        private TreeViewer treeViewer;
        
        private boolean filterActive = false;

        /**
         * Set a prefix to the filter.
         * 
         * @param newRegExp
         *            the new prefix to set
         */
        public void setPrefix(final String newRegExp) {
            this.regExp = newRegExp;
            if (treeViewer != null) {
                treeViewer.refresh();
            }
        }

        public void setFilterActive(boolean filterActive) {
        	this.filterActive = filterActive;
            if (treeViewer != null) {
                treeViewer.refresh();
            }
		}

		@Override
        public boolean select(final Viewer viewer, final Object parentElement, final Object element) {

            boolean selected = true;

            if (element instanceof ISObjectTreeItemWrapper) {
            	
            	ISObjectTreeItemWrapper treeItemWrapper = (ISObjectTreeItemWrapper) element;
            	
            	if(selectedTreeItemWrapers.contains(treeItemWrapper)) {
            		return true;
            	}
            	
                // Select parent if child should be selected
            	if(treeItemWrapper.getChildren().stream()
            			.anyMatch(child -> select(viewer, element, child))) {
            		return true;
            	}

            	if(!treeItemWrapper.isSelectable()) {
            		return false;
            	}
            	
                if(checkBoxFilter != null && filterActive) {
                	selected = !checkBoxFilter.filter(treeItemWrapper);
                }

                if (selected && regExp != null && !regExp.isEmpty() && treeViewer != null) {
                    String text = ((ILabelProvider) treeViewer.getLabelProvider()).getText(element);
                    if (text != null) {
                        selected = getStringMatcher().match(text);
                    }
                }
            }
            
            return selected;
        }

        public void setTreeViewer(final TreeViewer treeViewer) {
            this.treeViewer = treeViewer;
        }

        /**
         * Creates a new StringMatcher corresponding to the regExp.
         * 
         * @return a new StringMatcher
         */
        private StringMatcher getStringMatcher() {
            String computedRegExp = regExp;
            if (regExp == null) {
                computedRegExp = "";
            }
            // If the regular expression ends with a space, we have to use the exact
            // value of the given expreg
            if (computedRegExp.endsWith(" ")) {
                computedRegExp = computedRegExp.substring(0, computedRegExp.lastIndexOf(' '));
            }
            // At the end we add a star to make 'XYZ' recognized by the 'X'
            // expreg (as in quick outline for example)
            computedRegExp = computedRegExp + "*";

            return new StringMatcher(computedRegExp, true, false);
        }
    }
    
    private class ISObjectSelectionModifyAdapter implements ModifyListener {
        /**
         * {@inheritDoc}
         * 
         * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
         */
        public void modifyText(final ModifyEvent e) {
            viewerFilter.setPrefix(((Text) e.widget).getText());
        }
    }
    
	private boolean isPartiallySelected(ISObjectTreeItemWrapper treeItemWrapper) {
		switch(treeSelectMode) {
		case HIERARCHIC:
			return !ungrayedTreeItemWrapers.contains(treeItemWrapper) &&
					(treeItemWrapper.getAllSelectableTreeItemWrappers().stream().anyMatch(tiw -> selectedTreeItemWrapers.contains(tiw)) &&
							(!treeItemWrapper.isSelectable() || treeItemWrapper.getAllSelectableTreeItemWrappers().stream().anyMatch(tiw -> !selectedTreeItemWrapers.contains(tiw))));
		case PICK_ANY:
			return !selectedTreeItemWrapers.contains(treeItemWrapper) && treeItemWrapper.getAllSelectableTreeItemWrappers().stream().anyMatch(tiw -> selectedTreeItemWrapers.contains(tiw));
		}
		return false;
	}
	
    private class ISObjectSelectionCheckStateListener implements ICheckStateListener {

		@Override
		public void checkStateChanged(CheckStateChangedEvent event) {
			ISObjectTreeItemWrapper treeItemWrapper = (ISObjectTreeItemWrapper) event.getElement();
			
			if(isPartiallySelected(treeItemWrapper)) { // Element was grayed
				ungrayTreeItemWrapper(treeItemWrapper);
			} else if(selectedTreeItemWrapers.contains(treeItemWrapper)) { // Element was selected
				if(!alwaysSelectedTreeItemWrappers.contains(treeItemWrapper)) {
					deselectTreeItemWrapper(treeItemWrapper);
				}
			} else { // Element was unselected
				selectTreeItemWrapper(treeItemWrapper);
				if(selectionInductor != null) {
					selectionInductor.select(treeItemWrapper).forEach(induced -> selectTreeItemWrapper(induced));
				}
			}
			
	        if(pageCompleteTester != null) {
	        	setPageComplete(pageCompleteTester.isPageComplete(getSelectedTreeItemWrappers(), getPartiallySelectedTreeItemWrappers()));
	        }
	        
			treeViewer.refresh();
		}

		private void deselectTreeItemWrapper(ISObjectTreeItemWrapper treeItemWrapper) {
			switch(treeSelectMode) {
			case HIERARCHIC:
				if (!alwaysSelectedTreeItemWrappers.contains(treeItemWrapper)) {
					selectedTreeItemWrapers.remove(treeItemWrapper);
					if (selectedTreeItemWrapers.containsAll(treeItemWrapper.getChildren())) {
						selectedTreeItemWrapers.removeAll(treeItemWrapper.getAllSelectableTreeItemWrappers());
					}
				}
				treeItemWrapper.getAncestors().forEach(p -> {
					if(p.getChildren().stream().anyMatch(c -> !selectedTreeItemWrapers.contains(c))) {
						ungrayedTreeItemWrapers.remove(p);
					}
				});
				break;
			case PICK_ANY:
				if (!alwaysSelectedTreeItemWrappers.contains(treeItemWrapper)) {
					selectedTreeItemWrapers.remove(treeItemWrapper);
				}
				break;
			}
		}

		private void ungrayTreeItemWrapper(ISObjectTreeItemWrapper treeItemWrapper) {
			switch(treeSelectMode) {
			case HIERARCHIC:
				ungrayedTreeItemWrapers.add(treeItemWrapper);
				selectedTreeItemWrapers.remove(treeItemWrapper);
				break;
			case PICK_ANY:
				if(treeItemWrapper.isSelectable()) {
					selectedTreeItemWrapers.add(treeItemWrapper);
				}
				break;
			}
		}

		private void selectTreeItemWrapper(ISObjectTreeItemWrapper treeItemWrapper) {
			switch(treeSelectMode) {
			case HIERARCHIC:
				selectedTreeItemWrapers.addAll(treeItemWrapper.getAllSelectableTreeItemWrappers());
				ungrayedTreeItemWrapers.removeAll(treeItemWrapper.getAllTreeItemWrappers());
				List<ISObjectTreeItemWrapper> ancestors = treeItemWrapper.getAncestors();
				Collections.reverse(ancestors);
				ancestors.forEach(p -> {
					if(selectedTreeItemWrapers.containsAll(p.getChildren()) && p.isSelectable()) {
						selectedTreeItemWrapers.add(p);
						ungrayedTreeItemWrapers.remove(p);
					}
				});
				break;
			case PICK_ANY:
				if(treeItemWrapper.isSelectable()) {
					selectedTreeItemWrapers.add(treeItemWrapper);
				}
				break;
			}
		}

    }
    
    private class ISObjectSelectionCheckStateProvider implements ICheckStateProvider {

		@Override
		public boolean isChecked(Object element) {
			ISObjectTreeItemWrapper treeItemWrapper = (ISObjectTreeItemWrapper) element;
			return !ungrayedTreeItemWrapers.contains(treeItemWrapper) && 
					treeItemWrapper.getAllSelectableTreeItemWrappers().stream().anyMatch(tiw -> selectedTreeItemWrapers.contains(tiw));
		}

		@Override
		public boolean isGrayed(Object element) {
			ISObjectTreeItemWrapper treeItemWrapper = (ISObjectTreeItemWrapper) element;
			switch(treeSelectMode) {
			case HIERARCHIC:
				return !treeItemWrapper.isSelectable() || 
						treeItemWrapper.getAllSelectableTreeItemWrappers().stream().anyMatch(tiw -> !selectedTreeItemWrapers.contains(tiw));
			case PICK_ANY:
				return !selectedTreeItemWrapers.contains(treeItemWrapper);
			}
			return false;
		}
    	
    }

	public void setSelectionInductor(ISelectionInductor selectionInductor) {
		this.selectionInductor  = selectionInductor;
	}

	public void setPageCompleteTester(IPageCompleteTester pageCompleteTester) {
		this.pageCompleteTester  = pageCompleteTester;
	}

	public interface IPageCompleteTester {
		
		public boolean isPageComplete(Collection<ISObjectTreeItemWrapper> selectedTreeItemWrapers, Collection<ISObjectTreeItemWrapper> partiallySelectedTreeItemWrapers);

	}
	
	/**
	 * Implement this interface to specify a cascaded selection behavior for {@link ISObjectSelectionWizard}
	 */
	public interface ISelectionInductor {

		/**
		 * @param selected
		 * 
		 * @return The objects to select when the given object is selected.
		 */
		public List<ISObjectTreeItemWrapper> select(ISObjectTreeItemWrapper selected);
		
	}
	
	private Map<Object, List<ISObjectTreeItemWrapper>> treeItemWrapersMap = null;
	
	private List<ISObjectTreeItemWrapper> getTreeItemWrapperFromWrappedObject(Object object) {
		
		if(treeItemWrapersMap == null) {
			treeItemWrapersMap = new HashMap<>();
			initTreeItemWrapersMap(treeRoot);
		}
		
		return treeItemWrapersMap.get(object);
	}
	
	private void initTreeItemWrapersMap(ISObjectTreeItemWrapper treeItemWraper) {
		List<ISObjectTreeItemWrapper> treeItemWrapers = treeItemWrapersMap.get(treeItemWraper.getWrappedObject());
		if(treeItemWrapers == null) {
			treeItemWrapers = new ArrayList<>();
			treeItemWrapersMap.put(treeItemWraper.getWrappedObject(), treeItemWrapers);
		}
		
		if(!treeItemWrapers.contains(treeItemWraper)) {
			treeItemWrapers.add(treeItemWraper);
		}
		
		for(ISObjectTreeItemWrapper childTreeItemWrapper : treeItemWraper.getChildren()) {
			initTreeItemWrapersMap(childTreeItemWrapper);
		}
	}

	/**
	 * Helper class managing cascading selection from Objects rather than from {@link ISObjectTreeItemWrapper}s.
	 */
	public static abstract class ISObjectSelectionInductor implements ISelectionInductor {

		private ISObjectSelectionWizardPage page;

		public ISObjectSelectionInductor(ISObjectSelectionWizard wizard) {
			this.page = wizard.getPage();
		}

		@Override
		public List<ISObjectTreeItemWrapper> select(ISObjectTreeItemWrapper selected) {
			List<?> inducedSelectedObjects = selectObject(selected.getWrappedObject());
			List<ISObjectTreeItemWrapper> inducedSelectedTreeItemWrappers = new ArrayList<>();
			for(Object inducedSelectedObject : inducedSelectedObjects) {
				List<ISObjectTreeItemWrapper> treeItemWrappers = page.getTreeItemWrapperFromWrappedObject(inducedSelectedObject);
				if(treeItemWrappers != null) {
					inducedSelectedTreeItemWrappers.addAll(treeItemWrappers);
				}
			}
			return inducedSelectedTreeItemWrappers;
		}
		
		public abstract List<?> selectObject(Object selected);

	}
	
	public interface ICheckBoxFilter {
		
		public String getLabel();
		
		public boolean getDefaultCheckValue();
		
		/**
		 * @param element
		 * @return true if the element is filtered (i.e. hidden) when this filter is activated
		 */
		public boolean filter(ISObjectTreeItemWrapper element);
		
	}
	
	public static abstract class ISObjectCheckBoxFilter implements ICheckBoxFilter {
		
		private String label;
		private boolean defaultCheckValue = false;

		public ISObjectCheckBoxFilter(String label, boolean defaultCheckValue) {
			this.label = label;
			this.defaultCheckValue = defaultCheckValue;
		}

		@Override
		public String getLabel() {
			return label;
		}

		@Override
		public boolean getDefaultCheckValue() {
			return defaultCheckValue;
		}
		
	}

}
