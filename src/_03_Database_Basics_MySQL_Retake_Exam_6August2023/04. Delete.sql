DELETE p
FROM `property_transactions` AS p
WHERE p.`is_successful`= 0;

SELECT * FROM `property_transactions`;