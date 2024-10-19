SELECT
    a.`id`,
    a.`first_name`,
    a.`last_name`,
    COUNT(dam.`medal_id`) AS `medals_count`,
    s.`name` AS `sport`

FROM `athletes` AS a
LEFT JOIN `disciplines_athletes_medals` AS dam
ON dam.`athlete_id` = a.`id`
LEFT JOIN `medals` AS m
ON dam.`medal_id` = m.`id`
LEFT JOIN `disciplines` AS d
ON dam.`discipline_id` = d.`id`
LEFT JOIN `sports` AS s
ON d.`sport_id` = s.`id`
GROUP BY a.`id`, a.`first_name`, s.`name`
ORDER BY COUNT(dam.`medal_id`) DESC,  a.`first_name`
LIMIT 10;