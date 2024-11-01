SELECT
	   f.`flight_code`,
       f.`departure`,
       (CASE
           WHEN TIME(f.`departure`) >= '05:00:00' AND TIME(f.`departure`) < '12:00:00' THEN 'Morning'
           WHEN TIME(f.`departure`) >= '12:00:00' AND TIME(f.`departure`) < '17:00:00' THEN 'Afternoon'
           WHEN TIME(f.`departure`) >= '17:00:00' AND TIME(f.`departure`) < '21:00:00' THEN 'Evening'
           WHEN TIME(f.`departure`) >= '21:00:00' OR TIME(f.`departure`) < '05:00:00' THEN 'Night'
       END) AS `time_slot`
       FROM `flights` AS f
ORDER BY `flight_code` DESC;