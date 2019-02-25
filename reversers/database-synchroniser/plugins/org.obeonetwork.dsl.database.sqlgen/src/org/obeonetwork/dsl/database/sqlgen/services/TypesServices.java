/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.sqlgen.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryKind;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryUser;
import org.obeonetwork.dsl.typeslibrary.provider.TypesLibraryItemProviderAdapterFactory;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

public class TypesServices {
	
	private AdapterFactoryLabelProvider labelProvider = null;
	
	private AdapterFactoryLabelProvider getLabelProvider() {
		if (labelProvider == null) {
			labelProvider = new AdapterFactoryLabelProvider(new TypesLibraryItemProviderAdapterFactory());
		}
		return labelProvider;
	}
	
	public String getType(TypeInstance typeInstance) {
		// Handle enum types to add quotes
		if (typeInstance != null
				&& typeInstance.getNativeType() != null
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
		return isTargetOracleTypesLibrary(physicalTypesLibrary);
	}
	
	public boolean isTargetMySqlOrMariaDB(DatabaseElement element) {
		return isTargetMySql(element) || isTargetMariaDB(element);
	}
	
	public boolean isTargetMySql(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isTargetMysqlTypesLibrary(physicalTypesLibrary);
	}
	
	public boolean isTargetMariaDB(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isTargetMariaDBTypesLibrary(physicalTypesLibrary);
	}
	
	public boolean isTargetSqlServer(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isTargetSqlServerTypesLibrary(physicalTypesLibrary);
	}
	
	public boolean isTargetPostgreSQL(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isTargetPostgreSQLTypesLibrary(physicalTypesLibrary);
	}

	public boolean isTargetH2(DatabaseElement element) {
		TypesLibrary physicalTypesLibrary = getPhysicalTypesLibrary(element);
		return isTargetH2TypesLibrary(physicalTypesLibrary);
	}

	private TypesLibraryUser getTypesLibraryUser(DatabaseElement element) {
		if (element instanceof TypesLibraryUser) {
			return (TypesLibraryUser)element;
		} else {
			EObject container = element.eContainer();
			if (container != null && container instanceof DatabaseElement) {
				return getTypesLibraryUser((DatabaseElement)container);
			}
		}
		return null;
	}
	
	private TypesLibrary getTargetPhysicalTypesLibrary(TypesLibraryUser tlu) {
		if (tlu != null) {
			for (TypesLibrary library : tlu.getUsedLibraries()) {
				if (isTargetPhysicalTypesLibrary(library)) {
					return library;
				}
			}
		}
		return null;
	}
	
	private boolean isTargetPhysicalTypesLibrary(TypesLibrary targetTypesLibrary) {
		return targetTypesLibrary.getKind() == TypesLibraryKind.PHYSICAL_TYPES;
	}
	
	private boolean isTargetOracleTypesLibrary(TypesLibrary targetTypesLibrary) {
		return targetTypesLibrary != null && TypesLibraryUtil.ORACLE_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
	
	private boolean isTargetMysqlTypesLibrary(TypesLibrary targetTypesLibrary) {
		return targetTypesLibrary != null && TypesLibraryUtil.MYSQL_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
	
	private boolean isTargetMariaDBTypesLibrary(TypesLibrary targetTypesLibrary) {
		return targetTypesLibrary != null && TypesLibraryUtil.MARIADB_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
	
	private boolean isTargetSqlServerTypesLibrary(TypesLibrary targetTypesLibrary) {
		return targetTypesLibrary != null && TypesLibraryUtil.SQLSERVER_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
	
	
	private boolean isTargetH2TypesLibrary(TypesLibrary targetTypesLibrary) {
		return targetTypesLibrary != null && TypesLibraryUtil.H2_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
	
	
	private boolean isTargetPostgreSQLTypesLibrary(TypesLibrary targetTypesLibrary) {
		return targetTypesLibrary != null && TypesLibraryUtil.POSTGRES_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
}
