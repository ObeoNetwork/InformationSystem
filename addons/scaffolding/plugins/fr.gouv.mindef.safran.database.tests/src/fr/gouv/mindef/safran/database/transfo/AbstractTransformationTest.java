package fr.gouv.mindef.safran.database.transfo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Assert;
import org.obeonetwork.dsl.database.TableContainer;
import org.obeonetwork.dsl.entity.Root;
import org.obeonetwork.dsl.environment.Namespace;

import fr.gouv.mindef.safran.database.scaffold.ScaffoldFactory;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldInfo;
import fr.gouv.mindef.safran.database.scaffold.ScaffoldType;
import fr.gouv.mindef.safran.database.transfo.impl.EntityToMLD;
import fr.gouv.mindef.safran.database.transfo.impl.MLDToEntity;
import fr.gouv.mindef.safran.database.transfo.impl.MLDToMPD;
import fr.gouv.mindef.safran.database.transfo.impl.MPDToMLD;

public abstract class AbstractTransformationTest {

	private ResourceSet resourceSet = null;

	private static final String SCAFFOLD_MODEL_NAME = "/test.scaffold";
	private static Map<ScaffoldType, String[]> resourceNames = new HashMap<ScaffoldType, String[]>();
	{
		resourceNames.put(ScaffoldType.ENTITY_TO_MLD,
				new String[] { "/1-input-entity.entity", "/2-input-mld.database", "/3-expected-mld.database" });
		resourceNames.put(ScaffoldType.MLD_TO_ENTITY,
				new String[] { "/1-input-mld.database", "/2-input-entity.entity", "/3-expected-entity.entity" });
		resourceNames.put(ScaffoldType.MLD_TO_MPD,
				new String[] { "/1-input-mld.database", "/2-input-mpd.database", "/3-expected-mpd.database" });
		resourceNames.put(ScaffoldType.MPD_TO_MLD,
				new String[] { "/1-input-mpd.database", "/2-input-mld.database", "/3-expected-mld.database" });
	}

	public void testEntityToMldWithScaffoldModel(String folder) {
		testWithScaffoldModel(ScaffoldType.ENTITY_TO_MLD, folder);
	}

	public void testMldToEntityWithScaffoldModel(String folder) {
		testWithScaffoldModel(ScaffoldType.MLD_TO_ENTITY, folder);
	}

	public void testMldToMpdWithScaffoldModel(String folder) {
		testWithScaffoldModel(ScaffoldType.MLD_TO_MPD, folder);
	}

	public void testMpdToMldWithScaffoldModel(String folder) {
		testWithScaffoldModel(ScaffoldType.MPD_TO_MLD, folder);
	}

	public void testEntityToMld(String folder, String... additionalResources) {
		test(ScaffoldType.ENTITY_TO_MLD, folder, additionalResources);
	}

	public void testMldToEntity(String folder, String... additionalResources) {
		test(ScaffoldType.MLD_TO_ENTITY, folder, additionalResources);
	}

	public void testMldToMpd(String folder, String... additionalResources) {
		test(ScaffoldType.MLD_TO_MPD, folder, additionalResources);
	}

	public void testMpdToMld(String folder, String... additionalResources) {
		test(ScaffoldType.MPD_TO_MLD, folder, additionalResources);
	}

	private void test(ScaffoldType kind, String folder, String... additionalResources) {
		test(kind, folder, buildAdditionalResources(folder, additionalResources));
	}

	abstract String getModelsFolder();

	private void testWithScaffoldModel(ScaffoldType kind, String folder) {
		EObject object = getRootObject(
				URI.createPlatformPluginURI(getModelsFolder() + folder + SCAFFOLD_MODEL_NAME, true));
		if (object instanceof ScaffoldInfo) {
			testTransformation(kind, (ScaffoldInfo) object,
					URI.createPlatformPluginURI(getModelsFolder() + folder + resourceNames.get(kind)[2], true));
		} else {
			Assert.fail("Unable to open Scaffold model in " + folder + SCAFFOLD_MODEL_NAME);
		}
	}

	private void test(ScaffoldType kind, String folder, Iterable<URI> additionalResources) {
		ScaffoldInfo scaffoldInfo = buildScaffoldInfo(kind,
				URI.createPlatformPluginURI(getModelsFolder() + folder + resourceNames.get(kind)[0], true),
				URI.createPlatformPluginURI(getModelsFolder() + folder + resourceNames.get(kind)[1], true),
				additionalResources);
		testTransformation(kind, scaffoldInfo,
				URI.createPlatformPluginURI(getModelsFolder() + folder + resourceNames.get(kind)[2], true));
	}

	private ScaffoldInfo buildScaffoldInfo(ScaffoldType transformationKind, URI inputModel, URI outputModel,
			Iterable<URI> references) {
		EObject inputRoot = getRootObject(inputModel);
		EObject outputRoot = getRootObject(outputModel);
		Collection<EObject> additionalObjects = getAdditionalObjects(references);

		ScaffoldInfo scaffoldInfo = ScaffoldFactory.eINSTANCE.createScaffoldInfo();
		scaffoldInfo.setStartingObjectForTransformation(inputRoot, transformationKind);
		scaffoldInfo.setEndingObjectForTransformation(outputRoot, transformationKind);
		scaffoldInfo.clearAdditionalObjectsForTransformation(transformationKind);
		for (EObject additionalObject : additionalObjects) {
			scaffoldInfo.addAdditionalObjectsForTransformation(additionalObject, transformationKind);
		}
		return scaffoldInfo;
	}

	private Iterable<URI> buildAdditionalResources(String folder, String[] resourceNames) {
		List<URI> result = new ArrayList<URI>();
		for (String resourceName : resourceNames) {
			result.add(URI.createPlatformPluginURI(getModelsFolder() + folder + "/" + resourceName, true));
		}
		return result;
	}

	private void testTransformation(ScaffoldType transformationKind, ScaffoldInfo scaffoldInfo, URI expectedResult) {
		Transformation transformator = getTransformator(transformationKind);

		boolean result = transformator.doTransformationFirstStep(scaffoldInfo, transformationKind);
		Assert.assertTrue("Transformation failed", result);

		assertEquals(getResource(expectedResult), transformator.getResult());
		transformator.doTransformationFinalStep();
	}

	private Transformation getTransformator(ScaffoldType transformationKind) {
		Transformation transformator = null;
		switch (transformationKind) {
		case ENTITY_TO_MLD:
			transformator = new EntityToMLD();
			break;
		case MLD_TO_ENTITY:
			transformator = new MLDToEntity();
			break;
		case MLD_TO_MPD:
			transformator = new MLDToMPD();
			break;
		case MPD_TO_MLD:
			transformator = new MPDToMLD();
			break;
		}

		transformator.setSaveFinalResource(false);
		return transformator;
	}

	private Collection<EObject> getAdditionalObjects(Iterable<URI> uris) {
		ResourceSet set = getResourceSet();
		Collection<EObject> result = new ArrayList<EObject>();
		for (URI uri : uris) {
			Resource resource = set.getResource(uri, true);
			result.addAll(resource.getContents());
		}
		return result;
	}

	private EObject getRootObject(URI modelURI) {
		ResourceSet set = getResourceSet();
		Resource resource = set.getResource(modelURI, true);
		for (Iterator<EObject> it = resource.getAllContents(); it.hasNext();) {
			EObject object = it.next();
			if (object instanceof TableContainer || object instanceof Root || object instanceof Namespace
					|| object instanceof ScaffoldInfo) {
				return object;
			}
		}
		return null;
	}

	private void assertEquals(Resource expectedResource, Resource actualResource) {
		List<EObject> expectedContents = expectedResource.getContents();
		List<EObject> actualContents = actualResource.getContents();
		Assert.assertEquals("Not the same number of root objects", expectedContents.size(), actualContents.size());
		if (expectedContents.size() == actualContents.size()) {
			for (int i = 0; i < expectedContents.size(); i++) {
				assertEquals(expectedContents.get(i), actualContents.get(i));
			}
		}
	}

	private ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	private Resource getResource(URI uri) {
		return getResourceSet().getResource(uri, true);
	}

	private String getRelativeURIFragmentPath(EObject ancestorEObject, EObject descendantEObject, boolean resolve) {
		if (ancestorEObject == descendantEObject) {
			return "";
		}

		List<String> uriFragmentPath = new ArrayList<String>();
		HashSet<InternalEObject> visited = new HashSet<InternalEObject>();
		InternalEObject internalEObject = (InternalEObject) descendantEObject;
		for (InternalEObject container = resolve ? (InternalEObject) internalEObject.eContainer()
				: internalEObject.eInternalContainer(); container != null
						&& visited.add(container); container = resolve ? (InternalEObject) internalEObject.eContainer()
								: internalEObject.eInternalContainer()) {
			uriFragmentPath.add(container.eURIFragmentSegment(internalEObject.eContainingFeature(), internalEObject));
			internalEObject = container;
			if (container == ancestorEObject) {
				break;
			}
		}

		if (internalEObject != ancestorEObject && ancestorEObject != null) {
			throw new IllegalArgumentException(
					"The ancestor '" + ancestorEObject + "' is not an ancestor of '" + descendantEObject + "'");
		}

		StringBuilder result = new StringBuilder();
		int size = uriFragmentPath.size();
		if (size > 0) {
			for (int i = uriFragmentPath.size() - 1; i > 0; --i) {
				result.append(uriFragmentPath.get(i));
				result.append('/');
			}
			result.append(uriFragmentPath.get(0));
		}

		return result.toString();
	}
	
	private Map<String, String> getIdsMap(EObject root) {
		Map<String, String> map = new HashMap<String, String>();
		
		String rootId = root.eResource().getURIFragment(root);
		if (rootId != null) {
			map.put(rootId, getRelativeURIFragmentPath(null, root, false));
		}
		
		// Traverse all children
		TreeIterator<EObject> eAllContents = root.eAllContents();
		while (eAllContents.hasNext()) {
			EObject o = eAllContents.next();
			String id = o.eResource().getURIFragment(o);
			if (id != null) {
				map.put(id, getRelativeURIFragmentPath(null, o, false));
			}
		}
		
		return map;
	}

	private void assertEquals(EObject expected, EObject actual) {
		try {
			String expectedSerialized = serialize(expected);
			String actualSerialized = serialize(actual);

			Assert.assertEquals("Models are different", removeUselessElementsForComparison(expectedSerialized),
					removeUselessElementsForComparison(actualSerialized));
		} catch (IOException e) {
			Assert.fail("Unable to serialize model (ModelUtils) : " + e.getMessage());
		}
	}

	private String removeUselessElementsForComparison(String msg) {
		// Remove createdOn and modifiedOn values
		String result = msg.replaceAll(" ?(created|modified)On=\"[^\"]*\"", "");
		result = result.replaceAll(" ?xmi:id=\"[^\"]*\"", "");
		result = result.replaceAll(" ?technicalid=\"[^\"]*\"", "");
		result = result.replaceAll(" ?techID=\"[^\"]*\"", "");
		return result;
	}

	protected String serialize(EObject root) throws IOException {
		if (root == null)
			return "";

		final EObject copyRoot = root;

		// Get IDs map to be able to change UUID with relative fragment
		Map<String, String> idsMap = getIdsMap(copyRoot);
		
		final StringWriter writer = new StringWriter();
		final Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_ENCODING, System.getProperty("file.encoding"));
		// Should not throw ClassCast since uri calls for an xml resource
		((XMLResource) copyRoot.eResource()).save(writer, options);
		String result = writer.toString();
		writer.flush();
		
		// Replace Ids
		for (Entry<String, String> entry : idsMap.entrySet()) {
			result = result.replaceAll(entry.getKey(), entry.getValue());
		}
		
		return result;
	}

	protected Resource attachResource(URI resourceURI, EObject root) {
		final Resource newResource = createResource(resourceURI);
		newResource.getContents().add(root);
		return newResource;
	}

	protected Resource createResource(URI modelURI) {
		return createResource(modelURI, new ResourceSetImpl());
	}

	/**
	 * This will create a {@link Resource} given the model extension it is
	 * intended for and a ResourceSet.
	 * 
	 * @param modelURI
	 *            {@link org.eclipse.emf.common.util.URI URI} where the model is
	 *            stored.
	 * @param resourceSet
	 *            The {@link ResourceSet} to load the model in.
	 * @return The {@link Resource} given the model extension it is intended
	 *         for.
	 */
	protected Resource createResource(URI modelURI, ResourceSet resourceSet) {
		String fileExtension = modelURI.fileExtension();
		if (fileExtension == null || fileExtension.length() == 0) {
			fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
		}

		// First search the resource set for our resource factory
		Resource.Factory.Registry registry = resourceSet.getResourceFactoryRegistry();
		Object resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
		if (resourceFactory == null) {
			// then the global registry
			registry = Resource.Factory.Registry.INSTANCE;
			resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
			if (resourceFactory != null) {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension, resourceFactory);
			} else {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension,
						new XMIResourceFactoryImpl());
			}
		}

		return resourceSet.createResource(modelURI);
	}
}
