/*******************************************************************************
 * Copyright (c) 2008, 2023 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package org.obeonetwork.tools.doc.core;

import org.obeonetwork.tools.linker.EObjectLink;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface DocumentationLink extends EObjectLink {
	
	public static final String WORKSPACE_PREFIX = "platform:/resource"; //$NON-NLS-1$
	/**
	 * Constant defining the title of an annotation for a documentation link
	 */
	public final static String DOCUMENTATION_ANNOTATION_TITLE = "DocumentationLink"; //$NON-NLS-1$

	/**
	 * @return the name of the documentation.
	 */
	String getName();

	/**
	 * @param name the name to set
	 */
	void setName(String name);
	
	/**
	 * @return the value of the documentation.
	 */
	String getValue();

	/**
	 * @param value the value to set
	 */
	void setValue(String value);

	/**
	 * @return <code>true</code> if the referenced documentation is contained in the workspace.
	 */
	boolean isWorkspaceDocumentation();

	/**
	 * @return a well formatted URL.
	 */
	String getWebFormattedValue();

	/**
	 * @return the value of the {@link DocumentationLink} without the workspace prefix. 
	 */
	String getWorkspaceRelativeValue();


}
