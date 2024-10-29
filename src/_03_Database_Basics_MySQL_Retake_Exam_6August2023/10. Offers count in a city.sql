 DELIMITER $$
 CREATE FUNCTION udf_offers_from_city_name(`cityName` VARCHAR(50))
     RETURNS INT
     DETERMINISTIC
 BEGIN
     DECLARE `offers_count` INT;
     SET `offers_count` := (
         SELECT COUNT(c.`id`)
         FROM `property_offers` AS po
         INNER JOIN `properties` AS p
         ON po.property_id = p.id
         INNER JOIN `cities` AS c
         ON c.id = p.city_id
         WHERE c.`name` = `cityName`);
     RETURN `offers_count`;
  END $$
 DELIMITER ;

SELECT udf_offers_from_city_name('Vienna') AS `offers_count`;
SELECT udf_offers_from_city_name('Amsterdam') AS `offers_count`;