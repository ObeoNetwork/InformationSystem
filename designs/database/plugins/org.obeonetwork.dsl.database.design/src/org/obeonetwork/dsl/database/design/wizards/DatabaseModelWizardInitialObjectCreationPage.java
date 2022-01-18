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
package org.obeonetwork.dsl.database.design.wizards;

import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_H2_13;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_LOGICAL_TYPES;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MARIADB_102;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_MYSQL_5;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_ORACLE_11G;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_POSTGRES_9;
import static org.obeonetwork.dsl.database.spec.DatabaseConstants.DB_SQLSERVER_2008;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.provider.DatabaseEditPlugin;

public class DatabaseModelWizardInitialObjectCreationPage extends WizardPage {

	protected Combo initialObjectField;
	protected Combo dbVendorField;
	protected Combo encodingField;

	protected List<String> dbVendors;
	protected List<String> encodings;

	public DatabaseModelWizardInitialObjectCreationPage(String pageId) {
		super(pageId);
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}

		Label containerLabel = new Label(composite, SWT.LEFT);
		{
			containerLabel.setText("Model Object");

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			containerLabel.setLayoutData(data);
		}

		initialObjectField = new Combo(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			initialObjectField.setLayoutData(data);
		}

		initialObjectField.add("Data Base");
		initialObjectField.select(0);

		initialObjectField.addModifyListener(validator);

		Label dbVendorLabel = new Label(composite, SWT.LEFT);
		{
			dbVendorLabel.setText("DB Vendor");

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			dbVendorLabel.setLayoutData(data);
		}
		dbVendorField = new Combo(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			dbVendorField.setLayoutData(data);
		}
		for (String dbVendor : getDBVendors()) {
			dbVendorField.add(dbVendor);
		}
		dbVendorField.select(0);
		dbVendorField.addModifyListener(validator);

		Label encodingLabel = new Label(composite, SWT.LEFT);
		{
			encodingLabel.setText("XML Encoding");

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			encodingLabel.setLayoutData(data);
		}
		encodingField = new Combo(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			encodingField.setLayoutData(data);
		}

		for (String encoding : getEncodings()) {
			encodingField.add(encoding);
		}

		encodingField.select(0);
		encodingField.addModifyListener(validator);

		setPageComplete(validatePage());
		setControl(composite);
	}

	protected ModifyListener validator = new ModifyListener() {
		public void modifyText(ModifyEvent e) {
			setPageComplete(validatePage());
		}
	};

	protected boolean validatePage() {
		return getInitialObjectName() != null && getEncodings().contains(encodingField.getText())
				&& getDBVendors().contains(dbVendorField.getText());
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			if (initialObjectField.getItemCount() == 1) {
				initialObjectField.clearSelection();
				encodingField.setFocus();
			} else {
				encodingField.clearSelection();
				initialObjectField.setFocus();
			}
		}
	}

	public String getInitialObjectName() {
		String label = initialObjectField.getText();

		for (String name : getInitialObjectNames()) {
			if (getLabel(name).equals(label)) {
				return name;
			}
		}
		return null;
	}
	
	protected Collection<String> getInitialObjectNames() {
		List<String> initialObjectNames = new ArrayList<String>();
		for (EClassifier eClassifier : DatabasePackage.eINSTANCE.getEClassifiers()) {
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				if (!eClass.isAbstract()) {
					initialObjectNames.add(eClass.getName());
				}
			}
		}
		Collections.sort(initialObjectNames);
		return initialObjectNames;
	}

	public String getEncoding() {
		return encodingField.getText();
	}

	protected String getLabel(String typeName) {
		try {
			return DatabaseEditPlugin.INSTANCE.getString("_UI_" + typeName + "_type");
		} catch (MissingResourceException mre) {
			// TODO log error
		}
		return typeName;
	}

	protected Collection<String> getEncodings() {
		if (encodings == null) {
			encodings = new ArrayList<String>();
			for (StringTokenizer stringTokenizer = new StringTokenizer(
					"UTF-8 ASCII UTF-16 UTF-16BE UTF-16LE ISO-8859-1"); stringTokenizer
							.hasMoreTokens();) {
				encodings.add(stringTokenizer.nextToken());
			}
		}
		return encodings;
	}

	protected Collection<String> getDBVendors() {
		if (dbVendors == null) {
			dbVendors = new ArrayList<String>();
			dbVendors.add(DB_LOGICAL_TYPES);
			dbVendors.add(DB_MYSQL_5);
			dbVendors.add(DB_MARIADB_102);
			dbVendors.add(DB_ORACLE_11G);
			dbVendors.add(DB_H2_13);
			dbVendors.add(DB_POSTGRES_9);
			dbVendors.add(DB_SQLSERVER_2008);
		}
		return dbVendors;
	}
}