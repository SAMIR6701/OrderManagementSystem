# Order Management System
 
A secure and scalable RESTful Order Management System built using Spring Boot. This application enables efficient order processing through CRUD operations, JWT-based authentication, role-based access control, validation, exception handling, and API documentation using Swagger.
 
---
 
## 🚀 Features
 
### Authentication & Authorization
- JWT Authentication
- Spring Security Integration
- Role-Based Access Control (RBAC)
- ADMIN and USER Roles
 
### Order Management
- Create New Orders
- Retrieve All Orders
- Retrieve Order by ID
- Update Existing Orders
- Delete Orders
 
### Validation & Exception Handling
- Request Validation using Jakarta Validation
- Global Exception Handling
- Custom Error Responses
- Resource Not Found Handling
 
### API Documentation
- Swagger/OpenAPI Integration
- Interactive API Testing Interface
 
### Database Integration
- Spring Data JPA
- Hibernate ORM
- H2 Database Support
- MySQL Ready
 
---
 
## 🛠 Tech Stack
 
| Technology | Version |
|------------|-----------|
| Java | 21 |
| Spring Boot | 3.x |
| Spring Security | 6.x |
| Spring Data JPA | Latest |
| Hibernate | Latest |
| JWT | Latest |
| Maven | Latest |
| H2 Database | Latest |
| Swagger OpenAPI | Latest |
 
---
 
## 📁 Project Structure
 
```plaintext
src/main/java/com/example/demo
 
├── config
│   ├── SecurityConfig.java
│   └── SwaggerConfig.java
│
├── controller
│   ├── AuthController.java
│   └── OrderController.java
│
├── dto
│   ├── LoginRequest.java
│   ├── OrderRequestDTO.java
│   └── OrderResponseDTO.java
│
├── entity
│   ├── Order.java
│   ├── OrderStatus.java
│   └── User.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
│
├── repository
│   ├── OrderRepository.java
│   └── UserRepository.java
│
├── security
│   ├── JwtFilter.java
│   ├── JwtUtil.java
│   └── CustomerUserDetailsService.java
│
├── service
│   ├── OrderService.java
│   └── OrderServiceImpl.java
│
└── OrderManagementSystemApplication.java
```
 
---
 
## 🔄 Order Lifecycle
 
```plaintext
CREATED
   │
   ▼
CONFIRMED
   │
   ▼
PROCESSING
   │
   ▼
SHIPPED
   │
   ▼
DELIVERED
 
OR
 
CANCELLED
```
 
---
 
## 🔐 Security Roles
 
### ADMIN
- Create Orders
- Update Orders
- Delete Orders
- View Orders
 
### USER
- View Orders Only
 
---
 
## 📌 REST API Endpoints
 
### Authentication
 
| Method | Endpoint | Description |
|----------|----------|-------------|
| POST | /auth/login | Generate JWT Token |
 
### Orders
 
| Method | Endpoint | Description |
|----------|----------|-------------|
| POST | /orders | Create Order |
| GET | /orders | Get All Orders |
| GET | /orders/{id} | Get Order By ID |
| PUT | /orders/{id} | Update Order |
| DELETE | /orders/{id} | Delete Order |
 
---
 
## ▶️ Running the Application
 
### Clone Repository
 
```bash
git clone <repository-url>
```
 
### Build Project
 
```bash
mvn clean install
```
 
### Run Application
 
```bash
mvn spring-boot:run
```
 
---
 
## 📖 Swagger Documentation
 
```plaintext
http://localhost:8004/swagger-ui/index.html
```
 
---
 
## 💾 H2 Database Console
 
```plaintext
http://localhost:8004/h2-console
```
 
---
 
## 🔑 Sample Login Request
 
```json
{
  "username": "admin",
  "password": "password"
}
```
 
---
 
## 🎯 Key Concepts Implemented
 
- RESTful API Design
- Layered Architecture
- DTO Pattern
- JWT Authentication
- Role-Based Access Control
- Validation Framework
- Exception Handling
- Swagger Documentation
- Spring Security
- JPA & Hibernate
 
---
 
## 🚀 Future Enhancements
 
- Pagination & Sorting
- Search & Filtering
- Audit Logging
- Docker Support
- Email Notifications
- Unit Testing with JUnit & Mockito
- Deployment on AWS/Render
- Microservices Architecture
 
---
 
## 👨‍💻 Author
 
**Samir Shaikh**
 
Backend Developer | Java | Spring Boot | Spring Security | REST APIs
