CREATE PROCEDURE usp_get_employees_salary_above (desired_salary DECIMAL(20,4))
BEGIN
  SELECT `first_name`, `last_name`
  FROM `employees`
  WHERE `salary` >= `desired_salary`
  ORDER BY `first_name`, `last_name`, `employee_id`;
END $$
DELIMITER ;

CALL usp_get_employees_salary_above(45000);