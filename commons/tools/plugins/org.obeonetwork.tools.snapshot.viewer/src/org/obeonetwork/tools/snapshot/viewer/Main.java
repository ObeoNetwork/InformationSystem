package org.obeonetwork.tools.snapshot.viewer;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.cdo.internal.server.Repository;
import org.eclipse.emf.cdo.internal.server.bundle.CDOCommandProvider;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.server.CDOServerUtil;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.IStore;
import org.eclipse.emf.cdo.server.mem.MEMStoreUtil;
import org.eclipse.emf.cdo.server.net4j.CDONet4jServerUtil;
import org.eclipse.emf.cdo.spi.server.CDOCommand;
import org.eclipse.emf.cdo.spi.server.InternalSessionManager;
import org.eclipse.emf.cdo.spi.server.InternalStore;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.acceptor.IAcceptor;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.security.IAuthenticator;
import org.eclipse.net4j.util.security.PasswordCredentialsProvider;
import org.junit.Test;

public class Main {
	private static final String REPOSITORY_NAME = "SnapshotViewer";
	
	private static final String USER_LOGIN = "user";

	@Test
	public void test() {

		// Prepare the Net4j kernel
		Net4jUtil.prepareContainer(IPluginContainer.INSTANCE);
		// Prepare the JVM support
		JVMUtil.prepareContainer(IPluginContainer.INSTANCE);
		// Prepare the TCP support
		TCPUtil.prepareContainer(IPluginContainer.INSTANCE);
		// Prepare the CDO server
		CDONet4jServerUtil.prepareContainer(IPluginContainer.INSTANCE);
		// Prepare the CDO client
		CDONet4jUtil.prepareContainer(IPluginContainer.INSTANCE);

		IStore store = MEMStoreUtil.createMEMStore();

		// Setup Repository
		Map<String, String> props = new HashMap<String, String>();
		props.put(IRepository.Props.OVERRIDE_UUID, REPOSITORY_NAME);
		props.put(IRepository.Props.SUPPORTING_AUDITS, "true");
		props.put(IRepository.Props.SUPPORTING_BRANCHES, "true");

		Repository repository = new Repository.Default();
		repository.setName(REPOSITORY_NAME);
		repository.setStore((InternalStore) store);
		repository.setProperties(props);
		InternalSessionManager sessionManager = (InternalSessionManager) CDOServerUtil
				.createSessionManager();
		sessionManager.setAuthenticator(new IAuthenticator() {
			public void authenticate(String userID, char[] password)
					throws SecurityException {
				// always ok GOD MOD!
			}
		});
		repository.setSessionManager(sessionManager);

		CDOServerUtil.addRepository(IPluginContainer.INSTANCE, repository);

		IAcceptor acceptor = JVMUtil.getAcceptor(IPluginContainer.INSTANCE, "default"); //$NON-NLS-1$
		IConnector connector = JVMUtil.getConnector(IPluginContainer.INSTANCE, "default"); //$NON-NLS-1$

		CDOSessionConfiguration config = CDONet4jUtil.createSessionConfiguration();
		config.setConnector(connector);
		config.setRepositoryName(REPOSITORY_NAME);
		config.setCredentialsProvider(new PasswordCredentialsProvider(
				USER_LOGIN, USER_LOGIN.toCharArray()));

		org.eclipse.emf.cdo.net4j.CDOSession session = config.openSession();
		config.setSignalTimeout(-1);
		
		CDOCommandProvider cdoCommandProvider = new CDOCommandProvider(Activator.getContext());
		CDOCommand importCommand = cdoCommandProvider.getCommands().get("import");
		String xmlFile = "C:/Temp/toto.xml";
		try {
			importCommand.execute(new String[] {REPOSITORY_NAME, xmlFile});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
