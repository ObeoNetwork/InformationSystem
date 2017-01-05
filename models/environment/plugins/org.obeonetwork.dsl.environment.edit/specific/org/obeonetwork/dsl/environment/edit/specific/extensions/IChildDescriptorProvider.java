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
package org.obeonetwork.dsl.environment.edit.specific.extensions;

import java.util.Collection;

import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;

public interface IChildDescriptorProvider {

	/**
	 * 
	 * @param object
	 * @return if the object is a FilterContainer
	 */
	public boolean provides(Object object);
	
	/**
	 * 
	 * @param object
	 * @return a command parameter with an entity filter
	 */
	public CommandParameter getEntityFilter(Object object);
	
	/**
	 * create an entity filter
	 * @return en entityFilter
	 */
	public Object createEntityFilter();
	
	/**
	 * 
	 * @param object
	 * @return if objec is an attribute
	 */
	public boolean instanceOfAttribute(Object object);
	
	/**
	 * 
	 * @param object
	 * @return if object is a reference
	 */
	public boolean instanceOfReference(Object object);
	
	/**
	 * 
	 * @param object
	 * @return if object is a block
	 */
	public boolean instanceOfBlock(Object object);
	
	/**
	 * 
	 * @param object
	 * @return if object is a root
	 */
	public boolean instanceOfRoot(Object object);
	
	/**
	 * 
	 * @param object
	 * @return if object is a entity
	 */
	public boolean instanceOfEntity(Object object);
	
	/**
	 * 
	 * @param object
	 * @return if object is a property
	 */
	public boolean instanceOfProperty(Object object);
	
	/**
	 * Add an attribute to an entity filter
	 * @param editingDomain
	 * @param entityFilter
	 * @param attribute
	 */
	@SuppressWarnings("unchecked")
	public void addPropertiesToFilter(EditingDomain editingDomain, Object entityFilter, Collection properties);
	
	/**
	 * Remove an attribute to an entity filter
	 * @param editingDomain
	 * @param entityFilter
	 * @param property 
	 * @param attribute
	 */
	@SuppressWarnings("unchecked")
	public void removePropertiesToFilter(EditingDomain editingDomain, Object entityFilter, Collection properties, Object property);

	
	/**
	 * Add a reference to an entity to an entity filter
	 * @param editingDomain
	 * @param entityFilter
	 * @param attribute
	 */
	public void addEntityToFilter(EditingDomain editingDomain, Object entityFilter, Object entity);
	
	/**
	 * 
	 * @param object
	 * @return the attributes and the references of the entity object
	 */
	@SuppressWarnings("unchecked")
	public Collection getEntityProperties(Object object);
	
	/**
	 * 
	 * @param object
	 * @return the entities of the block object
	 */
	@SuppressWarnings("unchecked")
	public Collection getBlockEntities(Object object);
	
	/**
	 * 
	 * @param object
	 * @return all the entities 
	 */
	@SuppressWarnings("unchecked")
	public Collection getAllEntities(Object object);
	
	/**
	 * @param object
	 * return all the properties of the model
	 */
	@SuppressWarnings("unchecked")
	public Collection getAllProperties(Object root);
	
	/**
	 * 
	 * @param DTO
	 * @return all the filtered properties of the DTO
	 */
	@SuppressWarnings("unchecked")
	public Collection getPropertiesDTO(Object DTO);
}
