/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.requirement.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;
import org.obeonetwork.dsl.requirement.providers.RequirementMessages;

// End of user code

/**
 * 
 * 
 */
public class RequirementPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RequirementPropertiesEditionPart {

	protected EMFComboViewer type;
	protected Text subtype;
	protected Text id;
	protected Text name;
	// Start of user code  for version widgets declarations
	
	// End of user code

	protected Text status;
	protected Text statement;
	protected Text modifiedOn;
	protected Text createdOn;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RequirementPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
					return createTypeEMFComboViewer(parent);
				}
				if (key == RequirementViewsRepository.Requirement_.subtype) {
					return createSubtypeText(parent);
				}
				if (key == RequirementViewsRepository.Requirement_.id) {
					return createIdText(parent);
				}
				if (key == RequirementViewsRepository.Requirement_.name) {
					return createNameText(parent);
				}
				// Start of user code for version addToPart creation
				
				// End of user code
				if (key == RequirementViewsRepository.Requirement_.status) {
					return createStatusText(parent);
				}
				if (key == RequirementViewsRepository.Requirement_.statement) {
					return createStatementTextarea(parent);
				}
				if (key == RequirementViewsRepository.Requirement_.modifiedOn) {
					return createModifiedOnText(parent);
				}
				if (key == RequirementViewsRepository.Requirement_.createdOn) {
					return createCreatedOnText(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	
	protected Composite createTypeEMFComboViewer(Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getType()));
			}

		});
		type.setID(RequirementViewsRepository.Requirement_.type);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.type, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createSubtypeText(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.subtype, RequirementMessages.RequirementPropertiesEditionPart_SubtypeLabel);
		subtype = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData subtypeData = new GridData(GridData.FILL_HORIZONTAL);
		subtype.setLayoutData(subtypeData);
		subtype.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.subtype, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, subtype.getText()));
			}

		});
		subtype.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.subtype, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, subtype.getText()));
				}
			}

		});
		EditingUtils.setID(subtype, RequirementViewsRepository.Requirement_.subtype);
		EditingUtils.setEEFtype(subtype, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.subtype, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createSubtypeText

		// End of user code
		return parent;
	}

	
	protected Composite createIdText(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.id, RequirementMessages.RequirementPropertiesEditionPart_IdLabel);
		id = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData idData = new GridData(GridData.FILL_HORIZONTAL);
		id.setLayoutData(idData);
		id.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
			}

		});
		id.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
				}
			}

		});
		EditingUtils.setID(id, RequirementViewsRepository.Requirement_.id);
		EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.id, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createIdText

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.name, RequirementMessages.RequirementPropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, RequirementViewsRepository.Requirement_.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.name, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createStatusText(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.status, RequirementMessages.RequirementPropertiesEditionPart_StatusLabel);
		status = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData statusData = new GridData(GridData.FILL_HORIZONTAL);
		status.setLayoutData(statusData);
		status.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.status, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, status.getText()));
			}

		});
		status.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.status, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, status.getText()));
				}
			}

		});
		EditingUtils.setID(status, RequirementViewsRepository.Requirement_.status);
		EditingUtils.setEEFtype(status, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.status, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatusText

		// End of user code
		return parent;
	}

	
	protected Composite createStatementTextarea(Composite parent) {
		Label statementLabel = createDescription(parent, RequirementViewsRepository.Requirement_.statement, RequirementMessages.RequirementPropertiesEditionPart_StatementLabel);
		GridData statementLabelData = new GridData(GridData.FILL_HORIZONTAL);
		statementLabelData.horizontalSpan = 3;
		statementLabel.setLayoutData(statementLabelData);
		statement = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
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
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.statement, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, statement.getText()));
			}

		});
		EditingUtils.setID(statement, RequirementViewsRepository.Requirement_.statement);
		EditingUtils.setEEFtype(statement, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.statement, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createStatementTextArea

		// End of user code
		return parent;
	}

	
	protected Composite createModifiedOnText(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.modifiedOn, RequirementMessages.RequirementPropertiesEditionPart_ModifiedOnLabel);
		modifiedOn = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData modifiedOnData = new GridData(GridData.FILL_HORIZONTAL);
		modifiedOn.setLayoutData(modifiedOnData);
		modifiedOn.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.modifiedOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modifiedOn.getText()));
			}

		});
		modifiedOn.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.modifiedOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modifiedOn.getText()));
				}
			}

		});
		EditingUtils.setID(modifiedOn, RequirementViewsRepository.Requirement_.modifiedOn);
		EditingUtils.setEEFtype(modifiedOn, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.modifiedOn, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createModifiedOnText

		// End of user code
		return parent;
	}

	
	protected Composite createCreatedOnText(Composite parent) {
		createDescription(parent, RequirementViewsRepository.Requirement_.createdOn, RequirementMessages.RequirementPropertiesEditionPart_CreatedOnLabel);
		createdOn = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData createdOnData = new GridData(GridData.FILL_HORIZONTAL);
		createdOn.setLayoutData(createdOnData);
		createdOn.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.createdOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, createdOn.getText()));
			}

		});
		createdOn.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.createdOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, createdOn.getText()));
				}
			}

		});
		EditingUtils.setID(createdOn, RequirementViewsRepository.Requirement_.createdOn);
		EditingUtils.setEEFtype(createdOn, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.createdOn, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCreatedOnText

		// End of user code
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
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Requirement_.type);
		if (eefElementEditorReadOnlyState && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.requirement.parts.RequirementPropertiesEditionPart#setType(Enumerator newValue)
	 * 
	 */
	public void setType(Enumerator newValue) {
		type.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Requirement_.type);
		if (eefElementEditorReadOnlyState && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
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
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Requirement_.subtype);
		if (eefElementEditorReadOnlyState && subtype.isEnabled()) {
			subtype.setEnabled(false);
			subtype.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !subtype.isEnabled()) {
			subtype.setEnabled(true);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Requirement_.id);
		if (eefElementEditorReadOnlyState && id.isEnabled()) {
			id.setEnabled(false);
			id.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !id.isEnabled()) {
			id.setEnabled(true);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Requirement_.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Requirement_.status);
		if (eefElementEditorReadOnlyState && status.isEnabled()) {
			status.setEnabled(false);
			status.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !status.isEnabled()) {
			status.setEnabled(true);
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
		boolean eefElementEditorReadOnlyState = isReadOnly(RequirementViewsRepository.Requirement_.statement);
		if (eefElementEditorReadOnlyState && statement.isEnabled()) {
			statement.setEnabled(false);
			statement.setBackground(statement.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			statement.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !statement.isEnabled()) {
			statement.setEnabled(true);
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
		modifiedOn.setEnabled(false);
		modifiedOn.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		
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
		createdOn.setEnabled(false);
		createdOn.setToolTipText(RequirementMessages.Requirement_ReadOnly);
		
	}






	// Start of user code for version specific getters and setters implementation
	
	public Integer getVersion() {
		return null;
	}

	public void setVersion(Integer newValue) {

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
	
	// End of user code


}
