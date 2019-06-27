/*******************************************************************************
 * Copyright (c) 2019 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.design.reference.custom;

import java.util.List;
import java.util.function.Function;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.eef.core.api.EditingContextAdapter;
import org.eclipse.eef.ide.ui.ext.widgets.reference.internal.Messages;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.ext.emf.edit.EditingDomainServices;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.PatternFilter;

@SuppressWarnings("restriction")
public class CustomEEFExtEObjectSelectionPage extends WizardPage {

	private static final String INVALID_SELECTION_IN_TREEVIEWER_ERROR_MESSAGE = "La sélection doit être du type attendu.";
	private static final String NO_SELECTION_IN_TREEVIEWER_ERROR_MESSAGE = "Nécessite une valeur.";

	private final class TreeViewerPatternFilter extends PatternFilter {
		private boolean isLeaf(Object element){
			if (eClassifier.isInstance(element)) {
				return true;
			}
			if (element instanceof EObject) {
				return ((EObject) element).eContents().isEmpty();
			}
			
			return false;
		}

		@Override
		protected boolean isLeafMatch(Viewer viewer, Object element) {
			return choiceOfValues.contains(element) && super.isLeafMatch(viewer, element);
		}
		
		@Override
		public boolean isElementVisible(Viewer viewer, Object element) {
			if (isLeaf(element)) {
				return isLeafMatch(viewer, element);
			} else {
				StructuredViewer sviewer = (StructuredViewer) viewer;
				ITreeContentProvider provider = (ITreeContentProvider) sviewer.getContentProvider();
				for (Object child: provider.getChildren(element)){
					if (select(viewer, element, child))
						return true;
				}
				return false;
			}
		}
	}

	private EObject target;
	private EReference eReference;
	private ComposedAdapterFactory composedAdapterFactory;
	private TreeViewer eReferenceTreeViewer;
	private EditingDomainServices editingDomainServices;
	private ISelectionChangedListener eReferenceTreeViewerListener;
	private EClassifier eClassifier;
	private Text text;
	private List<?> choiceOfValues;

	public CustomEEFExtEObjectSelectionPage(EObject target, EReference eReference,
			EditingContextAdapter editingContextAdapter) {
		super(Messages.ReferenceSelectionWizardPage_title);
		this.target = target;
		this.eReference = eReference;
		this.eClassifier = this.eReference.getEType();
		this.editingDomainServices = new EditingDomainServices();
		this.choiceOfValues = this.editingDomainServices.getPropertyDescriptorChoiceOfValues(target, eReference.getName());
		
		this.setTitle(Messages.ReferenceSelectionWizardPage_title);
		this.setDescription(Messages.ReferenceSelectionWizardPage_description);
	}

	@Override
	public void createControl(Composite parent) {
		this.initializeDialogUnits(parent);
		
		Composite control = new Composite(parent, SWT.NONE);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.setControl(control);

		GridLayout gridLayout = new GridLayout(2, false);
		control.setLayout(gridLayout);

		this.composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		this.composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		this.createTreeViewer(control);
		this.initializeInput();

		this.determinePageCompletion();
	}
	
	private void initializeInput() {
		Object initialValue = this.target.eGet(this.eReference);
		this.eReferenceTreeViewer.setInput(this.target.eResource().getResourceSet());
		if (initialValue != null) {
			this.eReferenceTreeViewer.setSelection(new StructuredSelection(initialValue));
		}
		TreeItem[] items = this.eReferenceTreeViewer.getTree().getItems();
		if (items.length == 1) {
			eReferenceTreeViewer.expandToLevel(target.eResource().getResourceSet(), AbstractTreeViewer.ALL_LEVELS, true);
		}
	}
	
	private void createTreeViewer(Composite control) {
		Label label = new Label(control, SWT.NONE);
		label.setText(Messages.ReferenceCreationWizardPage_eClassToCreateLabel);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		
		PatternFilter patternFilter = new TreeViewerPatternFilter();
		
		// The following setPattern is used to activate the pattern filter event if the text field is empty
		// We need it because our PatternFilter also filters by the type of the element about to be displayed.
		patternFilter.setPattern("org.eclipse.ui.keys.optimization.false");
		patternFilter.setIncludeLeadingWildcard(true);
		
		text = new Text(control, SWT.BORDER);
	    text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	    text.addModifyListener(new ModifyListener() {
	        
	        @Override
	        public void modifyText(ModifyEvent e) {
	        	String textField = text.getText();
				patternFilter.setPattern(textField);
	        	eReferenceTreeViewer.refresh();
	        	if (textField.isEmpty()) {
	        		Object initialValue = target.eGet(eReference);
	        		if (initialValue != null) {
	        			eReferenceTreeViewer.setSelection(new StructuredSelection(initialValue));
	        		}
	        	} else {
	        		eReferenceTreeViewer.expandToLevel(target.eResource().getResourceSet(), AbstractTreeViewer.ALL_LEVELS, true);
	        	}
	        }
	    });
		
		this.eReferenceTreeViewer = new TreeViewer(control, SWT.BORDER);
		this.eReferenceTreeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(this.composedAdapterFactory);
		this.eReferenceTreeViewer.setLabelProvider(labelProvider);
		this.eReferenceTreeViewer.setContentProvider(new AdapterFactoryContentProvider(this.composedAdapterFactory));
		this.eReferenceTreeViewer.setFilters(patternFilter);
		
		this.eReferenceTreeViewerListener = new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				CustomEEFExtEObjectSelectionPage.this.determinePageCompletion();
			}
		};
		this.eReferenceTreeViewer.addSelectionChangedListener(this.eReferenceTreeViewerListener);
	}

	private void determinePageCompletion() {
		this.setMessage(null);
		boolean isPageComplete = this.isCompleteViewer(true, this.eReferenceTreeViewer, NO_SELECTION_IN_TREEVIEWER_ERROR_MESSAGE, (viewer) -> this.getEObject(viewer) != null);
		isPageComplete = this.isCompleteViewer(isPageComplete, this.eReferenceTreeViewer, INVALID_SELECTION_IN_TREEVIEWER_ERROR_MESSAGE, (viewer) -> this.eReference.getEType().isInstance(this.getEObject(viewer)));
		this.setPageComplete(isPageComplete);
	}

	/**
	 * Verifies if the given viewer is complete and if not, set the given error message.
	 * @param <T>
	 *
	 * @param isCurrentlyComplete
	 *            The currently completion status
	 * @param viewer
	 *            The viewer
	 * @param errorMessage
	 *            The error message
	 * @return <code>true</code> if the wizard is currently complete and the viewer too, <code>false</code> otherwise
	 */
	private boolean isCompleteViewer(boolean isCurrentlyComplete, TreeViewer viewer, String errorMessage, Function<TreeViewer, Boolean> func) {
		boolean isComplete = isCurrentlyComplete;
		if (isCurrentlyComplete) {
			boolean isViewerComplete = func.apply(viewer);
			isComplete = isComplete && isViewerComplete;

			if (!isViewerComplete) {
				this.setMessage(errorMessage, ERROR);
			}
		}
		return isComplete;
	}

	/**
	 * Sets the value of the reference to the selected object.
	 *
	 * @param monitor
	 *            The progress monitor
	 */
	public void performFinish(IProgressMonitor monitor) {
		EObject eObject = this.getEObject(this.eReferenceTreeViewer);
		if (eObject != null) {
			Object object = this.target.eGet(this.eReference);
			if (!eObject.equals(object)) {
				this.target.eSet(this.eReference, eObject);
			}
		}
	}
	
	/**
	 * Returns the currently selected EObject in the given viewer.
	 *
	 * @param viewer
	 *            The viewer
	 *
	 * @return The currently selected EObject in the given viewer, or <code>null</code> if the current selection is
	 *         empty or not an EObject (for example an EResource)
	 */
	private EObject getEObject(StructuredViewer viewer) {
		ISelection selection = viewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object object = structuredSelection.getFirstElement();
			if (object instanceof EObject) {
				return (EObject) object;
			}
		}
		return null;
	}
}
