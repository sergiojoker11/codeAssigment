CREATE TABLE Product (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
    name VARCHAR(50) NOT NULL,
    priceInPounds REAL,
    offerApplied BIT,
    priceRate REAL,
    PRIMARY KEY (id),
    UNIQUE (name));


INSERT INTO Product VALUES(1, 'Soup', 0.65, 0, 100);
INSERT INTO Product VALUES(2, 'Bread', 0.80, 0, 100);
INSERT INTO Product VALUES(3, 'Milk', 1.30, 0, 100);
INSERT INTO Product VALUES(4, 'Apples', 1, 0, 100);
