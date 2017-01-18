package fr.gouv.mindef.safran.project.lifecycle.ui;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class BusinessProjectImportExportDialog extends Dialog {
	
	private IProject sourceProject;
	private IProject targetProject;

	private ListViewer listViewerSource;
	private ListViewer listViewerTarget;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public BusinessProjectImportExportDialog(Shell parentShell, IProject sourceProject, IProject targetProject) {
		super(parentShell);
		setShellStyle(SWT.DIALOG_TRIM | SWT.MAX | SWT.RESIZE);
		this.sourceProject = sourceProject;
		this.targetProject = targetProject;
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.BusinessProjectImportDialog_Title);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FillLayout fl_container = new FillLayout(SWT.HORIZONTAL);
		fl_container.spacing = 10;
		fl_container.marginHeight = 10;
		fl_container.marginWidth = 10;
		container.setLayout(fl_container);
		
		Group grpSourceProject = new Group(container, SWT.NONE);
		grpSourceProject.setText(Messages.BusinessProjectImportDialog_grpSourceProject_text);
		grpSourceProject.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		listViewerSource = new ListViewer(grpSourceProject, SWT.BORDER | SWT.V_SCROLL);
		listViewerSource.setUseHashlookup(true);
		listViewerSource.setContentProvider(ArrayContentProvider.getInstance());
		listViewerSource.setLabelProvider(new ProjectLabelProvider());
		
		Group grpTargetProject = new Group(container, SWT.NONE);
		grpTargetProject.setText(Messages.BusinessProjectImportDialog_grpTargetProject_text);
		grpTargetProject.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		listViewerTarget = new ListViewer(grpTargetProject, SWT.BORDER | SWT.V_SCROLL);
		listViewerTarget.setUseHashlookup(true);
		listViewerTarget.setContentProvider(ArrayContentProvider.getInstance());
		listViewerTarget.setLabelProvider(new ProjectLabelProvider());

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
		initContents();
		initBindings();
		updateButtons();
	}
	
	private void initContents() {
		listViewerSource.setInput(getProjects());
		if (sourceProject != null) {
			listViewerSource.setSelection(new StructuredSelection(sourceProject));
		}
		listViewerTarget.setInput(getProjects());
		if (targetProject != null) {
			listViewerTarget.setSelection(new StructuredSelection(targetProject));
		}
	}
	
	private Collection<IProject> getProjects() {
		Collection<IProject> projects = new ArrayList<IProject>();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		for (IProject project : root.getProjects()) {
			// We keep only open Modeling projects
			if (project.isOpen()) {
				boolean natureEnabled = false;
				try {
					natureEnabled = project.isNatureEnabled(ModelingProject.NATURE_ID);
				} catch (CoreException e) {
					// Do nothing special
					natureEnabled = false;
				}
				if (natureEnabled) {
					projects.add(project);
				}
			}
			
		}
		return projects;
	}
	
	private void initBindings() {
		ISelectionChangedListener listener = new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				sourceProject = getSelectedProject(listViewerSource);
				targetProject = getSelectedProject(listViewerTarget);
				updateButtons();
			}
		};
		listViewerSource.addSelectionChangedListener(listener);
		listViewerTarget.addSelectionChangedListener(listener);
	}
	
	private IProject getSelectedProject(ListViewer viewer) {
		ISelection selection = viewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object firstElement = structuredSelection.getFirstElement();
				if (firstElement instanceof IProject) {
					return (IProject)firstElement;
				}
			}
		}
		return null;
	}
	
	private void updateButtons() {
		boolean okEnabled = sourceProject != null && targetProject != null && sourceProject != targetProject;
		getButton(IDialogConstants.OK_ID).setEnabled(okEnabled);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	private class ProjectLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			if (element instanceof IProject) {
				return ((IProject) element).getName();
			}
			return super.getText(element);
		}
	}

	public IProject getSourceProject() {
		return sourceProject;
	}

	public IProject getTargetProject() {
		return targetProject;
	}
	
}
