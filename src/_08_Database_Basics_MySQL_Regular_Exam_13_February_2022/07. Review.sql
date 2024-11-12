SELECT
       `id`,
       `content`,
       `rating`,
       `picture_url`,
       `published_at`
FROM `reviews` AS r
WHERE r.`content` LIKE 'My%' AND CHAR_LENGTH(r.`content`) > 61
ORDER BY r.`rating`DESC;