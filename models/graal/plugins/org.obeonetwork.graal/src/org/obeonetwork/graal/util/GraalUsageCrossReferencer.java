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
package org.obeonetwork.graal.util;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;

/**
 * UsageCrossReferencer used create derived cross referencers
 * @author sthibaudeau
 *
 */
public abstract class GraalUsageCrossReferencer {
	public Collection<Setting> findUsage(EObject eObject) {
		SpecificUsageCrossReferencer delegatedCrossReferencer = initCrossReferencer(eObject);
		return delegatedCrossReferencer.findUsage(eObject);
	}
	
	protected SpecificUsageCrossReferencer initCrossReferencer(EObject eObject) {
		if (eObject.eResource() != null) {
			if (eObject.eResource().getResourceSet() != null) {
				return new SpecificUsageCrossReferencer(eObject.eResource().getResourceSet());
			} else {
				return new SpecificUsageCrossReferencer(eObject.eResource());
			}
		} else {
			return new SpecificUsageCrossReferencer(getRootContainer(eObject));
		}
	}
	
	private EObject getRootContainer(EObject eObject) {
		if (eObject.eContainer() != null) {
			return getRootContainer(eObject.eContainer()); 
		} else {
			return eObject;
		}
	}
	
	private boolean delegatedCrossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject) {
		return crossReference(eObject, eReference, crossReferencedEObject);
	}
	
	abstract protected boolean crossReference(EObject eObject, EReference eReference, EObject crossReferencedEObject);

	private boolean delegatedContainment(EObject eObject) {
		return containment(eObject);
	}
	
	abstract protected boolean containment(EObject eObject);

	private class SpecificUsageCrossReferencer extends UsageCrossReferencer {

		private static final long serialVersionUID = 1L;

		public SpecificUsageCrossReferencer(Collection<?> eObjects) {
			super(eObjects);
		}

		public SpecificUsageCrossReferencer(EObject eObject) {
			super(eObject);
		}

		public SpecificUsageCrossReferencer(Resource resource) {
			super(resource);
		}

		public SpecificUsageCrossReferencer(ResourceSet resourceSet) {
			super(resourceSet);
		}
		
		@Override
		protected boolean crossReference(	EObject eObject,
											EReference eReference,
											EObject crossReferencedEObject) {
			return super.crossReference(eObject, eReference, crossReferencedEObject)
					&& delegatedCrossReference(eObject, eReference, crossReferencedEObject);
		}

		@Override
		protected boolean containment(EObject eObject) {
			return super.containment(eObject) && delegatedContainment(eObject);
		}
		
		public Collection<Setting> findUsage(EObject eObject) {
			return super.findUsage(eObject);
		}
	}
}
