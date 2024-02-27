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
package org.obeonetwork.dsl.soa.gen.swagger.ui.handlers;

import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logError;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SwaggerFileConverter;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

import com.google.common.io.Files;

public class SwaggerConverterHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile iFile = EventHelper.uwrapSingleSelection(event, IFile.class);
		File inputFile = iFile.getLocation().toFile();
		String path = inputFile.getAbsolutePath();
		String extension = Files.getFileExtension(path);
		if(path==null || extension==null) {
			return null;
		}
		String nameWithoutExtension = path.substring(0,path.length()-extension.length()-1);
		File outputFile = new File(nameWithoutExtension+"-3.1.0."+extension);
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(outputFile);
		} catch (FileNotFoundException e) {
			logError(String.format("Cannot write file: %s",outputFile.getAbsolutePath()), e);
		} catch (SecurityException e) {
			logError(String.format("Cannot write file: %s",outputFile.getAbsolutePath()), e);
		}
		if(outputStream!=null) {
			SwaggerFileConverter.convert(inputFile, outputStream);
		}
		
		if(outputFile.exists()) {
			try {
				IContainer container = iFile.getParent();
				if(container!=null) {
					container.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				}
			} catch (CoreException e) {
				logError(String.format("Error during refreshing for container of file: %s",outputFile.getAbsolutePath()), e);
			}
		}
		
		return null;
	}
}
