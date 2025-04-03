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
package org.obeonetwork.dsl.database.gen.common.services;

import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isH2MPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isMPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isMariaDBMPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isMysqlMPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isOracleMPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isPostgresMPD;
import static org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil.isSQLServerMPD;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryUser;
import org.obeonetwork.dsl.typeslibrary.provider.TypesLibraryItemProviderAdapterFactory;

public class TypesServices {

	private AdapterFactoryLabelProvider labelProvider = null;

	public AdapterFactoryLabelProvider getLabelProvider() {
		if (labelProvider == null) {
			labelProvider = new AdapterFactoryLabelProvider(new TypesLibraryItemProviderAdapterFactory());
		}
		return labelProvider;
	}

	public String getType(TypeInstance typeInstance) {
		// Handle enum types to add quotes
		if (typeInstance != null && typeInstance.getNativeType() != null
				&& typeInstance.getNativeType().getSpec() == NativeTypeKind.ENUM) {
			String label = typeInstance.getNativeType().getName();
			label += "(";
			for (int i = 0; i < typeInstance.getLiterals().size(); i++) {
				String literal = typeInstance.getLiterals().get(i);
				if (i != 0) {
					label += ", ";
				}
				label += "'" + literal + "'";
			}
			label += ")";
			return label;
		}

		return getLabelProvider().getText(typeInstance);
	}

	public TypesLibrary getPhysicalTypesLibrary(DatabaseElement element) {
		TypesLibraryUser tlu = getTypesLibraryUser(element);
		TypesLibrary physicalTypesLibrary = getTargetPhysicalTypesLibrary(tlu);
		return physicalTypesLibrary;
	}

	public boolean isTargetOracle(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isOracleMPD(physicalTypesLibrary);
	}
	
	public boolean isTargetOracle(DataBase database) {
		TypesLibrary physicalTypesLibrary = getTargetPhysicalTypesLibrary(database);
		return isOracleMPD(physicalTypesLibrary);
	}

	public boolean isTargetMySqlOrMariaDB(DatabaseElement element) {
		return isTargetMySql(element) || isTargetMariaDB(element);
	}

	public boolean isTargetMySql(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isMysqlMPD(physicalTypesLibrary);
	}

	public boolean isTargetMariaDB(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isMariaDBMPD(physicalTypesLibrary);
	}

	public boolean isTargetSqlServer(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isSQLServerMPD(physicalTypesLibrary);
	}

	public boolean isTargetPostgreSQL(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isPostgresMPD(physicalTypesLibrary);
	}

	public boolean isTargetH2(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isH2MPD(physicalTypesLibrary);
	}

	private TypesLibraryUser getTypesLibraryUser(DatabaseElement element) {
		if (element instanceof TypesLibraryUser) {
			return (TypesLibraryUser) element;
		} else {
			EObject container = element.eContainer();
			if (container != null && container instanceof DatabaseElement) {
				return getTypesLibraryUser((DatabaseElement) container);
			}
		}
		return null;
	}

	private TypesLibrary getTargetPhysicalTypesLibrary(TypesLibraryUser tlu) {
		if (tlu != null) {
			for (TypesLibrary library : tlu.getUsedLibraries()) {
				if (isMPD(library)) {
					return library;
				}
			}
		}
		return null;
	}

	public void dispose() {
		if (labelProvider != null) {
			labelProvider.dispose();
			labelProvider = null;
		}
	}
}
