SELECT m.`id`, m.`title`, mi.`runtime`, mi.`budget`, mi.`release_date`
FROM `movies` AS m
JOIN `movies_additional_info` AS mi ON m.`movie_info_id` = mi.`id`
WHERE YEAR (mi.`release_date`) BETWEEN 1996 AND 1999
ORDER BY mi.`runtime`, m.`id`
LIMIT 20;