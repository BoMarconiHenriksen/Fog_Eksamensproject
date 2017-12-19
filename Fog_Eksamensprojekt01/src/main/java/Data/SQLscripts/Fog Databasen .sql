/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */; -- 0 er true, 1 = false
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE `fog`;

USE `fog`;

-- Create userlist
DROP TABLE IF EXISTS `userlist`;
CREATE TABLE `userlist` (
	`user_id` INT(11) NOT NULL AUTO_INCREMENT,
    `zipcode` INT(4) NOT NULL,
	`email` VARCHAR(45) NOT NULL, 
    `password` VARCHAR(45) NOT NULL,  
    `role` VARCHAR(20) NOT NULL,  
    `firstname` VARCHAR(45) NOT NULL,
    `lastname` VARCHAR(45) NOT NULL,
    `address` VARCHAR(45) NOT NULL,
    `tlfnummer` INT(20) NOT NULL,
    PRIMARY KEY (user_id), FOREIGN KEY (zipcode) REFERENCES zipcodelist(zipcode),
    UNIQUE KEY `email_UNIQUE` (`email`)
);
    
-- create zipcodelist
DROP TABLE IF EXISTS `zipcodelist`;
CREATE TABLE `zipcodelist` (
	`zipcode` INT,
    `city` VARCHAR(20) CHARACTER SET utf8,
    PRIMARY KEY (zipcode)
);

-- Create ordreliste
DROP TABLE IF EXISTS `ordreliste`;
CREATE TABLE `ordreliste`(
	`ordre_id`INT (11) NOT NULL AUTO_INCREMENT, 
	`user_id`INT (11), 
	`receiveddate`VARCHAR(11), 
	PRIMARY KEY (ordre_id), FOREIGN KEY (user_id) REFERENCES userlist(user_id)-- ,
);

-- Create materialeliste 
DROP TABLE IF EXISTS `materialeliste`;
CREATE TABLE `materialeliste`(
	`vareid`INT (20) NOT NULL AUTO_INCREMENT, 
	`materialetype`VARCHAR (45) ,
	`materialenavn` VARCHAR(50),
	`enhed`VARCHAR(10), 
	`enhedspris`DOUBLE (11,2),
	`længde`INT (20),
    `carport_type` VARCHAR(50),
	PRIMARY KEY (vareid)
);

-- Create odetaljer
DROP TABLE IF EXISTS `odetaljer`;
CREATE TABLE `odetaljer`(
	`odetaljer_id`INT(11) NOT NULL AUTO_INCREMENT, 
    `ordre_id` INT(11),
    `ordre_status` VARCHAR(45) DEFAULT 'Ny ordre',
	`carport_length`DOUBLE(9,2),
	`carport_width`DOUBLE(9,2), 
	`carport_height`DOUBLE(9,2),
    `length_redskabsrum`DOUBLE(9,2),
    `width_redskabsrum`DOUBLE(9,2),
	`tagtype`INT (11), 
    `price`double(9,2),
    PRIMARY KEY (odetaljer_id),
	FOREIGN KEY (`ordre_id`)REFERENCES ordreliste(`ordre_id`)
);

-- Demo Data til zipcodelist
INSERT INTO zipcodelist VALUES (1000,'København K');

-- Demo user data
INSERT INTO userlist VALUES 
	(1, 1000, 'ansat@ansat.dk', 'a', 'employee', 'Jens', 'Jensen', 'Flyvervej 1',40404040),
    (2, 1000, 'kunde@kunde.dk', 'b', 'customer', 'Winnie', 'Hansen', 'Ved Søen 2', 50505050),
    (4, 1000, 'kunde4@kunde.dk', 'b', 'customer', 'Hans', 'Hansen', 'Ved Søen 2', 50505050);
    
-- Demo data ordreliste
INSERT INTO ordreliste VALUES
	(1, 1, '2017-9-9');
INSERT INTO ordreliste VALUES
	(2, 1, '2017-12-12');

-- Demo ordre data
INSERT INTO odetaljer VALUES
	(1,1,'Bestilt',240, 240, 225,210,150,1,4600.00);
INSERT INTO odetaljer VALUES
	(2,2,'Godkendt',240, 240, 225,0,0,1,2900.00);

-- Data til materialelisten 
INSERT INTO materialeliste values -- vareid, varenummer, materialetype, materialenavn, enhed, enhedsprise, længde 
	(1, 'Træ', '25x200 mm. trykimp. Brædt', 'stk', 26.95, 100, 'Basis'); 
INSERT INTO materialeliste values  
	(2, 'Træ', '25x125 mm. trykimp. Brædt', 'stk', 29.95, 100, 'Basis');
 INSERT INTO materialeliste values   
 	(3, 'Træ', '38x73 mm. Lægte ubh.', 'stk', 20.95, 100, 'Skur');
 INSERT INTO materialeliste values   
 	(4, 'Træ', '45x95 mm. Reglar ub.', 'm', 14.75, 100, 'Skur'); 
 INSERT INTO materialeliste values   
 	(5, 'Træ', '45x195 mm. spærtræ ubh.', 'm', 37.95, 100, 'Skur'); 
INSERT INTO materialeliste values   
	(6, 'Træ', '97x97 mm. trykimp. Stolpe 300 cm', 'stk', 83.85, 1, 'Basis');
INSERT INTO materialeliste values   
	(7, 'Træ', '19x100	mm. trykimp. Brædt', 'm', 6.95, 100, 'Basis');
-- Ovenstående tilføjes igen
INSERT INTO materialeliste values  
	(10, 'Træ', '25x150 mm. trykimp. Brædt', 'm', 37.95, 100, 'Basis'); 
INSERT INTO materialeliste values  
	(11, 'Træ', '25x50 mm. trykimp. Brædt', 'Sm', 19.95, 100, 'Basis'); 
INSERT INTO materialeliste values  
	(12, 'Træ', 'Færdigskåret (byg-selv spær)', 'sæt', 2200.00, 1, 'Basis');  

-- Beslag og Skruer    
INSERT INTO materialeliste values   
	(13, 'Beslag & Skruer', 'Plastmo bundskruer 200 stk', 'Pakke', 197.95, 1, 'Basis');
INSERT INTO materialeliste values   
	(14, 'Beslag & Skruer', 'hulbånd 1x20 mm. 10 mtr.', 'Rulle', 189.00, 1, 'Basis');
INSERT INTO materialeliste values   
	(15, 'Beslag & Skruer', 'Universal 190 mm højre', 'Stk', 37.00, 1, 'Basis');
INSERT INTO materialeliste values   
	(16, 'Beslag & Skruer', 'Universal 190 mm venstre', 'Stk', 37.00, 1, 'Basis');
INSERT INTO materialeliste values   
	(17, 'Beslag & Skruer', '4,5 x 60 mm. skruer 200 stk.', 'Pakke', 109.00, 1, 'Basis');
INSERT INTO materialeliste values   
	(18, 'Beslag & Skruer', '4,0 x 50 mm. beslagskruer 250 stk.', 'Pakke', 159.00, 1, 'Basis');
INSERT INTO materialeliste values   
	(19, 'Beslag & Skruer', 'Bræddebolt 10 x 120 mm.', 'Stk', 18.76, 1, 'Basis');
INSERT INTO materialeliste values   
	(20, 'Beslag & Skruer', 'Firkantskiver 40x40x11mm.', 'Stk', 9.76, 1, 'Basis');
INSERT INTO materialeliste values   
	(21, 'Beslag & Skruer', '4,5 x 70 mm. Skruer 400 stk.', 'Pakke', 289.00, 1, 'Basis');
INSERT INTO materialeliste values   
	(22, 'Beslag & Skruer', '4,5 x 50 mm. Skruer 300 stk.', 'Pakke', 229.00, 1, 'Basis');
 INSERT INTO materialeliste values   
 	(23, 'Beslag & Skruer', 'Stalddørsgreb 50x75', 'Sæt', 189.00, 1, 'Skur'); 
 INSERT INTO materialeliste values   
 	(24, 'Beslag & Skruer', 'T hængsel 390 mm.', 'Stk', 119.95, 1, 'Skur'); 
 INSERT INTO materialeliste values   
 	(25, 'Beslag & Skruer', 'Vinkelbeslag 35', 'Stk', 2.50, 1, 'Skur'); 
INSERT INTO materialeliste values   
	(26, 'Beslag & Skruer', '5,0 x 40 mm. beslagskruer 250 stk.', 'Pakke', 229.00, 1, 'Basis'); 
INSERT INTO materialeliste values   
	(27, 'Beslag & Skruer', '5,0 x 100 mm. Skruer 100 stk.', 'Pakke', 339.00, 1, 'Basis'); 
    
-- Tagpakken
 INSERT INTO materialeliste values   
	(8, 'Tagpakken', 'Plastmo Ecolite blåtonet 600', 'Stk', 330.00, 1, 'Basis_tag');
 INSERT INTO materialeliste values   
 	(9, 'Tagpakken', 'Plastmo Ecolite blåtonet 300', 'Stk', 119.00, 1, 'Basis_tag');
 INSERT INTO materialeliste values   
 	(28, 'Tagpakken', 'B & C Dobbelt -s sort', 'Stk', 49.95, 1, 'Tag'); 
 INSERT INTO materialeliste values   
 	(29, 'Tagpakken', 'B & C Rygsten sort', 'Stk', 89.95, 1, 'Tag'); 
 INSERT INTO materialeliste values   
 	(30, 'Tagpakken', 'B & C Toplægtholder', 'Stk', 18.50, 1, 'Tag'); 
INSERT INTO materialeliste values   
 	(31, 'Tagpakken', 'B & C Rygstensbeslag', 'Stk', 294.00, 1, 'Tag'); 
 INSERT INTO materialeliste values   
 	(32, 'Tagpakken', 'B & C Tagstensbindere & nakkekroge', 'Pk', 524.00, 1, 'Tag'); 
INSERT INTO materialeliste values   
	(33, 'Tagpakken', 'Plastmo Ecolite blåtonet 480', 'Stk', 199.00, 1, 'Basis_tag');   
    
commit;    
    
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
