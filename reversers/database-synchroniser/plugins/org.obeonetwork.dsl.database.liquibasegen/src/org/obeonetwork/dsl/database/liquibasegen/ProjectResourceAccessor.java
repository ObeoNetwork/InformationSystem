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
package org.obeonetwork.dsl.database.liquibasegen;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IProject;

import liquibase.resource.FileSystemResourceAccessor;

/**
 * {@link FileSystemResourceAccessor} based on an Eclipse {@link IProject}.
 * @author Obeo
 */
public class ProjectResourceAccessor extends FileSystemResourceAccessor {
	
	private IProject iProject;
	
	public ProjectResourceAccessor(IProject iProject) {
		super(new File(iProject.getLocation().toOSString()));
		this.iProject = iProject;
	}

	@Override
	public InputStream openStream(String relativeTo, String streamPath) throws IOException {
		File file = new File(streamPath);
		if (file.exists())
			return new FileInputStream(file);
		else
			return super.openStream(relativeTo, streamPath);
	}
	
	

}
