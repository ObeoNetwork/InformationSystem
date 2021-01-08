/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.binding.dialect.ui.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.sirius.business.api.dialect.command.RefreshRepresentationsCommand;
import org.eclipse.sirius.business.api.preferences.SiriusPreferencesKeys;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionStatus;
import org.eclipse.sirius.common.ui.SiriusTransPlugin;
import org.eclipse.sirius.ecore.extender.business.api.accessor.ModelAccessor;
import org.eclipse.sirius.ui.business.api.dialect.DefaultDialectEditorDialogFactory;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditorDialogFactory;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionEditorInput;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.SiriusPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.ISaveablePart2;
import org.eclipse.ui.ISaveablesSource;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.obeonetwork.dsl.environment.BindingInfo;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.binding.dialect.ui.editor.undoredo.UndoRedoActionHandler;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.BindingTreeMapper;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.BindingTreeSemanticSupport;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.TreeRoot;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.commands.CreateMappingsCommand;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider.TreeDataProvider;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEdge;
import org.obeonetwork.dsl.environment.bindingdialect.DBindingEditor;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;

/**
 * @author sthibaudeau
 *
 */
public class BindingTreeEditor extends EditorPart implements DialectEditor, SessionListener, IPageListener {

	public static final String ID = "org.obeonetwork.dsl.environment.binding.dialect.ui.editor.BindingTreeEditor"; //$NON-NLS-1$

	private DBindingEditor bindingEditorRepresentation;
	private BindingTreeEditorManager editorManager;
	private Session session;
	protected ModelAccessor accessor;
	protected DialectEditorDialogFactory myDialogFactory = new DefaultDialectEditorDialogFactory();

	private SashForm sashForm;
	private BindingTreeMapper treeMapper;
	private ScrolledComposite scrolledComposite;
	private Composite mappingDetails;
	private BindingGroupDetails grpDetailsLTR;
	private BindingGroupDetails grpDetailsRTL;
	private boolean closing = false;

	/**
	 * The {@link UndoRedoActionHandler} used to provide appropriate undo and
	 * redo Action Handlers to this editor.
	 */
	protected UndoRedoActionHandler undoRedoActionHandler;

	public BindingTreeEditor() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		setUpUndoRedoActionHandler();

		sashForm = new SashForm(parent, SWT.VERTICAL);
		sashForm.setSashWidth(3);

		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		editorManager = new BindingTreeEditorManager(getEditingDomain(), accessor);
		BindingTreeSemanticSupport treeSemanticSupport = new BindingTreeSemanticSupport(getBindingInfo(), editorManager);
		treeMapper = new BindingTreeMapper(sashForm, treeSemanticSupport);
		getSite().setSelectionProvider(treeMapper);
		treeMapper.getLeftTreeViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof StructuredSelection) {
					StructuredSelection strSelection = (StructuredSelection)event.getSelection();
					@SuppressWarnings("unchecked")
					Collection<DBoundElement> selectedElements = (Collection<DBoundElement>)strSelection.toList();
					populateLTRMappingDetails(selectedElements);
				}
			}
		});
		treeMapper.getRightTreeViewer().addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof StructuredSelection) {
					StructuredSelection strSelection = (StructuredSelection)event.getSelection();
					@SuppressWarnings("unchecked")
					Collection<DBoundElement> selectedElements = (Collection<DBoundElement>)strSelection.toList();
					populateRTLMappingDetails(selectedElements);
				}
			}
		});

		TreeDataProvider treeDataProvider = new TreeDataProvider(getBindingInfo());
		DBoundElement left = treeDataProvider.getLeftRoot();
		DBoundElement right = treeDataProvider.getRightRoot();
		List<DBindingEdge> edges = treeDataProvider.getEdges();

		treeMapper.setInput(new TreeRoot(left), new TreeRoot(right), edges);

		createBindingGroupDetails(sashForm);
		grpDetailsLTR.setText(getBindingDetailsLabel(left, right));
		grpDetailsRTL.setText(getBindingDetailsLabel(right, left));

		sashForm.setWeights(new int[] {70,30});

		// Expand the first levels on the two trees
		treeMapper.getLeftTreeViewer().expandToLevel(2);
		treeMapper.getRightTreeViewer().expandToLevel(2);

		revealBoundElements(edges);
	}

	private void createBindingGroupDetails(Composite parent) {
		Composite bottom = new Composite(parent, SWT.NONE);
		bottom.setLayout(new GridLayout(1, false));

		Button autoBindBtn = new Button(bottom, SWT.NONE);
		autoBindBtn.setText("Auto bind !");
		autoBindBtn.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		autoBindBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				autoBind();
			}
		});

		scrolledComposite = new ScrolledComposite(bottom, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		mappingDetails = new Composite(scrolledComposite, SWT.NONE);
		FormLayout fl_mappingDetails = new FormLayout();
		fl_mappingDetails.marginWidth = 10;
		fl_mappingDetails.marginHeight = 5;
		mappingDetails.setLayout(fl_mappingDetails);

		createLTRBindingGroupDetails(mappingDetails);
		createRTLBindingGroupDetails(mappingDetails);

		scrolledComposite.setContent(mappingDetails);
		scrolledComposite.setMinSize(mappingDetails.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	private void createLTRBindingGroupDetails(Composite parent) {
		grpDetailsLTR = new BindingGroupDetails(parent, null, editorManager);
	}

	private void createRTLBindingGroupDetails(Composite parent) {
		grpDetailsRTL = new BindingGroupDetails(parent, grpDetailsLTR.getGroup(), editorManager);
	}

	private void autoBind() {
		TreeRoot leftRoot = (TreeRoot)treeMapper.getLeftTreeViewer().getInput();
		DBoundElement leftRootElement = leftRoot.getElement();

		TreeRoot rightRoot = (TreeRoot)treeMapper.getRightTreeViewer().getInput();
		DBoundElement rightRootElement = rightRoot.getElement();

		// collect candidates to auto bind
		List<DBoundElement> leftCandidates = new ArrayList<DBoundElement>();
		for (DBoundElement leftItem : leftRootElement.getChildren()) {
			if (leftItem.getEdgesAsLeft().isEmpty()) {
				leftCandidates.add(leftItem);
			}
		}
		List<DBoundElement> rightCandidates = new ArrayList<DBoundElement>();
		for (DBoundElement rightItem : rightRootElement.getChildren()) {
			if (rightItem.getEdgesAsRight().isEmpty()) {
				rightCandidates.add(rightItem);
			}
		}

		List<DBoundElement> leftElementsToBind = new ArrayList<DBoundElement>();
		List<DBoundElement> rightElementsToBind = new ArrayList<DBoundElement>();
		while (leftCandidates.isEmpty() == false && rightCandidates.isEmpty() == false) {
			DBoundElement left = leftCandidates.remove(0);
			for (DBoundElement right : rightCandidates) {
				if (getPropertyLabel(left.getTarget()).equals(getPropertyLabel(right.getTarget()))) {
					leftElementsToBind.add(left);
					rightElementsToBind.add(right);
					rightCandidates.remove(right);
					break;
				}
			}
		}
		if (leftElementsToBind.size() > 0) {
			editorManager.execute(new CreateMappingsCommand(getEditingDomain(), getBindingInfo(), leftElementsToBind, rightElementsToBind));
			doRefresh();
		}
	}

	private String getPropertyLabel(EObject property) {
		String label = "";
		if (property instanceof Property) {
			label = ((Property)property).getName();
		}
		return label;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorPart#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);

		if (input instanceof SessionEditorInput) {
			final URI uri = ((SessionEditorInput) input).getURI();
			this.session = ((SessionEditorInput) input).getSession();
			setBindingEditorRepresentation(getBindingEditorRepresentation(uri, false));
		}

		if (session != null) {
			session.addListener(this);
		}

		final IEditingSession uiSession = SessionUIManager.INSTANCE.getOrCreateUISession(this.session);
		uiSession.open();
		uiSession.attachEditor(this);
		setAccessor(SiriusPlugin.getDefault().getModelAccessorRegistry().getModelAccessor(getBindingEditorRepresentation()));

		/*
		 * let's activate the model listening
		 */
		//		final DTreeElementSynchronizer sync = new DTreeElementSynchronizerSpec(accessor, getInterpreter());
		//		getTreeModel().activate(sync);
		/* Update title. Semantic tree could have been renamed */
		notify(PROP_TITLE);
	}

	/**
	 * @param accessor the accessor to set
	 */
	private void setAccessor(final ModelAccessor accessor) {
		this.accessor = accessor;
	}

	private void populateLTRMappingDetails(Collection<DBoundElement> elements) {
		grpDetailsLTR.setBoundElements(new LinkedHashSet<DBoundElement>(elements));
		mappingDetails.layout(true);
		scrolledComposite.setMinSize(mappingDetails.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	private void populateRTLMappingDetails(Collection<DBoundElement> elements) {
		grpDetailsRTL.setBoundElements(new LinkedHashSet<DBoundElement>(elements));
		mappingDetails.layout(true);
		scrolledComposite.setMinSize(mappingDetails.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	}

	/**
	 * Closes this editor
	 * 
	 * @param save indicates whether the modifications should be saved or not
	 */
	public void close(final boolean save) {
		Display display = getSite().getShell().getDisplay();
		display.asyncExec(new Runnable() {
			public void run() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(BindingTreeEditor.this, save);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.ide.IGotoMarker#gotoMarker(org.eclipse.core.resources.IMarker)
	 */
	public void gotoMarker(IMarker marker) {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.domain.IEditingDomainProvider#getEditingDomain()
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return session.getTransactionalEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.ui.business.api.dialect.DialectEditor#getRepresentation()
	 */
	public DRepresentation getRepresentation() {
		return getBindingEditorRepresentation();
	}

	public DBindingEditor getBindingEditorRepresentation() {
		return bindingEditorRepresentation;
	}

	private void setBindingEditorRepresentation(DBindingEditor bindingEditorRepresentation) {
		this.bindingEditorRepresentation = bindingEditorRepresentation;
	}

	private DBindingEditor getBindingEditorRepresentation(final URI uri, final boolean loadOnDemand) {
		DBindingEditor result = null;
		final Resource resource = getEditingDomain().getResourceSet().getResource(uri.trimFragment(), loadOnDemand);
		if (resource != null && resource.isLoaded()) {
			if (uri.fragment() != null) {
				final EObject rootElement = resource.getEObject(uri.fragment());
				if (rootElement instanceof DBindingEditor) {
					result = (DBindingEditor) rootElement;
				}
			}
		}
		return result;
	}

	private BindingInfo getBindingInfo() {
		return (BindingInfo)getBindingEditorRepresentation().getTarget();
	}

	protected boolean isAutoRefresh() {
		boolean autoRefresh = false;
		try {
			autoRefresh = SiriusPlugin.getDefault().getPluginPreferences().getBoolean(SiriusPreferencesKeys.PREF_AUTO_REFRESH.name());
		} catch (final IllegalArgumentException e) {
			SiriusTransPlugin.getPlugin().getLog().log(new Status(IStatus.ERROR, SiriusTransPlugin.PLUGIN_ID, IStatus.OK, e.getMessage(), e));
		}
		return autoRefresh;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.ui.business.api.dialect.DialectEditor#setDialogFactory(org.eclipse.sirius.ui.business.api.dialect.DialectEditorDialogFactory)
	 */
	public void setDialogFactory(DialectEditorDialogFactory dialogFactory) {
		myDialogFactory = dialogFactory;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.sirius.ui.business.api.dialect.DialectEditor#validateRepresentation()
	 */
	public void validateRepresentation() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		performSave(false, progressMonitor);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		if (isSaveAsAllowed()) {
			performSaveAs(new NullProgressMonitor());
		}
	}

	/**
	 * Performs the save and handles errors appropriately.
	 * 
	 * @param overwrite
	 *            indicates whether or not overwriting is allowed
	 * @param progressMonitor
	 *            the monitor in which to run the operation
	 * 
	 */
	protected void performSave(final boolean overwrite, final IProgressMonitor progressMonitor) {
		session.save(progressMonitor);
	}

	/**
	 * Perform the saveAs action.
	 * 
	 * @param progressMonitor
	 *            The progress monitor
	 */
	private void performSaveAs(final IProgressMonitor progressMonitor) {
		final Shell shell = getSite().getShell();
		final IEditorInput input = getEditorInput();
		final SaveAsDialog dialog = new SaveAsDialog(shell);
		final IFile original = input instanceof IFileEditorInput ? ((IFileEditorInput) input).getFile() : null;
		if (original != null) {
			dialog.setOriginalFile(original);
		}
		dialog.create();

		if (dialog.open() == Window.CANCEL) {
			if (progressMonitor != null) {
				progressMonitor.setCanceled(true);
			}
		} else {
			final IPath filePath = dialog.getResult();
			if (filePath == null) {
				if (progressMonitor != null) {
					progressMonitor.setCanceled(true);
				}
				return;
			}
			final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			final IFile file = workspaceRoot.getFile(filePath);
			final IEditorInput newInput = new FileEditorInput(file);
			// Check if the editor is already open
			final IEditorMatchingStrategy matchingStrategy = getEditorDescriptor().getEditorMatchingStrategy();
			final IEditorReference[] editorRefs = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
			for (int i = 0; i < editorRefs.length; i++) {
				if (matchingStrategy.matches(editorRefs[i], newInput)) {
					return;
				}
			}
			final boolean success = false;
			if (progressMonitor != null) {
				progressMonitor.setCanceled(!success);
			}
		}
	}

	/**
	 * Retrieves the descriptor for this editor.
	 * 
	 * @return the editor descriptor
	 */
	protected final IEditorDescriptor getEditorDescriptor() {
		final IEditorRegistry editorRegistry = PlatformUI.getWorkbench().getEditorRegistry();
		final IEditorDescriptor editorDesc = editorRegistry.findEditor(getSite().getId());
		return editorDesc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorPart#isDirty()
	 */
	@Override
	public boolean isDirty() {
		return this.session.getStatus() == SessionStatus.DIRTY;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void setFocus() {
		checkSemanticAssociation();
	}

	private void checkSemanticAssociation() {
		if (closing == false &&
				(getBindingEditorRepresentation() == null
				|| getBindingEditorRepresentation().eResource() == null
				|| getBindingEditorRepresentation().getTarget() == null
				|| getBindingEditorRepresentation().getTarget().eResource() == null)) {
			/*
			 * The element has been deleted, we should close the editor
			 */
			myDialogFactory.editorWillBeClosedInformationDialog(getSite().getShell());
			closing = DialectUIManager.INSTANCE.closeEditor(this, false);
		}
	}

	public void notify(final int changeKind) {
		switch (changeKind) {
		case DIRTY:
			firePropertyChangeInUIThread(IEditorPart.PROP_DIRTY);
			break;
		case SYNC:
			firePropertyChangeInUIThread(IEditorPart.PROP_DIRTY);
			break;
		case PROP_TITLE:
			firePropertyChangeInUIThread(PROP_TITLE);
			break;
		case REPLACED:
			/* session was reload, we need to reload the table or close it */
			launchRefresh();
			break;
		default:
			break;
		}
	}

	private void launchRefresh() {
		getEditingDomain().getCommandStack().execute(new RefreshRepresentationsCommand(getEditingDomain(), new NullProgressMonitor()));
		doRefresh();
	}

	public void doRefresh() {
		TreeDataProvider treeDataProvider = new TreeDataProvider(getBindingInfo());
		DBoundElement left = treeDataProvider.getLeftRoot();
		DBoundElement right = treeDataProvider.getRightRoot();
		List<DBindingEdge> edges = treeDataProvider.getEdges();
		treeMapper.setInput(new TreeRoot(left), new TreeRoot(right), edges);
		treeMapper.refresh();
		treeMapper.getLeftTreeViewer().expandToLevel(2);
		treeMapper.getRightTreeViewer().expandToLevel(2);
	}

	private void revealBoundElements(List<DBindingEdge> edges) {
		for (DBindingEdge dBindingEdge : edges) {
			treeMapper.getLeftTreeViewer().reveal(dBindingEdge.getLeft());
			treeMapper.getRightTreeViewer().reveal(dBindingEdge.getRight());
		}
	}

	private void firePropertyChangeInUIThread(final int notificationKind) {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				if (notificationKind == PROP_TITLE) {
					setPartName(getRepresentation().getName());
				}
				firePropertyChange(notificationKind);
			}
		});
	}

	private String getBindingDetailsLabel(DBoundElement first, DBoundElement second) {
		String label = "Binding details : ";
		if (first.getTarget() instanceof Type) {
			label += ((Type)first.getTarget()).getName();
		}
		label += " --> ";
		if (second.getTarget() instanceof Type) {
			label += ((Type)second.getTarget()).getName();
		}

		return label;
	}

	/**
	 * Initializes an UndoRedoActionHandler, which purpose is to provide
	 * appropriate undo and redo Action Handlers to this editor.
	 */
	protected void setUpUndoRedoActionHandler() {
		IWorkbenchWindow workbenchWindow = getEditorSite().getWorkbenchWindow();
		if (workbenchWindow != null) {
			IWorkbenchPage part = workbenchWindow.getActivePage();
			if (part != null) {
				undoRedoActionHandler = new UndoRedoActionHandler(this, getEditingDomain());
			}
		}
		// If the UndoRedoActionHandler was not create
		if (undoRedoActionHandler == null) {
			// We register the current editor as listening the page opening
			// The UndoRedoActionHandler will be created whenever the page will
			// open
			getEditorSite().getWorkbenchWindow().addPageListener(this);
		}
	}

	public void pageActivated(IWorkbenchPage page) {
		setUpUndoRedoActionHandler();
	}

	public void pageClosed(IWorkbenchPage page) {
	}

	public void pageOpened(IWorkbenchPage page) {
	}

	public Saveable[] getSaveables() {
		final IEditingSession uiSession = SessionUIManager.INSTANCE.getOrCreateUISession(this.session);
		return ((ISaveablesSource)uiSession).getSaveables();
	}

	public Saveable[] getActiveSaveables() {
		final IEditingSession uiSession = SessionUIManager.INSTANCE.getOrCreateUISession(this.session);
		return ((ISaveablesSource)uiSession).getActiveSaveables();
	}

	public int promptToSaveOnClose() {
		int choice = ISaveablePart2.DEFAULT;
		if (session != null && session.isOpen()) {
			IEditingSession uiSession = SessionUIManager.INSTANCE.getUISession(session);
			// Close all && Still open elsewhere detection.
			if (uiSession != null && uiSession.needToBeSavedOnClose(this)) {
				choice = uiSession.promptToSaveOnClose();
			}
		}
		return choice;
	}

	public DialectEditorDialogFactory getDialogFactory() {
		return myDialogFactory;
	}

	public boolean needsRefresh(int propId) {
		if (propId == DialectEditor.PROP_REFRESH) {
			if (isAutoRefresh()) {
				return true;
			}
		} else if (propId == DialectEditor.PROP_FORCE_REFRESH) {
			return true;
		}		 
		return false;
	}

}
