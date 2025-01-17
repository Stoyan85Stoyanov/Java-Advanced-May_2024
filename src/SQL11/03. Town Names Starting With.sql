CREATE PROCEDURE usp_get_towns_starting_with (town_substring VARCHAR(70))
BEGIN
  SELECT `name`
  FROM `towns`
  WHERE `name`
  LIKE CONCAT(town_substring,'%')
  ORDER BY `name`;
END $$
DELIMITER ;

CALL usp_get_towns_starting_with('b');