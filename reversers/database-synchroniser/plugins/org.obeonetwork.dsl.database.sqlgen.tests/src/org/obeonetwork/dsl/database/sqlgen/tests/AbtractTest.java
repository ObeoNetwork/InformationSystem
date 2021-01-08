/*******************************************************************************
 * Copyright (c) 2008, 2021 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.sqlgen.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.List;

import org.eclipse.acceleo.common.utils.ModelUtils;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.compare.extensions.services.DatabaseCompareService;
import org.obeonetwork.dsl.database.compare.extensions.services.DiffContentService;
import org.obeonetwork.dsl.database.dbevolution.DbevolutionPackage;
import org.obeonetwork.dsl.database.util.DatabaseResourceFactoryImpl;

public abstract class AbtractTest {

	protected void standaloneBootStrap(ResourceSet resourceSet) {
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new DatabaseResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(DatabasePackage.eNS_URI, DatabasePackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(DbevolutionPackage.eNS_URI, DbevolutionPackage.eINSTANCE);
	}

	protected Comparison diff(String left, String right) throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		standaloneBootStrap(rs);
		InputStream leftStream = getClass().getClassLoader().getResourceAsStream(left);
		assertNotNull(leftStream);
		InputStream rightStream = getClass().getClassLoader().getResourceAsStream(right);
		assertNotNull(rightStream);
		EObject rootSource = ModelUtils.load(leftStream, "left.database", rs);
		assertNotNull(rootSource);
		EObject rootTarget = ModelUtils.load(rightStream, "right.database", rs);
		assertNotNull(rootTarget);

		assertTrue(rootSource instanceof TableContainer);
		assertTrue(rootTarget instanceof TableContainer);

		return diff((TableContainer) rootSource, (TableContainer) rootTarget);

	}

	protected Comparison diff(TableContainer left, TableContainer right) throws Exception {
		Comparison comparison = DatabaseCompareService.compare(left, right);
		assertNotNull(comparison);

//		DatabaseChangeSet databaseChangeSet = null;
//		if (comparison instanceof DatabaseChangeSet) {
//			databaseChangeSet = (DatabaseChangeSet) comparison;
//		}
//		assertNotNull(databaseChangeSet);
		
		DiffContentService DiffContentService= new DiffContentService();

		System.out.println("---- Print ChangeSet -----");
		for (Diff element : comparison.getDifferences()) {
			System.out.println("\t"+element.eClass().getName()/*+"("+element+")"*/);
			List<Diff> subDiffs = DiffContentService.getSubDiffs(element, comparison);
			if(!subDiffs.isEmpty()){
				for (Diff e : subDiffs) {
					System.out.println("\t\t"+e.eClass().getName()+"("+e+")");
				}
			}
		}

		return comparison;
	}
}
