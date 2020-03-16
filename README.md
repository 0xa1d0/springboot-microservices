# springboot-microservices #
<b>This is a springboot+jpa+security project developed to create Microservices. </b><br />
"It contemplates the relation between Users and Posts, and Comments.
Each user may have multiples Posts, and each Post may have multiple comments.
We can access to get the Posts by User, and also the Comments by User and the Comments by Post."

<b>*Built With*</b><br />
Maven - Dependency Management<br />
Spring Boot - Framework to ease the bootstrapping and development of new Spring Applications<br />
git - Free and Open-Source distributed version control system<br />
PostgreSql - Open Source Relational Database<br />

<b>*External Tools Used*</b><br />
Postman - API Development Environment (Testing Docmentation)<br />
Mockaroo - Provide mock data to test an app<br />

<b>*To-Do*</b><br /></b><br />
1- Create an API to collet credentials.<br />
2- Create a Postgress Schema to store credentials and resources to be consumed by the services with ssl protocol.<br />
3- Create an API to consume resources with the authorities created in the previous API.<br />

<b>*Running the application locally*</b><br />
Download the zip or clone the Git repository.<br />
Unzip the zip file (if you downloaded one)<br />
Open Command Prompt and Change directory (cd) to folder containing pom.xml<br />
Open Eclipse<br />
File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip<br />
Select the project<br />
Choose the Spring Boot Application file (search for @SpringBootApplication)<br />
Right Click on the file and Run as Java Application<br />
Alternatively you can use the Spring Boot Maven plugin like so:<br />

  mvn spring-boot:run<br />

<b>*Actuator*</b><br />
To monitor and manage the application:<br />
URL	                                     Method
http://localhost:8080/actuator/	           GET<br />
http://localhost:8080/actuator/health	     GET<br />
http://localhost:8080/actuator/info	       GET<br />

<b>*URLs*</b><br />
http://localhost:8080 --> Home content<br />
http://localhost:8080/user --> role user related content<br />
http://localhost:8080/admin --> role admin related content<br />
http://localhost:8080/posts --> all posts<br />
http://localhost:8080/posts/{id} --> post by id<br />
http://localhost:8080/user/{id}/posts --> posts by user<br />
http://localhost:8080/comments --> all comments<br />
http://localhost:8080/comments/{id} --> comment by id<br />
http://localhost:8080/user/{id}/comments --> comments by user<br />
http://localhost:8080/posts/{id}/comments --> comments by post<br />

<b>*Packages*</b><br />
entities — to hold entities;<br />

repositories — to communicate with the database;<br />

services — to hold business logic;<br />

security — security configuration;<br />

controllers — to listen to the client;<br />

filters -> OncePerRequestFilter for the requests

util -> utilities, such as jwtUtil<br />

pom.xml - contains all the project dependencies<br />

SecurityConfiguration -> security definitions<br />

application.properties - It contains application-wide properties, such as server’s default port, server’s context path, database URLs.<br />
