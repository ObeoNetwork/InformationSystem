/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.entityrelation.parts.impl;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.obeonetwork.dsl.entityrelation.parts.EntityrelationViewsRepository;
import org.obeonetwork.dsl.entityrelation.parts.RelationElementPropertiesEditionPart;

import org.obeonetwork.dsl.entityrelation.providers.EntityrelationMessages;

// End of user code

/**
 * 
 * 
 */
public class RelationElementPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RelationElementPropertiesEditionPart {

	protected Text sourceEntity;
	protected EObjectFlatComboViewer sourceAttribute;
	protected Text targetEntity;
	protected EObjectFlatComboViewer targetAttribute;
	protected Text comments;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RelationElementPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
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
					return createPropertiesGroup(parent);
				}
				if (key == EntityrelationViewsRepository.RelationElement.Properties.sourceEntity) {
					return createSourceEntityText(parent);
				}
				if (key == EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute) {
					return createSourceAttributeFlatComboViewer(parent);
				}
				if (key == EntityrelationViewsRepository.RelationElement.Properties.targetEntity) {
					return createTargetEntityText(parent);
				}
				if (key == EntityrelationViewsRepository.RelationElement.Properties.targetAttribute) {
					return createTargetAttributeFlatComboViewer(parent);
				}
				if (key == EntityrelationViewsRepository.RelationElement.Properties.comments) {
					return createCommentsTextarea(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EntityrelationMessages.RelationElementPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createSourceEntityText(Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.RelationElement.Properties.sourceEntity, EntityrelationMessages.RelationElementPropertiesEditionPart_SourceEntityLabel);
		sourceEntity = SWTUtils.createScrollableText(parent, SWT.BORDER);
		sourceEntity.setEnabled(false);
		sourceEntity.setToolTipText(EntityrelationMessages.RelationElement_ReadOnly);
		GridData sourceEntityData = new GridData(GridData.FILL_HORIZONTAL);
		sourceEntity.setLayoutData(sourceEntityData);
		sourceEntity.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartImpl.this, EntityrelationViewsRepository.RelationElement.Properties.sourceEntity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceEntity.getText()));
			}

		});
		sourceEntity.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartImpl.this, EntityrelationViewsRepository.RelationElement.Properties.sourceEntity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, sourceEntity.getText()));
				}
			}

		});
		EditingUtils.setID(sourceEntity, EntityrelationViewsRepository.RelationElement.Properties.sourceEntity);
		EditingUtils.setEEFtype(sourceEntity, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.RelationElement.Properties.sourceEntity, EntityrelationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createSourceAttributeFlatComboViewer(Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute, EntityrelationMessages.RelationElementPropertiesEditionPart_SourceAttributeLabel);
		sourceAttribute = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute, EntityrelationViewsRepository.SWT_KIND));
		sourceAttribute.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		sourceAttribute.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartImpl.this, EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getSourceAttribute()));
			}

		});
		GridData sourceAttributeData = new GridData(GridData.FILL_HORIZONTAL);
		sourceAttribute.setLayoutData(sourceAttributeData);
		sourceAttribute.setID(EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.RelationElement.Properties.sourceAttribute, EntityrelationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createTargetEntityText(Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.RelationElement.Properties.targetEntity, EntityrelationMessages.RelationElementPropertiesEditionPart_TargetEntityLabel);
		targetEntity = SWTUtils.createScrollableText(parent, SWT.BORDER);
		targetEntity.setEnabled(false);
		targetEntity.setToolTipText(EntityrelationMessages.RelationElement_ReadOnly);
		GridData targetEntityData = new GridData(GridData.FILL_HORIZONTAL);
		targetEntity.setLayoutData(targetEntityData);
		targetEntity.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartImpl.this, EntityrelationViewsRepository.RelationElement.Properties.targetEntity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetEntity.getText()));
			}

		});
		targetEntity.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartImpl.this, EntityrelationViewsRepository.RelationElement.Properties.targetEntity, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, targetEntity.getText()));
				}
			}

		});
		EditingUtils.setID(targetEntity, EntityrelationViewsRepository.RelationElement.Properties.targetEntity);
		EditingUtils.setEEFtype(targetEntity, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.RelationElement.Properties.targetEntity, EntityrelationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createTargetAttributeFlatComboViewer(Composite parent) {
		createDescription(parent, EntityrelationViewsRepository.RelationElement.Properties.targetAttribute, EntityrelationMessages.RelationElementPropertiesEditionPart_TargetAttributeLabel);
		targetAttribute = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EntityrelationViewsRepository.RelationElement.Properties.targetAttribute, EntityrelationViewsRepository.SWT_KIND));
		targetAttribute.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		targetAttribute.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartImpl.this, EntityrelationViewsRepository.RelationElement.Properties.targetAttribute, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getTargetAttribute()));
			}

		});
		GridData targetAttributeData = new GridData(GridData.FILL_HORIZONTAL);
		targetAttribute.setLayoutData(targetAttributeData);
		targetAttribute.setID(EntityrelationViewsRepository.RelationElement.Properties.targetAttribute);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.RelationElement.Properties.targetAttribute, EntityrelationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createCommentsTextarea(Composite parent) {
		Label commentsLabel = createDescription(parent, EntityrelationViewsRepository.RelationElement.Properties.comments, EntityrelationMessages.RelationElementPropertiesEditionPart_CommentsLabel);
		GridData commentsLabelData = new GridData(GridData.FILL_HORIZONTAL);
		commentsLabelData.horizontalSpan = 3;
		commentsLabel.setLayoutData(commentsLabelData);
		comments = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
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
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RelationElementPropertiesEditionPartImpl.this, EntityrelationViewsRepository.RelationElement.Properties.comments, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, comments.getText()));
			}

		});
		EditingUtils.setID(comments, EntityrelationViewsRepository.RelationElement.Properties.comments);
		EditingUtils.setEEFtype(comments, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EntityrelationViewsRepository.RelationElement.Properties.comments, EntityrelationViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
