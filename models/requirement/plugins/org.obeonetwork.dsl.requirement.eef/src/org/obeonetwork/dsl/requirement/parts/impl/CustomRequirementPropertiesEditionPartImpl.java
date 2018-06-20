/*******************************************************************************
 * Copyright (c) 2010, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.requirement.parts.impl;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
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
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.requirement.parts.RequirementViewsRepository;
import org.obeonetwork.dsl.requirement.providers.RequirementMessages;

/**
 * Customizes the requirement wizard
 * @author sthibaudeau
 *
 */
public class CustomRequirementPropertiesEditionPartImpl extends
		RequirementPropertiesEditionPartImpl {

	public CustomRequirementPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	@Override
	public Composite createFigure(Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 6;
		layout.makeColumnsEqualWidth = false;
		layout.marginTop = 10;
		view.setLayout(layout);
		createControls(view);
		return view;
	}
	
	@Override
	protected Composite createIdText(Composite parent) {
		SWTUtils.createPartLabel(parent, RequirementMessages.RequirementPropertiesEditionPart_IdLabel, propertiesEditionComponent.isRequired(RequirementViewsRepository.Requirement_.id, RequirementViewsRepository.SWT_KIND));
		id = new Text(parent, SWT.BORDER);
		GridData idData = new GridData(GridData.FILL_HORIZONTAL);
		idData.horizontalSpan = 4;
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomRequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomRequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.id, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, id.getText()));
				}
			}

		});
		EditingUtils.setID(id, RequirementViewsRepository.Requirement_.id);
		EditingUtils.setEEFtype(id, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.id, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	@Override
	protected Composite createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, RequirementMessages.RequirementPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(RequirementViewsRepository.Requirement_.name, RequirementViewsRepository.SWT_KIND));
		name = new Text(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		nameData.horizontalSpan = 4;
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomRequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomRequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, RequirementViewsRepository.Requirement_.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.name, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	@Override
	protected Composite createStatusText(Composite parent) {
		SWTUtils.createPartLabel(parent, RequirementMessages.RequirementPropertiesEditionPart_StatusLabel, propertiesEditionComponent.isRequired(RequirementViewsRepository.Requirement_.status, RequirementViewsRepository.SWT_KIND));
		status = new Text(parent, SWT.BORDER);
		GridData statusData = new GridData(GridData.FILL_HORIZONTAL);
		statusData.horizontalSpan = 4;
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomRequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.status, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, status.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomRequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.status, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, status.getText()));
				}
			}

		});
		EditingUtils.setID(status, RequirementViewsRepository.Requirement_.status);
		EditingUtils.setEEFtype(status, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.status, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	@Override
	protected Composite createStatementTextarea(Composite parent) {
		SWTUtils.createPartLabel(parent, RequirementMessages.RequirementPropertiesEditionPart_StatementLabel, propertiesEditionComponent.isRequired(RequirementViewsRepository.Requirement_.statement, RequirementViewsRepository.SWT_KIND));
		statement = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData statementData = new GridData(GridData.FILL_HORIZONTAL);
		statementData.horizontalSpan = 4;
		statementData.heightHint = 80;
		statementData.widthHint = 200;
		statement.setFocus();
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CustomRequirementPropertiesEditionPartImpl.this, RequirementViewsRepository.Requirement_.statement, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, statement.getText()));
			}

		});
		EditingUtils.setID(statement, RequirementViewsRepository.Requirement_.statement);
		EditingUtils.setEEFtype(statement, "eef::Textarea"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(RequirementViewsRepository.Requirement_.statement, RequirementViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}
}
