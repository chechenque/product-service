DELIMITER //
CREATE PROCEDURE st_update_category(p_categoria VARCHAR(100), p_id INT)
BEGIN
IF NOT EXISTS (SELECT categoria FROM category WHERE id = p_id)
	THEN
		SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'La categoria No existe';
ELSE
		IF NOT EXISTS (SELECT categoria FROM category WHERE categoria = p_categoria)
			THEN
				UPDATE category SET categoria = p_categoria WHERE id = p_id;
		ELSE
				SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'La categoría ya está registrada';
			END IF;
	END IF;
END;
//