SELECT
     CONCAT(`first_name`, ' ', `last_name`) AS `full_name`,
     `age`
FROM `athletes` AS a
      JOIN `disciplines_athletes_medals` AS dam
      ON dam.`athlete_id` = a.`id`
      WHERE age = 17
      GROUP BY dam.`athlete_id`
      HAVING COUNT(dam.`athlete_id`) > 0
ORDER BY a.`id`, a.`age`
LIMIT 2;