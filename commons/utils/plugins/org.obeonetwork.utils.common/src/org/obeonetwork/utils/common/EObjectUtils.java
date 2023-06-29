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
package org.obeonetwork.utils.common;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EObjectUtils {

	public static Collection<Resource> getAllResources(EObject any) {
		Resource eResource = any.eResource();
		if (eResource != null) {
			ResourceSet resourceSet = eResource.getResourceSet();
			if (resourceSet != null) {
				return resourceSet.getResources();
			}
		}
		return Collections.emptyList();
	}

	public static <T extends EObject> T setEDataTypeValue(T eObject, EAttribute attribute, String literalValue) {
		if(literalValue.trim().isEmpty() && attribute.getDefaultValueLiteral() == null && attribute.isUnsettable()) {
			eObject.eUnset(attribute);
		} else {
			EFactory eFactory = EcorePackage.eINSTANCE.getEcoreFactory();
			EDataType eDataType = attribute.getEAttributeType();
			try {
				Object value = eFactory.createFromString(eDataType, literalValue);
				eObject.eSet(attribute, value);
			} catch (IllegalArgumentException e) {
				// Ignore attempts to set an illegal value
			}
		}
		
		return eObject;
	}
	
	/**
	 * @param eObject
	 * @return A list of ancestors in descending order, going from the model root to the parent of the given object.
	 */
	public static List<EObject> getAncestors(EObject eObject) {
		if (eObject.eContainer() != null) {
			List<EObject> ancestors = getAncestors(eObject.eContainer());
			ancestors.add(eObject.eContainer());
			return ancestors;
		} else {
			return new ArrayList<EObject>();
		}
	}
	
	public static <T extends EObject> T getContainerOrSelf(EObject eObject, Class<T> type) {
		EObject container = eObject;
		T matchingContainer = null;
		while(container != null && matchingContainer == null) {
			if(type.isInstance(container)) {
				matchingContainer = type.cast(container);
			}
			container = container.eContainer();
		}

		return matchingContainer;
	}
	
	public static <T extends EObject> T getContainer(EObject eObject, Class<T> type) {
		return getContainerOrSelf(eObject.eContainer(), type);
	}
	
	private static EList<?> getMultiFeatureValues(EObject eReferencer, String featureName) {
		EList<?> values = null;
		EStructuralFeature feature = eReferencer.eClass().getEStructuralFeature(featureName);
		if(feature != null && feature.isMany()) {
			Object valuesRaw = eReferencer.eGet(feature);
			if(valuesRaw instanceof EList) {
				values = (EList<?>) valuesRaw;
			}			
		}
		return values;
	}
	
	public static Object moveUp(EObject eReferencer, Object object, String featureName) {
		EList<?> values = getMultiFeatureValues(eReferencer, featureName);
		if(values != null) {
			values.move(Math.max(0, values.indexOf(object) - 1), values.indexOf(object));
		}
		return object;
	}
	
	public static Object moveDown(EObject eReferencer, Object object, String featureName) {
		EList<?> values = getMultiFeatureValues(eReferencer, featureName);
		if(values != null) {
			values.move(Math.min(values.size() - 1, values.indexOf(object) + 1), values.indexOf(object));
		}
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public static Object replaceValue(EObject eReferencer, Object oldValue, Object newValue, String featureName) {
		EList<?> values = getMultiFeatureValues(eReferencer, featureName);
		if (values != null) {
			int indexOfOldValue = values.indexOf(oldValue);
			if (indexOfOldValue != -1) {
				((EList<Object>) values).set(indexOfOldValue, newValue);
			}
		}
		return newValue;
	}
	
	public static EList<?> removeValue(EObject eReferencer, Object value, String featureName) {
		EList<?> values = getMultiFeatureValues(eReferencer, featureName);
		if (values != null) {
			values.remove(value);
		}
		return values;
	}
	
	/**
	 * Returns the name of the root package of a model element
	 * @param eObject an {@link EObject}
	 * @return the name as a {@link String}
	 */
	public static String getMetamodelRootPackageName(EObject eObject) {
		String packageName = null;
		EObject rootContainer = EcoreUtil.getRootContainer(eObject, true);		
		
		if (rootContainer != null) {
			EClass clazz = rootContainer.eClass();	
			packageName = clazz.getEPackage().getName();
		}
		
		return packageName;
	}
	
	public static List<EObject> toEObjectList(Object object) {
		
		List<EObject> list;
		if(object instanceof List) {
			list = ((List<?>)object).stream().filter(EObject.class::isInstance).map(EObject.class::cast).collect(toList());
		} else if(object instanceof EObject) {
			list = Collections.singletonList((EObject)object);
		} else {
			list = Collections.emptyList();
		}
		
		return list;
	}
	
}
 