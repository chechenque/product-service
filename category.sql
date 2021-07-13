-- DROP TABLE IF EXISTS category;
CREATE DATABASE  IF NOT EXISTS `product-service` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `product-service`;
-- Drop DATABASE `product-service`;
CREATE TABLE category(
	id INT,
    categoria VARCHAR(100)
);

INSERT INTO category VALUES(1,'Farmacia');
INSERT INTO category VALUES(2,'Bebidas');
CALL st_create_category('Farmagasa');
SELECT * FROM category;