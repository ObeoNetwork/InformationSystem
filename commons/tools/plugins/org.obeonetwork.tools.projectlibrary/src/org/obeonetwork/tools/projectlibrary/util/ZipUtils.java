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
package org.obeonetwork.tools.projectlibrary.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 
 * @author <a href="mailto:stephane.thibaudeau@obeo.fr">Stephane Thibaudeau</a>
 *
 */
public class ZipUtils {
	
	private static final int BUFFER_SIZE = 4096;

	public static void addToZip(final File fileToAdd, String pathInZip, final File zipFile) throws IOException {
		Map<String, String> zipProperties = new HashMap<>();
		zipProperties.put("create", "false");
		zipProperties.put("encoding", "UTF-8");
		URI zipUri = URI.create("jar:" + zipFile.toURI().toString());
		
		try (FileSystem zipFS = FileSystems.newFileSystem(zipUri, zipProperties)) {
			// Create directories
			int lastIdx = pathInZip.lastIndexOf("/");
			if (lastIdx != -1) {
				// We have directories to potentially create
				createDirectory(zipFS, pathInZip.substring(0, lastIdx));
			}
			
			// Create a path for the file in zip
			Path zipFilePath = zipFS.getPath(pathInZip);
			
			// Create a path for the existing zip file
			Path fileToAddPath = fileToAdd.toPath();

			// Add file into zip
			Files.copy(fileToAddPath,zipFilePath);
		}
	}
	
	private static void createDirectory(FileSystem fs, String directoryPath) throws IOException {
		int lastIdx = directoryPath.lastIndexOf("/");
		if (lastIdx != -1) {
			// Create parent directories
			String parentDirectoryPath = directoryPath.substring(0, lastIdx);
			createDirectory(fs, parentDirectoryPath);
		}
		Path folder = fs.getPath(directoryPath);
		if (Files.notExists(folder)) {
			Files.createDirectory(folder);			
		}
	}
	
	public static void zipFolder(final File folder, final File zipFile,  FileFilter filter) throws IOException {
		zipFolder(folder, new FileOutputStream(zipFile), filter);
	}

	public static void zipFolder(final File folder, final OutputStream outputStream, FileFilter filter) throws IOException {
		try (ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {
			processFolder(folder, zipOutputStream, folder.getPath().length() + 1, filter);
		}
	}
	
	private static void processFolder(final File folder, final ZipOutputStream zipOutputStream, final int prefixLength, FileFilter filter)	throws IOException {
		for (final File file : folder.listFiles(filter)) {
			if (file.isFile()) {
				final ZipEntry zipEntry = new ZipEntry(file.getPath().substring(prefixLength));
				zipOutputStream.putNextEntry(zipEntry);
				try (FileInputStream inputStream = new FileInputStream(file)) {
					copy(inputStream, zipOutputStream);
				}
				zipOutputStream.closeEntry();
			} else if (file.isDirectory()) {
				processFolder(file, zipOutputStream, prefixLength, filter);
			}
		}
	}

	private static void copy(InputStream input, OutputStream output) throws IOException {
		byte[] buffer = new byte[BUFFER_SIZE];
		int read = 0;
		while ((read = input.read(buffer)) != -1) {
			output.write(buffer, 0, read);
		}
	}
	
	public static void unzipIntoFolder(final File zipFile, final File targetFolder) throws IOException {
		unzipIntoFolder(zipFile, targetFolder, null);
	}
	
	public static void unzipIntoFolder(final File zipFile, final File targetFolder, FilenameFilter filter) throws IOException {
		if (!targetFolder.exists()) {
			targetFolder.mkdirs();
		}
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile));
		ZipEntry entry = zipInputStream.getNextEntry();
		// Loop on file contents
		while (entry != null) {
			File targetFile = new File(targetFolder, entry.getName());
			File parentFile = targetFile.getParentFile();
			if (filter == null || filter.accept(parentFile, targetFile.getName())) {
				if (entry.isDirectory()) {
					// Directory
					targetFile.mkdir();
				} else {
					// Not a directory, copy the file
					// but create the required parent directories first
					if (parentFile != null && !parentFile.exists()) {
						parentFile.mkdirs();
					}
					// then copy file
					BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile));
					copy(zipInputStream, outputStream);
					outputStream.close();
				}
			}
			zipInputStream.closeEntry();
			entry = zipInputStream.getNextEntry();
		}
		zipInputStream.close();
	}
	
//	   
//	    /**
//	     * Extracts a zip file specified by the zipFilePath to a directory specified by
//	     * destDirectory (will be created if does not exists)
//	     * @param zipFilePath
//	     * @param destDirectory
//	     * @throws IOException
//	     */
//	    public void unzip(String zipFilePath, String destDirectory) throws IOException {
//	        File destDir = new File(destDirectory);
//	        if (!destDir.exists()) {
//	            destDir.mkdir();
//	        }
//	        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
//	        ZipEntry entry = zipIn.getNextEntry();
//	        // iterates over entries in the zip file
//	        while (entry != null) {
//	            String filePath = destDirectory + File.separator + entry.getName();
//	            if (!entry.isDirectory()) {
//	                // if the entry is a file, extracts it
//	                extractFile(zipIn, filePath);
//	            } else {
//	                // if the entry is a directory, make the directory
//	                File dir = new File(filePath);
//	                dir.mkdir();
//	            }
//	            zipIn.closeEntry();
//	            entry = zipIn.getNextEntry();
//	        }
//	        zipIn.close();
//	    }
//	    /**
//	     * Extracts a zip entry (file entry)
//	     * @param zipIn
//	     * @param filePath
//	     * @throws IOException
//	     */
//	    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
//	        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
//	        byte[] bytesIn = new byte[BUFFER_SIZE];
//	        int read = 0;
//	        while ((read = zipIn.read(bytesIn)) != -1) {
//	            bos.write(bytesIn, 0, read);
//	        }
//	        bos.close();
//	    }
}
