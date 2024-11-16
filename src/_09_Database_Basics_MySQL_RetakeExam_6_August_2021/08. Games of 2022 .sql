SELECT
	g.`name`,
    g.`release_date`,
     CONCAT(LEFT(g.`description`, 10), '...') AS `summary`,

    (CASE
        WHEN MONTH(g.`release_date`) IN (1, 2, 3) THEN 'Q1'
        WHEN MONTH(g.`release_date`) IN (4, 5, 6) THEN 'Q2'
        WHEN MONTH(g.`release_date`) IN (7, 8, 9) THEN 'Q3'
        WHEN MONTH(g.`release_date`) IN (10, 11, 12) THEN 'Q4'
    END) AS `quarter`, t.`name` AS `team_name`
FROM `teams` AS t
LEFT JOIN `games` AS g
ON  g.`team_id` = t.`id`
WHERE g.`name` LIKE '%2'
    AND MONTH(g.`release_date`) % 2 = 0
    AND YEAR(g.`release_date`) = 2022
ORDER BY `quarter`;