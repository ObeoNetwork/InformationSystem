package org.obeonetwork.dsl.soa.ui.launchers;

import org.obeonetwork.acceleo.utils.launch.AbstractGenerationLauncher;
import org.obeonetwork.acceleo.utils.ui.actions.LaunchAction;

public class SpringHibernateLaunchAction extends LaunchAction {

	@Override
	public AbstractGenerationLauncher getLauncher() {
		return new SpringHibernateLauncher();
	}

}
