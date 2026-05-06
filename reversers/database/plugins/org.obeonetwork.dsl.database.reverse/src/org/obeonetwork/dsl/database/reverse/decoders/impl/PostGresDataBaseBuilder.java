/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.reverse.decoders.impl;

import java.math.BigInteger;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.obeonetwork.dsl.database.AbstractTable;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.Constraint;
import org.obeonetwork.dsl.database.PrimaryKey;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.database.reverse.DatabaseReverserPlugin;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.CreationUtils;
import org.obeonetwork.dsl.database.reverse.utils.JdbcUtils;
import org.obeonetwork.dsl.database.reverse.utils.ProgressListener;
import org.obeonetwork.dsl.database.reverse.utils.Queries;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;
import org.osgi.framework.Version;

public class PostGresDataBaseBuilder extends DefaultDataBaseBuilder {

	private Version version;

	private PostGresStatementBuilder builder;
	
	public PostGresDataBaseBuilder(DataSource source,
			ProgressListener progressListener, Queries queries)
			throws SQLException {
		super(source, progressListener, queries);
		this.setSchemaName(source.getSchemaName());
		builder = new PostGresStatementBuilder(metaData.getConnection());
	}

	@Override
	protected String getTypesLibraryUriPathmap() {
		return TypesLibraryUtil.POSTGRES_PATHMAP;
	}

	@Override
	protected String getTypesLibraryFileName() {
		return TypesLibraryUtil.POSTGRES_FILENAME;
	}

	@Override
	protected TypeInstance createTypeInstance(
			NativeTypesLibrary nativeTypesLibrary, String columnType,
			int columnSize, int decimalDigits) {
		String bkpColumnType = columnType;
		if (columnSize > 0) {
			columnType += "(%n";
		}
		if (decimalDigits > 0) {
			columnType += ",%p";
		}
		columnType += ")";
		NativeType nativeType = nativeTypesLibrary.findTypeByName(columnType);
		if (nativeType == null) {
			columnType = bkpColumnType;
		}
		return super.createTypeInstance(nativeTypesLibrary, columnType,
				columnSize, decimalDigits);
	}

	@Override
	public void buildTables() {
		super.buildTables();
		buildSequences(tableContainer);
	}

	private void buildSequences(TableContainer tableContainer) {
		
		// Parse the default values of all the columns to identify the links between columns and sequences
		Map<String, List<Column>> linkedByDefaultValueSequenceColumns = new HashMap();
		
		tableContainer.getTables().stream()
		.filter(Table.class::isInstance)
		.map(Table.class::cast).flatMap(t -> t.getColumns().stream())
		.forEach(c -> {
			String sequenceName = getSequenceNameFromDefaultValue(c);
			if(sequenceName != null) {
				List<Column> linkedColumns = linkedByDefaultValueSequenceColumns.get(sequenceName);
				if(linkedColumns == null) {
					linkedColumns = new ArrayList<>();
					linkedByDefaultValueSequenceColumns.put(sequenceName, linkedColumns);
				}
				linkedColumns.add(c);
			}
		});
		
		// Request the distant database to get the sequences of the current schema
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = builder.buildSequenceStatement(schemaName);
					
			rs = executeQuery(pstmt);
			while (rs.next()) {
				String sequenceName = rs.getString(1);
				BigInteger increment = getBigIntValueForColumn(rs, 2);
				BigInteger minValue = getBigIntValueForColumn(rs, 3);
				BigInteger maxValue = getBigIntValueForColumn(rs, 4); 
				BigInteger start = getBigIntValueForColumn(rs, 5);
				String cycleAsString = rs.getString(6);
				boolean cycle = "YES".equals(cycleAsString);
				
				String comment = rs.getString(7);
				
				// Retrieve CACHE value
				BigInteger cacheValue = null;
				PreparedStatement pstmtCache = builder.buildSequenceCacheValueStatement(schemaName, sequenceName);
							
				ResultSet rsCache = executeQuery(pstmtCache);
				if (rsCache.next()) {
					cacheValue = getBigIntValueForColumn(rsCache, 1);
				}
				JdbcUtils.closeStatement(pstmtCache);
				JdbcUtils.closeResultSet(rsCache);
				
				Sequence sequence = CreationUtils.createSequence(tableContainer, sequenceName, increment, minValue, maxValue, start, cycle, cacheValue);
				sequence.setComments(comment);
				// Look for a table that could correspond to the sequence based on its name
				if (sequenceName.endsWith("_seq")) {
					queries.getAllTables().stream().filter(Table.class::isInstance).map(Table.class::cast) //
					.map(Table::getPrimaryKey).map(PrimaryKey::getColumns).flatMap(List::stream) //
					.forEach(pkColumn -> {
						Table table = pkColumn.getOwner();
						if(sequenceName.equalsIgnoreCase(table.getName() + "_seq") || 
								sequenceName.equalsIgnoreCase(table.getName() + "_" + pkColumn.getName() + "_seq")) {
							pkColumn.setSequence(sequence);
						}
					});
				}
				
				// Link the columns referencing the sequence in their default value to the sequence
				if(linkedByDefaultValueSequenceColumns.get(sequenceName) != null) {
					linkedByDefaultValueSequenceColumns.get(sequenceName).forEach(column -> {
						column.setSequence(sequence);
					});
				}
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			JdbcUtils.closeResultSet(rs);
		}

	}
	
	private String getSequenceNameFromDefaultValue(Column column) {
		String sequenceName = null;
		
		String defaultValue = column.getDefaultValue();
		// Pattern matching expressions such as "nextval('schemaName.sequenceName'::regclass)"
		// In this example, first group matches "schemaName.sequenceName"
		Pattern p = Pattern.compile("nextval\\('([^']*)'[^\\)]*\\)");
		Matcher matcher = p.matcher(defaultValue);
		if(matcher.find()) {
			sequenceName = matcher.group(1);
			if(sequenceName.contains(".")) {
				sequenceName = sequenceName.substring(sequenceName.indexOf('.') + 1);
			}
		}
		
		return sequenceName;
	}
	
	@Override
	protected Column buildColumn(DatabaseMetaData metaData, TableContainer owner, NativeTypesLibrary nativeTypesLibrary, AbstractTable table, ResultSet rs) throws SQLException {
		Column column = super.buildColumn(metaData, owner, nativeTypesLibrary, table, rs);
		
		// Do not set the default value for the *SERIAL types
		Set<String> serialTypesNames = Set.of("SMALLSERIAL", "SERIAL", "BIGSERIAL");
		if(serialTypesNames.contains(((TypeInstance)column.getType()).getNativeType().getName())) {
			column.setDefaultValue("");
		}
		
		// Remove the type of the textual value if present
		final Pattern p = Pattern.compile("^('.*')::[^']*$");
		Matcher matcher = p.matcher(column.getDefaultValue());
		if(matcher.find()) {
			column.setDefaultValue(matcher.group(1));
		}
		
		return column;
	}

	@Override
	protected void buildColumnConstraints(DatabaseMetaData metaData, TableContainer owner, Table table) {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
			pstmt = builder.buildColumnConstraintStatement(schemaName, table.getName());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {					
				String name = rs.getString(1);
				String expression = rs.getString(2);

				Constraint constraint = CreationUtils.createConstraint(table, name);
				constraint.setExpression(expression);
			}
		} catch (Exception ex) {
			DatabaseReverserPlugin.logError("Error while importing database", ex);
		} finally {
			JdbcUtils.closeStatement(pstmt);
			JdbcUtils.closeResultSet(rs);
		}
	}
	
	public void setSchemaName(String schemaName) {
		if (schemaName.isEmpty() || schemaName == null) {
			this.schemaName = "public";
		}
	}
	
	@Override
	protected String getViewQuery(DatabaseMetaData metaData, String viewName) {
		String viewQuery = super.getViewQuery(metaData, viewName);
		if (viewQuery == null) {
			String viewFullName = viewName;
			if (schemaName != null && !schemaName.trim().isEmpty()) {
				viewFullName = schemaName + "." + viewName;
			}
			String query =	"select pg_get_viewdef('" + viewFullName + "', true)";
			ResultSet rs = null;
			PreparedStatement pstmt = null;
			try {
				pstmt = metaData.getConnection().prepareStatement(query);
				rs = executeQuery(pstmt);
				while (rs.next()) {
					viewQuery = rs.getString(1);
				}
			} catch (Exception ex) {
				DatabaseReverserPlugin.logError("Error while importing database", ex);
			} finally {
				JdbcUtils.closeStatement(pstmt);
				JdbcUtils.closeResultSet(rs);
			}
		}
		
		return viewQuery;
	}
	
}
