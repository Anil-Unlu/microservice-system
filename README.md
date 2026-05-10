# Microservices System

This project is a simple microservices architecture built with Spring Boot.

It contains two services:

## Services

### 1. User Service
- Manages user data
- Exposes REST APIs for user operations
- PostgreSQL database integration

### 2. Order Service
- Manages orders
- Communicates with User Service using OpenFeign
- Retrieves user information while processing orders

## Architecture

User Service  ←→  Order Service  
(communication via OpenFeign)

## Technologies

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Cloud OpenFeign
- PostgreSQL
- Maven

## How to Run

1. Start PostgreSQL
2. Run User Service
3. Run Order Service

Default ports:
- User Service: 8080
- Order Service: 8081

## Notes

This project is for learning microservices architecture and service-to-service communication.
