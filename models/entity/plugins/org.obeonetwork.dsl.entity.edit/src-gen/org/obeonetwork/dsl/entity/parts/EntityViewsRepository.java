/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.parts;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr>Jérôme Benois</a>
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
