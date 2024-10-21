UPDATE `driving_schools`
SET `average_lesson_price` = `average_lesson_price` + 30
WHERE `night_time_driving` = 1
  AND `city_id` = 5;