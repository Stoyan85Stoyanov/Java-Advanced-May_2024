DELIMITER $$
 CREATE FUNCTION udf_game_info_by_name(`game_name` VARCHAR(20))
     RETURNS TEXT
     DETERMINISTIC
 BEGIN
     DECLARE `game` TEXT;
     SET `game` := (
         SELECT CONCAT('The ',  g.`name`,  ' is developed by a ',  t.`name`,  ' in an office with an address ',  a.`name`)
		 FROM `games` AS g
			LEFT JOIN `teams` AS t
		    ON g.`team_id` = t.`id`
            LEFT JOIN `offices` AS o
            ON  t.`office_id` = o.`id`
            LEFT JOIN `addresses` AS a
            ON  o.`address_id` = a.`id`
			WHERE g.`name` = `game_name`);
     RETURN `game`;
     IF `game_name` IS NULL THEN
        RETURN 'Game not found.';
    ELSE
        RETURN `game_name`;
    END IF;
 END $$
 DELIMITER ;

 SELECT udf_game_info_by_name('Bitwolf') AS info
 FROM `games` AS g
 WHERE g.`name` = `game_name`;

 SELECT udf_game_info_by_name('Fix San') AS info
 FROM `games` AS g
 WHERE g.`name` = `game_name`;

 SELECT udf_game_info_by_name('Job') AS info
 FROM `games` AS g
 WHERE g.`name` = `game_name`;