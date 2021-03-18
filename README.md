# clip-api

The Api has the purpose of expose the information from Clip to process payment transactions and Disbursements.

## Technologies

* spring-boot 2.3.3
* Java 8
* JPA
* Mapstruct
* H2
* Mysql
* Cancelado de comprobantes

## How to use it

Turning on the apis

1.- Using the JAR clip-api-0.0.1-SNAPSHOT.jar compiled in the tar folder
2.- Execute the next command in command line : java -jar clip-api-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=local
  A)  -Dspring.profiles.active its the enviroment config
      +Local: using a local H2 database
      +Dev: uses a Db in local (SQL DB)
3.-Validate that the application is working:
    +http://localhost:8080/api/v1/users  


## Extra info

The following files have the configuration of the local H2 DB:
* data.sql.-has all the DML inserts for all the tables
* schema.sql.-has all the DDL objects in the DB
