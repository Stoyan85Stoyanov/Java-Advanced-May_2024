SELECT `department_id`, ROUND(MIN(`salary`), 2)
FROM `employees`
GROUP BY `department_id`
HAVING MIN(`salary`) > 800;