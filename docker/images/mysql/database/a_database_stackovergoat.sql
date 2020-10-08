- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema amt_project_01
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `amt_project_01` ;

-- -----------------------------------------------------
-- Schema amt_project_01
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `amt_project_01` DEFAULT CHARACTER SET utf8 ;
USE `amt_project_01` ;

-- -----------------------------------------------------
-- Table `amt_project_01`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amt_project_01`.`User` (
  `idUser` VARCHAR(50) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `pasword` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idUser_UNIQUE` ON `amt_project_01`.`User` (`idUser` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `amt_project_01`.`Question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amt_project_01`.`Question` (
  `idQuestion` VARCHAR(50) NOT NULL,
  `text` VARCHAR(400) NOT NULL,
  `User_idUser` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idQuestion`, `User_idUser`),
  CONSTRAINT `fk_Question_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `amt_project_01`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idQuestion_UNIQUE` ON `amt_project_01`.`Question` (`idQuestion` ASC) VISIBLE;

CREATE INDEX `fk_Question_User1_idx` ON `amt_project_01`.`Question` (`User_idUser` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `amt_project_01`.`Answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amt_project_01`.`Answer` (
  `idAnswer` VARCHAR(50) NOT NULL,
  `text` VARCHAR(400) NOT NULL,
  `Question_idQuestion` VARCHAR(50) NOT NULL,
  `Question_User_idUser` VARCHAR(50) NOT NULL,
  `User_idUser` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idAnswer`, `Question_idQuestion`, `Question_User_idUser`, `User_idUser`),
  CONSTRAINT `fk_Answer_Question1`
    FOREIGN KEY (`Question_idQuestion` , `Question_User_idUser`)
    REFERENCES `amt_project_01`.`Question` (`idQuestion` , `User_idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Answer_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `amt_project_01`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `idAnswer_UNIQUE` ON `amt_project_01`.`Answer` (`idAnswer` ASC) VISIBLE;

CREATE INDEX `fk_Answer_Question1_idx` ON `amt_project_01`.`Answer` (`Question_idQuestion` ASC, `Question_User_idUser` ASC) VISIBLE;

CREATE INDEX `fk_Answer_User1_idx` ON `amt_project_01`.`Answer` (`User_idUser` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `amt_project_01`.`User_votes_for_Question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amt_project_01`.`User_votes_for_Question` (
  `User_idUser` VARCHAR(50) NOT NULL,
  `Question_idQuestion` VARCHAR(50) NOT NULL,
  `User_votes_for_Questioncol` VARCHAR(45) NOT NULL,
  `isUpvote` TINYINT NOT NULL,
  PRIMARY KEY (`User_idUser`, `Question_idQuestion`),
  CONSTRAINT `fk_User_has_Question_User`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `amt_project_01`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Question_Question1`
    FOREIGN KEY (`Question_idQuestion`)
    REFERENCES `amt_project_01`.`Question` (`idQuestion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_User_has_Question_Question1_idx` ON `amt_project_01`.`User_votes_for_Question` (`Question_idQuestion` ASC) VISIBLE;

CREATE INDEX `fk_User_has_Question_User_idx` ON `amt_project_01`.`User_votes_for_Question` (`User_idUser` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `amt_project_01`.`User_votes_for_Answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `amt_project_01`.`User_votes_for_Answer` (
  `User_idUser` VARCHAR(50) NOT NULL,
  `Answer_idAnswer` VARCHAR(50) NOT NULL,
  `Answer_Question_idQuestion` VARCHAR(50) NOT NULL,
  `Answer_Question_User_idUser` VARCHAR(50) NOT NULL,
  `isUpvote` TINYINT NOT NULL,
  PRIMARY KEY (`User_idUser`, `Answer_idAnswer`, `Answer_Question_idQuestion`, `Answer_Question_User_idUser`),
  CONSTRAINT `fk_User_has_Answer_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `amt_project_01`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Answer_Answer1`
    FOREIGN KEY (`Answer_idAnswer` , `Answer_Question_idQuestion` , `Answer_Question_User_idUser`)
    REFERENCES `amt_project_01`.`Answer` (`idAnswer` , `Question_idQuestion` , `Question_User_idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_User_has_Answer_Answer1_idx` ON `amt_project_01`.`User_votes_for_Answer` (`Answer_idAnswer` ASC, `Answer_Question_idQuestion` ASC, `Answer_Question_User_idUser` ASC) VISIBLE;

CREATE INDEX `fk_User_has_Answer_User1_idx` ON `amt_project_01`.`User_votes_for_Answer` (`User_idUser` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;