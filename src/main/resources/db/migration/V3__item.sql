CREATE TABLE IF NOT EXISTS item
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    description  VARCHAR(255) NOT NULL,
    price        NUMERIC NOT NULL,
    stock_amount INT DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS eurder
(
    id SERIAL PRIMARY KEY,
    id_customer INT DEFAULT NULL,
    CONSTRAINT id_customer FOREIGN KEY (id_customer) REFERENCES customer(id),
    eurder_date TIMESTAMP NOT NULL,
    total_price FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS eurder_item_group
(
    id SERIAL PRIMARY KEY,
    amount INT DEFAULT NULL,
    shipping_date TIMESTAMP NOT NULL,
    id_item INT DEFAULT NULL,
    CONSTRAINT id_item FOREIGN KEY (id_item) REFERENCES item(id),
    id_eurder INT DEFAULT NULL,
    CONSTRAINT id_eurder FOREIGN KEY (id_eurder) REFERENCES eurder(id)
);
