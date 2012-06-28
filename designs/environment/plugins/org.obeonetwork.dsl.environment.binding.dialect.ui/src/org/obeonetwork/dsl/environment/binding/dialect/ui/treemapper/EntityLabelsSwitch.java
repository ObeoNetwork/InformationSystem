package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.entity.Attribute;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.Reference;
import org.obeonetwork.dsl.entity.util.EntitySwitch;
import org.obeonetwork.dsl.environment.MultiplicityKind;

public class EntityLabelsSwitch extends EntitySwitch<String> {
	
	public String getLabel(EObject eObject) {
		return doSwitch(eObject);
	}

	@Override
	public String caseEntity(Entity object) {
		return object.getName() + " : Entity";
	}

	@Override
	public String caseAttribute(Attribute object) {
		String label = object.getName();
		if (object.getType() != null && object.getType().getName() != null) {
			label += " : " + object.getType().getName();
		}
		if (object.getMultiplicity() != null
				&& (object.getMultiplicity().equals(MultiplicityKind.ZERO_STAR_LITERAL)
					|| object.getMultiplicity().equals(MultiplicityKind.ONE_STAR_LITERAL))) {
			label += " [*]";
		}
		return label;
	}

	@Override
	public String caseReference(Reference object) {
		String label = object.getName();
		if (object.getType() != null && object.getType().getName() != null) {
			label += " : " + object.getType().getName();
		}
		if (object.getMultiplicity() != null
				&& (object.getMultiplicity().equals(MultiplicityKind.ZERO_STAR_LITERAL)
					|| object.getMultiplicity().equals(MultiplicityKind.ONE_STAR_LITERAL))) {
			label += " [*]";
		}
		return label;
	}

	@Override
	public String defaultCase(EObject object) {
		return "";
	}
}
