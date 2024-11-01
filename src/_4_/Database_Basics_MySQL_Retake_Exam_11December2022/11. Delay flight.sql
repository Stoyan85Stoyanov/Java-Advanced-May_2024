DELIMITER $$
 CREATE PROCEDURE udp_delay_flight (`code` VARCHAR(50))
 BEGIN
     UPDATE `flights` AS f
     SET f.`has_delay` = 1,
       `departure` = DATE_ADD(`departure`, INTERVAL 30 MINUTE)
     WHERE f.`flight_code` = `code`;
  END $$
 DELIMITER ;