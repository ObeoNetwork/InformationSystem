Docker Toolbox sur Windows
- se connecter en tcp://192.168.99.100:2376
- cette info est disponible en variable d'environnement DOCKER_HOST normalement
(on doit même pouvoir l'utiliser par défaut sans préciser le docker host - à tester)

DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
        .withDockerHost("tcp://192.168.99.100:2376")
        .withDockerTlsVerify(true)
        .withDockerTlsVerify("1")
        .build();
                
                
Docker for windows
- Activer l'exposition du docker daemon sur port 2375 sans TLS 
https://github.com/docker-java/docker-java/issues/1032


DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder()
        .withDockerHost("tcp://localhost:2375")
        .build();