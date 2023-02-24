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
package org.obeonetwork.dsl.database.liquibasegen.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.obeonetwork.dsl.database.liquibasegen.service.DefaultTypeMatcher.LiquibaseDefaultType;
import org.obeonetwork.dsl.typeslibrary.NativeType;

public class DefaultTypeMatcherTest {

	/**
	 * Check that all existing logical type are known by DefaultTypeMatcher
	 */
	@Test
	public void testExistingMLDDataType() {
		ResourceSet rs = new ResourceSetImpl();
		Resource mldDataTypes = rs.getResource(URI.createPlatformPluginURI(
				"org.obeonetwork.dsl.typeslibrary/resources/LogicalModel.typeslibrary", true), true);
		TreeIterator<EObject> contentIte = mldDataTypes.getAllContents();
		while (contentIte.hasNext()) {
			EObject eObject = (EObject) contentIte.next();
			if (eObject instanceof NativeType) {
				NativeType dt = (NativeType) eObject;
				assertNotEquals(LiquibaseDefaultType.UNKWOWN, DefaultTypeMatcher.getLiquibaseDefaultType(dt));
			}
		}
	}

	@Test
	public void testStringDefaultValuePreProcess() {
		assertEquals("", DefaultTypeMatcher.preProcessDefaultValue(LiquibaseDefaultType.STRING, ""));
		assertEquals("'", DefaultTypeMatcher.preProcessDefaultValue(LiquibaseDefaultType.STRING, "'"));
		assertEquals("", DefaultTypeMatcher.preProcessDefaultValue(LiquibaseDefaultType.STRING, "''"));
		assertEquals("0", DefaultTypeMatcher.preProcessDefaultValue(LiquibaseDefaultType.STRING, "0"));
		assertEquals("0", DefaultTypeMatcher.preProcessDefaultValue(LiquibaseDefaultType.STRING, "'0'"));
	}

}
