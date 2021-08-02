package org.obeonetwork.dsl.soa.design.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ListDialog;
import org.obeonetwork.dsl.soa.Flow;
import org.obeonetwork.dsl.soa.FlowType;
import org.obeonetwork.dsl.soa.Parameter;

/**
 * {@link Dialog} for creating and editing {@link Flow} objects
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a> 
 */
public class NewFlowDialog extends Dialog {
	
	protected Shell shell;
	private Text authText;
	private Text tokenText;
	private Text refreshText;
	private Flow flow;
	private FlowType flowType;
	private Collection<Parameter> parametersToAdd = new ArrayList<>();
	private Collection<Parameter> parametersToRemove = new ArrayList<>();

	/**
	 * Create the dialog.
	 * @param parent a {@link Shell}
	 * @param flow a {@link Flow}
	 */
	public NewFlowDialog(Shell parent, Flow flow) {
		super(parent);		
		this.flow = flow;
		setText("Flow creation");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.setLocation(getParent().getLocation());
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return null;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.SHELL_TRIM | SWT.BORDER | SWT.PRIMARY_MODAL);
		shell.setSize(450, 280);
		shell.setText(getText());
		GridLayout gl_shell = new GridLayout(1, false);
		gl_shell.marginHeight = 0;
		gl_shell.verticalSpacing = 0;
		gl_shell.marginWidth = 0;
		shell.setLayout(gl_shell);
		
		Composite mainComposite = new Composite(shell, SWT.NONE);
		mainComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		GridLayout gl_mainComposite = new GridLayout(1, false);
		gl_mainComposite.verticalSpacing = 0;
		gl_mainComposite.marginWidth = 0;
		gl_mainComposite.horizontalSpacing = 0;
		gl_mainComposite.marginHeight = 0;
		mainComposite.setLayout(gl_mainComposite);
		
		Composite flowTypeComposite = new Composite(mainComposite, SWT.NONE);
		flowTypeComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		flowTypeComposite.setLayout(new GridLayout(2, false));
		
		Label lblType = new Label(flowTypeComposite, SWT.NONE);
		GridData gd_lblType = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblType.widthHint = 102;
		lblType.setLayoutData(gd_lblType);
		lblType.setBounds(0, 0, 55, 15);
		lblType.setText("Type:");
		
		Combo flowTypeCombo = new Combo(flowTypeComposite, SWT.READ_ONLY);
		flowTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		flowTypeCombo.setItems(FlowType.VALUES.stream().map(type -> type.getName()).toArray(String[]::new));
		flowTypeCombo.addListener(SWT.Selection, (e) -> setFlowType(FlowType.getByName(((Combo) e.widget).getText())));
		
		if (flow.getFlowType() != null)
			flowTypeCombo.setText(flow.getFlowType().getName());
		
		Composite authComposite = new Composite(mainComposite, SWT.NONE);
		authComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		authComposite.setLayout(new GridLayout(2, false));
		
		Label lblAuthorizationUrl = new Label(authComposite, SWT.NONE);
		GridData gd_lblAuthorizationUrl = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblAuthorizationUrl.widthHint = 102;
		lblAuthorizationUrl.setLayoutData(gd_lblAuthorizationUrl);
		lblAuthorizationUrl.setBounds(0, 0, 55, 15);
		lblAuthorizationUrl.setText("Authorization URL:");
		
		authText = new Text(authComposite, SWT.BORDER);
		authText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		if (flow.getAuthorizationURL() != null)
			authText.setText(flow.getAuthorizationURL());
		
		Composite tokenComposite = new Composite(mainComposite, SWT.NONE);
		tokenComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		tokenComposite.setLayout(new GridLayout(2, false));
		
		Label lblTokenUrl = new Label(tokenComposite, SWT.NONE);
		GridData gd_lblTokenUrl = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblTokenUrl.widthHint = 102;
		lblTokenUrl.setLayoutData(gd_lblTokenUrl);
		lblTokenUrl.setBounds(0, 0, 55, 15);
		lblTokenUrl.setText("Token URL:");
		
		tokenText = new Text(tokenComposite, SWT.BORDER);
		tokenText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		if (flow.getTokenURL() != null)
			tokenText.setText(flow.getTokenURL());
		
		Composite refreshComposite = new Composite(mainComposite, SWT.NONE);
		refreshComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		refreshComposite.setLayout(new GridLayout(2, false));
		
		Label lblRefreshUrl = new Label(refreshComposite, SWT.NONE);
		GridData gd_lblRefreshUrl = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblRefreshUrl.widthHint = 102;
		lblRefreshUrl.setLayoutData(gd_lblRefreshUrl);
		lblRefreshUrl.setBounds(0, 0, 55, 15);
		lblRefreshUrl.setText("Refresh URL:");
		
		refreshText = new Text(refreshComposite, SWT.BORDER);
		refreshText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		if (flow.getRefreshURL() != null) 
			refreshText.setText(flow.getRefreshURL());
		
		Composite parametersComposite = new Composite(mainComposite, SWT.NONE);
		parametersComposite.setLayout(new GridLayout(3, false));
		parametersComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		Label scopeLabel = new Label(parametersComposite, SWT.NONE);
		GridData gd_scopeLabel = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_scopeLabel.widthHint = 102;
		scopeLabel.setLayoutData(gd_scopeLabel);
		scopeLabel.setText("Scopes:");
		
		TableViewer parametersTableViewer = new TableViewer(parametersComposite, SWT.BORDER | SWT.V_SCROLL);
		Table table = parametersTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		parametersTableViewer.setContentProvider(new IStructuredContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				return flow.getScopes().stream().toArray(Parameter[]::new);
			}
		});
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		parametersTableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		parametersTableViewer.setInput(flow);		
		Composite buttonComposite = new Composite(parametersComposite, SWT.NONE);
		buttonComposite.setLayout(new GridLayout(1, false));
		
		Button addScope = new Button(buttonComposite, SWT.NONE);
		addScope.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		addScope.setImage(new Image(null, this.getClass().getClassLoader().getResourceAsStream("/icons/full/others/add.gif")));
		addScope.addListener(SWT.Selection, (e) -> {
			ListDialog dialog = new ParameterSelectionDialog(shell);
			dialog.setInput(flow);
			dialog.open();
			parametersToAdd = Arrays.asList(dialog.getResult()) // Object[]
					.stream()
					.map(Parameter.class::cast) // Stream<Parameter>
					.collect(Collectors.toList()); // List<Parameter>
			flow.getScopes().addAll(parametersToAdd);
			parametersTableViewer.setInput(flow);
		});
		
		Button deleteScope = new Button(buttonComposite, SWT.NONE);
		deleteScope.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		deleteScope.setImage(new Image(null, this.getClass().getClassLoader().getResourceAsStream("/icons/full/others/delete.gif")));
		deleteScope.addListener(SWT.Selection, (e) -> {
			parametersToRemove.add((Parameter) parametersTableViewer.getStructuredSelection().getFirstElement());
			flow.getScopes().removeAll(parametersToRemove);
			parametersTableViewer.setInput(flow);
		});
		
		/*
		Button moveScopeUp = new Button(buttonComposite, SWT.NONE);
		moveScopeUp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		moveScopeUp.setImage(new Image(null, this.getClass().getClassLoader().getResourceAsStream("/icons/full/others/up.gif")));
		
		Button moveScopeDown = new Button(buttonComposite, SWT.NONE);
		moveScopeDown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		moveScopeDown.setImage(new Image(null, this.getClass().getClassLoader().getResourceAsStream("/icons/full/others/down.gif")));
		 */
		
		Composite okCancelButtonsComposite = new Composite(mainComposite, SWT.NONE);
		okCancelButtonsComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, true, false, 1, 1));
		okCancelButtonsComposite.setLayout(new GridLayout(2, false));
		
		Button cancelButton = new Button(okCancelButtonsComposite, SWT.NONE);
		GridData gd_cancelButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_cancelButton.widthHint = 83;
		cancelButton.setLayoutData(gd_cancelButton);
		cancelButton.setText("Cancel");
		cancelButton.addListener(SWT.Selection, (e) -> cancelCreation());
		
		Button okButton = new Button(okCancelButtonsComposite, SWT.NONE);
		GridData gd_okButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_okButton.widthHint = 83;
		okButton.setLayoutData(gd_okButton);
		okButton.setText("OK");
		okButton.addListener(SWT.Selection, (e) -> validateCreation());
	}

	/**
	 * The cancel button is pressed.
	 * Cancels the creation of the {@link Flow}: all the scope {@link Parameter} added are removed, all the scope {@link Parameter} removed are added back.
	 */
	private void cancelCreation() {
		flow.getScopes().removeAll(parametersToAdd);
		flow.getScopes().addAll(parametersToRemove);
		
		shell.close();
	}

	/**
	 * The OK button is pressed.
	 * Validates all the changes entered by the user and pushes them to the {@link Flow} object.
	 */
	private void validateCreation() {
		flow.setAuthorizationURL(authText.getText());
		flow.setTokenURL(tokenText.getText());
		flow.setRefreshURL(refreshText.getText());
		flow.setFlowType(flowType);
		
		shell.close();
	}
	
	private void setFlowType(FlowType byName) {
		flowType = byName;
	}


}
