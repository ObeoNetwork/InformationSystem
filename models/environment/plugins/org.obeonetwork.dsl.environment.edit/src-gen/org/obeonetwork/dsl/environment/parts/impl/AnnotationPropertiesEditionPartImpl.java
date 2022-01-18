/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
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
package org.obeonetwork.dsl.environment.parts.impl;

// Start of user code for imports
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
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.obeonetwork.dsl.environment.parts.AnnotationPropertiesEditionPart;
import org.obeonetwork.dsl.environment.parts.EnvironmentViewsRepository;
import org.obeonetwork.dsl.environment.providers.EnvironmentMessages;

// End of user code

/**
 * 
 * 
 */
public class AnnotationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, AnnotationPropertiesEditionPart {

	protected Text title_;
	protected Text body;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AnnotationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence annotationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = annotationStep.addStep(EnvironmentViewsRepository.Annotation.Properties.class);
		propertiesStep.addStep(EnvironmentViewsRepository.Annotation.Properties.title_);
		propertiesStep.addStep(EnvironmentViewsRepository.Annotation.Properties.body);
		
		
		composer = new PartComposer(annotationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EnvironmentViewsRepository.Annotation.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EnvironmentViewsRepository.Annotation.Properties.title_) {
					return createTitle_Text(parent);
				}
				if (key == EnvironmentViewsRepository.Annotation.Properties.body) {
					return createBodyTextarea(parent);
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
		propertiesGroup.setText(EnvironmentMessages.AnnotationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createTitle_Text(Composite parent) {
		createDescription(parent, EnvironmentViewsRepository.Annotation.Properties.title_, EnvironmentMessages.AnnotationPropertiesEditionPart_Title_Label);
		title_ = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData title_Data = new GridData(GridData.FILL_HORIZONTAL);
		title_.setLayoutData(title_Data);
		title_.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AnnotationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Annotation.Properties.title_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, title_.getText()));
			}

		});
		title_.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AnnotationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Annotation.Properties.title_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, title_.getText()));
				}
			}

		});
		EditingUtils.setID(title_, EnvironmentViewsRepository.Annotation.Properties.title_);
		EditingUtils.setEEFtype(title_, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Annotation.Properties.title_, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTitle_Text

		// End of user code
		return parent;
	}

	
	protected Composite createBodyTextarea(Composite parent) {
		Label bodyLabel = createDescription(parent, EnvironmentViewsRepository.Annotation.Properties.body, EnvironmentMessages.AnnotationPropertiesEditionPart_BodyLabel);
		GridData bodyLabelData = new GridData(GridData.FILL_HORIZONTAL);
		bodyLabelData.horizontalSpan = 3;
		bodyLabel.setLayoutData(bodyLabelData);
		body = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
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
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AnnotationPropertiesEditionPartImpl.this, EnvironmentViewsRepository.Annotation.Properties.body, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, body.getText()));
			}

		});
		EditingUtils.setID(body, EnvironmentViewsRepository.Annotation.Properties.body);
		EditingUtils.setEEFtype(body, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EnvironmentViewsRepository.Annotation.Properties.body, EnvironmentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
