SELECT p.id, concat_ws(' ', p.first_name, p.last_name) as full_name,
p.age, p.position, p.hire_date

FROM players as p
	JOIN
   skills_data as sd ON p.skills_data_id = sd.id
WHERE p.age < 23 and
sd.strength > 50 and
p.hire_date is NULL and
p.position = 'A'
ORDER BY p.salary, p.age;