DELIMITER $$
 CREATE FUNCTION udf_count_flights_from_country(`country` VARCHAR(50))
     RETURNS INT
     DETERMINISTIC
 BEGIN
     DECLARE `count_flights` INT;
     SET `count_flights` := (
         SELECT COUNT(*)
		 FROM `flights` AS f
			LEFT JOIN `countries` AS c
		    ON c.`id` = f.`departure_country`
			WHERE `name` = `country`);
     RETURN `count_flights`;
 END $$
 DELIMITER ;

 SELECT udf_count_flights_from_country('Brazil') AS 'flights_count';

 SELECT udf_count_flights_from_country('Philippines') AS 'flights_count';