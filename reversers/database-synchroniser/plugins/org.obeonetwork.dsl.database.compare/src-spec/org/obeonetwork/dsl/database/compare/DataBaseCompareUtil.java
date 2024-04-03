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
package org.obeonetwork.dsl.database.compare;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.ecore.resource.Resource;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabaseFactory;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.compare.extensions.services.DatabaseCompareService;
import org.obeonetwork.dsl.database.util.DatabaseResourceImpl;

/**
 * Util class to build a comparisons
 * 
 */
public class DataBaseCompareUtil {

	/**
	 * Compare the given {@link TableContainer} with a equivalent empty
	 * {@link TableContainer}
	 * 
	 * @param rootContainer a non <code>null</code> {@link TableContainer}
	 * @return a {@link Comparison}
	 */
	public static Comparison buildFromScratchComparison(TableContainer rootContainer) {
		// First let's create an empty model containing only
		Resource resource = new DatabaseResourceImpl(URI.createURI("memory:/empty_database"));

		TableContainer newContainer = null;
		if (rootContainer instanceof DataBase) {
			newContainer = copyDatabase((DataBase) rootContainer);
			resource.getContents().add(newContainer);
		} else if (rootContainer instanceof Schema) {
			newContainer = copySchema((Schema) rootContainer);
			resource.getContents().add(newContainer);
		}

		// Then compare the two models
		Comparison comparison = null;
		try {
			comparison = DatabaseCompareService.compare(rootContainer, newContainer);
		} catch (Exception e) {
		}
		return comparison;
	}

	private static DataBase copyDatabase(DataBase database) {
		DataBase newDatabase = DatabaseFactory.eINSTANCE.createDataBase();
		newDatabase.setName(database.getName());
		for (Schema schema : database.getSchemas()) {
			newDatabase.getSchemas().add((Schema) copySchema(schema));
		}
		return newDatabase;
	}

	private static Schema copySchema(Schema schema) {
		Schema newSchema = DatabaseFactory.eINSTANCE.createSchema();
		newSchema.setName(schema.getName());
		return newSchema;
	}

}
