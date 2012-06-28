package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.environment.Attribute;
import org.obeonetwork.dsl.environment.DTO;
import org.obeonetwork.dsl.environment.MultiplicityKind;
import org.obeonetwork.dsl.environment.Reference;
import org.obeonetwork.dsl.environment.util.EnvironmentSwitch;

public class DtoLabelsSwitch extends EnvironmentSwitch<String> {
	
	public String getLabel(EObject eObject) {
		return doSwitch(eObject);
	}

	@Override
	public String caseDTO(DTO object) {
		return object.getName() + " : DTO";
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
