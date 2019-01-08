/*******************************************************************************
 * Copyright (c) 2016, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.snapshot.viewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.server.CDOServerImporter;
import org.eclipse.emf.cdo.server.CDOServerUtil;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.IStore;
import org.eclipse.emf.cdo.server.mem.MEMStoreUtil;
import org.eclipse.emf.cdo.server.net4j.CDONet4jServerUtil;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.net4j.acceptor.IAcceptor;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.io.IOUtil;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.sirius.business.api.query.FileQuery;
import org.obeonetwork.tools.snapshot.viewer.extension.IPostImportHandler;
import org.obeonetwork.tools.snapshot.viewer.extension.PostImportHandlerFactory;

import fr.obeo.dsl.viewpoint.collab.api.CDOExporter;
import fr.obeo.dsl.viewpoint.collab.api.CDORepositoryManager;
import fr.obeo.dsl.viewpoint.collab.api.CDORepositoryManagerRegistry;
import fr.obeo.dsl.viewpoint.collab.api.RepositoryConnectionException;
import fr.obeo.dsl.viewpoint.collab.model.cdoconfig.ConnectionType;

/**
 * Embedded CDO server used to load a XML file (exported from CDO).
 * The server uses a memory store to store data
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class EmbeddedCDOServer {

	public static final String DEFAULT_REPOSITORY_NAME = "designer-server";
	private static final String DEFAULT_HOST = "localhost";
	public static final int DEFAULT_PORT = 0;

	private String repositoryName = DEFAULT_REPOSITORY_NAME;
	private String host = DEFAULT_HOST;
	private int port = DEFAULT_PORT;

	private IRepository repository;
	private IAcceptor acceptor;

	/**
	 * Start a new server on an available port and load the XML file if provided. 
	 * @param dataFile XML data file (obtained via 'cdo export' on server) - optional 
	 * @param parentMonitor Progress monitor
	 * @throws Exception
	 */
	public void start(File dataFile, IProgressMonitor parentMonitor) throws Exception  {
		SubMonitor monitor = SubMonitor.convert(parentMonitor, 4);
		monitor.setTaskName("Retrieve repository name from XML");
		try {
			// Retrieve repository name from XML file
			// if we create a repository with a different name
			// then a "fromCDORoot" project is created when importing
			// the project into the workspace
			repositoryName = getRepositoryName(dataFile);
			monitor.worked(1);
			
			// Create store
			IStore store = MEMStoreUtil.createMEMStore();
			monitor.worked(1);
			
			// Create repository
			repository = createRepository(store, dataFile);
			monitor.worked(1);
			
			// Create acceptor
			acceptor = createAcceptor();
			monitor.worked(1);
		} catch (Exception e) {
			throw e;
		} finally {
			monitor.done();
		}
	}

	/**
	 * Retrieve repository name from XML file
	 * @param dataFile
	 * @return
	 * @throws FileNotFoundException
	 * @throws XMLStreamException
	 */
	private String getRepositoryName(File dataFile) throws FileNotFoundException, XMLStreamException {
		String repoName = null;
		FileInputStream inputStream = new FileInputStream(dataFile);
		
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
		while (reader.hasNext() && repoName == null) {
			int event = reader.next();

			switch(event){
	        case XMLStreamConstants.START_ELEMENT: 
	          if ("repository".equals(reader.getLocalName())){
	            repoName = reader.getAttributeValue("", "name");
	          }
	          break;
	      }
		}
		reader.close();
		try {
			inputStream.close();
		} catch (IOException e) {
			// Do nothing
		}

		if (repoName == null) {
			return DEFAULT_REPOSITORY_NAME;
		} else {
			return repoName;
		}
	}

	/**
	 * Stop server
	 */
	public void stop() {
		LifecycleUtil.deactivate(acceptor);
		LifecycleUtil.deactivate(repository);

		acceptor = null;
		repository = null;
	}

	/**
	 * Retrieve remote projects from CDO server
	 * @param parentMonitor
	 * @return
	 */
	public Collection<URI> getRemoteProjectsURIs(IProgressMonitor parentMonitor) {
		SubMonitor monitor = SubMonitor.convert(parentMonitor, 1);
		monitor.setTaskName("Retrieving remote projects list");
		
		CDOSession session = getCDOSession();
		CDOTransaction transaction = session.openTransaction();
		Collection<URI> remoteProjectsURIs = getRemoteProjectsURIs(transaction);
		transaction.close();
		session.close();
		
		monitor.worked(1);
		monitor.done();
		
		return remoteProjectsURIs;
	}
	
	/**
	 * Import remote project into workspace
	 * @param remoteResourceURI Remote project URI (to aird resource)
	 * @param remoteToLocalProjectNameMapping Mapping between remote and local projects names
	 * @param parentMonitor
	 * @throws RepositoryConnectionException
	 * @throws CoreException
	 */
	public void importProjectFromRepository(URI remoteResourceURI, Map<String, String> remoteToLocalProjectNameMapping, IProgressMonitor parentMonitor)
			throws RepositoryConnectionException, CoreException {
		SubMonitor monitor = SubMonitor.convert(parentMonitor, 1);
		monitor.setTaskName("Import remote project into workspace");
		Set<URI> resourceURIs = new HashSet<URI>();
		resourceURIs.add(remoteResourceURI);
		
		CDORepositoryManager repositoryManager = getRepositoryManager();
			
		CDOExporter cdoExporter = new CDOExporter();
		cdoExporter.exportResourcesFromRepository(resourceURIs, repositoryManager, true, true,
				remoteToLocalProjectNameMapping, monitor);
		
		// Call postImport handlers
		doPostImport(remoteToLocalProjectNameMapping);
	}
	
	private void doPostImport(Map<String, String> remoteToLocalProjectNameMapping) {
		Collection<IPostImportHandler> handlers = PostImportHandlerFactory.getInstance().getPostImportHandlers();
		for (IPostImportHandler handler : handlers) {
			handler.doPostImport(this, remoteToLocalProjectNameMapping);
		}
	}
	
	public CDOSession getCDOSession() {
		String productGroup = "org.eclipse.emf.cdo.sessions";
		return (CDOSession) IPluginContainer.INSTANCE.getElement(productGroup, "cdo", getTcpUrl());
	}
	
	private IRepository createRepository(IStore store, File xmlFile) throws Exception {
		Map<String, String> props = new HashMap<String, String>();
		props.put(IRepository.Props.OVERRIDE_UUID, repositoryName);
		props.put(IRepository.Props.SUPPORTING_AUDITS, Boolean.FALSE.toString());
		props.put(IRepository.Props.SUPPORTING_BRANCHES, Boolean.FALSE.toString());

		IRepository repository = CDOServerUtil.createRepository(repositoryName, store, props);
		CDONet4jServerUtil.prepareContainer(IPluginContainer.INSTANCE);

		// Try to import XML file if one has been specified
		if (xmlFile != null) {
			importXMLFile(repository, xmlFile);
		}

		// Activate repository
		CDOServerUtil.addRepository(IPluginContainer.INSTANCE, repository);

		return repository;
	}

	private void importXMLFile(IRepository repository, File dataXmlFile) throws Exception {
		if (!dataXmlFile.exists()) {
			throw new IllegalArgumentException("XML File " + dataXmlFile.getAbsolutePath() + " does not exist.");
		}

		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(dataXmlFile);

			// Import file
			CDOServerImporter.XML importer = new CDOServerImporter.XML(repository);
			importer.importRepository(inputStream);

		} finally {
			IOUtil.close(inputStream);
		}
	}

	private IAcceptor createAcceptor() throws IOException {
		// If the port was not specified we try to get an available one
		if (port == 0) {
			port = getAvailablePort();
		}
		return TCPUtil.getAcceptor(IPluginContainer.INSTANCE, getUrl());
	}

	private int getAvailablePort() throws IOException {
		ServerSocket s = new ServerSocket(0);
		int localPort = s.getLocalPort();
		s.close();
		return localPort;
	}

	public String getRepositoryName() {
		return repositoryName;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getUrl() {
		return host + TCPUtil.PORT_SEPARATOR + port;
	}

	public String getTcpUrl() {
		return TCPUtil.FACTORY_TYPE + "://" + host + TCPUtil.PORT_SEPARATOR + port + "?repositoryName="
				+ getRepositoryName();
	}

	private Collection<URI> getRemoteProjectsURIs(CDOTransaction transaction) {
		Collection<URI> remoteProjectsURIs = new ArrayList<URI>();

		CDOResource rootResource = transaction.getRootResource();

		for (EObject object : rootResource.getContents()) {
			// Test first on ResourceFolder because a CDOResourceFolder is also
			// a
			// CDOResourceNode
			if (object instanceof CDOResourceFolder) {
				// Search in folder
				remoteProjectsURIs.addAll(getRemoteProjectsURIs((CDOResourceFolder) object));
			} else if (object instanceof CDOResourceNode) {
				CDOResourceNode node = (CDOResourceNode) object;
				if (isSessionResource(node)) {
					remoteProjectsURIs.add(node.getURI());
				}
			}
		}

		return remoteProjectsURIs;
	}

	private Collection<URI> getRemoteProjectsURIs(CDOResourceFolder folder) {
		Collection<URI> remoteProjectsURIs = new ArrayList<URI>();

		for (CDOResourceNode node : folder.getNodes()) {
			if (isSessionResource(node)) {
				remoteProjectsURIs.add(node.getURI());
			} else if (node instanceof CDOResourceFolder) {
				getRemoteProjectsURIs((CDOResourceFolder) node);
			}
		}

		return remoteProjectsURIs;
	}

	protected boolean isSessionResource(CDOResourceNode cdoResourceNode) {
		return ((cdoResourceNode instanceof CDOResource)
				&& (new FileQuery(cdoResourceNode.getURI().fileExtension()).isSessionResourceFile()));
	}

	private CDORepositoryManager getRepositoryManager() {
		return CDORepositoryManagerRegistry.getRepositoryManager(getHost(), Integer.toString(getPort()),
				getRepositoryName(), ConnectionType.TCP);
	}

}
