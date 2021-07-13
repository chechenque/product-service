-- SQLINES LICENSE FOR EVALUATION USE ONLY
DELIMITER //


CREATE PROCEDURE st_create_category(p_categoria VARCHAR(100))

BEGIN
DECLARE
	v_size INT DEFAULT 0;
	DECLARE v_count INT DEFAULT 1;

-- SQLINES DEMO *** ista la categoria
IF NOT EXISTS (SELECT categoria FROM category WHERE categoria = p_categoria)
	THEN
		-- SQLINES DEMO *** a asignarle a la nueva categoría
		SET v_size = (SELECT count(id) FROM category);
		WHILE v_count <= v_size
			DO
				IF EXISTS (SELECT id FROM category WHERE id = v_count)
					THEN
						SET v_count = v_count + 1;
				ELSE
						SET v_size = 0;
					END IF;
			END WHILE;

			-- SQLINES DEMO ***  de la categoría
			INSERT INTO category VALUES(v_count, p_categoria);
ELSE
        SIGNAL SQLSTATE '50000' SET MESSAGE_TEXT = 'La categoría ya está registrada';
	END IF;
END;
//

DELIMITER ;
