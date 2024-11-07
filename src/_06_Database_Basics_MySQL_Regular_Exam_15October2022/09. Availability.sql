SELECT
    t.`id` AS 'table_id',
    t.`capacity`,
    COUNT(oc.`client_id`) AS 'count_clients',
    (IF(`capacity` > COUNT(oc.`client_id`),
       'Free seats',
        IF (`capacity` = COUNT(oc.`client_id`), 'Full', 'Extra seats')))
       AS 'availability'

FROM `tables` AS t
INNER JOIN `orders` AS o
ON o.`table_id` = t.`id`
INNER JOIN `orders_clients` AS oc
ON oc.`order_id` = o.`id`
WHERE `floor` = 1
GROUP BY t.`id`
ORDER BY t.`id` DESC;