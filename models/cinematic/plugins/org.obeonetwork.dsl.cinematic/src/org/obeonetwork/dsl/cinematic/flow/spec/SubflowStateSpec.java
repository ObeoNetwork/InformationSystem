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
package org.obeonetwork.dsl.cinematic.flow.spec;

import org.obeonetwork.dsl.cinematic.flow.impl.SubflowStateImpl;

public class SubflowStateSpec extends SubflowStateImpl {
	@Override
	public String getName() {
		if (super.getSubflow() != null) {
			return super.getSubflow().getName();
		}
		return "<unnamed>";
	}
}
