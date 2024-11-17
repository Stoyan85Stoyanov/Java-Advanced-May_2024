SELECT
     g.`name`,
    (CASE
         WHEN (g.`budget`) < 50000 THEN 'Normal budget'
         WHEN (g.`budget`) >= 50000 THEN 'Insufficient budget'
    END) AS `budget_level`,
     t.`name` AS `team_name`,
	 a.`name` AS `address_name`

FROM `games` AS g
LEFT JOIN `teams` AS t
ON g.`team_id` = t.`id`
LEFT JOIN `offices` AS o
ON t.`office_id`= o.`id`
LEFT JOIN `addresses` AS a
ON o.`address_id` = a.`id`
LEFT JOIN `games_categories` AS gc
ON gc.`game_id` = g.`id`
LEFT JOIN `categories` AS c
ON gc.`category_id` = c.`id`
WHERE g.`release_date` IS NULL
AND c.`name` IS NULL
ORDER BY g.`name`;