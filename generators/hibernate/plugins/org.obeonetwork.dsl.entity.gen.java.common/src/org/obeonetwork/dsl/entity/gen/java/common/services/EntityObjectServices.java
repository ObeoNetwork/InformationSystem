package org.obeonetwork.dsl.entity.gen.java.common.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class EntityObjectServices {
	
	public int hashCode(EObject object) {
		return object.hashCode();
	}
	
	public String getUuid(EObject object) {
		return ((XMIResourceImpl)object.eResource()).getID(object);
	}
}
