/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.is.designer.interpreter.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the {@link IVariableManager}.
 *
 * @author sbegaudeau
 */
public class VariableManager implements IVariableManager {

	/**
	 * The parent {@link IVariableManager}.
	 */
	private IVariableManager parent;

	/**
	 * The variables.
	 */
	private Map<String, Object> variables = new HashMap<String, Object>();

	/**
	 * The child variable manager.
	 */
	private List<IVariableManager> children = new ArrayList<IVariableManager>();

	/**
	 * The constructor.
	 */
	public VariableManager() {
		// do nothing
	}

	/**
	 * The constructor.
	 *
	 * @param parent
	 *            The parent of this {@link IVariableManager}.
	 */
	public VariableManager(IVariableManager parent) {
		this.parent = parent;
	}

	@Override
	public Object put(String name, Object value) {
		Object previous = this.variables.put(name, value);
		return previous;
	}

	@Override
	public Map<String, Object> getVariables() {
		if (this.parent != null) {
			Map<String, Object> parentVariables = this.parent.getVariables();
			parentVariables.putAll(this.variables);
			return parentVariables;
		}
		return new HashMap<String, Object>(this.variables);
	}

	@Override
	public IVariableManager createChild() {
		IVariableManager variableManager = new VariableManager(this);
		this.children.add(variableManager);
		return variableManager;
	}

	@Override
	public void clear() {
		this.variables.clear();

		for (IVariableManager variableManager : children) {
			variableManager.clear();
		}
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    for (Map.Entry<String, Object> var : getVariables().entrySet()) {
            String name = var.getKey();
            Object value = var.getValue();
            boolean local = variables.containsKey(name);
            sb.append(name).append(" = ").append(value); //$NON-NLS-1$
            if (!local) {
                sb.append(" [inherited]"); //$NON-NLS-1$
            }
            sb.append("\n"); //$NON-NLS-1$
        }
	    return sb.toString();
	}
}
