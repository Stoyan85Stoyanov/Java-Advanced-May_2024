SELECT * FROM `orders` WHERE `id` >= 12 AND `id` <= 23;
# SELECT * FROM `orders` WHERE `id` BETWEEN 12 AND 23;

UPDATE `orders`
SET `table_id` = `table_id` - 1
WHERE `id` BETWEEN 12 AND 23;