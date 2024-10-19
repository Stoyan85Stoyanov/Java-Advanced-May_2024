SELECT
     a.`id`,
     a.`first_name`,
     a.`last_name`
FROM `athletes` AS a
LEFT JOIN `disciplines_athletes_medals` AS dam
ON dam.`athlete_id` = a.`id`
LEFT JOIN `medals` AS m
ON dam.`medal_id` = m.`id`
WHERE m.`id` IS NULL
ORDER BY a.`id`;