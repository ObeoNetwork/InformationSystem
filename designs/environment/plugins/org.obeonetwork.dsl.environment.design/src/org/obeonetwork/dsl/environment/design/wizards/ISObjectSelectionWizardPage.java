/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
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
import org.eclipse.sirius.common.ui.tools.api.view.common.item.CommonItem;
import org.eclipse.sirius.common.ui.tools.api.view.common.item.ItemDecorator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;

public class ISObjectSelectionWizardPage extends AbstractSelectionWizardPage {

    private Composite pageComposite;

    private TreeItemWrapper treeRoot;

    private final AdapterFactoryLabelProvider myAdapterFactoryLabelProvider;

    private final List<EObject> selectedEObjects = new ArrayList<EObject>();

    private boolean many = false;
    
    private List<EObject> preSelection;

    private TreeViewer treeViewer;

	private ISObjectSelectionFilter viewerFilter;

    public ISObjectSelectionWizardPage(
    		String pageName, 
    		String title, 
    		ImageDescriptor imageTitle, 
    		TreeItemWrapper treeRoot, 
    		boolean many,
    		List<EObject> preSelection,
    		AdapterFactory factory) {
        super(pageName, title, imageTitle);
        this.myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(factory);
        this.treeRoot = treeRoot;
        this.preSelection = preSelection;
        this.many = many;
    }

    @Override
    public void createControl(final Composite parent) {
        initializeDialogUnits(parent);

        pageComposite = new Composite(parent, SWT.NONE);
        pageComposite.setLayout(new GridLayout());
        pageComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

        createSelectionGroup(pageComposite);
        
        treeViewer = createTreeViewer(pageComposite);
        treeViewer.setInput(this.treeRoot);

        viewerFilter.setTreeViewer(treeViewer);

        treeViewer.expandAll();
        
        initRootPrefix();
        
        if(!preSelection.isEmpty()) {
        	ArrayList<TreeItem> preSelectedItems = new ArrayList<>();
        	collectPreSelectedTreeItems(treeViewer.getTree().getItems(), preSelectedItems);
        	treeViewer.getTree().setSelection(preSelectedItems.toArray(new TreeItem[] {}));
        	selectedEObjects.addAll(preSelection);
        }
        
        treeViewer.refresh();
        
        setControl(pageComposite);
    }

    private void collectPreSelectedTreeItems(TreeItem[] items, List<TreeItem> preSelectedItems) {
		for(int i = 0; i < items.length; i++) {
			if(preSelection.contains(((TreeItemWrapper)items[i].getData()).getWrappedObject()) && ! preSelectedItems.contains(items[i])) {
				preSelectedItems.add(items[i]);
			}
			collectPreSelectedTreeItems(items[i].getItems(), preSelectedItems);
		}
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

    /**
     * Compute a common prefix for all items.
     */
    private void initRootPrefix() {
        String prefix = null;
        boolean again = true;

        final int count = this.treeViewer.getTree().getItemCount();

        for (int i = 0; i < count && again; i++) {
            final TreeItem treeItem = this.treeViewer.getTree().getItem(i);
            prefix = computeCommonPrefix(prefix, treeItem);
            if (prefix == null) {
                again = false;
            } else {
                prefix = computeChildrenPrefix(prefix, treeItem);
                if (prefix == null) {
                    again = false;
                }
            }

        }
        if (prefix != null) {
            this.elementsToSelectText.setText(prefix);
            this.elementsToSelectText.setSelection(prefix.length());
        }
    }

    private String computeChildrenPrefix(final String oldPrefix, final TreeItem parent) {
        String prefix = oldPrefix;
        boolean again = true;

        final int count = parent.getItemCount();

        for (int i = 0; i < count && again; i++) {
            final TreeItem treeItem = parent.getItem(i);
            prefix = computeCommonPrefix(prefix, treeItem);
            if (prefix == null) {
                again = false;
            } else {
                prefix = computeChildrenPrefix(prefix, treeItem);
                if (prefix == null) {
                    again = false;
                }
            }
        }
        return prefix;
    }

    private String computeCommonPrefix(final String oldPrefix, final TreeItem treeItem) {
        String prefix = oldPrefix;
        if (prefix == null) {
            // the prefix is equal to the first item (default)
            prefix = treeItem.getText();
        } else {
            if (!treeItem.getText().startsWith(prefix)) {
                // we must find a new prefix.
                int searchIndex = Math.min(prefix.length() - 1, treeItem.getText().length());
                String newPrefix = null;
                while (searchIndex > 0 && newPrefix == null) {
                    if (treeItem.getText().startsWith(prefix.substring(0, searchIndex))) {
                        newPrefix = prefix.substring(0, searchIndex);
                    } else {
                        searchIndex--;
                    }
                }
                if (newPrefix != null) {
                    prefix = newPrefix;
                } else {
                    // no common prefix found.
                    prefix = null;
                }
            }
        }
        return prefix;
    }

    /**
     * Get the selected EObject. If they are several objects selected, return the first.
     * 
     * @return the selected EObject
     */
    public EObject getSelectedEObject() {
        if (selectedEObjects.size() > 0) {
            return this.selectedEObjects.get(0);
        }
        return null;
    }

    /**
     * Get the selected {@link EObject}, if they are many.
     * 
     * @return the list of selected instances.
     */
    public List<EObject> getSelectedEObjects() {
        return this.selectedEObjects;

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
                selectedEObjects.clear();
                return;
            }
            
            final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
            if (selection.size() > 0) {
            	TreeItemWrapper selectedTreeItemWrapper = (TreeItemWrapper) selection.toList().iterator().next();
            	EObject selectedElement = (EObject) selectedTreeItemWrapper.getWrappedObject();
            	if(selectedEObjects.contains(selectedElement) || !selectedTreeItemWrapper.isSelectable()) {
            		selectedEObjects.clear();
            		treeViewer.getTree().deselectAll();
            	} else {
            		selectedEObjects.clear();
            		selectedEObjects.add(selectedElement);
            	}
                return;
            }
        }
    }

    private class ISObjectSelectionLabelProvider extends LabelProvider {

        @Override
        public Image getImage(final Object element) {
            Image result = null;
            if (element instanceof TreeItemWrapper) {
                result = myAdapterFactoryLabelProvider.getImage(((TreeItemWrapper) element).getWrappedObject());
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
            if (element instanceof TreeItemWrapper) {
                result = myAdapterFactoryLabelProvider.getText(((TreeItemWrapper) element).getWrappedObject());
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
            return ((TreeItemWrapper) element).getParent();
        }

        public Object[] getChildren(final Object parentElement) {
            if (parentElement instanceof TreeItemWrapper) {
                return ((TreeItemWrapper) parentElement).getChildren().toArray();
            }
            return EMPTY_ARRAY;
        }

        public boolean hasChildren(final Object element) {
            return ((TreeItemWrapper) element).getChildren().size() > 0;
        }

        @Override
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
            // Nop
        }

        @Override
        public Object[] getElements(final Object inputElement) {
            if (inputElement instanceof TreeItemWrapper) {
                return ((TreeItemWrapper) inputElement).getChildren().toArray();
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

        @Override
        public boolean select(final Viewer viewer, final Object parentElement, final Object element) {

            boolean selected = false;
            Object element2 = null;

            if (element instanceof TreeItemWrapper) {

                /* select parent if child should be selected */
                for (final TreeItemWrapper childItem : ((TreeItemWrapper) element).getChildren()) {
                    if (select(viewer, element, childItem)) {
                        return true;
                    }
                }

                element2 = ((TreeItemWrapper) element).getWrappedObject();

            } else {
                element2 = element;
            }

            if (element2 instanceof EObject || element2 instanceof CommonItem) {
                if (regExp == null || regExp.length() == 0) {
                    selected = true;
                }

                if (treeViewer != null) {
                    final String text = ((ILabelProvider) treeViewer.getLabelProvider()).getText(element2);
                    if (!selected && text != null && getStringMatcher().match(text)) {
                        selected = true;
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
                computedRegExp = ""; //$NON-NLS-1$
            }
            // If the regular expression ends with a space, we have to use the exact
            // value of the given expreg
            if (computedRegExp.endsWith(" ")) { //$NON-NLS-1$
                computedRegExp = computedRegExp.substring(0, computedRegExp.lastIndexOf(' '));
            }
            // At the end we add a star to make 'XYZ' recognized by the 'X'
            // expreg (as in quick outline for example)
            computedRegExp = computedRegExp + "*"; //$NON-NLS-1$

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
    
    private class ISObjectSelectionCheckStateListener implements ICheckStateListener {

		@Override
		public void checkStateChanged(CheckStateChangedEvent event) {
			TreeItemWrapper treeItemWrapper = (TreeItemWrapper) event.getElement();
			if(event.getChecked()) {
				selectedEObjects.addAll(treeItemWrapper.getAllSelectableWrappedEObjects());
			} else {
				selectedEObjects.removeAll(treeItemWrapper.getAllSelectableWrappedEObjects());
			}
			
			treeViewer.refresh();
		}
    	
    }
    
    private class ISObjectSelectionCheckStateProvider implements ICheckStateProvider {

		@Override
		public boolean isChecked(Object element) {
			TreeItemWrapper treeItemWrapper = (TreeItemWrapper) element;
			return treeItemWrapper.getAllSelectableWrappedEObjects().stream()
					.anyMatch(o -> selectedEObjects.contains(o));
		}

		@Override
		public boolean isGrayed(Object element) {
			TreeItemWrapper treeItemWrapper = (TreeItemWrapper) element;
			return !treeItemWrapper.isSelectable();
		}
    	
    }
}
