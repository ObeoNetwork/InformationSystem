package org.obeonetwork.dsl.environment.design.ui.providers;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.obeonetwork.dsl.environment.NamespacesContainer;
import org.obeonetwork.dsl.environment.Type;
import org.obeonetwork.dsl.environment.TypesDefinition;

public class StructuredTypesContentProvider extends ArrayContentProvider implements ITreeContentProvider {

	private String typeName = null;
	
	public StructuredTypesContentProvider(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Collection<Object> children = new ArrayList<Object>();
		if (parentElement instanceof NamespacesContainer) {
			children.addAll(((NamespacesContainer) parentElement).getOwnedNamespaces());
		}
		if (parentElement instanceof TypesDefinition) {
			for (Type type : ((TypesDefinition) parentElement).getTypes()) {
				if (typeName.equals(type.eClass().getName())) {
					children.add(type);
				}
			}
		}
		return children.toArray();
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof EObject) {
			return ((EObject) element).eContainer();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof NamespacesContainer) {
			if (!((NamespacesContainer) element).getOwnedNamespaces().isEmpty()) {
				return true;
			}
		}
		if (element instanceof TypesDefinition) {
			if (!((TypesDefinition) element).getTypes().isEmpty()) {
				return true;
			}
		}
		return false;
	}

}
