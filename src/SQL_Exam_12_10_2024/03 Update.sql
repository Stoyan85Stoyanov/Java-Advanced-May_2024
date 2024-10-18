UPDATE `disciplines` AS d
SET d.`name` = REPLACE(d.`name`, 'weight', '')
WHERE d.`name` LIKE '%weight%';