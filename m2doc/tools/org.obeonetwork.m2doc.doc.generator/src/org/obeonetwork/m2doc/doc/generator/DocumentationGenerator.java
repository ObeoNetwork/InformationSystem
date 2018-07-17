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
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.sirius.diagram.DiagramPackage;
import org.eclipse.sirius.table.metamodel.table.TablePackage;
import org.eclipse.sirius.tree.TreePackage;
import org.eclipse.sirius.viewpoint.ViewpointPackage;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.obeonetwork.m2doc.doc.generator.reflection.OEcoreUtil;
import org.obeonetwork.m2doc.doc.generator.reflection.ReflectionHelper;

/**
 * Utility class used to generate the M2Doc documentation.
 * 
 * @author <a href="mailto:vincent.richard@obeo.fr">Vincent Richard</a>
 */
public class DocumentationGenerator {
	
	// Absolute path to InformationSystem git workspace
	private static String gitRepoRootPath = "/Absolute/path/to/InformationSystem/git/workspace/";

	// Cinematic configuration
	private static String outputPluginParentFolder = gitRepoRootPath + "m2doc/cinematic/plugins/";
	private static String outputPluginName = "org.obeonetwork.cinematic.m2doc.services";
	private static String metamodelName = "Cinematic";
	private static String[] serviceslJavaPackages = { "org.obeonetwork.cinematic.m2doc.services", "org.obeonetwork.requirement.m2doc.services" };
	private static String[] metamodelJavaPackages = { "org.obeonetwork.dsl.cinematic" };
	private static String[] odesignResourcePaths = { gitRepoRootPath + "designs/cinematic/plugins/org.obeonetwork.dsl.cinematic.design/description/cinematic.odesign" };
	
	// Requirement configuration
//	private static String outputPluginParentFolder = gitRepoRootPath + "m2doc/requirement/plugins/";
//	private static String outputPluginName = "org.obeonetwork.dsl.requirement.m2doc.services";
//	private static String metamodelName = "Requirement";
//	private static String[] serviceslJavaPackages = { "org.obeonetwork.requirement.m2doc.services" };
//	private static String[] metamodelJavaPackages = { "org.obeonetwork.dsl.requirement" };
//	private static String[] odesignResourcePaths = { gitRepoRootPath + "designs/requirement/plugins/org.obeonetwork.dsl.requirement.design/description/requirement.odesign" };
	
    /**
     * The charset used to write the documentation.
     */
    private static final String UTF8 = "UTF-8"; //$NON-NLS-1$
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		File pluginFolder = new File(outputPluginParentFolder + outputPluginName);
        File documentationFolder = new File(pluginFolder, "doc"); //$NON-NLS-1$
        if(!documentationFolder.exists()) {
        	documentationFolder.mkdir();
        }
        File pagesFolder = new File(documentationFolder, "pages"); //$NON-NLS-1$
        if(!pagesFolder.exists()) {
        	pagesFolder.mkdir();
        }
        
		
		List<Class<?>> serviceClasses = Arrays.asList(serviceslJavaPackages).stream()
				.map(p -> ReflectionHelper.getClasses(p)).flatMap(a -> a.stream()).collect(Collectors.toList());
		System.out.println("Found Service Classes : " + serviceClasses.size());
		
		List<Method> services = serviceClasses.stream()
				.map(s -> Arrays.asList(s.getMethods())).flatMap(a -> a.stream())
				.filter(m -> m.getParameters().length > 0 && EObject.class.isAssignableFrom(m.getParameters()[0].getType()))
				.sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).collect(Collectors.toList());
		System.out.println("Found Services : " + services.size());
		
		List<Class<?>> metaClassesImpl = Arrays.asList(metamodelJavaPackages).stream().map(p -> ReflectionHelper.getClasses(p)).flatMap(s -> s.stream())
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
		
		List<Viewpoint> viewPoints = loadViewpoints(odesignResourcePaths);
		System.out.println("Found Viewpoints : " + viewPoints.size());
		
        // toc.xml
        StringBuffer tocBuffer = computeToc(metamodelName, allMetaClasses);
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
        StringBuffer indexBuffer = html(head(false, metamodelName, outputPluginName), computeIndexBody(metamodelName, allMetaClasses, viewPoints));
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
        	StringBuffer metaClassBuffer = html(head(false, computeMetaClassName(metaClass), outputPluginName), computeMetaClassBody(metamodelName, outputPluginName, metaClass, services, externalMetaClasses.contains(metaClass)));
            File file = new File(pagesFolder, computeHtmlFileName(metaClass));
                System.out.println("Writing " + file.getAbsolutePath());
                try (PrintWriter writer = new PrintWriter(file, UTF8);) {
                    writer.print(metaClassBuffer.toString());
                }
        	
        }
        
        System.out.println("Done writing.");
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
