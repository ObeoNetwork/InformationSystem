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
package org.obeonetwork.database.transfo.impl;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryFactory;


public class MPDToMLD extends MpdToMldBidiRules {

	@Override
	protected String getTypePropertiesFileName() {
		// Not used for this kind of transformation
		throw new UnsupportedOperationException("Should not be called on Physical to Logical transformations");
	}

	@Override
	protected TypeInstance resolveType(TypeInstance physicalType) {
		if (physicalType.getNativeType() != null) {
			NativeType logicalType = physicalType.getNativeType().getMapsTo();
			if (logicalType != null) {
				TypeInstance typeInstance = TypesLibraryFactory.eINSTANCE.createTypeInstance();
				typeInstance.setLength(physicalType.getLength());
				typeInstance.setPrecision(physicalType.getPrecision());
				typeInstance.setNativeType(logicalType);
				return typeInstance;
			} else {
				String msg = "";
				EObject eContainer = physicalType.eContainer();
				if (eContainer instanceof Column) {
					Column column = (Column)eContainer;
					msg = "[" + column.getOwner().getName() + "." + column.getName() + "] ";
				}
				System.err.println(msg + "Cannot resolve Logical type for : " + physicalType.getNativeType().getName());
			}
		} else {
			System.err.println("Cannot resolve type: " + physicalType);
		}
		return null;
	}

}
