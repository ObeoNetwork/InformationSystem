/**
 * Generated with Acceleo
 */
package org.obeonetwork.dsl.interaction.providers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.jface.viewers.IFilter;

import org.obeonetwork.dsl.environment.components.MetadataCptPropertiesEditionComponent;

import org.obeonetwork.dsl.environment.edit.specific.policies.CustomPropertiesEditingProvider;

import org.obeonetwork.dsl.interaction.InteractionPackage;
import org.obeonetwork.dsl.interaction.Operand;

import org.obeonetwork.dsl.interaction.components.OperandOperandPropertiesEditionComponent;
import org.obeonetwork.dsl.interaction.components.OperandPropertiesEditionComponent;

/**
 * 
 * 
 */
public class OperandPropertiesEditionProvider extends CustomPropertiesEditingProvider {

	/**
	 * Constructor without provider for super types.
	 */
	public OperandPropertiesEditionProvider() {
		super();
	}

	/**
	 * Constructor with providers for super types.
	 * @param superProviders providers to use for super types.
	 */
	public OperandPropertiesEditionProvider(List<PropertiesEditingProvider> superProviders) {
		super(superProviders);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext) {
		return (editingContext.getEObject() instanceof Operand) 
					&& (InteractionPackage.Literals.OPERAND == editingContext.getEObject().eClass());
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext, String part) {
		return (editingContext.getEObject() instanceof Operand) && (OperandOperandPropertiesEditionComponent.OPERAND_PART.equals(part) || MetadataCptPropertiesEditionComponent.METADATAS_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.Class)
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public boolean provides(PropertiesEditingContext editingContext, java.lang.Class refinement) {
		return (editingContext.getEObject() instanceof Operand) && (refinement == OperandOperandPropertiesEditionComponent.class || refinement == MetadataCptPropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.Class)
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public boolean provides(PropertiesEditingContext editingContext, String part, java.lang.Class refinement) {
		return (editingContext.getEObject() instanceof Operand) && ((OperandOperandPropertiesEditionComponent.OPERAND_PART.equals(part) && refinement == OperandOperandPropertiesEditionComponent.class) || (MetadataCptPropertiesEditionComponent.METADATAS_PART.equals(part) && refinement == MetadataCptPropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode) {
		if (editingContext.getEObject() instanceof Operand) {
			return new OperandPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return super.getPropertiesEditingComponent(editingContext, mode);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode, String part) {
		if (editingContext.getEObject() instanceof Operand) {
			if (OperandOperandPropertiesEditionComponent.OPERAND_PART.equals(part))
				return new OperandOperandPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (MetadataCptPropertiesEditionComponent.METADATAS_PART.equals(part))
				return new MetadataCptPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return super.getPropertiesEditingComponent(editingContext, mode, part);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode, String part, java.lang.Class refinement) {
		if (editingContext.getEObject() instanceof Operand) {
			if (OperandOperandPropertiesEditionComponent.OPERAND_PART.equals(part)
				&& refinement == OperandOperandPropertiesEditionComponent.class)
				return new OperandOperandPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (MetadataCptPropertiesEditionComponent.METADATAS_PART.equals(part)
				&& refinement == MetadataCptPropertiesEditionComponent.class)
				return new MetadataCptPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return super.getPropertiesEditingComponent(editingContext, mode, part, refinement);
	}

	/**
	 * Provides the filter used by the plugin.xml to assign part forms.
	 */
	public static class EditionFilter implements IFilter {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
		 */
		public boolean select(Object toTest) {
			EObject eObj = EEFUtils.resolveSemanticObject(toTest);
			return eObj != null && InteractionPackage.Literals.OPERAND == eObj.eClass();
		}
		
	}

}
