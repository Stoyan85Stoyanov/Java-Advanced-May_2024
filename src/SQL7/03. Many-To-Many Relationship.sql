CREATE DATABASE `students_info`;
USE `students_info`;

CREATE TABLE `students` (
`student_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(60) NOT NULL
);

INSERT INTO `students` (`name`)
VALUES
       ('Mila'),
       ('Toni'),
       ('Ron');

CREATE TABLE `exams` (
`exam_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);

ALTER TABLE `exams` AUTO_INCREMENT = 101;

INSERT INTO `exams` (`name`)
VALUES
       ('Spring MVC'),
       ('Neo4j'),
       ('Oracle 11g');

CREATE TABLE `students_exams` (
`student_id` INT NOT NULL,
`exam_id` INT NOT NULL,

CONSTRAINT `pk_students_exams`
PRIMARY KEY (`student_id`, `exam_id`),

CONSTRAINT `fk_students`
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`),

CONSTRAINT `fk_exams`
FOREIGN KEY (`exam_id`)
REFERENCES `exams`(`exam_id`)
);

INSERT INTO `students_exams` (`student_id`, `exam_id`)
VALUES
       (1, 101),
       (1, 102),
	   (2, 101),
       (3, 103),
       (2, 102),
       (2, 103);
