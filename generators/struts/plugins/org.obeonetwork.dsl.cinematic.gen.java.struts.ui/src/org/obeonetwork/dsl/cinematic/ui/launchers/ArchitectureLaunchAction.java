package org.obeonetwork.dsl.cinematic.ui.launchers;

import org.obeonetwork.acceleo.utils.launch.AbstractGenerationLauncher;
import org.obeonetwork.acceleo.utils.ui.actions.LaunchAction;

public class ArchitectureLaunchAction extends LaunchAction {

	@Override
	public AbstractGenerationLauncher getLauncher() {
		return new ArchitectureLauncher();
	}

}
