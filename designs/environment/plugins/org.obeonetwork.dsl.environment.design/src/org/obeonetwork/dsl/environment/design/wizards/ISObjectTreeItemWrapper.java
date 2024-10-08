/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
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
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.sirius.common.tools.api.util.TreeItemWrapper;

public class ISObjectTreeItemWrapper {

	// Structural data
    private ISObjectTreeItemWrapper parent;
    private Object wrappedObject = null;

    // Behavior functional data
	private Function<Object, List<?>> childrenFunction;
	private Function<Object, Boolean> selectableCondition;

	// Cached data
    private List<ISObjectTreeItemWrapper> children = null;
	private Boolean selectable = null;
	
	
    /**
     * Create a root node
     * 
     * @param childrenFunction
     * @param selectableCondition
     */
    @SuppressWarnings("unchecked")
	public ISObjectTreeItemWrapper(final Function<?, List<?>> childrenFunction, final Function<?, Boolean> selectableCondition) {
    	this.childrenFunction = (Function<Object, List<?>>) childrenFunction;
    	this.selectableCondition = (Function<Object, Boolean>) selectableCondition;
    	this.children = new ArrayList<>();
    }
    
    /**
     * Create a child node
     * 
     * @param parent
     * @param wrappedObject
     */
    public ISObjectTreeItemWrapper(final ISObjectTreeItemWrapper parent, final Object wrappedObject) {
        this.parent = parent;
        this.wrappedObject = wrappedObject;
        if(parent != null) {
            this.childrenFunction = parent.childrenFunction;
            this.selectableCondition = parent.selectableCondition;
            parent.addChild(this);
        }
    }

    private void addChild(ISObjectTreeItemWrapper treeItemWrapper) {
    	children.add(treeItemWrapper);
	}

	public Object getWrappedObject() {
        return wrappedObject;
    }

    public List<ISObjectTreeItemWrapper> getChildren() {
    	if(children == null) {
    		children = new ArrayList<>();
    		if(childrenFunction != null) {
    			@SuppressWarnings("unchecked")
				List<Object> childObjects = (List<Object>) childrenFunction.apply(wrappedObject);
				for(Object childObject : childObjects) {
					if(!knownAsAncestor(childObject)) {
						new ISObjectTreeItemWrapper(this, childObject);
					}
				}
    		}
    	}
        return children;
    }

    public ISObjectTreeItemWrapper getParent() {
        return parent;
    }

    /**
     * Helper method to avoid cycles when building a tree.
     * 
     * @param obj Object to be tested
     * 
     * @return true if this or one of the parent {@link ISObjectTreeItemWrapper} already wraps the given object.
     */
    private boolean knownAsAncestor(final Object object) {
    	return Objects.equals(wrappedObject, object) || (parent != null && parent.knownAsAncestor(object));
    }

	public boolean isSelectable() {
		if(selectable == null) {
			selectable = true;
            if(selectableCondition != null) {
            	selectable = selectableCondition.apply(wrappedObject);
            }
		}
		return selectable;
	}

	public Set<ISObjectTreeItemWrapper> getAllSelectableTreeItemWrappers() {
		Set<ISObjectTreeItemWrapper> allSelectableTreeItemWrappers = new HashSet<>();
		if(isSelectable()) {
			allSelectableTreeItemWrappers.add(this);
		}
		for(ISObjectTreeItemWrapper childItemWrapper : getChildren()) {
			allSelectableTreeItemWrappers.addAll(childItemWrapper.getAllSelectableTreeItemWrappers());
		}
		return allSelectableTreeItemWrappers;
	}

	public Collection<ISObjectTreeItemWrapper> getAllTreeItemWrappers() {
		List<ISObjectTreeItemWrapper> allTreeItemWrappers = new ArrayList<>();
		allTreeItemWrappers.add(this);
		for(ISObjectTreeItemWrapper childItemWrapper : getChildren()) {
			allTreeItemWrappers.addAll(childItemWrapper.getAllTreeItemWrappers());
		}
		return allTreeItemWrappers;
	}

	/**
	 * @return A new list of ancestors in descending order, going from the root to the parent of this {@link TreeItemWrapper}.
	 */
	public List<ISObjectTreeItemWrapper> getAncestors() {
		if (parent == null) {
			return new ArrayList<ISObjectTreeItemWrapper>();
		}
		List<ISObjectTreeItemWrapper> ancestors = parent.getAncestors();
		ancestors.add(parent);
		return ancestors;
	}
	
}
