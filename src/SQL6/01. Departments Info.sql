SELECT `department_id`, COUNT(`id`)
FROM `employees`
GROUP BY `department_id`;