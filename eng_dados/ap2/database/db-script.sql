-- MySQL Script generated by MySQL Workbench
-- Sun Nov 12 21:35:38 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sound--
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sound--
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sound--` DEFAULT CHARACTER SET utf8 ;
USE `sound--` ;

-- -----------------------------------------------------
-- Table `sound--`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sound--`.`autor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(11) NOT NULL,
  `nome_original` VARCHAR(45) NOT NULL,
  `nome_artistico` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sound--`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sound--`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sound--`.`musica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sound--`.`musica` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `letra` VARCHAR(200) NOT NULL,
  `data_lancamento` DATE NOT NULL,
  `fk_categoria` INT NULL,
  `duracao` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `musica_categoria_idx` (`fk_categoria` ASC) VISIBLE,
  CONSTRAINT `musica_categoria`
    FOREIGN KEY (`fk_categoria`)
    REFERENCES `sound--`.`categoria` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sound--`.`autor_musica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sound--`.`autor_musica` (
  `fk_autor` INT NOT NULL,
  `fk_musica` INT NOT NULL,
  PRIMARY KEY (`fk_autor`, `fk_musica`),
  INDEX `fk_to_musica_idx` (`fk_musica` ASC) VISIBLE,
  CONSTRAINT `fk_musica_autor`
    FOREIGN KEY (`fk_autor`)
    REFERENCES `sound--`.`autor` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_autor_musica`
    FOREIGN KEY (`fk_musica`)
    REFERENCES `sound--`.`musica` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
