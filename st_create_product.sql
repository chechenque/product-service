-- SQLINES LICENSE FOR EVALUATION USE ONLY
DELIMITER //

CREATE PROCEDURE st_create_product(
							p_codigo CHAR(13),
							p_producto VARCHAR(100),
							p_descripcion VARCHAR(255),
							p_precio DOUBLE,
							p_cantidad INT,
							p_id_categoria INT)

BEGIN
DECLARE
	v_size INT DEFAULT 0;
	DECLARE v_count INT DEFAULT 1;

-- SQLINES DEMO *** ista el código del producto
IF EXISTS (SELECT codigo FROM product WHERE codigo = p_codigo)
	THEN
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'El código del producto ya está registrado';
	END IF;

-- SQLINES DEMO ***  de categoría exista
IF NOT EXISTS (SELECT id FROM category WHERE id = p_id_categoria)
	THEN
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'El id de categoría no existe';
	END IF;

-- SQLINES DEMO *** a asignarle al nuevo producto
SET v_size = (SELECT count(id) FROM product);
WHILE v_count <= v_size
	DO
		IF EXISTS (SELECT id FROM product WHERE id = v_count)
			THEN
				SET v_count = v_count + 1;
		ELSE
				SET v_size = 0;
			END IF;
	END WHILE;

-- SQLINES DEMO *** tro del nuevo producto
INSERT INTO product VALUES(v_count,p_codigo,p_producto,p_descripcion,p_precio,p_cantidad,NOW(3),p_id_categoria);
END;
//