# Retail
Current Account Management System


### Overview
Welcome to Current Account Management System! 
This project aims to create account, specially current account management.
It is built using Spring boot, Spring mvc, Hibernate.

## Base Package
The Base Package forms the bedrock of our project's architecture, providing a standardized and efficient foundation for various components. Designed to enhance code reusability, maintainability, and consistency, the base package includes several essential modules that shape the core of our application's development.

### Account Package
The Account Package serves as a pivotal component of our application, handling various aspects of account management and transactions. It provides a structured framework for organizing, manipulating, and tracking accounts and their associated data.
Table of Contents
### Current Account Package
The Current Account Package is an extension of the Account Package, catering specifically to the management of current accounts. It builds upon the foundational components from the Account Package while introducing additional attributes and behaviors that are relevant to current accounts.


Certainly! Here's an overview of the Customer and Transaction packages in your project:

### Customer Package
The Customer Package is a fundamental module within our application that handles the management of customer data and interactions. It encompasses various components designed to facilitate the creation, retrieval, and manipulation of customer-related information.

### Transaction Package
The Transaction Package is responsible for managing transaction data, enabling the recording and tracking of financial transactions within the system. It offers a structured framework for capturing and managing transaction details.
Project Description

## Getting Started
Follow these steps to get the project up and running on your local machine:

Step 1: Clone the repository
Step 2: Installation
Step 3: Run the application


### Step 1: Clone the repository
```shell
git clone https://github.com/monajahromi/Retail.git
cd Retial
```

Step 2: Installation

### Docker

1. Build the Docker image by running the following command in the terminal:
```shell
docker build -t retail:1.0.0 .
```

Step 3: Run the Application
Run the Docker container using the following command:

```shell
docker run --name retail -p 8083:8083 -d retail:1.0.0

```

This will start the container and expose port 8083 on your local machine.
The -d flag detaches the container, 
and the -it flag enables interactive mode,
allowing you to interact with the container's terminal.

If port 8083 is already in use on your system, you can use an alternate port, such as 8084:
```shell
docker run --name retail -p 8084:8083 -it -d retail:1.0.0

```

API Documentation
You can explore and interact with the API endpoints using the Swagger UI:


- Swagger UI: [http://localhost:8083/swagger-ui/index.html](http://localhost:8083/swagger-ui/index.html)
- API Documentation JSON: [http://localhost:8083/v3/api-docs](http://localhost:8083/v3/api-docs)

The Swagger UI provides an interactive interface to view, test, and interact with the API endpoints, while the API Documentation JSON endpoint provides the OpenAPI specification in JSON format.

