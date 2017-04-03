/*******************************************************************************
 * Copyright (c) 2011, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * @author @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class AbstractGenerationLauncher {
	
	public abstract void lauchGeneration(final String[] args) throws IOException;
	
	public abstract void lauchGeneration(URI modelURI, File folder, IProgressMonitor monitor) throws IOException;
}
