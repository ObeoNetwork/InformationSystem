/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.design.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

public class TreeItemWrapper {

    private Object wrappedObject;

    private List<TreeItemWrapper> children;

    private TreeItemWrapper parent;

	private boolean selectable;

    public TreeItemWrapper(final Object wrappedObject, final TreeItemWrapper parent) {
        this.wrappedObject = wrappedObject;
        this.parent = parent;
        children = new ArrayList<TreeItemWrapper>(5);
        if(parent != null) {
            parent.getChildren().add(this);
        }
        this.selectable = true;
    }

    public Object getWrappedObject() {
        return this.wrappedObject;
    }

    public List<TreeItemWrapper> getChildren() {
        return this.children;
    }

    public TreeItemWrapper getParent() {
        return this.parent;
    }

    /**
     * Helper method to avoid cycles when building a tree.
     * 
     * @param obj Object to be tested
     * 
     * @return true if this or one of the parent {@link TreeItemWrapper} already wraps the given object.
     */
    public boolean knownAsAncestor(final Object obj) {
    	if(Objects.equals(wrappedObject, obj)) {
    		return true;
    	}
    	
    	if(parent != null) {
    		return parent.knownAsAncestor(obj);
    	}
    	
    	return false;
    }

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}
    
	public boolean isSelectable() {
		return selectable;
	}

	public Collection<? extends EObject> getAllSelectableWrappedEObjects() {
		return getAllSelectableWrappedObjects().stream()
				.filter(EObject.class::isInstance)
				.map(EObject.class::cast)
				.collect(Collectors.toList());
	}
	
	public Collection<?> getAllSelectableWrappedObjects() {
		List<Object> allSelectableWrappedObjects = new ArrayList<>();
		collectAllSelectableWrappedObjects(this, allSelectableWrappedObjects);
		return allSelectableWrappedObjects;
	}

	private void collectAllSelectableWrappedObjects(TreeItemWrapper treeItemWrapper, List<Object> allSelectableWrappedObjects) {
		if(treeItemWrapper.isSelectable()) {
			allSelectableWrappedObjects.add(treeItemWrapper.getWrappedObject());
		}
		for(TreeItemWrapper childItemWrapper : treeItemWrapper.getChildren()) {
			collectAllSelectableWrappedObjects(childItemWrapper, allSelectableWrappedObjects);
		}
	}

	
}
