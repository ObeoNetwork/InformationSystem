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
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.obeonetwork.utils.common.SiriusInterpreterUtils;

public class EObjectTreeItemWrapper {

	// Structural data
    private EObjectTreeItemWrapper parent;
    private EObject wrappedEObject = null;

    // Behavior functional data
	private IInterpreter interpreter;
	private String childrenExpression;
	private String selectableCondition;

	// Cached data
    private List<EObjectTreeItemWrapper> children = null;
	private Boolean selectable = null;
	
    /**
     * Create a root node
     * 
     * @param interpreter
     * @param childrenExpression
     * @param selectableCondition
     */
    public EObjectTreeItemWrapper(final IInterpreter interpreter, final String childrenExpression, final String selectableCondition) {
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
    public EObjectTreeItemWrapper(final EObjectTreeItemWrapper parent, final EObject wrappedEObject) {
        this.parent = parent;
        this.wrappedEObject = wrappedEObject;
        if(parent != null) {
            this.interpreter = parent.interpreter;
            this.childrenExpression = parent.childrenExpression;
            this.selectableCondition = parent.selectableCondition;
            parent.addChild(this);
        }
    }

    private void addChild(EObjectTreeItemWrapper treeItemWrapper) {
    	children.add(treeItemWrapper);
	}

	public EObject getWrappedEObject() {
        return wrappedEObject;
    }

    public List<EObjectTreeItemWrapper> getChildren() {
    	if(children == null) {
    		children = new ArrayList<>();
    		if(childrenExpression != null) {
    			List<EObject> childEObjects = SiriusInterpreterUtils.evaluateToEObjectList(interpreter, wrappedEObject, childrenExpression);
				for(EObject childEObject : childEObjects) {
					if(!knownAsAncestor(childEObject)) {
						new EObjectTreeItemWrapper(this, childEObject);
					}
				}
    		}
    	}
        return children;
    }

    public EObjectTreeItemWrapper getParent() {
        return parent;
    }

    /**
     * Helper method to avoid cycles when building a tree.
     * 
     * @param obj Object to be tested
     * 
     * @return true if this or one of the parent {@link EObjectTreeItemWrapper} already wraps the given object.
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

	public Set<EObjectTreeItemWrapper> getAllSelectableTreeItemWrappers() {
		Set<EObjectTreeItemWrapper> allSelectableTreeItemWrappers = new HashSet<>();
		if(isSelectable()) {
			allSelectableTreeItemWrappers.add(this);
		}
		for(EObjectTreeItemWrapper childItemWrapper : getChildren()) {
			allSelectableTreeItemWrappers.addAll(childItemWrapper.getAllSelectableTreeItemWrappers());
		}
		return allSelectableTreeItemWrappers;
	}

	public Collection<EObjectTreeItemWrapper> getAllTreeItemWrappers() {
		List<EObjectTreeItemWrapper> allTreeItemWrappers = new ArrayList<>();
		allTreeItemWrappers.add(this);
		for(EObjectTreeItemWrapper childItemWrapper : getChildren()) {
			allTreeItemWrappers.addAll(childItemWrapper.getAllTreeItemWrappers());
		}
		return allTreeItemWrappers;
	}

	/**
	 * @return A list of ancestors in ascending order, going from the parent of the given object to the root.
	 */
	public List<EObjectTreeItemWrapper> getAncestors() {
		List<EObjectTreeItemWrapper> ancestors = new ArrayList<>();
		EObjectTreeItemWrapper treeItemWrapper = this.parent;
		while(treeItemWrapper != null) {
			ancestors.add(treeItemWrapper);
			treeItemWrapper = treeItemWrapper.parent;
		}
		return ancestors;
	}
	
}
