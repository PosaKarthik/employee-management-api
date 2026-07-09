# 🚀 Employee Management REST API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.15-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.9-red)
![MySQL](https://img.shields.io/badge/MySQL-8-blue)
![OpenAPI](https://img.shields.io/badge/OpenAPI-3-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

## 📖 Project Overview

Employee Management REST API is a backend application built using **Spring Boot** that follows a **Layered Architecture** to create clean, maintainable, and scalable RESTful APIs.

The application provides APIs to manage employee records with support for CRUD operations, search functionality, pagination, sorting, batch employee creation, bean validation, global exception handling, structured error responses, logging, and interactive API documentation using Swagger OpenAPI.

This project demonstrates Spring Boot best practices such as the **DTO Pattern**, **Mapper Pattern**, **Layered Architecture**, **Bean Validation**, **Global Exception Handling**, and **Separation of Concerns**.

## ✨ Features

- ✅ Create Employee
- ✅ Get Employee by ID
- ✅ Get All Employees
- ✅ Update Employee
- ✅ Delete Employee
- ✅ Search Employees by Department
- ✅ Search Employees by Name
- ✅ Search Employees by Salary
- ✅ Batch Employee Creation
- ✅ Pagination
- ✅ Sorting
- ✅ Bean Validation
- ✅ Global Exception Handling
- ✅ Structured Error Responses
- ✅ Logging using SLF4J
- ✅ Swagger / OpenAPI Documentation
- ✅ DTO Pattern
- ✅ Mapper Pattern
- ✅ Layered Architecture

- ## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming Language |
| Spring Boot 3.5 | Backend Framework |
| Spring Data JPA | Data Access Layer |
| Hibernate | ORM Framework |
| MySQL | Relational Database |
| Maven | Build Tool |
| Lombok | Boilerplate Code Reduction |
| Bean Validation | Request Validation |
| OpenAPI / Swagger | API Documentation |
| SLF4J | Logging Framework |

## 🏗️ Architecture

The project follows a **Layered Architecture** to ensure separation of concerns.

```text
                Client
                   │
                   ▼
          EmployeeController
                   │
                   ▼
           EmployeeService
                   │
                   ▼
           EmployeeMapper
                   │
                   ▼
        EmployeeRepository
                   │
                   ▼
            MySQL Database
```

### Layer Responsibilities

| Layer | Responsibility |
|--------|----------------|
| Controller | Handles HTTP requests and responses |
| Service | Contains business logic |
| Mapper | Converts Entity ↔ DTO |
| Repository | Performs database operations using Spring Data JPA |
| Database | Stores employee information |

## 🔄 Request Flow

```text
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Mapper
   │
   ▼
Repository
   │
   ▼
MySQL Database
   │
   ▲
Repository
   │
   ▲
Mapper
   │
   ▲
Service
   │
   ▲
Controller
   │
   ▲
Client
```

## 📚 Concepts Demonstrated

- Layered Architecture
- RESTful API Design
- DTO Pattern
- Mapper Pattern
- Dependency Injection
- Bean Validation
- Global Exception Handling
- Structured Error Responses
- Logging using SLF4J
- Pagination
- Sorting
- Batch Processing
- Spring Profiles
- OpenAPI / Swagger Documentation
- Spring Data JPA

## 📂 Project Structure

```text
employee-management-api
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.posakarthik.employeemanagement
│   │   │       ├── config
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── exception
│   │   │       ├── mapper
│   │   │       ├── repository
│   │   │       ├── response
│   │   │       ├── service
│   │   │       └── EmployeeManagementApiApplication.java
│   │   │
│   │   └── resources
│   │       ├── application.yml
│   │       ├── application-dev.yml
│   │       └── application-prod.yml
│   │
│   └── test
│
├── pom.xml
└── README.md
```

## 🌐 REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/employees` | Create a new employee |
| GET | `/api/employees/{id}` | Get employee by ID |
| GET | `/api/employees` | Get all employees |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |
| GET | `/api/employees/department/{department}` | Search by department |
| GET | `/api/employees/name/{name}` | Search by employee name |
| GET | `/api/employees/salary/{salary}` | Search employees with salary greater than the given amount |
| POST | `/api/employees/batch` | Create multiple employees |
| GET | `/api/employees/bypaginationandsorting` | Get employees with pagination and sorting |

## 📄 Pagination & Sorting Parameters

| Parameter | Description | Default |
|-----------|-------------|---------|
| pageNumber | Page number (starts from 0) | 0 |
| pageSize | Number of records per page | 5 |
| direction | Sort direction (ASC/DESC) | ASC |
| sortBy | Field name for sorting | employeeId |

## ⚠️ Validation

The application validates incoming request data using **Jakarta Bean Validation**.

### Example Validations

- Employee Name is required.
- Employee Email must be valid.
- Employee Salary must be greater than zero.
- Employee Department is required.

Validation is automatically performed using the `@Valid` annotation.

## 🚨 Error Response

### Employee Not Found (404)

```json
{
  "message": "Employee not found with id : 5",
  "status": 404,
  "error": "Not Found",
  "path": "/api/employees/5",
  "timestamp": "2026-07-09T18:30:25"
}
```

### Validation Failed (400)

```json
{
  "message": "Validation Failed",
  "status": 400,
  "error": "Bad Request",
  "path": "/api/employees",
  "timestamp": "2026-07-09T18:30:25",
  "fieldErrors": [
    {
      "field": "employeeEmail",
      "message": "Employee email should be valid"
    },
    {
      "field": "employeeName",
      "message": "Employee name is required"
    }
  ]
}
```

## 📸 Swagger Documentation

Swagger UI is available at:

```text
http://localhost:7070/swagger-ui/index.html
```

After deployment, this section will be updated with the live Swagger URL.

> **Screenshot:** *(Add a screenshot after deployment.)*

## 🗄️ Database

The application uses **MySQL** as the relational database.

### Employee Table

| Column | Type |
|---------|------|
| employee_id | BIGINT |
| employee_name | VARCHAR |
| employee_email | VARCHAR |
| employee_salary | DOUBLE |
| employee_department | VARCHAR |

## 📊 Logging

The application uses **SLF4J** for logging.

Logs are maintained for:

- Service layer operations
- Business events
- Exception handling
- Validation failures

Log levels:

- INFO
- DEBUG
- ERROR

## ⚙️ Installation

### Clone the Repository

```bash
git clone https://github.com/<your-github-username>/employee-management-api.git
```

### Navigate to the Project

```bash
cd employee-management-api
```

## 🛠️ Configure Database

Update your database configuration in `application-dev.yml`.

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/employeems
    username: your_username
    password: your_password
```

Create the MySQL database before running the application.

```sql
CREATE DATABASE employeems;
```

## ▶️ Running the Application

Run the application using Maven:

```bash
mvn spring-boot:run
```

Or build and run the JAR:

```bash
mvn clean package

java -jar target/employee-management-api-0.0.1-SNAPSHOT.jar
```

The application will start on:

```text
http://localhost:7070
```

## 🧪 API Documentation

Once the application is running, access the Swagger UI:

```text
http://localhost:7070/swagger-ui/index.html
```

OpenAPI JSON:

```text
http://localhost:7070/v3/api-docs
```

## 📝 Sample Request

### Create Employee

```http
POST /api/employees
Content-Type: application/json
```

```json
{
  "employeeName": "Karthik",
  "employeeEmail": "karthik@gmail.com",
  "employeeSalary": 50000,
  "employeeDepartment": "IT"
}
```

## ✅ Sample Response

```json
{
  "employeeId": 1,
  "employeeName": "Karthik",
  "employeeEmail": "karthik@gmail.com",
  "employeeSalary": 50000,
  "employeeDepartment": "IT"
}
```

## 🚀 Future Enhancements

- 🔐 Spring Security with JWT Authentication
- 👥 Role-Based Authorization (Admin/User)
- 🧪 Unit & Integration Testing (JUnit & Mockito)
- 🐳 Docker & Docker Compose
- ☁️ Cloud Deployment
- ⚡ Redis Caching
- 📩 Kafka Integration
- 🌐 Microservices Architecture

## 👨‍💻 Author

**Posa Karthik**

- GitHub: https://github.com/PosaKarthik
- LinkedIn: https://www.linkedin.com/in/posa-karthik-225353408/

Feel free to connect with me and provide feedback on the project.


## 📄 License

This project is created for learning and portfolio purposes.
