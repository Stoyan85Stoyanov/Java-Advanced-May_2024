 DELIMITER $$
CREATE PROCEDURE udp_special_offer(`first_name` VARCHAR(50))
 BEGIN
     UPDATE `property_offers` AS p_o
     JOIN `agents` AS a
     ON a.`id` = p_o.`agent_id`
     SET p_o.`price` = p_o.`price` * 0.90
     WHERE a.`first_name` = `first_name`;
END $$
DELIMITER ;

CALL udp_special_offer('Hans');
 SELECT a.`first_name`, p_o.`price`
 FROM `property_offers` AS p_o
 JOIN `agents` AS a
 ON  a.`id`= p_o.`agent_id`
 WHERE `first_name` ='Hans'