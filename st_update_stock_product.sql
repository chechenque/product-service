DELIMITER \\
CREATE PROCEDURE st_update_stock(
								p_codigo CHAR(13),
								p_stock INT)
BEGIN
DECLARE valid INT DEFAULT 0;
IF NOT EXISTS(SELECT codigo FROM product WHERE codigo = p_codigo )
	THEN -- Si no existe regresamos error
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'El código del producto no existe';
ELSE
		SET valid = (SELECT cantidad FROM product WHERE codigo = p_codigo) + p_stock;
        IF (valid >= 0)
			THEN -- Si es mayor o igual a 0, acutalizamos a 0
				UPDATE product SET cantidad = valid WHERE codigo = p_codigo;
		ELSE -- Si no mandamos otro error diciendo que el valor negativo
				SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'No pueden haber valores negativos en stock';
			END IF;
	END IF;
END;
\\