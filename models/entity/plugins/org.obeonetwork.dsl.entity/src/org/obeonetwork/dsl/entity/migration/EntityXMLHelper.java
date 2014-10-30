package org.obeonetwork.dsl.entity.migration;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;

public class EntityXMLHelper extends XMIHelperImpl {

	public EntityXMLHelper(XMLResource migrationResourceImpl) {
		super(migrationResourceImpl);
	}
	
	@Override
	public void setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		
		// TODO migration code here !!!
		super.setValue(object, feature, value, position);
	}
	
	@Override
	public EObject createObject(EFactory eFactory, EClassifier type) {
		if (type == EnvironmentPackage.eINSTANCE.getType()) {
			return super.createObject(eFactory, EntityPackage.Literals.ENTITY);
		}
		if (type == EnvironmentPackage.eINSTANCE.getDataType()) {
			return super.createObject(EnvironmentFactory.eINSTANCE, EnvironmentPackage.Literals.PRIMITIVE_TYPE);
		}
		return super.createObject(eFactory, type);
	}
}
