# CoopCredit System

Simple credit application system with two microservices:

- `credit-application-service`
- `risk-central-mock-service`

The goal is to simulate a real credit flow with hexagonal architecture and REST APIs.

___________
 1. Project structure


<img width="282" height="73" alt="image" src="https://github.com/user-attachments/assets/1bcd4908-50fd-4894-a68e-8f212aba8cb6" />


credit-application-service: main service. Manages affiliates and credit applications. Calls the risk service.

risk-central-mock-service: fake risk engine. Returns a risk score using the document number.

Both projects are Spring Boot applications with Maven.

_______________________________________________________
2. Technologies
Java 17

Spring Boot 3

Spring Web

Spring Data JPA

PostgreSQL

Lombok

MapStruct

Spring Boot Actuator

Maven

3. Prerequisites
You need these tools installed:

JDK 17 or higher

Maven 3.8+

Git

PostgreSQL database (local or cloud, for example Supabase)

Postman or another REST client

4. Clone the repository
bash
Copiar código
git clone https://github.com/Anderson030/coopcredit-system.git
cd coopcredit-system
5. Database configuration
The database is used by credit-application-service.

Create a PostgreSQL database.

Get the host, port, database name, username and password.

Open the file:

text
Copiar código
credit-application-service/src/main/resources/application.yml
Set your values:

yaml
Copiar código
spring:
  datasource:
    url: jdbc:postgresql://YOUR_HOST:YOUR_PORT/YOUR_DATABASE
    username: YOUR_USERNAME
    password: YOUR_PASSWORD
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
Replace YOUR_HOST, YOUR_PORT, YOUR_DATABASE, YOUR_USERNAME, YOUR_PASSWORD with your real data.

If you use Supabase, use the host and port from the connection screen and the database name postgres by default.

6. Risk service URL configuration
credit-application-service calls risk-central-mock-service.

Check this property in:

text
Copiar código
credit-application-service/src/main/resources/application.yml
yaml
Copiar código
coopcredit:
  risk-central:
    base-url: http://localhost:8081
If you change the port of risk-central-mock-service, update this URL.

7. Build the projects
From the root folder:

bash
Copiar código
cd coopcredit-system

cd credit-application-service
mvn clean package -DskipTests

cd ../risk-central-mock-service
mvn clean package -DskipTests
This command builds the two JAR files.

8. Run the microservices
Open two terminal windows.

8.1 Run risk-central-mock-service (port 8081)
bash
Copiar código
cd coopcredit-system/risk-central-mock-service
mvn spring-boot:run
Check health:

bash
Copiar código
GET http://localhost:8081/actuator/health
Expected response:

json
Copiar código
{"status":"UP"}
8.2 Run credit-application-service (port 8080)
In the second terminal:

bash
Copiar código
cd coopcredit-system/credit-application-service
mvn spring-boot:run
Check health:

bash
Copiar código
GET http://localhost:8080/actuator/health
Expected response:

json
Copiar código
{"status":"UP"}
9. REST API endpoints
9.1 risk-central-mock-service
Base URL: http://localhost:8081

POST /risk-evaluation
Request example:

http
Copiar código
POST http://localhost:8081/risk-evaluation
Content-Type: application/json
Body:

json
Copiar código
{
  "documentNumber": "1000086965"
}
Response example:

json
Copiar código
{
  "riskScore": 69,
  "riskLevel": "HIGH",
  "message": "Cliente con riesgo alto."
}
The response is a mock. The score and level are derived from the document number.

9.2 credit-application-service
Base URL: http://localhost:8080

Health
h
Copiar código
GET /actuator/health
Affiliates
Controller: AffiliateController

POST /api/affiliates
Create a new affiliate.

Request:

http
Copiar código
POST http://localhost:8080/api/affiliates
Content-Type: application/json
Body example (adapt to your DTO):

json
Copiar código
{
  "documentNumber": "1000086965",
  "firstName": "Anderson",
  "lastName": "Blandon",
  "email": "anderson@example.com",
  "salary": 3000000,
  "active": true
}
Response example:

json
Copiar código
{
  "id": 1,
  "documentNumber": "1000086965",
  "firstName": "Anderson",
  "lastName": "Blandon",
  "email": "anderson@example.com",
  "salary": 3000000,
  "active": true
}
The exact fields depend on AffiliateRequest and AffiliateResponse.

GET /api/affiliates
Get all affiliates.

http
Copiar código
GET http://localhost:8080/api/affiliates
Response example:

json
Copiar código
[
  {
    "id": 1,
    "documentNumber": "1000086965",
    "firstName": "Anderson",
    "lastName": "Blandon",
    "email": "anderson@example.com",
    "salary": 3000000,
    "active": true
  }
]
Credit application evaluation
The use case EvaluateCreditApplicationService evaluates a credit application.
If you have a REST endpoint for this (for example /api/credit-applications/{id}/evaluate), you can document it here.
You can add the exact URL and body when the controller is ready.

10. Postman usage
Start both microservices.

Open Postman.

Create a new collection named CoopCredit.

Add these requests:

GET http://localhost:8080/actuator/health

GET http://localhost:8081/actuator/health

POST http://localhost:8081/risk-evaluation with JSON body and documentNumber.

POST http://localhost:8080/api/affiliates with affiliate JSON body.

GET http://localhost:8080/api/affiliates

Save the collection.

Export the collection as JSON and include it in the project if needed.

11. Tests
To run tests in each microservice:

bash
Copiar código
cd credit-application-service
mvn test

cd ../risk-central-mock-service
mvn test
You can extend the project with unit tests, integration tests and Testcontainers.

