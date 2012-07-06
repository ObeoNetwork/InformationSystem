package org.obeonetwork.dsl.cinematic.ui.launchers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.acceleo.engine.utils.AcceleoLaunchingUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.acceleo.utils.launch.NetworkGenerationLauncher;
import org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.main.StrutsArchitecture;


public class ArchitectureLauncher extends NetworkGenerationLauncher {

	private AbstractAcceleoGenerator launcher;

	@Override
	protected String getLaunchID() {
		return AcceleoLaunchingUtil.computeLaunchConfigID("org.obeonetwork.dsl.cinematic.gen.java.struts.architecture", 
				"org.obeonetwork.dsl.cinematic.gen.java.struts.architecture.main.StrutsArchitecture", 
				EcoreUtil.getURI(launcher.getModel()).toString(), 
				launcher.getTargetFolder().getAbsolutePath(), 
				new ArrayList<String>());
	}

	@Override
	public AbstractAcceleoGenerator instanciateLauncher(URI modelURI, File folder) throws IOException {
		launcher = new StrutsArchitecture(modelURI, folder, new ArrayList<String>());
		return launcher;
	}
}
