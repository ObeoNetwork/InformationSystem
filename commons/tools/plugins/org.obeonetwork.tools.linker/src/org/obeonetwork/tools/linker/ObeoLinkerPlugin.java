package org.obeonetwork.tools.linker;

import org.eclipse.emf.common.EMFPlugin.EclipsePlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ObeoLinkerPlugin extends EclipsePlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.tools.linker"; //$NON-NLS-1$

	// The shared instance
	private static ObeoLinkerPlugin plugin;
	
	/**
	 * The constructor
	 */
	public ObeoLinkerPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ObeoLinkerPlugin getInstance() {
		return plugin;
	}

}
