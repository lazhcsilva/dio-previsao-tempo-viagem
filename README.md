# Time consumption API project for travel scheduling
This is an API for storing and managing trips, with functionalities for checking the weather forecast. It uses a MySQL database and Swagger for documentation.

## Functionality
- **Travel management**: Add, update, delete and list trips.
- **Weather Consultation**: CHeck the current weather and the weather forecast in different cities.
- **Security**: Implementation of authentication and authorization with Spring Security

## Technologies used
- **Java 17**
- **Spring Boot**
- **Spring Security**
- **MySQL**
- **Swagger**
- **Feign Client**

## Prerequisites
- JDK 17 or higher
- Maven
- MySQL

## Database configuration
1. Make sure you have a MySQL database running and create a database called travel_db. 
2. Update the connection settings in `application.properties`.

```properties
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/weatherlocalization?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false&&useTimezone=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```
## Maven dependence
Make sure that the pom.xml file contains the following dependencies:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-openfeign</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.5.0</version>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20240303</version>
    </dependency>
</dependencies>
```

## API documentation
The API documentation can be accessed via Swagger after starting the application:

```bash
http://localhost:8080/swagger-ui.html
```
## Endpoints
### TravelController
- `GET /travel` - Return all trips
- `GET /travel/{id}` - Returns a specific trip by ID
- `POST /travel` - Insert a new trip
- `PUT /travel/{id}` - Updates a specific trip by ID
- `DELETE /travel/{id}` - Deletes a specific trip by ID
### WeatherController
- `GET /weather` - Checks the current weather (Parameter: `q` - city name)
- `GET /weather/future` - Checks future weather (Parameters: `q` - city name, `dt` - date between 14 and 300 days in the future)

## Security configuration
The application uses Spring Security for authentication and authorization. The security configuration is done in the `WebSecurityConfig` and `SecurityDatabaseService` classes.

## Exception handling
The project implements a `GlobalExceptionHandler` class to handle global exceptions in the application.

## User initialization
A classe `StartApplication` cria um usuário padrão com senha criptografada ao iniciar a aplicação.

## How to Get an API Key
To use the weather check functionality, you need to obtain a WeatherAPI API key. Follow the steps below:

Visit the WeatherAPI website.
1. Create an account or log in if you already have one.
2. Navigate to the API Keys section and generate a new key.
3. Replace the key in the class `WeatherServiceImpl`.
```java
private static final String key = "your-key-here";
```
## How to run the application
1. Clone the repository:
`git clone https://github.com/seuusuario/travel-weather-api.git`
2. Compile and package the project
```bash
mvn clean install
```
3. Run application
```bash
mvn spring-boot:run
```

The application will be available at http://localhost:8080.

## Contribution
Contributions are welcome! Feel free to open issues and pull requests for improvements and corrections.
