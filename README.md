# User Management Application

The User Management Application is an application built with Spring Boot and designed to handle CRUD operation and manage user information.


# Instructions for running the Spring Boot Application

## Prerequisites

1. **Java Development Kit (JDK)**:
   Ensure you have JDK 17 or later installed. You can download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-downloads.html) or use OpenJDK.

2. **Maven**:
   Maven is required for building and running the Spring Boot application. You can download Maven from [Apache Maven's official website](https://maven.apache.org/download.cgi).

3.  **PostgreSQL Database**:
    Install PostgreSQL on your machine. You can download it from [PostgreSQL's official website](https://www.postgresql.org/download/).

4. **IDE (Optional)**:
   Use an Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, Spring Tool Suite (STS) or VSCode for better development experience.

## Database setup

1. **Create database**:
   Open PostgreSQL command line or pgAdmin and create a new database named `usermanagement`
   `CREATE DATABASE usermanagement;`

2. **Database Credentials**:
   Make sure the `application.properties` file in your Spring Boot application has the correct database credentials. The provided properties are:
   `spring.datasource.url=jdbc:postgresql://localhost:5432/usermanagement`
   `spring.datasource.username=postgres`
   `spring.datasource.password=123456`

## Running the Application

1. **Clone or Download the Project**:
   Ensure you have the project files on your local machine.
   `cd <repository_directory>`

   If you using version control system like Git, use this command to clone the repository:
   `git clone https://github.com/ddaudovv/rest-web-service.git`

   or download [zip archive](https://github.com/ddaudovv/rest-web-service/archive/refs/heads/master.zip)

   `cd <project_directory>`

2. **Build the Project**:
   Use Maven to build the project. Open a terminal in the project directory and run:
   `mvn clean install`

3. **Run the Application**:
   After the build is successful, run the Spring Boot application using Maven:
   `mvn spring-boot:run`

4. **Access the Application**:
   The application should now be running on `http://localhost:8080`. You can access it via your web browser or any API client like Postman.

## API Documentation

All endpoints are relative to the base URL:  `http://localhost:8080`

### Authentication
All endpoints ,except for creating a new user, require basic authentication. To access these endpoints, include the `Authorization` header in your requests with username and password.

### Endpoints

1. **Create a New User**
    Allows you to add a new to the database. The user information should be provided in the request body as JSON
- URL: `/users/`
- Method: `POST`
- Status Codes:
  - `201 Created` : User created successfully.
  - `400 Bad Request` : Validation failed.


2. **Get User by ID**
   Allows you to retrieve a user by their ID. The user ID must be provided as a path parameter. Returns the created user information in the response body.
- URL: `/users/{id}`
- Method: `GET`
- Authentication: Required, Type - Basic Authorization.
- Path Variable: `id` (long) - The ID of the user.
- Status Codes:
  - `200 OK` : User created successfully.
  - `400 Bad Request` : Validation failed.
  - `401 Unauthorized` :  Bad credentials.
  - `404 Not Found` :  User with the given ID does not exist.


3. **Get all Users**
Retrieves all the users stored in the database, sorted in ascendant order by `last_name` and `date_of_birth` column. Returns a list of users information in the response body.
- URL: `/users/all`
- Method: `GET`
- Authentication: Required, Type - Basic Authorization.
- Status Codes:
  - `200 OK` : Users retrieved successfully.
  - `401 Unauthorized` :  Bad credentials.


4. **Get users by search term** Searches for users based on a search term and returns a list of users information in the response body.
- URL: `/search`
- Method: `GET`
- Query Parameter: `term` (string) - The term to search for in usernames and emails.
- Authentication: Required, Type - Basic Authorization.
- Status Codes:
  - `200 OK` : Users matching the search term retrieved successfully.
  - `400 Bad Request` : Validation failed.
  - `401 Unauthorized` :  Bad credentials.
  - `404 Not Found` :  No Users found matching the search term.

5. **Update User**
   Allows you to update an existing user in the database. The user ID must be provided as a path parameter, and the updated user information should be provided in the request body as JSON.
- URL: `/update/{id}`
- Method: `PUT`
- Authentication: Required, Type - Basic Authorization.
- Path Variable: `id` (long) - The ID of the user.
- Status Codes:
  - `200 OK` : User updated successfully.
  - `400 Bad Request` : Validation failed.
  - `401 Unauthorized` :  Bad credentials.
  - `404 Not Found` :  User with the given ID does not exist.

6. **Delete User by ID**
   Allows you to delete a user from the database. The user ID must be provided as a path parameter. Returns the deleted user information in the response body.
- URL: `/delete/{id}`
- Method: `DELETE`
- Authentication: Required, Type - Basic Authorization.
- Path Variable: `id` (long) - The ID of the user.
- Status Codes:
  - `200 OK` : User deleted successfully.
  - `400 Bad Request` : Validation failed.
  - `401 Unauthorized` :  Bad credentials.
  - `404 Not Found` :  User with the given ID does not exist.

