package org.obeonetwork.dsl.database.sqlgen;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryKind;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryUser;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

public class TypesServices {
	
	private AdapterFactoryLabelProvider labelProvider = null;
	
	private AdapterFactoryLabelProvider getLabelProvider() {
		if (labelProvider == null) {
			labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}
		return labelProvider;
	}
	
	public String getType(TypeInstance typeInstance) {
		return getLabelProvider().getText(typeInstance);
	}

	public boolean isTargetOracle(DatabaseElement element) {
		TypesLibraryUser tlu = getTypesLibraryUser(element);
		TypesLibrary physicalTypesLibrary = getTargetPhysicalTypesLibrary(tlu);
		return isTargetOracleTypesLibrary(physicalTypesLibrary);
	}
	
	public boolean isTargetMySql(DatabaseElement element) {
		TypesLibraryUser tlu = getTypesLibraryUser(element);
		TypesLibrary physicalTypesLibrary = getTargetPhysicalTypesLibrary(tlu);
		return isTargetMysqlTypesLibrary(physicalTypesLibrary);
	}
	
	public boolean isTargetSqlServer(DatabaseElement element) {
		TypesLibraryUser tlu = getTypesLibraryUser(element);
		TypesLibrary physicalTypesLibrary = getTargetPhysicalTypesLibrary(tlu);
		return isTargetSqlServerTypesLibrary(physicalTypesLibrary);
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
	
	private boolean isTargetSqlServerTypesLibrary(TypesLibrary targetTypesLibrary) {
		return targetTypesLibrary != null && TypesLibraryUtil.SQLSERVER_PATHMAP.equals(targetTypesLibrary.eResource().getURI().toString());
	}
}
