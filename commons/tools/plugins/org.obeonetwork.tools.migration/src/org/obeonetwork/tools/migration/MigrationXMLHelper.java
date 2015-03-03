package org.obeonetwork.tools.migration;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;

public class MigrationXMLHelper extends XMIHelperImpl {
	
	private IMigrationHelper migrationHelper;
	
	public MigrationXMLHelper(XMLResource resource, IMigrationHelper migrationHelper) {
		super(resource);
		this.migrationHelper = migrationHelper;
	}
	
	@Override
	public EObject createObject(EFactory eFactory, EClassifier type) {
		if (migrationHelper.isMigrationNeeded()) {
			EObject object = migrationHelper.createObject(eFactory, type, this);
			if (object != null) {
				return object;
			}
		}
		
		// Check if factory and type match
		if (!eFactory.getEPackage().equals(type.getEPackage())) {
			return super.createObject(type.getEPackage().getEFactoryInstance(), type);
		}
		
		return super.createObject(eFactory, type);
	}
	
	public EObject originalCreateObject(EFactory eFactory, EClassifier type) {
		return super.createObject(eFactory, type);
	}
	
	@Override
	public void setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		if (migrationHelper.isMigrationNeeded()) {
			boolean valueSet = migrationHelper.setValue(object, feature, value, position, this);
			if (valueSet == false) {
				originalSetValue(object, feature, value, position);
			}
		} else {
			originalSetValue(object, feature, value, position);
		}
	}
	
	public void originalSetValue(EObject object, EStructuralFeature feature, Object value, int position) {
		super.setValue(object, feature, value, position);
	}
	
}
