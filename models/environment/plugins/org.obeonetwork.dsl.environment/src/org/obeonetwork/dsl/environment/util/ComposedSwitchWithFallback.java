/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.environment.util;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ComposedSwitch;
import org.eclipse.emf.ecore.util.Switch;

public class ComposedSwitchWithFallback<T> extends ComposedSwitch<T> {
	
	private Switch<T> fallbackSwitch = null;

	public ComposedSwitchWithFallback() {
		super();
	}
	
	public ComposedSwitchWithFallback(Switch<T> fallbackSwitch) {
		this();
		setFallbackSwitch(fallbackSwitch);
	}
	
	public ComposedSwitchWithFallback(Collection<? extends Switch<T>> switches) {
		super(switches);
	}
	
	public ComposedSwitchWithFallback(Collection<? extends Switch<T>> switches, Switch<T> fallbackSwitch) {
		this(switches);
		setFallbackSwitch(fallbackSwitch);
	}
	
	@Override
	public T doSwitch(EObject eObject) {
		T doSwitch = super.doSwitch(eObject);
		if (doSwitch == null && getFallbackSwitch() != null) {
			doSwitch = getFallbackSwitch().doSwitch(eObject);
		}
		return doSwitch;
	}

	public Switch<T> getFallbackSwitch() {
		return fallbackSwitch;
	}

	public void setFallbackSwitch(Switch<T> fallbackSwitch) {
		this.fallbackSwitch = fallbackSwitch;
	}
}
