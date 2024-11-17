DELIMITER $$
 CREATE PROCEDURE udp_update_budget (`min_game_rating` DECIMAL(10, 2))
 BEGIN
     UPDATE `games` AS g
         LEFT JOIN `games_categories` AS gc
         ON  gc.`game_id` = g.`id`
         LEFT JOIN `categories` AS c
         ON gc.`category_id` = c.`id`
     SET g.`budget` = `budget` + 100000,
         g.`release_date` = DATE_ADD(`release_date`, INTERVAL 1 YEAR)
     WHERE c.`name` IS NULL
      AND g.`rating` > `min_game_rating`
      AND g.`release_date` IS NOT NULL;
  END $$
 DELIMITER ;

 CALL udp_update_budget (8);