/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.requirement.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;
import org.obeonetwork.dsl.requirement.parts.TextWithButton;
import org.obeonetwork.dsl.requirement.providers.RequirementMessages;

// End of user code

/**
 * 
 * 
 */
public class RequirementPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RequirementPropertiesEditionPart {

	protected EMFComboViewer type;
	protected Text subtype;
	protected Text id;
	protected Text name;
	// Start of user code  for version widgets declarations
	protected TextWithButton version;
	// End of user code

	protected Text status;
	protected Text statement;
	protected Text modifiedOn;
	protected Text createdOn;



	/**
	 * For {@link ISection} use only.
	 */
	public RequirementPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RequirementPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence requirement_Step = new BindingCompositionSequence(propertiesEditionComponent);
		requirement_Step.addStep(RequirementViewsRepository.Requirement_.type);
		requirement_Step.addStep(RequirementViewsRepository.Requirement_.subtype);
		requirement_Step.addStep(RequirementViewsRepository.Requirement_.id);
		requirement_Step.addStep(RequirementViewsRepository.Requirement_.name);
		requirement_Step.addStep(RequirementViewsRepository.Requirement_.version);
		requirement_Step.addStep(RequirementViewsRepository.Requirement_.status);
		requirement_Step.addStep(RequirementViewsRepository.Requirement_.statement);
		requirement_Step.addStep(RequirementViewsRepository.Requirement_.modifiedOn);
		requirement_Step.addStep(RequirementViewsRepository.Requirement_.createdOn);
		
		composer = new PartComposer(requirement_Step) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == RequirementViewsRepository.Requirement_.type) {
					return createTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == RequirementViewsRepository.Requirement_.subtype) {
					return createSubtypeText(widgetFactory, parent);
				}
				if (key == RequirementViewsRepository.Requirement_.id) {
					return createIdText(widgetFactory, parent);
				}
				if (key == RequirementViewsRepository.Requirement_.name) {
					return createNameText(widgetFactory, parent);
				}
				// Start of user code for version addToPart creation
				
				if (key == RequirementViewsRepository.Requirement_.version) {
					return createVersionWidget(widgetFactory, parent);
				}
				
				// End of user code
				if (key == RequirementViewsRepository.Requirement_.status) {
					return createStatusText(widgetFactory, parent);
				}
				if (key == RequirementViewsRepository.Requirement_.statement) {
					return createStatementTextarea(widgetFactory, parent);
				}
				if (key == RequirementViewsRepository.Requirement_.modifiedOn) {
					return createModifiedOnText(widgetFactory, parent);
				}
				if (key == RequirementViewsRepository.Requirement_.createdOn) {
					return createCreatedOnText(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	
	protected Composite createTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.type, RequirementMessages.RequirementPropertiesEditionPart_TypeLabel);
		type = new EMFComboViewer(parent);
		type.setContentProvider(new ArrayContentProvider());
		type.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.getCombo().setLayoutData(typeData);
		type.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartForm.this, RequirementViewsRepository.Requirement_.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getType()));
			}

		});
		type.setID(RequirementViewsRepository.Requirement_.type);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.type, RequirementViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSubtypeText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.subtype, RequirementMessages.RequirementPropertiesEditionPart_SubtypeLabel);
		subtype = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		subtype.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData subtypeData = new GridData(GridData.FILL_HORIZONTAL);
		subtype.setLayoutData(subtypeData);
		subtype.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RequirementPropertiesEditionPartForm.this,
							RequirementViewsRepository.Requirement_.subtype,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, subtype.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									RequirementViewsRepository.Requirement_.subtype,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, subtype.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		subtype.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartForm.this, RequirementViewsRepository.Requirement_.subtype, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, subtype.getText()));
				}
			}
		});
		EditingUtils.setID(subtype, RequirementViewsRepository.Requirement_.subtype);
		EditingUtils.setEEFtype(subtype, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.subtype, RequirementViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createIdText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.id, RequirementMessages.RequirementPropertiesEditionPart_IdLabel);
		id = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		id.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData idData = new GridData(GridData.FILL_HORIZONTAL);
		id.setLayoutData(idData);
		id.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RequirementPropertiesEditionPartForm.this,
							RequirementViewsRepository.Requirement_.id,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									RequirementViewsRepository.Requirement_.id,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, id.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		id.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartForm.this, RequirementViewsRepository.Requirement_.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
				}
			}
		});
		EditingUtils.setID(id, RequirementViewsRepository.Requirement_.id);
		EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.id, RequirementViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.name, RequirementMessages.RequirementPropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RequirementPropertiesEditionPartForm.this,
							RequirementViewsRepository.Requirement_.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									RequirementViewsRepository.Requirement_.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartForm.this, RequirementViewsRepository.Requirement_.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, RequirementViewsRepository.Requirement_.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.name, RequirementViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createStatusText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.status, RequirementMessages.RequirementPropertiesEditionPart_StatusLabel);
		status = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		status.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData statusData = new GridData(GridData.FILL_HORIZONTAL);
		status.setLayoutData(statusData);
		status.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RequirementPropertiesEditionPartForm.this,
							RequirementViewsRepository.Requirement_.status,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, status.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									RequirementViewsRepository.Requirement_.status,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, status.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		status.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartForm.this, RequirementViewsRepository.Requirement_.status, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, status.getText()));
				}
			}
		});
		EditingUtils.setID(status, RequirementViewsRepository.Requirement_.status);
		EditingUtils.setEEFtype(status, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.status, RequirementViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createStatementTextarea(FormToolkit widgetFactory, Composite parent) {
		Label statementLabel = createDescription(parent, RequirementViewsRepository.Requirement_.statement, RequirementMessages.RequirementPropertiesEditionPart_StatementLabel);
		GridData statementLabelData = new GridData(GridData.FILL_HORIZONTAL);
		statementLabelData.horizontalSpan = 3;
		statementLabel.setLayoutData(statementLabelData);
		statement = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL); //$NON-NLS-1$
		GridData statementData = new GridData(GridData.FILL_HORIZONTAL);
		statementData.horizontalSpan = 2;
		statementData.heightHint = 80;
		statementData.widthHint = 200;
		statement.setLayoutData(statementData);
		statement.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RequirementPropertiesEditionPartForm.this,
							RequirementViewsRepository.Requirement_.statement,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, statement.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									RequirementViewsRepository.Requirement_.statement,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, statement.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(statement, RequirementViewsRepository.Requirement_.statement);
		EditingUtils.setEEFtype(statement, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.statement, RequirementViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createModifiedOnText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.modifiedOn, RequirementMessages.RequirementPropertiesEditionPart_ModifiedOnLabel);
		modifiedOn = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		modifiedOn.setEnabled(false);
		modifiedOn.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		modifiedOn.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData modifiedOnData = new GridData(GridData.FILL_HORIZONTAL);
		modifiedOn.setLayoutData(modifiedOnData);
		modifiedOn.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RequirementPropertiesEditionPartForm.this,
							RequirementViewsRepository.Requirement_.modifiedOn,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modifiedOn.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									RequirementViewsRepository.Requirement_.modifiedOn,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, modifiedOn.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		modifiedOn.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartForm.this, RequirementViewsRepository.Requirement_.modifiedOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modifiedOn.getText()));
				}
			}
		});
		EditingUtils.setID(modifiedOn, RequirementViewsRepository.Requirement_.modifiedOn);
		EditingUtils.setEEFtype(modifiedOn, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.modifiedOn, RequirementViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createCreatedOnText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.createdOn, RequirementMessages.RequirementPropertiesEditionPart_CreatedOnLabel);
		createdOn = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		createdOn.setEnabled(false);
		createdOn.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		createdOn.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData createdOnData = new GridData(GridData.FILL_HORIZONTAL);
		createdOn.setLayoutData(createdOnData);
		createdOn.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RequirementPropertiesEditionPartForm.this,
							RequirementViewsRepository.Requirement_.createdOn,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, createdOn.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									RequirementViewsRepository.Requirement_.createdOn,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, createdOn.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RequirementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		createdOn.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartForm.this, RequirementViewsRepository.Requirement_.createdOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, createdOn.getText()));
				}
			}
		});
		EditingUtils.setID(createdOn, RequirementViewsRepository.Requirement_.createdOn);
		EditingUtils.setEEFtype(createdOn, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.createdOn, RequirementViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#getType()
	 * 
	 */
	public Enumerator getType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) type.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#initType(Object input, Enumerator current)
	 */
	public void initType(Object input, Enumerator current) {
		type.setInput(input);
		type.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#setType(Enumerator newValue)
	 * 
	 */
	public void setType(Enumerator newValue) {
		type.modelUpdating(new StructuredSelection(newValue));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#getSubtype()
	 * 
	 */
	public String getSubtype() {
		return subtype.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#setSubtype(String newValue)
	 * 
	 */
	public void setSubtype(String newValue) {
		if (newValue != null) {
			subtype.setText(newValue);
		} else {
			subtype.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#getId()
	 * 
	 */
	public String getId() {
		return id.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#setId(String newValue)
	 * 
	 */
	public void setId(String newValue) {
		if (newValue != null) {
			id.setText(newValue);
		} else {
			id.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#getStatus()
	 * 
	 */
	public String getStatus() {
		return status.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#setStatus(String newValue)
	 * 
	 */
	public void setStatus(String newValue) {
		if (newValue != null) {
			status.setText(newValue);
		} else {
			status.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#getStatement()
	 * 
	 */
	public String getStatement() {
		return statement.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#setStatement(String newValue)
	 * 
	 */
	public void setStatement(String newValue) {
		if (newValue != null) {
			statement.setText(newValue);
		} else {
			statement.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#getModifiedOn()
	 * 
	 */
	public String getModifiedOn() {
		return modifiedOn.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#setModifiedOn(String newValue)
	 * 
	 */
	public void setModifiedOn(String newValue) {
		if (newValue != null) {
			modifiedOn.setText(newValue);
		} else {
			modifiedOn.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#getCreatedOn()
	 * 
	 */
	public String getCreatedOn() {
		return createdOn.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#setCreatedOn(String newValue)
	 * 
	 */
	public void setCreatedOn(String newValue) {
		if (newValue != null) {
			createdOn.setText(newValue);
		} else {
			createdOn.setText(""); //$NON-NLS-1$
		}
	}






	// Start of user code for version specific getters and setters implementation
	
	public Integer getVersion() {
		return Integer.valueOf(version.getText());
	}

	public void setVersion(Integer newValue) {
		if (newValue != null) {
			version.setText( String.valueOf(newValue));
		} else {
			version.setText("");
		}
	}
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return RequirementMessages.Requirement_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createVersionWidget(FormToolkit widgetFactory, final Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.version, RequirementMessages.RequirementPropertiesEditionPart_VersionLabel);
		
		version = new TextWithButton(parent, SWT.NONE, widgetFactory);
		version.setButtonText("+1");
		GridData versionData = new GridData(GridData.FILL_HORIZONTAL);
		version.setLayoutData(versionData);
		version.addButtonSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean increment = MessageDialog.openQuestion(parent.getShell(), "Increment version number", "Are you really sure you want to increment the version number ?\n"
										+ "Version number should be incremented only on major modifications.");
				if (increment == true) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(
								new PropertiesEditionEvent(RequirementPropertiesEditionPartForm.this,
									RequirementViewsRepository.Requirement_.version,
									PropertiesEditionEvent.COMMIT,
									PropertiesEditionEvent.SET,
									null,
									null));
				}
				
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						RequirementViewsRepository.Requirement_.version,
						RequirementViewsRepository.FORM_KIND),
				null);
		return parent;
	}
	// End of user code


}
