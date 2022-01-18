/*******************************************************************************
 * Copyright (c) 2008, 2022 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.snapshot.viewer.wizards;

import org.eclipse.emf.common.util.URI;

/**
 * Class used to store wizard page data
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ImportXmlInput {
	private String xmlFile = null;
	private String localProjectName = null;
	private URI remoteProjectURI = null;
	
	public String getXmlFile() {
		return xmlFile;
	}
	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}
	public String getLocalProjectName() {
		return localProjectName;
	}
	public void setLocalProjectName(String localProjectName) {
		this.localProjectName = localProjectName;
	}
	public URI getRemoteProjectURI() {
		return remoteProjectURI;
	}
	public void setRemoteProjectURI(URI remoteProjectURI) {
		this.remoteProjectURI = remoteProjectURI;
	}
	
}
