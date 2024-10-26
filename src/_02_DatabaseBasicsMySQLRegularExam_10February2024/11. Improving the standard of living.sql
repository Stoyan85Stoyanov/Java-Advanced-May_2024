DELIMITER $$
 CREATE PROCEDURE udp_increase_salaries_by_country(`country_name` VARCHAR(40))
 BEGIN
UPDATE `workers` AS w
JOIN `preserves` AS p
         ON p.`id` = w.`preserve_id`
         JOIN `countries_preserves` AS cp
         ON p.`id` = cp.`preserve_id`
		 JOIN `countries` AS c
         ON c.`id` = cp.`country_id`
SET w.`salary` = w.`salary` * 1.05
WHERE c.`name` = `country_name`;
END $$
DELIMITER ;

 CALL udp_increase_salaries_by_country('Germany');

SELECT w.first_name, w.last_name,w.salary as 'salary after' from workers w
JOIN preserves p on p.id = w.preserve_id
JOIN countries_preserves cp on p.id = cp.preserve_id
JOIN countries c on c.id = cp.country_id
where c.name = 'Germany';