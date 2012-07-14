package org.obeonetwork.dsl.entity.ui.launchers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.obeonetwork.acceleo.utils.launch.NetworkGenerationLauncher;
import org.obeonetwork.dsl.entity.gen.java.common.main.Common;

import org.eclipse.acceleo.engine.utils.AcceleoLaunchingUtil;

public class CommonLauncher extends NetworkGenerationLauncher {

	private AbstractAcceleoGenerator launcher;
	
	@Override
	protected String getLaunchID() {
		return AcceleoLaunchingUtil.computeLaunchConfigID("org.obeonetwork.dsl.entity.gen.java.common", 
				"org.obeonetwork.dsl.entity.gen.java.common.main.Common", 
				EcoreUtil.getURI(launcher.getModel()).toString(), 
				launcher.getTargetFolder().getAbsolutePath(), 
				new ArrayList<String>());
	}

	@Override
	public AbstractAcceleoGenerator instanciateLauncher(URI modelURI, File folder) throws IOException {
		launcher = new Common(modelURI, folder, new ArrayList<String>());
		return launcher;
	}

}
