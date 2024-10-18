  SELECT
     c.`id`,
     c.`name`
FROM `countries` AS c
LEFT JOIN `athletes` AS a
ON  a.`country_id` = c.`id`
WHERE a.`id` IS NULL
ORDER BY c.`name` DESC
LIMIT 15;