CREATE TABLE IF NOT EXISTS customer
(
    id           SERIAL PRIMARY KEY,
    first_name   VARCHAR(255) NOT NULL,
    last_name    VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL,

    phone_number VARCHAR(255) NOT NULL,
    fk_address_id      INTEGER NOT NULL,

    CONSTRAINT fk_address
        FOREIGN KEY (fk_address_id)
            REFERENCES address (address_id)
);

