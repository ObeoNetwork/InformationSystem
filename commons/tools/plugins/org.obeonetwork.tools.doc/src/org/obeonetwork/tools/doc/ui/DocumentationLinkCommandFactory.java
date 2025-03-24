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
/**
 * 
 */
package org.obeonetwork.tools.doc.ui;

import org.eclipse.core.commands.IHandler;
import org.obeonetwork.tools.doc.core.DocumentationLink;

/**
 * @author Obeo
 *
 */
public interface DocumentationLinkCommandFactory {
	
	/**
	 * Creates a new {@link IHandler} to open the given {@link DocumentationLink}.
	 * @param entry to open
	 * @return the Handler opening the given {@link DocumentationLink}.
	 */
	IHandler createOpenCommand(DocumentationLink entry);
}
