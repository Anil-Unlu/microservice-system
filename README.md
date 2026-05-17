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

### 4. Eureka Server (port: 8761)
- Service discovery and registration
- All services register themselves on startup

### 5. API Gateway (port: 8085)
- Single entry point for all requests
- Routes requests to appropriate services via Eureka

## Architecture
Client → API Gateway (8085)
↓
Eureka Server (8761)
↙      ↓       ↘
User Service  Order Service  Product Service

## Technologies
- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- Spring Cloud OpenFeign
- Spring Cloud Netflix Eureka
- Spring Cloud Gateway
- PostgreSQL
- Lombok
- Maven

## How to Run
1. Start PostgreSQL
2. Create databases: `userdb`, `orderdb`, `productdb`
3. Run services in order:
   - Eureka Server
   - User Service
   - Product Service
   - Order Service
   - API Gateway

## Notes
This project is for learning microservices architecture with service discovery and API gateway patterns.