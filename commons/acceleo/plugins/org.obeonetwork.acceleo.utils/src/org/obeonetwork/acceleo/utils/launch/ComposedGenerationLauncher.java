/*******************************************************************************
 * Copyright (c) 2008, 2025 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package org.obeonetwork.acceleo.utils.launch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

/**
 * @author Obeo
 *
 */
public class ComposedGenerationLauncher extends AbstractGenerationLauncher {

	private List<AbstractGenerationLauncher> launchers;
	
	/**
	 * 
	 */
	public ComposedGenerationLauncher() {
		super();
		launchers = new ArrayList<AbstractGenerationLauncher>();
	}
	
	/**
	 * @param launchers
	 */
	public ComposedGenerationLauncher(List<AbstractGenerationLauncher> launchers) {
		super();
		this.launchers = launchers;
	}
	
	/**
	 * Add a launcher to the composition.
	 * @param launcher laucher to add.
	 */
	public void addLauncher(AbstractGenerationLauncher launcher) {
		launchers.add(launcher);
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.acceleo.utils.launch.AbstractGenerationLauncher#lauchGeneration(java.lang.String[])
	 */
	public void lauchGeneration(String[] args) throws IOException {
		for (AbstractGenerationLauncher launcher : launchers) {
			launcher.lauchGeneration(args);
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.acceleo.utils.launch.AbstractGenerationLauncher#lauchGeneration(org.eclipse.emf.common.util.URI, java.io.File, java.util.List, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void lauchGeneration(URI modelURI, File folder, IProgressMonitor monitor) throws IOException {
		for (AbstractGenerationLauncher launcher : launchers) {
			launcher.lauchGeneration(modelURI, folder, monitor);
		}
	}
}
