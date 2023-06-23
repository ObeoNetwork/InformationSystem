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
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.obeonetwork.utils.common.EObjectUtils;

public class LazyEObjectTreeItemWrapper {

	// Structural data
    private LazyEObjectTreeItemWrapper parent;
    private EObject wrappedEObject = null;

    // Behavior functional data
	private IInterpreter interpreter;
	private String childrenExpression;
	private String selectableCondition;

	// Cached data
    private List<LazyEObjectTreeItemWrapper> children = null;
	private Boolean selectable = null;
	
    /**
     * Create a root node
     * 
     * @param interpreter
     * @param childrenExpression
     * @param selectableCondition
     */
    public LazyEObjectTreeItemWrapper(final IInterpreter interpreter, final String childrenExpression, final String selectableCondition) {
    	this.interpreter = interpreter;
    	this.childrenExpression = childrenExpression;
    	this.selectableCondition = selectableCondition;
    	this.children = new ArrayList<>();
    }
    
    /**
     * Create a child node
     * 
     * @param parent
     * @param wrappedEObject
     */
    public LazyEObjectTreeItemWrapper(final LazyEObjectTreeItemWrapper parent, final EObject wrappedEObject) {
        this.parent = parent;
        this.wrappedEObject = wrappedEObject;
        if(parent != null) {
            this.interpreter = parent.interpreter;
            this.childrenExpression = parent.childrenExpression;
            this.selectableCondition = parent.selectableCondition;
            parent.addChild(this);
        }
    }

    private void addChild(LazyEObjectTreeItemWrapper lazyEObjectTreeItemWrapper) {
    	children.add(lazyEObjectTreeItemWrapper);
	}

	public EObject getWrappedEObject() {
        return wrappedEObject;
    }

    public List<LazyEObjectTreeItemWrapper> getChildren() {
    	if(children == null) {
    		children = new ArrayList<>();
    		if(childrenExpression != null) {
    			List<EObject> childrenEObjects = null;
    			try {
    				childrenEObjects = EObjectUtils.toEObjectList(interpreter.evaluate(wrappedEObject, childrenExpression));
    			} catch (EvaluationException e) {
    				e.printStackTrace();
    				// Bad luck
    			}
    			if(childrenEObjects != null) {
    				for(EObject childEObject : childrenEObjects) {
    					if(!knownAsAncestor(childEObject)) {
    						new LazyEObjectTreeItemWrapper(this, childEObject);
    					}
    				}
    			}
    		}
    	}
        return children;
    }

    public LazyEObjectTreeItemWrapper getParent() {
        return parent;
    }

    /**
     * Helper method to avoid cycles when building a tree.
     * 
     * @param obj Object to be tested
     * 
     * @return true if this or one of the parent {@link LazyEObjectTreeItemWrapper} already wraps the given object.
     */
    private boolean knownAsAncestor(final EObject eObject) {
    	return Objects.equals(wrappedEObject, eObject) || (parent != null && parent.knownAsAncestor(eObject));
    }

	public boolean isSelectable() {
		if(selectable == null) {
			selectable = true;
            if(selectableCondition != null) {
	            try {
	            	selectable = interpreter.evaluateBoolean(wrappedEObject, selectableCondition);
				} catch (EvaluationException e) {
					e.printStackTrace();
					// Bad luck
				}
            }
		}
		return selectable;
	}

	public Set<EObject> getAllSelectableWrappedEObjects() {
		Set<EObject> allSelectableWrappedEObjects = new HashSet<EObject>();
		if(isSelectable()) {
			allSelectableWrappedEObjects.add(getWrappedEObject());
		}
		for(LazyEObjectTreeItemWrapper childItemWrapper : getChildren()) {
			allSelectableWrappedEObjects.addAll(childItemWrapper.getAllSelectableWrappedEObjects());
		}
		return allSelectableWrappedEObjects;
	}

	public Set<EObject> getAllWrappedEObjects() {
		Set<EObject> allWrappedEObjects = new HashSet<EObject>();
		allWrappedEObjects.add(getWrappedEObject());
		for(LazyEObjectTreeItemWrapper childItemWrapper : getChildren()) {
			allWrappedEObjects.addAll(childItemWrapper.getAllWrappedEObjects());
		}
		return allWrappedEObjects;
	}

	public List<EObject> getAncestorsWrappedEObjects() {
		List<EObject> ancestorsWrappedEObjects = new LinkedList<>();
		LazyEObjectTreeItemWrapper treeItemWrapper = this.parent;
		while(treeItemWrapper != null) {
			ancestorsWrappedEObjects.add(0, treeItemWrapper.getWrappedEObject());
			treeItemWrapper = treeItemWrapper.parent;
		}
		return ancestorsWrappedEObjects;
	}
	
}
