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

package org.obeonetwork.acceleo.utils.launch;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;

/**
 * @author Obeo
 *
 */
public abstract class AbstractGenerationLauncher {
	
	public abstract void lauchGeneration(final String[] args) throws IOException;
	
	public abstract void lauchGeneration(URI modelURI, File folder, IProgressMonitor monitor) throws IOException;
}
