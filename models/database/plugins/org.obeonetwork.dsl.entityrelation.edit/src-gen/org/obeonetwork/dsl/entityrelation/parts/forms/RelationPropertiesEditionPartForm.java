/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;
import org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart;
import org.obeonetwork.dsl.entityrelation.providers.EntityrelationMessages;

// End of user code

/**
 * 
 * 
 */
public class RelationPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, RelationPropertiesEditionPart {

	protected Text name;
	protected EObjectFlatComboViewer identifier;
	protected EObjectFlatComboViewer source;
	protected Text sourceRole;
	protected EMFComboViewer sourceCardinality;
	protected Button sourceIsComposite;
	protected EObjectFlatComboViewer target;
	protected Text targetRole;
	protected EMFComboViewer targetCardinality;
	protected Button targetIsComposite;
	protected ReferencesTable elements;
	protected List<ViewerFilter> elementsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> elementsFilters = new ArrayList<ViewerFilter>();
	protected Text comments;



	/**
	 * For {@link ISection} use only.
	 */
	public RelationPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RelationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence relationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = relationStep.addStep(EntityrelationViewsRepository.Relation.Properties.class);
		propertiesStep.addStep(EntityrelationViewsRepository.Relation.Properties.name);
		propertiesStep.addStep(EntityrelationViewsRepository.Relation.Properties.identifier);
		CompositionStep sourceStep = propertiesStep.addStep(EntityrelationViewsRepository.Relation.Properties.Source.class);
		sourceStep.addStep(EntityrelationViewsRepository.Relation.Properties.Source.source_);
		sourceStep.addStep(EntityrelationViewsRepository.Relation.Properties.Source.sourceRole);
		sourceStep.addStep(EntityrelationViewsRepository.Relation.Properties.Source.sourceCardinality);
		sourceStep.addStep(EntityrelationViewsRepository.Relation.Properties.Source.sourceIsComposite);
		
		CompositionStep targetStep = propertiesStep.addStep(EntityrelationViewsRepository.Relation.Properties.Target.class);
		targetStep.addStep(EntityrelationViewsRepository.Relation.Properties.Target.target_);
		targetStep.addStep(EntityrelationViewsRepository.Relation.Properties.Target.targetRole);
		targetStep.addStep(EntityrelationViewsRepository.Relation.Properties.Target.targetCardinality);
		targetStep.addStep(EntityrelationViewsRepository.Relation.Properties.Target.targetIsComposite);
		
		propertiesStep.addStep(EntityrelationViewsRepository.Relation.Properties.elements);
		propertiesStep.addStep(EntityrelationViewsRepository.Relation.Properties.comments);
		
		
		composer = new PartComposer(relationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EntityrelationViewsRepository.Relation.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.identifier) {
					return createIdentifierFlatComboViewer(parent, widgetFactory);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.Source.class) {
					return createSourceGroup(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.Source.source_) {
					return createSourceFlatComboViewer(parent, widgetFactory);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.Source.sourceRole) {
					return createSourceRoleText(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.Source.sourceCardinality) {
					return createSourceCardinalityEMFComboViewer(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.Source.sourceIsComposite) {
					return createSourceIsCompositeCheckbox(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.Target.class) {
					return createTargetGroup(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.Target.target_) {
					return createTargetFlatComboViewer(parent, widgetFactory);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.Target.targetRole) {
					return createTargetRoleText(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.Target.targetCardinality) {
					return createTargetCardinalityEMFComboViewer(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.Target.targetIsComposite) {
					return createTargetIsCompositeCheckbox(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.elements) {
					return createElementsTableComposition(widgetFactory, parent);
				}
				if (key == EntityrelationViewsRepository.Relation.Properties.comments) {
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
		propertiesSection.setText(EntityrelationMessages.RelationPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.Relation.Properties.name, EntityrelationMessages.RelationPropertiesEditionPart_NameLabel);
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
							RelationPropertiesEditionPartForm.this,
							EntityrelationViewsRepository.Relation.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RelationPropertiesEditionPartForm.this,
									EntityrelationViewsRepository.Relation.Properties.name,
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
									RelationPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EntityrelationViewsRepository.Relation.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.name, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createIdentifierFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EntityrelationViewsRepository.Relation.Properties.identifier, EntityrelationMessages.RelationPropertiesEditionPart_IdentifierLabel);
		identifier = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EntityrelationViewsRepository.Relation.Properties.identifier, EntityrelationViewsRepository.FORM_KIND));
		widgetFactory.adapt(identifier);
		identifier.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData identifierData = new GridData(GridData.FILL_HORIZONTAL);
		identifier.setLayoutData(identifierData);
		identifier.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.identifier, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getIdentifier()));
			}

		});
		identifier.setID(EntityrelationViewsRepository.Relation.Properties.identifier);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.identifier, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createSourceGroup(FormToolkit widgetFactory, final Composite parent) {
		Section sourceSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		sourceSection.setText(EntityrelationMessages.RelationPropertiesEditionPart_SourceGroupLabel);
		GridData sourceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		sourceSectionData.horizontalSpan = 3;
		sourceSection.setLayoutData(sourceSectionData);
		Composite sourceGroup = widgetFactory.createComposite(sourceSection);
		GridLayout sourceGroupLayout = new GridLayout();
		sourceGroupLayout.numColumns = 3;
		sourceGroup.setLayout(sourceGroupLayout);
		sourceSection.setClient(sourceGroup);
		return sourceGroup;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createSourceFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EntityrelationViewsRepository.Relation.Properties.Source.source_, EntityrelationMessages.RelationPropertiesEditionPart_SourceLabel);
		source = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EntityrelationViewsRepository.Relation.Properties.Source.source_, EntityrelationViewsRepository.FORM_KIND));
		widgetFactory.adapt(source);
		source.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
		source.setLayoutData(sourceData);
		source.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.Source.source_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSource()));
			}

		});
		source.setID(EntityrelationViewsRepository.Relation.Properties.Source.source_);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.Source.source_, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSourceRoleText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.Relation.Properties.Source.sourceRole, EntityrelationMessages.RelationPropertiesEditionPart_SourceRoleLabel);
		sourceRole = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		sourceRole.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sourceRoleData = new GridData(GridData.FILL_HORIZONTAL);
		sourceRole.setLayoutData(sourceRoleData);
		sourceRole.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RelationPropertiesEditionPartForm.this,
							EntityrelationViewsRepository.Relation.Properties.Source.sourceRole,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceRole.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RelationPropertiesEditionPartForm.this,
									EntityrelationViewsRepository.Relation.Properties.Source.sourceRole,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, sourceRole.getText()));
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
									RelationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		sourceRole.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.Source.sourceRole, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceRole.getText()));
				}
			}
		});
		EditingUtils.setID(sourceRole, EntityrelationViewsRepository.Relation.Properties.Source.sourceRole);
		EditingUtils.setEEFtype(sourceRole, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.Source.sourceRole, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSourceCardinalityEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.Relation.Properties.Source.sourceCardinality, EntityrelationMessages.RelationPropertiesEditionPart_SourceCardinalityLabel);
		sourceCardinality = new EMFComboViewer(parent);
		sourceCardinality.setContentProvider(new ArrayContentProvider());
		sourceCardinality.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sourceCardinalityData = new GridData(GridData.FILL_HORIZONTAL);
		sourceCardinality.getCombo().setLayoutData(sourceCardinalityData);
		sourceCardinality.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.Source.sourceCardinality, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceCardinality()));
			}

		});
		sourceCardinality.setID(EntityrelationViewsRepository.Relation.Properties.Source.sourceCardinality);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.Source.sourceCardinality, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSourceIsCompositeCheckbox(FormToolkit widgetFactory, Composite parent) {
		sourceIsComposite = widgetFactory.createButton(parent, getDescription(EntityrelationViewsRepository.Relation.Properties.Source.sourceIsComposite, EntityrelationMessages.RelationPropertiesEditionPart_SourceIsCompositeLabel), SWT.CHECK);
		sourceIsComposite.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.Source.sourceIsComposite, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(sourceIsComposite.getSelection())));
			}

		});
		GridData sourceIsCompositeData = new GridData(GridData.FILL_HORIZONTAL);
		sourceIsCompositeData.horizontalSpan = 2;
		sourceIsComposite.setLayoutData(sourceIsCompositeData);
		EditingUtils.setID(sourceIsComposite, EntityrelationViewsRepository.Relation.Properties.Source.sourceIsComposite);
		EditingUtils.setEEFtype(sourceIsComposite, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.Source.sourceIsComposite, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createTargetGroup(FormToolkit widgetFactory, final Composite parent) {
		Section targetSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		targetSection.setText(EntityrelationMessages.RelationPropertiesEditionPart_TargetGroupLabel);
		GridData targetSectionData = new GridData(GridData.FILL_HORIZONTAL);
		targetSectionData.horizontalSpan = 3;
		targetSection.setLayoutData(targetSectionData);
		Composite targetGroup = widgetFactory.createComposite(targetSection);
		GridLayout targetGroupLayout = new GridLayout();
		targetGroupLayout.numColumns = 3;
		targetGroup.setLayout(targetGroupLayout);
		targetSection.setClient(targetGroup);
		return targetGroup;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createTargetFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EntityrelationViewsRepository.Relation.Properties.Target.target_, EntityrelationMessages.RelationPropertiesEditionPart_TargetLabel);
		target = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EntityrelationViewsRepository.Relation.Properties.Target.target_, EntityrelationViewsRepository.FORM_KIND));
		widgetFactory.adapt(target);
		target.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData targetData = new GridData(GridData.FILL_HORIZONTAL);
		target.setLayoutData(targetData);
		target.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.Target.target_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTarget()));
			}

		});
		target.setID(EntityrelationViewsRepository.Relation.Properties.Target.target_);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.Target.target_, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTargetRoleText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.Relation.Properties.Target.targetRole, EntityrelationMessages.RelationPropertiesEditionPart_TargetRoleLabel);
		targetRole = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		targetRole.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData targetRoleData = new GridData(GridData.FILL_HORIZONTAL);
		targetRole.setLayoutData(targetRoleData);
		targetRole.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							RelationPropertiesEditionPartForm.this,
							EntityrelationViewsRepository.Relation.Properties.Target.targetRole,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetRole.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RelationPropertiesEditionPartForm.this,
									EntityrelationViewsRepository.Relation.Properties.Target.targetRole,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, targetRole.getText()));
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
									RelationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		targetRole.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.Target.targetRole, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetRole.getText()));
				}
			}
		});
		EditingUtils.setID(targetRole, EntityrelationViewsRepository.Relation.Properties.Target.targetRole);
		EditingUtils.setEEFtype(targetRole, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.Target.targetRole, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTargetCardinalityEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.Relation.Properties.Target.targetCardinality, EntityrelationMessages.RelationPropertiesEditionPart_TargetCardinalityLabel);
		targetCardinality = new EMFComboViewer(parent);
		targetCardinality.setContentProvider(new ArrayContentProvider());
		targetCardinality.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData targetCardinalityData = new GridData(GridData.FILL_HORIZONTAL);
		targetCardinality.getCombo().setLayoutData(targetCardinalityData);
		targetCardinality.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.Target.targetCardinality, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetCardinality()));
			}

		});
		targetCardinality.setID(EntityrelationViewsRepository.Relation.Properties.Target.targetCardinality);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.Target.targetCardinality, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTargetIsCompositeCheckbox(FormToolkit widgetFactory, Composite parent) {
		targetIsComposite = widgetFactory.createButton(parent, getDescription(EntityrelationViewsRepository.Relation.Properties.Target.targetIsComposite, EntityrelationMessages.RelationPropertiesEditionPart_TargetIsCompositeLabel), SWT.CHECK);
		targetIsComposite.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.Target.targetIsComposite, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(targetIsComposite.getSelection())));
			}

		});
		GridData targetIsCompositeData = new GridData(GridData.FILL_HORIZONTAL);
		targetIsCompositeData.horizontalSpan = 2;
		targetIsComposite.setLayoutData(targetIsCompositeData);
		EditingUtils.setID(targetIsComposite, EntityrelationViewsRepository.Relation.Properties.Target.targetIsComposite);
		EditingUtils.setEEFtype(targetIsComposite, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.Target.targetIsComposite, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createElementsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.elements = new ReferencesTable(getDescription(EntityrelationViewsRepository.Relation.Properties.elements, EntityrelationMessages.RelationPropertiesEditionPart_ElementsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.elements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				elements.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.elements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				elements.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.elements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				elements.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.elements, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				elements.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.elementsFilters) {
			this.elements.addFilter(filter);
		}
		this.elements.setHelpText(propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.elements, EntityrelationViewsRepository.FORM_KIND));
		this.elements.createControls(parent, widgetFactory);
		this.elements.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationPropertiesEditionPartForm.this, EntityrelationViewsRepository.Relation.Properties.elements, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData elementsData = new GridData(GridData.FILL_HORIZONTAL);
		elementsData.horizontalSpan = 3;
		this.elements.setLayoutData(elementsData);
		this.elements.setLowerBound(0);
		this.elements.setUpperBound(-1);
		elements.setID(EntityrelationViewsRepository.Relation.Properties.elements);
		elements.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createCommentsTextarea(FormToolkit widgetFactory, Composite parent) {
		Label commentsLabel = createDescription(parent, EntityrelationViewsRepository.Relation.Properties.comments, EntityrelationMessages.RelationPropertiesEditionPart_CommentsLabel);
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
							RelationPropertiesEditionPartForm.this,
							EntityrelationViewsRepository.Relation.Properties.comments,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, comments.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									RelationPropertiesEditionPartForm.this,
									EntityrelationViewsRepository.Relation.Properties.comments,
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
									RelationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(comments, EntityrelationViewsRepository.Relation.Properties.comments);
		EditingUtils.setEEFtype(comments, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.Relation.Properties.comments, EntityrelationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setName(String newValue)
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
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getIdentifier()
	 * 
	 */
	public EObject getIdentifier() {
		if (identifier.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) identifier.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#initIdentifier(EObjectFlatComboSettings)
	 */
	public void initIdentifier(EObjectFlatComboSettings settings) {
		identifier.setInput(settings);
		if (current != null) {
			identifier.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setIdentifier(EObject newValue)
	 * 
	 */
	public void setIdentifier(EObject newValue) {
		if (newValue != null) {
			identifier.setSelection(new StructuredSelection(newValue));
		} else {
			identifier.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setIdentifierButtonMode(ButtonsModeEnum newValue)
	 */
	public void setIdentifierButtonMode(ButtonsModeEnum newValue) {
		identifier.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#addFilterIdentifier(ViewerFilter filter)
	 * 
	 */
	public void addFilterToIdentifier(ViewerFilter filter) {
		identifier.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#addBusinessFilterIdentifier(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToIdentifier(ViewerFilter filter) {
		identifier.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getSource()
	 * 
	 */
	public EObject getSource() {
		if (source.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) source.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#initSource(EObjectFlatComboSettings)
	 */
	public void initSource(EObjectFlatComboSettings settings) {
		source.setInput(settings);
		if (current != null) {
			source.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setSource(EObject newValue)
	 * 
	 */
	public void setSource(EObject newValue) {
		if (newValue != null) {
			source.setSelection(new StructuredSelection(newValue));
		} else {
			source.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setSourceButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSourceButtonMode(ButtonsModeEnum newValue) {
		source.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#addFilterSource(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSource(ViewerFilter filter) {
		source.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#addBusinessFilterSource(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSource(ViewerFilter filter) {
		source.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getSourceRole()
	 * 
	 */
	public String getSourceRole() {
		return sourceRole.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setSourceRole(String newValue)
	 * 
	 */
	public void setSourceRole(String newValue) {
		if (newValue != null) {
			sourceRole.setText(newValue);
		} else {
			sourceRole.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getSourceCardinality()
	 * 
	 */
	public Enumerator getSourceCardinality() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sourceCardinality.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#initSourceCardinality(Object input, Enumerator current)
	 */
	public void initSourceCardinality(Object input, Enumerator current) {
		sourceCardinality.setInput(input);
		sourceCardinality.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setSourceCardinality(Enumerator newValue)
	 * 
	 */
	public void setSourceCardinality(Enumerator newValue) {
		sourceCardinality.modelUpdating(new StructuredSelection(newValue));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getSourceIsComposite()
	 * 
	 */
	public Boolean getSourceIsComposite() {
		return Boolean.valueOf(sourceIsComposite.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setSourceIsComposite(Boolean newValue)
	 * 
	 */
	public void setSourceIsComposite(Boolean newValue) {
		if (newValue != null) {
			sourceIsComposite.setSelection(newValue.booleanValue());
		} else {
			sourceIsComposite.setSelection(false);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getTarget()
	 * 
	 */
	public EObject getTarget() {
		if (target.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) target.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#initTarget(EObjectFlatComboSettings)
	 */
	public void initTarget(EObjectFlatComboSettings settings) {
		target.setInput(settings);
		if (current != null) {
			target.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setTarget(EObject newValue)
	 * 
	 */
	public void setTarget(EObject newValue) {
		if (newValue != null) {
			target.setSelection(new StructuredSelection(newValue));
		} else {
			target.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setTargetButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTargetButtonMode(ButtonsModeEnum newValue) {
		target.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#addFilterTarget(ViewerFilter filter)
	 * 
	 */
	public void addFilterToTarget(ViewerFilter filter) {
		target.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#addBusinessFilterTarget(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToTarget(ViewerFilter filter) {
		target.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getTargetRole()
	 * 
	 */
	public String getTargetRole() {
		return targetRole.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setTargetRole(String newValue)
	 * 
	 */
	public void setTargetRole(String newValue) {
		if (newValue != null) {
			targetRole.setText(newValue);
		} else {
			targetRole.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getTargetCardinality()
	 * 
	 */
	public Enumerator getTargetCardinality() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetCardinality.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#initTargetCardinality(Object input, Enumerator current)
	 */
	public void initTargetCardinality(Object input, Enumerator current) {
		targetCardinality.setInput(input);
		targetCardinality.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setTargetCardinality(Enumerator newValue)
	 * 
	 */
	public void setTargetCardinality(Enumerator newValue) {
		targetCardinality.modelUpdating(new StructuredSelection(newValue));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getTargetIsComposite()
	 * 
	 */
	public Boolean getTargetIsComposite() {
		return Boolean.valueOf(targetIsComposite.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setTargetIsComposite(Boolean newValue)
	 * 
	 */
	public void setTargetIsComposite(Boolean newValue) {
		if (newValue != null) {
			targetIsComposite.setSelection(newValue.booleanValue());
		} else {
			targetIsComposite.setSelection(false);
		}
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#initElements(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initElements(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		elements.setContentProvider(contentProvider);
		elements.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#updateElements()
	 * 
	 */
	public void updateElements() {
	elements.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#addFilterElements(ViewerFilter filter)
	 * 
	 */
	public void addFilterToElements(ViewerFilter filter) {
		elementsFilters.add(filter);
		if (this.elements != null) {
			this.elements.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#addBusinessFilterElements(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToElements(ViewerFilter filter) {
		elementsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#isContainedInElementsTable(EObject element)
	 * 
	 */
	public boolean isContainedInElementsTable(EObject element) {
		return ((ReferencesTableSettings)elements.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#getComments()
	 * 
	 */
	public String getComments() {
		return comments.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.entityrelation.parts.RelationPropertiesEditionPart#setComments(String newValue)
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
		return EntityrelationMessages.Relation_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
