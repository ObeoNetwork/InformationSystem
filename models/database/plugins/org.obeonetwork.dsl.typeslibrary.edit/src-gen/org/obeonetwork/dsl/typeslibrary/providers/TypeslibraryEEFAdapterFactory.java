/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.providers;

import org.eclipse.emf.common.notify.Adapter;

import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryAdapterFactory;

/**
 * 
 * 
 */
public class TypeslibraryEEFAdapterFactory extends TypesLibraryAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.typeslibrary.util.TypesLibraryAdapterFactory#createNativeTypesLibraryAdapter()
	 * 
	 */
	public Adapter createNativeTypesLibraryAdapter() {
		return new NativeTypesLibraryPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.typeslibrary.util.TypesLibraryAdapterFactory#createTypeInstanceAdapter()
	 * 
	 */
	public Adapter createTypeInstanceAdapter() {
		return new TypeInstancePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.typeslibrary.util.TypesLibraryAdapterFactory#createNativeTypeAdapter()
	 * 
	 */
	public Adapter createNativeTypeAdapter() {
		return new NativeTypePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.typeslibrary.util.TypesLibraryAdapterFactory#createComplexNamedTypeAdapter()
	 * 
	 */
	public Adapter createComplexNamedTypeAdapter() {
		return new ComplexNamedTypePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.typeslibrary.util.TypesLibraryAdapterFactory#createSimpleNamedTypeAdapter()
	 * 
	 */
	public Adapter createSimpleNamedTypeAdapter() {
		return new SimpleNamedTypePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.typeslibrary.util.TypesLibraryAdapterFactory#createUserDefinedTypeRefAdapter()
	 * 
	 */
	public Adapter createUserDefinedTypeRefAdapter() {
		return new UserDefinedTypeRefPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.dsl.typeslibrary.util.TypesLibraryAdapterFactory#createUserDefinedTypesLibraryAdapter()
	 * 
	 */
	public Adapter createUserDefinedTypesLibraryAdapter() {
		return new UserDefinedTypesLibraryPropertiesEditionProvider();
	}

}
