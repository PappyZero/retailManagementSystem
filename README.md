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
```
git clone https://github.com/PappyZero/helloWorldApplication.git
cd retail-management-system
```

**2. Configure Database**
Create a database for the application:

sql
```
CREATE DATABASE retail_management;
```

Update "src/main/resources/application.properties" with your database credentials:

properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/retail_management
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

**3. Build and Run the Application**
Use Maven to build and run the application:

bash
```
mvn clean install
mvn spring-boot:run
```

**4. Access the Application**
Open your browser and navigate to:

"http://localhost:8080"

## Troubleshooting

Customer and Supplier Data Not Loading
If you encounter the "Failed to load customer data" or "Failed to load supplier data" errors:

1. Check that the database tables are properly created:
     1. Check that Customer and Supplier tables exist in your database
     2. Verify table structure matches the entity definitions

2. Add sample data to the database:
   
sql
```
INSERT INTO customer (name, email, phone) VALUES ('John Doe', 'john@example.com', '1234567890');
INSERT INTO supplier (name, contact, phone) VALUES ('ABC Suppliers', 'contact@abc.com', '0987654321');
```

3. Verify service implementations:
     1. Ensure CustomerService and SupplierService are properly implemented
     2. Check that these services are correctly autowired in their respective controllers

4. Check application logs for errors

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── helloWorldApplication/
│   │               ├── controller/       # REST controllers
│   │               ├── model/            # Entity classes
│   │               ├── repository/       # JPA repositories
│   │               ├── service/          # Business logic
│   │               └── HelloWorldApplication.java  # Main class
│   └── resources/
│       ├── static/   # CSS, JS files
│       ├── templates/ # Thymeleaf templates
│       └── application.properties
└── test/
```

## API Endpoints
**Customers**

1. GET /api/customers - Get all customers
2. GET /api/customers/{id} - Get customer by ID
3. POST /api/customers - Create a new customer
4. PUT /api/customers/{id} - Update a customer
5. DELETE /api/customers/{id} - Delete a customer

**Suppliers**

1. GET /api/suppliers - Get all suppliers
2. GET /api/suppliers/{id} - Get supplier by ID
3. POST /api/suppliers - Create a new supplier
4. PUT /api/suppliers/{id} - Update a supplier
5. DELETE /api/suppliers/{id} - Delete a supplier

**Products**

1. GET /api/products - Get all products
2. GET /api/products/{id} - Get product by ID
3. POST /api/products - Create a new product
4. PUT /api/products/{id} - Update a product
5. DELETE /api/products/{id} - Delete a product

**Payments**

1. GET /api/payments - Get all payments
2. GET /api/payments/{id} - Get payment by ID
3. POST /api/payments - Create a new payment
4. PUT /api/payments/{id} - Update a payment
5. DELETE /api/payments/{id} - Delete a payment

## Contributing

1. Fork the repository
2. Create your feature branch (git checkout -b feature/amazing-feature)
3. Commit your changes (git commit -m 'Added some amazing feature')
4. Push to the branch (git push origin feature/amazing-feature)
5. Open a Pull Request

## License
This project is licensed under the MIT License - see the LICENSE file for details.
