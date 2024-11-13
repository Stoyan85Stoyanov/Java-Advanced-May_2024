DELIMITER $$
 CREATE PROCEDURE udp_reduce_price (`category_name` VARCHAR(50))
 BEGIN
     UPDATE `products` AS p
         LEFT JOIN `categories` AS c
         ON c.`id` = p.`category_id`
         LEFT JOIN `reviews` AS r
         ON r.`id` = p.`review_id`
     SET p.`price` = `price` * 0.70
     WHERE c.`name` = `category_name`
     AND r.`rating` < 4;
  END $$
 DELIMITER ;

 CALL udp_reduce_price ('Phones and tablets');