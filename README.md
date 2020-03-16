# springboot-microservices #
This is a springboot+jpa+security project developed to create Microservices. 
"It contemplates the relation between Users and Posts, and Comments.
Each user may have multiples Posts, and each Post may have multiple comments.
We can access to get the Posts by User, and also the Comments by User and the Comments by Post."

*Built With*
Maven - Dependency Management
Spring Boot - Framework to ease the bootstrapping and development of new Spring Applications
git - Free and Open-Source distributed version control system
PostgreSql - Open Source Relational Database

*External Tools Used*
Postman - API Development Environment (Testing Docmentation)
Mockaroo - Provide mock data to test an app

*To-Do*
1- Create an API to collet credentials.
2- Create a Postgress Schema to store credentials and resources to be consumed by the services with ssl protocol.
3- Create an API to consume resources with the authorities created in the previous API.

*Running the application locally*
Download the zip or clone the Git repository.
Unzip the zip file (if you downloaded one)
Open Command Prompt and Change directory (cd) to folder containing pom.xml
Open Eclipse
File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
Select the project
Choose the Spring Boot Application file (search for @SpringBootApplication)
Right Click on the file and Run as Java Application
Alternatively you can use the Spring Boot Maven plugin like so:

  mvn spring-boot:run

*Actuator*
To monitor and manage the application:
URL	                                     Method
http://localhost:8080/actuator/	           GET
http://localhost:8080/actuator/health	     GET
http://localhost:8080/actuator/info	       GET

*URLs*
http://localhost:8080 --> Home content
http://localhost:8080/user --> role user related content
http://localhost:8080/admin --> role admin related content
http://localhost:8080/posts --> all posts
http://localhost:8080/posts/{id} --> post by id
http://localhost:8080/user/{id}/posts --> posts by user
http://localhost:8080/comments --> all comments
http://localhost:8080/comments/{id} --> comment by id
http://localhost:8080/user/{id}/comments --> comments by user
http://localhost:8080/posts/{id}/comments --> comments by post

*Packages*
entities — to hold entities;

repositories — to communicate with the database;

services — to hold business logic;

security — security configuration;

controllers — to listen to the client;

filters -> OncePerRequestFilter for the requests

util -> utilities, such as jwtUtil

pom.xml - contains all the project dependencies

SecurityConfiguration -> security definitions

application.properties - It contains application-wide properties, such as server’s default port, server’s context path, database URLs.
