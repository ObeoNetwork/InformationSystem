package org.obeonetwork.dsl.soa.gen.swagger.tests;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.soa.Component;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter;
import org.obeonetwork.dsl.soa.gen.swagger.SwaggerExporter.MapperType;
import org.obeonetwork.dsl.soa.util.SoaResourceFactoryImpl;
import org.yaml.snakeyaml.Yaml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SwaggerGenerationTest {
	
	private static final String PLUGIN_ID = "org.obeonetwork.dsl.soa.gen.swagger.tests";
	private static final String INPUT_FOLDER_PATH_FORMAT = "/data/generation/%s/input";
	private static final String EXPECTED_FOLDER_PATH_FORMAT = "/data/generation/%s/expected-%s";
	private static final String OUTPUT_FOLDER_NAME_FORMAT = PLUGIN_ID + "-generation-%s-output-%s";
	
	private File createTemporaryOutputFolder(String outputFolderName) {
		File outputFolder = null;
		try {
			Path outputFolderPath = Files.createTempDirectory(outputFolderName);
			outputFolder = outputFolderPath.toFile();
			outputFolder.deleteOnExit();
		} catch (IOException e) {
			// Fail case
		}
		
		if (outputFolder == null) {
			fail("Unable to create temporary output folder.");
		}
		
		return outputFolder;
	}
	
	private String readFile(File file) {
		String content = null;
		try {
			content = Files.readAllLines(file.toPath()).stream().collect(joining("\n"));
		} catch (IOException e) {
			fail("Error reading file : " + file.getAbsolutePath());
		}
		
		return content;
	}

	private void assertFolderEquals(File targetfolder, File expectedFolder) {
		
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
			fail("Some files have not been generated : " + missingFileNames.stream().collect(joining(", ")));
		}
		
		// Assert no unexpected files are generated
		if (!unexpectedFileNames.isEmpty()) {
			fail("Some unexpected files have been generated : " + unexpectedFileNames.stream().collect(joining(", ")));
		}
		
		// Assert each generated file is conform to the expected one
		for(String fileName : expectedFileNames) {
			File expectedFile = new File(expectedFolder, fileName);
			File generatedFile = new File(targetfolder, fileName);
			
			assertFileContentEquals("Generated content is different for file " + expectedFile.getName(), expectedFile, generatedFile);
		}
		
	}
	
	void assertFileContentEquals(String message, File expectedFile, File actualFile) {
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
	
	private File createTempFolderFromBundleEntryPath(String bundleEntryPath) {
		File tempFolder = null;
		try {
			Path targetPath = Files.createTempDirectory(PLUGIN_ID + "-" + bundleEntryPath.replaceAll("/", "-"));
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
					 fail("Unable to copy expected file into temp folder : " + e.getMessage());
				}
			}
		}
		
		return tempFolder;
	}
	
	private ResourceSet createResourceSetFromBundleEntryPath(String bundleEntryPath) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new SoaResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(SoaPackage.eNS_URI, SoaPackage.eINSTANCE);
		resourceSet.getPackageRegistry().put(EnvironmentPackage.eNS_URI, EnvironmentPackage.eINSTANCE);
		
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
	
	private void testExportInDir(String generationTestId, MapperType outputFormat) {
		String inputFolderPath = String.format(INPUT_FOLDER_PATH_FORMAT, generationTestId);
		ResourceSet resourceSet = createResourceSetFromBundleEntryPath(inputFolderPath);
		
		Component component = resourceSet.getResources().stream()
		.flatMap(resource -> resource.getContents().stream())
		.filter(root -> root instanceof org.obeonetwork.dsl.soa.System)
		.map(root -> (org.obeonetwork.dsl.soa.System)root)
		.flatMap(system -> system.getOwnedComponents().stream())
		.findFirst().orElse(null);
		
		String expectedBundleEntryFolderPath = String.format(EXPECTED_FOLDER_PATH_FORMAT, generationTestId, outputFormat.toString().toLowerCase());
		File expectedFolder = createTempFolderFromBundleEntryPath(expectedBundleEntryFolderPath);
		
		File outputFolder = createTemporaryOutputFolder(String.format(OUTPUT_FOLDER_NAME_FORMAT, generationTestId, outputFormat.toString().toLowerCase()));
		
		SwaggerExporter swaggerExporter = new SwaggerExporter(component);
		swaggerExporter.setOutputFormat(outputFormat);
		swaggerExporter.exportInDir(outputFolder);
		
		assertFolderEquals(outputFolder, expectedFolder); 
	}
	
	@Test
	public void testJsonExportInFileOdtsAdminWs() {
		// TODO
	}
	
	@Test
	public void testYamlExportInFileOdtsAdminWs() {
		// TODO
	}
	
	@Test
	public void testGetOutputFileName1() {
		// TODO
	}
	
	@Test
	public void testGetOutputFileName2() {
		// TODO
	}
	
	@Test
	public void testJsonExportInDirPetstore() {
		testExportInDir("petstore", MapperType.JSON);
	}

	@Test
	public void testYamlExportInDirPetstore() {
		testExportInDir("petstore", MapperType.YAML);
	}
	
	@Test
	public void testJsonExportInDirThetvdb() {
		testExportInDir("thetvdb", MapperType.JSON);
	}

	@Test
	public void testYamlExportInDirThetvdb() {
		testExportInDir("thetvdb", MapperType.YAML);
	}
	
	@Test
	public void testJsonExportInDirOdtsAdminWs() {
		testExportInDir("odts-admin-ws", MapperType.JSON);
	}

	@Test
	public void testYamlExportInDirOdtsAdminWs() {
		testExportInDir("odts-admin-ws", MapperType.YAML);
	}
	
}
