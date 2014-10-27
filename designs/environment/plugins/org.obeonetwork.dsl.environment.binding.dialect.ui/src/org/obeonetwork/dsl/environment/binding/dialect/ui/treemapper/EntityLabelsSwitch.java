package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper;

import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.util.EntitySwitch;

public class EntityLabelsSwitch extends EntitySwitch<String> {
	
	public String getLabel(EObject eObject) {
		return doSwitch(eObject);
	}

	@Override
	public String caseEntity(Entity object) {
		return object.getName() + " : Entity";
	}

	@Override
	public String defaultCase(EObject object) {
		return "";
	}
}
