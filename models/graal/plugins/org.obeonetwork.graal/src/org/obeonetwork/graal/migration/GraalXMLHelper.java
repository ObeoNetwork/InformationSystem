package org.obeonetwork.graal.migration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;

public class GraalXMLHelper extends XMIHelperImpl {

	public GraalXMLHelper(XMLResource migrationResourceImpl) {
		super(migrationResourceImpl);
	}
	
	@Override
	public void setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		
		// TODO migration code here !!!
		super.setValue(object, feature, value, position);
	}
}
