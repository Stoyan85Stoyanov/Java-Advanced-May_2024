INSERT INTO `athletes` (`first_name`, `last_name`, `age`, `country_id`)
SELECT
    UPPER(a.`first_name`) AS `first_name`,
    CONCAT(a.`last_name`, ' comes from ', c.`name`) AS `last_name`,
    (a.`age` + a.`country_id`) AS `age`,
    c.`id`
FROM `athletes` AS a
LEFT JOIN `countries` AS c
ON a.`country_id` = c.`id`
WHERE c.`name` LIKE 'A%';