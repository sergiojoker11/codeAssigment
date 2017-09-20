CREATE TABLE DiscountToApply (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
    productId1 BIGINT,
    productId2 BIGINT,
    productId3 BIGINT,
    productId4 BIGINT,
    productId5 BIGINT,
    primary key (id));

CREATE TABLE DiscountApplied (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
    productId1 BIGINT,
    productRate1 REAL,
    productId2 BIGINT,
    productRate2 REAL,
    productId3 BIGINT,
    productRate3 REAL,
    productId4 BIGINT,
    productRate4 REAL,
    productId5 BIGINT,
    productRate5 REAL,
    primary key (id));

CREATE TABLE Discount (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
    discountToApplyId BIGINT,
    discountAppliedId BIGINT,
    PRIMARY KEY (id));

-- Offer 1
INSERT INTO DiscountToApply VALUES(1, 4, NULL, NULL, NULL, NULL);
INSERT INTO DiscountApplied VALUES(1, 4, 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO Discount VALUES(1, 1, 1);

-- Offer 2
INSERT INTO DiscountToApply VALUES(2, 1, 1, NULL, NULL, NULL);
INSERT INTO DiscountApplied VALUES(2, 1, 100, 1, 100, 2, 50, NULL, NULL, NULL, NULL);
INSERT INTO Discount VALUES(2, 2, 2);

SELECT * FROM DiscountToApply;
SELECT * FROM DiscountApplied;
