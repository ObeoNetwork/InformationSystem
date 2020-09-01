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
import java.nio.file.Path;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Comparison;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Schema;
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

	public IStatus doGenerate(Monitor monitor, Comparison comparisonModel, Path targetFolder) throws IOException {

		File computeTargetFolder = computeTargetFolder(targetFolder.toFile(), comparisonModel);
		if (!computeTargetFolder.exists()) {
			if (!computeTargetFolder.mkdirs()) {
				throw new IOException("Unable to create folder at " + targetFolder);
			}
		}

		File file = computeTargetFolder.toPath().resolve(ChangeLogBuilder.FILE_NAME).toFile();
		if (file.createNewFile()) {
			ChangeLogBuilder changeLogBuilder = new ChangeLogBuilder();
			List<ChangeLogChild> contents = changeLogBuilder.buildContent(comparisonModel);
			if (!contents.isEmpty()) {
				XMLChangeLogSerializer xmlSerializer = new XMLChangeLogSerializer();
				try (OutputStream output = new BufferedOutputStream(new FileOutputStream(file))) {
					xmlSerializer.write(contents, output);
					output.flush();
				}

				// TODO remove this
				try (OutputStream output = new BufferedOutputStream(
						new FileOutputStream(targetFolder.resolve(ChangeLogBuilder.FILE_NAME).toFile()))) {
					xmlSerializer.write(contents, output);
					output.flush();
				}

			}
			List<IStatus> statuses = changeLogBuilder.getStatuses();
			if (statuses.isEmpty()) {
				return Status.OK_STATUS;
			} else {
				return StatusUtils.createMultiStatus("Some problem occured during generation", statuses);
			}
		} else {
			return StatusUtils.createErrorStatus("Unable to create file at " + file);
		}

	}

	private File computeTargetFolder(File folder, Comparison comparison) {
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
			if (database.getSchemas().size() > 0) {
				Schema schema = database.getSchemas().get(0);
				folderName = schema.getName();
			}
			folderName += "-";
		}
		java.sql.Timestamp timeStampDate = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd/HH-mm-ss");
		String timestamp = formatter.format(timeStampDate);
		folderName += timestamp;

		File targetFolder = new File(folder.getAbsolutePath() + "/" + dbtypeFolderName + folderName);
		return targetFolder;
	}

}
