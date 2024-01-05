CREATE TABLE IF NOT EXISTS admin
(
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL ,
    password VARCHAR(255) NOT NULL
);

INSERT INTO admin(email, password)
VALUES
    ('admin@eurder.com', 'admin');

