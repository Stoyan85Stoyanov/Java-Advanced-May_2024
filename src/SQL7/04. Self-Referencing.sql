CREATE DATABASE `teachers_info`;
USE `teachers_info`;

CREATE TABLE `teachers` (
`teacher_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(60) NOT NULL,
`manager_id` INT
);

ALTER TABLE `teachers` AUTO_INCREMENT = 101;

INSERT INTO `teachers` (`name`, `manager_id`)
  VALUES
       ('John', NULL),
       ('Maya', 106),
	   ('Silvia', 106),
       ('Ted', 105),
       ('Mark', 101),
       ('Greta', 101);

ALTER TABLE `teachers`
ADD CONSTRAINT `fk_manager_id`
FOREIGN KEY (`manager_id`)
REFERENCES `teachers`(`teacher_id`)
