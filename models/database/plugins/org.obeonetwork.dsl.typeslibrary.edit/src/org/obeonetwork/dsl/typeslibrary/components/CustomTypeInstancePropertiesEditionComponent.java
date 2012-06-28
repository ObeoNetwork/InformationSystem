package org.obeonetwork.dsl.typeslibrary.components;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;
import org.obeonetwork.dsl.typeslibrary.parts.TypeInstancePropertiesEditionPart;

public class CustomTypeInstancePropertiesEditionComponent extends TypeInstancePropertiesEditionComponent {

	public CustomTypeInstancePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject column, String editing_mode) {
		super(editingContext, column, editing_mode);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		super.initPart(key, kind, elt, allResource);
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final TypeInstancePropertiesEditionPart basePart = (TypeInstancePropertiesEditionPart)editingPart;
			updateTypeFieldsVisibility((TypeInstance)elt, basePart);
		}
		setInitializing(false);
	}
	
	@Override
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			TypeInstancePropertiesEditionPart basePart = (TypeInstancePropertiesEditionPart)editingPart;
			if (TypesLibraryPackage.eINSTANCE.getTypeInstance_NativeType().equals((msg.getFeature()))) {
				updateTypeFieldsVisibility((TypeInstance)semanticObject, basePart);
			}
		}
	}
	
	private void updateTypeFieldsVisibility(TypeInstance typeInstance, TypeInstancePropertiesEditionPart basePart) {
		if (typeInstance.getNativeType() != null) {
			NativeTypeKind nativeTypeKind = typeInstance.getNativeType().getSpec();
			boolean lengthVisible = (nativeTypeKind == NativeTypeKind.LENGTH || nativeTypeKind == NativeTypeKind.LENGTH_AND_PRECISION);
			boolean precisionVisible = (nativeTypeKind == NativeTypeKind.LENGTH_AND_PRECISION);
			boolean literalsVisible = (nativeTypeKind == NativeTypeKind.ENUM);
			basePart.updateTypeFields(lengthVisible, precisionVisible, literalsVisible);
		}
	}
}
