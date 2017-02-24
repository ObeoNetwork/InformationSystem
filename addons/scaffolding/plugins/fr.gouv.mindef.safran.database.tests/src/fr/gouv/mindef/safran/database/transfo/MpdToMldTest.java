package fr.gouv.mindef.safran.database.transfo;


import org.junit.Test;

public class MpdToMldTest extends AbstractTransformationTest {

	@Override
	String getModelsFolder() {
		return "/fr.gouv.mindef.safran.database.tests/models/mpd2mld/";
	}

	@Test
	public void testoracleSimple() {
		testMpdToMld("1-oracle-simple");
	}
	
	@Test
	public void testOracleAvecAdditionalResourceEtReferencesEntreModeles() {
		
		testMpdToMld("2-oracle-avec-refs", "additional-resource-mld.database");
	}
	
	@Test
	public void testAvecBcpDeSuppressions() {
		testMpdToMld("3-bcp-suppressions");
	}
	
	
	@Test
	public void testAvecBcpDeSuppressionsEtScaffold() {
		testMpdToMldWithScaffoldModel("4-bcp-suppressions-et-scaffold");
	}
	
	@Test
	public void testmysqlSimple() {
		testMpdToMld("5-mysql-simple");
	}
	
	@Test
	public void testh2Simple() {
		testMpdToMld("6-h2-simple");
	}
	
	@Test
	public void testsqlserverSimple() {
		testMpdToMld("7-sqlserver-simple");
	}
	
	
	@Test
	public void testpostgresSimple() {
		testMpdToMld("8-postgres-simple");
	}
}
