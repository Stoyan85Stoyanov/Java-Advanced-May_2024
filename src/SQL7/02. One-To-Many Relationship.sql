CREATE DATABASE `cars`;
USE `cars`;

CREATE TABLE `manufacturers` (
`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(60) NOT NULL UNIQUE,
`established_on` DATE
);

INSERT INTO `manufacturers` (`name`, `established_on`)
VALUES
      ('BMW', '1916/03/01'),
      ('Tesla', '2003/01/01'),
      ('Lada', '1966/05/01');

CREATE TABLE `models` (
`model_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(60) NOT NULL,
`manufacturer_id` INT,
CONSTRAINT `fk_models_manufacturers`
FOREIGN KEY (`manufacturer_id`)
REFERENCES `manufacturers`(`manufacturer_id`)
);

INSERT INTO `models` (`model_id`, `name`, `manufacturer_id`)
VALUES
       (101, 'X1', 1),
       (102, 'i6', 1),
	   (103, 'Model S', 2),
       (104, 'Model X', 2),
       (105, 'Model 3', 2),
       (106, 'Nova', 3);