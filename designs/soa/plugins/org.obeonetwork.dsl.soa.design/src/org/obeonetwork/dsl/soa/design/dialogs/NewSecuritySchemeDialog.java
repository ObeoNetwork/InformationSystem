package org.obeonetwork.dsl.soa.design.dialogs;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
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
import org.obeonetwork.dsl.soa.ApiKeyLocation;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.Flow;
import org.obeonetwork.dsl.soa.HttpScheme;
import org.obeonetwork.dsl.soa.SecurityScheme;
import org.obeonetwork.dsl.soa.SecuritySchemeType;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.design.adapters.SecuritySchemeTypeAdapter;

/**
 * Opens a dialog for defining a {@link SecurityScheme}.
 * IMPORTANT NOTICE: This code is not used. The dialog displayed is generated with Sirius. 
 * Although, the display of the group elements depends on the SecuritySchemeType Combo box, and cannot be changed dynamically.
 * A current workaround has been implemented, disposing and re-opening the sirius Dialog. 
 * This {@link NewSecuritySchemeDialog} class is kept in case the user do not want to rely on the workaround. 
 * 
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers
 *         la Fosse</a>
 */
public class NewSecuritySchemeDialog extends Dialog {
	private boolean isEdit = false;

	// UI
	private Shell shell;
	private Composite currentComposite;
	private Composite mainComposite;

	// The scheme
	private SecurityScheme scheme;

	// Builder parameters
	private String name;
	private SecuritySchemeType securitySchemeType;
	private String description;

	// API KEY
	private String apiKey;
	private ApiKeyLocation apiKeyLocation;

	// HTTP
	private HttpScheme httpScheme;
	private String format;
	
	// OPENID
	private String openIdConnectURL;
	
	
	// OAUTH2
	private Collection<Flow> flowsAdded = new ArrayList<>();
	private Collection<Flow> flowsDeleted = new ArrayList<>();
	

	/**
	 * If the dialog is used to edit an existing {@link SecurityScheme}, all the
	 * fields are filled with the {@link SecurityScheme} values.
	 * 
	 * @param schemeToEdit a {@link SecurityScheme}
	 */
	public NewSecuritySchemeDialog(Shell parent, SecurityScheme schemeToEdit) {
		super(parent);
		scheme = schemeToEdit;
		name = scheme.getKey();
		securitySchemeType = scheme.getType();
		description = scheme.getDescription();
		apiKeyLocation = scheme.getApiKeyLocation();
		httpScheme = scheme.getHttpScheme();
		openIdConnectURL = scheme.getConnectURL();
		format = scheme.getFormat();
	}

	/**
	 * Opens the dialog so that the right corner is located on the mouse.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		Point pt = display.getCursorLocation();
		shell.setLocation(pt.x - shell.getSize().x, pt.y - shell.getSize().y);
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 365);
		shell.setText(Messages.NewSecuritySchemeDialog_0);
		
		GridLayout gl_shell = new GridLayout(1, false);
		gl_shell.verticalSpacing = 0;
		gl_shell.horizontalSpacing = 0;
		gl_shell.marginHeight = 0;
		gl_shell.marginWidth = 0;
		shell.setLayout(gl_shell);
		Composite typeComposite = new Composite(shell, SWT.NONE);
		GridLayout gl_typeComposite = new GridLayout(1, false);
		gl_typeComposite.marginBottom = 5;
		gl_typeComposite.horizontalSpacing = 0;
		gl_typeComposite.marginWidth = 0;
		gl_typeComposite.marginHeight = 0;
		typeComposite.setLayout(gl_typeComposite);
		GridData gd_typeComposite = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_typeComposite.widthHint = 424;
		typeComposite.setLayoutData(gd_typeComposite);

		Composite composite = new Composite(typeComposite, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(2, false));

		Label typeLabel = new Label(composite, SWT.NONE);
		GridData gd_typeLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_typeLabel.widthHint = 92;
		typeLabel.setLayoutData(gd_typeLabel);
		typeLabel.setText(Messages.NewSecuritySchemeDialog_1);

		Combo typeCombo = new Combo(composite, SWT.READ_ONLY);
		typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		typeCombo.setItems(SecuritySchemeType.VALUES.stream().map(SecuritySchemeType::getName).toArray(String[]::new));
		typeCombo.addSelectionListener(new SecuritySchemeTypeAdapter(this));
		if (securitySchemeType != null)
			typeCombo.setText(securitySchemeType.getName());

		Composite apiKeyNameComposite = new Composite(typeComposite, SWT.NONE);
		apiKeyNameComposite.setLayout(new GridLayout(2, false));
		GridData gd_apiKeyNameComposite = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_apiKeyNameComposite.heightHint = 30;
		apiKeyNameComposite.setLayoutData(gd_apiKeyNameComposite);
		apiKeyNameComposite.setBounds(0, 0, 64, 64);

		Label apiKeyNameLabel = new Label(apiKeyNameComposite, SWT.NONE);
		GridData gd_apiKeyNameLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_apiKeyNameLabel.widthHint = 92;
		apiKeyNameLabel.setLayoutData(gd_apiKeyNameLabel);
		apiKeyNameLabel.setText(Messages.NewSecuritySchemeDialog_2);

		Text apiKeyNameText = new Text(apiKeyNameComposite, SWT.BORDER);
		apiKeyNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		apiKeyNameText.addListener(SWT.KeyUp, (e) -> setName(((Text) e.widget).getText()));
		if (name != null)
			apiKeyNameText.setText(name);

		Composite apiKeyDescriptionComposite = new Composite(shell, SWT.NONE);
		apiKeyDescriptionComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		apiKeyDescriptionComposite.setLayout(new GridLayout(2, false));

		Label apiKeyDescriptionLabel = new Label(apiKeyDescriptionComposite, SWT.NONE);
		GridData gd_apiKeyDescriptionLabel = new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1);
		gd_apiKeyDescriptionLabel.widthHint = 92;
		apiKeyDescriptionLabel.setLayoutData(gd_apiKeyDescriptionLabel);
		apiKeyDescriptionLabel.setBounds(0, 0, 55, 15);
		apiKeyDescriptionLabel.setText(Messages.NewSecuritySchemeDialog_3);

		Text descriptionText = new Text(apiKeyDescriptionComposite, SWT.BORDER | SWT.MULTI);
		GridData gd_apiKeyDescriptionText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_apiKeyDescriptionText.heightHint = 81;
		descriptionText.setLayoutData(gd_apiKeyDescriptionText);
		descriptionText.addListener(SWT.KeyUp, (e) -> setDescription(((Text) e.widget).getText()));

		if (description != null)
			descriptionText.setText(description);

		Label separator = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		mainComposite = new Composite(shell, SWT.NONE);
		mainComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 1, 1));
		GridLayout gl_mainComposite = new GridLayout(1, false);
		gl_mainComposite.marginWidth = 0;
		gl_mainComposite.marginHeight = 0;
		mainComposite.setLayout(gl_mainComposite);

		Composite okCancelComposite = new Composite(shell, SWT.NONE);
		okCancelComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		okCancelComposite.setLayout(new GridLayout(2, false));

		Button cancelButton = new Button(okCancelComposite, SWT.NONE);
		GridData gd_cancelButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_cancelButton.widthHint = 83;
		cancelButton.setLayoutData(gd_cancelButton);
		cancelButton.setText(Messages.NewSecuritySchemeDialog_4);
		cancelButton.addListener(SWT.Selection, (e) -> cancelCreation());

		Button okButton = new Button(okCancelComposite, SWT.NONE);
		okButton.setSelection(true);
		okButton.addListener(SWT.Selection, (e) -> validateCreation());

		GridData gd_okButton = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_okButton.widthHint = 83;
		okButton.setLayoutData(gd_okButton);
		okButton.setText(Messages.NewSecuritySchemeDialog_5);

		setOAuth2Composite();
		displayComposite();
	}

	/**
	 * Displays the fields related to the API Key Security Scheme on the Dialog.
	 */
	public void setApiKeyComposite() {
		removeCurrentComposite();

		Composite apiKeyComposite = new Composite(mainComposite, SWT.NONE);
		GridData gd_apiKeyComposite = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_apiKeyComposite.widthHint = 237;
		apiKeyComposite.setLayoutData(gd_apiKeyComposite);
		apiKeyComposite.setLayout(new GridLayout(1, false));

		Composite apiKeyLocationComboComposite = new Composite(apiKeyComposite, SWT.NONE);
		apiKeyLocationComboComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		apiKeyLocationComboComposite.setLayout(new GridLayout(2, false));

		Label apiKeyLocationLabel = new Label(apiKeyLocationComboComposite, SWT.NONE);
		apiKeyLocationLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		apiKeyLocationLabel.setBounds(0, 0, 55, 15);
		apiKeyLocationLabel.setText(Messages.NewSecuritySchemeDialog_6);

		Combo apiKeyLocationCombo = new Combo(apiKeyLocationComboComposite, SWT.READ_ONLY);
		apiKeyLocationCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		apiKeyLocationCombo
				.setItems(ApiKeyLocation.VALUES.stream().map(ApiKeyLocation::getLiteral).toArray(String[]::new));
		apiKeyLocationCombo.addListener(SWT.Selection,
				(e) -> setApiKeyLocation(ApiKeyLocation.getByName(((Combo) e.widget).getText())));
		if (apiKeyLocation != null)
			apiKeyLocationCombo.setText(apiKeyLocation.getName());

		setCurrentComposite(apiKeyComposite);

		shell.layout(true);
	}

	/**
	 * Dislpays the fields related to OpenID on the Dialog
	 */
	public void setOpenIdComposite() {
		removeCurrentComposite();

		Composite openIdConnectUrlComposite = new Composite(mainComposite, SWT.NONE);
		openIdConnectUrlComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		openIdConnectUrlComposite.setLayout(new GridLayout(2, false));

		Label openIdConnectUrlLabel = new Label(openIdConnectUrlComposite, SWT.NONE);
		GridData gd_openIdConnectUrlLabel = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		gd_openIdConnectUrlLabel.widthHint = 92;
		openIdConnectUrlLabel.setLayoutData(gd_openIdConnectUrlLabel);
		openIdConnectUrlLabel.setBounds(0, 0, 55, 15);
		openIdConnectUrlLabel.setText(Messages.NewSecuritySchemeDialog_7);

		Text openIdConnectUrlText = new Text(openIdConnectUrlComposite, SWT.BORDER);
		openIdConnectUrlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		openIdConnectUrlText.addListener(SWT.KeyUp, (e) -> setOpenIdConnectURL(((Text) e.widget).getText()));
		
		if (openIdConnectURL != null)
			openIdConnectUrlText.setText(openIdConnectURL);

		setCurrentComposite(openIdConnectUrlComposite);
		shell.layout(true);
	}

	/**
	 * Displays the fields related to HTTP on the Dialog
	 */
	public void setHttpComposite() {
		removeCurrentComposite();
		Composite httpComposite = new Composite(mainComposite, SWT.NONE);
		httpComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		GridLayout gl_httpComposite = new GridLayout(1, false);
		gl_httpComposite.marginWidth = 0;
		httpComposite.setLayout(gl_httpComposite);

		Composite httpCompositeScheme = new Composite(httpComposite, SWT.NONE);
		httpCompositeScheme.setLayout(new GridLayout(2, false));
		GridData gd_httpCompositeScheme = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_httpCompositeScheme.widthHint = 92;
		httpCompositeScheme.setLayoutData(gd_httpCompositeScheme);

		Label lblHttpScheme = new Label(httpCompositeScheme, SWT.NONE);
		GridData gd_lblHttpScheme = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblHttpScheme.widthHint = 92;
		lblHttpScheme.setLayoutData(gd_lblHttpScheme);
		lblHttpScheme.setBounds(0, 0, 55, 15);
		lblHttpScheme.setText(Messages.NewSecuritySchemeDialog_8);

		Combo httpSchemeCombo = new Combo(httpCompositeScheme, SWT.READ_ONLY);
		httpSchemeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		httpSchemeCombo.setItems(HttpScheme.VALUES.stream().map(HttpScheme::getName).toArray(String[]::new));
		httpSchemeCombo.addListener(SWT.Selection,
				(e) -> setHttpScheme(HttpScheme.getByName(((Combo) e.widget).getText())));
		if (httpSchemeCombo != null)
			httpSchemeCombo.setText(httpScheme.getName());

		
		Composite bearerComposite = new Composite(httpComposite, SWT.NONE);
		bearerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		bearerComposite.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel = new Label(bearerComposite, SWT.NONE);
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 92;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		lblNewLabel.setText(Messages.NewSecuritySchemeDialog_9);
		
		Text formatText = new Text(bearerComposite, SWT.BORDER);
		formatText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		formatText.addListener(SWT.KeyUp, (e) -> setFormat(((Text) e.widget).getText()));
		if (format != null)
			formatText.setText(format);
		
		if (httpScheme == null || !httpScheme.equals(HttpScheme.BEARER))
			formatText.setEnabled(false);
		
		httpSchemeCombo.addListener(SWT.Selection, (e) -> {
			if (HttpScheme.getByName(((Combo) e.widget).getText()).equals(HttpScheme.BEARER)) {
				formatText.setEnabled(true);
			} else {
				formatText.setEnabled(false);
				formatText.setText(Messages.NewSecuritySchemeDialog_10);
				format = null;
			}
		});
		
		setCurrentComposite(httpComposite);
		shell.layout(true);
	}



	/**
	 * Displays the fields related to OAuth2 on the Dialog
	 */
	public void setOAuth2Composite() {
		removeCurrentComposite();
		Composite oauth2Composite = new Composite(mainComposite, SWT.NONE);
		oauth2Composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		oauth2Composite.setLayout(new GridLayout(3, false));

		Label lblFlows = new Label(oauth2Composite, SWT.NONE);
		GridData gd_lblFlows = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_lblFlows.widthHint = 92;
		lblFlows.setLayoutData(gd_lblFlows);
		lblFlows.setText(Messages.NewSecuritySchemeDialog_11);

		TableViewer tableViewer = new TableViewer(oauth2Composite, SWT.BORDER);
		Table compositeTable = tableViewer.getTable();

		GridData gd_compositeList = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_compositeList.widthHint = 294;
		gd_compositeList.heightHint = 81;
		compositeTable.setLayoutData(gd_compositeList);
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		tableViewer.setContentProvider(new IStructuredContentProvider() {
			
			@Override
			public Object[] getElements(Object inputElement) {
				Collection<Flow> flowsToDisplayInTheTable = new ArrayList<>();
				flowsToDisplayInTheTable.addAll(scheme.getFlows());
				flowsToDisplayInTheTable.addAll(flowsAdded);
				flowsToDisplayInTheTable.removeAll(flowsDeleted);
				return flowsToDisplayInTheTable.toArray(new Flow[] {});
			}
		});
		tableViewer.setInput(scheme);
		tableViewer.addDoubleClickListener((e) -> {
			if (e.getSource() instanceof TableViewer && ((TableViewer) e.getSource()).getStructuredSelection() != null
					&& ((TableViewer) e.getSource()).getStructuredSelection().getFirstElement() instanceof Flow) {

				new NewFlowDialog(shell,
						(Flow) ((TableViewer) e.getSource()).getStructuredSelection().getFirstElement()).open();
				tableViewer.setInput(scheme);
			}
		});

		Composite auth2buttonComposite = new Composite(oauth2Composite, SWT.NONE);
		auth2buttonComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		GridLayout gl_auth2buttonComposite = new GridLayout(1, false);
		gl_auth2buttonComposite.marginWidth = 0;
		gl_auth2buttonComposite.marginHeight = 0;
		auth2buttonComposite.setLayout(gl_auth2buttonComposite);

		Button addFlow = new Button(auth2buttonComposite, SWT.NONE);
		GridData gd_addFlow = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_addFlow.widthHint = 50;
		addFlow.setLayoutData(gd_addFlow);
		addFlow.setImage(
				new Image(null, this.getClass().getClassLoader().getResourceAsStream(Messages.NewSecuritySchemeDialog_12))); 
		addFlow.addListener(SWT.Selection, (e) -> {
			Flow flow = SoaFactory.eINSTANCE.createFlow();
			flowsAdded.add(flow);
			new NewFlowDialog(shell, flow).open();
			tableViewer.refresh();
		});

		Button deleteFlow = new Button(auth2buttonComposite, SWT.NONE);
		deleteFlow.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		deleteFlow.setImage(
				new Image(null, this.getClass().getClassLoader().getResourceAsStream(Messages.NewSecuritySchemeDialog_13))); 
		deleteFlow.addListener(SWT.Selection, (e) -> {
			Flow toDelete = (Flow) tableViewer.getStructuredSelection().getFirstElement();
			flowsDeleted.add(toDelete);
			tableViewer.refresh();
		});

		shell.layout(true);
		setCurrentComposite(oauth2Composite);
	}

	/**
	 * Remove the bottom {@link Composite} of the Dialog
	 */
	public void removeCurrentComposite() {
		if (currentComposite != null) {
			currentComposite.dispose();
			setCurrentComposite(null);
		}

		shell.layout(true);
	}


	private void revertChanges() {
		if (isEdit == false) {
			Component component = (Component) scheme.eContainer();
			component.getSecuritySchemes().remove(scheme);
		}
	}
	
	/**
	 * The cancel button has been pressed: cancel all the changes made to the
	 * current {@link SecurityScheme}
	 */
	private void cancelCreation() {
		revertChanges();
		shell.close();
	}

	/**
	 * The OK button has been pressed: all the changes defined by the widgets are
	 * applied to the current {@link SecurityScheme}
	 */
	private void validateCreation() {
		scheme.setType(securitySchemeType);		
		scheme.setKey(name);
		scheme.setDescription(description);
		scheme.setApiKeyLocation(apiKeyLocation);
		scheme.setHttpScheme(httpScheme);
		scheme.setConnectURL(openIdConnectURL);
		scheme.getFlows().addAll(flowsAdded);
		scheme.setFormat(format);
		scheme.getFlows().addAll(flowsAdded);
		scheme.getFlows().removeAll(flowsDeleted);
		shell.close();
	}

	/**
	 * Display a composite with the entry fields as defined by the
	 * {@link SecuritySchemeType} of the {@link SecurityScheme}
	 */
	public void displayComposite() {
		switch (securitySchemeType) {
		case API_KEY:
			setApiKeyComposite();
			break;
		case HTTP:
			setHttpComposite();
			break;
		case OAUTH2:
			setOAuth2Composite();
			break;
		case OPEN_ID_CONNECT:
			setOpenIdComposite();
			break;
		default:
			setApiKeyComposite();
			break;
		}
		shell.layout(true);
	}

	/**
	 * Opens the dialog so that an existing {@link SecurityScheme} can be edited.
	 */
	public void edit() {
		isEdit = true;
		open();
	}

	public void setCurrentComposite(Composite currentComposite) {
		this.currentComposite = currentComposite;
	}

	public void setSecuritySchemeType(SecuritySchemeType type) {
		this.securitySchemeType = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String apiKeyDescription) {
		this.description = apiKeyDescription;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public void setApiKeyLocation(ApiKeyLocation apiKeyLocation) {
		this.apiKeyLocation = apiKeyLocation;
	}

	public void setHttpScheme(HttpScheme httpScheme) {
		this.httpScheme = httpScheme;
	}

	public void setOpenIdConnectURL(String openIdConnectURL) {
		this.openIdConnectURL = openIdConnectURL;
	}

	private void setFormat(String format) {
		this.format = format;
	}
}
