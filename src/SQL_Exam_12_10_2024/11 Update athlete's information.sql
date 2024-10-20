DELIMITER $$
 CREATE PROCEDURE udp_first_name_to_upper_case  (`letter` CHAR(1))
 BEGIN
	UPDATE `athletes` AS a
    SET a.`first_name` = UPPER(a.`first_name`)
    WHERE RIGHT(a.`first_name`, 1) = `letter`;
  END $$
 DELIMITER ;

 CALL udp_first_name_to_upper_case ('s');