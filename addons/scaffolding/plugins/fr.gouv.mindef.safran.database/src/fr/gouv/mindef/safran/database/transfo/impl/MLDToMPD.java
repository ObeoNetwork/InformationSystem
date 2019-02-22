/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package fr.gouv.mindef.safran.database.transfo.impl;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;

public class MLDToMPD extends MpdToMldBidiRules {

	@Override
	protected String getTypePropertiesFileName() {
		if (isTargetOracleMPD()) {
			return "LogicalTypes-to-Oracle.properties";
		} else if (isTargetMysqlMPD()) {
			return "LogicalTypes-to-MySQL.properties";
		} else if (isTargetMariaDBMPD()) {
			return "LogicalTypes-to-MariaDB.properties";
		} else if (isTargetPostgresMPD()) {
			return "LogicalTypes-to-Postgres.properties";
		} else if (isTargetSQLServerMPD()) {
			return "LogicalTypes-to-SQLServer.properties";
		} else if (isTargetH2MPD()) {
			return "LogicalTypes-to-H2.properties";
		}
		return null;
	}

	@Override
	protected TypeInstance resolveType(TypeInstance logicalType) {
		if (logicalType.getNativeType() == null || logicalType.getNativeType().getName() == null) {
			return null;
		}
		String physicalTypeName = getTypeProperties().getProperty(logicalType.getNativeType().getName());
		NativeType physicalNativetype = findNativeType(physicalTypeName, targetTypesLibrary);
		
		if (physicalNativetype != null) {
			TypeInstance typeInstance = TypesLibraryFactory.eINSTANCE.createTypeInstance();
			typeInstance.setLength(logicalType.getLength());
			typeInstance.setPrecision(logicalType.getPrecision());
			typeInstance.setNativeType(physicalNativetype);
			return typeInstance;
		}
		return null;
	}

	private NativeType findNativeType(String name, TypesLibrary typesLibrary) {
		TreeIterator<EObject> it = typesLibrary.eAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof NativeType) {
				NativeType nativeType = (NativeType) eObject;
				if (nativeType.getName().equals(name)) {
					return nativeType;
				}
			}
		}
		return null;
	}

}
