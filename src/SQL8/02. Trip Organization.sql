USE `camp`;
SELECT `driver_id`, `vehicle_type`,
       CONCAT(`first_name`, ' ', `last_name`) AS 'driver_name'
FROM `vehicles` AS v
INNER JOIN `campers` AS c
ON v.`driver_id` = c.`id`;