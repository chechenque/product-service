-- DROP TABLE IF EXISTS product;
USE `product-service`;
CREATE TABLE product(
	id INT,
    codigo CHAR(13),
    producto VARCHAR(100),
    descripcion VARCHAR(255),
	precio FLOAT,
	cantidad INT,
	fecha_creacion DATE,
	id_categoria INT
);

DROP PROCEDURE st_create_product;
INSERT INTO product VALUES(1,'7501055311453','Paracetamol 500mg','Paracetamol 500mg, 20 tabletas',20.00,100,CURRENT_DATE(),1);
INSERT INTO product VALUES(2,'7898917592649','Coca-Cola 600ml','Coca-Cola 600ml, no retornable',15.00,500,CURRENT_DATE(),2);

SELECT * FROM product;