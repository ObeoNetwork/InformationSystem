/*******************************************************************************
 * Copyright (c) 2008, 2024 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.liquibasegen;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
import org.obeonetwork.dsl.database.DatabaseElement;
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

	private TypesServices typesServices = new TypesServices();

	private Supplier<String> idPrefixProvider = () -> LocalDateTime.now()
			.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss--"));

	public IStatus doGenerate(Monitor monitor, Comparison comparisonModel, Path targetFolder) throws IOException {
		return doGenerate(monitor, comparisonModel, targetFolder, false);
	}
	

	public  IStatus doGenerate(Monitor monitor, Comparison comparisonModel, Path targetFolder, boolean createSchemaIfNoneExist) throws IOException {
		File computeTargetFolder = computeTargetFolder(targetFolder.toFile(), comparisonModel);
		File computeLastTargetFolder = computeLastGenerationTargetFolder(targetFolder.toFile(), comparisonModel);

		// Current generation path (stored in path holding the date)
		File file = computeTargetFolder.toPath().resolve(ChangeLogBuilder.FILE_NAME).toFile();

		Path lastFileFolder = computeLastTargetFolder.toPath();
		File lastFile = lastFileFolder.resolve(ChangeLogBuilder.FILE_NAME).toFile();

		// Deletes last generation
		if (lastFile.exists()) {
			lastFile.delete();
		}

		ChangeLogBuilder changeLogBuilder = new ChangeLogBuilder();
		List<ChangeLogChild> contents = changeLogBuilder.buildContent(comparisonModel, idPrefixProvider.get(), createSchemaIfNoneExist);
		if (!contents.isEmpty()) {
			XMLChangeLogSerializer xmlSerializer = new XMLChangeLogSerializer();
			try (OutputStream output = new BufferedOutputStream(new FileOutputStream(file))) {
				xmlSerializer.write(contents, output);
				output.flush();
			}

			Files.copy(file.toPath(), lastFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

			Path liquibasePropertyFile = lastFileFolder.resolve("liquibase.properties");
			if (!liquibasePropertyFile.toFile().exists()) {
				writePropertyFile(liquibasePropertyFile, comparisonModel);
			}						
		}
		List<IStatus> statuses = changeLogBuilder.getStatuses();
		if (statuses.isEmpty()) {
			return Status.OK_STATUS;
		} else {
			return StatusUtils.createMultiStatus("See message in the detail section", statuses);
		}
	}

	private static final String EOL = System.lineSeparator();

	private void writePropertyFile(Path liquibasePropertyFile, Comparison comparisonModel) throws IOException {
		
		DatabaseElement databaseElement = comparisonModel.getMatches().stream()
		.filter(match -> match.getLeft() instanceof DatabaseElement)
		.map(match -> (DatabaseElement)match.getLeft())
		.findAny().orElse(null);
		
		String content = //
				  "# Enter the path for your changelog file." + EOL //
				+ "changeLogFile=run.changelog.xml" + EOL //
				+ EOL //
				+ "#### Enter the Target database 'url' information  ####" + EOL //
				+ genPropertyFileURLSectionContents("url", databaseElement) //
				+ EOL //
				+ "# Enter the username for your Target database." + EOL //
				+ "username: " + EOL //
				+ EOL //
				+ "# Enter the password for your Target database." + EOL //
				+ "password: " + EOL //
				+ EOL //
				+ "# Specify the schema to use for the creation of Liquibase objects" + EOL //
				+ "#liquibase.liquibaseSchemaName: YOUR_SCHEMA_NAME" + EOL //
				+ EOL //
				+ "#Driver name" + EOL //
				+ "driver: " + genDriver(databaseElement) + EOL //
				+ "#Path to the driver jar" + EOL
				+ "classpath: " + EOL
				+ EOL
				+ "#### Enter the Source Database 'referenceUrl' information ####" + EOL //
				+ "## The source database is the baseline or reference against which your target database is compared for diff/diffchangelog commands."
				+ EOL //
				+ EOL //
				+ "# Enter URL for the source database" + EOL //
				+ genPropertyFileURLSectionContents("referenceUrl", databaseElement) //
				+ EOL //
				+ "# Enter the username for your source database" + EOL //
				+ "#referenceUsername:" + EOL //
				+ EOL //
				+ "# Enter the password for your source database" + EOL //
				+ "#referencePassword:" + EOL //
				+ EOL;

		try (FileWriter writer = new FileWriter(liquibasePropertyFile.toFile())) {
			writer.append(content);
		}

	}
	
	private String genDriver(DatabaseElement databaseElement) {
		String driver = "";
		
		if(databaseElement != null) {
			if(typesServices.isTargetH2(databaseElement)) {
				driver = "org.h2.Driver";
			} else if(typesServices.isTargetPostgreSQL(databaseElement)) {
				driver = "org.postgresql.Driver";
			} else if(typesServices.isTargetOracle(databaseElement)) {
				driver = "oracle.jdbc.OracleDriver";
			} else if(typesServices.isTargetMySql(databaseElement)) {
				driver = "com.mysql.jdbc.Driver";
			} else if(typesServices.isTargetMariaDB(databaseElement)) {
				driver = "org.mariadb.jdbc.Driver";
			} else if(typesServices.isTargetSqlServer(databaseElement)) {
				driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			}
		}
		return driver;
	}

	private String genPropertyFileURLSectionContents(String propertyName, DatabaseElement databaseElement) {
		
		StringBuffer urlSection = new StringBuffer();
		
		if(databaseElement != null) {
			if(typesServices.isTargetH2(databaseElement)) {
				urlSection.append(propertyName + ": jdbc:h2:<path><dbName>" + EOL);
				urlSection.append("#" + propertyName + ": jdbc:h2:tcp://<hostname>:<port>/<path><dbName>" + EOL);
			} else if(typesServices.isTargetPostgreSQL(databaseElement)) {
				urlSection.append(propertyName + ": jdbc:postgresql://<hostname>:5432/<dbName>" + EOL);
			} else if(typesServices.isTargetOracle(databaseElement)) {
				urlSection.append(propertyName + ": jdbc:oracle:thin:@<hostname>:1521:<dbName>" + EOL);
			} else if(typesServices.isTargetMySql(databaseElement)) {
				urlSection.append(propertyName + ": jdbc:mysql://<hostname>:3306/<dbName>" + EOL);
			} else if(typesServices.isTargetMariaDB(databaseElement)) {
				urlSection.append(propertyName + ": jdbc:mysql://<hostname>:3306/<dbName>" + EOL);
			} else if(typesServices.isTargetSqlServer(databaseElement)) {
				urlSection.append(propertyName + ": jdbc:sqlserver://<hostname>:1433;DatabaseName=<dbName>" + EOL);
			}
		}
		
		return urlSection.toString();
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
