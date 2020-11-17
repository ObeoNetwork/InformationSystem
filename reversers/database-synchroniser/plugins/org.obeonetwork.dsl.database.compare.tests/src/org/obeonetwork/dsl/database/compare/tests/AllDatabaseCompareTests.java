/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.compare.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.obeonetwork.dsl.database.compare.tests.comparison.DatabaseComparisonTestSuite;
import org.obeonetwork.dsl.database.compare.tests.generation.DatabaseEvolutionScriptGenerationTestSuite;
import org.obeonetwork.dsl.database.compare.tests.transformation.DatabaseTransformationTestSuite;

@RunWith(Suite.class)
@SuiteClasses({ DatabaseComparisonTestSuite.class, DatabaseTransformationTestSuite.class,
		DatabaseEvolutionScriptGenerationTestSuite.class })
/**
 * Launches all tests for all stages of the "database compare" feature:
 * <ul>
 * <li>Database comparison using EMFCompare</li>
 * <li>Transformation of the resulting EMFCompare Comparison into a DBEvolution
 * model</li>
 * <li>Generation of the corresponding SQL scripts to actually do the
 * evolution</li>
 * </ul>
 * 
 * @author Florent Latombe
 *         <a href= "mailto:florent.latombe@obeo.fr">florent.latombe@obeo.fr</a>
 *
 */
public class AllDatabaseCompareTests {
	/**
	 * The constructor.
	 */
	private AllDatabaseCompareTests() {
		// Prevent instantiation
	}

}
