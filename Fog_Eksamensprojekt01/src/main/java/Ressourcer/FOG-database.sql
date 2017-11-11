/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */; -- 0 er true, 1 = false
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE `fog`;

USE `fog`;

drop table if exists `userlist`;
create table `userlist` (
	`user_id` int(11) NOT NULL AUTO_INCREMENT,
	`email`varchar(100) NOT NULL, 
    `password`varchar(100) NOT NULL,  
    `admin_status` int (3), 
	`username` varchar(45) NOT NULL,
	primary key (user_id));

DROP TABLE IF EXISTS `ordreliste`;
CREATE TABLE `ordreliste`(
`ordre_id`int (11) not null auto_increment, 
`user_id`int (11), 
`receiveddate`varchar(11), 
primary key (ordre_id), foreign key (user_id) references userlist(user_id));

DROP TABLE IF EXISTS `materialeliste`;
CREATE TABLE `materialeliste`(
`vareid`int (20) not null auto_increment, 
-- `varenummer`int (20) not null,
`materialetype`varchar (45) ,
`materialenavn` varchar(50),
`enhed`varchar(10), 
`enhedspris`double (11,2),
`længde`int (20),
primary key (vareid)
);
select * from materialeliste where vareid=18;

drop table if exists `odetaljer`;
create table `odetaljer`(

	`odetaljer_id`int(11) not null auto_increment, 
    `ordre_id` int(11),
	`length`double(9,2),
	`width`double(9,2), 
	`height`double(9,2), 
	`tagtype`int (11), 
    `redskabsrum`boolean default false,  
    primary key (odetaljer_id),
	FOREIGN key (`ordre_id`)references orderlist(`ordre_id`));
    
-- Data til materialelisten 
INSERT INTO materialeliste values -- vareid, varenummer, materialetype, materialenavn, enhed, enhedsprise, længde 
	(1, 'Træ & Tagplader', '25x200 mm. trykimp. Brædt', 'm', 50.95, 100); -- 1085025200 0300
INSERT INTO materialeliste values  
	(3, 'Træ & Tagplader', '25x125 mm. trykimp. Brædt', 'm', 29.95, 100);
INSERT INTO materialeliste values   
	(5, 'Træ & Tagplader', '38x73 mm. Lægte ubh.', 'm', 20.95, 100);
INSERT INTO materialeliste values   
	(6, 'Træ & Tagplader', '45x95 mm. Reglar ub.', 'm', 14.75, 100);
INSERT INTO materialeliste values   
	(8, 'Træ & Tagplader', '45x195 mm. spærtræ ubh.', 'm', 37.95, 100);
INSERT INTO materialeliste values   
	(11, 'Træ & Tagplader', '297x97 mm. trykimp. Stolpe', 'm', 77.95, 100);
INSERT INTO materialeliste values   
	(14, 'Træ & Tagplader', '19x100	mm. trykimp. Brædt', 'm', 6.95, 100);
INSERT INTO materialeliste values   
	(15, 'Træ & Tagplader', 'Plastmo Ecolite blåtonet', 'stk', 510.00, 1);
INSERT INTO materialeliste values   
	(16, 'Træ & Tagplader', 'Plastmo Ecolite blåtonet', 'Stk', 339.00, 1);
INSERT INTO materialeliste values   
	(17, 'Beslag & Skruer', 'Plastmo bundskruer 200 stk', 'Pakke', 197.95, 1);
INSERT INTO materialeliste values   
	(18, 'Beslag & Skruer', 'hulbånd 1x20 mm. 10 mtr.', 'Rulle', 189.00, 1);
INSERT INTO materialeliste values   
	(19, 'Beslag & Skruer', 'Universal 190 mm højre', 'Stk', 37.00, 1);
INSERT INTO materialeliste values   
	(20, 'Beslag & Skruer', 'Universal 190 mm venstre', 'Stk', 37.00, 1);
INSERT INTO materialeliste values   
	(21, 'Beslag & Skruer', '4,5 x 60 mm. skruer 200 stk.', 'Pakke', 109.00, 1);
INSERT INTO materialeliste values   
	(22, 'Beslag & Skruer', '4,0 x 50 mm. beslagskruer 250 stk.', 'Pakke', 159.00, 1);
INSERT INTO materialeliste values   
	(23, 'Beslag & Skruer', 'Bræddebolt 10 x 120 mm.', 'Stk', 18.76, 1);
INSERT INTO materialeliste values   
	(24, 'Beslag & Skruer', 'Firkantskiver 40x40x11mm.', 'Stk', 9.76, 1);
INSERT INTO materialeliste values   
	(25, 'Beslag & Skruer', '4,5 x 70 mm. Skruer 400 stk.', 'Pakke', 289.00, 1);
INSERT INTO materialeliste values   
	(26, 'Beslag & Skruer', '4,5 x 50 mm. Skruer 300 stk.', 'Pakke', 229.00, 1);
INSERT INTO materialeliste values   
	(27, 'Beslag & Skruer', 'Stalddørsgreb 50x75', 'Sæt', 189.00, 1);
INSERT INTO materialeliste values   
	(28, 'Beslag & Skruer', 'T hængsel 390 mm.', 'Stk', 119.95, 1);
INSERT INTO materialeliste values   
	(29, 'Beslag & Skruer', 'Vinkelbeslag 35', 'Stk', 2.50, 1);

commit;    
    

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;