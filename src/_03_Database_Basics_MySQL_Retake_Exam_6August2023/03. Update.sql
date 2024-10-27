 UPDATE `properties` AS p
 SET p.`price` = p.`price` - 50000
 WHERE p.`price` >= 800000;