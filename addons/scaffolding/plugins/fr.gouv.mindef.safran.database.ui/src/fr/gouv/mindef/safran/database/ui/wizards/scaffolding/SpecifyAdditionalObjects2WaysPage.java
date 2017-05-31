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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;

public class SpecifyAdditionalObjects2WaysPage extends WizardPage {
	private ScaffoldInfo scaffoldInfo;
	private AdditionalObjectsComposite additionalObjectsComposite1;
	private AdditionalObjectsComposite additionalObjectsComposite2;

	/**
	 * Create the wizard.
	 */
	public SpecifyAdditionalObjects2WaysPage(ScaffoldInfo scaffoldInfo) {
		super("additionalObjects2Ways");
		setTitle("Specify additional objects");
		setDescription("Add elements which could be referenced by the generated model");
		this.scaffoldInfo = scaffoldInfo;
	}
	
	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		Session session = SessionManager.INSTANCE.getSession(scaffoldInfo);
		ScaffoldType scaffoldType1 = scaffoldInfo.getLeftToRightTransformationType();
		EObject target1 = scaffoldInfo.getRightObject();
		Collection<EObject> additionalObjects1 = new ArrayList<EObject>(scaffoldInfo.getLeftToRightAdditionalObjects());
		ScaffoldType scaffoldType2 = scaffoldInfo.getRightToLeftTransformationType();
		EObject target2 = scaffoldInfo.getLeftObject();
		Collection<EObject> additionalObjects2 = new ArrayList<EObject>(scaffoldInfo.getRightToLeftAdditionalObjects());


		Label lbl1 = new Label(container, SWT.NONE);
		lbl1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lbl1.setText(scaffoldType1.getName() + " :");
		
		additionalObjectsComposite1 = new AdditionalObjectsComposite(container, session, scaffoldType1, target1, additionalObjects1);
		additionalObjectsComposite1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		new Label(container, SWT.NONE);
		
		Label lbl2 = new Label(container, SWT.NONE);
		lbl2.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lbl2.setText(scaffoldType2.getName() + " :");
				
		additionalObjectsComposite2 = new AdditionalObjectsComposite(container, session, scaffoldType2, target2, additionalObjects2);
		additionalObjectsComposite2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	}
	
	public Collection<EObject> getAdditionalObjects1() {
		return additionalObjectsComposite1.getAdditionalObjects();
	}

	public Collection<EObject> getAdditionalObjects2() {
		return additionalObjectsComposite2.getAdditionalObjects();
	}
}
