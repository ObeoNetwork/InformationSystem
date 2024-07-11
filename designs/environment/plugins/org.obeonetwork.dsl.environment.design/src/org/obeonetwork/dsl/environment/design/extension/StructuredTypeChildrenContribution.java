package org.obeonetwork.dsl.environment.design.extension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.environment.Property;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.StructuredType;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider.extensionpoint.IBoundableElementChildren;

/**
 * 
 * @author Obeo
 *
 */
public class StructuredTypeChildrenContribution implements IBoundableElementChildren {
	
	private final StructuredTypeLabelsSwitch structuredTypeLabelsSwitch = new StructuredTypeLabelsSwitch();

	@Override
	public List<? extends EObject> getChildren(EObject object) {
		if (object instanceof StructuredType) {
			StructuredType structuredType = (StructuredType) object;
			List<Property> properties = new ArrayList<Property>();
			properties.addAll(structuredType.getAttributes());
			for (StructuredType associatedType : structuredType.getAssociatedTypes()) {
				properties.addAll(associatedType.getAttributes());
			}
			properties.addAll(structuredType.getReferences());
			return properties;
		} else if (object instanceof Reference) {
			Reference entityReference = (Reference) object;
			if (entityReference.getReferencedType() != null) {
				return getChildren(entityReference.getReferencedType());
			}
		}
		return Collections.emptyList();
	}

	@Override
	public List<EClass> getApplicableEClasses() {
		return List.of(
				EnvironmentPackage.eINSTANCE.getStructuredType(), 
				EnvironmentPackage.eINSTANCE.getReference(),
				EnvironmentPackage.eINSTANCE.getAttribute(), 
				EnvironmentPackage.eINSTANCE.getProperty());
	}

	@Override
	public String getLabel(EObject eObject) {
		return structuredTypeLabelsSwitch.getLabel(eObject);
	}
}
