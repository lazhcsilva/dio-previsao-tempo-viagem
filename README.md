# Travel Weather API
This is an API for storing and managing trips, with functionalities for checking the weather forecast. It uses a MySQL database and Swagger for documentation.

## Functionality
- Travel storage and management
- Checking the current weather for a specific location
- Checking the future climate for a specific location

## Technologies used
- Java
- Spring Boot
- MySQL
- Swagger
- Feign Client

## Prerequisites
- JDK 11+
- Maven
- MySQL

## Database configuration
Make sure you have a MySQL database running and create a database called travel_db. 
Update the connection settings in `application.properties`.

```
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/weatherlocalization?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&useSSL=false&&useTimezone=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

## API documentation
The API documentation can be accessed via Swagger after starting the application:

```
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

## How to Get an API Key
To use the weather check functionality, you need to obtain a WeatherAPI API key. Follow the steps below:

Visit the WeatherAPI website.
1. Create an account or log in if you already have one.
2. Navigate to the API Keys section and generate a new key.
3. Replace the key in the class `WeatherServiceImpl`.
```
private static final String key = "your-key-here";
```
## How to run the application
1. Clone the repository:
`git clone https://github.com/seuusuario/travel-weather-api.git`
2. Wait for the application to compile
3. Run application through class `TempoDiarioApplication`

The application will be available at http://localhost:8080.

## Contribution
Contributions are welcome! Feel free to open issues and pull requests for improvements and corrections.
