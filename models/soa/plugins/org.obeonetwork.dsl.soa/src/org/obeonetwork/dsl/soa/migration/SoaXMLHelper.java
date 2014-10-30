package org.obeonetwork.dsl.soa.migration;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.obeonetwork.dsl.environment.EnvironmentFactory;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.soa.SoaPackage;

public class SoaXMLHelper extends XMIHelperImpl {

	public SoaXMLHelper(XMLResource migrationResourceImpl) {
		super(migrationResourceImpl);
	}
	
	@Override
	public void setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		if (feature == SoaPackage.Literals.SERVICE__SYNCHRONIZATION) {
			if ("asynchrone".equals(value)) {
					super.setValue(object, feature, "asynchronous", position);
					return;
			}
		}
		
		super.setValue(object, feature, value, position);
	}
	
	@Override
	public EObject createObject(EFactory eFactory, EClassifier type) {
		if (type == EnvironmentPackage.Literals.REFERENCE) {
			// In old Environment metamodel, Reference.navigable was false by default
			// In new Environment metamodel, Reference.navigable is true by default
			EObject createdObject = super.createObject(eFactory, type);
			if (createdObject instanceof Reference) {
				((Reference)createdObject).setNavigable(false);
			}
			return createdObject;
		}
		if (type == EnvironmentPackage.Literals.DTO) {
			return super.createObject(EnvironmentFactory.eINSTANCE, type);
		}
		if (type == EnvironmentPackage.Literals.DATA_TYPE) {
			return super.createObject(EnvironmentFactory.eINSTANCE, EnvironmentPackage.Literals.PRIMITIVE_TYPE);
		}
		
		return super.createObject(eFactory, type);
	}
}
