Entity Relationships

Here's how these entities interact with each other:

Customers:

Purchase products

Make payments for their purchases

Have a one-to-many relationship with payments

Products:

Are purchased by customers

Are supplied by suppliers

Have a many-to-one relationship with suppliers

Have a many-to-many relationship with customers (through orders/purchases)

Suppliers:

Supply products

Have a one-to-many relationship with products

Payments:

Are made by customers

Are associated with purchases/orders

Have a many-to-one relationship with customers

