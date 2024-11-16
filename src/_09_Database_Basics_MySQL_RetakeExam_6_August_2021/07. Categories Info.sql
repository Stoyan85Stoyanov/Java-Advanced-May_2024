SELECT
    c.`name` AS `category_name`,
    COUNT(*) AS `game_count`,
    ROUND(AVG(`budget`), 2) AS `average_budget`,
    MAX(`rating`) AS `max_rating`

FROM `categories` AS c
LEFT JOIN `games_categories` AS gc
ON c.`id` = gc.`category_id`
LEFT JOIN `games` AS g
ON g.`id` = gc.`game_id`
GROUP BY `category_name`
HAVING MAX(g.`rating`) >= 9.5
ORDER BY `game_count` DESC, `category_name`;