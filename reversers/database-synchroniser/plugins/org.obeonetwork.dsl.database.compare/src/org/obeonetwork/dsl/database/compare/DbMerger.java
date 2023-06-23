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
package org.obeonetwork.dsl.database.compare;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.merge.AbstractMerger;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;

public class DbMerger extends AbstractMerger {

	public DbMerger() {
		super();
	}

	@Override
	public boolean isMergerFor(Diff target) {
		return target instanceof DBDiff;
	}

}
