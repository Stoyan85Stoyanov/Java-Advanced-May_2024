 SELECT SUBSTRING(p.`address`,1, 6) `agent_name`,
 CHAR_LENGTH(p.`address`) * 5430 `price`
 FROM `properties` AS p
 LEFT JOIN `property_offers` AS p_o
 ON p.id = p_o.`property_id`
 WHERE p_o.`agent_id` IS NULL
 ORDER BY `agent_name` DESC, `price` DESC;