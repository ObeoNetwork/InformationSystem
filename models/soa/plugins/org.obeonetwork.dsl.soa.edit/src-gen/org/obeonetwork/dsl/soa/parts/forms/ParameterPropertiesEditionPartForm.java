/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.AdvancedEObjectFlatComboViewer.EObjectFlatComboViewerListener;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
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
import org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart;
import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;
import org.obeonetwork.dsl.soa.providers.SoaMessages;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>J�r�me Benois</a>
 * 
 */
public class ParameterPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ParameterPropertiesEditionPart {

	protected Text name;
	protected Text lower;
	protected Text upper;
	protected Button isUnique;
	protected Button isOrdered;
	protected AdvancedEObjectFlatComboViewer type;
	protected ViewerFilter typeFilter;
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public ParameterPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ParameterPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence parameterStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = parameterStep.addStep(SoaViewsRepository.Parameter.Properties.class);
		propertiesStep.addStep(SoaViewsRepository.Parameter.Properties.name);
		propertiesStep.addStep(SoaViewsRepository.Parameter.Properties.lower);
		propertiesStep.addStep(SoaViewsRepository.Parameter.Properties.upper);
		propertiesStep.addStep(SoaViewsRepository.Parameter.Properties.isUnique);
		propertiesStep.addStep(SoaViewsRepository.Parameter.Properties.isOrdered);
		propertiesStep.addStep(SoaViewsRepository.Parameter.Properties.type);
		propertiesStep.addStep(SoaViewsRepository.Parameter.Properties.description);
		
		
		composer = new PartComposer(parameterStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == SoaViewsRepository.Parameter.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == SoaViewsRepository.Parameter.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == SoaViewsRepository.Parameter.Properties.lower) {
					return createLowerText(widgetFactory, parent);
				}
				if (key == SoaViewsRepository.Parameter.Properties.upper) {
					return createUpperText(widgetFactory, parent);
				}
				if (key == SoaViewsRepository.Parameter.Properties.isUnique) {
					return createIsUniqueCheckbox(widgetFactory, parent);
				}
				if (key == SoaViewsRepository.Parameter.Properties.isOrdered) {
					return createIsOrderedCheckbox(widgetFactory, parent);
				}
				if (key == SoaViewsRepository.Parameter.Properties.type) {
					return createTypeFlatComboViewer(parent, widgetFactory);
				}
				if (key == SoaViewsRepository.Parameter.Properties.description) {
					return createDescriptionTextarea(widgetFactory, parent);
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
		propertiesSection.setText(SoaMessages.ParameterPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, SoaViewsRepository.Parameter.Properties.name, SoaMessages.ParameterPropertiesEditionPart_NameLabel);
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
							ParameterPropertiesEditionPartForm.this,
							SoaViewsRepository.Parameter.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ParameterPropertiesEditionPartForm.this,
									SoaViewsRepository.Parameter.Properties.name,
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
									ParameterPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartForm.this, SoaViewsRepository.Parameter.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, SoaViewsRepository.Parameter.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Parameter.Properties.name, SoaViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createLowerText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, SoaViewsRepository.Parameter.Properties.lower, SoaMessages.ParameterPropertiesEditionPart_LowerLabel);
		lower = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		lower.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData lowerData = new GridData(GridData.FILL_HORIZONTAL);
		lower.setLayoutData(lowerData);
		lower.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ParameterPropertiesEditionPartForm.this,
							SoaViewsRepository.Parameter.Properties.lower,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lower.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ParameterPropertiesEditionPartForm.this,
									SoaViewsRepository.Parameter.Properties.lower,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, lower.getText()));
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
									ParameterPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		lower.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartForm.this, SoaViewsRepository.Parameter.Properties.lower, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, lower.getText()));
				}
			}
		});
		EditingUtils.setID(lower, SoaViewsRepository.Parameter.Properties.lower);
		EditingUtils.setEEFtype(lower, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Parameter.Properties.lower, SoaViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createUpperText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, SoaViewsRepository.Parameter.Properties.upper, SoaMessages.ParameterPropertiesEditionPart_UpperLabel);
		upper = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		upper.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData upperData = new GridData(GridData.FILL_HORIZONTAL);
		upper.setLayoutData(upperData);
		upper.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ParameterPropertiesEditionPartForm.this,
							SoaViewsRepository.Parameter.Properties.upper,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upper.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ParameterPropertiesEditionPartForm.this,
									SoaViewsRepository.Parameter.Properties.upper,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, upper.getText()));
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
									ParameterPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		upper.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartForm.this, SoaViewsRepository.Parameter.Properties.upper, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, upper.getText()));
				}
			}
		});
		EditingUtils.setID(upper, SoaViewsRepository.Parameter.Properties.upper);
		EditingUtils.setEEFtype(upper, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Parameter.Properties.upper, SoaViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createIsUniqueCheckbox(FormToolkit widgetFactory, Composite parent) {
		isUnique = widgetFactory.createButton(parent, getDescription(SoaViewsRepository.Parameter.Properties.isUnique, SoaMessages.ParameterPropertiesEditionPart_IsUniqueLabel), SWT.CHECK);
		isUnique.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartForm.this, SoaViewsRepository.Parameter.Properties.isUnique, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isUnique.getSelection())));
			}

		});
		GridData isUniqueData = new GridData(GridData.FILL_HORIZONTAL);
		isUniqueData.horizontalSpan = 2;
		isUnique.setLayoutData(isUniqueData);
		EditingUtils.setID(isUnique, SoaViewsRepository.Parameter.Properties.isUnique);
		EditingUtils.setEEFtype(isUnique, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Parameter.Properties.isUnique, SoaViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createIsOrderedCheckbox(FormToolkit widgetFactory, Composite parent) {
		isOrdered = widgetFactory.createButton(parent, getDescription(SoaViewsRepository.Parameter.Properties.isOrdered, SoaMessages.ParameterPropertiesEditionPart_IsOrderedLabel), SWT.CHECK);
		isOrdered.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartForm.this, SoaViewsRepository.Parameter.Properties.isOrdered, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(isOrdered.getSelection())));
			}

		});
		GridData isOrderedData = new GridData(GridData.FILL_HORIZONTAL);
		isOrderedData.horizontalSpan = 2;
		isOrdered.setLayoutData(isOrderedData);
		EditingUtils.setID(isOrdered, SoaViewsRepository.Parameter.Properties.isOrdered);
		EditingUtils.setEEFtype(isOrdered, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Parameter.Properties.isOrdered, SoaViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createTypeFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, SoaViewsRepository.Parameter.Properties.type, SoaMessages.ParameterPropertiesEditionPart_TypeLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartForm.this, SoaViewsRepository.Parameter.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParameterPropertiesEditionPartForm.this, SoaViewsRepository.Parameter.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return null;
			}

		};
		//create widget
		type = new AdvancedEObjectFlatComboViewer(SoaMessages.ParameterPropertiesEditionPart_TypeLabel, resourceSet, typeFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		type.createControls(parent, widgetFactory);
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.setLayoutData(typeData);
		type.setID(SoaViewsRepository.Parameter.Properties.type);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Parameter.Properties.type, SoaViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}


	
	protected Composite createDescriptionTextarea(FormToolkit widgetFactory, Composite parent) {
		Label descriptionLabel = createDescription(parent, SoaViewsRepository.Parameter.Properties.description, SoaMessages.ParameterPropertiesEditionPart_DescriptionLabel);
		GridData descriptionLabelData = new GridData(GridData.FILL_HORIZONTAL);
		descriptionLabelData.horizontalSpan = 3;
		descriptionLabel.setLayoutData(descriptionLabelData);
		description = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL); //$NON-NLS-1$
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		descriptionData.horizontalSpan = 2;
		descriptionData.heightHint = 80;
		descriptionData.widthHint = 200;
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ParameterPropertiesEditionPartForm.this,
							SoaViewsRepository.Parameter.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ParameterPropertiesEditionPartForm.this,
									SoaViewsRepository.Parameter.Properties.description,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, description.getText()));
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
									ParameterPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(description, SoaViewsRepository.Parameter.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Parameter.Properties.description, SoaViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(SoaViewsRepository.Parameter.Properties.name);
		if (readOnly && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(SoaMessages.Parameter_ReadOnly);
		} else if (!readOnly && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#getLower()
	 * 
	 */
	public String getLower() {
		return lower.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#setLower(String newValue)
	 * 
	 */
	public void setLower(String newValue) {
		if (newValue != null) {
			lower.setText(newValue);
		} else {
			lower.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(SoaViewsRepository.Parameter.Properties.lower);
		if (readOnly && lower.isEnabled()) {
			lower.setEnabled(false);
			lower.setToolTipText(SoaMessages.Parameter_ReadOnly);
		} else if (!readOnly && !lower.isEnabled()) {
			lower.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#getUpper()
	 * 
	 */
	public String getUpper() {
		return upper.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#setUpper(String newValue)
	 * 
	 */
	public void setUpper(String newValue) {
		if (newValue != null) {
			upper.setText(newValue);
		} else {
			upper.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(SoaViewsRepository.Parameter.Properties.upper);
		if (readOnly && upper.isEnabled()) {
			upper.setEnabled(false);
			upper.setToolTipText(SoaMessages.Parameter_ReadOnly);
		} else if (!readOnly && !upper.isEnabled()) {
			upper.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#getIsUnique()
	 * 
	 */
	public Boolean getIsUnique() {
		return Boolean.valueOf(isUnique.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#setIsUnique(Boolean newValue)
	 * 
	 */
	public void setIsUnique(Boolean newValue) {
		if (newValue != null) {
			isUnique.setSelection(newValue.booleanValue());
		} else {
			isUnique.setSelection(false);
		}
		boolean readOnly = isReadOnly(SoaViewsRepository.Parameter.Properties.isUnique);
		if (readOnly && isUnique.isEnabled()) {
			isUnique.setEnabled(false);
			isUnique.setToolTipText(SoaMessages.Parameter_ReadOnly);
		} else if (!readOnly && !isUnique.isEnabled()) {
			isUnique.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#getIsOrdered()
	 * 
	 */
	public Boolean getIsOrdered() {
		return Boolean.valueOf(isOrdered.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#setIsOrdered(Boolean newValue)
	 * 
	 */
	public void setIsOrdered(Boolean newValue) {
		if (newValue != null) {
			isOrdered.setSelection(newValue.booleanValue());
		} else {
			isOrdered.setSelection(false);
		}
		boolean readOnly = isReadOnly(SoaViewsRepository.Parameter.Properties.isOrdered);
		if (readOnly && isOrdered.isEnabled()) {
			isOrdered.setEnabled(false);
			isOrdered.setToolTipText(SoaMessages.Parameter_ReadOnly);
		} else if (!readOnly && !isOrdered.isEnabled()) {
			isOrdered.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#getType()
	 * 
	 */
	public EObject getType() {
		return type.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#initType(EObjectFlatComboSettings)
	 */
	public void initType(EObjectFlatComboSettings settings) {
		type.setInput(settings);
		if (current != null) {
			type.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean readOnly = isReadOnly(SoaViewsRepository.Parameter.Properties.type);
		if (readOnly && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(SoaMessages.Parameter_ReadOnly);
		} else if (!readOnly && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#setType(EObject newValue)
	 * 
	 */
	public void setType(EObject newValue) {
		if (newValue != null) {
			type.setSelection(new StructuredSelection(newValue));
		} else {
			type.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(SoaViewsRepository.Parameter.Properties.type);
		if (readOnly && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(SoaMessages.Parameter_ReadOnly);
		} else if (!readOnly && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#setTypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setTypeButtonMode(ButtonsModeEnum newValue) {
		type.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#addFilterType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToType(ViewerFilter filter) {
		type.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#addBusinessFilterType(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToType(ViewerFilter filter) {
		type.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.ParameterPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(SoaViewsRepository.Parameter.Properties.description);
		if (readOnly && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(SoaMessages.Parameter_ReadOnly);
		} else if (!readOnly && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return SoaMessages.Parameter_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
