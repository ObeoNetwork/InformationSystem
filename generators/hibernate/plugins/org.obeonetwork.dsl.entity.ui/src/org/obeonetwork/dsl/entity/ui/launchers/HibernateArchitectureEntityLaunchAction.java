package org.obeonetwork.dsl.entity.ui.launchers;

import org.obeonetwork.acceleo.utils.launch.AbstractGenerationLauncher;
import org.obeonetwork.acceleo.utils.ui.actions.LaunchAction;

public class HibernateArchitectureEntityLaunchAction extends LaunchAction {

	@Override
	public AbstractGenerationLauncher getLauncher() {
		return new HibernateArchitectureEntityLauncher();
	}

}