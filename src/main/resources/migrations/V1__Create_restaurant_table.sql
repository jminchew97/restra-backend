CREATE TABLE restaurant
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR,
    address    VARCHAR,
    food_type  varchar,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO restaurant (name, address,food_type)
VALUES ('Best Dim Sum', '123 da street', 'dim sum');

INSERT INTO restaurant (name, address,food_type)
VALUES ('Burger Palace', '123 westore ave', 'american');