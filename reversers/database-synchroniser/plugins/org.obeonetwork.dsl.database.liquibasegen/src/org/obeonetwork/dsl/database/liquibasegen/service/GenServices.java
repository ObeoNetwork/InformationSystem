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
package org.obeonetwork.dsl.database.liquibasegen.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Index;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.View;
import org.obeonetwork.dsl.database.dbevolution.DBDiff;
import org.obeonetwork.dsl.database.dbevolution.IndexChange;
import org.obeonetwork.dsl.database.gen.common.services.DatabaseServices;
import org.obeonetwork.dsl.database.gen.common.services.TypesServices;
import org.obeonetwork.dsl.database.gen.common.services.UtilServices;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;

/**
 * Class that provides service for the Liquibase generation
 * 
 * <p>
 * It intentionally wrap other service classes to clearly identified which one a
 * required for the Liquibase generation. It may help in a future refactoring
 * when slipping the Liquibase generation in another plugin
 * </p>
 * 
 * @author adaussy
 *
 */
public class GenServices {

	private static final String EMPTY = "";

	private TypesServices typeService = new TypesServices();

	private UtilServices utilService = new UtilServices();

	private DatabaseServices databaseService = new DatabaseServices();

	/**
	 * Gets the qualified name of a {@link Table} ($schemaName.$tableName)
	 * 
	 * @param table a {@link Table}
	 * @return a String
	 */
	public String getFullName(Table table) {
		return (genQualifiedSchemaPrefix(table) + table.getName()).trim();
	}

	public String getFullName(Column column) {
		return getFullName(column.getOwner()) + "." + column.getName();
	}

	/**
	 * Gets the name of a table (prevent NPE)
	 * 
	 * @param table a table
	 * @return the name of the table or "" (never <code>null</code>)
	 */
	public String safeName(Table table) {	
		return Optional.ofNullable(table.getName()).map(String::trim).orElse(EMPTY);
	}

	private String genQualifiedSchemaPrefix(Table table) {
		String prefix = genSchemaPrefix(table);
		if (!prefix.isEmpty()) {
			return prefix + ".";
		}
		return EMPTY;
	}

	private String genSchemaPrefix(Table table) {
		if (supportsSchema(table) && table.eContainer() instanceof Schema) {
			Schema schema = (Schema) table.eContainer();
			return schema.getName();
		}
		return EMPTY;
	}

	/**
	 * Returns <code>true</code> if the given table supports schema
	 * 
	 * @param table a {@link Table}
	 * @return <code>true</code> if it does, <code>false</code> otherwise
	 */
	public boolean supportsSchema(Table table) {
		return typeService.isTargetH2(table) //
				|| typeService.isTargetOracle(table) //
				|| typeService.isTargetPostgreSQL(table) //
				|| typeService.isTargetMySql(table) // In MySQl schema = database
				|| typeService.isTargetSqlServer(table);
	}

	/**
	 * Dispose the service
	 */
	public void dispose() {
		typeService.dispose();
	}

	public boolean shouldGenerateIndex(IndexChange indexChange) {
		Index index = indexChange.getIndex();
		PrimaryKey primKey = index.getOwner().getPrimaryKey();
		
		return (primKey == null || !Objects.equals(primKey.getID(), index.getID())) //
				&& !((typeService.isTargetOracle(index) || typeService.isTargetPostgreSQL(index)) 
						&& databaseService.isIndexOnPKColumns(index));
	}

	/**
	 * Get the string representation for the given {@link TypeInstance}
	 * 
	 * @param typeInstance a TypeInstance
	 * @return a String
	 */
	public String getType(TypeInstance typeInstance) {
		return typeService.getType(typeInstance);
	}

	/**
	 * Gets the label of a given {@link EObject} (from the Database meta model)
	 * 
	 * @param o an {@link EObject}
	 * @return a String
	 */
	public String getLabel(EObject o) {
		return typeService.getLabelProvider().getText(o);
	}

	/**
	 * Gets a list of {@link DBDiff} ordered in a way it ease the generation of
	 * scripts
	 * 
	 * @param comparisonModel a Comparison
	 * @return a list
	 */
	public List<DBDiff> getOrderedChanges(Comparison comparisonModel) {
		return utilService.getOrderedChanges(comparisonModel);
	}

	public String getViewQuery(View view) {
		return databaseService.getViewQuery(view);
	}

	public List<DBDiff> getSubDiffs(Diff diff) {
		return utilService.getSubDiffs(diff);
	}

}
