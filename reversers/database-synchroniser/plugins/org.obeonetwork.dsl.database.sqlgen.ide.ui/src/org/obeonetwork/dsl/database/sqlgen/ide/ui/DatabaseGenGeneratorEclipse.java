//Start of user code copyright
//End of user code

package org.obeonetwork.dsl.database.sqlgen.ide.ui;

//Start of user code imports
import java.io.File;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.acceleo.aql.AcceleoUtil;
import org.eclipse.acceleo.aql.evaluation.GenerationResult;
import org.eclipse.acceleo.aql.ide.ui.dialog.AbstractResourceSelectionDialog;
import org.eclipse.acceleo.aql.ide.ui.dialog.FolderSelectionDialog;
import org.eclipse.acceleo.aql.parser.AcceleoParser;
import org.eclipse.acceleo.query.ast.ASTNode;
import org.eclipse.acceleo.query.ast.TypeLiteral;
import org.eclipse.acceleo.query.ide.runtime.impl.namespace.OSGiQualifiedNameResolver;
import org.eclipse.acceleo.query.runtime.namespace.IQualifiedNameQueryEnvironment;
import org.eclipse.acceleo.query.runtime.namespace.IQualifiedNameResolver;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import org.obeonetwork.dsl.database.sqlgen.DatabaseGenGenerator;

import org.eclipse.emf.compare.Comparison;

//End of user code

/**
 * Eclipse launcher for org::obeonetwork::dsl::database::sqlgen::DatabaseGen.
 * 
 * @author Laurent Redor
 * @generated
 */
public class DatabaseGenGeneratorEclipse extends DatabaseGenGenerator {

	/**
	 * Opens the dialog to select the target folder.
	 */
	private static final class SelectTargetRunnable implements Runnable {

		/**
		 * The target folder.
		 */
		private String target;

		@Override
		public void run() {
			final AbstractResourceSelectionDialog dialog = new FolderSelectionDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Select the destination folder",
					"");
			final int dialogResult = dialog.open();
			if ((dialogResult == IDialogConstants.OK_ID) && dialog.getFileName() != null
					&& !dialog.getFileName().isEmpty()) {
				final IPath path = new Path(dialog.getFileName());
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
				final IPath location;
				if (path.segmentCount() == 1) {
					location = workspaceRoot.getProject(path.segment(0)).getLocation();
				} else {
					location = workspaceRoot.getFolder(path).getLocation();
				}
				if (location != null) {
					target = location.toFile().getAbsolutePath();
				} else {
					Activator.getDefault().log(new Status(IStatus.ERROR, getClass(),
							"No location found for " + path + " (check if the project exists)."));
					target = null;
				}
			} else {
				target = null;
			}
		}

		/**
		 * Gets the target folder.
		 * 
		 * @return the target folder
		 */
		public String getTarget() {
			return target;
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
	public DatabaseGenGeneratorEclipse(IFile selected) {
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
	public DatabaseGenGeneratorEclipse(IFile selected, String target) {
		super(Collections.singletonList(URI.createFileURI(selected.getLocation().toString()).toString()), target);
		this.values = null;
	}

	/**
	 * Constructor.
	 * 
	 * @param selected the selected {@link Comparison}
	 * @generated
	 */
	public DatabaseGenGeneratorEclipse(Comparison selected) {
		super(Collections.emptyList(), getTarget(selected));
		this.values = Collections.singletonList(selected);
	}

	/**
	 * Constructor.
	 * 
	 * @param selected the selected {@link Comparison}
	 * @param target   the target folder of the generation
	 * @generated
	 */
	public DatabaseGenGeneratorEclipse(Comparison selected, String target) {
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
		final String bundleIdentifier = "org.obeonetwork.dsl.database.sqlgen";
		final Bundle bundle = Platform.getBundle(bundleIdentifier);
		if (bundle == null || bundle.getState() == Bundle.UNINSTALLED) {
			Activator.getDefault().log(new Status(IStatus.ERROR, getClass(),
					"The Bundle " + bundleIdentifier + " must be available in the target platform."));
		}
		return new OSGiQualifiedNameResolver(bundle, EPackage.Registry.INSTANCE, AcceleoParser.QUALIFIER_SEPARATOR);
	}

	/**
	 * Gets the target folder for the selected {@link Comparison} or selected
	 * {@link IFile}.
	 * 
	 * @param selected the model {@link Comparison} or selected {@link IFile}
	 * @return the target folder for the selected {@link Comparison} or selected
	 *         {@link IFile}
	 * @generated
	 */
	private static String getTarget(Object selected) {
		final SelectTargetRunnable runnable = new SelectTargetRunnable();
		Display.getDefault().syncExec(runnable);

		return runnable.getTarget();
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
	 * @generated
	 */
	@Override
	protected void afterGeneration(GenerationResult generationResult) {
		super.afterGeneration(generationResult);

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

}
