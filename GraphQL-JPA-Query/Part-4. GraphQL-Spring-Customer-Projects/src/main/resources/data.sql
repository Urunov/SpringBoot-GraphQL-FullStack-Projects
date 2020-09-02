
INSERT INTO customers (id, name, email) VALUES (1, 'Adam S', 'adam.s@gmail.com');
INSERT INTO customers (id, name, email) VALUES (2, 'Ana T', 'ana.t@gmail.com');


INSERT INTO products (id, name, description, price) VALUES (100, 'iPhone X', 'Apple iPhone X', 1299.99);
INSERT INTO products (id, name, description, price) VALUES (101, 'Galaxy S10', 'Apple iPhone', 1099.99);
INSERT INTO products (id, name, description, price) VALUES (102, 'Pixel 3a', 'Apple iPhone', 999.99);
INSERT INTO products (id, name, description, price) VALUES (103, 'Huawei P30', 'Apple iPhone', 899.99);
INSERT INTO products (id, name, description, price) VALUES (104, 'LG Q7', 'Apple iPhone', 1099.99);
INSERT INTO products (id, name, description, price) VALUES (105, 'Razer Phone 2', 'Apple iPhone', 899.99);
INSERT INTO products (id, name, description, price) VALUES (106, 'Oppo Reno 10x', 'Apple iPhone', 1099.99);


INSERT INTO orders (customer_id, product_id, quantity, status) VALUES(1, 100, 1, 'PENDING');
INSERT INTO orders (customer_id, product_id, quantity, status) VALUES(1, 103, 2, 'PENDING');
INSERT INTO orders (customer_id, product_id, quantity, status) VALUES(1, 105, 1, 'DELIVERED');

INSERT INTO orders (customer_id, product_id, quantity, status) VALUES(2, 105, 1, 'PENDING');
INSERT INTO orders (customer_id, product_id, quantity, status) VALUES(2, 102, 1, 'CANCELLED');
INSERT INTO orders (customer_id, product_id, quantity, status) VALUES(2, 106, 1, 'DELIVERED');