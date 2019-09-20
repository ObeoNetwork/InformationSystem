package org.obeonetwork.dsl.is.compare;


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

import com.google.common.base.Function;

public class ISMatchEngineFactory implements IMatchEngine.Factory {
	
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
		// Using this matcher as fall back, EMF Compare will still search for XMI IDs on EObjects
		// for which we had no custom id function.
		//IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.WHEN_AVAILABLE);
		IEObjectMatcher customIDMatcher = new IdentifierEObjectMatcher(idFunction);
		 
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
}
