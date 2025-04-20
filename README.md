# Retail Management System
A Spring Boot application for managing retail operations including customers, products, suppliers, and payments. Built for Nigerian businesses to streamline their inventory and sales processes.


## Overview

This retail management system provides a web interface for tracking products, managing customer information, handling supplier relationships, and recording payment transactions. The application is built using:
1. Spring Boot for the backend

2. Spring Data JPA for database interactions

3. Thymeleaf for frontend templating

4. Bootstrap for responsive design


## Features

1. Customer management
2. Product inventory tracking
3. Supplier management
4. Payment processing and history


## Entity Relationships

Here's how these entities interact with each other:

**Customers**:

1. Purchase products
2. Make payments for their purchases
3. Have a one-to-many relationship with payments

**Products**:

1. Are purchased by customers
2. Are supplied by suppliers
3. Have a many-to-one relationship with suppliers
4. Have a many-to-many relationship with customers (through orders/purchases)

**Suppliers**:

1. Supply products
2. Have a one-to-many relationship with products

**Payments**:

1. Are made by customers
2. Are associated with purchases/orders
3. Have a many-to-one relationship with customers

## Prerequisites
Before running this application, ensure you have the following installed:

1. Java 11 or higher
2. Maven 3.6.3 or higher
3. MySQL 8.0 or another compatible database

## Getting Started
Follow these steps to set up and run the application locally:

**1. Clone the Repository**
bash

git clone https://github.com/YOUR_USERNAME/retail-management-system.git
cd retail-management-system
2. Configure Database
Create a database for the application:
sqlCREATE DATABASE retail_management;
Update src/main/resources/application.properties with your database credentials:
propertiesspring.datasource.url=jdbc:mysql://localhost:3306/retail_management
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
3. Build and Run the Application
Use Maven to build and run the application:
bashmvn clean install
mvn spring-boot:run
4. Access the Application
Open your browser and navigate to:
http://localhost:8080
Troubleshooting
Customer and Supplier Data Not Loading
If you encounter the "Failed to load customer data" or "Failed to load supplier data" errors:

Check that the database tables are properly created:

Check that Customer and Supplier tables exist in your database
Verify table structure matches the entity definitions


Add sample data to the database:
sqlINSERT INTO customer (name, email, phone) VALUES ('John Doe', 'john@example.com', '1234567890');
INSERT INTO supplier (name, contact, phone) VALUES ('ABC Suppliers', 'contact@abc.com', '0987654321');

Verify service implementations:

Ensure CustomerService and SupplierService are properly implemented
Check that these services are correctly autowired in their respective controllers


Check application logs for errors
