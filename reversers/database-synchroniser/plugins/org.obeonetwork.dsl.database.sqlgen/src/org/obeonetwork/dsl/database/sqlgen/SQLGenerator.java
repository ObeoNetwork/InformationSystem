/*******************************************************************************
 * Copyright (c) 2008, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.sqlgen;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.acceleo.engine.generation.strategy.IAcceleoGenerationStrategy;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;

public abstract class SQLGenerator extends AbstractAcceleoGenerator {
	IAcceleoGenerationStrategy generationStrategy;

	public void setGenerationStrategy(IAcceleoGenerationStrategy generationStrategy) {
		this.generationStrategy = generationStrategy;
	}

	List<IAcceleoTextGenerationListener> listeners = new ArrayList<IAcceleoTextGenerationListener>();

	public void addGenerationListener(IAcceleoTextGenerationListener listener) {
		listeners.add(listener);
	}

	@Override
	public List<IAcceleoTextGenerationListener> getGenerationListeners() {
		return listeners;
	}
	
}
