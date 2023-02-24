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
package org.obeonetwork.dsl.cinematic.toolkits.spec;

import java.util.stream.Collectors;

import org.obeonetwork.dsl.cinematic.toolkits.impl.WidgetImpl;

public class WidgetSpec extends WidgetImpl {

	@Override
	public String getMetadataHelp() {
		return this.getMetadataDefinitions().stream()
				.map(m -> m.getHelp())
				.filter(v -> v != null)
				.collect(Collectors.joining("\n"));
	}

	
}
