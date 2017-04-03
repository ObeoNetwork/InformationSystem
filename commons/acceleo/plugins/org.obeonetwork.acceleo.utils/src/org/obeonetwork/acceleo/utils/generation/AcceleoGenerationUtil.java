/*******************************************************************************
 * Copyright (c) 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.acceleo.utils.generation;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.acceleo.common.AcceleoCommonPlugin;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;

/**
 * Utility methods for the generation.
 * 
 * @author sbegaudeau
 */
public class AcceleoGenerationUtil {
	
	/**
	 * The sole instance.
	 */
	private static AcceleoGenerationUtil instance;
	
	/**
	 * The constructor.
	 */
	private AcceleoGenerationUtil() {
		// prevent instantiation
	}
	
	/**
	 * Returns the sole instance.
	 * 
	 * @return The sole instance.
	 */
	public static AcceleoGenerationUtil getInstance() {
		if (instance == null) {
			instance = new AcceleoGenerationUtil();
		}
		return instance;
	}
	
	/**
	 * Copy the content of the bundle in the directory with the given resourcebundleDirectoryPath and paste it in the given iContainer.
	 * 
	 * @param iContainer The output folder.
	 * @param bundle The bundle.
	 * @param resourceBundleDirectoryPath The folder to copy in the bundle.
	 */
	public void copyBundleContent(IContainer iContainer, Bundle bundle, String resourceBundleDirectoryPath) {
		Enumeration<?> entries = bundle.findEntries(resourceBundleDirectoryPath, "*", true);
		while (entries.hasMoreElements()) {
			Object element = entries.nextElement();
			if (element instanceof URL) {
				URL url = (URL) element;
				InputStream stream = null;
				try {
					stream = FileLocator.openStream(bundle, new Path(url.getPath()), false);
					IFile file = iContainer.getFile(new Path(url.getPath()).removeFirstSegments(new Path(resourceBundleDirectoryPath).segmentCount()));
					if (file.isAccessible() && file.exists()) {
						file.delete(true, new NullProgressMonitor());
					}
					if (!file.getParent().exists() && file.getProject().exists()) {
						IContainer parent = file.getParent();
						String[] segments = parent.getProjectRelativePath().segments();
						IContainer tmpContainer = file.getProject();
						for (String segment : segments) {
							tmpContainer = tmpContainer.getFolder(new Path(segment));
							boolean shouldGenerate = true;
							for (String seg : segments) {
								if (".svn".equals(seg)) {
									shouldGenerate = false;
								}
							}
							if (shouldGenerate && !tmpContainer.exists() && tmpContainer instanceof IFolder) {
								((IFolder)tmpContainer).create(true, false, new NullProgressMonitor());
							}
						}
					}
					if (!".svn".equals(file.getName()) && file.getParent().exists()) {						
						file.create(stream, true, new NullProgressMonitor());
					}
				} catch (IOException e) {
					// commented for "svn" files illegal access
					// AcceleoCommonPlugin.log(e, true);
				} catch (CoreException e) {
					AcceleoCommonPlugin.log(e, true);
				} finally {
					try {
						if (stream != null) {
							stream.close();							
						}
					} catch (IOException e) {
						AcceleoCommonPlugin.log(e, true);
					}
				}
			}
		}
	}
}
