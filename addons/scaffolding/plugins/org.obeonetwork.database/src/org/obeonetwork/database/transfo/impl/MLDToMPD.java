/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.database.transfo.impl;

import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isH2MPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isMariaDBMPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isMysqlMPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isOracleMPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isPostgresMPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isSQLServerMPD;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;

public class MLDToMPD extends MpdToMldBidiRules {

	@Override
	protected String getTypePropertiesFileName() {
		if (isOracleMPD(targetTypesLibrary)) {
			return "LogicalTypes-to-Oracle.properties";
		} else if (isMysqlMPD(targetTypesLibrary)) {
			return "LogicalTypes-to-MySQL.properties";
		} else if (isMariaDBMPD(targetTypesLibrary)) {
			return "LogicalTypes-to-MariaDB.properties";
		} else if (isPostgresMPD(targetTypesLibrary)) {
			return "LogicalTypes-to-Postgres.properties";
		} else if (isSQLServerMPD(targetTypesLibrary)) {
			return "LogicalTypes-to-SQLServer.properties";
		} else if (isH2MPD(targetTypesLibrary)) {
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
