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