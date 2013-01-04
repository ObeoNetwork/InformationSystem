/**
 * 
 */
package org.obeonetwork.acceleo.utils.launch;

import java.io.File;
import java.io.IOException;

import org.eclipse.acceleo.engine.service.AbstractAcceleoGenerator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class NetworkGenerationLauncher extends AbstractGenerationLauncher {

	protected AbstractAcceleoGenerator generationLauncher;

	/**
	 * @return the launchID of this loader
	 */
	protected abstract String getLaunchID();

	/**
	 * @param modelURI
	 * @param folder
	 * @return
	 * @throws IOException
	 */
	public abstract AbstractAcceleoGenerator instanciateLauncher(URI modelURI, File folder) throws IOException;

	
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.acceleo.utils.launch.AbstractGenerationLauncher#lauchGeneration(java.lang.String[])
	 */
	public void lauchGeneration(final String[] args) throws IOException {
		if (args.length < 2) {
			System.out.println("Arguments not valid : {model, folder}.");
		} else {
			URI modelURI = URI.createFileURI(args[0]);
			File folder = new File(args[1]);
			lauchGeneration(modelURI, folder, null);
		}
	}
	
	
	/**
	 * {@inheritDoc}
	 * @see org.obeonetwork.acceleo.utils.launch.AbstractGenerationLauncher#lauchGeneration(org.eclipse.emf.common.util.URI, java.io.File, java.util.List, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void lauchGeneration(URI modelURI, File folder, IProgressMonitor monitor) throws IOException {
		//AcceleoPreferences.switchTraceability(false);
		generationLauncher = instanciateLauncher(modelURI, folder);
		//TraceabilityAcceleoGenerator generator = new TraceabilityAcceleoGenerator(generationLauncher, getLaunchID());
		generationLauncher.doGenerate(monitor != null?BasicMonitor.toMonitor(monitor):new BasicMonitor());
		//AcceleoPreferences.switchTraceability(false);
	}
}
