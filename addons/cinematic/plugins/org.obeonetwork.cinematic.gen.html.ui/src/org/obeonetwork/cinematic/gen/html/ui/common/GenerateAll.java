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
package org.obeonetwork.cinematic.gen.html.ui.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;


/**
 * Main entry point of the 'Html' generation module.
 */
public class GenerateAll {

	/**
	 * The model URI.
	 */
	private URI modelURI;

	/**
	 * The output folder.
	 */
	private IContainer targetFolder;

	/**
	 * The other arguments.
	 */
	List<? extends Object> arguments;

	/**
	 * Constructor.
	 * 
	 * @param modelURI
	 *            is the URI of the model.
	 * @param targetFolder
	 *            is the output folder
	 * @param arguments
	 *            are the other arguments
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 * @generated
	 */
	public GenerateAll(URI modelURI, IContainer targetFolder, List<? extends Object> arguments) {
		this.modelURI = modelURI;
		this.targetFolder = targetFolder;
		this.arguments = arguments;
	}

	/**
	 * Launches the generation.
	 *
	 * @param monitor
	 *            This will be used to display progress information to the user.
	 * @throws IOException
	 *             Thrown when the output cannot be saved.
	 */
	public void doGenerate(IProgressMonitor monitor) throws IOException {
		if (!targetFolder.getLocation().toFile().exists()) {
			targetFolder.getLocation().toFile().mkdirs();
		}
		
		monitor.subTask("Loading...");
		org.obeonetwork.cinematic.gen.html.main.Main gen0 = new org.obeonetwork.cinematic.gen.html.main.Main(modelURI, targetFolder.getLocation().toFile(), arguments);
		monitor.worked(1);
		String generationID = org.eclipse.acceleo.engine.utils.AcceleoLaunchingUtil.computeUIProjectID("org.obeonetwork.cinematic.gen.html", "org.obeonetwork.cinematic.gen.html.main.Main", modelURI.toString(), targetFolder.getFullPath().toString(), new ArrayList<String>());
		gen0.setGenerationID(generationID);
		gen0.doGenerate(BasicMonitor.toMonitor(monitor));
		
	}

}
