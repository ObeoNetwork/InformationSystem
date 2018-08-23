/**
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.obeonetwork.tools.projectlibrary.ui.wizard.imp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;
import org.obeonetwork.tools.projectlibrary.imp.IConfirmationRunnable;
import org.obeonetwork.tools.projectlibrary.imp.LibraryImportException;
import org.obeonetwork.tools.projectlibrary.imp.ProjectLibraryImporter;
import org.obeonetwork.tools.projectlibrary.ui.wizard.WizardUtils;

/**
 * Wizard used to import a project library into a modeling project
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ImportLibraryIntoProjectWizard extends Wizard implements IImportWizard {
	
	private static final String KEY_SEPARATOR = "#";
	
	private static final String PREF_OPEN_SESSION_EDITOR = "PREF_OPEN_SESSION_EDITOR_ON_SESSION_OPEN";

	private static final String PLUGIN_SIRIUS_UI = "org.eclipse.sirius.ui";

	private static final String PREF_OPEN_ACTIVITY_EXPLORER = "openactivityexplorer";

	private static final String PLUGIN_ACTIVITY_EXPLORER = "org.eclipse.amalgam.explorer.activity.ui";
	
	private static final Map<String, Boolean> PREFS_EXPECTED_VALUES = new HashMap<String, Boolean>();
	static {
		PREFS_EXPECTED_VALUES.put(getPluginAndKey(PLUGIN_SIRIUS_UI, PREF_OPEN_SESSION_EDITOR), Boolean.FALSE);
		PREFS_EXPECTED_VALUES.put(getPluginAndKey(PLUGIN_ACTIVITY_EXPLORER, PREF_OPEN_ACTIVITY_EXPLORER), Boolean.FALSE);
	}

	private ImportLibraryIntoProjectWizardModel model = new ImportLibraryIntoProjectWizardModel();
	
	private ImportLibraryIntoProjectFileSelectionPage fileSelectionPage = null;

	public ImportLibraryIntoProjectWizard() {
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		fileSelectionPage = new ImportLibraryIntoProjectFileSelectionPage(this);
		
		// Initialize with selected project if it is a modeling project
		Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
		if (selectedObject instanceof IProject) {
			IProject project = (IProject)selectedObject;
			Option<ModelingProject> optionModelingProject = ModelingProject.asModelingProject(project);
			if (optionModelingProject.some()) {
				this.model.setModelingProject(optionModelingProject.get());
			}
		}
		
		// Initialize list of modeling projects
		model.setModelingProjects(WizardUtils.getAllModelingProjects());
	}

	@Override
	public boolean canFinish() {
		return super.canFinish() && fileSelectionPage.isPageComplete();
	}

	@Override
	public boolean performFinish() {
		ImportLibraryAsProjectRunnable runnable = new ImportLibraryAsProjectRunnable();
		try {
			getContainer().run(true, true, runnable);
		} catch (Exception e) {
			// Do nothing
		}
		return runnable.getResult();
	}
	
	public class ImportLibraryAsProjectRunnable implements IRunnableWithProgress {
		private boolean result;

		public void run(IProgressMonitor monitor) {
			SubMonitor subMonitor = SubMonitor.convert(monitor, "Importing MAR file", 1);
			
			Map<String, Boolean> originalValues = disableAutomaticEditors();
			
			ProjectLibraryImporter importer = new ProjectLibraryImporter();
			try {
				importer.importIntoProject(model.getModelingProject(), new File(model.getFilepath()), new IConfirmationRunnable() {
					
					@Override
					public boolean askForConfirmation(String message) {
						return MessageDialog.openConfirm(getShell(), "Import project as library", message);
					}
				}, subMonitor.newChild(1));
			} catch (LibraryImportException e) {
				MessageDialog.openError(getShell(), "Import project as library", e.getMessage());
				result = false;
			}
			
			resetAutomaticEditors(originalValues);
			subMonitor.done();
			result = true;
	    }
		
		public boolean getResult() {
			return result;
		}
	}
	
	/**
	 * Disable automatic editors opening for Activity Explorer and Sirius AIRD editor
	 */
	private Map<String, Boolean> disableAutomaticEditors() {
		Map<String, Boolean> originalValues = new HashMap<>();
		
		for (Entry<String, Boolean> prefEntry : PREFS_EXPECTED_VALUES.entrySet()) {
			String plugin = extractPluginFromPluginAndKey(prefEntry.getKey());
			String key = extractKeyFromPluginAndKey(prefEntry.getKey());
			
			boolean originalValue = getPreference(plugin, key);
			if (!prefEntry.getValue().equals(originalValue)) {
				// Change value for preference
				setPreferenceValue(plugin, key, prefEntry.getValue());
				
				originalValues.put(prefEntry.getKey(), originalValue);
			}
		}
		
		return originalValues;
	}
	
	private void resetAutomaticEditors(Map<String, Boolean> originalValues) {
		for (Entry<String, Boolean> originalValue : originalValues.entrySet()) {
			String plugin = extractPluginFromPluginAndKey(originalValue.getKey());
			String key = extractKeyFromPluginAndKey(originalValue.getKey());
			setPreferenceValue(plugin, key, originalValue.getValue());
		}
	}
	
	private static String getPluginAndKey(String plugin, String key) {
		return plugin + KEY_SEPARATOR + key;
	}
	
	private static String extractPluginFromPluginAndKey(String pluginAndKey) {
		String[] split = pluginAndKey.split(KEY_SEPARATOR);
		if (split.length > 0) {
			return split[0];
		}
		return null;
	}
	
	private static String extractKeyFromPluginAndKey(String pluginAndKey) {
		String[] split = pluginAndKey.split(KEY_SEPARATOR);
		if (split.length > 1) {
			return split[1];
		}
		return null;
	}
	
	private boolean getPreference(String plugin, String key) {
		return Platform.getPreferencesService().getBoolean(plugin, key, true, null);
	}
	
	private void setPreferenceValue(String plugin, String key, boolean value) {
		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(plugin);
		preferences.put(key, Boolean.toString(value));
	}
	
	@Override
	public void addPages() {
		super.addPages();
		addPage(fileSelectionPage);
	}

	public ImportLibraryIntoProjectWizardModel getModel() {
		return model;
	}
	
}
