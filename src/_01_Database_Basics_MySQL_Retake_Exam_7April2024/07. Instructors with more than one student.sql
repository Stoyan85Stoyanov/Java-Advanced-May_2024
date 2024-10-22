SELECT
    i.`first_name`,
    i.`last_name`,
    COUNT(i_s.`student_id`) AS `students_count`,
    c.`name`
FROM `instructors` i
         JOIN `instructors_driving_schools` ids ON i.`id` = ids.`instructor_id`
         JOIN `instructors_students` i_s ON i.`id` = i_s.`instructor_id`
         JOIN `driving_schools` ds ON ds.`id` = ids.`driving_school_id`
         JOIN `cities` c ON c.`id` = ds.`city_id`
GROUP BY i.`id`, i.`first_name`, c.`name`
HAVING `students_count` > 1
ORDER BY `students_count` DESC, i.`first_name`;