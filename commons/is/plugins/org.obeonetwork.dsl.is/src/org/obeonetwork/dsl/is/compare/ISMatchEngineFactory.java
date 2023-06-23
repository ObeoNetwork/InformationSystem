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
package org.obeonetwork.dsl.is.compare;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.eobject.IdentifierEObjectMatcher;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.obeonetwork.dsl.database.DatabaseElement;
import org.obeonetwork.dsl.is.Activator;

import com.google.common.base.Function;

public class ISMatchEngineFactory implements IMatchEngine.Factory {
	
	private static final String EXTENSION_POINT_ID = "org.obeonetwork.dsl.is.compare.matcher";
	private int ranking;

	public ISMatchEngineFactory() {
	}

	public IMatchEngine getMatchEngine() {
		
		Function<EObject, String> idFunction = new Function<EObject, String>() {
			public String apply(EObject input) {
				if (input instanceof DatabaseElement) {
					// We want the database match engine factory to be used for Database elements
					return null;
				}
				// a null return here tells the match engine to fall back to the other matchers
				return getIdentifier(input);
			}
		};
		IEObjectMatcher customIDMatcher = new IdentifierEObjectMatcher(getSpecificEObjectMatcher(), idFunction);
		 
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());

		return new DefaultMatchEngine(customIDMatcher, comparisonFactory);
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int 	ranking) {
		this.ranking = ranking;
	}

	public boolean isMatchEngineFactoryFor(IComparisonScope scope) {
		return true;
	}

	private String getIdentifier(EObject eObject) {
		String identifier;
		if (eObject == null) {
			identifier = null;
		} else if (eObject.eIsProxy()) {
			identifier = ((InternalEObject)eObject).eProxyURI().fragment();
		} else {
			identifier = EcoreUtil.getID(eObject);
			if (identifier == null) {
				final Resource eObjectResource = eObject.eResource();
				if (eObjectResource instanceof XMIResource) {
					identifier = ((XMIResource)eObjectResource).getID(eObject);
				}
			}
		}
		return identifier;
	}
	
	private IEObjectMatcher getSpecificEObjectMatcher() {
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT_ID);
		try {
			for (IConfigurationElement element : elements) {
				Object executable = element.createExecutableExtension("class");
				if (executable instanceof IEObjectMatcherProvider) {
					return ((IEObjectMatcherProvider) executable).getMatcher();
				}
			}
		} catch (CoreException ex) {
			Status status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error while loading extension point " + EXTENSION_POINT_ID, ex);
			Activator.getDefault().getLog().log(status);
		}
		return null;
	}
}
