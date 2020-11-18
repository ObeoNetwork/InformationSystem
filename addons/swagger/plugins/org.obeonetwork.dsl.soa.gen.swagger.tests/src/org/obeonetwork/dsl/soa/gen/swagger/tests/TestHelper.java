/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.soa.gen.swagger.tests;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.obeonetwork.dsl.soa.gen.swagger.utils.StreamUtils.asStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl;
import org.obeonetwork.dsl.environment.Environment;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.SoaFactory;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.System;
import org.obeonetwork.dsl.soa.util.SoaResourceFactoryImpl;
import org.obeonetwork.dsl.technicalid.TechnicalIDPackage;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestHelper {
	
	private static final String PLUGIN_ID = "org.obeonetwork.dsl.soa.gen.swagger.tests";
	private static final String ENVIRONMENT_MODEL_URI = "platform:/plugin/org.obeonetwork.dsl.environment.common/model/obeo.environment";
	
	public static File createTempFolderFromBundleEntryPath(String bundleEntryPath) {
		File tempFolder = null;
		try {
			Path targetPath = Files.createTempDirectory(PLUGIN_ID + bundleEntryPath.replaceAll("/", "-"));
			tempFolder = targetPath.toFile();
			tempFolder.deleteOnExit();
		} catch (IOException e) {
		}
		
		if (tempFolder == null) {
			fail("Unable to create temporary folder.");
		}
		
		Enumeration<URL> entries = Platform.getBundle(PLUGIN_ID).findEntries(bundleEntryPath, "*", false);
		if(entries != null) {
			while (entries.hasMoreElements()) {
				URL entry = entries.nextElement();
				try {
					// Copy file into temp folder
					File file = new File(FileLocator.resolve(entry).getFile());
					Files.copy(file.toPath(), new File(tempFolder, file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					 fail("Unable to copy bundled file into temporary folder : " + e.getMessage());
				}
			}
		}
		
		return tempFolder;
	}
	
	public static File findFirstFile(File folder) {
		return folder.listFiles()[0];
	}

	public static Environment loadEnvironment(ResourceSet resourceSet) {
		Resource resource = resourceSet.getResource(URI.createURI(ENVIRONMENT_MODEL_URI), true);
		
		return resource.getContents().stream()
				.filter(Environment.class::isInstance)
				.map(Environment.class::cast)
				.findFirst().orElse(null);
	}

	public static System createSystem(ResourceSet resourceSet) {
 		Resource resource = resourceSet.createResource(URI.createURI("in-memory.soa"));
		System system = SoaFactory.eINSTANCE.createSystem();
		system.setName("in-memory system");
		resource.getContents().add(system);
		
		return system;
	}

	public static ResourceSet createSoaResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new SoaResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(SoaPackage.eNS_URI, SoaPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(EnvironmentPackage.eNS_URI, EnvironmentPackage.eINSTANCE);
		
		return resourceSet;
	}
	
	public static ResourceSet createSoaResourceSetFromBundleEntryPath(String bundleEntryPath) {
		ResourceSet resourceSet = createSoaResourceSet();
		
		Enumeration<URL> entries = Platform.getBundle(PLUGIN_ID).findEntries(bundleEntryPath, "*", false);
		if(entries != null) {
			while (entries.hasMoreElements()) {
				URL entry = entries.nextElement();
				String fileName = Paths.get(entry.getPath()).getFileName().toString();
				URI uri = URI.createPlatformPluginURI(PLUGIN_ID + bundleEntryPath + "/" + fileName, true);
				resourceSet.getResource(uri, true);
			}
		}
		
		return resourceSet;
	}
	
	public static Component findFirstComponent(ResourceSet resourceSet) {
		return resourceSet.getResources().stream()
		.flatMap(resource -> resource.getContents().stream())
		.filter(root -> root instanceof org.obeonetwork.dsl.soa.System)
		.map(root -> (org.obeonetwork.dsl.soa.System)root)
		.flatMap(system -> system.getOwnedComponents().stream())
		.findFirst().orElse(null);
	}
	
	public static File createTemporaryOutputFolder(String tempFolderName) {
		File tempFolder = null;
		try {
			Path tempFolderPath = Files.createTempDirectory(PLUGIN_ID + "-" + tempFolderName);
			tempFolder = tempFolderPath.toFile();
			tempFolder.deleteOnExit();
		} catch (IOException e) {
			// Fail case
		}
		
		if (tempFolder == null) {
			fail("Unable to create temporary folder.");
		}
		
		return tempFolder;
	}
	
	private static String readFile(File file) {
		String content = null;
		try {
			content = Files.readAllLines(file.toPath()).stream().collect(joining("\n"));
		} catch (IOException e) {
			fail("Error reading file : " + file.getAbsolutePath());
		}
		
		return content;
	}

	public static void assertFolderEquals(String message, File targetfolder, File expectedFolder) {
		
		List<String> generatedFileNames = 
				Arrays.asList(targetfolder.listFiles()).stream()
				.map(file -> file.getName()).collect(toList());
		
		List<String> expectedFileNames = 
				Arrays.asList(expectedFolder.listFiles()).stream()
				.map(file -> file.getName()).collect(toList());
		
		List<String> missingFileNames = 
				expectedFileNames.stream()
				.filter(expectedFileName -> !generatedFileNames.contains(expectedFileName))
				.collect(toList());
		
		List<String> unexpectedFileNames = 
				generatedFileNames.stream()
				.filter(generatedFileName -> !expectedFileNames.contains(generatedFileName))
				.collect(toList());
		
		// Assert all files are generated
		if (!missingFileNames.isEmpty()) {
			fail(message + " Files are missing : " + missingFileNames.stream().collect(joining(", ")));
		}
		
		// Assert no unexpected files are generated
		if (!unexpectedFileNames.isEmpty()) {
			fail(message + "Unexpected files : " + unexpectedFileNames.stream().collect(joining(", ")));
		}
		
		// Assert each generated file is conform to the expected one
		for(String fileName : expectedFileNames) {
			File expectedFile = new File(expectedFolder, fileName);
			File generatedFile = new File(targetfolder, fileName);
			
			assertFileContentEquals("File content differs : " + expectedFile.getName(), expectedFile, generatedFile);
		}
		
	}
	
	public static void assertFileContentEquals(String message, File expectedFile, File actualFile) {
		if(expectedFile.getName().endsWith(".json")) {
			JsonNode expectedJsonTree = null;
			JsonNode actualJsonTree = null;
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				expectedJsonTree = objectMapper.readTree(expectedFile);
				actualJsonTree = objectMapper.readTree(actualFile);
			} catch (IOException e) {
				// Fail case
			}
			
			if(expectedJsonTree == null || actualJsonTree == null) {
				fail("Unable to read json from file " + expectedFile.getName());
			}
			
			assertTrue(message, expectedJsonTree.equals(actualJsonTree));
		} else if(expectedFile.getName().endsWith(".yaml")) {
			Object expectedYaml = null;
			Object actualYaml = null;
			try {
				Yaml yamlMapper = new Yaml();
				expectedYaml = yamlMapper.load(new FileInputStream(expectedFile));
				actualYaml = yamlMapper.load(new FileInputStream(actualFile));
			} catch (FileNotFoundException e) {
				// Fail case
			}
			
			if(expectedYaml == null || actualYaml == null) {
				fail("Unable to read yaml from file " + expectedFile.getName());
			}
			
			assertTrue(message, expectedYaml.equals(actualYaml));
		} else {
			String expectedContent = readFile(expectedFile);
			String actualContent = readFile(actualFile);
			
			assertEquals(message, expectedContent, actualContent);
		}
		
	}
	
	private static final List<EStructuralFeature> IGNORED_FEATURES = new ArrayList<>();
	static {
		IGNORED_FEATURES.add(TechnicalIDPackage.eINSTANCE.getIdentifiable_Technicalid());
		IGNORED_FEATURES.add(EnvironmentPackage.eINSTANCE.getObeoDSMObject_CreatedOn());
		IGNORED_FEATURES.add(EnvironmentPackage.eINSTANCE.getObeoDSMObject_ModifiedOn());
	}
	
	private static class XMIResourceTestImpl extends XMIResourceImpl {
		
		@Override
        protected XMLHelper createXMLHelper() {
            return new XMLHelperImpl() {
            	
                @Override
                public Object getValue(EObject obj, EStructuralFeature f) {
                    if(IGNORED_FEATURES.contains(f)) {
                        return null;
                    }
                    
                    Object value = super.getValue(obj, f);
                    
                    return value;
                }
                
                @Override
                public String getHREF(EObject obj) {
                	StringBuffer href = new StringBuffer();
                	
                	EObject ancestor = obj;
                	while(ancestor != null) {
                    	EStructuralFeature nameFeature = ancestor.eClass().getEStructuralFeature("name");
                    	if(nameFeature != null) {
                        	href.insert(0, "[" + ancestor.eGet(nameFeature).toString() + "]");
                    	}
                    	
                		if(ancestor.eContainingFeature() != null) {
                			href.insert(0, ancestor.eContainingFeature().getName());
                    		href.insert(0, ".");
                		}
                		
                		ancestor = ancestor.eContainer();
                	}
                	
                	return href.toString();
                }
                
            };
        }

	}
	
	public static void assertECoreEquals(String message, EObject expectedEObject, EObject actualEObject) {
		
		String actual = null;
		String expected = null;
        try {
    		XMIResourceTestImpl actualResource = new XMIResourceTestImpl();
            actualResource.getContents().add(sortAllELists(EcoreUtil.copy(actualEObject)));
            StringWriter actualWriter = new StringWriter();
            actualResource.save(actualWriter, Collections.emptyMap());
            actual = actualWriter.toString();
            
    		XMIResourceTestImpl expectedResource = new XMIResourceTestImpl();
    		expectedResource.getContents().add(sortAllELists(EcoreUtil.copy(expectedEObject)));
            StringWriter expectedWriter = new StringWriter();
			expectedResource.save(expectedWriter, Collections.emptyMap());
			expected = expectedWriter.toString();
		} catch (IOException e) {
			// Fail case
		}
        
        if(actual == null || expected == null) {
			fail(String.format("Unable to serialize %s.", expectedEObject.eClass().getName()));
        }

		assertEquals(message, expected, actual);
	}

	private static EObject sortAllELists(EObject eObject) {
		
		List<EList<?>> eListValues = asStream(eObject.eAllContents())
		.flatMap(e -> e.eClass().getEAllStructuralFeatures().stream()
				.filter(feature -> feature.isMany())
				.filter(feature -> feature.isChangeable())
				.filter(feature -> !feature.isDerived())
				.map(f -> e.eGet(f)))
		.filter(EList.class::isInstance).map(EList.class::cast)
		.collect(toList());
		
		eListValues.forEach(eList -> ECollections.sort(eList, (a, b) -> getSortKey(a).compareTo(getSortKey(b))));
		
		return eObject;
	}
	
	private static String getSortKey(Object object) {
		String sortKey = null;
		if(object instanceof EObject) {
			EObject eObject = (EObject) object;
        	EStructuralFeature nameFeature = eObject.eClass().getEStructuralFeature("name");
        	if(nameFeature != null) {
        		sortKey = eObject.eGet(nameFeature).toString();
        	} else {
            	sortKey = Integer.toString(eObject.toString().length());
        	}
		} else {
        	sortKey = object.toString();
		}
    	return sortKey;
	}
	
}
