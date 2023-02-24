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
import org.obeonetwork.dsl.soa.parts.SoaViewsRepository;
import org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart;
import org.obeonetwork.dsl.soa.providers.SoaMessages;

// End of user code

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jerome Benois</a>
 * 
 */
public class WirePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, WirePropertiesEditionPart {

	protected AdvancedEObjectFlatComboViewer source;
	protected ViewerFilter sourceFilter;
	protected AdvancedEObjectFlatComboViewer dest;
	protected ViewerFilter destFilter;
	protected Text description;



	/**
	 * For {@link ISection} use only.
	 */
	public WirePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public WirePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence wireStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = wireStep.addStep(SoaViewsRepository.Wire.Properties.class);
		propertiesStep.addStep(SoaViewsRepository.Wire.Properties.source);
		propertiesStep.addStep(SoaViewsRepository.Wire.Properties.dest);
		propertiesStep.addStep(SoaViewsRepository.Wire.Properties.description);
		
		
		composer = new PartComposer(wireStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == SoaViewsRepository.Wire.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == SoaViewsRepository.Wire.Properties.source) {
					return createSourceFlatComboViewer(parent, widgetFactory);
				}
				if (key == SoaViewsRepository.Wire.Properties.dest) {
					return createDestFlatComboViewer(parent, widgetFactory);
				}
				if (key == SoaViewsRepository.Wire.Properties.description) {
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
		propertiesSection.setText(SoaMessages.WirePropertiesEditionPart_PropertiesGroupLabel);
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

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createSourceFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, SoaViewsRepository.Wire.Properties.source, SoaMessages.WirePropertiesEditionPart_SourceLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WirePropertiesEditionPartForm.this, SoaViewsRepository.Wire.Properties.source, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WirePropertiesEditionPartForm.this, SoaViewsRepository.Wire.Properties.source, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return getSource();
			}

			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WirePropertiesEditionPartForm.this, SoaViewsRepository.Wire.Properties.source, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element)); 
			}

		};
		//create widget
		source = new AdvancedEObjectFlatComboViewer(SoaMessages.WirePropertiesEditionPart_SourceLabel, resourceSet, sourceFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		source.createControls(parent, widgetFactory);
		GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
		source.setLayoutData(sourceData);
		source.setID(SoaViewsRepository.Wire.Properties.source);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Wire.Properties.source, SoaViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceFlatComboViewer

		// End of user code
		return parent;
	}


	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createDestFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, SoaViewsRepository.Wire.Properties.dest, SoaMessages.WirePropertiesEditionPart_DestLabel);
		// create callback listener
		EObjectFlatComboViewerListener listener = new EObjectFlatComboViewerListener(){
			public void handleSet(EObject element){
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WirePropertiesEditionPartForm.this, SoaViewsRepository.Wire.Properties.dest, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element)); 
			}
			public void navigateTo(EObject element){ }

			public EObject handleCreate() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WirePropertiesEditionPartForm.this, SoaViewsRepository.Wire.Properties.dest, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null)); 
				return getDest();
			}

			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WirePropertiesEditionPartForm.this, SoaViewsRepository.Wire.Properties.dest, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element)); 
			}

		};
		//create widget
		dest = new AdvancedEObjectFlatComboViewer(SoaMessages.WirePropertiesEditionPart_DestLabel, resourceSet, destFilter, propertiesEditionComponent.getEditingContext().getAdapterFactory(), listener);
		dest.createControls(parent, widgetFactory);
		GridData destData = new GridData(GridData.FILL_HORIZONTAL);
		dest.setLayoutData(destData);
		dest.setID(SoaViewsRepository.Wire.Properties.dest);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Wire.Properties.dest, SoaViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDestFlatComboViewer

		// End of user code
		return parent;
	}


	
	protected Composite createDescriptionTextarea(FormToolkit widgetFactory, Composite parent) {
		Label descriptionLabel = createDescription(parent, SoaViewsRepository.Wire.Properties.description, SoaMessages.WirePropertiesEditionPart_DescriptionLabel);
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
							WirePropertiesEditionPartForm.this,
							SoaViewsRepository.Wire.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									WirePropertiesEditionPartForm.this,
									SoaViewsRepository.Wire.Properties.description,
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
									WirePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(description, SoaViewsRepository.Wire.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(SoaViewsRepository.Wire.Properties.description, SoaViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionTextArea

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
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#getSource()
	 * 
	 */
	public EObject getSource() {
		return source.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#initSource(EObjectFlatComboSettings)
	 */
	public void initSource(EObjectFlatComboSettings settings) {
		source.setInput(settings);
		if (current != null) {
			source.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(SoaViewsRepository.Wire.Properties.source);
		if (eefElementEditorReadOnlyState && source.isEnabled()) {
			source.setEnabled(false);
			source.setToolTipText(SoaMessages.Wire_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
			source.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#setSource(EObject newValue)
	 * 
	 */
	public void setSource(EObject newValue) {
		if (newValue != null) {
			source.setSelection(new StructuredSelection(newValue));
		} else {
			source.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(SoaViewsRepository.Wire.Properties.source);
		if (eefElementEditorReadOnlyState && source.isEnabled()) {
			source.setEnabled(false);
			source.setToolTipText(SoaMessages.Wire_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
			source.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#setSourceButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSourceButtonMode(ButtonsModeEnum newValue) {
		source.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#addFilterSource(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSource(ViewerFilter filter) {
		source.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#addBusinessFilterSource(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSource(ViewerFilter filter) {
		source.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#getDest()
	 * 
	 */
	public EObject getDest() {
		return dest.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#initDest(EObjectFlatComboSettings)
	 */
	public void initDest(EObjectFlatComboSettings settings) {
		dest.setInput(settings);
		if (current != null) {
			dest.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(SoaViewsRepository.Wire.Properties.dest);
		if (eefElementEditorReadOnlyState && dest.isEnabled()) {
			dest.setEnabled(false);
			dest.setToolTipText(SoaMessages.Wire_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dest.isEnabled()) {
			dest.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#setDest(EObject newValue)
	 * 
	 */
	public void setDest(EObject newValue) {
		if (newValue != null) {
			dest.setSelection(new StructuredSelection(newValue));
		} else {
			dest.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(SoaViewsRepository.Wire.Properties.dest);
		if (eefElementEditorReadOnlyState && dest.isEnabled()) {
			dest.setEnabled(false);
			dest.setToolTipText(SoaMessages.Wire_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dest.isEnabled()) {
			dest.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#setDestButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDestButtonMode(ButtonsModeEnum newValue) {
		dest.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#addFilterDest(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDest(ViewerFilter filter) {
		dest.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#addBusinessFilterDest(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDest(ViewerFilter filter) {
		dest.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.soa.parts.WirePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(SoaViewsRepository.Wire.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setBackground(description.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			description.setToolTipText(SoaMessages.Wire_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
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
		return SoaMessages.Wire_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
