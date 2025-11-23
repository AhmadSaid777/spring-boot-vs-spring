# Spring REST JPA Application (Without Spring Boot)  
  
Production-grade Spring MVC REST API with JPA/Hibernate and MySQL.  
  
## Project Structure  
  
``` 
spring-rest-jpa/  
  src/main/java/com/example/rest/  
    config/AppConfig.java  
    controller/UserController.java  
    model/User.java  
    repository/UserRepository.java  
    service/UserService.java  
    service/UserServiceImpl.java  
  src/main/webapp/WEB-INF/  
    web.xml  
  pom.xml  
  database-setup.sql  
``` 
  
## Build Instructions  
  
1. Setup MySQL database:  
   Run the database-setup.sql script  
  
2. Build the project:  
   mvn clean package  
  
3. Deploy to Tomcat:  
   Copy target/spring-rest-jpa.war to Tomcat webapps/  
  
## API Endpoints  
  
Base URL: http://localhost:8080/spring-rest-jpa/api/users  
  
- GET    /users      - Get all users  
- GET    /users/{id} - Get user by ID  
- POST   /users      - Create new user  
- PUT    /users/{id} - Update user  
- DELETE /users/{id} - Delete user 
