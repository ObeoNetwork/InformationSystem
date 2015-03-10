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
