/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.parts;

/**
 * 
 * 
 */
public class TypeslibraryViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * NativeTypesLibrary view descriptor
	 * 
	 */
	public static class NativeTypesLibrary {
		public static class Properties {
	
			
			public static String name = "typeslibrary::NativeTypesLibrary::properties::name";
			
			
			public static String nativeTypes = "typeslibrary::NativeTypesLibrary::properties::nativeTypes";
			
	
		}
	
	}

	/**
	 * TypeInstance view descriptor
	 * 
	 */
	public static class TypeInstance {
		public static class Properties {
	
			
			public static String type = "typeslibrary::TypeInstance::properties::type";
			
				public static class TypeAttributes {
			
					
					public static String length = "typeslibrary::TypeInstance::properties::typeAttributes::length";
					
					
					public static String precision = "typeslibrary::TypeInstance::properties::typeAttributes::precision";
					
			
				}
			
			
			public static String literals = "typeslibrary::TypeInstance::properties::literals";
			
	
		}
	
	}

	/**
	 * NativeType view descriptor
	 * 
	 */
	public static class NativeType {
		public static class Properties {
	
			
			public static String name = "typeslibrary::NativeType::properties::name";
			
			
			public static String spec = "typeslibrary::NativeType::properties::spec";
			
			
			public static String mapsTo = "typeslibrary::NativeType::properties::mapsTo";
			
	
		}
	
	}

	/**
	 * ComplexNamedType view descriptor
	 * 
	 */
	public static class ComplexNamedType {
		public static class Properties {
	
			
			public static String name = "typeslibrary::ComplexNamedType::properties::name";
			
			
			public static String types = "typeslibrary::ComplexNamedType::properties::types";
			
	
		}
	
	}

	/**
	 * SimpleNamedType view descriptor
	 * 
	 */
	public static class SimpleNamedType {
		public static class Properties {
	
			
			public static String name = "typeslibrary::SimpleNamedType::properties::name";
			
			
			public static String type = "typeslibrary::SimpleNamedType::properties::type";
			
	
		}
	
	}

	/**
	 * UserDefinedTypeRef view descriptor
	 * 
	 */
	public static class UserDefinedTypeRef {
		public static class Properties {
	
			
			public static String type = "typeslibrary::UserDefinedTypeRef::properties::type";
			
	
		}
	
	}

	/**
	 * UserDefinedTypesLibrary view descriptor
	 * 
	 */
	public static class UserDefinedTypesLibrary {
		public static class Properties {
	
			
			public static String name = "typeslibrary::UserDefinedTypesLibrary::properties::name";
			
			
			public static String userDefinedTypes = "typeslibrary::UserDefinedTypesLibrary::properties::userDefinedTypes";
			
	
		}
	
	}

}
