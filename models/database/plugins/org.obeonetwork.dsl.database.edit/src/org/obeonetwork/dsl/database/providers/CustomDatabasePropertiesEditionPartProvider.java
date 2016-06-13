package org.obeonetwork.dsl.database.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.obeonetwork.dsl.database.parts.DatabaseViewsRepository;
import org.obeonetwork.dsl.database.parts.forms.CustomPrimaryKeyPropertiesEditionPartForm;
import org.obeonetwork.dsl.database.parts.impl.CustomPrimaryKeyPropertiesEditionPartImpl;

public class CustomDatabasePropertiesEditionPartProvider extends DatabasePropertiesEditionPartProvider {

	@Override
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == DatabaseViewsRepository.PrimaryKey.class) {
			if (kind == DatabaseViewsRepository.SWT_KIND)
				return new CustomPrimaryKeyPropertiesEditionPartImpl(component);
			if (kind == DatabaseViewsRepository.FORM_KIND)
				return new CustomPrimaryKeyPropertiesEditionPartForm(component);
		}
		return super.getPropertiesEditionPart(key, kind, component);
	}
}
