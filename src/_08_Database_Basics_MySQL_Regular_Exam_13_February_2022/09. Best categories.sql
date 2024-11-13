SELECT COUNT(c.id) AS `items_count`,
             c.`name`,
             SUM(p.`quantity_in_stock`) AS `total_quantity`
FROM `products` AS p
LEFT JOIN `categories` AS c
ON c.`id` = p.`category_id`
GROUP BY c.`id`
ORDER BY `items_count` DESC, `total_quantity`
LIMIT 5;