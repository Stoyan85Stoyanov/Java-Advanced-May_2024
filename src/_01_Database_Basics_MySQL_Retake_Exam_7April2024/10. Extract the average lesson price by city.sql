DELIMITER $$
CREATE FUNCTION `udf_average_lesson_price_by_city`(`city_name` VARCHAR(40))
    RETURNS DECIMAL(10, 2)
    DETERMINISTIC
BEGIN
    DECLARE `average_lesson_price` DECIMAL(10, 2);
    SET `average_lesson_price` := (SELECT
         ROUND(AVG(ds.`average_lesson_price`), 2)
         FROM `cities` c
         JOIN `driving_schools` ds ON ds.`city_id` = c.`id`
         WHERE c.`name` = `city_name`);
    RETURN `average_lesson_price`;
END $$
DELIMITER ;