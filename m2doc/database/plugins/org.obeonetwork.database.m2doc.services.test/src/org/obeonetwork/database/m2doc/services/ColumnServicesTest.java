package org.obeonetwork.database.m2doc.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;
import org.junit.Test;
import org.obeonetwork.database.m2doc.services.common.AbstractTest;
import org.obeonetwork.dsl.database.Column;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.database.Table;
import org.obeonetwork.dsl.typeslibrary.NativeType;
import org.obeonetwork.dsl.typeslibrary.NativeTypeKind;
import org.obeonetwork.dsl.typeslibrary.TypeInstance;
import org.obeonetwork.dsl.typeslibrary.TypesLibraryPackage;

public class ColumnServicesTest extends AbstractTest {
	/**
	 * the test database model.
	 */
	private DataBase dataBase;

	@Before
	public void setUp() {
		dataBase = loadModel("model/serie-oracle.database");
	}

	private Table getGSSerieTable() {
		List<Table> tables = new ArrayList<Table>(new DataBaseServices().allTables(dataBase));
		for (Table table : tables) {
			if ("GS_SERIE".equals(table.getName())) {
				return table;
			}
		}
		return null;
	}

	/**
	 * Returns the specified column.
	 * 
	 * @param table
	 * @param colName
	 * @return
	 */
	private Column getColumn(Table table, String colName) {
		for (Column col : table.getColumns()) {
			if (colName.contentEquals(col.getName())) {
				return col;
			}
		}
		return null;
	}

	@Test
	public void isUniqueOuiTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_NOM");
		assertEquals("Oui", new ColumnServices().isUnic(col));
	}

	@Test
	public void isUniqueNonTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_ID");
		assertEquals("Non", new ColumnServices().isUnic(col));
	}

	@Test
	public void isUniqueCheckTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_NOM");
		assertEquals("X", new ColumnServices().checkUnique(col));
	}

	@Test
	public void isUniqueCheckNotTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_ID");
		assertEquals("", new ColumnServices().checkUnique(col));
	}

	@Test
	public void isPrimaryKeyOuiTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_ID");
		assertEquals("Oui", new ColumnServices().isInPrimaryKey(col));
	}

	@Test
	public void isPrimaryKeyNonTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_NOM");
		assertEquals("Non", new ColumnServices().isInPrimaryKey(col));
	}

	@Test
	public void isPrimaryKeyCheckTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_ID");
		assertEquals("X", new ColumnServices().checkInPrimaryKey(col));
	}

	@Test
	public void isPrimaryKeyCheckNotTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_NOM");
		assertEquals("", new ColumnServices().checkInPrimaryKey(col));
	}

	@Test
	public void isForeignKeyOuiTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "RF_GENRE_ID");
		assertEquals("Oui", new ColumnServices().isInForeignKey(col));
	}

	@Test
	public void isForeignKeyNonTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_NOM");
		assertEquals("Non", new ColumnServices().isInForeignKey(col));
	}

	@Test
	public void isForeignKeyCheckTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "RF_GENRE_ID");
		assertEquals("X", new ColumnServices().checkInForeignKey(col));
	}

	@Test
	public void isForeignKeyCheckNotTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_NOM");
		assertEquals("", new ColumnServices().checkInForeignKey(col));
	}
	// @Test
	// public void isAutoIncrementTest() {
	// Table table = getGSSerieTable();
	// Column col = getColumn(table, "RF_GENRE_ID");
	// assertEquals("Oui", new ColumnServices().isForeignKey(col));
	// }

	@Test
	public void isAutoIncrementNonTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_NOM");
		assertEquals("Non", new ColumnServices().isInForeignKey(col));
	}

	// @Test
	// public void isAutoIncrementCheckTest() {
	// Table table = getGSSerieTable();
	// Column col = getColumn(table, "RF_GENRE_ID");
	// assertEquals("X", new ColumnServices().checkForeignKey(col));
	// }

	@Test
	public void isAutoIncrementCheckNotTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "GS_SERIE_NOM");
		assertEquals("", new ColumnServices().checkInForeignKey(col));
	}

	@Test
	public void isForeignKeyNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("No", new ColumnServices().isInForeignKey(col));
	}

	@Test
	public void isPrimaryKeyNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("No", new ColumnServices().isInPrimaryKey(col));
	}

	@Test
	public void isNullableNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("No", new ColumnServices().isNullable(col));
	}

	@Test
	public void isMandatoryNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("No", new ColumnServices().isMandatory(col));
	}

	@Test
	public void isAutoincrementNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("No", new ColumnServices().isAutoincrement(col));
	}

	@Test
	public void isUniqueNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("No", new ColumnServices().isUnic(col));
	}

	@Test
	public void checkForeignKeyNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("", new ColumnServices().checkInForeignKey(col));
	}

	@Test
	public void checkPrimaryKeyNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("", new ColumnServices().checkInPrimaryKey(col));
	}

	@Test
	public void checkNullableNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("", new ColumnServices().checkNullable(col));
	}

	@Test
	public void checkAutoincrementNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("", new ColumnServices().checkAutoincrement(col));
	}

	@Test
	public void checkUniqueNullTest() {
		Table table = getGSSerieTable();
		Column col = getColumn(table, "No table");
		assertEquals("", new ColumnServices().checkUnique(col));
	}

	@Test
	public void testColumnLengthSIMPLE() {
		Column col = (Column) EcoreUtil.create(DatabasePackage.Literals.COLUMN);
		TypeInstance type = (TypeInstance) EcoreUtil.create(TypesLibraryPackage.Literals.TYPE_INSTANCE);
		NativeType nType = (NativeType) EcoreUtil.create(TypesLibraryPackage.Literals.NATIVE_TYPE);
		col.setType(type);
		type.setNativeType(nType);
		nType.setSpec(NativeTypeKind.SIMPLE);
		assertEquals("", new ColumnServices().typeLength(col));
	}

	@Test
	public void testColumnLengthENUM() {
		Column col = (Column) EcoreUtil.create(DatabasePackage.Literals.COLUMN);
		TypeInstance type = (TypeInstance) EcoreUtil.create(TypesLibraryPackage.Literals.TYPE_INSTANCE);
		NativeType nType = (NativeType) EcoreUtil.create(TypesLibraryPackage.Literals.NATIVE_TYPE);
		col.setType(type);
		type.setNativeType(nType);
		nType.setSpec(NativeTypeKind.ENUM);
		assertEquals("", new ColumnServices().typeLength(col));
	}

	@Test
	public void testColumnLengthLENGTH() {
		Column col = (Column) EcoreUtil.create(DatabasePackage.Literals.COLUMN);
		TypeInstance type = (TypeInstance) EcoreUtil.create(TypesLibraryPackage.Literals.TYPE_INSTANCE);
		NativeType nType = (NativeType) EcoreUtil.create(TypesLibraryPackage.Literals.NATIVE_TYPE);
		col.setType(type);
		type.setNativeType(nType);
		nType.setSpec(NativeTypeKind.LENGTH);
		type.setLength(255);
		assertEquals("255", new ColumnServices().typeLength(col));
	}

	@Test
	public void testColumnLengthLENGTHANDPRECISION() {
		Column col = (Column) EcoreUtil.create(DatabasePackage.Literals.COLUMN);
		TypeInstance type = (TypeInstance) EcoreUtil.create(TypesLibraryPackage.Literals.TYPE_INSTANCE);
		NativeType nType = (NativeType) EcoreUtil.create(TypesLibraryPackage.Literals.NATIVE_TYPE);
		col.setType(type);
		type.setNativeType(nType);
		nType.setSpec(NativeTypeKind.LENGTH_AND_PRECISION);
		type.setLength(255);
		type.setPrecision(8);
		assertEquals("255,8", new ColumnServices().typeLength(col));
	}

	@Test
	public void testDefaultValueService() {
		Column col = (Column) EcoreUtil.create(DatabasePackage.Literals.COLUMN);
		col.setDefaultValue("defaultValue");
		assertEquals("defaultValue", new ColumnServices().defaultValue(col));
	}

	@Test
	public void testNoDefaultValueService() {
		Column col = (Column) EcoreUtil.create(DatabasePackage.Literals.COLUMN);
		assertEquals("", new ColumnServices().defaultValue(col));
	}
}
