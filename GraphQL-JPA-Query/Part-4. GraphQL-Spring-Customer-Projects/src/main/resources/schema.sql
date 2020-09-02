CREATE TABLE customers (
    id INTEGER  NOT NULL  AUTO_INCREMENT,
    name VARCHAR (128) NOT NULL,
    email VARCHAR (128) NOT NULL,
    PRIMARY Key (id)
);

CREATE TABLE products (

    id INTEGER NOT NUll AUTO_INCREMENT,
    name VARCHAR (128) NOT NULL ,
    description VARCHAR (256) NOT NULL ,
    price DOUBLE NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE orders (
    id INTEGER NOT NULL Auto_Increment,
    customer_id INTEGER NOT NULL ,
    product_id INTEGER NOT NULL ,
    quantity INTEGER NOT NULL ,
    status VARCHAR (20) NoT NULL ,
    create TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    PRIMARY  KEY (id)
);