/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen;

import java.util.Objects;

public record ConnectionInformation(String url, String username, String password) {
	public ConnectionInformation {
		Objects.requireNonNull(url);
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
	}

	/**
	 * Returns connection details with the password masked to avoid exposing it in logs.
	 */
	@Override
	public String toString() {
		return "ConnectionInformation[url=" + url + ", username=" + username + ", password=***]";
	}

}
