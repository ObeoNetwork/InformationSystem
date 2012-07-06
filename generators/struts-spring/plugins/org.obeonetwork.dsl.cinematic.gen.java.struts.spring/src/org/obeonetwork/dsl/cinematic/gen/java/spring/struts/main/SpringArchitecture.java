package org.obeonetwork.dsl.cinematic.gen.java.spring.struts.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.obeonetwork.acceleo.utils.properties.util.AcceleoPropertiesUtils;
import org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.CinematicArchitecturePlugin;
import org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.main.StrutsArchitecture;

public class SpringArchitecture extends StrutsArchitecture {

	public SpringArchitecture(URI modelURI, File folder, ArrayList<String> arguments) throws IOException {
		super(modelURI, folder, arguments);
	}
	
	public SpringArchitecture(EObject model, File targetFolder, List<? extends Object> arguments) throws IOException {
		super(model, targetFolder, arguments);
	}

	@Override
	public List<String> getProperties() {
		String strutsPropertiesFile = AcceleoPropertiesUtils.PLATFORM_PLUGIN + CinematicArchitecturePlugin.PLUGIN_ID + CinematicArchitecturePlugin.STRUTS_PROPERTIES;
    	propertiesFiles.add(strutsPropertiesFile);
    	return propertiesFiles;
	}
	
}
