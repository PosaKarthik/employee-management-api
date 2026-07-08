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

- 
