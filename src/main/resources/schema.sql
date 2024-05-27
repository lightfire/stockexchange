CREATE TABLE IF NOT EXISTS stock (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       description VARCHAR(255),
                       current_price DECIMAL(15, 2),
                       last_update TIMESTAMP
);

CREATE TABLE IF NOT EXISTS stock_exchange (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                name VARCHAR(255) NOT NULL,
                                description VARCHAR(255),
                                live_in_market BOOLEAN
);

CREATE TABLE IF NOT EXISTS stock_exchange_stock (
                                      stock_exchange_id BIGINT NOT NULL,
                                      stock_id BIGINT NOT NULL,
                                      FOREIGN KEY (stock_exchange_id) REFERENCES stock_exchange(id),
                                      FOREIGN KEY (stock_id) REFERENCES stock(id),
                                      PRIMARY KEY (stock_exchange_id, stock_id)
);