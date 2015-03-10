package org.obeonetwork.dsl.database.compare;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.database.compare";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
	public static Activator getDefault() {
		return plugin;
	}
	
	public void logInfo(String msg) {
		log(IStatus.INFO, msg);
	}
	
	public void logWarning(String msg) {
		log(IStatus.WARNING, msg);
	}
	
	public void logError(String msg) {
		log(IStatus.ERROR, msg);
	}
	
	public void log(int severity, String message) {
		getLog().log(new Status(severity, Activator.PLUGIN_ID, message));
	}
}
