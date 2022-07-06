# Spring Boot REST API Project
This is a Spring boot implementaion of an API for the REC risk module.

## How to Run
Clone this repository

Build the project by running the command

`mvn clean package`

Run the project by invoking the command

`java -jar target/api-1.0.0.jar`


## About the service

The service is a REST service. It uses an in-memory database (H2) to store the data. It fetched data from files in the resource folder and loads the data in a H2 database. You can view the H2 database at `http://localhost:8080/h2-console`.

## API Endpoints

### Get all the Table Data

```
GET http://127.0.0.1:8080/api/v1/reports

 [
    {
        "reference": "BCP-1-5688/k/2020/CICARE",
        "country": "COTE D'IVOIRE",
        "cedant": "Paix Assur",
        "validationStatus": "Rejected",
        "confirmationStatus": "Rejected",
        "publicationDate": "2020-10-31",
        "branch": "AUTOMOBILE",
        "rec": 0
    }
    .
    .
    .
 ]   

```
### Filter by one field single value

```
GET http://127.0.0.1:8080/api/v1/reports/filter?region=CIMA AFRIQUE OCCIDENTALE

```
### Filter by one field and multiple values

`GET http://127.0.0.1:8080/api/v1/reports/filter?cedant=Paix Assur,HYPER NON VIE ASSURANCE`


### Filter by multiple fields and multiple values

This works with multiple filter fields:

  ```
  region
  country
  cedant
  cedant_group
  validation_status
  confirmation_status
  branch
  ```

Example GET

`http://127.0.0.1:8080/api/v1/reports/filter?cedant=HYPER NON VIE ASSURANCE&confirmation_status=Confirmed`

### OpenAPI Documenation

Run the server and browse to localhost:8080/swagger-ui.html


