  SELECT
       u.`name` AS 'university_name',
       c.`name` AS 'city_name',
       `address`,
        (CASE
              WHEN u.`tuition_fee` < 800 THEN 'cheap'
              WHEN u.`tuition_fee` >= 800 AND u.`tuition_fee` < 1200 THEN 'normal'
              WHEN u.`tuition_fee` >= 1200 AND u.`tuition_fee` < 2500 THEN 'high'
              ELSE 'expensive'
              END) AS `price`, u.`tuition_fee`
 FROM `universities` AS u
          INNER JOIN `cities` AS c
          ON c.`id` = u.`city_id`
 ORDER BY `tuition_fee`;