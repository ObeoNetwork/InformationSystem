package org.obeonetwork.dsl.cinematic.design.services.flows;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.obeonetwork.dsl.cinematic.AbstractPackage;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.obeonetwork.dsl.cinematic.Event;
import org.obeonetwork.dsl.cinematic.NamedElement;
import org.obeonetwork.dsl.cinematic.flow.Flow;
import org.obeonetwork.dsl.cinematic.flow.SubflowState;
import org.obeonetwork.dsl.cinematic.flow.Transition;
import org.obeonetwork.dsl.cinematic.toolkits.WidgetEventType;
import org.obeonetwork.dsl.cinematic.view.AbstractViewElement;
import org.obeonetwork.dsl.cinematic.view.ViewContainer;
import org.obeonetwork.dsl.technicalid.Identifiable;

public class FlowstateToViewstateEventDialog extends Dialog {
	private Text txtFilterText;
	private Transition transition;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public FlowstateToViewstateEventDialog(Shell parentShell, Transition transition) {
		super(parentShell);
		this.transition = transition;
		setShellStyle(SWT.SHELL_TRIM);		
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		System.out.println("Creating the dialog");
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		composite.setLayout(new GridLayout(2, false));
		
		Button btnCheckButton = new Button(composite, SWT.CHECK);

		btnCheckButton.setText("Hide View Containers bound to other View States");
		new Label(composite, SWT.NONE);
		
		txtFilterText = new Text(composite, SWT.SEARCH | SWT.ICON_CANCEL);
		txtFilterText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtFilterText.setMessage("Filter text (? = any character, * = any String)");
		
		Button btnClearButton = new Button(composite, SWT.NONE);
		btnClearButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnClearButton.setText("clear");
		
		CheckboxTreeViewer checkboxTreeViewer = new CheckboxTreeViewer(container, SWT.BORDER);
		Tree tree = checkboxTreeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		checkboxTreeViewer.setContentProvider(new ITreeContentProvider() {
			
			@Override
			public boolean hasChildren(Object element) {
				return (element instanceof Flow || element instanceof AbstractViewElement);				
			}
			
			@Override
			public Object getParent(Object element) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] getElements(Object root) {
				ArrayList<Object> elements = new ArrayList<Object>();
				
				if (root instanceof Transition) {
					elements.add(((Transition) root).eContainer());
					CinematicRoot cinematicRoot = FlowsUtil.getCinematicRoot((EObject) root);
					elements.addAll(FlowsUtil.getAllPackagesFromRoot(cinematicRoot).stream()
						.flatMap(abstractPackage -> abstractPackage.getViewContainers().stream())
						.collect(Collectors.toList()));
				}
				
				return elements.toArray();
				
			}
			
			@Override
			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof Flow) {
					return ((Flow) parentElement).getEvents().toArray();
				}
				
				if (parentElement instanceof AbstractViewElement) {
					Collection<EObject> eObjects = new ArrayList<>();
					eObjects.addAll(((AbstractViewElement) parentElement).getWidget().getPossibleEvents());
					if (parentElement instanceof ViewContainer) {
						eObjects.addAll(((ViewContainer) parentElement).getViewElements());
					}
					return eObjects.toArray();
				}
				
				return null;
			}
		});
		
		checkboxTreeViewer.setLabelProvider(new LabelProvider() {

			@Override
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return super.getImage(element);
			}

			@Override
			public String getText(Object element) {
				if (element instanceof Flow) {
					return "Flow events";
				}
				
				if (element instanceof NamedElement) {
					return ((NamedElement) element).getName();
				}
				
				if (element instanceof WidgetEventType) {
					return ((WidgetEventType) element).getName();
				}
				
				return super.getText(element);
			}
			
		});
		checkboxTreeViewer.setInput(transition);
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
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 361);
	}
	
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Event selection");	
	}
}
 