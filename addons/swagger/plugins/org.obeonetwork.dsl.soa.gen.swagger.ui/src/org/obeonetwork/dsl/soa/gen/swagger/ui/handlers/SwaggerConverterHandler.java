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
import static org.obeonetwork.dsl.soa.gen.swagger.Activator.logWarning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.soa.gen.swagger.ui.wizards.Messages;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SwaggerFileConverter;
import org.obeonetwork.dsl.soa.gen.swagger.utils.UnsupportedSwagerFileException;
import org.obeonetwork.utils.common.ui.handlers.EventHelper;

import com.google.common.io.Files;

public class SwaggerConverterHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IFile iFile = EventHelper.uwrapSingleSelection(event, IFile.class);
		File inputFile = iFile.getLocation().toFile();
		String path = inputFile.getAbsolutePath();
		String extension = Files.getFileExtension(path);
		if (path == null || extension == null) {
			return null;
		}
		String nameWithoutExtension = path.substring(0, path.length() - extension.length() - 1);
		File outputFile = new File(nameWithoutExtension + "-3.1.0." + extension);
		OutputStream outputStream = null;
		boolean anyError = false;
		try {
			outputStream = new FileOutputStream(outputFile);
		} catch (FileNotFoundException e) {
			anyError = true;
			logError(String.format("Cannot write file: %s", outputFile.getAbsolutePath()), e);
		} catch (SecurityException e) {
			anyError = true;
			logError(String.format("Cannot write file: %s", outputFile.getAbsolutePath()), e);
		}
		List<String> parsingWarnings = Collections.emptyList();
		if (outputStream != null) {
			try {
				parsingWarnings = SwaggerFileConverter.convert(inputFile, outputStream);
			} catch (IOException | SecurityException | IllegalArgumentException | UnsupportedSwagerFileException e) {
				anyError = true;
				logError(String.format("Cannot convert to OpenAPI 3.1.0 version the file : %s.",
						inputFile.getAbsolutePath()), e);
			}
		}

		if (outputFile.exists()) {
			try {
				IContainer container = iFile.getParent();
				if (container != null) {
					container.refreshLocal(IResource.DEPTH_ONE, new NullProgressMonitor());
				}
			} catch (CoreException e) {
				anyError = true;
				logError(String.format("Error during refreshing for container of file: %s",
						outputFile.getAbsolutePath()), e);
			}
		}
		boolean anyWarning = !parsingWarnings.isEmpty();
		if (anyWarning) {
			logWarning(String.format("Conversion of file[%s] to OpenAPI 3.1.0: parsing messages:\n%s",
					inputFile.getAbsolutePath(), parsingWarnings.toString()));
		}
		if (anyError) {
			if (outputFile != null && outputFile.exists()) {
				try {
					outputFile.delete();
				} catch (SecurityException e) {
				}
			}
			MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.SwaggerConvertWizard_Title,
					Messages.SwaggerConvertWizard_Failure_message);
		} else if (anyWarning) {
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.SwaggerConvertWizard_Title,
					Messages.SwaggerConvertWizard_Warning_message);
		} else {
			MessageDialog.openInformation(Display.getCurrent().getActiveShell(), Messages.SwaggerConvertWizard_Title,
					Messages.SwaggerConvertWizard_Success_message);
		}
		return null;
	}
}
