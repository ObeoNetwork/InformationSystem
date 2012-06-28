package org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.obeonetwork.dsl.entity.Entity;
import org.obeonetwork.dsl.entity.Property;
import org.obeonetwork.dsl.entity.Reference;
import org.obeonetwork.dsl.environment.binding.dialect.ui.treemapper.TreeRoot;
import org.obeonetwork.dsl.environment.bindingdialect.BindingdialectFactory;
import org.obeonetwork.dsl.environment.bindingdialect.DBoundElement;
import org.obeonetwork.dsl.soa.ServiceDTO;

public class DBoundElementContentProvider implements ITreeContentProvider {
	
//	private DBindingEditor bindingEditor;
	
	public DBoundElementContentProvider() {
		super();
//		this.bindingEditor = bindingEditor;
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof TreeRoot) {
			return new Object[]{((TreeRoot) inputElement).getElement()};
		}
		return null;
	}

	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof DBoundElement) {
			DBoundElement boundElement = (DBoundElement)parentElement;
			if (boundElement.getChildren().isEmpty()) {
				List<DBoundElement> children = new ArrayList<DBoundElement>();
				EObject[] delegatedChildren = getDelegatedChildren(boundElement.getTarget());
				for (EObject object : delegatedChildren) {
					DBoundElement childBoundElement = BindingdialectFactory.eINSTANCE.createDBoundElement();
//					bindingEditor.getBoundElements().add(childBoundElement);
					childBoundElement.setParent(boundElement);
					childBoundElement.setTarget(object);
					children.add(childBoundElement);
				}
				boundElement.getChildren().clear();
				boundElement.getChildren().addAll(children);
			}
			return boundElement.getChildren().toArray();
		}
		return null;
	}
	
	private EObject[] getDelegatedChildren(EObject object) {
		if (object instanceof Entity) {
			Entity entity = (Entity)object;
			List<Property> properties = new ArrayList<Property>();
			properties.addAll(entity.getAttributes());
			properties.addAll(entity.getReferences());
			return (EObject[]) properties.toArray(new EObject[]{});
		} else if (object instanceof ServiceDTO) {
			ServiceDTO dto = (ServiceDTO)object;
			List<org.obeonetwork.dsl.environment.Property> properties = new ArrayList<org.obeonetwork.dsl.environment.Property>();
			properties.addAll(dto.getAttributes());
			properties.addAll(dto.getReferences());
			return (EObject[]) properties.toArray(new EObject[]{});
		} else if (object instanceof Reference) {
			Reference entityReference = (Reference)object;
			if (entityReference.getType() != null) {
				return getDelegatedChildren(entityReference.getType());
			} else {
				return new EObject[]{};
			}
		} else if (object instanceof org.obeonetwork.dsl.environment.Reference) {
			org.obeonetwork.dsl.environment.Reference envReference = (org.obeonetwork.dsl.environment.Reference)object;
			if (envReference.getType() != null) {
				return getDelegatedChildren(envReference.getType());
			} else {
				return new EObject[]{};
			}
		}
		return new EObject[]{};
	}

	public Object getParent(Object element) {
		if (element instanceof DBoundElement) {
			return ((DBoundElement)element).getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		Object[] children = getChildren(element);
		return (children != null && children.length > 0);
	}

}
