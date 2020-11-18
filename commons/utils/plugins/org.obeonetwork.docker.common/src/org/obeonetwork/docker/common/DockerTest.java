/*******************************************************************************
 * Copyright (c) 2008, 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.docker.common;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Bind;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.Ports;
import com.github.dockerjava.api.model.Ports.Binding;
import com.github.dockerjava.api.model.Volume;

public class DockerTest {
	
	private DockerUtils docker;
	
	private String createMySQLContainer(String containerName) {
		ExposedPort tcp3306 = ExposedPort.tcp(3306);
		
		Ports portBindings = new Ports();
        portBindings.bind(tcp3306, Binding.bindPort(tcp3306.getPort()));
        
		CreateContainerResponse exec = docker.createContainerCmd("mysql:5.7")
				.withName(containerName)
				.withImage("mysql:5.7")
				.withAttachStdin(Boolean.FALSE)
				.withAttachStdout(Boolean.FALSE)
				.withAttachStderr(Boolean.FALSE)
				.withEnv("MYSQL_ROOT_PASSWORD=root",
						"MYSQL_DATABASE=northwind",
						"MYSQL_USER=test",
						"MYSQL_PASSWORD=test")
				.withExposedPorts(tcp3306)
				.withHostConfig(HostConfig.newHostConfig().
						withPortBindings(portBindings)
				)
	            .exec();
		return exec.getId();
	}
	
	private Image loadOracleImage() {
		// Check if image already exists
		List<Image> images = docker.getImages("oracle/database:11.2.0.2-xe");
		if (images.isEmpty()) {
			// Load image
			try {
				docker.loadImage("D:/temp/docker/oracle11G-XE/oracle-xe-docker.tar");
			} catch (FileNotFoundException e) {
				fail("load oracle image failed : " + e.getMessage());
			}
			images = docker.getImages("oracle/database:11.2.0.2-xe");
		}
		return images.isEmpty() ? null : images.get(0); 
	}
	
	private String createOracleContainer(String containerName) {
		Image image = loadOracleImage();
		if (image != null) {
			
			
//			docker run --name oracletest --shm-size=1g -p 1521:1521 -e ORACLE_PWD=oracleserver -v temp/oradata:/u01/app/oracle/oradata -d oracle/database:11.2.0.2-xe
			ExposedPort tcp1521 = ExposedPort.tcp(1521);
			
			Ports portBindings = new Ports();
	        portBindings.bind(tcp1521, Binding.bindPort(tcp1521.getPort()));
	        
//	        Volume volume = new Volume("/u01/app/oracle/oradata");
	        
			CreateContainerResponse exec = docker.createContainerCmd("oracle/database:11.2.0.2-xe")
					.withName(containerName)
					.withImage("oracle/database:11.2.0.2-xe")
					.withAttachStdin(Boolean.FALSE)
					.withAttachStdout(Boolean.FALSE)
					.withAttachStderr(Boolean.FALSE)
					.withEnv("ORACLE_PWD=oracleserver")
//					.withVolumes(new Volume("oradata:/u01/app/oracle/oradata"))
					.withExposedPorts(tcp1521)
					.withHostConfig(HostConfig.newHostConfig()
							.withShmSize(FileUtils.ONE_GB)
							.withPortBindings(portBindings)
							.withBinds(new Bind("oradata", new Volume("/u01/app/oracle/oradata")))
					)
		            .exec();
			return exec.getId();
		}
		return null;
	}
	
	private void listContainers(List<Container> containers) {
		for (Container container : containers) {
			System.out.println("ID=" + container.getId());
			System.out.println("Names=" + StringUtils.join(Arrays.asList(container.getNames()), ","));
		}
	}
	
//	private void listContainers(DockerClient dockerClient, boolean showAll) {
//		List<Container> containers = dockerClient.listContainersCmd().withShowAll(showAll).exec();
//		for (Container container : containers) {
//			System.out.println("ID=" + container.getId());
//			for (String name : container.getNames()) {
//				System.out.println("Name=" + name);
//			}
//			System.out.println("Image=" + container.getImage());
//			System.out.println("Image ID=" + container.getImageId());
//			System.out.println("Labels=" + container.getLabels());
//		}
//	}

	@Test
	public void testDocker() {

		docker = new DockerUtils("tcp://192.168.99.100:2376", true);
		
		System.out.println("------------------------------------");
		System.out.println("Before !!!");
		System.out.println("------------------------------------");
		listContainers(docker.getContainers(false));
		
//		String containerId = createMySQLContainer("mysqltest");
		
		String containerId = createOracleContainer("oracletest_junit");
		if (containerId == null) {
			return;
		}
		docker.startContainer(containerId);
		
		
		System.out.println("------------------------------------");
		System.out.println("After !!!");
		System.out.println("------------------------------------");
		listContainers(docker.getContainers(false));
		
//		docker.stopContainer(containerId);
//		docker.removeContainer(containerId);
//		
//		System.out.println("------------------------------------");
//		System.out.println("End  !!!");
//		System.out.println("------------------------------------");
//		listContainers(docker.getContainers(false));
		
//		try {
//			PullImageResultCallback result = dockerClient.pullImageCmd("mysql:5.7")
//					.exec(new PullImageResultCallback()).awaitCompletion();
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
}
