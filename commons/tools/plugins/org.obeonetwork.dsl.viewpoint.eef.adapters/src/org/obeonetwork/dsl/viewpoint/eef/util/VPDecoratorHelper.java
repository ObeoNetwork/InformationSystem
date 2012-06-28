/**
 * 
 */
package org.obeonetwork.dsl.viewpoint.eef.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.adapters.SemanticAdapter;

import fr.obeo.dsl.viewpoint.DSemanticDecorator;
import fr.obeo.dsl.viewpoint.ViewpointPackage;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 * 
 */
public class VPDecoratorHelper {

	private EObject target;

	/**
	 * @param target
	 */
	public VPDecoratorHelper(EObject target) {
		super();
		this.target = target;
	}

	public boolean canAdapt() {
		return target instanceof EObject;
	}

	public SemanticAdapter createSemanticAdapterFromDSemanticDecorator() {
		if (canAdapt()) {
			if (ViewpointPackage.eINSTANCE.getDSemanticDecorator().isInstance(target)) {
				return new SemanticAdapter() {
					public EObject getEObject() {
						return ((DSemanticDecorator) target).getTarget();
					}
				};
			} else {
				return new SemanticAdapter() {
					public EObject getEObject() {
						return target;
					}
				};
			}
		} else {
			return null;
		}
	}

}
