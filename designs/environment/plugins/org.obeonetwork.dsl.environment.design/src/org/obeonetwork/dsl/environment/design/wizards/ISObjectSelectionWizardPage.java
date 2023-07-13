/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.sirius.common.tools.api.util.StringMatcher;
import org.eclipse.sirius.common.ui.tools.api.selection.page.AbstractSelectionWizardPage;
import org.eclipse.sirius.common.ui.tools.api.util.SWTUtil;
import org.eclipse.sirius.common.ui.tools.api.view.common.item.ItemDecorator;
import org.eclipse.sirius.diagram.ui.provider.DiagramUIPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.obeonetwork.utils.common.ui.handlers.SelectionHelper;

public class ISObjectSelectionWizardPage extends AbstractSelectionWizardPage {

    private Composite pageComposite;

    private EObjectTreeItemWrapper treeRoot;

    private final AdapterFactoryLabelProvider myAdapterFactoryLabelProvider;

    private Set<EObjectTreeItemWrapper> selectedTreeItemWrapers = new HashSet<>();

    private Set<EObjectTreeItemWrapper> ungrayedTreeItemWrapers = new HashSet<>();
    
    private Collection<EObjectTreeItemWrapper> preSelectedTreeItemWrappers = Collections.emptyList();
    
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
    		EObjectTreeItemWrapper treeRoot, 
    		boolean many) {
        super(pageName, title, imageTitle);
        this.treeRoot = treeRoot;
        this.many = many;
        this.myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(DiagramUIPlugin.getPlugin().getItemProvidersAdapterFactory());
    }

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
	
    @Override
    public void createControl(final Composite parent) {
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
        			.map(EObjectTreeItemWrapper.class::cast)
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
			if(preSelectedTreeItemWrappers.contains((EObjectTreeItemWrapper)items[i].getData()) && ! preSelectedItems.contains(items[i])) {
				preSelectedItems.add(items[i]);
			}
			collectPreSelectedTreeItems(preSelectedItems, items[i].getItems());
		}
	}

	public void setPreSelectedEObjects(Collection<EObject> preSelectedEObjects) {
		preSelectedTreeItemWrappers = new HashSet<>();
		collectPreSelectedTreeItemWrappers(preSelectedEObjects, treeRoot);
	}

	private void collectPreSelectedTreeItemWrappers(Collection<EObject> preSelectedEObjects, EObjectTreeItemWrapper treeItemWrapper) {
		if(preSelectedEObjects.contains(treeItemWrapper.getWrappedEObject())) {
			preSelectedTreeItemWrappers.add(treeItemWrapper);
		}
		for(EObjectTreeItemWrapper childTreeItemWrapper : treeItemWrapper.getChildren()) {
			collectPreSelectedTreeItemWrappers(preSelectedEObjects, childTreeItemWrapper);
		}
	}

	public void setPreSelectedTreeItemWrappers(Collection<EObjectTreeItemWrapper> preSelectedTreeItemWrappers) {
		this.preSelectedTreeItemWrappers = preSelectedTreeItemWrappers;
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
        viewer.setComparator(new ViewerComparator());
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

    public EObjectTreeItemWrapper getSelectedTreeItemWrapper() {
        return selectedTreeItemWrapers.stream().findFirst().orElse(null);
    }
    
    /**
     * Get the selected EObject. If several objects are selected, return any one of them.
     * 
     * @return the selected EObject
     */
    public EObject getSelectedEObject() {
        return Optional.ofNullable(getSelectedTreeItemWrapper()).map(tiw -> tiw.getWrappedEObject()).orElse(null);
    }

    public Collection<EObjectTreeItemWrapper> getSelectedTreeItemWrappers() {
        return selectedTreeItemWrapers;
    }
    
    /**
     * Get the selected {@link EObject}s.
     * 
     * @return the list of selected instances.
     */
    public Collection<EObject> getSelectedEObjects() {
        return getSelectedTreeItemWrappers().stream().map(tiw -> tiw.getWrappedEObject()).collect(toList());
    }

    public Collection<EObjectTreeItemWrapper> getPartiallySelectedTreeItemWrappers() {
    	List<EObjectTreeItemWrapper> partiallySelectedTreeItemWrappers = new ArrayList<>();
    	collectPartiallySelectedTreeItemWrappers(partiallySelectedTreeItemWrappers, treeRoot);
        return partiallySelectedTreeItemWrappers;
    }
    
	private void collectPartiallySelectedTreeItemWrappers(List<EObjectTreeItemWrapper> partiallySelectedTreeItemWrappers, EObjectTreeItemWrapper treeItemWrapper) {
		if(treeItemWrapper.getWrappedEObject() != null && isPartiallySelected(treeItemWrapper)) {
			partiallySelectedTreeItemWrappers.add(treeItemWrapper);
		}
		for(EObjectTreeItemWrapper childTreeItemWrapper : treeItemWrapper.getChildren()) {
			collectPartiallySelectedTreeItemWrappers(partiallySelectedTreeItemWrappers, childTreeItemWrapper);
		}
	}

    public Collection<EObject> getPartiallySelectedEObjects() {
        return getPartiallySelectedTreeItemWrappers().stream().map(tiw -> tiw.getWrappedEObject()).collect(toList());
    }
    
    /**
     * Dispose the created swt resources. {@inheritDoc}
     * 
     * @see org.eclipse.jface.dialogs.DialogPage#dispose()
     */
    @Override
    public void dispose() {

        myAdapterFactoryLabelProvider.dispose();

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
            
        	EObjectTreeItemWrapper selectedTreeItemWrapper = SelectionHelper.uwrapSingleSelection(event.getSelection(), EObjectTreeItemWrapper.class);
        	if(selectedTreeItemWrapper != null) {
            	if(selectedTreeItemWrapers.contains(selectedTreeItemWrapper) || !selectedTreeItemWrapper.isSelectable()) {
            		selectedTreeItemWrapers.clear();
            		treeViewer.getTree().deselectAll();
            	} else {
            		selectedTreeItemWrapers.clear();
            		selectedTreeItemWrapers.add(selectedTreeItemWrapper);
            	}
        	}
        }
    }

    private class ISObjectSelectionLabelProvider extends LabelProvider {

        @Override
        public Image getImage(final Object element) {
            Image result = null;
            if (element instanceof EObjectTreeItemWrapper) {
                result = myAdapterFactoryLabelProvider.getImage(((EObjectTreeItemWrapper) element).getWrappedEObject());
            } else if (element instanceof ItemDecorator) {
                result = ((ItemDecorator) element).getImage();
            } else {
                result = myAdapterFactoryLabelProvider.getImage(element);
            }
            return result;
        }

        @Override
        public String getText(final Object element) {
            String result = null;
            if (element instanceof EObjectTreeItemWrapper) {
                result = myAdapterFactoryLabelProvider.getText(((EObjectTreeItemWrapper) element).getWrappedEObject());
            } else if (element instanceof ItemDecorator) {
                result = ((ItemDecorator) element).getText();
            } else {
                result = myAdapterFactoryLabelProvider.getText(element);
            }
            return result;
        }
    }

    private static final Object[] EMPTY_ARRAY = {};
    private class ISTreeItemWrapperContentProvider extends ArrayContentProvider implements ITreeContentProvider {

        public Object getParent(final Object element) {
            return ((EObjectTreeItemWrapper) element).getParent();
        }

        public Object[] getChildren(final Object parentElement) {
            if (parentElement instanceof EObjectTreeItemWrapper) {
                return ((EObjectTreeItemWrapper) parentElement).getChildren().toArray();
            }
            return EMPTY_ARRAY;
        }

        public boolean hasChildren(final Object element) {
            return ((EObjectTreeItemWrapper) element).getChildren().size() > 0;
        }

        @Override
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
            // Nop
        }

        @Override
        public Object[] getElements(final Object inputElement) {
            if (inputElement instanceof EObjectTreeItemWrapper) {
                return ((EObjectTreeItemWrapper) inputElement).getChildren().toArray();
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
            EObject eObject = null;

            if (element instanceof EObjectTreeItemWrapper) {
            	
            	EObjectTreeItemWrapper treeItemWrapper = (EObjectTreeItemWrapper) element;
            	
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
            	
                eObject = ((EObjectTreeItemWrapper) element).getWrappedEObject();

                if(checkBoxFilter != null && filterActive) {
                	selected = !checkBoxFilter.filter(treeItemWrapper);
                }

                if (selected && regExp != null && !regExp.isEmpty() && treeViewer != null) {
                    String text = ((ILabelProvider) treeViewer.getLabelProvider()).getText(eObject);
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
    
	private boolean isPartiallySelected(EObjectTreeItemWrapper treeItemWrapper) {
		switch(treeSelectMode) {
		case HIERARCHIC:
			return !ungrayedTreeItemWrapers.contains(treeItemWrapper) &&
					(treeItemWrapper.getAllSelectableTreeItemWrappers().stream().anyMatch(tiw -> selectedTreeItemWrapers.contains(tiw)) &&
							(!treeItemWrapper.isSelectable() || treeItemWrapper.getAllSelectableTreeItemWrappers().stream().anyMatch(tiw -> !selectedTreeItemWrapers.contains(tiw))));
		case PICK_ANY:
			return treeItemWrapper.getAllSelectableTreeItemWrappers().stream().anyMatch(tiw -> selectedTreeItemWrapers.contains(tiw));
		}
		return false;
	}
	
    private class ISObjectSelectionCheckStateListener implements ICheckStateListener {

		@Override
		public void checkStateChanged(CheckStateChangedEvent event) {
			EObjectTreeItemWrapper treeItemWrapper = (EObjectTreeItemWrapper) event.getElement();
			
			if(isPartiallySelected(treeItemWrapper)) { // Element was grayed
				ungrayTreeItemWrapper(treeItemWrapper);
			} else if(selectedTreeItemWrapers.contains(treeItemWrapper)) { // Element was selected
				deselectTreeItemWrapper(treeItemWrapper);
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

		private void deselectTreeItemWrapper(EObjectTreeItemWrapper treeItemWrapper) {
			switch(treeSelectMode) {
			case HIERARCHIC:
				selectedTreeItemWrapers.remove(treeItemWrapper);
				if(selectedTreeItemWrapers.containsAll(treeItemWrapper.getChildren())) {
					selectedTreeItemWrapers.removeAll(treeItemWrapper.getAllSelectableTreeItemWrappers());
				}
				treeItemWrapper.getAncestors().forEach(p -> {
					if(p.getChildren().stream().anyMatch(c -> !selectedTreeItemWrapers.contains(c))) {
						ungrayedTreeItemWrapers.remove(p);
					}
				});
				break;
			case PICK_ANY:
				selectedTreeItemWrapers.remove(treeItemWrapper);
				break;
			}
		}

		private void ungrayTreeItemWrapper(EObjectTreeItemWrapper treeItemWrapper) {
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

		private void selectTreeItemWrapper(EObjectTreeItemWrapper treeItemWrapper) {
			switch(treeSelectMode) {
			case HIERARCHIC:
				selectedTreeItemWrapers.addAll(treeItemWrapper.getAllSelectableTreeItemWrappers());
				ungrayedTreeItemWrapers.removeAll(treeItemWrapper.getAllTreeItemWrappers());
				treeItemWrapper.getAncestors().forEach(p -> {
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
			EObjectTreeItemWrapper treeItemWrapper = (EObjectTreeItemWrapper) element;
			return !ungrayedTreeItemWrapers.contains(treeItemWrapper) && 
					treeItemWrapper.getAllSelectableTreeItemWrappers().stream().anyMatch(tiw -> selectedTreeItemWrapers.contains(tiw));
		}

		@Override
		public boolean isGrayed(Object element) {
			EObjectTreeItemWrapper treeItemWrapper = (EObjectTreeItemWrapper) element;
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
		
		public boolean isPageComplete(Collection<EObjectTreeItemWrapper> selectedTreeItemWrapers, Collection<EObjectTreeItemWrapper> partiallySelectedTreeItemWrapers);

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
		public List<EObjectTreeItemWrapper> select(EObjectTreeItemWrapper selected);
		
	}
	
	public interface ICheckBoxFilter {
		
		public String getLabel();
		
		public boolean getDefaultCheckValue();
		
		/**
		 * @param element
		 * @return true if the element is filtered (i.e. hidden) when this filter is activated
		 */
		public boolean filter(EObjectTreeItemWrapper element);
		
	}
	
}
