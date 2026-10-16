//Start of user code copyright
//End of user code

package org.obeonetwork.cinematic.gen.html.ide.ui;

import java.io.BufferedOutputStream;
//Start of user code imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.acceleo.aql.AcceleoUtil;
import org.eclipse.acceleo.aql.evaluation.GenerationResult;
import org.eclipse.acceleo.aql.parser.AcceleoParser;
import org.eclipse.acceleo.query.ast.ASTNode;
import org.eclipse.acceleo.query.ast.TypeLiteral;
import org.eclipse.acceleo.query.ide.runtime.impl.namespace.OSGiQualifiedNameResolver;
import org.eclipse.acceleo.query.runtime.namespace.IQualifiedNameQueryEnvironment;
import org.eclipse.acceleo.query.runtime.namespace.IQualifiedNameResolver;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.obeonetwork.cinematic.gen.html.ide.ui.dialogs.SpecificWorkspaceResourceDialog;
import org.obeonetwork.cinematic.gen.html.main.MainGenerator;
import org.obeonetwork.dsl.cinematic.CinematicRoot;
import org.osgi.framework.Bundle;

//End of user code

/**
 * Eclipse launcher for org::obeonetwork::cinematic::gen::html::main::main.
 * 
 * @author Laurent Redor
 * @generated
 */
public class MainGeneratorEclipse extends MainGenerator {

	private static final class FolderSelectionRunnable implements Runnable {

		private IResource selectedResource = null;

		public void run() {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
			
			ViewerFilter filter = new ViewerFilter() {
				
				@Override
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof IFolder) {
						return !(((IFolder) element).getName().startsWith("."));
					}
					return true;
				}
			};

			List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
			filters.add(filter);
			selectedResource = SpecificWorkspaceResourceDialog.openFolderOrFileSelection(shell,
					"Safr@an",
					"Select an existing folder or specify a new one",
					new Path(root.getRawLocation().toOSString()),
					filters);
		}

		public IResource getSelectedResource() {
			return selectedResource;
		}
	}

	/**
	 * The selected value.
	 * 
	 * @generated
	 */
	private final List<EObject> values;

	/**
	 * Constructor.
	 * 
	 * @param selected the selected {@link IFile}
	 * @generated
	 */
	public MainGeneratorEclipse(IFile selected) {
		super(Collections.singletonList(URI.createFileURI(selected.getLocation().toString()).toString()),
				getTarget(selected));
		this.values = null;
	}

	/**
	 * Constructor.
	 * 
	 * @param selected the selected {@link IFile}
	 * @param target   the target folder of the generation
	 * @generated
	 */
	public MainGeneratorEclipse(IFile selected, String target) {
		super(Collections.singletonList(URI.createFileURI(selected.getLocation().toString()).toString()), target);
		this.values = null;
	}

	/**
	 * Constructor.
	 * 
	 * @param selected the selected {@link CinematicRoot}
	 * @generated
	 */
	public MainGeneratorEclipse(CinematicRoot selected) {
		super(Collections.emptyList(), getTarget(selected));
		this.values = Collections.singletonList(selected);
	}

	/**
	 * Constructor.
	 * 
	 * @param selected the selected {@link CinematicRoot}
	 * @param target   the target folder of the generation
	 * @generated
	 */
	public MainGeneratorEclipse(CinematicRoot selected, String target) {
		super(Collections.emptyList(), target);
		this.values = Collections.singletonList(selected);
	}

	/**
	 * @generated
	 */
	@Override
	protected List<EObject> getValues(IQualifiedNameQueryEnvironment queryEnvironment,
			Map<EClass, List<EObject>> valuesCache, TypeLiteral type, ResourceSet resourceSetForModels,
			List<Resource> modelResources, Monitor monitor) {
		final List<EObject> res;

		if (values != null) {
			res = values;
		} else {
			res = super.getValues(queryEnvironment, valuesCache, type, resourceSetForModels, modelResources, monitor);
		}

		return res;
	}

	/**
	 * @generated
	 */
	@Override
	protected void standaloneInitialization(ResourceSet resourceSetForModels) {
		// nothing to do here
	}

	/**
	 * @generated
	 */
	@Override
	protected IQualifiedNameResolver createResolver() {
		final String bundleIdentifier = "org.obeonetwork.cinematic.gen.html";
		final Bundle bundle = Platform.getBundle(bundleIdentifier);
		if (bundle == null || bundle.getState() == Bundle.UNINSTALLED) {
			Activator.getDefault().log(new Status(IStatus.ERROR, getClass(),
					"The Bundle " + bundleIdentifier + " must be available in the target platform."));
		}
		return new OSGiQualifiedNameResolver(bundle, EPackage.Registry.INSTANCE, AcceleoParser.QUALIFIER_SEPARATOR);
	}

	/**
	 * Gets the target folder for the selected {@link CinematicRoot} or selected
	 * {@link IFile}.
	 * 
	 * @param selected the model {@link CinematicRoot} or selected {@link IFile}
	 * @return the target folder for the selected {@link CinematicRoot} or selected
	 *         {@link IFile}
	 * @generated
	 */
	private static String getTarget(Object selected) {
		final FolderSelectionRunnable runnable = new FolderSelectionRunnable();
		Display.getDefault().syncExec(runnable);

		return runnable.getSelectedResource().getLocation().toOSString();
	}

	/**
	 * @generated
	 */
	@Override
	public void generate(Monitor monitor) {
		if (target != null) {
			super.generate(monitor);
		}
	}

	/**
	 * Prints the diagnostics for the given {@link GenerationResult}.
	 * 
	 * @param generationResult the {@link GenerationResult}
	 * @generated
	 */
	protected void printDiagnostics(GenerationResult generationResult) {
		if (generationResult.getDiagnostic().getSeverity() > Diagnostic.INFO) {
			printDiagnostic(generationResult.getDiagnostic());
		}
		printSummary(generationResult);
	}

	/**
	 * Prints the given {@link Diagnostic} for the given {@link PrintStream}.
	 * 
	 * @param stream      the {@link PrintStream}
	 * @param diagnostic  the {@link Diagnostic}
	 * @param indentation the current indentation
	 * @generated
	 */
	protected void printDiagnostic(Diagnostic diagnostic) {
		if (diagnostic.getMessage() != null) {
			final String location;
			if (!diagnostic.getData().isEmpty() && diagnostic.getData().get(0) instanceof ASTNode) {
				location = AcceleoUtil.getLocation((ASTNode) diagnostic.getData().get(0)) + ": ";
			} else {
				location = "";
			}
			switch (diagnostic.getSeverity()) {
			case Diagnostic.INFO:
				Activator.getDefault().log(new Status(IStatus.INFO, diagnostic.getSource(),
						location + diagnostic.getMessage(), diagnostic.getException()));
				break;

			case Diagnostic.WARNING:
				Activator.getDefault().log(new Status(IStatus.WARNING, diagnostic.getSource(),
						location + diagnostic.getMessage(), diagnostic.getException()));
				break;

			case Diagnostic.ERROR:
				Activator.getDefault().log(new Status(IStatus.ERROR, diagnostic.getSource(),
						location + diagnostic.getMessage(), diagnostic.getException()));
				break;
			}
		}
		for (Diagnostic child : diagnostic.getChildren()) {
			printDiagnostic(child);
		}
	}

	/**
	 * Prints the summary of the generation.
	 * 
	 * @param result the {@link GenerationResult}
	 * @generated
	 */
	protected void printSummary(GenerationResult result) {
		int nbErrors = 0;
		int nbWarnings = 0;
		int nbInfos = 0;
		for (Diagnostic diagnostic : result.getDiagnostic().getChildren()) {
			switch (diagnostic.getSeverity()) {
			case Diagnostic.ERROR:
				nbErrors++;
				break;

			case Diagnostic.WARNING:
				nbWarnings++;
				break;

			case Diagnostic.INFO:
				nbInfos++;
				break;

			default:
				break;
			}
		}

		final String message = "Files: " + result.getGeneratedFiles().size() + ", Lost Files: "
				+ result.getLostFiles().size() + ", Errors: " + nbErrors + ", Warnings: " + nbWarnings + ", Infos: "
				+ nbInfos + ".";
		Activator.getDefault().log(new Status(IStatus.INFO, getClass(), message));
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void afterGeneration(GenerationResult generationResult) {
		super.afterGeneration(generationResult);

		// Unzip the content of bootstrap.zip
		Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
    	URL fileURL = FileLocator.find(bundle, new Path("bootstrap/bootstrap.zip"), null);
    	
    	File destinationFolder = java.nio.file.Path.of(target).toFile();
    	try {
    		unzip(fileURL, destinationFolder);
    	} catch (IOException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			Activator.getDefault().log(status);
    	}
    	
		// refresh if the generated files are in the workspace
		final File targetFolder = new File(target);
		final IContainer targetWorkspaceContainer = ResourcesPlugin.getWorkspace().getRoot()
				.getContainerForLocation(new Path(targetFolder.getAbsolutePath()));
		if (targetWorkspaceContainer != null) {
			try {
				targetWorkspaceContainer.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (CoreException e) {
				Activator.getDefault().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"could not refresh " + targetWorkspaceContainer.getFullPath(), e));
			}
		}
	}
	
	/**
	 * Unzip a file given its url into a folder
	 * @param zipURL URL of the zip file
	 * @param folder Folder where to unzip
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void unzip(URL zipURL, File folder) throws FileNotFoundException, IOException{

		ZipInputStream zis = new ZipInputStream(zipURL.openStream());

		ZipEntry ze = null;
		try {
			while((ze = zis.getNextEntry()) != null){

				File f = new File(folder.getCanonicalPath(), ze.getName());
				if (ze.isDirectory()) {
					f.mkdirs();
					continue;
				}
				f.getParentFile().mkdirs();
				OutputStream fos = new BufferedOutputStream(
						new FileOutputStream(f));
				try {
					try {
						final byte[] buf = new byte[8192];
						int bytesRead;
						while (-1 != (bytesRead = zis.read(buf)))
							fos.write(buf, 0, bytesRead);
					}
					finally {
						fos.close();
					}
				}
				catch (final IOException ioe) {
					f.delete();
					throw ioe;
				}
			}
		}
		finally {
			zis.close();
		}
	}

}
