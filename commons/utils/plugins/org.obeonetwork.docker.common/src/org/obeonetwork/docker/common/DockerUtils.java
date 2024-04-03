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
package org.obeonetwork.docker.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.function.Predicate;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerCmd;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse.ContainerState;
import com.github.dockerjava.api.command.ListImagesCmd;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

public class DockerUtils {

	private DockerClient dockerClient;

	public DockerUtils(String url, boolean useTLS) {
		// Cas Unix et Mac à faire
		DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
				.withDockerHost(url)
				.withDockerTlsVerify(useTLS)/*.withDockerTlsVerify("1")*/
				.withDockerCertPath("/")
				.build();

		dockerClient = DockerClientBuilder.getInstance(config).build();
		dockerClient.listContainersCmd().exec();
	}
	
	public List<Container> getContainers(boolean showAll) {
		return dockerClient.listContainersCmd().withShowAll(showAll).exec();
	}
	
	public boolean waitUntilContainerIsStarted(String containerId, long timeoutMillis) {
		return waitUntilContainerStateVerify(containerId,
				state -> state.getHealth() != null && "healthy".equals(state.getHealth().getStatus()),
				timeoutMillis);
	}
	
	public boolean waitUntilContainerStateVerify(String containerId, Predicate<ContainerState> predicate, long timeoutMillis) {
		boolean timeoutOccured = false;
		boolean predicateVerified = false;
		Instant start = Instant.now();
		while (!predicateVerified && !timeoutOccured) {
			ContainerState state = getContainerState(containerId);
			predicateVerified = predicate.test(state);
			timeoutOccured = Duration.between(start, Instant.now()).toMillis() > timeoutMillis;
		}
		
		return predicateVerified;
	}
	
	public ContainerState getContainerState(String containerId) {
		InspectContainerResponse exec = dockerClient.inspectContainerCmd(containerId).exec();
		return exec.getState();
	}
	
	public CreateContainerCmd createContainerCmd(String image) {
		return dockerClient.createContainerCmd(image);
	}
	
	public void startContainer(String containerId) {
		dockerClient.startContainerCmd(containerId).exec();
	}
	
	public void stopContainer(String containerId) {
		dockerClient.stopContainerCmd(containerId).exec();
	}
	
	public void removeContainer(String name) {
		dockerClient.removeContainerCmd(name).exec();
	}
	
	public List<Image> getImages(String imageNameFilter) {
		ListImagesCmd listImagesCmd = dockerClient.listImagesCmd();
		if (imageNameFilter != null) {
			listImagesCmd.withImageNameFilter(imageNameFilter);
		}
		return listImagesCmd.exec();
	}
	
//	public void pullImage(String image) {
//		dockerClient.pullImageCmd(image).exec(image);
//	}
	
	public void loadImage(String filename) throws FileNotFoundException{
		File imageFile = new File(filename);
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(imageFile));
		dockerClient.loadImageCmd(inputStream).exec();
	}
	
	public void loadImage(URL url) throws IOException {
		dockerClient.loadImageCmd(url.openStream()).exec();
	}
	

	public DockerClient getDockerClient() {
		return dockerClient;
	}
	
}
