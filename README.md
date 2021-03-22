# clip-api

The Api has the purpose of expose the information from Clip to process payment transactions and Disbursements.

## Technologies

* spring-boot 2.3.3
* Java 8
* JPA
* Mapstruct
* H2
* Mysql

## How to use it

Running the Api

1.- Using the JAR clip-api-0.0.1-SNAPSHOT.jar compiled in the tar folder

2.- Execute the next command in command line : java -jar clip-api-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=local
  A)  -Dspring.profiles.active its the enviroment config
      +Local: using a local H2 database
      +Dev: uses a Db in local (SQL DB)
      
3.-Validate that the application is working:
    +http://localhost:8080/api/v1/users  

## Web API Resources

GET_ALL_USERS
GET /api/v1/users
Response

[

    {
    
        "id": 1,
        
        "name": "Eddy Ramos",
        
        "createTs": "2021-03-17",
        
        "lastTs": "2021-03-17"
        
    }
    
]

GET_USER_BY_ID
GET api/v1/users/{id}
Response

{

    "id": 1,
    
    "name": "Eddy Ramos",
    
    "createTs": "2021-03-17",
    
    "lastTs": "2021-03-17"
    
}

GET_TRANSACTIONS_BY_USER_ID
GET api/v1/transactions?clip_user={userId}
Response

[

    {
    
        "id": 1,
        
        "amount": 3.14,
        
        "clipUser": 1,
        
        "cardData": "20004152895621457448",
        
        "disbursed": false,
        
        "lastTs": "2021-03-17T06:00:00.000+00:00",
        
        "createTs": "2021-03-17T06:00:00.000+00:00"
        
    }
    
]

POST_TRANSACTION
POST api/v1/users/{id}
Body

{

        "amount": 3.14,
        
        "clipUser": 1,
        
        "cardData": "20004152895621457448",
        
        "disbursed": false
        
}
Response

 {
 
        "id": 1,
        
        "amount": 3.14,
        
        "clipUser": 1,
        
        "cardData": "20004152895621457448",
        
        "disbursed": false,
        
        "lastTs": "2021-03-17T06:00:00.000+00:00",
        
        "createTs": "2021-03-17T06:00:00.000+00:00"
        
 }

GET_DISBURSEMENT
GET api/v1/disbursement
Response

[

    {
    
        "id": 1,
        
        "amount": 1.00,
        
        "clipUser": 25000,
        
        "lastTs": "2021-01-01T06:00:00.000+00:00",
        
        "createTs": "2021-01-01T06:00:00.000+00:00"
        
    },
    
    {
    
        "id": 2,
        
        "amount": 1.00,
        
        "clipUser": 25000,
        
        "lastTs": "2021-02-01T06:00:00.000+00:00",
        
        "createTs": "2021-02-01T06:00:00.000+00:00"
        
    }
    
]

POST_DISBURSEMENT
POST api/v1/disbursement
Response

[

    {
    
        "id": 3,
        
        "amount": 1003.39,
        
        "clipUser": 1,
        
        "lastTs": "2021-03-18T22:39:36.828+00:00",
        
        "createTs": "2021-03-18T22:39:36.828+00:00"
        
    },
    
    {
    
        "id": 4,
        
        "amount": 100.00,
        
        "clipUser": 2,
        
        "lastTs": "2021-03-18T22:39:36.853+00:00",
        
        "createTs": "2021-03-18T22:39:36.853+00:00"
        
    }
    
]


## Extra info

The following files have the configuration of the local H2 DB:
* data.sql.-has all the DML inserts for all the tables
* schema.sql.-has all the DDL objects in the DB
