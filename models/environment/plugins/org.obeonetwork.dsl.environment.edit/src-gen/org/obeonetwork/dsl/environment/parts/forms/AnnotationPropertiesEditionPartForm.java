/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
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
package org.obeonetwork.dsl.environment.parts.forms;

// Start of user code for imports
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
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
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
import org.obeonetwork.dsl.environment.parts.AnnotationPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class AnnotationPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, AnnotationPropertiesEditionPart {

	protected Text title_;
	protected Text body;



	/**
	 * For {@link ISection} use only.
	 */
	public AnnotationPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AnnotationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence annotationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = annotationStep.addStep(EnvironmentViewsRepository.Annotation.Properties.class);
		propertiesStep.addStep(EnvironmentViewsRepository.Annotation.Properties.title_);
		propertiesStep.addStep(EnvironmentViewsRepository.Annotation.Properties.body);
		
		
		composer = new PartComposer(annotationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.Annotation.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.Annotation.Properties.title_) {
					return createTitle_Text(widgetFactory, parent);
				}
				if (key == EnvironmentViewsRepository.Annotation.Properties.body) {
					return createBodyTextarea(widgetFactory, parent);
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
		propertiesSection.setText(EnvironmentMessages.AnnotationPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createTitle_Text(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.Annotation.Properties.title_, EnvironmentMessages.AnnotationPropertiesEditionPart_Title_Label);
		title_ = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		title_.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData title_Data = new GridData(GridData.FILL_HORIZONTAL);
		title_.setLayoutData(title_Data);
		title_.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AnnotationPropertiesEditionPartForm.this,
							EnvironmentViewsRepository.Annotation.Properties.title_,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, title_.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AnnotationPropertiesEditionPartForm.this,
									EnvironmentViewsRepository.Annotation.Properties.title_,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, title_.getText()));
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
									AnnotationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		title_.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AnnotationPropertiesEditionPartForm.this, EnvironmentViewsRepository.Annotation.Properties.title_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, title_.getText()));
				}
			}
		});
		EditingUtils.setID(title_, EnvironmentViewsRepository.Annotation.Properties.title_);
		EditingUtils.setEEFtype(title_, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Annotation.Properties.title_, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTitle_Text

		// End of user code
		return parent;
	}

	
	protected Composite createBodyTextarea(FormToolkit widgetFactory, Composite parent) {
		Label bodyLabel = createDescription(parent, EnvironmentViewsRepository.Annotation.Properties.body, EnvironmentMessages.AnnotationPropertiesEditionPart_BodyLabel);
		GridData bodyLabelData = new GridData(GridData.FILL_HORIZONTAL);
		bodyLabelData.horizontalSpan = 3;
		bodyLabel.setLayoutData(bodyLabelData);
		body = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL); //$NON-NLS-1$
		GridData bodyData = new GridData(GridData.FILL_HORIZONTAL);
		bodyData.horizontalSpan = 2;
		bodyData.heightHint = 80;
		bodyData.widthHint = 200;
		body.setLayoutData(bodyData);
		body.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AnnotationPropertiesEditionPartForm.this,
							EnvironmentViewsRepository.Annotation.Properties.body,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, body.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AnnotationPropertiesEditionPartForm.this,
									EnvironmentViewsRepository.Annotation.Properties.body,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, body.getText()));
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
									AnnotationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		EditingUtils.setID(body, EnvironmentViewsRepository.Annotation.Properties.body);
		EditingUtils.setEEFtype(body, "eef::Textarea"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Annotation.Properties.body, EnvironmentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createBodyTextArea

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
	 * @see org.obeonetwork.dsl.environment.parts.AnnotationPropertiesEditionPart#getTitle_()
	 * 
	 */
	public String getTitle_() {
		return title_.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.AnnotationPropertiesEditionPart#setTitle_(String newValue)
	 * 
	 */
	public void setTitle_(String newValue) {
		if (newValue != null) {
			title_.setText(newValue);
		} else {
			title_.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Annotation.Properties.title_);
		if (eefElementEditorReadOnlyState && title_.isEnabled()) {
			title_.setEnabled(false);
			title_.setToolTipText(EnvironmentMessages.Annotation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !title_.isEnabled()) {
			title_.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.AnnotationPropertiesEditionPart#getBody()
	 * 
	 */
	public String getBody() {
		return body.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.environment.parts.AnnotationPropertiesEditionPart#setBody(String newValue)
	 * 
	 */
	public void setBody(String newValue) {
		if (newValue != null) {
			body.setText(newValue);
		} else {
			body.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EnvironmentViewsRepository.Annotation.Properties.body);
		if (eefElementEditorReadOnlyState && body.isEnabled()) {
			body.setEnabled(false);
			body.setBackground(body.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			body.setToolTipText(EnvironmentMessages.Annotation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !body.isEnabled()) {
			body.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EnvironmentMessages.Annotation_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
