SELECT
    c.`name`,
    COUNT(ids.`driving_school_id`) AS `instructors_count`
FROM `cities` c

         JOIN `driving_schools` ds ON c.`id` = ds.`city_id`
         LEFT JOIN `instructors_driving_schools` ids ON ds.`id` = ids.`driving_school_id`
         LEFT JOIN `instructors` i ON ids.`instructor_id` = i.`id`
GROUP BY c.`name`
HAVING `instructors_count` > 0
ORDER BY `instructors_count` DESC;