/*******************************************************************************
 * Copyright (c) 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Supplier;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.gen.common.services.StatusUtils;
import org.obeonetwork.dsl.database.gen.common.services.TypesServices;
import org.obeonetwork.dsl.typeslibrary.NativeTypesLibrary;
import org.obeonetwork.dsl.typeslibrary.TypesLibrary;
import org.obeonetwork.dsl.typeslibrary.UserDefinedTypesLibrary;

import liquibase.changelog.ChangeLogChild;
import liquibase.serializer.core.xml.XMLChangeLogSerializer;

/**
 * Generator that generate a changelog from a database comparison
 */
public class LiquibaseGenerator {

	private Supplier<String> idPrefixProvider = () -> LocalDateTime.now()
			.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss--"));

	public IStatus doGenerate(Monitor monitor, Comparison comparisonModel, Path targetFolder) throws IOException {

		File computeTargetFolder = computeTargetFolder(targetFolder.toFile(), comparisonModel);
		File computeLastTargetFolder = computeLastGenerationTargetFolder(targetFolder.toFile(), comparisonModel);

		// Current generation path (stored in path holding the date)
		File file = computeTargetFolder.toPath().resolve(ChangeLogBuilder.FILE_NAME).toFile();

		File lastFile = computeLastTargetFolder.toPath().resolve(ChangeLogBuilder.FILE_NAME).toFile();

		// Deletes last generation
		if (lastFile.exists()) {
			lastFile.delete();
		}

		ChangeLogBuilder changeLogBuilder = new ChangeLogBuilder();
		List<ChangeLogChild> contents = changeLogBuilder.buildContent(comparisonModel, idPrefixProvider.get());
		if (!contents.isEmpty()) {
			XMLChangeLogSerializer xmlSerializer = new XMLChangeLogSerializer();
			try (OutputStream output = new BufferedOutputStream(new FileOutputStream(file))) {
				xmlSerializer.write(contents, output);
				output.flush();
			}

			Files.copy(file.toPath(), lastFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		}
		List<IStatus> statuses = changeLogBuilder.getStatuses();
		if (statuses.isEmpty()) {
			return Status.OK_STATUS;
		} else {
			return StatusUtils.createMultiStatus("See message in the detail section", statuses);
		}

	}

	/**
	 * Compute the folder holding the last generated shnage log for the given model
	 * 
	 * @param folder     a root folder
	 * @param comparison the current comparison
	 * @return a folder
	 * @throws IOException
	 */
	private File computeLastGenerationTargetFolder(File folder, Comparison comparison) throws IOException {
		String folderName = "";
		String dbtypeFolderName = "";
		if (comparison != null) {
			DataBase database = (DataBase) comparison.getMatches().get(0).getLeft();

			TypesLibrary physicalTypesLibrary = new TypesServices().getPhysicalTypesLibrary(database);
			if (physicalTypesLibrary instanceof NativeTypesLibrary) {
				dbtypeFolderName += ((NativeTypesLibrary) physicalTypesLibrary).getName() + "/";
			} else if (physicalTypesLibrary instanceof UserDefinedTypesLibrary) {
				dbtypeFolderName += ((UserDefinedTypesLibrary) physicalTypesLibrary).getName() + "/";
			}

			folderName = database.getName();
		}

		File targetFolder = new File(folder.getAbsolutePath() + "/" + dbtypeFolderName + folderName);

		if (!targetFolder.exists()) {
			if (!targetFolder.mkdirs()) {
				throw new IOException("Unable to create folder at " + targetFolder);
			}
		}
		return targetFolder;
	}

	private File computeTargetFolder(File folder, Comparison comparison) throws IOException {
		String folderName = "";
		String dbtypeFolderName = "";
		if (comparison != null) {
			DataBase database = (DataBase) comparison.getMatches().get(0).getLeft();

			TypesLibrary physicalTypesLibrary = new TypesServices().getPhysicalTypesLibrary(database);
			if (physicalTypesLibrary instanceof NativeTypesLibrary) {
				dbtypeFolderName += ((NativeTypesLibrary) physicalTypesLibrary).getName() + "/";
			} else if (physicalTypesLibrary instanceof UserDefinedTypesLibrary) {
				dbtypeFolderName += ((UserDefinedTypesLibrary) physicalTypesLibrary).getName() + "/";
			}

			folderName = database.getName();
		}
		java.sql.Timestamp timeStampDate = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String timestamp = formatter.format(timeStampDate);
		folderName += "/" + timestamp;

		File targetFolder = new File(folder.getAbsolutePath() + "/" + dbtypeFolderName + folderName);

		if (!targetFolder.exists()) {
			if (!targetFolder.mkdirs()) {
				throw new IOException("Unable to create folder at " + targetFolder);
			}
		}

		return targetFolder;
	}

	public void setIdPrefixProvider(Supplier<String> idPrefixProvider) {
		this.idPrefixProvider = idPrefixProvider;
	}

}
