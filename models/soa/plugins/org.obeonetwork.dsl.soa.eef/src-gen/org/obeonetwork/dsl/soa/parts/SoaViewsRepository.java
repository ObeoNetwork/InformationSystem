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
package org.obeonetwork.dsl.soa.parts;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jerome Benois</a>
 * 
 */
public class SoaViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * System view descriptor
	 * 
	 */
	public static class System {
		public static class Properties {
	
			
			public static String name = "soa::System::properties::name";
			
			
			public static String description = "soa::System::properties::description";
			
	
		}
	
	}

	/**
	 * Component view descriptor
	 * 
	 */
	public static class Component {
		public static class Properties {
	
			
			public static String name = "soa::Component::properties::name";
			
			
			public static String description = "soa::Component::properties::description";
			
	
		}
	
	}

	/**
	 * Service view descriptor
	 * 
	 */
	public static class Service {
		public static class Properties {
	
			
			public static String synchronization = "soa::Service::properties::synchronization";
			
			
			public static String kind = "soa::Service::properties::kind";
			
			
			public static String name = "soa::Service::properties::name";
			
			
			public static String description = "soa::Service::properties::description";
			
	
		}
	
	}

	/**
	 * Wire view descriptor
	 * 
	 */
	public static class Wire {
		public static class Properties {
	
			
			public static String source = "soa::Wire::properties::source";
			
			
			public static String dest = "soa::Wire::properties::dest";
			
			
			public static String description = "soa::Wire::properties::description";
			
	
		}
	
	}

	/**
	 * Binding view descriptor
	 * 
	 */
	public static class Binding {
		public static class Properties {
	
			
			public static String technology = "soa::Binding::properties::technology";
			
			
			public static String description = "soa::Binding::properties::description";
			
	
		}
	
	}

	/**
	 * Interface view descriptor
	 * 
	 */
	public static class Interface_ {
		public static class Properties {
	
			
			public static String name = "soa::Interface::properties::name";
			
			
			public static String description = "soa::Interface::properties::description";
			
	
		}
	
	}

	/**
	 * Operation view descriptor
	 * 
	 */
	public static class Operation {
		public static class Properties {
	
			
			public static String name = "soa::Operation::properties::name";
			
			
			public static String kind = "soa::Operation::properties::kind";
			
			
			public static String public_ = "soa::Operation::properties::public";
			
			
			public static String description = "soa::Operation::properties::description";
			
	
		}
	
	}

	/**
	 * Parameter view descriptor
	 * 
	 */
	public static class Parameter {
		public static class Properties {
	
			
			public static String name = "soa::Parameter::properties::name";
			
			
			public static String multiplicity = "soa::Parameter::properties::multiplicity";
			
			
			public static String isUnique = "soa::Parameter::properties::isUnique";
			
			
			public static String isOrdered = "soa::Parameter::properties::isOrdered";
			
			
			public static String type = "soa::Parameter::properties::type";
			
			
			public static String description = "soa::Parameter::properties::description";
			
	
		}
	
	}

}
