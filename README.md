# Microservice System

A microservices architecture built with Spring Boot.

## Services

### 1. User Service (port: 8080)
- User CRUD operations
- Validation & exception handling
- PostgreSQL integration

### 2. Order Service (port: 8081)
- Order management
- Communicates with User Service and Product Service via OpenFeign
- PostgreSQL integration

### 3. Product Service (port: 8082)
- Product CRUD operations
- Stock management (reduce stock on order)
- Exception handling
- PostgreSQL integration

## Architecture
User Service ←── Order Service ──→ Product Service

## Technologies
- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- Spring Cloud OpenFeign
- PostgreSQL
- Lombok
- Maven

## How to Run
1. Start PostgreSQL
2. Create databases: `userdb`, `orderdb`, `productdb`
3. Run services in order:
   - User Service
   - Product Service
   - Order Service

## Notes
This project is for learning microservices architecture and service-to-service communication.
