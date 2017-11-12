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
    
drop table if exists `linjeliste`;
create table `linjeliste`(
`linjeliste_id`int(11) not null auto_increment, 
`materialetype`varchar (45), 
`dimension`varchar (1),
`baselength`double(11,2), 
`antal`int (5),
`beskrivelse`varchar(100),
primary key (linjeliste_id));

drop table if exists `lineitem`;
create table `lineitem`(
    `linjeliste_id`int(11) ,
    `vareid`int (20),
    `linjepris`double(11,2),
    primary key (linjeliste_id, vareid));
      
     
    
-- Data til materialelisten 
INSERT INTO materialeliste values -- vareid, varenummer, materialetype, materialenavn, enhed, enhedsprise, længde 
	(1, 'Træ', '25x200 mm. trykimp. Brædt', 'Stk', 50.95, 100); -- 1085025200 0300
INSERT INTO materialeliste values  
	(2, 'Træ', '25x125 mm. trykimp. Brædt', 'Stk', 29.95, 100);
INSERT INTO materialeliste values   
	(3, 'Træ', '38x73 mm. Lægte ubh.', 'Stk', 20.95, 100);
INSERT INTO materialeliste values   
	(4, 'Træ', '45x95 mm. Reglar ub.', 'Stk', 14.75, 100);
INSERT INTO materialeliste values   
	(5, 'Træ', '45x195 mm. spærtræ ubh.', 'Stk', 37.95, 100);
INSERT INTO materialeliste values   
	(6, 'Træ', '97x97 mm. trykimp. Stolpe', 'Stk', 77.95, 100);
INSERT INTO materialeliste values   
	(7, 'Træ', '19x100	mm. trykimp. Brædt', 'Stk', 6.95, 100);
INSERT INTO materialeliste values  
	(10, 'Træ', '25x150 mm. trykimp. Brædt', 'Stk', 37.95, 100); -- 1085025150 0300
INSERT INTO materialeliste values  
	(11, 'Træ', '25x50 mm. trykimp. Brædt', 'Stk', 19.95, 100); -- ingen vr.
INSERT INTO materialeliste values  
	(12, 'Træ', 'Færdigskåret (byg-selv spær)', 'sæt', 2200.00, 0); -- ingen vr. 

-- Beslag og Skruer    
INSERT INTO materialeliste values   
	(13, 'Beslag & Skruer', 'Plastmo bundskruer 200 stk', 'Pakke', 197.95, 0);
INSERT INTO materialeliste values   
	(14, 'Beslag & Skruer', 'hulbånd 1x20 mm. 10 mtr.', 'Rulle', 189.00, 0);
INSERT INTO materialeliste values   
	(15, 'Beslag & Skruer', 'Universal 190 mm højre', 'Stk', 37.00, 0);
INSERT INTO materialeliste values   
	(16, 'Beslag & Skruer', 'Universal 190 mm venstre', 'Stk', 37.00, 0);
INSERT INTO materialeliste values   
	(17, 'Beslag & Skruer', '4,5 x 60 mm. skruer 200 stk.', 'Pakke', 109.00, 0);
INSERT INTO materialeliste values   
	(18, 'Beslag & Skruer', '4,0 x 50 mm. beslagskruer 250 stk.', 'Pakke', 159.00, 0);
INSERT INTO materialeliste values   
	(19, 'Beslag & Skruer', 'Bræddebolt 10 x 120 mm.', 'Stk', 18.76, 0);
INSERT INTO materialeliste values   
	(20, 'Beslag & Skruer', 'Firkantskiver 40x40x11mm.', 'Stk', 9.76, 0);
INSERT INTO materialeliste values   
	(21, 'Beslag & Skruer', '4,5 x 70 mm. Skruer 400 stk.', 'Pakke', 289.00, 0);
INSERT INTO materialeliste values   
	(22, 'Beslag & Skruer', '4,5 x 50 mm. Skruer 300 stk.', 'Pakke', 229.00, 0);
INSERT INTO materialeliste values   
	(23, 'Beslag & Skruer', 'Stalddørsgreb 50x75', 'Sæt', 189.00, 0);
INSERT INTO materialeliste values   
	(24, 'Beslag & Skruer', 'T hængsel 390 mm.', 'Stk', 119.95, 0);
INSERT INTO materialeliste values   
	(25, 'Beslag & Skruer', 'Vinkelbeslag 35', 'Stk', 2.50, 0);
INSERT INTO materialeliste values   
	(26, 'Beslag & Skruer', '5,0 x 40 mm. beslagskruer 250 stk.', 'Pakke', 229.00, 0); -- ingen vr.
INSERT INTO materialeliste values   
	(27, 'Beslag & Skruer', '5,0 x 100 mm. Skruer 100 stk.', 'Pakke', 339.00, 0); -- ingen vr.
    
-- Tagpakken
INSERT INTO materialeliste values   
	(8, 'Tagpakken', 'Plastmo Ecolite blåtonet', 'Stk', 510.00, 600);
INSERT INTO materialeliste values   
	(9, 'Tagpakken', 'Plastmo Ecolite blåtonet', 'Stk', 339.00, 360);
INSERT INTO materialeliste values   
	(28, 'Tagpakken', 'B & C Dobbelt -s sort', 'Stk', 49.95, 0); -- ingen vr.
INSERT INTO materialeliste values   
	(29, 'Tagpakken', 'B & C Rygsten sort', 'Stk', 89.95, 0); -- 7921695
INSERT INTO materialeliste values   
	(30, 'Tagpakken', 'B & C Toplægtholder', 'Stk', 18.50, 0); -- ingen vr.
INSERT INTO materialeliste values   
	(31, 'Tagpakken', 'B & C Rygstensbeslag', 'Stk', 294.00, 0); -- ingen vr. 
INSERT INTO materialeliste values   
	(32, 'Tagpakken', 'B & C Tagstensbindere & nakkekroge', 'Pk', 524.00, 0); -- ingen vr.
    
-- Data til linjelisten 
INSERT  INTO linjeliste   values
(null, 'Træ & Tagplader', 'b', 360,4, 'Understernbrædder til for og bagende'),
( null,'Træ & Tagplader', 'l', 540,4, 'Understernbrædder til siderne'), 
(null, 'Træ & Tagplader', 'b', 360, 2,'Oversternbrædder til for og bagende'),
(null, 'Træ & Tagplader', 'l', 540, 4,'Oversternbrædder til siderne'), 
(null, 'Træ & Tagplader', 'u', 420,1, 'Til z på bagside af dør'),
(null, 'Træ & Tagplader', 's', 270,12, 'Løsholter til skurgavle'),
(null, 'Træ & Tagplader', 's', 240,4, 'Løsholter til skursider'),
(null, 'Træ & Tagplader', 'l', 600,2, 'Remme i sider, sadles ned i stolper, carport-del'),
(null, 'Træ & Tagplader', 's', 480,1, 'Remme i sider, sadles ned i stolper, skur-del');

INSERT  INTO linjeliste   values
(null, 'Træ & Tagplader', 'l', 600, 15,'Spær, monteres på rem'),
( null,'Træ & Tagplader', 'h', 300,11, 'Stolper, nedgraves i 90 cm. jord'), 
(null, 'Træ & Tagplader', 's', 210, 200,'Til beklædning af skur 1 på 2'),
(null, 'Træ & Tagplader', 'l', 540,4, 'Vandbrædt på stern i sider'), 
(null, 'Træ & Tagplader', 'b', 360,2, 'Vandbrædt på stern i forende'),
(null, 'Træ & Tagplader', 'l', 600, 6,'Tagplader monteres på spær'),
(null, 'Træ & Tagplader', 'b', 360, 6,'Tagplader monteres på spær');

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


insert into lineitem values
(1,1,null),
(2,1,null),
(3,2,null),
(4,2,null),
(5,5,null),
(6,6,null),
(7,6,null),
(8,8,null),
(9,8,null),
(10,8,null),
(11,11,null),
(12,14,null),
(13,14,null),
(14,14,null),
(15,15,null),
(16,16,null);

insert into lineitem values
(17,17,null),
(18,18,null),
(19,19,null),
(20,20,null),
(21,21,null),
(22,22,null),
(23,23,null),
(24,24,null),
(25,25,null),
(26,26,null),
(27,27,null),
(28,28,null),
(29,29,null);

select lineitem.linjeliste_id, materialeliste.materialetype, linjeliste.beskrivelse,
                    materialeliste.materialenavn,enhed, enhedspris, antal from linjeliste,
                    materialeliste, lineitem where materialeliste.vareid=lineitem.vareid 
                   and linjeliste.linjeliste_id=lineitem.linjeliste_id;
select*from materialeliste;
select * from linjeliste;
commit;    
    
select linjeliste.beskrivelse, materialeliste.materialenavn, enhedspris, antal from linjeliste, materialeliste, lineitem where materialeliste.vareid=lineitem.vareid and linjeliste.linjeliste_id=lineitem.linjeliste_id;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;