/*******************************************************************************
 * Copyright (c) 2012, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.ui.wizards.scaffolding;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;

public class SpecifyAdditionalObjectsPage extends WizardPage {
	
	private Session session;
	private ScaffoldType scaffoldType;
	private EObject target;
	private AdditionalObjectsComposite additionalObjectsComposite;
	
	/**
	 * Create the wizard.
	 */
	public SpecifyAdditionalObjectsPage(Session session, ScaffoldType scaffoldType, EObject target) {
		super("additionalObjects");
		this.session = session;
		this.scaffoldType = scaffoldType;
		this.target = target;
		setTitle("Specify additional objects");
		setDescription("Add elements which could be referenced by the generated model");
	}
	
	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblAdditionalObjects = new Label(container, SWT.NONE);
		lblAdditionalObjects.setText("Additional objects :");
		lblAdditionalObjects.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		
		additionalObjectsComposite = new AdditionalObjectsComposite(container, session, scaffoldType, target);
		additionalObjectsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
	}
	
	public Iterable<EObject> getAdditionalObjects() {
		return additionalObjectsComposite.getAdditionalObjects();
	}
}
