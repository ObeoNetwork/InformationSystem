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
package org.obeonetwork.dsl.database.compare.tests.comparison;

import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.compare.match.IMatchEngine;
import org.junit.Test;
import org.obeonetwork.dsl.is.compare.ISMatchEngineFactory;

public class ISMatchEngineFactoryTest {

	/**
	 * This test guarantees that we can instantiate a {@link IMatchEngine} via the
	 * <code>org.eclipse.emf.compare.rcp.matchEngine</code> extension point.<br>
	 * The extension is contibuted by the <code>org.obeonetwork.dsl.is</code>
	 * plugin.<br>
	 * The test covers the case where a {@link java.lang.LinkageError} is raised due
	 * to a version mismatch with EMF Compare on <code>com.google.guava</code> as
	 * defined by the <code>Import-Package</code> section of
	 * <code>/org.obeonetwork.dsl.is/META-INF/MANIFEST.MF</code>.
	 */
	@Test
	public void testGetMatchEngine() {
		
		ISMatchEngineFactory matchEngineFactory = new ISMatchEngineFactory();
		assertNotNull(matchEngineFactory.getMatchEngine());
		
	}
	
}
