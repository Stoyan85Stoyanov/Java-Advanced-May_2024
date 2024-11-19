UPDATE coaches as c
SET
  c.coach_level = c.coach_level + 1
WHERE
  c.id IN (SELECT
  coach_id
  FROM players_coaches) and
  first_name like 'A%';