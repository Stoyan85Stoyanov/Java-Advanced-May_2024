DELIMITER $$
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
   DECLARE movies_count INT; # броят на историческите флми за даденият actor
   SET movies_count := (
      SELECT COUNT(g.`name`) AS 'history_movies'
      FROM `actors` AS a
      JOIN `movies_actors` AS ma ON a.`id` = ma.`actor_id`
      JOIN `genres_movies` AS gm ON ma.`movie_id` = gm.`movie_id`
      JOIN `genres` AS g ON g.`id` = gm.`genre_id`
      WHERE CONCAT(a.first_name, ' ', a.last_name) = full_name AND g.name = 'History'
      GROUP BY g.`name`);
   RETURN movies_count;
END$$

DELIMITER $$