# Retail - Current Account Management System


Overview
Welcome to the Current Account Management System! 
This project is focused on creating an account management system, 
particularly for current accounts.
It's built using Spring Boot, Spring MVC, and Hibernate.

This document contains:
- Project Structure
- Getting Started
- API Documentation
- Testing with Postman


## Project Structure:

### 1- Base Package
The **Base Package** forms the foundation of our project's architecture, promoting code reusability, maintainability, and consistency. It includes essential modules that provide a standardized framework for various components.
### 2- Account Package
The **Account Package** is designed to provide a flexible and extensible foundation for managing various types of accounts within the system.

### 3- Current Account Package
The Current Account Package is an extension of the Account Package. Creating, updating, deleting and retrieving current accounts is possible 

### 4- Customer Package
The **Customer Package** designed to facilitate the creation, retrieval, and manipulation of customer-related information.

### 5- Transaction Package
The **Transaction Package** is responsible for tracking of transactions within the system. 


## Getting Started
Follow these steps to get the project up and running on your local machine:

- Step 1: Clone the repository
- Step 2: Installation and Running the application



### Step 1: Clone the repository
```shell
git clone https://github.com/monajahromi/Retail.git
cd Retial
```

### Step 2: Installation and Running the application


#### Docker Build
Build the Docker image by running the following command in the terminal:
```shell
docker build -t retail:0.0.1 .
```

#### Docker Run
Run the Docker container using the following command:
```shell
docker run --name retail -p 8083:8083 -it -d retail:0.0.1
```

This will start the container and expose port 8083 on your local machine.
The -d flag detaches the container, and the -it flag enables interactive mode,
allowing you to interact with the container's terminal.

If port 8083 is already in use on your system, you can use an alternate port, such as 8084:
```shell
docker run --name retail -p 8084:8083 -it -d retail:0.0.1
```

## API Documentation
You can explore and interact with the API endpoints using the Swagger UI:


- Swagger UI: [http://localhost:8083/swagger-ui/index.html](http://localhost:8083/swagger-ui/index.html)
- API Documentation JSON: [http://localhost:8083/v3/api-docs](http://localhost:8083/v3/api-docs)


## Testing with Postman

Access Postman Collection and Workspace:
https://www.postman.com/crimson-moon-938196/workspace/account-management/overview