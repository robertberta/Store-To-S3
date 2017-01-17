CREATE SCHEMA `ddk` ;

CREATE TABLE `ddk`.`Fields` (
  `idFields` INT NOT NULL,
  `idDocument` INT NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  `dataType` VARCHAR(10) NOT NULL,
  `constraint` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idFields`));

CREATE TABLE `ddk`.`Documents` (
  `idDocument` INT NOT NULL AUTO_INCREMENT,
  `company` VARCHAR(30) NOT NULL,
  `team` VARCHAR(30) NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`company`,`team`,`name`),
  KEY `fk_Document_1_idx` (`idDocument`),
  CONSTRAINT `idDocument` FOREIGN KEY (`idDocument`) REFERENCES `Fields` (`idFields`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;