SELECT
    c.`continent_code`,
    c.`currency_code`,
    COUNT(*) AS 'currency_usage'
FROM `countries` AS c
GROUP BY c.`continent_code`, c.`currency_code`
HAVING `currency_usage` > 1
   AND `currency_usage` = (SELECT COUNT(*) AS 'most_used_currency'
                           FROM `countries` AS c1
                           WHERE c.`continent_code` = c1.`continent_code`
                           GROUP BY c1.`currency_code`
                           ORDER BY `most_used_currency` DESC
                           LIMIT 1)
ORDER BY c.`continent_code`, c.`continent_code`;