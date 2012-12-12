/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.cinematic.view.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.obeonetwork.dsl.cinematic.view.parts.ViewViewsRepository;
import org.obeonetwork.dsl.cinematic.view.parts.forms.DTOBindingPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.view.parts.forms.DTOPropertyBindingPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.view.parts.forms.EntityBindingPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.view.parts.forms.EntityPropertyBindingPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.view.parts.forms.ViewActionPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.view.parts.forms.ViewContainerPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.view.parts.forms.ViewContainerReferencePropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.view.parts.forms.ViewElementPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.view.parts.forms.ViewEventPropertiesEditionPartForm;
import org.obeonetwork.dsl.cinematic.view.parts.impl.DTOBindingPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.view.parts.impl.DTOPropertyBindingPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.view.parts.impl.EntityBindingPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.view.parts.impl.EntityPropertyBindingPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.view.parts.impl.ViewActionPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.view.parts.impl.ViewContainerPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.view.parts.impl.ViewContainerReferencePropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.view.parts.impl.ViewElementPropertiesEditionPartImpl;
import org.obeonetwork.dsl.cinematic.view.parts.impl.ViewEventPropertiesEditionPartImpl;

/**
 * 
 * 
 */
public class ViewPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == ViewViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == ViewViewsRepository.ViewContainer.class) {
			if (kind == ViewViewsRepository.SWT_KIND)
				return new ViewContainerPropertiesEditionPartImpl(component);
			if (kind == ViewViewsRepository.FORM_KIND)
				return new ViewContainerPropertiesEditionPartForm(component);
		}
		if (key == ViewViewsRepository.ViewElement.class) {
			if (kind == ViewViewsRepository.SWT_KIND)
				return new ViewElementPropertiesEditionPartImpl(component);
			if (kind == ViewViewsRepository.FORM_KIND)
				return new ViewElementPropertiesEditionPartForm(component);
		}
		if (key == ViewViewsRepository.ViewAction.class) {
			if (kind == ViewViewsRepository.SWT_KIND)
				return new ViewActionPropertiesEditionPartImpl(component);
			if (kind == ViewViewsRepository.FORM_KIND)
				return new ViewActionPropertiesEditionPartForm(component);
		}
		if (key == ViewViewsRepository.ViewEvent.class) {
			if (kind == ViewViewsRepository.SWT_KIND)
				return new ViewEventPropertiesEditionPartImpl(component);
			if (kind == ViewViewsRepository.FORM_KIND)
				return new ViewEventPropertiesEditionPartForm(component);
		}
		if (key == ViewViewsRepository.EntityBinding.class) {
			if (kind == ViewViewsRepository.SWT_KIND)
				return new EntityBindingPropertiesEditionPartImpl(component);
			if (kind == ViewViewsRepository.FORM_KIND)
				return new EntityBindingPropertiesEditionPartForm(component);
		}
		if (key == ViewViewsRepository.EntityPropertyBinding.class) {
			if (kind == ViewViewsRepository.SWT_KIND)
				return new EntityPropertyBindingPropertiesEditionPartImpl(component);
			if (kind == ViewViewsRepository.FORM_KIND)
				return new EntityPropertyBindingPropertiesEditionPartForm(component);
		}
		if (key == ViewViewsRepository.DTOPropertyBinding.class) {
			if (kind == ViewViewsRepository.SWT_KIND)
				return new DTOPropertyBindingPropertiesEditionPartImpl(component);
			if (kind == ViewViewsRepository.FORM_KIND)
				return new DTOPropertyBindingPropertiesEditionPartForm(component);
		}
		if (key == ViewViewsRepository.DTOBinding.class) {
			if (kind == ViewViewsRepository.SWT_KIND)
				return new DTOBindingPropertiesEditionPartImpl(component);
			if (kind == ViewViewsRepository.FORM_KIND)
				return new DTOBindingPropertiesEditionPartForm(component);
		}
		if (key == ViewViewsRepository.ViewContainerReference.class) {
			if (kind == ViewViewsRepository.SWT_KIND)
				return new ViewContainerReferencePropertiesEditionPartImpl(component);
			if (kind == ViewViewsRepository.FORM_KIND)
				return new ViewContainerReferencePropertiesEditionPartForm(component);
		}
		return null;
	}

}
