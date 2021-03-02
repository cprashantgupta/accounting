#RESTFul Web Service

Account Application 

Account -> Bills
- Retrieve all account - GET /account
- Create an Account - POST /account
- Retrieve one account - GET /account/{id}
- Delete one Account - DELETE /account/{id}

Bills
- Retrieve all bills for an account - GET /bill
- Create a bill for an account - POST /account/{id}/bill
- retrieve details of a bill GET /account/{id}/bill/{bill_id}

Swagger Details : 
 - http://localhost:8080/swagger-ui/index.html#/

HAL Explorer : 
 - http://localhost:8080/explorer/index.html#theme=Cosmo&uri=/actuator
