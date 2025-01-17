SELECT
   e.`first_name`,
   e.`last_name`,
   e.`hire_date`,
   d.`name` AS 'dept_name'
FROM `employees` AS e
INNER JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`hire_date` > '1999-01-01 00:00:00'
AND d.`name` IN ('Sales', 'Finance')
ORDER BY e.`hire_date`;