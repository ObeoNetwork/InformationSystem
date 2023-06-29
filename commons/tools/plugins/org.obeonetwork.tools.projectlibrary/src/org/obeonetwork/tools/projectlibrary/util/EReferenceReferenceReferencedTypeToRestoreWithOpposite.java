package org.obeonetwork.tools.projectlibrary.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.obeonetwork.dsl.environment.Reference;

public class EReferenceReferenceReferencedTypeToRestoreWithOpposite extends ToBeRestoredReference {

	protected final Reference oppositeReference;

	public EReferenceReferenceReferencedTypeToRestoreWithOpposite(EObject sourceObject,
			EStructuralFeature referencingFeature, String targetKey, Integer position, boolean canBeRestored,
			final Reference oppositeReference) {
		super(sourceObject, referencingFeature, targetKey, position, canBeRestored);
		this.oppositeReference = oppositeReference;
	}
	
	public Reference getOppositeReference() {
		return oppositeReference;
	}

}
