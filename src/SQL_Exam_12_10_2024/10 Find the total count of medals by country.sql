DROP FUNCTION udf_total_medals_count_by_country
DELIMITER $$
 CREATE FUNCTION udf_total_medals_count_by_country(`name` VARCHAR(40))
     RETURNS INT
     DETERMINISTIC
 BEGIN
     DECLARE `total_medals` INT;
     SET `total_medals` := (
         SELECT COUNT(dam.`medal_id`)
         FROM `medals` AS m
                  INNER JOIN `disciplines_athletes_medals` AS dam
                  ON dam.`medal_id` = m.`id`
                  INNER JOIN `athletes` AS a
                  ON dam.`athlete_id` = a.`id`
                  INNER JOIN `countries` AS c
                  ON a.`country_id` = c.`id`
           WHERE c.`name` = `name`);
     RETURN `total_medals`;
 END $$
 DELIMITER ;

 SELECT c.name, udf_total_medals_count_by_country ('Bahamas') as count_of_medals
FROM countries c
WHERE c.name = 'Bahamas'