CREATE SCHEMA `ddk` ;

DROP TABLE IF EXISTS ddk.Document;
DROP TABLE IF EXISTS ddk.Field;
CREATE TABLE `ddk`.`Field` (
  `idField` INT NOT NULL AUTO_INCREMENT,
  `idDocument` INT NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  `dataType` VARCHAR(10) NOT NULL,
  `constraint` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idField`));

CREATE TABLE `ddk`.`Document` (
  `idDocument` INT NOT NULL AUTO_INCREMENT,
  `company` VARCHAR(30) NOT NULL,
  `team` VARCHAR(30) NOT NULL,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`company`,`team`,`name`),
  KEY `fk_Document_1_idx` (`idDocument`),
  CONSTRAINT `idDocument` FOREIGN KEY (`idDocument`) REFERENCES `Field` (`idField`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO ddk.Field values (null,1,"supplier","String","NN");
INSERT INTO ddk.Document values (1,"tc","all","invoice");