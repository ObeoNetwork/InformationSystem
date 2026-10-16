/*******************************************************************************
 * Copyright (c) 2008, 2026 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.database.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.Assert;

import liquibase.Liquibase;
import liquibase.database.Database;

public abstract class AbstractDockerTests {
	
	public static final String DATABASE_NAME_DEFAULT = "northwind";
	protected static Liquibase liquibase;
	protected static Database database;
	
	protected String containerName; 
	protected String containerImage;
	
	public AbstractDockerTests(String containerImage) {
		this.containerImage = containerImage;
		this.containerName = convertToContainerName(containerImage);  
	}
	
	@After
	public void tearDown() throws IOException, InterruptedException {
		
		ProcessBuilder killProcessBuilder = new ProcessBuilder();
		killProcessBuilder.command("docker", "kill", containerName); // shut down the container
		Process killProcess = killProcessBuilder.start();
		killProcess.waitFor();
		
		ProcessBuilder rmProcessBuilder = new ProcessBuilder();
		rmProcessBuilder.command("docker", "rm", "-f", containerName); // removes it from docker
		Process rmProcess = rmProcessBuilder.start();
		rmProcess.waitFor();
		
		Thread.sleep(1000);
		database = null;
	}
	
	/**
	 *  Container name cannot contain the ':' and '/' characters, often used in Docker images.
	 *  
	 * @param containerImage
	 * @return
	 */
	protected String convertToContainerName(String containerImage) {
		return containerImage.replace(":", "_").replace("/", "_");
	}
	
	/**
	 * Run the docker command {@link builder} and wait for its creation.
	 * 
	 * @param runProcessBuilder the docker command.
	 */
	protected void runAndWaitContainerCreation(ProcessBuilder runProcessBuilder) {
		try {
			runProcessBuilder.redirectErrorStream(true);

			System.out.println("Preparing container for image " + containerImage);

			Process process = runProcessBuilder.start();

	        BufferedReader reader = new BufferedReader(
	                new InputStreamReader(process.getInputStream()));

	        String line;
	        while ((line = reader.readLine()) != null) {
	            System.out.println(line);
	        }

	        int exitVal = process.waitFor();
            Thread.sleep(5000); 
            
            // wait for container to boot if created at the moment. 
            // a better implementation would check the output log until the containers tells its ready
            
	        if (exitVal != 0) {
	        	throw new Exception("Could not initialize docker image: exit code: "+exitVal);
	        }

		} catch (Exception e) {
			Assert.fail(e.toString());
		}		
	}
}
