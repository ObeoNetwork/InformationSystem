/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.typeslibrary.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.obeonetwork.dsl.typeslibrary.parts.TypeslibraryViewsRepository;
import org.obeonetwork.dsl.typeslibrary.parts.forms.ComplexNamedTypePropertiesEditionPartForm;
import org.obeonetwork.dsl.typeslibrary.parts.forms.NativeTypePropertiesEditionPartForm;
import org.obeonetwork.dsl.typeslibrary.parts.forms.NativeTypesLibraryPropertiesEditionPartForm;
import org.obeonetwork.dsl.typeslibrary.parts.forms.SimpleNamedTypePropertiesEditionPartForm;
import org.obeonetwork.dsl.typeslibrary.parts.forms.TypeInstancePropertiesEditionPartForm;
import org.obeonetwork.dsl.typeslibrary.parts.forms.UserDefinedTypeRefPropertiesEditionPartForm;
import org.obeonetwork.dsl.typeslibrary.parts.forms.UserDefinedTypesLibraryPropertiesEditionPartForm;
import org.obeonetwork.dsl.typeslibrary.parts.impl.ComplexNamedTypePropertiesEditionPartImpl;
import org.obeonetwork.dsl.typeslibrary.parts.impl.NativeTypePropertiesEditionPartImpl;
import org.obeonetwork.dsl.typeslibrary.parts.impl.NativeTypesLibraryPropertiesEditionPartImpl;
import org.obeonetwork.dsl.typeslibrary.parts.impl.SimpleNamedTypePropertiesEditionPartImpl;
import org.obeonetwork.dsl.typeslibrary.parts.impl.TypeInstancePropertiesEditionPartImpl;
import org.obeonetwork.dsl.typeslibrary.parts.impl.UserDefinedTypeRefPropertiesEditionPartImpl;
import org.obeonetwork.dsl.typeslibrary.parts.impl.UserDefinedTypesLibraryPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class TypeslibraryPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == TypeslibraryViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == TypeslibraryViewsRepository.NativeTypesLibrary.class) {
			if (kind == TypeslibraryViewsRepository.SWT_KIND)
				return new NativeTypesLibraryPropertiesEditionPartImpl(component);
			if (kind == TypeslibraryViewsRepository.FORM_KIND)
				return new NativeTypesLibraryPropertiesEditionPartForm(component);
		}
		if (key == TypeslibraryViewsRepository.TypeInstance.class) {
			if (kind == TypeslibraryViewsRepository.SWT_KIND)
				return new TypeInstancePropertiesEditionPartImpl(component);
			if (kind == TypeslibraryViewsRepository.FORM_KIND)
				return new TypeInstancePropertiesEditionPartForm(component);
		}
		if (key == TypeslibraryViewsRepository.NativeType.class) {
			if (kind == TypeslibraryViewsRepository.SWT_KIND)
				return new NativeTypePropertiesEditionPartImpl(component);
			if (kind == TypeslibraryViewsRepository.FORM_KIND)
				return new NativeTypePropertiesEditionPartForm(component);
		}
		if (key == TypeslibraryViewsRepository.ComplexNamedType.class) {
			if (kind == TypeslibraryViewsRepository.SWT_KIND)
				return new ComplexNamedTypePropertiesEditionPartImpl(component);
			if (kind == TypeslibraryViewsRepository.FORM_KIND)
				return new ComplexNamedTypePropertiesEditionPartForm(component);
		}
		if (key == TypeslibraryViewsRepository.SimpleNamedType.class) {
			if (kind == TypeslibraryViewsRepository.SWT_KIND)
				return new SimpleNamedTypePropertiesEditionPartImpl(component);
			if (kind == TypeslibraryViewsRepository.FORM_KIND)
				return new SimpleNamedTypePropertiesEditionPartForm(component);
		}
		if (key == TypeslibraryViewsRepository.UserDefinedTypeRef.class) {
			if (kind == TypeslibraryViewsRepository.SWT_KIND)
				return new UserDefinedTypeRefPropertiesEditionPartImpl(component);
			if (kind == TypeslibraryViewsRepository.FORM_KIND)
				return new UserDefinedTypeRefPropertiesEditionPartForm(component);
		}
		if (key == TypeslibraryViewsRepository.UserDefinedTypesLibrary.class) {
			if (kind == TypeslibraryViewsRepository.SWT_KIND)
				return new UserDefinedTypesLibraryPropertiesEditionPartImpl(component);
			if (kind == TypeslibraryViewsRepository.FORM_KIND)
				return new UserDefinedTypesLibraryPropertiesEditionPartForm(component);
		}
		return null;
	}

}
