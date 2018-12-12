package org.obeonetwork.dsl.database.reverse;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class DatabaseReverserPlugin extends Plugin implements BundleActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.database.reverse";

	// The shared instance
	private static DatabaseReverserPlugin plugin;

	/**
	 * The constructor
	 */
	public DatabaseReverserPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
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
	public static DatabaseReverserPlugin getDefault() {
		return plugin;
	}
	
	public static void logError(String message, Throwable exception) {
		log(IStatus.ERROR, message, exception);
	}
	
	public static void logWarning(String message, Throwable exception) {
		log(IStatus.WARNING, message, exception);
	}
	
	public static void log(int severity, String message, Throwable exception) {
		getDefault().getLog().log(new Status(severity, PLUGIN_ID, message, exception));
	}
}
