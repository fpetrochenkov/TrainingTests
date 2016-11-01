-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema databaseTest
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema databaseTest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `databaseTest` DEFAULT CHARACTER SET utf8 ;
USE `databaseTest` ;

-- -----------------------------------------------------
-- Table `databaseTest`.`car_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `databaseTest`.`car_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `car_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `databaseTest`.`tires`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `databaseTest`.`tires` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `diameter` VARCHAR(45) NOT NULL,
  `width` VARCHAR(45) NOT NULL,
  `height` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `car_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tires_car_type_idx` (`car_type_id` ASC),
  CONSTRAINT `fk_tires_car_type`
    FOREIGN KEY (`car_type_id`)
    REFERENCES `databaseTest`.`car_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
