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
package org.obeonetwork.m2doc.doc.generator;

import static org.obeonetwork.m2doc.doc.generator.M2DocHelpContentUtils.computeHtmlFileName;
import static org.obeonetwork.m2doc.doc.generator.M2DocHelpContentUtils.computeIndexBody;
import static org.obeonetwork.m2doc.doc.generator.M2DocHelpContentUtils.computeMetaClassBody;
import static org.obeonetwork.m2doc.doc.generator.M2DocHelpContentUtils.computeMetaClassName;
import static org.obeonetwork.m2doc.doc.generator.M2DocHelpContentUtils.computeToc;
import static org.obeonetwork.m2doc.doc.generator.M2DocHelpContentUtils.head;
import static org.obeonetwork.m2doc.doc.generator.M2DocHelpContentUtils.html;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.sirius.diagram.DiagramPackage;
import org.eclipse.sirius.properties.PropertiesPackage;
import org.eclipse.sirius.properties.ext.widgets.reference.propertiesextwidgetsreference.PropertiesExtWidgetsReferencePackage;
import org.eclipse.sirius.table.metamodel.table.TablePackage;
import org.eclipse.sirius.tree.TreePackage;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.obeonetwork.dsl.database.DatabasePackage;
import org.obeonetwork.dsl.entity.EntityPackage;
import org.obeonetwork.dsl.environment.EnvironmentPackage;
import org.obeonetwork.dsl.requirement.RequirementPackage;
import org.obeonetwork.dsl.soa.SoaPackage;
import org.obeonetwork.graal.GraalPackage;
import org.obeonetwork.m2doc.doc.generator.reflection.OEcoreUtil;
import org.obeonetwork.m2doc.doc.generator.reflection.ReflectionHelper;

/**
 * Utility class used to generate the M2Doc documentation.
 * 
 * @author <a href="mailto:vincent.richard@obeo.fr">Vincent Richard</a>
 */
public class DocumentationGenerator {
	
	private static class Configuration {
		
		private String outputPluginParentFolder;
		private String outputPluginName;
		private String metamodelName;
		private String[] serviceslJavaPackages;
		private String[] metamodelJavaPackages;
		private String[] odesignResourcePaths;

		private Configuration(String outputPluginParentFolder, String outputPluginName, String metamodelName, String[] serviceslJavaPackages, String[] metamodelJavaPackages, String[] odesignResourcePaths) {
			this.outputPluginParentFolder = outputPluginParentFolder ;
			this. outputPluginName = outputPluginName;
			this.metamodelName = metamodelName;
			this.serviceslJavaPackages = serviceslJavaPackages ;
			this. metamodelJavaPackages = metamodelJavaPackages;
			this.odesignResourcePaths = odesignResourcePaths;
		}
	}
	
	// Absolute path to InformationSystem git working copy
	private static String gitRepoRootPath = "/home/obeo/git/InformationSystem/";

	private static List<Configuration> initializeConfigurations() {
		final List<Configuration> res = new ArrayList<>();
		
		res.add(new Configuration(gitRepoRootPath + "m2doc/cinematic/plugins/",   "org.obeonetwork.cinematic.m2doc.services",       "Cinematic",   new String[] { "org.obeonetwork.cinematic.m2doc.services" },       new String[] { "org.obeonetwork.dsl.cinematic" },   new String[] { gitRepoRootPath + "designs/cinematic/plugins/org.obeonetwork.dsl.cinematic.design/description/cinematic.odesign" }));
		res.add(new Configuration(gitRepoRootPath + "m2doc/requirement/plugins/", "org.obeonetwork.dsl.requirement.m2doc.services", "Requirement", new String[] { "org.obeonetwork.requirement.m2doc.services" },     new String[] { "org.obeonetwork.dsl.requirement" }, new String[] { gitRepoRootPath + "designs/requirement/plugins/org.obeonetwork.dsl.requirement.design/description/requirement.odesign" }));
		res.add(new Configuration(gitRepoRootPath + "m2doc/entity/plugins/",      "org.obeonetwork.dsl.entity.m2doc.services",      "Entity",      new String[] { "org.obeonetwork.dsl.entity.m2doc.services" },      new String[] { "org.obeonetwork.dsl.entity" },      new String[] { gitRepoRootPath + "designs/entity/plugins/org.obeonetwork.dsl.entity.design/description/entity.odesign", gitRepoRootPath + "addons/structuredtypes/plugins/fr.gouv.mindef.safran.is.design/description/safran-is.odesign" }));
		res.add(new Configuration(gitRepoRootPath + "m2doc/soa/plugins/",         "org.obeonetwork.dsl.soa.m2doc.services",         "SOA",         new String[] { "org.obeonetwork.dsl.soa.m2doc.services" },         new String[] { "org.obeonetwork.dsl.soa" },         new String[] { gitRepoRootPath + "designs/soa/plugins/org.obeonetwork.dsl.soa.design/description/soa.odesign", gitRepoRootPath + "addons/structuredtypes/plugins/fr.gouv.mindef.safran.is.design/description/safran-is.odesign" }));
		res.add(new Configuration(gitRepoRootPath + "m2doc/graal/plugins/",       "org.obeonetwork.dsl.graal.m2doc.services",       "Graal",       new String[] { "org.obeonetwork.dsl.graal.m2doc.services" },       new String[] { "org.obeonetwork.graal" },           new String[] { gitRepoRootPath + "designs/graal/plugins/org.obeonetwork.graal.design/description/graal.odesign", gitRepoRootPath + "designs/graal/plugins/org.obeonetwork.graal.design/description/requirements.odesign", gitRepoRootPath + "addons/structuredtypes/plugins/fr.gouv.mindef.safran.is.design/description/safran-is.odesign"}));
		res.add(new Configuration(gitRepoRootPath + "m2doc/environment/plugins/", "org.obeonetwork.dsl.environment.m2doc.services", "Environment", new String[] { "org.obeonetwork.dsl.environment.m2doc.services" }, new String[] { "org.obeonetwork.dsl.environment" }, new String[] { gitRepoRootPath + "designs/environment/plugins/org.obeonetwork.dsl.environment.design/description/environment.odesign" }));
		res.add(new Configuration(gitRepoRootPath + "m2doc/database/plugins/",    "org.obeonetwork.database.m2doc.services",        "Database",    new String[] { "org.obeonetwork.database.m2doc.services" },        new String[] { "org.obeonetwork.dsl.database" },    new String[] { gitRepoRootPath + "designs/database/plugins/org.obeonetwork.dsl.database.design/description/database.odesign" }));
		
		return res;
	}
	
    /**
     * The charset used to write the documentation.
     */
    private static final String UTF8 = "UTF-8"; //$NON-NLS-1$
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		PropertiesPackage.eINSTANCE.getName();
		PropertiesExtWidgetsReferencePackage.eINSTANCE.getName();
		EnvironmentPackage.eINSTANCE.getName();
		EntityPackage.eINSTANCE.getName();
		SoaPackage.eINSTANCE.getName();
		RequirementPackage.eINSTANCE.getName();
		GraalPackage.eINSTANCE.getName();
		DatabasePackage.eINSTANCE.getName();
		AstPackage.eINSTANCE.getName();
		
		final List<Configuration> configurations = initializeConfigurations();
		
		final List<Class<?>> allServiceClasses = new ArrayList<>();

		for (Configuration configuration : configurations) {
			allServiceClasses.addAll(Arrays.asList(configuration.serviceslJavaPackages).stream().map(p -> ReflectionHelper.getClasses(p))
					.flatMap(a -> a.stream()).filter(c -> isServiceClass(c)).collect(Collectors.toList()));
		}
		System.out.println("Found Total Service Classes : " + allServiceClasses.size());

		List<Method> allServices = allServiceClasses.stream().map(s -> Arrays.asList(s.getMethods()))
				.flatMap(a -> a.stream()).filter(m -> isService(m))
				.sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).collect(Collectors.toList());
		System.out.println("Found Total Services : " + allServices.size());
		
		final Map<EClass, String> eClassToHTMLPages = initEClassToHTMLPage(configurations);
		
		for (Configuration configuration : configurations) {
			System.out.println("\n*** " + configuration.metamodelName + " ***");
			File pluginFolder = new File(configuration.outputPluginParentFolder + configuration.outputPluginName);
			File documentationFolder = new File(pluginFolder, "doc"); //$NON-NLS-1$
			File pagesFolder = new File(documentationFolder, "pages"); //$NON-NLS-1$
			if(!documentationFolder.exists()) {
				documentationFolder.mkdir();
			}
			if(!pagesFolder.exists()) {
				pagesFolder.mkdir();
			}


			List<Class<?>> serviceClasses = Arrays.asList(configuration.serviceslJavaPackages).stream()
					.map(p -> ReflectionHelper.getClasses(p)).flatMap(a -> a.stream()).filter(c -> !c.getSimpleName().isEmpty()).collect(Collectors.toList());
			System.out.println("Found Service Classes : " + serviceClasses.size());

			List<Method> services = serviceClasses.stream().map(s -> Arrays.asList(s.getMethods()))
					.flatMap(a -> a.stream()).filter(m -> isService(m))
					.sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).collect(Collectors.toList());
			System.out.println("Found Services : " + services.size());

			List<Class<?>> metaClassesImpl = Arrays.asList(configuration.metamodelJavaPackages).stream().map(p -> ReflectionHelper.getClasses(p)).flatMap(s -> s.stream())
					.filter(c -> !c.isAnonymousClass() && !c.isMemberClass() && !c.isInterface() && !Modifier.isAbstract(c.getModifiers()) && OEcoreUtil.getEClass(getMetaInterface(c)) != null)
					.sorted((c1, c2) -> c1.getSimpleName().compareTo(c2.getSimpleName())).collect(Collectors.toList());

			List<Class<?>> metaClasses = new ArrayList<>();
			for(Class<?> metaClassImpl : metaClassesImpl) {
				metaClasses.add(getMetaInterface(metaClassImpl));
			}
			System.out.println("Found Meta Classes : " + metaClasses.size());

			List<Class<?>> externalMetaClasses = new ArrayList<>();
			for(Method service : services) {
				if(service.getParameterCount() > 0) {
					Class<?> externalMetaClass = service.getParameters()[0].getType();
					if(EObject.class.isAssignableFrom(externalMetaClass) 
							&& !metaClasses.contains(externalMetaClass) 
							&& !externalMetaClasses.contains(externalMetaClass)) {
						externalMetaClasses.add(externalMetaClass);
					}
				}
			}
			System.out.println("Found External Meta Classes : " + externalMetaClasses.size());

			List<Class<?>> allMetaClasses = new ArrayList<>();
			allMetaClasses.addAll(metaClasses);
			allMetaClasses.addAll(externalMetaClasses);
			allMetaClasses.sort((c1, c2) -> c1.getSimpleName().compareTo(c2.getSimpleName()));

			List<Viewpoint> viewPoints = loadViewpoints(configuration.odesignResourcePaths);
			System.out.println("Found Viewpoints : " + viewPoints.size());

			// toc.xml
			StringBuffer tocBuffer = computeToc(configuration.metamodelName, allMetaClasses);
			try {
				File tocFile = new File(documentationFolder, "toc.xml");
				System.out.println("Writing " + tocFile.getAbsolutePath());
				try (PrintWriter writer = new PrintWriter(tocFile, UTF8);) {
					writer.print(tocBuffer.toString());
				}
			} catch (IOException exception) {
				exception.printStackTrace();
			}

			// index.html
			StringBuffer indexBuffer = html(head(false, configuration.metamodelName, configuration.outputPluginName), computeIndexBody(configuration.metamodelName, allMetaClasses, viewPoints));
			try {
				File indexFile = new File(pagesFolder, "index.html");
				System.out.println("Writing " + indexFile.getAbsolutePath());
				try (PrintWriter writer = new PrintWriter(indexFile, UTF8);) {
					writer.print(indexBuffer.toString());
				}
			} catch (IOException exception) {
				exception.printStackTrace();
			}

			// Metaclasses
			for(Class<?> metaClass : allMetaClasses) {
				StringBuffer metaClassBuffer = html(head(false, computeMetaClassName(metaClass), configuration.outputPluginName), computeMetaClassBody(configuration.metamodelName, configuration.outputPluginName, eClassToHTMLPages, metaClass, allServices, externalMetaClasses.contains(metaClass)));
				File file = new File(pagesFolder, computeHtmlFileName(metaClass));
				System.out.println("Writing " + file.getAbsolutePath());
				try (PrintWriter writer = new PrintWriter(file, UTF8);) {
					writer.print(metaClassBuffer.toString());
				}
			}	
		}
        
        System.out.println("Done writing.");
	}

	private static Map<EClass, String> initEClassToHTMLPage(List<Configuration> configurations) {
		final Map<EClass, String> res = new HashMap<>();
		
		for (Configuration configuration : configurations) {
			List<Class<?>> metaClassesImpl = Arrays.asList(configuration.metamodelJavaPackages).stream()
					.map(p -> ReflectionHelper.getClasses(p)).flatMap(s -> s.stream())
					.filter(c -> !c.isAnonymousClass() && !c.isMemberClass() && !c.isInterface()
							&& !Modifier.isAbstract(c.getModifiers())
							&& OEcoreUtil.getEClass(getMetaInterface(c)) != null)
					.sorted((c1, c2) -> c1.getSimpleName().compareTo(c2.getSimpleName())).collect(Collectors.toList());

			
			for (Class<?> metaClassImpl : metaClassesImpl) {
				final Class<?> cls = getMetaInterface(metaClassImpl);
				res.put(OEcoreUtil.getEClass(cls), "/help/topic/" + configuration.outputPluginName +"/doc/pages/" +computeHtmlFileName(cls));
			}
		}
		
		return res;
	}

	private static boolean isServiceClass(Class<?> cls) {
		return !cls.getSimpleName().isEmpty() && !cls.isMemberClass();
	}

	private static boolean isService(Method method) {
		return method.getParameters().length > 0 && EObject.class.isAssignableFrom(method.getParameters()[0].getType());
	}

	private static Class<?> getMetaInterface(Class<?> metaClassImpl) {
		if(!Modifier.isInterface(metaClassImpl.getModifiers())) {
			String typeName = metaClassImpl.getSimpleName();
			if(typeName.endsWith("Impl")) {
				typeName = typeName.substring(0, typeName.length() - 4);
			}
			for(int i = 0; i < metaClassImpl.getGenericInterfaces().length; i++) {
				Type intfType = metaClassImpl.getGenericInterfaces()[i];
				if(intfType instanceof Class) {
					Class<?> intf = (Class<?>) intfType;
					if(typeName.equals(intf.getSimpleName())) {
						return intf;
					}
				}
				
			}
		}
		
		return metaClassImpl;
	}

	private static List<Viewpoint> loadViewpoints(String[] odesignResourcePaths) {
		List<Viewpoint> viewPoints = new ArrayList<>();
		ViewpointPackage.eINSTANCE.eClass();
		TablePackage.eINSTANCE.eClass();
		TreePackage.eINSTANCE.eClass();
		DiagramPackage.eINSTANCE.eClass();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("odesign", new XMIResourceFactoryImpl());
		ResourceSet resSet = new ResourceSetImpl();
		for(String odesignResourcePath : odesignResourcePaths) {
			File odesignFile = new File(odesignResourcePath);
			URI uri = URI.createFileURI(odesignFile.getAbsolutePath());
			Resource resource = resSet.getResource(uri, true);
			Group group = (Group) resource.getContents().get(0);
			viewPoints.addAll(group.getOwnedViewpoints());
		}
		for(Viewpoint vp : viewPoints) {
			System.out.println(vp.getName());
		}
		return viewPoints;
	}

	
}
