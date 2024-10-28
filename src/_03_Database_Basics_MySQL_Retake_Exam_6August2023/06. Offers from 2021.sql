SELECT *
FROM `property_offers` AS p_o
WHERE YEAR(p_o.`offer_datetime`) = 2021
ORDER BY `price`
LIMIT 10;