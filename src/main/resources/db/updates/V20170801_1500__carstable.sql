
CREATE TABLE `car` (
  `car_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `car_make` VARCHAR(255) NOT NULL,
  `car_model` VARCHAR(255) NOT NULL,
  `engine_size` INT(10),
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;