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
package org.obeonetwork.dsl.database.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.obeonetwork.dsl.database.tests.utils.TestUtils;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;

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
		ProcessBuilder builder = new ProcessBuilder();
		builder.command("docker", "kill", containerName); // shut down the container
		builder.command("docker", "rm", "-f", containerName); // removes it from docker
		Process process = builder.start();
		process.waitFor();
		
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
	 * @param builder the docker command.
	 */
	protected void runAndWaitContainerCreation(ProcessBuilder builder) {
		try {
			Process process = builder.start();
			StringBuilder output = new StringBuilder();

	        BufferedReader reader = new BufferedReader(
	                new InputStreamReader(process.getInputStream()));

	        String line;
	        while ((line = reader.readLine()) != null) {
	            output.append(line + "\n");
	        }

	        int exitVal = process.waitFor();
            System.out.println(output);
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
