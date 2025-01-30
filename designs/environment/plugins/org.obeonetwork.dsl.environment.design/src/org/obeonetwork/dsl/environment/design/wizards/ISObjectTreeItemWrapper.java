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
import java.util.Set;
import java.util.function.Function;

import org.eclipse.sirius.common.tools.api.util.TreeItemWrapper;

public class ISObjectTreeItemWrapper {

	// Structural data
    private ISObjectTreeItemWrapper parent;
    private Object wrappedObject = null;

    // Behavior functional data
    private ISObjectTreeItemWrapperConfiguration configuration;

	// Cached data
    private List<ISObjectTreeItemWrapper> children = null;
	private Boolean selectable = null;
	
	public static class ISObjectTreeItemWrapperConfiguration {
		private Function<Object, List<?>> childrenFunction;
		private Function<Object, Boolean> selectableCondition = null;
		private int maxDuplicateAncestorsAllowed = 0;
		private Function<Object, Object> asUnambiguousElementFunction = (e) -> e;
		
		public Function<Object, List<?>> getChildrenFunction() {
			return childrenFunction;
		}
		
		@SuppressWarnings("unchecked")
		public void setChildrenFunction(final Function<?, List<?>> childrenFunction) {
			this.childrenFunction = (Function<Object, List<?>>) childrenFunction;
		}
		
		public Function<Object, Boolean> getSelectableCondition() {
			return selectableCondition;
		}
		
		@SuppressWarnings("unchecked")
		public void setSelectableCondition(final Function<?, Boolean> selectableCondition) {
			this.selectableCondition = (Function<Object, Boolean>) selectableCondition;
		}
		
		public int getMaxDuplicateAncestorsAllowed() {
			return maxDuplicateAncestorsAllowed;
		}
		
		public void setMaxDuplicateAncestorsAllowed(int maxDuplicateAncestorsAllowed) {
			this.maxDuplicateAncestorsAllowed = maxDuplicateAncestorsAllowed;
		}

		public Function<Object, Object> getAsUnambiguousElementFunction() {
			return asUnambiguousElementFunction;
		}
		
		/**
		 * The given function should return a unique object representing the given element.
		 * @see IBoundableElementChildren#asUnambiguousElement(Object)
		 * 
		 * @param asUnambiguousElementFunction
		 */
		public void setAsUnambiguousElementFunction(Function<Object, Object> asUnambiguousElementFunction) {
			this.asUnambiguousElementFunction = asUnambiguousElementFunction;
		}

	}
	
    /**
     * Create a root node.
     * 
     * Instantiates the configuration that will be shared by all the tree nodes.
     * The childrenFunction goes into the configuration.
     * 
     * @param childrenFunction
     */
	public ISObjectTreeItemWrapper(final Function<?, List<?>> childrenFunction) {
    	this.configuration = new ISObjectTreeItemWrapperConfiguration();
    	configuration.setChildrenFunction(childrenFunction);
    	this.children = new ArrayList<>();
    }
    
    /**
     * Create a child node.
     * 
     * @param parent
     * @param wrappedObject
     */
    public ISObjectTreeItemWrapper(final ISObjectTreeItemWrapper parent, final Object wrappedObject) {
        this.parent = parent;
        this.wrappedObject = wrappedObject;
        if(parent != null) {
            this.configuration = parent.configuration;
            parent.addChild(this);
        }
    }
    
    /**
     * The configuration instance is unique for a given ISObjectTreeItemWrapper tree.
     * Changes made on the configuration thus impact all the tree.
     * 
     * @return The shared configuration for this tree.
     */
    public ISObjectTreeItemWrapperConfiguration getConfiguration() {
		return configuration;
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
    		if(configuration.getChildrenFunction() != null) {
    			@SuppressWarnings("unchecked")
				List<Object> childObjects = (List<Object>) configuration.getChildrenFunction().apply(wrappedObject);
				for(Object childObject : childObjects) {
					if(!maxDuplicateAncestorsReached(childObject)) {
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
     * Return true if the count of the parent-child couples in the ancestors hierarchy equal 
     * to the current parent-child is greater than the max duplicate ancestors allowed.
     * 
     * All of the children of every ancestors are considered in the count.
     * 
     * The current parent-child couple is formed by the current wrapped object and the given childObject.
     * 
     * The parents are made unambiguous with a call to {@link ISObjectTreeItemWrapper#asUnambiguousParent(Object)}
     * 
     * @param childObject Object to be tested
     * 
     * @return true the maximum representation of the current parent-child couple is reached.
     */
    private boolean maxDuplicateAncestorsReached(final Object childObject) {
    	long duplicateAncestorsCount = getAncestors().stream()
    		.filter(ancestorTiw -> asUnambiguousParent(ancestorTiw.getWrappedObject()) == asUnambiguousParent(wrappedObject) && 
    				ancestorTiw.getChildren().stream().anyMatch(tiw -> tiw.getWrappedObject() == childObject))
    		.count();
    	return duplicateAncestorsCount > configuration.getMaxDuplicateAncestorsAllowed();
    }

	private Object asUnambiguousParent(Object element) {
		return configuration.getAsUnambiguousElementFunction().apply(element);
	}

	public boolean isSelectable() {
		if(selectable == null) {
			selectable = true;
            if(configuration.getSelectableCondition() != null) {
            	selectable = configuration.getSelectableCondition().apply(wrappedObject);
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
