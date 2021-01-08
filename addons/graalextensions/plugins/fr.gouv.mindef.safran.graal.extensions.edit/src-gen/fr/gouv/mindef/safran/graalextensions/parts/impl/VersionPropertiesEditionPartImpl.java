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
package fr.gouv.mindef.safran.graalextensions.parts.impl;

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
import org.eclipse.swt.widgets.Text;

import fr.gouv.mindef.safran.graalextensions.parts.GraalextensionsViewsRepository;
import fr.gouv.mindef.safran.graalextensions.parts.TextWithButton;
import fr.gouv.mindef.safran.graalextensions.parts.VersionPropertiesEditionPart;
import fr.gouv.mindef.safran.graalextensions.providers.GraalextensionsMessages;

// End of user code

/**
 * @author Obeo.fr
 * 
 */
public class VersionPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, VersionPropertiesEditionPart {

	// Start of user code  for version widgets declarations
	protected TextWithButton version;
	// End of user code

	protected Text modifiedOn;
	protected Text createdOn;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public VersionPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence versionStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = versionStep.addStep(GraalextensionsViewsRepository.Version.Properties.class);
		propertiesStep.addStep(GraalextensionsViewsRepository.Version.Properties.version_);
		propertiesStep.addStep(GraalextensionsViewsRepository.Version.Properties.modifiedOn);
		propertiesStep.addStep(GraalextensionsViewsRepository.Version.Properties.createdOn);
		
		
		composer = new PartComposer(versionStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == GraalextensionsViewsRepository.Version.Properties.class) {
					return createPropertiesGroup(parent);
				}
				// Start of user code for version addToPart creation
				
				// End of user code
				if (key == GraalextensionsViewsRepository.Version.Properties.modifiedOn) {
					return createModifiedOnText(parent);
				}
				if (key == GraalextensionsViewsRepository.Version.Properties.createdOn) {
					return createCreatedOnText(parent);
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
		propertiesGroup.setText(GraalextensionsMessages.VersionPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createModifiedOnText(Composite parent) {
		createDescription(parent, GraalextensionsViewsRepository.Version.Properties.modifiedOn, GraalextensionsMessages.VersionPropertiesEditionPart_ModifiedOnLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(VersionPropertiesEditionPartImpl.this, GraalextensionsViewsRepository.Version.Properties.modifiedOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modifiedOn.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(VersionPropertiesEditionPartImpl.this, GraalextensionsViewsRepository.Version.Properties.modifiedOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, modifiedOn.getText()));
				}
			}

		});
		EditingUtils.setID(modifiedOn, GraalextensionsViewsRepository.Version.Properties.modifiedOn);
		EditingUtils.setEEFtype(modifiedOn, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalextensionsViewsRepository.Version.Properties.modifiedOn, GraalextensionsViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createModifiedOnText

		// End of user code
		return parent;
	}

	
	protected Composite createCreatedOnText(Composite parent) {
		createDescription(parent, GraalextensionsViewsRepository.Version.Properties.createdOn, GraalextensionsMessages.VersionPropertiesEditionPart_CreatedOnLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(VersionPropertiesEditionPartImpl.this, GraalextensionsViewsRepository.Version.Properties.createdOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, createdOn.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(VersionPropertiesEditionPartImpl.this, GraalextensionsViewsRepository.Version.Properties.createdOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, createdOn.getText()));
				}
			}

		});
		EditingUtils.setID(createdOn, GraalextensionsViewsRepository.Version.Properties.createdOn);
		EditingUtils.setEEFtype(createdOn, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(GraalextensionsViewsRepository.Version.Properties.createdOn, GraalextensionsViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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


}
