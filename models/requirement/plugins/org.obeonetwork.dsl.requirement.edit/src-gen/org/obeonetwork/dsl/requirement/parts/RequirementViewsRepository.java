/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.requirement.parts;

/**
 * 
 * 
 */
public class RequirementViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Repository view descriptor
	 * 
	 */
	public static class Repository {
		public static class Repository_ {
	
			
			public static String name = "requirement::Repository::Repository_::name";
			
			
			public static String mainCategories = "requirement::Repository::Repository_::mainCategories";
			
			
			public static String referencedObject = "requirement::Repository::Repository_::referencedObject";
			
	
		}
	
	}

	/**
	 * Category view descriptor
	 * 
	 */
	public static class Category {
		public static class Category_ {
	
			
			public static String id = "requirement::Category::Category_::id";
			
			
			public static String name = "requirement::Category::Category_::name";
			
			
			public static String requirements = "requirement::Category::Category_::requirements";
			
			
			public static String subCategories = "requirement::Category::Category_::subCategories";
			
	
		}
	
	}

	/**
	 * Requirement view descriptor
	 * 
	 */
	public static class Requirement_ {
	
	public static String type = "requirement::Requirement_::type";
	
	
	public static String subtype = "requirement::Requirement_::subtype";
	
	
	public static String id = "requirement::Requirement_::id";
	
	
	public static String name = "requirement::Requirement_::name";
	
	// Start of user code for version ElementEditor key
	public static String version = "requirement::Requirement_::version";
	// End of user code
	
	
	public static String status = "requirement::Requirement_::status";
	
	
	public static String statement = "requirement::Requirement_::statement";
	
	
	public static String modifiedOn = "requirement::Requirement_::modifiedOn";
	
	
	public static String createdOn = "requirement::Requirement_::createdOn";
	
	}

	/**
	 * Advanced view descriptor
	 * 
	 */
	public static class Advanced {
	
	public static String rationale = "requirement::Advanced::rationale";
	
	
	public static String acceptanceCriteria = "requirement::Advanced::acceptanceCriteria";
	
	
	public static String referencedObject = "requirement::Advanced::referencedObject";
	
	}

}
