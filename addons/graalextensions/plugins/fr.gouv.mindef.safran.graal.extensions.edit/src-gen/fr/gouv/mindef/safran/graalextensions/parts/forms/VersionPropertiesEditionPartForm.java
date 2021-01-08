/**
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package fr.gouv.mindef.safran.graalextensions.parts.forms;

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
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;

import fr.gouv.mindef.safran.graalextensions.parts.GraalextensionsViewsRepository;
import fr.gouv.mindef.safran.graalextensions.parts.TextWithButton;
import fr.gouv.mindef.safran.graalextensions.parts.VersionPropertiesEditionPart;
import fr.gouv.mindef.safran.graalextensions.providers.GraalextensionsMessages;

// End of user code

/**
 * @author Obeo.fr
 * 
 */
public class VersionPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, VersionPropertiesEditionPart {

	// Start of user code  for version widgets declarations
	protected TextWithButton version;
	// End of user code

	protected Text modifiedOn;
	protected Text createdOn;



	/**
	 * For {@link ISection} use only.
	 */
	public VersionPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public VersionPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence versionStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = versionStep.addStep(GraalextensionsViewsRepository.Version.Properties.class);
		propertiesStep.addStep(GraalextensionsViewsRepository.Version.Properties.version_);
		propertiesStep.addStep(GraalextensionsViewsRepository.Version.Properties.modifiedOn);
		propertiesStep.addStep(GraalextensionsViewsRepository.Version.Properties.createdOn);
		
		
		composer = new PartComposer(versionStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalextensionsViewsRepository.Version.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				// Start of user code for version addToPart creation
				
				if (key == GraalextensionsViewsRepository.Version.Properties.version_) {
					return createVersionWidget(widgetFactory, parent);
				}
				
				// End of user code
				if (key == GraalextensionsViewsRepository.Version.Properties.modifiedOn) {
					return createModifiedOnText(widgetFactory, parent);
				}
				if (key == GraalextensionsViewsRepository.Version.Properties.createdOn) {
					return createCreatedOnText(widgetFactory, parent);
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
		propertiesSection.setText(GraalextensionsMessages.VersionPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createModifiedOnText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, GraalextensionsViewsRepository.Version.Properties.modifiedOn, GraalextensionsMessages.VersionPropertiesEditionPart_ModifiedOnLabel);
		modifiedOn = widgetFactory.createText(parent, ""); //$NON-NLS-1$
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
							VersionPropertiesEditionPartForm.this,
							GraalextensionsViewsRepository.Version.Properties.modifiedOn,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modifiedOn.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									VersionPropertiesEditionPartForm.this,
									GraalextensionsViewsRepository.Version.Properties.modifiedOn,
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
									VersionPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(VersionPropertiesEditionPartForm.this, GraalextensionsViewsRepository.Version.Properties.modifiedOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modifiedOn.getText()));
				}
			}
		});
		EditingUtils.setID(modifiedOn, GraalextensionsViewsRepository.Version.Properties.modifiedOn);
		EditingUtils.setEEFtype(modifiedOn, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(GraalextensionsViewsRepository.Version.Properties.modifiedOn, GraalextensionsViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createModifiedOnText

		// End of user code
		return parent;
	}

	
	protected Composite createCreatedOnText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, GraalextensionsViewsRepository.Version.Properties.createdOn, GraalextensionsMessages.VersionPropertiesEditionPart_CreatedOnLabel);
		createdOn = widgetFactory.createText(parent, ""); //$NON-NLS-1$
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
							VersionPropertiesEditionPartForm.this,
							GraalextensionsViewsRepository.Version.Properties.createdOn,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, createdOn.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									VersionPropertiesEditionPartForm.this,
									GraalextensionsViewsRepository.Version.Properties.createdOn,
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
									VersionPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(VersionPropertiesEditionPartForm.this, GraalextensionsViewsRepository.Version.Properties.createdOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, createdOn.getText()));
				}
			}
		});
		EditingUtils.setID(createdOn, GraalextensionsViewsRepository.Version.Properties.createdOn);
		EditingUtils.setEEFtype(createdOn, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(GraalextensionsViewsRepository.Version.Properties.createdOn, GraalextensionsViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see fr.gouv.mindef.safran.environment.parts.VersionPropertiesEditionPart#getModifiedOn()
	 * 
	 */
	public String getModifiedOn() {
		return modifiedOn.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.VersionPropertiesEditionPart#setModifiedOn(String newValue)
	 * 
	 */
	public void setModifiedOn(String newValue) {
		if (newValue != null) {
			modifiedOn.setText(newValue);
		} else {
			modifiedOn.setText(""); //$NON-NLS-1$
		}
		modifiedOn.setEnabled(false);
		modifiedOn.setToolTipText(GraalextensionsMessages.Version_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.VersionPropertiesEditionPart#getCreatedOn()
	 * 
	 */
	public String getCreatedOn() {
		return createdOn.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.gouv.mindef.safran.environment.parts.VersionPropertiesEditionPart#setCreatedOn(String newValue)
	 * 
	 */
	public void setCreatedOn(String newValue) {
		if (newValue != null) {
			createdOn.setText(newValue);
		} else {
			createdOn.setText(""); //$NON-NLS-1$
		}
		createdOn.setEnabled(false);
		createdOn.setToolTipText(GraalextensionsMessages.Version_ReadOnly);
		
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
		return GraalextensionsMessages.Version_Part_Title;
	}

	// Start of user code additional methods
	protected Composite createVersionWidget(FormToolkit widgetFactory, final Composite parent) {
		createDescription(parent, GraalextensionsViewsRepository.Version.Properties.version_, GraalextensionsMessages.VersionPropertiesEditionPart_VersionLabel);
		
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
								new PropertiesEditionEvent(VersionPropertiesEditionPartForm.this,
									GraalextensionsViewsRepository.Version.Properties.version_,
									PropertiesEditionEvent.COMMIT,
									PropertiesEditionEvent.SET,
									null,
									null));
				}
				
			}
			
		});
		FormUtils.createHelpButton(widgetFactory, parent,
				propertiesEditionComponent.getHelpContent(
						GraalextensionsViewsRepository.Version.Properties.version_,
						GraalextensionsViewsRepository.FORM_KIND),
				null);
		return parent;
	}
	// End of user code


}
