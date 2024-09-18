CREATE TABLE IF NOT EXISTS `addresses` (
  `address_id` int(10) NOT NULL AUTO_INCREMENT,
  `address_text` varchar(100) NOT NULL,
  `town_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  UNIQUE KEY `PK_Addresses` (`address_id`),
  KEY `fk_addresses_towns` (`town_id`),
  CONSTRAINT `fk_addresses_towns` FOREIGN KEY (`town_id`) REFERENCES `towns` (`town_id`)
) ENGINE=InnoDB AUTO_INCREMENT=292 DEFAULT CHARSET=utf8;