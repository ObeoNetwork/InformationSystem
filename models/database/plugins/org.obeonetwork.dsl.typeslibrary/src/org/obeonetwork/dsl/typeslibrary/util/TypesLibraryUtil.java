package org.obeonetwork.dsl.typeslibrary.util;

import java.net.URL;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

public class TypesLibraryUtil {
	
	public static NativeType findLogicalType(TypeInstance physicalTypeInstance) {
		NativeType physicalNativeType = physicalTypeInstance.getNativeType();
		NativeType logicalNativeType = physicalNativeType.getMapsTo();
		if(logicalNativeType==null){
			System.err.println("Cannot map physical type: "+physicalNativeType.getName()+" to logical type");	
		}		
		return logicalNativeType;		
	}
	
	
	public static NativeTypesLibrary getLogicalTypesLibrary(ResourceSet resourceSet) {		
		URI typeslibraryURI = URI.createURI("pathmap://LogicalDBTypes");
		Resource resource = resourceSet.getResource(typeslibraryURI, true);
		NativeTypesLibrary nativeTypesLibrary = (NativeTypesLibrary) resource.getContents().get(0);
	    return nativeTypesLibrary;
	}	
	
	public static NativeTypesLibrary loadNativeTypesLibrary(
			String databaseProductName, String databaseProductVersion) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = null;
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			standaloneBootStrap(resourceSet);
		}
		URI typeslibraryURI = null;
		if (databaseProductName.equals("MySQL")) {
			typeslibraryURI = URI.createURI(MYSQL_PATHMAP);
		} else if (databaseProductName.equals("Oracle")) {
			typeslibraryURI = URI.createURI(ORACLE_PATHMAP);
		}
		resource = resourceSet.getResource(typeslibraryURI, true);
		return (NativeTypesLibrary) resource.getContents().get(0);
	}

	public static final String ORACLE_PATHMAP = "pathmap://NativeDBTypes/Oracle-11g";
	public static final String MYSQL_PATHMAP = "pathmap://NativeDBTypes/MySQL-5";

	private static void standaloneBootStrap(ResourceSet resourceSet) {
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(TypesLibraryPackage.eNS_URI,
				TypesLibraryPackage.eINSTANCE);
		registerPathmaps();
	}

	public static void registerPathmaps() {
		final URL mySqlUrl = TypesLibraryUtil.class.getClassLoader()
				.getResource("MySQL-5.typeslibrary");
		URIConverter.URI_MAP.put(URI.createURI(MYSQL_PATHMAP),
				URI.createURI(mySqlUrl.toString()));
		final URL oracleUrl = TypesLibraryUtil.class.getClassLoader()
				.getResource("Oracle-11g.typeslibrary");
		URIConverter.URI_MAP.put(URI.createURI(ORACLE_PATHMAP),
				URI.createURI(oracleUrl.toString()));
	}

}
