PACER Judiciary Information System (JIS) - Backend

Welcome to the backend repository of the Judiciary Information System (JIS)! 
This repository handles the core logic and data management of the Judiciary Information System, which streamlines the management of court cases, 
hearing schedules, and user roles for registrars, lawyers, and judges.

✨ Project Overview
The backend application is built using Spring Boot, ensuring a robust, scalable, and secure architecture. 
It provides RESTful APIs for the frontend to interact with, managing data and enforcing business logic. The backend also integrates authentication and role-based access control to provide a secure experience for all users.

🛠️ Technologies and Skills Used
Backend Framework
Spring Boot: Provides a lightweight and efficient framework for building microservices with embedded server support.
Database Management
MySQL: A reliable relational database used to store and manage case and user data efficiently.
Spring Data JPA: Simplifies database operations with powerful repository abstractions.
Security
Spring Security: Implements authentication and authorization, supporting role-based access control (Registrar, Judge, Lawyer).
JWT (JSON Web Tokens): Secures API endpoints with stateless authentication.
API Development
RESTful APIs: Enables seamless interaction between the frontend and backend.
Validation: Ensures data integrity using Hibernate Validator annotations.
File Handling
Handles binary file uploads (e.g., user photos or case documents) as byte arrays for secure and efficient storage.
Logging
Spring Boot Logging: Provides effective logging for debugging and monitoring.
Version Control and Collaboration

Git & GitHub: Ensures version tracking and team collaboration for backend development.
⚙️ Specifications
Core Features
Case Management:

Create, update, and retrieve court case details.
Assign hearing dates and manage adjournments with reasons.
Record court proceedings and judgment summaries.
Automatically generate unique Case Identification Numbers (CIN).
User Management:

Create and delete user accounts (Registrar, Judge, Lawyer).
Enforce role-based access control for API endpoints.
Data Querying:

Query pending cases sorted by CIN.
Fetch resolved cases within a given time period.
Retrieve upcoming hearings for a specific date.
View the status of any case using its CIN.
Historical Case Access:

Enable keyword-based search for past cases.
Track and charge lawyers for accessing historical case data.
