/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
 * @author <a href="mailto:thibault.beziers-la-fosse@obeo.fr">Thibault Béziers la Fosse</a>
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
