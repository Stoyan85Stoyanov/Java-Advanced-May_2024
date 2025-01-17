DELIMITER $$
CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))
BEGIN
    UPDATE `actors` AS a
        JOIN `movies_actors` AS ma ON a.`id` = ma.`actor_id`
        JOIN `movies` AS m ON ma.`movie_id` = m.`id`
    SET  a.`awards` = a.`awards` + 1
    WHERE m.`title` = movie_title;
END $$
DELIMITER ;