package org.obeonetwork.docker.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerCmd;
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
				.withDockerTlsVerify(true)/*.withDockerTlsVerify("1")*/
				.build();

		dockerClient = DockerClientBuilder.getInstance(config).build();
	}
	
	public List<Container> getContainers(boolean showAll) {
		return dockerClient.listContainersCmd().withShowAll(showAll).exec();
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
	
	public void loadImage(String filename) throws FileNotFoundException{
		File imageFile = new File(filename);
		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(imageFile));
		dockerClient.loadImageCmd(inputStream).exec();
	}

	public DockerClient getDockerClient() {
		return dockerClient;
	}
	
}
