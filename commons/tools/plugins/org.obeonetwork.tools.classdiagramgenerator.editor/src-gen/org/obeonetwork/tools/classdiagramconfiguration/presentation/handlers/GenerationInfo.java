/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.classdiagramconfiguration.presentation.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GenerationInfo {
	private String descriptionId = null;
	private Map<String, String> placeholders = new HashMap<String, String>();
	private Map<String, Boolean> booleanInfos = new HashMap<String, Boolean>();
	private Collection<String> metamodelsURIs = new ArrayList<String>();
	private Collection<String> javaExtensions = new ArrayList<String>();
	
	public GenerationInfo(String descriptionId) {
		super();
		this.descriptionId = descriptionId;
	}
	
	public String getDescriptionId() {
		return descriptionId;
	}

	public void setDescriptionId(String descriptionId) {
		this.descriptionId = descriptionId;
	}

	public boolean isEmpty() {
		return getPlaceholders().isEmpty() && getBooleanInfos().isEmpty();
	}
	
	public Map<String, String> getPlaceholders() {
		return placeholders;
	}
	
	public void setPlaceholders(Map<String, String> placeholders) {
		this.placeholders = placeholders;
	}
	
	public Map<String, Boolean> getBooleanInfos() {
		return booleanInfos;
	}
	
	public void setBooleanInfos(Map<String, Boolean> booleanInfos) {
		this.booleanInfos = booleanInfos;
	}

	public Collection<String> getMetamodelsURIs() {
		return metamodelsURIs;
	}

	public void setMetamodelsURIs(Collection<String> metamodelsURIs) {
		this.metamodelsURIs = metamodelsURIs;
	}

	public Collection<String> getJavaExtensions() {
		return javaExtensions;
	}

	public void setJavaExtensions(Collection<String> javaExtensions) {
		this.javaExtensions = javaExtensions;
	}
	
}