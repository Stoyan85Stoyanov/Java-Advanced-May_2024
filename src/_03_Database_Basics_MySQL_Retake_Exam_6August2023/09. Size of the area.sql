 SELECT p.`address`, p.`area`,
        (CASE
            WHEN `area` <= 100 THEN 'small'
            WHEN `area` <= 200 THEN 'medium'
            WHEN `area` <= 500 THEN 'large'
            ELSE 'extra large'
            END) `size`
 FROM `properties` AS p
 ORDER BY p.`area`, p.`address` DESC