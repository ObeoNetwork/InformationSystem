package org.obeonetwork.dsl.database.tests.h2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Schema;
import org.obeonetwork.dsl.database.Sequence;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.database.reverse.DatabaseReverser;
import org.obeonetwork.dsl.database.reverse.source.DataSource;
import org.obeonetwork.dsl.database.reverse.utils.MultiDataBaseQueries;
import org.obeonetwork.dsl.database.spec.DatabaseConstants;
import org.obeonetwork.dsl.database.tests.AbstractTests;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;
import org.obeonetwork.dsl.typeslibrary.util.TypesLibraryUtil;

import liquibase.exception.DatabaseException;

public class H2Tests extends AbstractTests {

	private static final String H2_DATABASE_MODEL_REFERENCE_PATH = "resources/h2_outputRef.database";

	private static final String JDBC_H2_URL_PATTERN = "jdbc:h2:tcp://%1$s:%2$s/%3$s";

	private static final Object H2_HOST_DEFAULT = "127.0.0.1";

	private static final Object H2_PORT_DEFAULT = "1521";

	@BeforeClass
	public static void setUpBeforeClass() throws DatabaseException {
		String url = String.format(JDBC_H2_URL_PATTERN, H2_HOST_DEFAULT, H2_PORT_DEFAULT, DATABASE_NAME_DEFAULT);
		database = TestUtils.openDatabaseConnection(url, "", "");
	}

	@Test
	public void testImportH2() {
		String url = String.format(JDBC_H2_URL_PATTERN, H2_HOST_DEFAULT, H2_PORT_DEFAULT, DATABASE_NAME_DEFAULT);
		DataSource dataSource = new DataSource(DATABASE_NAME_DEFAULT, "PUBLIC");
		dataSource.setJdbcUrl(url);
		dataSource.setVendor(DatabaseConstants.DB_H2_13);

		DataBase database = DatabaseReverser.reverse(dataSource, new MultiDataBaseQueries(), null);

		DataBase databaseRef = TestUtils.loadModel(H2_DATABASE_MODEL_REFERENCE_PATH, TypesLibraryUtil.H2_PATHMAP);

		this.prepareH2RefModel(databaseRef, database);
		
		TestUtils.checkEquality(database, databaseRef);
	}

	private void prepareH2RefModel(DataBase ref, DataBase database) {
		List<Column> allColumns = new ArrayList<>();
		allColumns.addAll(getColumnsWithDefaultValueFromDirectTableOfDatabase(ref));
		allColumns.addAll(getColumnsWithDefaultValueFromSchemasOfDatabase(ref));
		
		List<Sequence> allSequences = new ArrayList<>();
		allSequences.addAll(ref.getSequences());
		allSequences.addAll(ref.getSchemas().stream().map(Schema::getSequences).flatMap(Collection::stream)
				.collect(Collectors.toList()));
		
		for (Column column : allColumns) {
			// Gets the column from the database retrieved from H2 database using the relative URI fragment path of the column of the reference database
			String refColumnID = EcoreUtil.getRelativeURIFragmentPath(ref, column);
			EObject eColumn = EcoreUtil.getEObject(database, refColumnID);
			if (eColumn instanceof Column) {
				// Extracts ###IDx### from the default value of a column from the reference database
				String refColumnDefaultValue = column.getDefaultValue();
				String refSeqUUID = refColumnDefaultValue.substring("(NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_".length(), refColumnDefaultValue.length() - 1);
				
				// Gets the sequence of the reference database associated with the column.
				Optional<Sequence> optSeq = allSequences.stream().filter(seq -> seq.getName().contains(refSeqUUID)).findFirst();
				if (optSeq.isPresent()) {
					Sequence refSeq = optSeq.get();
					
					// Gets the sequence from the database retrieved from H2 database using the relative URI fragment path of the sequence of the reference database
					String refSeqID = EcoreUtil.getRelativeURIFragmentPath(ref, refSeq);
					EObject eSequence = EcoreUtil.getEObject(database, refSeqID);
					if (eSequence instanceof Sequence) {
						// Update the name of the sequence contained in the reference database
						refSeq.setName(((Sequence) eSequence).getName());
					}
				}
				// Update the default value of the column contained in the reference database
				column.setDefaultValue(((Column) eColumn).getDefaultValue());
			}
		}
	}
	
	private Collection<? extends Column> getColumnsWithDefaultValueFromDirectTableOfDatabase(DataBase ref) {
		List<Column> columns = ref.getTables().stream()
				.filter(Table.class::isInstance)
				.map(Table.class::cast)
				.map(Table::getColumns)
				.flatMap(Collection::stream)
				.filter(this::hasDefaultValue)
				.collect(Collectors.toList());
		return columns;
	}

	private Collection<? extends Column> getColumnsWithDefaultValueFromSchemasOfDatabase(DataBase ref) {
		List<Column> columns = ref.getSchemas().stream()
				.map(Schema::getTables)
				.flatMap(Collection::stream)
				.filter(Table.class::isInstance)
				.map(Table.class::cast)
				.map(Table::getColumns)
				.flatMap(Collection::stream)
				.filter(this::hasDefaultValue)
				.collect(Collectors.toList());
		return columns;
	}
	
	private boolean hasDefaultValue(Column col) {
		String defaultValue = col.getDefaultValue();
		return defaultValue != null && !defaultValue.isEmpty() && defaultValue.contains("###ID");
	}
}
