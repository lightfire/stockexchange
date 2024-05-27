
# Stock Exchange Management Application

This is a Java-based backend application using the Spring framework to manage a stock exchange system. The application includes functionality to manage stock exchanges and stocks, and provides several REST endpoints for interacting with the system.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Getting Started](#getting-started)
5. [Building and Running the Application](#building-and-running-the-application)
6. [API Endpoints](#api-endpoints)
7. [Security](#security)
8. [Database Initialization](#database-initialization)
9. [Future Enhancements](#future-enhancements)
10. [Contributing](#contributing)
11. [License](#license)

## Project Overview

The Stock Exchange Management Application provides an API to manage stock exchanges and stocks. Each stock exchange can have multiple stocks, and stocks can be listed on multiple exchanges. Stock exchanges with fewer than 5 stocks cannot be live in the market.

## Features

- List a stock exchange with all its stocks
- Create a new stock
- Add a stock to a stock exchange
- Delete a stock from a stock exchange
- Update the price of a stock
- Delete a stock from the system

## Technologies Used

- Java 17
- Spring Boot 2.6.6
- Spring Data JPA
- Spring Security
- H2 Database
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.0 or higher

### Clone the Repository

```sh
git clone https://github.com/lightfire/stockexchange.git
cd stockexchange
```

## Building and Running the Application

### Build the Application

```sh
mvn clean install
```

### Run the Application

```sh
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Endpoints

### List one stock exchange with all its stocks

- **URL:** `/api/v1/stock-exchange/{name}`
- **Method:** `GET`
- **Description:** Retrieve a stock exchange by its name along with all its stocks.

### Create a new stock

- **URL:** `/api/v1/stock`
- **Method:** `POST`
- **Description:** Create a new stock.

### Add a stock to a stock exchange

- **URL:** `/api/v1/stock-exchange/{name}`
- **Method:** `POST`
- **Description:** Add a stock to a stock exchange.

### Delete a stock from a stock exchange

- **URL:** `/api/v1/stock-exchange/{name}`
- **Method:** `DELETE`
- **Description:** Delete a stock from a stock exchange.

### Update the price of a stock

- **URL:** `/api/v1/stock`
- **Method:** `PUT`
- **Description:** Update the price of a stock.

### Delete a stock from the system

- **URL:** `/api/v1/stock`
- **Method:** `DELETE`
- **Description:** Delete a stock from the system.

## Security

The application uses basic authentication for securing the endpoints. The default user credentials are:

- **Username:** `user`
- **Password:** `password`

## Database Initialization

The application uses an H2 in-memory database. The database schema and some initial data are loaded from the `src/main/resources/data.sql` file.

### Sample Data

```sql
-- Insert into stock table
INSERT INTO stock (name, description, current_price, last_update) VALUES
                                                                      ('Stock A', 'Description for Stock A', 100.00, CURRENT_TIMESTAMP),
                                                                      ('Stock B', 'Description for Stock B', 150.50, CURRENT_TIMESTAMP),
                                                                      ('Stock C', 'Description for Stock C', 200.75, CURRENT_TIMESTAMP),
                                                                      ('Stock D', 'Description for Stock D', 250.25, CURRENT_TIMESTAMP),
                                                                      ('Stock E', 'Description for Stock E', 300.00, CURRENT_TIMESTAMP),
                                                                      ('Stock F', 'Description for Stock F', 350.00, CURRENT_TIMESTAMP);

-- Insert into stock_exchange table
INSERT INTO stock_exchange (name, description, live_in_market) VALUES
                                                                   ('Exchange 1', 'Description for Exchange 1', TRUE),
                                                                   ('Exchange 2', 'Description for Exchange 2', TRUE),
                                                                   ('Exchange 3', 'Description for Exchange 3', TRUE),
                                                                   ('Exchange 4', 'Description for Exchange 4', TRUE),
                                                                   ('Exchange 5', 'Description for Exchange 5', TRUE),
                                                                   ('Exchange 6', 'Description for Exchange 6', TRUE),
                                                                   ('Exchange 7', 'Description for Exchange 7', FALSE),
                                                                   ('Exchange 8', 'Description for Exchange 8', FALSE),
                                                                   ('Exchange 9', 'Description for Exchange 9', FALSE),
                                                                   ('Exchange 10', 'Description for Exchange 10', FALSE);

-- Insert into stock_exchange_stock table to establish relationships
-- Stock A associated with 5 exchanges
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id) VALUES
                                                                   (1, 1),
                                                                   (2, 1),
                                                                   (3, 1),
                                                                   (4, 1),
                                                                   (5, 1);

-- Stock B associated with 4 exchanges (should not be live in market)
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id) VALUES
                                                                   (1, 2),
                                                                   (2, 2),
                                                                   (3, 2),
                                                                   (4, 2);

-- Stock C associated with 6 exchanges
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id) VALUES
                                                                   (1, 3),
                                                                   (2, 3),
                                                                   (3, 3),
                                                                   (4, 3),
                                                                   (5, 3),
                                                                   (6, 3);

-- Stock D associated with 5 exchanges
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id) VALUES
                                                                   (1, 4),
                                                                   (2, 4),
                                                                   (3, 4),
                                                                   (4, 4),
                                                                   (5, 4);

-- Stock E associated with 3 exchanges (should not be live in market)
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id) VALUES
                                                                   (1, 5),
                                                                   (2, 5),
                                                                   (3, 5);

-- Stock F associated with 7 exchanges
INSERT INTO stock_exchange_stock (stock_exchange_id, stock_id) VALUES
                                                                   (1, 6),
                                                                   (2, 6),
                                                                   (3, 6),
                                                                   (4, 6),
                                                                   (5, 6),
                                                                   (6, 6),
                                                                   (7, 6);
```

## Future Enhancements

- Add role-based access control to the endpoints
- Implement more comprehensive error handling and validation
- Enhance the API documentation using Swagger or a similar tool
- Add unit and integration tests

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes. Make sure to follow the existing code style and include tests for any new functionality.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
