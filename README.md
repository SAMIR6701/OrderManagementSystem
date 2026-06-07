🚀 Order Management System
A secure and scalable Order Management System built using Spring Boot that enables efficient order processing through authentication, authorization, workflow management, pagination, sorting, search, filtering, validation, and exception handling.
This project demonstrates modern backend development practices and follows a clean layered architecture for maintainability and scalability.
✨ Features
🔐 Authentication & Authorization
JWT Authentication
Spring Security Integration
Role-Based Access Control (RBAC)
ADMIN and USER Roles
BCrypt Password Encryption
📦 Order Management
Create Orders
Retrieve Orders
Update Orders
Delete Orders
Order Status Management
🔄 Order Workflow
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
✅ Status Transition Validation
Current StatusAllowed Next StatusCREATEDCONFIRMED, CANCELLEDCONFIRMEDPROCESSING, CANCELLEDPROCESSINGSHIPPEDSHIPPEDDELIVERED
Invalid transitions are automatically blocked.
📄 Pagination
Retrieve large datasets efficiently.
Example:
GET /orders/paged?page=0&size=5
Benefits
Faster response times
Better performance
Reduced memory consumption
🔀 Sorting
Sort records dynamically.
Example:
GET /orders/paged?page=0&size=5&sortBy=id
Supported sorting on:
Order ID
Customer Name
Product Name
Status
Created Date
🔍 Search & Filtering APIs
Search orders using different criteria.
Search by Status
GET /orders/status/DELIVERED
Search by Customer
GET /orders/customer/samir
Search by Product
GET /orders/product/laptop
Benefits
Faster order lookup
Flexible filtering
Improved user experience
Production-ready querying
⚠️ Validation & Exception Handling
Jakarta Bean Validation
Global Exception Handler
Custom Error Responses
Resource Not Found Handling
Invalid Status Transition Handling
📖 Swagger/OpenAPI Documentation
Interactive API documentation with built-in testing support.
Swagger UI:
http://localhost:8004/swagger-ui/index.html
🗄 Database
Spring Data JPA
Hibernate ORM
H2 Database
MySQL Ready
🏗 Project Architecture
Client
   │
   ▼
Controller Layer
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
Database
📁 Project Structure
PackageResponsibilityconfigSecurity & Application ConfigurationcontrollerREST API EndpointsserviceBusiness Logicservice.implService ImplementationsrepositoryDatabase Access LayerentityJPA EntitiesdtoRequest & Response ObjectssecurityAuthentication & AuthorizationexceptionGlobal Exception HandlingutilUtility Classes
📌 API Endpoints
Authentication
MethodEndpointDescriptionPOST/auth/loginGenerate JWT Token
Orders
MethodEndpointDescriptionPOST/ordersCreate OrderGET/ordersGet All OrdersGET/orders/{id}Get Order By IDPUT/orders/{id}Update OrderDELETE/orders/{id}Delete OrderPATCH/orders/{id}/statusUpdate Order StatusGET/orders/pagedPagination & SortingGET/orders/status/{status}Search by StatusGET/orders/customer/{customerName}Search by CustomerGET/orders/product/{productName}Search by Product
🛠 Technology Stack
TechnologyVersionJava21Spring Boot3.xSpring Security6.xSpring Data JPALatestHibernateLatestJWTLatestMavenLatestH2 DatabaseLatestSwagger/OpenAPILatest
🚀 Running the Application
Clone Repository
git clone <repository-url>
Build Project
mvn clean install
Run Application
mvn spring-boot:run
💾 H2 Database Console
http://localhost:8004/h2-console
🔑 Sample Login Request
{
  "username": "admin",
  "password": "password"
}
🎯 Key Concepts Implemented
RESTful API Design
Layered Architecture
DTO Pattern
JWT Authentication
Spring Security
Role-Based Access Control (RBAC)
Order Workflow Management
Status Transition Validation
Pagination
Sorting
Search & Filtering APIs
Validation Framework
Global Exception Handling
Swagger/OpenAPI
JPA & Hibernate
🔮 Future Enhancements
Audit Fields
Dashboard & Analytics APIs
Unit Testing (JUnit & Mockito)
Docker Support
Email Notifications
MySQL Migration
Cloud Deployment
CI/CD Pipeline
👨‍💻 Author
Samir Shaikh
Java Backend Developer | Spring Boot | Spring Security | REST APIs | JPA/Hibernate | JWT Authentication
 
 
