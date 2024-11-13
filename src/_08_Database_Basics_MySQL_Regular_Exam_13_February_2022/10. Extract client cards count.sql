DELIMITER $$
 CREATE FUNCTION udf_customer_products_count(`name` VARCHAR(30))
     RETURNS INT
     DETERMINISTIC
 BEGIN
     DECLARE `products_count` INT;
     SET `products_count` := (
         SELECT COUNT(c.`id`)
         FROM `customers` AS c
                  LEFT JOIN `orders` AS o
                  ON c.`id` = o.`customer_id`
                  LEFT JOIN `orders_products` AS op
                  ON o.`id` = op.`order_id`
          WHERE c.`first_name` = `name`);
     RETURN `products_count`;
 END $$
 DELIMITER ;

 SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
 WHERE c.first_name = 'Shirley';