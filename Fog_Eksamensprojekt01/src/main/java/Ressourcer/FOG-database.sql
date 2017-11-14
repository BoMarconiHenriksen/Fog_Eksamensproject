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
	`email` VARCHAR(100) NOT NULL, 
    `password` VARCHAR(100) NOT NULL,  
    `role` VARCHAR(20) NOT NULL DEFAULT 'customer', 
	`firstname` VARCHAR(45) NOT NULL,
    `lastname` VARCHAR(45) NOT NULL,
    `address` VARCHAR(45) NOT NULL,
    PRIMARY KEY (user_id), FOREIGN KEY (zipcode) REFERENCES zipcodelist(zipcode),
    UNIQUE KEY `email_UNIQUE` (`email`)
);
    
-- create zipcodelist
DROP TABLE IF EXISTS `zipcodelist`;
CREATE TABLE `zipcodelist` (
	`zipcode` INT(4) NOT NULL,
    `city`VARCHAR(45) NOT NULL,
    PRIMARY KEY (zipcode)
);

-- Create ordreliste
DROP TABLE IF EXISTS `ordreliste`;
CREATE TABLE `ordreliste`(
	`ordre_id`INT (11) NOT NULL AUTO_INCREMENT, 
	`user_id`INT (11), 
	`receiveddate`VARCHAR(11), 
	PRIMARY KEY (ordre_id), FOREIGN KEY (user_id) REFERENCES userlist(user_id)-- ,
    -- FOREIGN KEY (ordre_id) REFERENCES odetaljer(ordre_id)
);

-- Create materialeliste 
DROP TABLE IF EXISTS `materialeliste`;
CREATE TABLE `materialeliste`(
	`vareid`INT (20) NOT NULL AUTO_INCREMENT, 
	-- `varenummer`int (20) not null,
	`materialetype`VARCHAR (45) ,
	`materialenavn` VARCHAR(50),
	`enhed`VARCHAR(10), 
	`enhedspris`DOUBLE (11,2),
	`længde`INT (20),
	PRIMARY KEY (vareid)
);

-- Create linjeliste 
DROP TABLE IF EXISTS `linjeliste`;
CREATE TABLE `linjeliste`(
	`linjeliste_id` INT(11) NOT NULL AUTO_INCREMENT, 
	`materialetype` VARCHAR (45), 
	`dimension` VARCHAR (1),
	`baselength` DOUBLE(11,2), 
	`antal`INT (5),
	`beskrivelse` VARCHAR(100),
	PRIMARY KEY (linjeliste_id)
);

-- Create odetaljer
DROP TABLE IF EXISTS `odetaljer`;
CREATE TABLE `odetaljer`(
	`odetaljer_id`INT(11) NOT NULL AUTO_INCREMENT, 
    `ordre_id` INT(11),
    `vareid`INT (20),
    `linjeliste_id`INT(11),
	`length`DOUBLE(9,2),
	`width`DOUBLE(9,2), 
	`height`DOUBLE(9,2),
    `lengthredskabsrum`DOUBLE(9,2),
	`tagtype`INT (11), 
    `redskabsrum`BOOLEAN DEFAULT FALSE,  
    PRIMARY KEY (odetaljer_id),
	FOREIGN KEY (`ordre_id`)REFERENCES ordreliste(`ordre_id`),
    FOREIGN KEY (`vareid`)REFERENCES materialeliste(`vareid`),
    FOREIGN KEY (`linjeliste_id`)REFERENCES linjeliste(`linjeliste_id`)
);

-- Data til materialelisten 
INSERT INTO materialeliste values -- vareid, varenummer, materialetype, materialenavn, enhed, enhedsprise, længde 
	(1, 'Træ', '25x200 mm. trykimp. Brædt', 'stk', 26.95, 100); -- 1085025200 0300
INSERT INTO materialeliste values  
	(2, 'Træ', '25x125 mm. trykimp. Brædt', 'stk', 29.95, 100);
INSERT INTO materialeliste values   
	(3, 'Træ', '38x73 mm. Lægte ubh.', 'stk', 20.95, 100);
INSERT INTO materialeliste values   
	(4, 'Træ', '45x95 mm. Reglar ub.', 'm', 14.75, 100);
INSERT INTO materialeliste values   
	(5, 'Træ', '45x195 mm. spærtræ ubh.', 'm', 37.95, 100);
INSERT INTO materialeliste values   
	(6, 'Træ', '97x97 mm. trykimp. Stolpe 300 cm', 'stk', 83.85, 1);
INSERT INTO materialeliste values   
	(7, 'Træ', '19x100	mm. trykimp. Brædt', 'm', 6.95, 100);
INSERT INTO materialeliste values  
	(10, 'Træ', '25x150 mm. trykimp. Brædt', 'm', 37.95, 100); -- 1085025150 0300
INSERT INTO materialeliste values  
	(11, 'Træ', '25x50 mm. trykimp. Brædt', 'Sm', 19.95, 100); -- ingen vr.
INSERT INTO materialeliste values  
	(12, 'Træ', 'Færdigskåret (byg-selv spær)', 'sæt', 2200.00, 1); -- ingen vr. 

-- Beslag og Skruer    
INSERT INTO materialeliste values   
	(13, 'Beslag & Skruer', 'Plastmo bundskruer 200 stk', 'Pakke', 197.95, 1);
INSERT INTO materialeliste values   
	(14, 'Beslag & Skruer', 'hulbånd 1x20 mm. 10 mtr.', 'Rulle', 189.00, 1);
INSERT INTO materialeliste values   
	(15, 'Beslag & Skruer', 'Universal 190 mm højre', 'Stk', 37.00, 1);
INSERT INTO materialeliste values   
	(16, 'Beslag & Skruer', 'Universal 190 mm venstre', 'Stk', 37.00, 1);
INSERT INTO materialeliste values   
	(17, 'Beslag & Skruer', '4,5 x 60 mm. skruer 200 stk.', 'Pakke', 109.00, 1);
INSERT INTO materialeliste values   
	(18, 'Beslag & Skruer', '4,0 x 50 mm. beslagskruer 250 stk.', 'Pakke', 159.00, 1);
INSERT INTO materialeliste values   
	(19, 'Beslag & Skruer', 'Bræddebolt 10 x 120 mm.', 'Stk', 18.76, 1);
INSERT INTO materialeliste values   
	(20, 'Beslag & Skruer', 'Firkantskiver 40x40x11mm.', 'Stk', 9.76, 1);
INSERT INTO materialeliste values   
	(21, 'Beslag & Skruer', '4,5 x 70 mm. Skruer 400 stk.', 'Pakke', 289.00, 1);
INSERT INTO materialeliste values   
	(22, 'Beslag & Skruer', '4,5 x 50 mm. Skruer 300 stk.', 'Pakke', 229.00, 1);
INSERT INTO materialeliste values   
	(23, 'Beslag & Skruer', 'Stalddørsgreb 50x75', 'Sæt', 189.00, 1);
INSERT INTO materialeliste values   
	(24, 'Beslag & Skruer', 'T hængsel 390 mm.', 'Stk', 119.95, 1);
INSERT INTO materialeliste values   
	(25, 'Beslag & Skruer', 'Vinkelbeslag 35', 'Stk', 2.50, 1);
INSERT INTO materialeliste values   
	(26, 'Beslag & Skruer', '5,0 x 40 mm. beslagskruer 250 stk.', 'Pakke', 229.00, 1); -- ingen vr.
INSERT INTO materialeliste values   
	(27, 'Beslag & Skruer', '5,0 x 100 mm. Skruer 100 stk.', 'Pakke', 339.00, 1); -- ingen vr.
    
-- Tagpakken
INSERT INTO materialeliste values   
	(8, 'Tagpakken', 'Plastmo Ecolite blåtonet 600', 'Stk', 330.00, 1);
INSERT INTO materialeliste values   
	(9, 'Tagpakken', 'Plastmo Ecolite blåtonet 300', 'Stk', 119.00, 1);
INSERT INTO materialeliste values   
	(28, 'Tagpakken', 'B & C Dobbelt -s sort', 'Stk', 49.95, 1); -- ingen vr.
INSERT INTO materialeliste values   
	(29, 'Tagpakken', 'B & C Rygsten sort', 'Stk', 89.95, 1); -- 7921695
INSERT INTO materialeliste values   
	(30, 'Tagpakken', 'B & C Toplægtholder', 'Stk', 18.50, 1); -- ingen vr.
INSERT INTO materialeliste values   
	(31, 'Tagpakken', 'B & C Rygstensbeslag', 'Stk', 294.00, 1); -- ingen vr. 
INSERT INTO materialeliste values   
	(32, 'Tagpakken', 'B & C Tagstensbindere & nakkekroge', 'Pk', 524.00, 1); -- ingen vr.
    
INSERT INTO materialeliste values   
	(33, 'Tagpakken', 'Plastmo Ecolite blåtonet 480', 'Stk', 199.00, 1);   
    
-- Data til linjelisten 
INSERT  INTO linjeliste   values
(null, 'Træ', 'b', 360,4, 'Understernbrædder til for og bagende'),
( null,'Træ', 'l', 540,4, 'Understernbrædder til siderne'), 
(null, 'Træ', 'b', 360, 2,'Oversternbrædder til for og bagende'),
(null, 'Træ', 'l', 540, 4,'Oversternbrædder til siderne'), 
(null, 'Træ', 'u', 420,1, 'Til z på bagside af dør'),
(null, 'Træ', 's', 270,12, 'Løsholter til skurgavle'),
(null, 'Træ', 's', 240,4, 'Løsholter til skursider'),
(null, 'Træ', 'l', 600,2, 'Remme i sider, sadles ned i stolper, carport-del'),
(null, 'Træ', 's', 480,1, 'Remme i sider, sadles ned i stolper, skur-del');

INSERT  INTO linjeliste   values
(null, 'Træ', 'l', 600, 15,'Spær, monteres på rem'),
( null,'Træ', 'h', 300,11, 'Stolper, nedgraves i 90 cm. jord'), 
(null, 'Træ', 's', 210, 200,'Til beklædning af skur 1 på 2'),
(null, 'Træ', 'l', 540,4, 'Vandbrædt på stern i sider'), 
(null, 'Træ', 'b', 360,2, 'Vandbrædt på stern i forende'),
(null, 'Træ', 'l', 600, 6,'Tagplader monteres på spær'),
(null, 'Træ', 'b', 360, 6,'Tagplader monteres på spær');

INSERT  INTO linjeliste   values
(null, 'Beslag og skruer', 'c',1, 3, 'Skruer til tagplader'),
(null, 'Beslag og skruer', 'c',1, 2, 'Til vindkryds på spær'),
(null, 'Beslag og skruer', 'c', 1,15, 'Til montering af spær på rem'),
(null, 'Beslag og skruer', 'c',1, 15, 'Til montering af spær på rem'),
(null, 'Beslag og skruer', 'c',1, 1, 'Til montering af stern og vandbrædt'),
(null, 'Beslag og skruer', 'c', 1,3, 'Til montering af universalbeslag + hulbånd'),
(null, 'Beslag og skruer', 'c', 1,18, 'Til montering af rem på stolper'),
(null, 'Beslag og skruer', 'c', 1,12, 'Til montering af rem på stolper'),
(null, 'Beslag og skruer', 'c', 1,2, 'Til montering af yderste beklædning'),
(null, 'Beslag og skruer', 'c', 1,2, 'Til montering af inderste beklædning'),
(null, 'Beslag og skruer', 'c',1, 1, 'Til lås på dør i skur'),
(null, 'Beslag og skruer', 'c', 1,2, 'Til skurdør'),
(null, 'Beslag og skruer', 'c', 1,32, 'Til montering af løsholter i skur');

commit;    
    
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
