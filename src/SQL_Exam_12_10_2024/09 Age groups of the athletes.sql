SELECT
    CONCAT(a.`first_name`, ' ', a.`last_name`) AS `full_name`,
    (CASE
        WHEN `age` <= 18 THEN 'Teenager'
        WHEN `age` > 18 AND `age` <= 25 THEN 'Young adult'
        WHEN `age` >= 26 THEN 'Adult'
    END) AS `age_group`
FROM `athletes` AS a
ORDER BY a.`age` DESC, a.`first_name` ASC;