DELETE u
FROM `universities` AS u
WHERE `number_of_staff` IS NULL;

SELECT * FROM `universities`;