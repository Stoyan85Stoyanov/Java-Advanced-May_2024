    DELIMITER $$

    CREATE PROCEDURE `usp_raise_salaries`(p_department_name VARCHAR(70))
BEGIN

    UPDATE `employees`
    SET `salary` = `salary` * 1.05
    WHERE `department_id` = (SELECT `department_id`
                             FROM `departments`
                             WHERE `name` = p_department_name);
END $$

DELIMITER ;
CALL `usp_raise_salaries`('Finance');