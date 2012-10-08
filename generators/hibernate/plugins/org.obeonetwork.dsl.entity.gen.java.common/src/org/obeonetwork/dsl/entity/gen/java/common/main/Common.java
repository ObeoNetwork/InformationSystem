/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.entity.gen.java.common.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.common.internal.utils.workspace.AcceleoWorkspaceUtil;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.acceleo.engine.generation.strategy.IAcceleoGenerationStrategy;
import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.acceleo.engine.service.AcceleoService;
import org.eclipse.acceleo.engine.service.properties.AbstractAcceleoPropertiesLoaderService;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.obeonetwork.acceleo.utils.properties.util.AcceleoPropertiesUtils;
import org.obeonetwork.acceleo.utils.properties.util.ObeoNetworkBundlePropertiesLoaderService;
import org.obeonetwork.acceleo.utils.properties.util.ObeoNetworkPropertiesLoaderService;
import org.obeonetwork.dsl.entity.gen.java.common.EntityCommonPlugin;
import org.osgi.framework.Bundle;

/**
 * Entry point of the 'Common' generation module.
 *
 * @generated
 */
public class Common extends AbstractAcceleoGenerator {
	/**
	 * The name of the module.
	 *
	 * @generated
	 */
	public static final String MODULE_FILE_NAME = "Common";
	
	/**
	 * The name of the templates that are to be generated.
	 *
	 * @generated
	 */
	public static final String[] TEMPLATE_NAMES = { "commonEntity", };

	/**
	 * Allows the public constructor to be used. Note that a generator created
	 * this way cannot be used to launch generations before one of
	 * {@link #initialize(EObject, File, List)} or
	 * {@link #initialize(URI, File, List)} is called.
	 * <p>
	 * The main reason for this constructor is to allow clients of this
	 * generation to call it from another Java file, as it allows for the
	 * retrieval of {@link #getProperties()} and
	 * {@link #getGenerationListeners()}.
	 * </p>
	 *
	 * @generated
	 */
	public Common() {
    // Empty implementation
  }

	/**
	 * This allows clients to instantiates a generator with all required information.
	 * 
	 * @param modelURI
	 *            URI where the model on which this generator will be used is located.
	 * @param targetFolder
	 *            This will be used as the output folder for this generation : it will be the base path
	 *            against which all file block URLs will be resolved.
	 * @param arguments
	 *            If the template which will be called requires more than one argument taken from the model,
	 *            pass them here.
	 * @throws IOException
	 *             This can be thrown in three scenarios : the module cannot be found, it cannot be loaded, or
	 *             the model cannot be loaded.
	 * @generated
	 */
	public Common(URI modelURI, File targetFolder,
			List<? extends Object> arguments) throws IOException {
    initialize(modelURI, targetFolder, arguments);
  }

	/**
	 * This allows clients to instantiates a generator with all required information.
	 * 
	 * @param model
	 *            We'll iterate over the content of this element to find Objects matching the first parameter
	 *            of the template we need to call.
	 * @param targetFolder
	 *            This will be used as the output folder for this generation : it will be the base path
	 *            against which all file block URLs will be resolved.
	 * @param arguments
	 *            If the template which will be called requires more than one argument taken from the model,
	 *            pass them here.
	 * @throws IOException
	 *             This can be thrown in two scenarios : the module cannot be found, or it cannot be loaded.
	 * @generated
	 */
	public Common(EObject model, File targetFolder,
			List<? extends Object> arguments) throws IOException {
    initialize(model, targetFolder, arguments);
  }
	
	/**
	 * This can be used to launch the generation from a standalone application.
	 * 
	 * @param args
	 *            Arguments of the generation.
	 * @generated
	 */
	public static void main(String[] args) {
    try {
      if (args.length < 2) {
        System.out.println("Arguments not valid : {model, folder}.");
      } else {
        URI modelURI = URI.createFileURI(args[0]);
        File folder = new File(args[1]);
        List<String> arguments = new ArrayList<String>();
        for (int i = 2; i < args.length; i++) {
          arguments.add(args[i]);
        }
        Common generator = new Common(modelURI, folder, arguments);
        generator.doGenerate(new BasicMonitor());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

	/**
	 * Launches the generation described by this instance.
	 * 
	 * @param monitor
	 *            This will be used to display progress information to the user.
	 * @throws IOException
	 *             This will be thrown if any of the output files cannot be saved to disk.
	 * @generated
	 */
	@Override
	public void doGenerate(Monitor monitor) throws IOException {
    /*
     * TODO if you wish to change the generation as a whole, override this.
     * The default behavior should be sufficient in most cases.
     */
    super.doGenerate(monitor);
  }
	
	/**
	 * If this generator needs to listen to text generation events, listeners can be returned from here.
	 * 
	 * @return List of listeners that are to be notified when text is generated through this launch.
	 * @generated
	 */
	@Override
	public List<IAcceleoTextGenerationListener> getGenerationListeners() {
    List<IAcceleoTextGenerationListener> listeners = super.getGenerationListeners();
    // TODO if you need to listen to generation event, add listeners to the list here
    return listeners;
  }
	
	/**
	 * If you need to change the way files are generated, this is your entry point.
	 * <p>
	 * The default is {@link org.eclipse.acceleo.engine.generation.strategy.DefaultStrategy}; it generates
	 * files on the fly. If you only need to preview the results, return a new
	 * {@link org.eclipse.acceleo.engine.generation.strategy.PreviewStrategy}. Both of these aren't aware of
	 * the running Eclipse and can be used standalone.
	 * </p>
	 * <p>
	 * If you need the file generation to be aware of the workspace (A typical example is when you wanna
	 * override files that are under clear case or any other VCS that could forbid the overriding), then
	 * return a new {@link org.eclipse.acceleo.engine.generation.strategy.WorkspaceAwareStrategy}.
	 * <b>Note</b>, however, that this <b>cannot</b> be used standalone.
	 * </p>
	 * <p>
	 * All three of these default strategies support merging through JMerge.
	 * </p>
	 * 
	 * @return The generation strategy that is to be used for generations launched through this launcher.
	 * @generated
	 */
	public IAcceleoGenerationStrategy getGenerationStrategy() {
    return super.getGenerationStrategy();
  }
	
	/**
	 * This will be called in order to find and load the module that will be launched through this launcher.
	 * We expect this name not to contain file extension, and the module to be located beside the launcher.
	 * 
	 * @return The name of the module that is to be launched.
	 * @generated
	 */
	@Override
	public String getModuleName() {
    return MODULE_FILE_NAME;
  }
	
	/**
	 * If the module(s) called by this launcher require properties files, return their qualified path from
	 * here.Take note that the first added properties files will take precedence over subsequent ones if they
	 * contain conflicting keys.
	 * <p>
	 * Properties need to be in source folders, the path that we expect to get as a result of this call are of
	 * the form &lt;package>.&lt;properties file name without extension>. For example, if you have a file
	 * named "messages.properties" in package "org.eclipse.acceleo.sample", the path that needs be returned by
	 * a call to {@link #getProperties()} is "org.eclipse.acceleo.sample.messages".
	 * </p>
	 * 
	 * @return The list of properties file we need to add to the generation context.
	 * @see java.util.ResourceBundle#getBundle(String)
	 * @generated NOT
	 */
	@Override
	public List<String> getProperties() {
    List<String> propertiesFiles = super.getProperties();
    
	if (this.model != null && this.model.eResource() != null) {
		propertiesFiles.addAll(AcceleoPropertiesUtils.getPropertiesFilesNearModel(this.model.eResource()));
	}
	
    propertiesFiles.add(EntityCommonPlugin.ORG_OBEONETWORK_DSL_ENTITY_GEN_JAVA_COMMON_DEFAULT_PROPERTIES);
    propertiesFiles.add(EntityCommonPlugin.ORG_OBEONETWORK_DSL_ENTITY_GEN_JAVA_COMMON_DEFAULT_JAVA_FILES_PROPERTIES);
	
    return propertiesFiles;
  }
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator#getPropertiesLoaderService(org.eclipse.acceleo.engine.service.AcceleoService)
	 * @generated NOT
	 */
	@Override
	public AbstractAcceleoPropertiesLoaderService getPropertiesLoaderService(
			AcceleoService acceleoService) {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			Bundle bundle = AcceleoWorkspaceUtil.getBundle(getClass());
			return new ObeoNetworkBundlePropertiesLoaderService(acceleoService, bundle);
		}
		return new ObeoNetworkPropertiesLoaderService(acceleoService);
	}
	
	/**
	 * This will be used to get the list of templates that are to be launched by this launcher.
	 * 
	 * @return The list of templates to call on the module {@link #getModuleName()}.
	 * @generated
	 */
	@Override
	public String[] getTemplateNames() {
    return TEMPLATE_NAMES;
  }
	
	/**
	 * This can be used to update the resource set's package registry with all needed EPackages.
	 * 
	 * @param resourceSet
	 *            The resource set which registry has to be updated.
	 * @generated
	 */
	@Override
	public void registerPackages(ResourceSet resourceSet) {
    super.registerPackages(resourceSet);
    resourceSet.getPackageRegistry().put(org.obeonetwork.dsl.entity.EntityPackage.eINSTANCE.getNsURI(), org.obeonetwork.dsl.entity.EntityPackage.eINSTANCE);
    resourceSet.getPackageRegistry().put(org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage.eINSTANCE.getNsURI(), org.obeonetwork.dsl.entity.extensionUtilities.ExtensionUtilitiesPackage.eINSTANCE);
    // TODO If you need additional package registrations, do them here. The following line is an example for UML.
    // resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
  }

	/**
	 * This can be used to update the resource set's resource factory registry with all needed factories.
	 * 
	 * @param resourceSet
	 *            The resource set which registry has to be updated.
	 * @generated
	 */
	@Override
	public void registerResourceFactories(ResourceSet resourceSet) {
    super.registerResourceFactories(resourceSet);
    // TODO If you need additional resource factories registrations, do them here. The following line is an example for UML.
    // resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
  }
	
}
