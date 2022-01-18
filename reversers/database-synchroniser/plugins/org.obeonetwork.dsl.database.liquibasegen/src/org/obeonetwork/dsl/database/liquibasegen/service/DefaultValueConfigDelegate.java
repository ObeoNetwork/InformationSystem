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
package org.obeonetwork.dsl.database.liquibasegen.service;

import liquibase.change.ColumnConfig;
import liquibase.change.core.AddDefaultValueChange;

/**
 * Class that wrap either a {@link AddDefaultValueChange} or a
 * {@link ColumnConfig} to offer of common API to set default values
 * 
 * @author adaussy
 *
 */
public class DefaultValueConfigDelegate {

	private final AddDefaultValueChange change;
	private final ColumnConfig colmunConfig;

	public DefaultValueConfigDelegate(AddDefaultValueChange addColumChange) {
		super();
		this.change = addColumChange;
		this.colmunConfig = null;
	}

	public DefaultValueConfigDelegate(ColumnConfig colmunConfig) {
		super();
		this.change = null;
		this.colmunConfig = colmunConfig;		
	}

	public void setDefaultValueBoolean(String value) {

		if (DefaultTypeMatcher.isBooleanValue(value)) {
			setDefaultValueBoolean(Boolean.valueOf(value));
		} else {
			setDefaultValue(value);
		}
	}

	private void setDefaultValueBoolean(Boolean value) {

		if (change != null) {
			change.setDefaultValueBoolean(value);
		} else {
			colmunConfig.setDefaultValueBoolean(value);
		}
	}

	public void setDefaultValue(String value) {
		if (change != null) {
			change.setDefaultValue(value);
		} else {
			colmunConfig.setDefaultValue(value);
		}
	}

	public void setDefaultValueDate(String value) {
		if (change != null) {
			change.setDefaultValueDate(value);
		} else {
			colmunConfig.setDefaultValueDate(value);
		}
	}

	public void setDefaultValueNumeric(String value) {
		if (change != null) {
			change.setDefaultValueNumeric(value);
		} else {
			colmunConfig.setDefaultValueNumeric(value);
		}
	}

}
