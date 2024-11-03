SELECT
    CONCAT(`first_name`, " ", `last_name`) AS 'full_name',
    SUBSTRING(`email`, 2, 10) AS `username`,
    REVERSE(`phone`) AS `password`
    FROM `students` AS s
    LEFT JOIN `students_courses` AS sc
    ON s.`id` = sc.`student_id`
    WHERE `course_id` IS NULL
    ORDER BY `password` DESC;