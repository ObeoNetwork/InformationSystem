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
package org.obeonetwork.dsl.entity.parts;

/**
 * @author Obeo
 * 
 */
public class EntityViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Root view descriptor
	 * 
	 */
	public static class Root {
		public static class Properties {
	
			
			public static String name = "entity::Root::properties::name";
			
			
			public static String description = "entity::Root::properties::description";
			
	
		}
	
	}

	/**
	 * Entity view descriptor
	 * 
	 */
	public static class Entity_ {
		public static class Properties {
	
			
			public static String name = "entity::Entity_::properties::name";
			
			
			public static String superType = "entity::Entity_::properties::superType";
			
			
			public static String associatedTypes = "entity::Entity_::properties::associatedTypes";
			
			
			public static String description = "entity::Entity_::properties::description";
			
	
		}
	
	}

	/**
	 * Persistence view descriptor
	 * 
	 */
	public static class Persistence {
		public static class Properties {
	
			
			public static String estimatedVolumetry = "entity::Persistence::properties::estimatedVolumetry";
			
			
			public static String estimatedAccess = "entity::Persistence::properties::estimatedAccess";
			
			
			public static String historized = "entity::Persistence::properties::historized";
			
			
			public static String inheritanceKind = "entity::Persistence::properties::inheritanceKind";
			
	
		}
	
	}

	/**
	 * Finder view descriptor
	 * 
	 */
	public static class Finder {
		public static class Properties {
	
			
			public static String customizedName = "entity::Finder::properties::customizedName";
			
			
			public static String multiplicity = "entity::Finder::properties::multiplicity";
			
			
			public static String description = "entity::Finder::properties::description";
			
	
		}
	
	}

	/**
	 * InternalCriterion view descriptor
	 * 
	 */
	public static class InternalCriterion {
		public static class Properties {
	
			
			public static String target = "entity::InternalCriterion::properties::target";
			
			
			public static String description = "entity::InternalCriterion::properties::description";
			
	
		}
	
	}

	/**
	 * ExternalCriterion view descriptor
	 * 
	 */
	public static class ExternalCriterion {
		public static class Properties {
	
			
			public static String name = "entity::ExternalCriterion::properties::name";
			
			
			public static String type = "entity::ExternalCriterion::properties::type";
			
			
			public static String description = "entity::ExternalCriterion::properties::description";
			
	
		}
	
	}

}
