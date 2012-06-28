/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;
import org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart;
import org.obeonetwork.dsl.entityrelation.providers.EntityrelationMessages;

// End of user code

/**
 * 
 * 
 */
public class RelationElementPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RelationElementPropertiesEditionPart {

	protected Text sourceEntity;
	protected EObjectFlatComboViewer sourceAttribute;
	protected Text targetEntity;
	protected EObjectFlatComboViewer targetAttribute;
	protected Text comments;



	/**
	 * For {@link ISection} use only.
	 */
	public RelationElementPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RelationElementPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence relationElementStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = relationElementStep.addStep(EntityrelationViewsRepository.RelationElement.Properties.class);
		propertiesStep.addStep(EntityrelationViewsRepository.RelationElement.Properties.sourceEntity);
		propertiesStep.addStep(EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute);
		propertiesStep.addStep(EntityrelationViewsRepository.RelationElement.Properties.targetEntity);
		propertiesStep.addStep(EntityrelationViewsRepository.RelationElement.Properties.targetAttribute);
		propertiesStep.addStep(EntityrelationViewsRepository.RelationElement.Properties.comments);
		
		
		composer = new PartComposer(relationElementStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EntityrelationViewsRepository.RelationElement.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.RelationElement.Properties.sourceEntity) {
					return createSourceEntityText(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute) {
					return createSourceAttributeFlatComboViewer(parent, widgetFactory);
				}
				if (key == EntityrelationViewsRepository.RelationElement.Properties.targetEntity) {
					return createTargetEntityText(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.RelationElement.Properties.targetAttribute) {
					return createTargetAttributeFlatComboViewer(parent, widgetFactory);
				}
				if (key == EntityrelationViewsRepository.RelationElement.Properties.comments) {
					return createCommentsTextarea(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EntityrelationMessages.RelationElementPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createSourceEntityText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.RelationElement.Properties.sourceEntity, EntityrelationMessages.RelationElementPropertiesEditionPart_SourceEntityLabel);
		sourceEntity = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		sourceEntity.setEnabled(false);
		sourceEntity.setToolTipText(EntityrelationMessages.RelationElement_ReadOnly);
		sourceEntity.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sourceEntityData = new GridData(GridData.FILL_HORIZONTAL);
		sourceEntity.setLayoutData(sourceEntityData);
		sourceEntity.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RelationElementPropertiesEditionPartForm.this,
							EntityrelationViewsRepository.RelationElement.Properties.sourceEntity,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceEntity.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RelationElementPropertiesEditionPartForm.this,
									EntityrelationViewsRepository.RelationElement.Properties.sourceEntity,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, sourceEntity.getText()));
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
									RelationElementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		sourceEntity.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartForm.this, EntityrelationViewsRepository.RelationElement.Properties.sourceEntity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceEntity.getText()));
				}
			}
		});
		EditingUtils.setID(sourceEntity, EntityrelationViewsRepository.RelationElement.Properties.sourceEntity);
		EditingUtils.setEEFtype(sourceEntity, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.RelationElement.Properties.sourceEntity, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createSourceAttributeFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute, EntityrelationMessages.RelationElementPropertiesEditionPart_SourceAttributeLabel);
		sourceAttribute = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute, EntityrelationViewsRepository.FORM_KIND));
		widgetFactory.adapt(sourceAttribute);
		sourceAttribute.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData sourceAttributeData = new GridData(GridData.FILL_HORIZONTAL);
		sourceAttribute.setLayoutData(sourceAttributeData);
		sourceAttribute.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartForm.this, EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceAttribute()));
			}

		});
		sourceAttribute.setID(EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTargetEntityText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.RelationElement.Properties.targetEntity, EntityrelationMessages.RelationElementPropertiesEditionPart_TargetEntityLabel);
		targetEntity = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		targetEntity.setEnabled(false);
		targetEntity.setToolTipText(EntityrelationMessages.RelationElement_ReadOnly);
		targetEntity.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData targetEntityData = new GridData(GridData.FILL_HORIZONTAL);
		targetEntity.setLayoutData(targetEntityData);
		targetEntity.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RelationElementPropertiesEditionPartForm.this,
							EntityrelationViewsRepository.RelationElement.Properties.targetEntity,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetEntity.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RelationElementPropertiesEditionPartForm.this,
									EntityrelationViewsRepository.RelationElement.Properties.targetEntity,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, targetEntity.getText()));
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
									RelationElementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		targetEntity.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartForm.this, EntityrelationViewsRepository.RelationElement.Properties.targetEntity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetEntity.getText()));
				}
			}
		});
		EditingUtils.setID(targetEntity, EntityrelationViewsRepository.RelationElement.Properties.targetEntity);
		EditingUtils.setEEFtype(targetEntity, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.RelationElement.Properties.targetEntity, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createTargetAttributeFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EntityrelationViewsRepository.RelationElement.Properties.targetAttribute, EntityrelationMessages.RelationElementPropertiesEditionPart_TargetAttributeLabel);
		targetAttribute = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EntityrelationViewsRepository.RelationElement.Properties.targetAttribute, EntityrelationViewsRepository.FORM_KIND));
		widgetFactory.adapt(targetAttribute);
		targetAttribute.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData targetAttributeData = new GridData(GridData.FILL_HORIZONTAL);
		targetAttribute.setLayoutData(targetAttributeData);
		targetAttribute.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartForm.this, EntityrelationViewsRepository.RelationElement.Properties.targetAttribute, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetAttribute()));
			}

		});
		targetAttribute.setID(EntityrelationViewsRepository.RelationElement.Properties.targetAttribute);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.RelationElement.Properties.targetAttribute, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createCommentsTextarea(FormToolkit widgetFactory, Composite parent) {
		Label commentsLabel = createDescription(parent, EntityrelationViewsRepository.RelationElement.Properties.comments, EntityrelationMessages.RelationElementPropertiesEditionPart_CommentsLabel);
		GridData commentsLabelData = new GridData(GridData.FILL_HORIZONTAL);
		commentsLabelData.horizontalSpan = 3;
		commentsLabel.setLayoutData(commentsLabelData);
		comments = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL); //$NON-NLS-1$
		GridData commentsData = new GridData(GridData.FILL_HORIZONTAL);
		commentsData.horizontalSpan = 2;
		commentsData.heightHint = 80;
		commentsData.widthHint = 200;
		comments.setLayoutData(commentsData);
		comments.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RelationElementPropertiesEditionPartForm.this,
							EntityrelationViewsRepository.RelationElement.Properties.comments,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, comments.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RelationElementPropertiesEditionPartForm.this,
									EntityrelationViewsRepository.RelationElement.Properties.comments,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, comments.getText()));
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
									RelationElementPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(comments, EntityrelationViewsRepository.RelationElement.Properties.comments);
		EditingUtils.setEEFtype(comments, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.RelationElement.Properties.comments, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#getSourceEntity()
	 * 
	 */
	public String getSourceEntity() {
		return sourceEntity.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#setSourceEntity(String newValue)
	 * 
	 */
	public void setSourceEntity(String newValue) {
		if (newValue != null) {
			sourceEntity.setText(newValue);
		} else {
			sourceEntity.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#getSourceAttribute()
	 * 
	 */
	public EObject getSourceAttribute() {
		if (sourceAttribute.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) sourceAttribute.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#initSourceAttribute(EObjectFlatComboSettings)
	 */
	public void initSourceAttribute(EObjectFlatComboSettings settings) {
		sourceAttribute.setInput(settings);
		if (current != null) {
			sourceAttribute.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#setSourceAttribute(EObject newValue)
	 * 
	 */
	public void setSourceAttribute(EObject newValue) {
		if (newValue != null) {
			sourceAttribute.setSelection(new StructuredSelection(newValue));
		} else {
			sourceAttribute.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#setSourceAttributeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSourceAttributeButtonMode(ButtonsModeEnum newValue) {
		sourceAttribute.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#addFilterSourceAttribute(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSourceAttribute(ViewerFilter filter) {
		sourceAttribute.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#addBusinessFilterSourceAttribute(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSourceAttribute(ViewerFilter filter) {
		sourceAttribute.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#getTargetEntity()
	 * 
	 */
	public String getTargetEntity() {
		return targetEntity.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#setTargetEntity(String newValue)
	 * 
	 */
	public void setTargetEntity(String newValue) {
		if (newValue != null) {
			targetEntity.setText(newValue);
		} else {
			targetEntity.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#getTargetAttribute()
	 * 
	 */
	public EObject getTargetAttribute() {
		if (targetAttribute.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) targetAttribute.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#initTargetAttribute(EObjectFlatComboSettings)
	 */
	public void initTargetAttribute(EObjectFlatComboSettings settings) {
		targetAttribute.setInput(settings);
		if (current != null) {
			targetAttribute.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#setTargetAttribute(EObject newValue)
	 * 
	 */
	public void setTargetAttribute(EObject newValue) {
		if (newValue != null) {
			targetAttribute.setSelection(new StructuredSelection(newValue));
		} else {
			targetAttribute.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#setTargetAttributeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTargetAttributeButtonMode(ButtonsModeEnum newValue) {
		targetAttribute.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#addFilterTargetAttribute(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTargetAttribute(ViewerFilter filter) {
		targetAttribute.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#addBusinessFilterTargetAttribute(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTargetAttribute(ViewerFilter filter) {
		targetAttribute.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#getComments()
	 * 
	 */
	public String getComments() {
		return comments.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart#setComments(String newValue)
	 * 
	 */
	public void setComments(String newValue) {
		if (newValue != null) {
			comments.setText(newValue);
		} else {
			comments.setText(""); //$NON-NLS-1$
		}
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EntityrelationMessages.RelationElement_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
