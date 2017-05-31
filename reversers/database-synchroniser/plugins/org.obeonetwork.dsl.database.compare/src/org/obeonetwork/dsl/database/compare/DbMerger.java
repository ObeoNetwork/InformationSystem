/*******************************************************************************
 * Copyright (c) 2011, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
