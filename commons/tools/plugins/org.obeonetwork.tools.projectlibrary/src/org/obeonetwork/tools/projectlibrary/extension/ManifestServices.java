/*******************************************************************************
 * Copyright (c) 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.tools.projectlibrary.extension;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.featureextensions.FeatureExtensionsManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DFeatureExtension;
import org.obeonetwork.dsl.manifest.BadVersionStringException;
import org.obeonetwork.dsl.manifest.MImportExportData;
import org.obeonetwork.dsl.manifest.MManifest;
import org.obeonetwork.dsl.manifest.ManifestFactory;
import org.obeonetwork.dsl.manifest.util.ManifestUtils;

/**
 * Services to deal with modeling projects manifests 
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 */
public class ManifestServices {
	
	private static final String MANIFEST_KEY_EXPORT_DEPENDENCIES = "Export-Dependencies";
	private static final String MANIFEST_KEY_EXPORT_COMMENT = "Export-Comment";
	private static final String MANIFEST_KEY_EXPORT_DATE = "Export-Date";
	private static final String MANIFEST_KEY_EXPORT_VERSION = "Export-Version";
	private static final String MANIFEST_KEY_PROJECT_ID = "Project-Id";
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
	private static final String DEPENDENCY_PATTERN = "%s;" + MANIFEST_KEY_EXPORT_VERSION + "=\'%s\'";
	private static final Pattern DEPENDENCY_REGEX = Pattern.compile("^([^;]+);" + MANIFEST_KEY_EXPORT_VERSION + "='([^'])+'$");
	
	public Manifest getManifestFromArchive(File archiveFile) throws IOException {
		JarFile jarFile = new JarFile(archiveFile);
		Manifest manifest = jarFile.getManifest();
		jarFile.close();
		return manifest;
	}
	
	public MManifest getModelFromMarManifest(Manifest manifest) {
		MManifest manifestModel = ManifestFactory.eINSTANCE.createMManifest();
		manifestModel.setProjectId(manifest.getMainAttributes().getValue(new Attributes.Name(MANIFEST_KEY_PROJECT_ID)));
		String creationDateAsString = manifest.getMainAttributes().getValue(new Attributes.Name(MANIFEST_KEY_EXPORT_DATE));
		if (creationDateAsString != null) {
			try {
				manifestModel.setCreationDate(DATE_FORMAT.parse(creationDateAsString));
			} catch (ParseException e) {
				// Do nothing, date format is invalid
			}			
		}
		manifestModel.setComment(manifest.getMainAttributes().getValue(new Attributes.Name(MANIFEST_KEY_EXPORT_COMMENT)));
		try {
			manifestModel.setVersion(manifest.getMainAttributes().getValue(new Attributes.Name(MANIFEST_KEY_EXPORT_VERSION)));
		} catch (BadVersionStringException e) {
		}
		
		String dependenciesAsString = manifest.getMainAttributes().getValue(new Attributes.Name(MANIFEST_KEY_EXPORT_DEPENDENCIES));
		String[] dependencies = dependenciesAsString.split(",");
		for (String dep : dependencies) {
			Matcher matcher = DEPENDENCY_REGEX.matcher(dep);
			if (matcher.matches()) {
				String id = matcher.group(1);
				String version = matcher.group(2);
				
				if (ManifestUtils.isVersionFormatValid(version)) {
					MManifest depManifest = ManifestFactory.eINSTANCE.createMManifest();
					depManifest.setProjectId(id);
					try {
						depManifest.setVersion(version);
					} catch (BadVersionStringException e) {
						// Do nothing, should never occur as we have checked just before
					}
					manifestModel.getDependencies().add(depManifest);
				}
			}
		}
		
		return manifestModel;
	}
	
	public Manifest getMarManifestFromModel(MManifest manifestModel) {
		Manifest manifest = new Manifest();
		manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
		manifest.getMainAttributes().put(new Attributes.Name(MANIFEST_KEY_PROJECT_ID), manifestModel.getProjectId());
		manifest.getMainAttributes().put(new Attributes.Name(MANIFEST_KEY_EXPORT_VERSION), manifestModel.getVersion());
		manifest.getMainAttributes().put(new Attributes.Name(MANIFEST_KEY_EXPORT_DATE), DATE_FORMAT.format(manifestModel.getCreationDate()));
		manifest.getMainAttributes().put(new Attributes.Name(MANIFEST_KEY_EXPORT_COMMENT), manifestModel.getComment());
		
		String dependencies = "";
		for (MManifest requiredManifest : manifestModel.getDependencies()) {
			String dependencyAsString = String.format(DEPENDENCY_PATTERN, requiredManifest.getProjectId(), requiredManifest.getVersion());
			dependencies += dependencyAsString + ",";
		}
		manifest.getMainAttributes().put(new Attributes.Name(MANIFEST_KEY_EXPORT_DEPENDENCIES), dependencies);
		return manifest;
	}

	public MManifest getNewManifest(String id, String version, String comment) {
		MManifest manifest = ManifestFactory.eINSTANCE.createMManifest();
		manifest.setProjectId(id);
		try {
			manifest.setVersion(version);
		} catch (BadVersionStringException e) {
			return null;
		}
		if (comment == null) {
			manifest.setComment("");
		} else {
			manifest.setComment(comment);
		}
		manifest.setCreationDate(new Date());
		
		return manifest;
	}
	
	public List<MManifest> getDependencies(Session session) {
		MImportExportData data = getImportExportData(session);
		if (data != null) {
			return data.getDependencies();
		}
		return new ArrayList<>();
	}
	
	public List<MManifest> getExportedManifests(Session session) {
		MImportExportData data = getImportExportData(session);
		if (data != null) {
			return data.getExportedManifests();
		}
		return new ArrayList<>();
	}
	
	public List<MManifest> getImportedManifests(Session session) {
		MImportExportData data = getImportExportData(session);
		if (data != null) {
			return data.getImportedManifests();
		}
		return new ArrayList<>();
	}
	
	public MImportExportData getImportExportData(Session session) {
		if (session != null) {
			Collection<DFeatureExtension> data = FeatureExtensionsManager.INSTANCE.retrieveFeatureExtensionData(ManifestFeatureExtension.FEATURE_EXTENSION_NAME, session);
			if (data != null) {
				for (DFeatureExtension featureExtension : data) {
					if (featureExtension instanceof MImportExportData) {
						return (MImportExportData)featureExtension;
					}
				}
			}
		}
		return null;
	}
	
	private DAnalysis getMainAnalysis(Session session) {
		if (session != null) {
			Resource mainAird = session.getSessionResource();
			if (mainAird != null && mainAird.getContents() != null) {
				for (EObject content : mainAird.getContents()) {
					if (content instanceof DAnalysis) {
						return (DAnalysis)content;
					}
				}
				
			}
			
		}
		return null;
	}
	
	public MImportExportData createImportExportData(final Session session) {
		MImportExportData data = ManifestFactory.eINSTANCE.createMImportExportData();
		final DAnalysis mainAnalysis = getMainAnalysis(session);
		if (mainAnalysis != null) {
			executeInRecordingCommand(session, () -> {
				FeatureExtensionsManager.INSTANCE.saveFeatureExtensionData(
						ManifestFeatureExtension.FEATURE_EXTENSION_NAME,
						session,
						mainAnalysis,
						data);
			});
		}
		return data;
	}
	
	public void addExportedManifestToSession(final Session session, final MManifest manifest) {
		if (session != null) {
			MImportExportData data = getImportExportData(session);
			if (data == null) {
				data = createImportExportData(session);
			}
			final MImportExportData data2 = data;
			executeInRecordingCommand(session, () -> data2.getExportedManifests().add(manifest) );
		}
	}
	
	private void executeInRecordingCommand(final Session session, final Runnable runnable) {
		final TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
		final Command cmd = new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				runnable.run();
			}
		};
		domain.getCommandStack().execute(cmd);
	}
	
}
