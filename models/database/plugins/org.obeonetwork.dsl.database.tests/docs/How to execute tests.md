# Run tests with docker

In order to execute tests always in the same context, this document explains how to lauch databases using docker with right parameters.

## Launch database

I recommend to start one container at once as some container are mapped on the same connection port.

### Prerequisites

You need to install docker first.

### MariaDB

Installation :

- docker pull mariadb/server:10.2
- docker run --name mariadbtest -p 127.0.0.1:3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mariadb/server:10.2

Arrêt :

- docker stop mariadbtest

Démarrage :

- docker start mariadbtest

### MySQL

Installation :

- docker pull mysql:5.7
- docker run --name mysqltest -p 127.0.0.1:3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7

Arrêt :

- docker stop mysqltest

Démarrage :

- docker start mysqltest

### Postgres

Installation :

- docker pull postgres:9.3-alpine
- docker run --name postgrestest -p 127.0.0.1:5432:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=northwind -d postgres:9.3-alpine

Arrêt :

- docker stop postgrestest

Démarrage :

- docker start postgrestest

### SQL Server

Installation :

- docker pull mcr.microsoft.com/mssql/server:2017-latest
- docker run --name sqlservertest -p 127.0.0.1:1433:1433 -e ACCEPT_EULA=Y -e SA_PASSWORD=Sqls3rv3r -d mcr.microsoft.com/mssql/server:2017-latest

Arrêt :

- docker stop sqlservertest

Démarrage :

- docker start sqlservertest

Note: You can open a connection to the SQL Server database through docker by running the following command in a terminal:

- docker exec -it sqlservertest
- cd opt/mssql-tools/bin
- ./sqlcmd -S 127.0.0.1,1433 -U sa -P Sqls3rv3r -d northwind

### H2 Database

Installation :

- docker pull oscarfonts/h2:1.3.176
- docker run --name h2test -p 127.0.0.1:1521:1521 -p 127.0.0.1:8081:81 -d oscarfonts/h2:1.3.176

Arrêt :

- docker stop sqlservertest

Démarrage :

- docker start sqlservertest

### Oracle

Installation :

- Build docker image:
  - Download https://minhaskamal.github.io/DownGit/#/home?url=https://github.com/oracle/docker-images/tree/master/OracleDatabase/SingleInstance/dockerfiles/11.2.0.2
  - Download Oracle database 11g Release 2 Express Edition from http://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html
  - Rename Dockerfile.xe en Dockerfile
  - Execute cmd : docker build -t oracle/database:11.2.0.2-xe . 
- docker run --name oracletest --shm-size=1g -p 127.0.0.1:1521:1521 -e ORACLE_PWD=oracleserver -v path/to/directory:/u01/app/oracle/oradata -d oracle/database:11.2.0.2-xe

Arrêt :

- docker stop oracletest

Démarrage :

- docker start oracletest

## Execute tests

Once a docker container has been launch and the database is started, you can start the test class associated with the docker container.

## Disclaimer

It may happen that tests can fail after some time. In such case you will need to staop and remove the docker container involved using the command: `docker rm -v [container name]`, then execute the run command associated with the docker container you remove. The run command is the last step of the installation process above.