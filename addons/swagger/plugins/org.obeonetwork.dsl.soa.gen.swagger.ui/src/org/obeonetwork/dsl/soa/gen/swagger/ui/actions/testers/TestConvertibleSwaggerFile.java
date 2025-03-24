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
package org.obeonetwork.dsl.soa.gen.swagger.ui.actions.testers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerFileQuery;
import org.obeonetwork.dsl.soa.gen.swagger.utils.SwaggerFileConverter;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 
 * @author Obeo
 *
 */
public class TestConvertibleSwaggerFile extends PropertyTester {

	public static final List<String> ACCEPTED_EXTENSIONS = List.of("yaml", "yml", "json");
	public static final String TO_OPEN_API_31_COMMAND_ARG = "ToOpenAPI31Command";

	/**
	 * Manages the visibility of the Swagger convert menu and the ToOpenAPI310
	 * command.
	 * <p>
	 * The Swagger convert menu is visible only if receiver is a valid
	 * Swagger/OpenAPI file with extension yaml, yml or json.
	 * </p>
	 * <p>
	 * The ToOpenAPI310 command is enabled only if the Swagger/OpenAPI version of
	 * the file (receiver) can be converted to OpenAPI 3.1.0 version.
	 * </p>
	 */
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		SwaggerFileQuery fileQuery = null;
		boolean isConvertMenu = false;
		if (args != null && args.length == 1) {
			if (!TO_OPEN_API_31_COMMAND_ARG.equals((String) args[0])) {
				return false;
			}
		} else {
			// Swagger convert menu
			isConvertMenu = true;
		}

		if (!(receiver instanceof IFile) || !ACCEPTED_EXTENSIONS.contains(((IFile) receiver).getFileExtension())) {
			return false;
		}

		try {
			File inputFile = ((IFile) receiver).getLocation().toFile();
			fileQuery = new SwaggerFileQuery(inputFile);
		} catch (JsonProcessingException e) {
		} catch (IOException e) {
		}

		if (fileQuery == null) {
			return false;
		}
		if (isConvertMenu) {
			return true;
		}

		// ToOpenAPI310 command
		return SwaggerFileConverter.canConvertToOpenAPI310(fileQuery.getVersion());
	}

}
