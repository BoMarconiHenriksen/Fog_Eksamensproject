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
DROP TABLE IF EXISTS `zipcodelis`;
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

-- Data til zipcodelist
INSERT INTO zipcodelist VALUES (1000,'København K');
INSERT INTO zipcodelist VALUES (1001,'København K');
INSERT INTO zipcodelist VALUES (1002,'København K');
INSERT INTO zipcodelist VALUES (1003,'København K');
INSERT INTO zipcodelist VALUES (1004,'København K');
INSERT INTO zipcodelist VALUES (1005,'København K');
INSERT INTO zipcodelist VALUES (1006,'København K');
INSERT INTO zipcodelist VALUES (1007,'København K');
INSERT INTO zipcodelist VALUES (1008,'København K');
INSERT INTO zipcodelist VALUES (1009,'København K');
INSERT INTO zipcodelist VALUES (1010,'København K');
INSERT INTO zipcodelist VALUES (1011,'København K');
INSERT INTO zipcodelist VALUES (1012,'København K');
INSERT INTO zipcodelist VALUES (1013,'København K');
INSERT INTO zipcodelist VALUES (1014,'København K');
INSERT INTO zipcodelist VALUES (1015,'København K');
INSERT INTO zipcodelist VALUES (1016,'København K');
INSERT INTO zipcodelist VALUES (1017,'København K');
INSERT INTO zipcodelist VALUES (1018,'København K');
INSERT INTO zipcodelist VALUES (1019,'København K');
INSERT INTO zipcodelist VALUES (1020,'København K');
INSERT INTO zipcodelist VALUES (1021,'København K');
INSERT INTO zipcodelist VALUES (1022,'København K');
INSERT INTO zipcodelist VALUES (1023,'København K');
INSERT INTO zipcodelist VALUES (1024,'København K');
INSERT INTO zipcodelist VALUES (1025,'København K');
INSERT INTO zipcodelist VALUES (1026,'København K');
INSERT INTO zipcodelist VALUES (1045,'København K');
INSERT INTO zipcodelist VALUES (1050,'København K');
INSERT INTO zipcodelist VALUES (1051,'København K');
INSERT INTO zipcodelist VALUES (1052,'København K');
INSERT INTO zipcodelist VALUES (1053,'København K');
INSERT INTO zipcodelist VALUES (1054,'København K');
INSERT INTO zipcodelist VALUES (1055,'København K');
INSERT INTO zipcodelist VALUES (1056,'København K');
INSERT INTO zipcodelist VALUES (1057,'København K');
INSERT INTO zipcodelist VALUES (1058,'København K');
INSERT INTO zipcodelist VALUES (1059,'København K');
INSERT INTO zipcodelist VALUES (1060,'København K');
INSERT INTO zipcodelist VALUES (1061,'København K');
INSERT INTO zipcodelist VALUES (1062,'København K');
INSERT INTO zipcodelist VALUES (1063,'København K');
INSERT INTO zipcodelist VALUES (1064,'København K');
INSERT INTO zipcodelist VALUES (1065,'København K');
INSERT INTO zipcodelist VALUES (1066,'København K');
INSERT INTO zipcodelist VALUES (1067,'København K');
INSERT INTO zipcodelist VALUES (1068,'København K');
INSERT INTO zipcodelist VALUES (1069,'København K');
INSERT INTO zipcodelist VALUES (1070,'København K');
INSERT INTO zipcodelist VALUES (1071,'København K');
INSERT INTO zipcodelist VALUES (1072,'København K');
INSERT INTO zipcodelist VALUES (1073,'København K');
INSERT INTO zipcodelist VALUES (1074,'København K');
INSERT INTO zipcodelist VALUES (1092,'København K');
INSERT INTO zipcodelist VALUES (1093,'København K');
INSERT INTO zipcodelist VALUES (1095,'København K');
INSERT INTO zipcodelist VALUES (1098,'København K');
INSERT INTO zipcodelist VALUES (1100,'København K');
INSERT INTO zipcodelist VALUES (1101,'København K');
INSERT INTO zipcodelist VALUES (1102,'København K');
INSERT INTO zipcodelist VALUES (1103,'København K');
INSERT INTO zipcodelist VALUES (1104,'København K');
INSERT INTO zipcodelist VALUES (1105,'København K');
INSERT INTO zipcodelist VALUES (1106,'København K');
INSERT INTO zipcodelist VALUES (1107,'København K');
INSERT INTO zipcodelist VALUES (1110,'København K');
INSERT INTO zipcodelist VALUES (1111,'København K');
INSERT INTO zipcodelist VALUES (1112,'København K');
INSERT INTO zipcodelist VALUES (1113,'København K');
INSERT INTO zipcodelist VALUES (1114,'København K');
INSERT INTO zipcodelist VALUES (1115,'København K');
INSERT INTO zipcodelist VALUES (1116,'København K');
INSERT INTO zipcodelist VALUES (1117,'København K');
INSERT INTO zipcodelist VALUES (1118,'København K');
INSERT INTO zipcodelist VALUES (1119,'København K');
INSERT INTO zipcodelist VALUES (1120,'København K');
INSERT INTO zipcodelist VALUES (1121,'København K');
INSERT INTO zipcodelist VALUES (1122,'København K');
INSERT INTO zipcodelist VALUES (1123,'København K');
INSERT INTO zipcodelist VALUES (1124,'København K');
INSERT INTO zipcodelist VALUES (1125,'København K');
INSERT INTO zipcodelist VALUES (1126,'København K');
INSERT INTO zipcodelist VALUES (1127,'København K');
INSERT INTO zipcodelist VALUES (1128,'København K');
INSERT INTO zipcodelist VALUES (1129,'København K');
INSERT INTO zipcodelist VALUES (1130,'København K');
INSERT INTO zipcodelist VALUES (1131,'København K');
INSERT INTO zipcodelist VALUES (1140,'København K');
INSERT INTO zipcodelist VALUES (1147,'København K');
INSERT INTO zipcodelist VALUES (1148,'København K');
INSERT INTO zipcodelist VALUES (1150,'København K');
INSERT INTO zipcodelist VALUES (1151,'København K');
INSERT INTO zipcodelist VALUES (1152,'København K');
INSERT INTO zipcodelist VALUES (1153,'København K');
INSERT INTO zipcodelist VALUES (1154,'København K');
INSERT INTO zipcodelist VALUES (1155,'København K');
INSERT INTO zipcodelist VALUES (1156,'København K');
INSERT INTO zipcodelist VALUES (1157,'København K');
INSERT INTO zipcodelist VALUES (1158,'København K');
INSERT INTO zipcodelist VALUES (1159,'København K');
INSERT INTO zipcodelist VALUES (1160,'København K');
INSERT INTO zipcodelist VALUES (1161,'København K');
INSERT INTO zipcodelist VALUES (1162,'København K');
INSERT INTO zipcodelist VALUES (1163,'København K');
INSERT INTO zipcodelist VALUES (1164,'København K');
INSERT INTO zipcodelist VALUES (1165,'København K');
INSERT INTO zipcodelist VALUES (1166,'København K');
INSERT INTO zipcodelist VALUES (1167,'København K');
INSERT INTO zipcodelist VALUES (1168,'København K');
INSERT INTO zipcodelist VALUES (1169,'København K');
INSERT INTO zipcodelist VALUES (1170,'København K');
INSERT INTO zipcodelist VALUES (1171,'København K');
INSERT INTO zipcodelist VALUES (1172,'København K');
INSERT INTO zipcodelist VALUES (1173,'København K');
INSERT INTO zipcodelist VALUES (1174,'København K');
INSERT INTO zipcodelist VALUES (1175,'København K');
INSERT INTO zipcodelist VALUES (1200,'København K');
INSERT INTO zipcodelist VALUES (1201,'København K');
INSERT INTO zipcodelist VALUES (1202,'København K');
INSERT INTO zipcodelist VALUES (1203,'København K');
INSERT INTO zipcodelist VALUES (1204,'København K');
INSERT INTO zipcodelist VALUES (1205,'København K');
INSERT INTO zipcodelist VALUES (1206,'København K');
INSERT INTO zipcodelist VALUES (1207,'København K');
INSERT INTO zipcodelist VALUES (1208,'København K');
INSERT INTO zipcodelist VALUES (1209,'København K');
INSERT INTO zipcodelist VALUES (1210,'København K');
INSERT INTO zipcodelist VALUES (1211,'København K');
INSERT INTO zipcodelist VALUES (1212,'København K');
INSERT INTO zipcodelist VALUES (1213,'København K');
INSERT INTO zipcodelist VALUES (1214,'København K');
INSERT INTO zipcodelist VALUES (1215,'København K');
INSERT INTO zipcodelist VALUES (1216,'København K');
INSERT INTO zipcodelist VALUES (1217,'København K');
INSERT INTO zipcodelist VALUES (1218,'København K');
INSERT INTO zipcodelist VALUES (1219,'København K');
INSERT INTO zipcodelist VALUES (1220,'København K');
INSERT INTO zipcodelist VALUES (1221,'København K');
INSERT INTO zipcodelist VALUES (1240,'København K');
INSERT INTO zipcodelist VALUES (1250,'København K');
INSERT INTO zipcodelist VALUES (1251,'København K');
INSERT INTO zipcodelist VALUES (1253,'København K');
INSERT INTO zipcodelist VALUES (1254,'København K');
INSERT INTO zipcodelist VALUES (1255,'København K');
INSERT INTO zipcodelist VALUES (1256,'København K');
INSERT INTO zipcodelist VALUES (1257,'København K');
INSERT INTO zipcodelist VALUES (1259,'København K');
INSERT INTO zipcodelist VALUES (1260,'København K');
INSERT INTO zipcodelist VALUES (1261,'København K');
INSERT INTO zipcodelist VALUES (1263,'København K');
INSERT INTO zipcodelist VALUES (1264,'København K');
INSERT INTO zipcodelist VALUES (1265,'København K');
INSERT INTO zipcodelist VALUES (1266,'København K');
INSERT INTO zipcodelist VALUES (1267,'København K');
INSERT INTO zipcodelist VALUES (1268,'København K');
INSERT INTO zipcodelist VALUES (1270,'København K');
INSERT INTO zipcodelist VALUES (1271,'København K');
INSERT INTO zipcodelist VALUES (1300,'København K');
INSERT INTO zipcodelist VALUES (1301,'København K');
INSERT INTO zipcodelist VALUES (1302,'København K');
INSERT INTO zipcodelist VALUES (1303,'København K');
INSERT INTO zipcodelist VALUES (1304,'København K');
INSERT INTO zipcodelist VALUES (1306,'København K');
INSERT INTO zipcodelist VALUES (1307,'København K');
INSERT INTO zipcodelist VALUES (1308,'København K');
INSERT INTO zipcodelist VALUES (1309,'København K');
INSERT INTO zipcodelist VALUES (1310,'København K');
INSERT INTO zipcodelist VALUES (1311,'København K');
INSERT INTO zipcodelist VALUES (1312,'København K');
INSERT INTO zipcodelist VALUES (1313,'København K');
INSERT INTO zipcodelist VALUES (1314,'København K');
INSERT INTO zipcodelist VALUES (1315,'København K');
INSERT INTO zipcodelist VALUES (1316,'København K');
INSERT INTO zipcodelist VALUES (1317,'København K');
INSERT INTO zipcodelist VALUES (1318,'København K');
INSERT INTO zipcodelist VALUES (1319,'København K');
INSERT INTO zipcodelist VALUES (1320,'København K');
INSERT INTO zipcodelist VALUES (1321,'København K');
INSERT INTO zipcodelist VALUES (1322,'København K');
INSERT INTO zipcodelist VALUES (1323,'København K');
INSERT INTO zipcodelist VALUES (1324,'København K');
INSERT INTO zipcodelist VALUES (1325,'København K');
INSERT INTO zipcodelist VALUES (1326,'København K');
INSERT INTO zipcodelist VALUES (1327,'København K');
INSERT INTO zipcodelist VALUES (1328,'København K');
INSERT INTO zipcodelist VALUES (1329,'København K');
INSERT INTO zipcodelist VALUES (1350,'København K');
INSERT INTO zipcodelist VALUES (1352,'København K');
INSERT INTO zipcodelist VALUES (1353,'København K');
INSERT INTO zipcodelist VALUES (1354,'København K');
INSERT INTO zipcodelist VALUES (1355,'København K');
INSERT INTO zipcodelist VALUES (1356,'København K');
INSERT INTO zipcodelist VALUES (1357,'København K');
INSERT INTO zipcodelist VALUES (1358,'København K');
INSERT INTO zipcodelist VALUES (1359,'København K');
INSERT INTO zipcodelist VALUES (1360,'København K');
INSERT INTO zipcodelist VALUES (1361,'København K');
INSERT INTO zipcodelist VALUES (1362,'København K');
INSERT INTO zipcodelist VALUES (1363,'København K');
INSERT INTO zipcodelist VALUES (1364,'København K');
INSERT INTO zipcodelist VALUES (1365,'København K');
INSERT INTO zipcodelist VALUES (1366,'København K');
INSERT INTO zipcodelist VALUES (1367,'København K');
INSERT INTO zipcodelist VALUES (1368,'København K');
INSERT INTO zipcodelist VALUES (1369,'København K');
INSERT INTO zipcodelist VALUES (1370,'København K');
INSERT INTO zipcodelist VALUES (1371,'København K');
INSERT INTO zipcodelist VALUES (1400,'København K');
INSERT INTO zipcodelist VALUES (1401,'København K');
INSERT INTO zipcodelist VALUES (1402,'København K');
INSERT INTO zipcodelist VALUES (1403,'København K');
INSERT INTO zipcodelist VALUES (1404,'København K');
INSERT INTO zipcodelist VALUES (1406,'København K');
INSERT INTO zipcodelist VALUES (1407,'København K');
INSERT INTO zipcodelist VALUES (1408,'København K');
INSERT INTO zipcodelist VALUES (1409,'København K');
INSERT INTO zipcodelist VALUES (1410,'København K');
INSERT INTO zipcodelist VALUES (1411,'København K');
INSERT INTO zipcodelist VALUES (1412,'København K');
INSERT INTO zipcodelist VALUES (1413,'København K');
INSERT INTO zipcodelist VALUES (1414,'København K');
INSERT INTO zipcodelist VALUES (1415,'København K');
INSERT INTO zipcodelist VALUES (1416,'København K');
INSERT INTO zipcodelist VALUES (1417,'København K');
INSERT INTO zipcodelist VALUES (1418,'København K');
INSERT INTO zipcodelist VALUES (1419,'København K');
INSERT INTO zipcodelist VALUES (1420,'København K');
INSERT INTO zipcodelist VALUES (1421,'København K');
INSERT INTO zipcodelist VALUES (1422,'København K');
INSERT INTO zipcodelist VALUES (1423,'København K');
INSERT INTO zipcodelist VALUES (1424,'København K');
INSERT INTO zipcodelist VALUES (1425,'København K');
INSERT INTO zipcodelist VALUES (1426,'København K');
INSERT INTO zipcodelist VALUES (1427,'København K');
INSERT INTO zipcodelist VALUES (1428,'København K');
INSERT INTO zipcodelist VALUES (1429,'København K');
INSERT INTO zipcodelist VALUES (1430,'København K');
INSERT INTO zipcodelist VALUES (1431,'København K');
INSERT INTO zipcodelist VALUES (1432,'København K');
INSERT INTO zipcodelist VALUES (1433,'København K');
INSERT INTO zipcodelist VALUES (1434,'København K');
INSERT INTO zipcodelist VALUES (1435,'København K');
INSERT INTO zipcodelist VALUES (1436,'København K');
INSERT INTO zipcodelist VALUES (1437,'København K');
INSERT INTO zipcodelist VALUES (1438,'København K');
INSERT INTO zipcodelist VALUES (1439,'København K');
INSERT INTO zipcodelist VALUES (1440,'København K');
INSERT INTO zipcodelist VALUES (1441,'København K');
INSERT INTO zipcodelist VALUES (1448,'København K');
INSERT INTO zipcodelist VALUES (1450,'København K');
INSERT INTO zipcodelist VALUES (1451,'København K');
INSERT INTO zipcodelist VALUES (1452,'København K');
INSERT INTO zipcodelist VALUES (1453,'København K');
INSERT INTO zipcodelist VALUES (1454,'København K');
INSERT INTO zipcodelist VALUES (1455,'København K');
INSERT INTO zipcodelist VALUES (1456,'København K');
INSERT INTO zipcodelist VALUES (1457,'København K');
INSERT INTO zipcodelist VALUES (1458,'København K');
INSERT INTO zipcodelist VALUES (1459,'København K');
INSERT INTO zipcodelist VALUES (1460,'København K');
INSERT INTO zipcodelist VALUES (1461,'København K');
INSERT INTO zipcodelist VALUES (1462,'København K');
INSERT INTO zipcodelist VALUES (1463,'København K');
INSERT INTO zipcodelist VALUES (1464,'København K');
INSERT INTO zipcodelist VALUES (1465,'København K');
INSERT INTO zipcodelist VALUES (1466,'København K');
INSERT INTO zipcodelist VALUES (1467,'København K');
INSERT INTO zipcodelist VALUES (1468,'København K');
INSERT INTO zipcodelist VALUES (1470,'København K');
INSERT INTO zipcodelist VALUES (1471,'København K');
INSERT INTO zipcodelist VALUES (1472,'København K');
INSERT INTO zipcodelist VALUES (1473,'København K');
INSERT INTO zipcodelist VALUES (1500,'København V');
INSERT INTO zipcodelist VALUES (1501,'København V');
INSERT INTO zipcodelist VALUES (1502,'København V');
INSERT INTO zipcodelist VALUES (1503,'København V');
INSERT INTO zipcodelist VALUES (1504,'København V');
INSERT INTO zipcodelist VALUES (1505,'København V');
INSERT INTO zipcodelist VALUES (1506,'København V');
INSERT INTO zipcodelist VALUES (1507,'København V');
INSERT INTO zipcodelist VALUES (1508,'København V');
INSERT INTO zipcodelist VALUES (1509,'København V');
INSERT INTO zipcodelist VALUES (1510,'København V');
INSERT INTO zipcodelist VALUES (1512,'København V');
INSERT INTO zipcodelist VALUES (1513,'København V');
INSERT INTO zipcodelist VALUES (1532,'København V');
INSERT INTO zipcodelist VALUES (1533,'København V');
INSERT INTO zipcodelist VALUES (1550,'København V');
INSERT INTO zipcodelist VALUES (1551,'København V');
INSERT INTO zipcodelist VALUES (1552,'København V');
INSERT INTO zipcodelist VALUES (1553,'København V');
INSERT INTO zipcodelist VALUES (1554,'København V');
INSERT INTO zipcodelist VALUES (1555,'København V');
INSERT INTO zipcodelist VALUES (1556,'København V');
INSERT INTO zipcodelist VALUES (1557,'København V');
INSERT INTO zipcodelist VALUES (1558,'København V');
INSERT INTO zipcodelist VALUES (1559,'København V');
INSERT INTO zipcodelist VALUES (1560,'København V');
INSERT INTO zipcodelist VALUES (1561,'København V');
INSERT INTO zipcodelist VALUES (1562,'København V');
INSERT INTO zipcodelist VALUES (1563,'København V');
INSERT INTO zipcodelist VALUES (1564,'København V');
INSERT INTO zipcodelist VALUES (1566,'København V');
INSERT INTO zipcodelist VALUES (1567,'København V');
INSERT INTO zipcodelist VALUES (1568,'København V');
INSERT INTO zipcodelist VALUES (1569,'København V');
INSERT INTO zipcodelist VALUES (1570,'København V');
INSERT INTO zipcodelist VALUES (1571,'København V');
INSERT INTO zipcodelist VALUES (1572,'København V');
INSERT INTO zipcodelist VALUES (1573,'København V');
INSERT INTO zipcodelist VALUES (1574,'København V');
INSERT INTO zipcodelist VALUES (1575,'København V');
INSERT INTO zipcodelist VALUES (1576,'København V');
INSERT INTO zipcodelist VALUES (1577,'København V');
INSERT INTO zipcodelist VALUES (1592,'København V');
INSERT INTO zipcodelist VALUES (1599,'København V');
INSERT INTO zipcodelist VALUES (1600,'København V');
INSERT INTO zipcodelist VALUES (1601,'København V');
INSERT INTO zipcodelist VALUES (1602,'København V');
INSERT INTO zipcodelist VALUES (1603,'København V');
INSERT INTO zipcodelist VALUES (1604,'København V');
INSERT INTO zipcodelist VALUES (1605,'København V');
INSERT INTO zipcodelist VALUES (1606,'København V');
INSERT INTO zipcodelist VALUES (1607,'København V');
INSERT INTO zipcodelist VALUES (1608,'København V');
INSERT INTO zipcodelist VALUES (1609,'København V');
INSERT INTO zipcodelist VALUES (1610,'København V');
INSERT INTO zipcodelist VALUES (1611,'København V');
INSERT INTO zipcodelist VALUES (1612,'København V');
INSERT INTO zipcodelist VALUES (1613,'København V');
INSERT INTO zipcodelist VALUES (1614,'København V');
INSERT INTO zipcodelist VALUES (1615,'København V');
INSERT INTO zipcodelist VALUES (1616,'København V');
INSERT INTO zipcodelist VALUES (1617,'København V');
INSERT INTO zipcodelist VALUES (1618,'København V');
INSERT INTO zipcodelist VALUES (1619,'København V');
INSERT INTO zipcodelist VALUES (1620,'København V');
INSERT INTO zipcodelist VALUES (1621,'København V');
INSERT INTO zipcodelist VALUES (1622,'København V');
INSERT INTO zipcodelist VALUES (1623,'København V');
INSERT INTO zipcodelist VALUES (1624,'København V');
INSERT INTO zipcodelist VALUES (1630,'København V');
INSERT INTO zipcodelist VALUES (1631,'København V');
INSERT INTO zipcodelist VALUES (1632,'København V');
INSERT INTO zipcodelist VALUES (1633,'København V');
INSERT INTO zipcodelist VALUES (1634,'København V');
INSERT INTO zipcodelist VALUES (1635,'København V');
INSERT INTO zipcodelist VALUES (1650,'København V');
INSERT INTO zipcodelist VALUES (1651,'København V');
INSERT INTO zipcodelist VALUES (1652,'København V');
INSERT INTO zipcodelist VALUES (1653,'København V');
INSERT INTO zipcodelist VALUES (1654,'København V');
INSERT INTO zipcodelist VALUES (1655,'København V');
INSERT INTO zipcodelist VALUES (1656,'København V');
INSERT INTO zipcodelist VALUES (1657,'København V');
INSERT INTO zipcodelist VALUES (1658,'København V');
INSERT INTO zipcodelist VALUES (1659,'København V');
INSERT INTO zipcodelist VALUES (1660,'København V');
INSERT INTO zipcodelist VALUES (1661,'København V');
INSERT INTO zipcodelist VALUES (1662,'København V');
INSERT INTO zipcodelist VALUES (1663,'København V');
INSERT INTO zipcodelist VALUES (1664,'København V');
INSERT INTO zipcodelist VALUES (1665,'København V');
INSERT INTO zipcodelist VALUES (1666,'København V');
INSERT INTO zipcodelist VALUES (1667,'København V');
INSERT INTO zipcodelist VALUES (1668,'København V');
INSERT INTO zipcodelist VALUES (1669,'København V');
INSERT INTO zipcodelist VALUES (1670,'København V');
INSERT INTO zipcodelist VALUES (1671,'København V');
INSERT INTO zipcodelist VALUES (1672,'København V');
INSERT INTO zipcodelist VALUES (1673,'København V');
INSERT INTO zipcodelist VALUES (1674,'København V');
INSERT INTO zipcodelist VALUES (1675,'København V');
INSERT INTO zipcodelist VALUES (1676,'København V');
INSERT INTO zipcodelist VALUES (1677,'København V');
INSERT INTO zipcodelist VALUES (1699,'København V');
INSERT INTO zipcodelist VALUES (1700,'København V');
INSERT INTO zipcodelist VALUES (1701,'København V');
INSERT INTO zipcodelist VALUES (1702,'København V');
INSERT INTO zipcodelist VALUES (1703,'København V');
INSERT INTO zipcodelist VALUES (1704,'København V');
INSERT INTO zipcodelist VALUES (1705,'København V');
INSERT INTO zipcodelist VALUES (1706,'København V');
INSERT INTO zipcodelist VALUES (1707,'København V');
INSERT INTO zipcodelist VALUES (1708,'København V');
INSERT INTO zipcodelist VALUES (1709,'København V');
INSERT INTO zipcodelist VALUES (1710,'København V');
INSERT INTO zipcodelist VALUES (1711,'København V');
INSERT INTO zipcodelist VALUES (1712,'København V');
INSERT INTO zipcodelist VALUES (1713,'København V');
INSERT INTO zipcodelist VALUES (1714,'København V');
INSERT INTO zipcodelist VALUES (1715,'København V');
INSERT INTO zipcodelist VALUES (1716,'København V');
INSERT INTO zipcodelist VALUES (1717,'København V');
INSERT INTO zipcodelist VALUES (1718,'København V');
INSERT INTO zipcodelist VALUES (1719,'København V');
INSERT INTO zipcodelist VALUES (1720,'København V');
INSERT INTO zipcodelist VALUES (1721,'København V');
INSERT INTO zipcodelist VALUES (1722,'København V');
INSERT INTO zipcodelist VALUES (1723,'København V');
INSERT INTO zipcodelist VALUES (1724,'København V');
INSERT INTO zipcodelist VALUES (1725,'København V');
INSERT INTO zipcodelist VALUES (1726,'København V');
INSERT INTO zipcodelist VALUES (1727,'København V');
INSERT INTO zipcodelist VALUES (1728,'København V');
INSERT INTO zipcodelist VALUES (1729,'København V');
INSERT INTO zipcodelist VALUES (1730,'København V');
INSERT INTO zipcodelist VALUES (1731,'København V');
INSERT INTO zipcodelist VALUES (1732,'København V');
INSERT INTO zipcodelist VALUES (1733,'København V');
INSERT INTO zipcodelist VALUES (1734,'København V');
INSERT INTO zipcodelist VALUES (1735,'København V');
INSERT INTO zipcodelist VALUES (1736,'København V');
INSERT INTO zipcodelist VALUES (1737,'København V');
INSERT INTO zipcodelist VALUES (1738,'København V');
INSERT INTO zipcodelist VALUES (1739,'København V');
INSERT INTO zipcodelist VALUES (1749,'København V');
INSERT INTO zipcodelist VALUES (1750,'København V');
INSERT INTO zipcodelist VALUES (1751,'København V');
INSERT INTO zipcodelist VALUES (1752,'København V');
INSERT INTO zipcodelist VALUES (1753,'København V');
INSERT INTO zipcodelist VALUES (1754,'København V');
INSERT INTO zipcodelist VALUES (1755,'København V');
INSERT INTO zipcodelist VALUES (1756,'København V');
INSERT INTO zipcodelist VALUES (1757,'København V');
INSERT INTO zipcodelist VALUES (1758,'København V');
INSERT INTO zipcodelist VALUES (1759,'København V');
INSERT INTO zipcodelist VALUES (1760,'København V');
INSERT INTO zipcodelist VALUES (1761,'København V');
INSERT INTO zipcodelist VALUES (1762,'København V');
INSERT INTO zipcodelist VALUES (1763,'København V');
INSERT INTO zipcodelist VALUES (1764,'København V');
INSERT INTO zipcodelist VALUES (1765,'København V');
INSERT INTO zipcodelist VALUES (1766,'København V');
INSERT INTO zipcodelist VALUES (1770,'København V');
INSERT INTO zipcodelist VALUES (1771,'København V');
INSERT INTO zipcodelist VALUES (1772,'København V');
INSERT INTO zipcodelist VALUES (1773,'København V');
INSERT INTO zipcodelist VALUES (1774,'København V');
INSERT INTO zipcodelist VALUES (1775,'København V');
INSERT INTO zipcodelist VALUES (1777,'København V');
INSERT INTO zipcodelist VALUES (1780,'København V');
INSERT INTO zipcodelist VALUES (1782,'København V');
INSERT INTO zipcodelist VALUES (1785,'København V');
INSERT INTO zipcodelist VALUES (1786,'København V');
INSERT INTO zipcodelist VALUES (1787,'København V');
INSERT INTO zipcodelist VALUES (1790,'København V');
INSERT INTO zipcodelist VALUES (1799,'København V');
INSERT INTO zipcodelist VALUES (1800,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1801,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1802,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1803,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1804,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1805,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1806,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1807,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1808,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1809,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1810,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1811,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1812,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1813,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1814,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1815,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1816,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1817,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1818,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1819,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1820,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1822,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1823,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1824,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1825,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1826,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1827,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1828,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1829,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1835,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1850,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1851,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1852,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1853,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1854,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1855,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1856,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1857,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1860,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1861,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1862,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1863,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1864,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1865,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1866,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1867,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1868,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1870,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1871,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1872,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1873,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1874,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1875,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1876,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1877,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1878,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1879,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1900,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1901,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1902,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1903,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1904,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1905,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1906,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1908,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1909,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1910,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1911,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1912,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1913,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1914,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1915,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1916,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1917,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1920,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1921,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1922,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1923,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1924,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1925,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1926,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1927,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1928,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1931,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1950,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1951,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1952,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1953,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1954,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1955,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1956,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1957,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1958,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1959,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1960,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1961,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1962,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1963,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1964,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1965,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1966,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1967,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1970,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1971,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1972,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1973,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (1974,'Frederiksberg C');
INSERT INTO zipcodelist VALUES (2000,'Frederiksberg');
INSERT INTO zipcodelist VALUES (2100,'København Ø');
INSERT INTO zipcodelist VALUES (2150,'Nordhavn');
INSERT INTO zipcodelist VALUES (2200,'København N');
INSERT INTO zipcodelist VALUES (2300,'København S');
INSERT INTO zipcodelist VALUES (2400,'København NV');
INSERT INTO zipcodelist VALUES (2450,'København SV');
INSERT INTO zipcodelist VALUES (2500,'Valby');
INSERT INTO zipcodelist VALUES (2600,'Glostrup');
INSERT INTO zipcodelist VALUES (2605,'Brøndby');
INSERT INTO zipcodelist VALUES (2610,'Rødovre');
INSERT INTO zipcodelist VALUES (2620,'Albertslund');
INSERT INTO zipcodelist VALUES (2625,'Vallensbæk');
INSERT INTO zipcodelist VALUES (2630,'Taastrup');
INSERT INTO zipcodelist VALUES (2635,'Ishøj');
INSERT INTO zipcodelist VALUES (2640,'Hedehusene');
INSERT INTO zipcodelist VALUES (2650,'Hvidovre');
INSERT INTO zipcodelist VALUES (2660,'Brøndby Strand');
INSERT INTO zipcodelist VALUES (2665,'Vallensbæk Strand');
INSERT INTO zipcodelist VALUES (2670,'Greve');
INSERT INTO zipcodelist VALUES (2680,'Solrød Strand');
INSERT INTO zipcodelist VALUES (2690,'Karlslunde');
INSERT INTO zipcodelist VALUES (2700,'Brønshøj');
INSERT INTO zipcodelist VALUES (2720,'Vanløse');
INSERT INTO zipcodelist VALUES (2730,'Herlev');
INSERT INTO zipcodelist VALUES (2740,'Skovlunde');
INSERT INTO zipcodelist VALUES (2750,'Ballerup');
INSERT INTO zipcodelist VALUES (2760,'Måløv');
INSERT INTO zipcodelist VALUES (2765,'Smørum');
INSERT INTO zipcodelist VALUES (2770,'Kastrup');
INSERT INTO zipcodelist VALUES (2791,'Dragør');
INSERT INTO zipcodelist VALUES (2800,'Kongens Lyngby');
INSERT INTO zipcodelist VALUES (2820,'Gentofte');
INSERT INTO zipcodelist VALUES (2830,'Virum');
INSERT INTO zipcodelist VALUES (2840,'Holte');
INSERT INTO zipcodelist VALUES (2850,'Nærum');
INSERT INTO zipcodelist VALUES (2860,'Søborg');
INSERT INTO zipcodelist VALUES (2870,'Dyssegård');
INSERT INTO zipcodelist VALUES (2880,'Bagsværd');
INSERT INTO zipcodelist VALUES (2900,'Hellerup');
INSERT INTO zipcodelist VALUES (2920,'Charlottenlund');
INSERT INTO zipcodelist VALUES (2930,'Klampenborg');
INSERT INTO zipcodelist VALUES (2942,'Skodsborg');
INSERT INTO zipcodelist VALUES (2950,'Vedbæk');
INSERT INTO zipcodelist VALUES (2960,'Rungsted Kyst');
INSERT INTO zipcodelist VALUES (2970,'Hørsholm');
INSERT INTO zipcodelist VALUES (2980,'Kokkedal');
INSERT INTO zipcodelist VALUES (2990,'Nivå');
INSERT INTO zipcodelist VALUES (3000,'Helsingør');
INSERT INTO zipcodelist VALUES (3050,'Humlebæk');
INSERT INTO zipcodelist VALUES (3060,'Espergærde');
INSERT INTO zipcodelist VALUES (3070,'Snekkersten');
INSERT INTO zipcodelist VALUES (3080,'Tikøb');
INSERT INTO zipcodelist VALUES (3100,'Hornbæk');
INSERT INTO zipcodelist VALUES (3120,'Dronningmølle');
INSERT INTO zipcodelist VALUES (3140,'Ålsgårde');
INSERT INTO zipcodelist VALUES (3150,'Hellebæk');
INSERT INTO zipcodelist VALUES (3200,'Helsinge');
INSERT INTO zipcodelist VALUES (3210,'Vejby');
INSERT INTO zipcodelist VALUES (3220,'Tisvildeleje');
INSERT INTO zipcodelist VALUES (3230,'Græsted');
INSERT INTO zipcodelist VALUES (3250,'Gilleleje');
INSERT INTO zipcodelist VALUES (3300,'Frederiksværk');
INSERT INTO zipcodelist VALUES (3310,'Ølsted');
INSERT INTO zipcodelist VALUES (3320,'Skævinge');
INSERT INTO zipcodelist VALUES (3330,'Gørløse');
INSERT INTO zipcodelist VALUES (3360,'Liseleje');
INSERT INTO zipcodelist VALUES (3370,'Melby');
INSERT INTO zipcodelist VALUES (3390,'Hundested');
INSERT INTO zipcodelist VALUES (3400,'Hillerød');
INSERT INTO zipcodelist VALUES (3450,'Allerød');
INSERT INTO zipcodelist VALUES (3460,'Birkerød');
INSERT INTO zipcodelist VALUES (3480,'Fredensborg');
INSERT INTO zipcodelist VALUES (3490,'Kvistgård');
INSERT INTO zipcodelist VALUES (3500,'Værløse');
INSERT INTO zipcodelist VALUES (3520,'Farum');
INSERT INTO zipcodelist VALUES (3540,'Lynge');
INSERT INTO zipcodelist VALUES (3550,'Slangerup');
INSERT INTO zipcodelist VALUES (3600,'Frederikssund');
INSERT INTO zipcodelist VALUES (3630,'Jægerspris');
INSERT INTO zipcodelist VALUES (3650,'Ølstykke');
INSERT INTO zipcodelist VALUES (3660,'Stenløse');
INSERT INTO zipcodelist VALUES (3670,'Veksø Sjælland');
INSERT INTO zipcodelist VALUES (3700,'Rønne');
INSERT INTO zipcodelist VALUES (3720,'Aakirkeby');
INSERT INTO zipcodelist VALUES (3730,'Nexø');
INSERT INTO zipcodelist VALUES (3740,'Svaneke');
INSERT INTO zipcodelist VALUES (3751,'Østermarie');
INSERT INTO zipcodelist VALUES (3760,'Gudhjem');
INSERT INTO zipcodelist VALUES (3770,'Allinge');
INSERT INTO zipcodelist VALUES (3782,'Klemensker');
INSERT INTO zipcodelist VALUES (3790,'Hasle');
INSERT INTO zipcodelist VALUES (4000,'Roskilde');
INSERT INTO zipcodelist VALUES (4030,'Tune');
INSERT INTO zipcodelist VALUES (4040,'Jyllinge');
INSERT INTO zipcodelist VALUES (4050,'Skibby');
INSERT INTO zipcodelist VALUES (4060,'Kirke Såby');
INSERT INTO zipcodelist VALUES (4070,'Kirke Hyllinge');
INSERT INTO zipcodelist VALUES (4100,'Ringsted');
INSERT INTO zipcodelist VALUES (4129,'Ringsted');
INSERT INTO zipcodelist VALUES (4130,'Viby Sjælland');
INSERT INTO zipcodelist VALUES (4140,'Borup');
INSERT INTO zipcodelist VALUES (4160,'Herlufmagle');
INSERT INTO zipcodelist VALUES (4171,'Glumsø');
INSERT INTO zipcodelist VALUES (4173,'Fjenneslev');
INSERT INTO zipcodelist VALUES (4174,'Jystrup Midtsj');
INSERT INTO zipcodelist VALUES (4180,'Sorø');
INSERT INTO zipcodelist VALUES (4190,'Munke Bjergby');
INSERT INTO zipcodelist VALUES (4200,'Slagelse');
INSERT INTO zipcodelist VALUES (4220,'Korsør');
INSERT INTO zipcodelist VALUES (4230,'Skælskør');
INSERT INTO zipcodelist VALUES (4241,'Vemmelev');
INSERT INTO zipcodelist VALUES (4242,'Boeslunde');
INSERT INTO zipcodelist VALUES (4243,'Rude');
INSERT INTO zipcodelist VALUES (4244,'Agersø');
INSERT INTO zipcodelist VALUES (4245,'Omø');
INSERT INTO zipcodelist VALUES (4250,'Fuglebjerg');
INSERT INTO zipcodelist VALUES (4261,'Dalmose');
INSERT INTO zipcodelist VALUES (4262,'Sandved');
INSERT INTO zipcodelist VALUES (4270,'Høng');
INSERT INTO zipcodelist VALUES (4281,'Gørlev');
INSERT INTO zipcodelist VALUES (4291,'Ruds Vedby');
INSERT INTO zipcodelist VALUES (4293,'Dianalund');
INSERT INTO zipcodelist VALUES (4295,'Stenlille');
INSERT INTO zipcodelist VALUES (4296,'Nyrup');
INSERT INTO zipcodelist VALUES (4300,'Holbæk');
INSERT INTO zipcodelist VALUES (4305,'Orø');
INSERT INTO zipcodelist VALUES (4320,'Lejre');
INSERT INTO zipcodelist VALUES (4330,'Hvalsø');
INSERT INTO zipcodelist VALUES (4340,'Tølløse');
INSERT INTO zipcodelist VALUES (4350,'Ugerløse');
INSERT INTO zipcodelist VALUES (4360,'Kirke Eskilstrup');
INSERT INTO zipcodelist VALUES (4370,'Store Merløse');
INSERT INTO zipcodelist VALUES (4390,'Vipperød');
INSERT INTO zipcodelist VALUES (4400,'Kalundborg');
INSERT INTO zipcodelist VALUES (4420,'Regstrup');
INSERT INTO zipcodelist VALUES (4440,'Mørkøv');
INSERT INTO zipcodelist VALUES (4450,'Jyderup');
INSERT INTO zipcodelist VALUES (4460,'Snertinge');
INSERT INTO zipcodelist VALUES (4470,'Svebølle');
INSERT INTO zipcodelist VALUES (4480,'Store Fuglede');
INSERT INTO zipcodelist VALUES (4490,'Jerslev Sjælland');
INSERT INTO zipcodelist VALUES (4500,'Nykøbing S');
INSERT INTO zipcodelist VALUES (4520,'Svinninge');
INSERT INTO zipcodelist VALUES (4532,'Gislinge');
INSERT INTO zipcodelist VALUES (4534,'Hørve');
INSERT INTO zipcodelist VALUES (4540,'Fårevejle');
INSERT INTO zipcodelist VALUES (4550,'Asnæs');
INSERT INTO zipcodelist VALUES (4560,'Vig');
INSERT INTO zipcodelist VALUES (4571,'Grevinge');
INSERT INTO zipcodelist VALUES (4572,'Nørre Asmindrup');
INSERT INTO zipcodelist VALUES (4573,'Højby');
INSERT INTO zipcodelist VALUES (4581,'Rørvig');
INSERT INTO zipcodelist VALUES (4583,'Sjællands Odde');
INSERT INTO zipcodelist VALUES (4591,'Føllenslev');
INSERT INTO zipcodelist VALUES (4592,'Sejerø');
INSERT INTO zipcodelist VALUES (4593,'Eskebjerg');
INSERT INTO zipcodelist VALUES (4600,'Køge');
INSERT INTO zipcodelist VALUES (4621,'Gadstrup');
INSERT INTO zipcodelist VALUES (4622,'Havdrup');
INSERT INTO zipcodelist VALUES (4623,'Lille Skensved');
INSERT INTO zipcodelist VALUES (4632,'Bjæverskov');
INSERT INTO zipcodelist VALUES (4640,'Fakse');
INSERT INTO zipcodelist VALUES (4652,'Hårlev');
INSERT INTO zipcodelist VALUES (4653,'Karise');
INSERT INTO zipcodelist VALUES (4654,'Fakse Ladeplads');
INSERT INTO zipcodelist VALUES (4660,'Store Heddinge');
INSERT INTO zipcodelist VALUES (4671,'Strøby');
INSERT INTO zipcodelist VALUES (4672,'Klippinge');
INSERT INTO zipcodelist VALUES (4673,'Rødvig Stevns');
INSERT INTO zipcodelist VALUES (4681,'Herfølge');
INSERT INTO zipcodelist VALUES (4682,'Tureby');
INSERT INTO zipcodelist VALUES (4683,'Rønnede');
INSERT INTO zipcodelist VALUES (4684,'Holmegaard');
INSERT INTO zipcodelist VALUES (4690,'Haslev');
INSERT INTO zipcodelist VALUES (4700,'Næstved');
INSERT INTO zipcodelist VALUES (4720,'Præstø');
INSERT INTO zipcodelist VALUES (4733,'Tappernøje');
INSERT INTO zipcodelist VALUES (4735,'Mern');
INSERT INTO zipcodelist VALUES (4736,'Karrebæksminde');
INSERT INTO zipcodelist VALUES (4750,'Lundby');
INSERT INTO zipcodelist VALUES (4760,'Vordingborg');
INSERT INTO zipcodelist VALUES (4771,'Kalvehave');
INSERT INTO zipcodelist VALUES (4772,'Langebæk');
INSERT INTO zipcodelist VALUES (4773,'Stensved');
INSERT INTO zipcodelist VALUES (4780,'Stege');
INSERT INTO zipcodelist VALUES (4791,'Borre');
INSERT INTO zipcodelist VALUES (4792,'Askeby');
INSERT INTO zipcodelist VALUES (4793,'Bogø By');
INSERT INTO zipcodelist VALUES (4800,'Nykøbing F');
INSERT INTO zipcodelist VALUES (4840,'Nørre Alslev');
INSERT INTO zipcodelist VALUES (4850,'Stubbekøbing');
INSERT INTO zipcodelist VALUES (4862,'Guldborg');
INSERT INTO zipcodelist VALUES (4863,'Eskilstrup');
INSERT INTO zipcodelist VALUES (4871,'Horbelev');
INSERT INTO zipcodelist VALUES (4872,'Idestrup');
INSERT INTO zipcodelist VALUES (4873,'Væggerløse');
INSERT INTO zipcodelist VALUES (4874,'Gedser');
INSERT INTO zipcodelist VALUES (4880,'Nysted');
INSERT INTO zipcodelist VALUES (4891,'Toreby L');
INSERT INTO zipcodelist VALUES (4892,'Kettinge');
INSERT INTO zipcodelist VALUES (4894,'Øster Ulslev');
INSERT INTO zipcodelist VALUES (4895,'Errindlev');
INSERT INTO zipcodelist VALUES (4900,'Nakskov');
INSERT INTO zipcodelist VALUES (4912,'Harpelunde');
INSERT INTO zipcodelist VALUES (4913,'Horslunde');
INSERT INTO zipcodelist VALUES (4920,'Søllested');
INSERT INTO zipcodelist VALUES (4930,'Maribo');
INSERT INTO zipcodelist VALUES (4941,'Bandholm');
INSERT INTO zipcodelist VALUES (4942,'Askø og Lilleø');
INSERT INTO zipcodelist VALUES (4943,'Torrig L');
INSERT INTO zipcodelist VALUES (4944,'Fejø');
INSERT INTO zipcodelist VALUES (4945,'Femø');
INSERT INTO zipcodelist VALUES (4951,'Nørreballe');
INSERT INTO zipcodelist VALUES (4952,'Stokkemarke');
INSERT INTO zipcodelist VALUES (4953,'Vesterborg');
INSERT INTO zipcodelist VALUES (4960,'Holeby');
INSERT INTO zipcodelist VALUES (4970,'Rødby');
INSERT INTO zipcodelist VALUES (4983,'Dannemare');
INSERT INTO zipcodelist VALUES (4990,'Sakskøbing');
INSERT INTO zipcodelist VALUES (4992,'Midtsjælland USF P');
INSERT INTO zipcodelist VALUES (5000,'Odense C');
INSERT INTO zipcodelist VALUES (5029,'Odense C');
INSERT INTO zipcodelist VALUES (5100,'Odense C');
INSERT INTO zipcodelist VALUES (5200,'Odense V');
INSERT INTO zipcodelist VALUES (5210,'Odense NV');
INSERT INTO zipcodelist VALUES (5220,'Odense SØ');
INSERT INTO zipcodelist VALUES (5230,'Odense M');
INSERT INTO zipcodelist VALUES (5240,'Odense NØ');
INSERT INTO zipcodelist VALUES (5250,'Odense SV');
INSERT INTO zipcodelist VALUES (5260,'Odense S');
INSERT INTO zipcodelist VALUES (5270,'Odense N');
INSERT INTO zipcodelist VALUES (5290,'Marslev');
INSERT INTO zipcodelist VALUES (5300,'Kerteminde');
INSERT INTO zipcodelist VALUES (5320,'Agedrup');
INSERT INTO zipcodelist VALUES (5330,'Munkebo');
INSERT INTO zipcodelist VALUES (5350,'Rynkeby');
INSERT INTO zipcodelist VALUES (5370,'Mesinge');
INSERT INTO zipcodelist VALUES (5380,'Dalby');
INSERT INTO zipcodelist VALUES (5390,'Martofte');
INSERT INTO zipcodelist VALUES (5400,'Bogense');
INSERT INTO zipcodelist VALUES (5450,'Otterup');
INSERT INTO zipcodelist VALUES (5462,'Morud');
INSERT INTO zipcodelist VALUES (5463,'Harndrup');
INSERT INTO zipcodelist VALUES (5464,'Brenderup Fyn');
INSERT INTO zipcodelist VALUES (5466,'Asperup');
INSERT INTO zipcodelist VALUES (5471,'Søndersø');
INSERT INTO zipcodelist VALUES (5474,'Veflinge');
INSERT INTO zipcodelist VALUES (5485,'Skamby');
INSERT INTO zipcodelist VALUES (5491,'Blommenslyst');
INSERT INTO zipcodelist VALUES (5492,'Vissenbjerg');
INSERT INTO zipcodelist VALUES (5500,'Middelfart');
INSERT INTO zipcodelist VALUES (5540,'Ullerslev');
INSERT INTO zipcodelist VALUES (5550,'Langeskov');
INSERT INTO zipcodelist VALUES (5560,'Aarup');
INSERT INTO zipcodelist VALUES (5580,'Nørre Aaby');
INSERT INTO zipcodelist VALUES (5591,'Gelsted');
INSERT INTO zipcodelist VALUES (5592,'Ejby');
INSERT INTO zipcodelist VALUES (5600,'Faaborg');
INSERT INTO zipcodelist VALUES (5602,'Avernakø');
INSERT INTO zipcodelist VALUES (5603,'Bjørnø');
INSERT INTO zipcodelist VALUES (5610,'Assens');
INSERT INTO zipcodelist VALUES (5620,'Glamsbjerg');
INSERT INTO zipcodelist VALUES (5631,'Ebberup');
INSERT INTO zipcodelist VALUES (5642,'Millinge');
INSERT INTO zipcodelist VALUES (5672,'Broby');
INSERT INTO zipcodelist VALUES (5683,'Haarby');
INSERT INTO zipcodelist VALUES (5690,'Tommerup');
INSERT INTO zipcodelist VALUES (5700,'Svendborg');
INSERT INTO zipcodelist VALUES (5750,'Ringe');
INSERT INTO zipcodelist VALUES (5762,'Vester Skerninge');
INSERT INTO zipcodelist VALUES (5771,'Stenstrup');
INSERT INTO zipcodelist VALUES (5772,'Kværndrup');
INSERT INTO zipcodelist VALUES (5792,'Årslev');
INSERT INTO zipcodelist VALUES (5800,'Nyborg');
INSERT INTO zipcodelist VALUES (5853,'Ørbæk');
INSERT INTO zipcodelist VALUES (5854,'Gislev');
INSERT INTO zipcodelist VALUES (5856,'Ryslinge');
INSERT INTO zipcodelist VALUES (5863,'Ferritslev Fyn');
INSERT INTO zipcodelist VALUES (5871,'Frørup');
INSERT INTO zipcodelist VALUES (5874,'Hesselager');
INSERT INTO zipcodelist VALUES (5881,'Skårup Fyn');
INSERT INTO zipcodelist VALUES (5882,'Vejstrup');
INSERT INTO zipcodelist VALUES (5883,'Oure');
INSERT INTO zipcodelist VALUES (5884,'Gudme');
INSERT INTO zipcodelist VALUES (5892,'Gudbjerg Sydfyn');
INSERT INTO zipcodelist VALUES (5900,'Rudkøbing');
INSERT INTO zipcodelist VALUES (5932,'Humble');
INSERT INTO zipcodelist VALUES (5935,'Bagenkop');
INSERT INTO zipcodelist VALUES (5943,'Strynø');
INSERT INTO zipcodelist VALUES (5953,'Tranekær');
INSERT INTO zipcodelist VALUES (5960,'Marstal');
INSERT INTO zipcodelist VALUES (5965,'Birkholm');
INSERT INTO zipcodelist VALUES (5970,'Ærøskøbing');
INSERT INTO zipcodelist VALUES (5985,'Søby Ærø');
INSERT INTO zipcodelist VALUES (6000,'Kolding');
INSERT INTO zipcodelist VALUES (6040,'Egtved');
INSERT INTO zipcodelist VALUES (6051,'Almind');
INSERT INTO zipcodelist VALUES (6052,'Viuf');
INSERT INTO zipcodelist VALUES (6064,'Jordrup');
INSERT INTO zipcodelist VALUES (6070,'Christiansfeld');
INSERT INTO zipcodelist VALUES (6091,'Bjert');
INSERT INTO zipcodelist VALUES (6092,'Sønder Stenderup');
INSERT INTO zipcodelist VALUES (6093,'Sjølund');
INSERT INTO zipcodelist VALUES (6094,'Hejls');
INSERT INTO zipcodelist VALUES (6100,'Haderslev');
INSERT INTO zipcodelist VALUES (6200,'Aabenraa');
INSERT INTO zipcodelist VALUES (6210,'Barsø');
INSERT INTO zipcodelist VALUES (6230,'Rødekro');
INSERT INTO zipcodelist VALUES (6240,'Løgumkloster');
INSERT INTO zipcodelist VALUES (6261,'Bredebro');
INSERT INTO zipcodelist VALUES (6270,'Tønder');
INSERT INTO zipcodelist VALUES (6280,'Højer');
INSERT INTO zipcodelist VALUES (6300,'Gråsten');
INSERT INTO zipcodelist VALUES (6310,'Broager');
INSERT INTO zipcodelist VALUES (6320,'Egernsund');
INSERT INTO zipcodelist VALUES (6330,'Padborg');
INSERT INTO zipcodelist VALUES (6340,'Kruså');
INSERT INTO zipcodelist VALUES (6360,'Tinglev');
INSERT INTO zipcodelist VALUES (6372,'Bylderup Bov');
INSERT INTO zipcodelist VALUES (6392,'Bolderslev');
INSERT INTO zipcodelist VALUES (6400,'Sønderborg');
INSERT INTO zipcodelist VALUES (6430,'Nordborg');
INSERT INTO zipcodelist VALUES (6440,'Augustenborg');
INSERT INTO zipcodelist VALUES (6470,'Sydals');
INSERT INTO zipcodelist VALUES (6500,'Vojens');
INSERT INTO zipcodelist VALUES (6510,'Gram');
INSERT INTO zipcodelist VALUES (6520,'Toftlund');
INSERT INTO zipcodelist VALUES (6534,'Agerskov');
INSERT INTO zipcodelist VALUES (6535,'Branderup J');
INSERT INTO zipcodelist VALUES (6541,'Bevtoft');
INSERT INTO zipcodelist VALUES (6560,'Sommersted');
INSERT INTO zipcodelist VALUES (6580,'Vamdrup');
INSERT INTO zipcodelist VALUES (6600,'Vejen');
INSERT INTO zipcodelist VALUES (6621,'Gesten');
INSERT INTO zipcodelist VALUES (6622,'Bække');
INSERT INTO zipcodelist VALUES (6623,'Vorbasse');
INSERT INTO zipcodelist VALUES (6630,'Rødding');
INSERT INTO zipcodelist VALUES (6640,'Lunderskov');
INSERT INTO zipcodelist VALUES (6650,'Brørup');
INSERT INTO zipcodelist VALUES (6660,'Lintrup');
INSERT INTO zipcodelist VALUES (6670,'Holsted');
INSERT INTO zipcodelist VALUES (6682,'Hovborg');
INSERT INTO zipcodelist VALUES (6683,'Føvling');
INSERT INTO zipcodelist VALUES (6690,'Gørding');
INSERT INTO zipcodelist VALUES (6700,'Esbjerg');
INSERT INTO zipcodelist VALUES (6701,'Esbjerg');
INSERT INTO zipcodelist VALUES (6705,'Esbjerg Ø');
INSERT INTO zipcodelist VALUES (6710,'Esbjerg V');
INSERT INTO zipcodelist VALUES (6715,'Esbjerg N');
INSERT INTO zipcodelist VALUES (6720,'Fanø');
INSERT INTO zipcodelist VALUES (6731,'Tjæreborg');
INSERT INTO zipcodelist VALUES (6740,'Bramming');
INSERT INTO zipcodelist VALUES (6752,'Glejbjerg');
INSERT INTO zipcodelist VALUES (6753,'Agerbæk');
INSERT INTO zipcodelist VALUES (6760,'Ribe');
INSERT INTO zipcodelist VALUES (6771,'Gredstedbro');
INSERT INTO zipcodelist VALUES (6780,'Skærbæk');
INSERT INTO zipcodelist VALUES (6792,'Rømø');
INSERT INTO zipcodelist VALUES (6800,'Varde');
INSERT INTO zipcodelist VALUES (6818,'Årre');
INSERT INTO zipcodelist VALUES (6823,'Ansager');
INSERT INTO zipcodelist VALUES (6830,'Nørre Nebel');
INSERT INTO zipcodelist VALUES (6840,'Oksbøl');
INSERT INTO zipcodelist VALUES (6851,'Janderup Vestj');
INSERT INTO zipcodelist VALUES (6852,'Billum');
INSERT INTO zipcodelist VALUES (6853,'Vejers Strand');
INSERT INTO zipcodelist VALUES (6854,'Henne');
INSERT INTO zipcodelist VALUES (6855,'Outrup');
INSERT INTO zipcodelist VALUES (6857,'Blåvand');
INSERT INTO zipcodelist VALUES (6862,'Tistrup');
INSERT INTO zipcodelist VALUES (6870,'Ølgod');
INSERT INTO zipcodelist VALUES (6880,'Tarm');
INSERT INTO zipcodelist VALUES (6893,'Hemmet');
INSERT INTO zipcodelist VALUES (6900,'Skjern');
INSERT INTO zipcodelist VALUES (6920,'Videbæk');
INSERT INTO zipcodelist VALUES (6933,'Kibæk');
INSERT INTO zipcodelist VALUES (6940,'Lem St');
INSERT INTO zipcodelist VALUES (6950,'Ringkøbing');
INSERT INTO zipcodelist VALUES (6960,'Hvide Sande');
INSERT INTO zipcodelist VALUES (6971,'Spjald');
INSERT INTO zipcodelist VALUES (6973,'Ørnhøj');
INSERT INTO zipcodelist VALUES (6980,'Tim');
INSERT INTO zipcodelist VALUES (6990,'Ulfborg');
INSERT INTO zipcodelist VALUES (7000,'Fredericia');
INSERT INTO zipcodelist VALUES (7007,'Fredericia');
INSERT INTO zipcodelist VALUES (7017,'Taulov Pakkecenter');
INSERT INTO zipcodelist VALUES (7018,'Pakker TLP');
INSERT INTO zipcodelist VALUES (7029,'Fredericia');
INSERT INTO zipcodelist VALUES (7080,'Børkop');
INSERT INTO zipcodelist VALUES (7100,'Vejle');
INSERT INTO zipcodelist VALUES (7120,'Vejle Øst');
INSERT INTO zipcodelist VALUES (7130,'Juelsminde');
INSERT INTO zipcodelist VALUES (7140,'Stouby');
INSERT INTO zipcodelist VALUES (7150,'Barrit');
INSERT INTO zipcodelist VALUES (7160,'Tørring');
INSERT INTO zipcodelist VALUES (7171,'Uldum');
INSERT INTO zipcodelist VALUES (7173,'Vonge');
INSERT INTO zipcodelist VALUES (7182,'Bredsten');
INSERT INTO zipcodelist VALUES (7183,'Randbøl');
INSERT INTO zipcodelist VALUES (7184,'Vandel');
INSERT INTO zipcodelist VALUES (7190,'Billund');
INSERT INTO zipcodelist VALUES (7200,'Grindsted');
INSERT INTO zipcodelist VALUES (7250,'Hejnsvig');
INSERT INTO zipcodelist VALUES (7260,'Sønder Omme');
INSERT INTO zipcodelist VALUES (7270,'Stakroge');
INSERT INTO zipcodelist VALUES (7280,'Sønder Felding');
INSERT INTO zipcodelist VALUES (7300,'Jelling');
INSERT INTO zipcodelist VALUES (7321,'Gadbjerg');
INSERT INTO zipcodelist VALUES (7323,'Give');
INSERT INTO zipcodelist VALUES (7330,'Brande');
INSERT INTO zipcodelist VALUES (7361,'Ejstrupholm');
INSERT INTO zipcodelist VALUES (7362,'Hampen');
INSERT INTO zipcodelist VALUES (7400,'Herning');
INSERT INTO zipcodelist VALUES (7429,'Herning');
INSERT INTO zipcodelist VALUES (7430,'Ikast');
INSERT INTO zipcodelist VALUES (7441,'Bording');
INSERT INTO zipcodelist VALUES (7442,'Engesvang');
INSERT INTO zipcodelist VALUES (7451,'Sunds');
INSERT INTO zipcodelist VALUES (7470,'Karup J');
INSERT INTO zipcodelist VALUES (7480,'Vildbjerg');
INSERT INTO zipcodelist VALUES (7490,'Aulum');
INSERT INTO zipcodelist VALUES (7500,'Holstebro');
INSERT INTO zipcodelist VALUES (7540,'Haderup');
INSERT INTO zipcodelist VALUES (7550,'Sørvad');
INSERT INTO zipcodelist VALUES (7560,'Hjerm');
INSERT INTO zipcodelist VALUES (7570,'Vemb');
INSERT INTO zipcodelist VALUES (7600,'Struer');
INSERT INTO zipcodelist VALUES (7620,'Lemvig');
INSERT INTO zipcodelist VALUES (7650,'Bøvlingbjerg');
INSERT INTO zipcodelist VALUES (7660,'Bækmarksbro');
INSERT INTO zipcodelist VALUES (7673,'Harboøre');
INSERT INTO zipcodelist VALUES (7680,'Thyborøn');
INSERT INTO zipcodelist VALUES (7700,'Thisted');
INSERT INTO zipcodelist VALUES (7730,'Hanstholm');
INSERT INTO zipcodelist VALUES (7741,'Frøstrup');
INSERT INTO zipcodelist VALUES (7742,'Vesløs');
INSERT INTO zipcodelist VALUES (7752,'Snedsted');
INSERT INTO zipcodelist VALUES (7755,'Bedsted Thy');
INSERT INTO zipcodelist VALUES (7760,'Hurup Thy');
INSERT INTO zipcodelist VALUES (7770,'Vestervig');
INSERT INTO zipcodelist VALUES (7790,'Thyholm');
INSERT INTO zipcodelist VALUES (7800,'Skive');
INSERT INTO zipcodelist VALUES (7830,'Vinderup');
INSERT INTO zipcodelist VALUES (7840,'Højslev');
INSERT INTO zipcodelist VALUES (7850,'Stoholm Jyll');
INSERT INTO zipcodelist VALUES (7860,'Spøttrup');
INSERT INTO zipcodelist VALUES (7870,'Roslev');
INSERT INTO zipcodelist VALUES (7884,'Fur');
INSERT INTO zipcodelist VALUES (7900,'Nykøbing M');
INSERT INTO zipcodelist VALUES (7950,'Erslev');
INSERT INTO zipcodelist VALUES (7960,'Karby');
INSERT INTO zipcodelist VALUES (7970,'Redsted M');
INSERT INTO zipcodelist VALUES (7980,'Vils');
INSERT INTO zipcodelist VALUES (7990,'Øster Assels');
INSERT INTO zipcodelist VALUES (7992,'Sydjylland/Fyn USF P');
INSERT INTO zipcodelist VALUES (7993,'Sydjylland/Fyn USF B');
INSERT INTO zipcodelist VALUES (7996,'Fakturaservice');
INSERT INTO zipcodelist VALUES (7997,'Fakturascanning');
INSERT INTO zipcodelist VALUES (7998,'Statsservice');
INSERT INTO zipcodelist VALUES (7999,'Kommunepost');
INSERT INTO zipcodelist VALUES (8000,'Aarhus C');
INSERT INTO zipcodelist VALUES (8100,'Aarhus C');
INSERT INTO zipcodelist VALUES (8200,'Aarhus N');
INSERT INTO zipcodelist VALUES (8210,'Aarhus V');
INSERT INTO zipcodelist VALUES (8220,'Brabrand');
INSERT INTO zipcodelist VALUES (8229,'Risskov Ø');
INSERT INTO zipcodelist VALUES (8230,'Åbyhøj');
INSERT INTO zipcodelist VALUES (8240,'Risskov');
INSERT INTO zipcodelist VALUES (8245,'Risskov Ø');
INSERT INTO zipcodelist VALUES (8250,'Egå');
INSERT INTO zipcodelist VALUES (8260,'Viby J');
INSERT INTO zipcodelist VALUES (8270,'Højbjerg');
INSERT INTO zipcodelist VALUES (8300,'Odder');
INSERT INTO zipcodelist VALUES (8305,'Samsø');
INSERT INTO zipcodelist VALUES (8310,'Tranbjerg J');
INSERT INTO zipcodelist VALUES (8320,'Mårslet');
INSERT INTO zipcodelist VALUES (8330,'Beder');
INSERT INTO zipcodelist VALUES (8340,'Malling');
INSERT INTO zipcodelist VALUES (8350,'Hundslund');
INSERT INTO zipcodelist VALUES (8355,'Solbjerg');
INSERT INTO zipcodelist VALUES (8361,'Hasselager');
INSERT INTO zipcodelist VALUES (8362,'Hørning');
INSERT INTO zipcodelist VALUES (8370,'Hadsten');
INSERT INTO zipcodelist VALUES (8380,'Trige');
INSERT INTO zipcodelist VALUES (8381,'Tilst');
INSERT INTO zipcodelist VALUES (8382,'Hinnerup');
INSERT INTO zipcodelist VALUES (8400,'Ebeltoft');
INSERT INTO zipcodelist VALUES (8410,'Rønde');
INSERT INTO zipcodelist VALUES (8420,'Knebel');
INSERT INTO zipcodelist VALUES (8444,'Balle');
INSERT INTO zipcodelist VALUES (8450,'Hammel');
INSERT INTO zipcodelist VALUES (8462,'Harlev J');
INSERT INTO zipcodelist VALUES (8464,'Galten');
INSERT INTO zipcodelist VALUES (8471,'Sabro');
INSERT INTO zipcodelist VALUES (8472,'Sporup');
INSERT INTO zipcodelist VALUES (8500,'Grenaa');
INSERT INTO zipcodelist VALUES (8520,'Lystrup');
INSERT INTO zipcodelist VALUES (8530,'Hjortshøj');
INSERT INTO zipcodelist VALUES (8541,'Skødstrup');
INSERT INTO zipcodelist VALUES (8543,'Hornslet');
INSERT INTO zipcodelist VALUES (8544,'Mørke');
INSERT INTO zipcodelist VALUES (8550,'Ryomgård');
INSERT INTO zipcodelist VALUES (8560,'Kolind');
INSERT INTO zipcodelist VALUES (8570,'Trustrup');
INSERT INTO zipcodelist VALUES (8581,'Nimtofte');
INSERT INTO zipcodelist VALUES (8585,'Glesborg');
INSERT INTO zipcodelist VALUES (8586,'Ørum Djurs');
INSERT INTO zipcodelist VALUES (8592,'Anholt');
INSERT INTO zipcodelist VALUES (8600,'Silkeborg');
INSERT INTO zipcodelist VALUES (8620,'Kjellerup');
INSERT INTO zipcodelist VALUES (8632,'Lemming');
INSERT INTO zipcodelist VALUES (8641,'Sorring');
INSERT INTO zipcodelist VALUES (8643,'Ans By');
INSERT INTO zipcodelist VALUES (8653,'Them');
INSERT INTO zipcodelist VALUES (8654,'Bryrup');
INSERT INTO zipcodelist VALUES (8660,'Skanderborg');
INSERT INTO zipcodelist VALUES (8670,'Låsby');
INSERT INTO zipcodelist VALUES (8680,'Ry');
INSERT INTO zipcodelist VALUES (8700,'Horsens');
INSERT INTO zipcodelist VALUES (8721,'Daugård');
INSERT INTO zipcodelist VALUES (8722,'Hedensted');
INSERT INTO zipcodelist VALUES (8723,'Løsning');
INSERT INTO zipcodelist VALUES (8732,'Hovedgård');
INSERT INTO zipcodelist VALUES (8740,'Brædstrup');
INSERT INTO zipcodelist VALUES (8751,'Gedved');
INSERT INTO zipcodelist VALUES (8752,'Østbirk');
INSERT INTO zipcodelist VALUES (8762,'Flemming');
INSERT INTO zipcodelist VALUES (8763,'Rask Mølle');
INSERT INTO zipcodelist VALUES (8765,'Klovborg');
INSERT INTO zipcodelist VALUES (8766,'Nørre Snede');
INSERT INTO zipcodelist VALUES (8781,'Stenderup');
INSERT INTO zipcodelist VALUES (8783,'Hornsyld');
INSERT INTO zipcodelist VALUES (8789,'Endelave');
INSERT INTO zipcodelist VALUES (8799,'Tunø');
INSERT INTO zipcodelist VALUES (8800,'Viborg');
INSERT INTO zipcodelist VALUES (8830,'Tjele');
INSERT INTO zipcodelist VALUES (8831,'Løgstrup');
INSERT INTO zipcodelist VALUES (8832,'Skals');
INSERT INTO zipcodelist VALUES (8840,'Rødkærsbro');
INSERT INTO zipcodelist VALUES (8850,'Bjerringbro');
INSERT INTO zipcodelist VALUES (8860,'Ulstrup');
INSERT INTO zipcodelist VALUES (8870,'Langå');
INSERT INTO zipcodelist VALUES (8881,'Thorsø');
INSERT INTO zipcodelist VALUES (8882,'Fårvang');
INSERT INTO zipcodelist VALUES (8883,'Gjern');
INSERT INTO zipcodelist VALUES (8900,'Randers C');
INSERT INTO zipcodelist VALUES (8920,'Randers NV');
INSERT INTO zipcodelist VALUES (8930,'Randers NØ');
INSERT INTO zipcodelist VALUES (8940,'Randers SV');
INSERT INTO zipcodelist VALUES (8950,'Ørsted');
INSERT INTO zipcodelist VALUES (8960,'Randers SØ');
INSERT INTO zipcodelist VALUES (8961,'Allingåbro');
INSERT INTO zipcodelist VALUES (8963,'Auning');
INSERT INTO zipcodelist VALUES (8970,'Havndal');
INSERT INTO zipcodelist VALUES (8981,'Spentrup');
INSERT INTO zipcodelist VALUES (8983,'Gjerlev J');
INSERT INTO zipcodelist VALUES (8990,'Fårup');
INSERT INTO zipcodelist VALUES (9000,'Aalborg');
INSERT INTO zipcodelist VALUES (9029,'Aalborg');
INSERT INTO zipcodelist VALUES (9100,'Aalborg');
INSERT INTO zipcodelist VALUES (9200,'Aalborg SV');
INSERT INTO zipcodelist VALUES (9210,'Aalborg SØ');
INSERT INTO zipcodelist VALUES (9220,'Aalborg Øst');
INSERT INTO zipcodelist VALUES (9230,'Svenstrup J');
INSERT INTO zipcodelist VALUES (9240,'Nibe');
INSERT INTO zipcodelist VALUES (9260,'Gistrup');
INSERT INTO zipcodelist VALUES (9270,'Klarup');
INSERT INTO zipcodelist VALUES (9280,'Storvorde');
INSERT INTO zipcodelist VALUES (9293,'Kongerslev');
INSERT INTO zipcodelist VALUES (9300,'Sæby');
INSERT INTO zipcodelist VALUES (9310,'Vodskov');
INSERT INTO zipcodelist VALUES (9320,'Hjallerup');
INSERT INTO zipcodelist VALUES (9330,'Dronninglund');
INSERT INTO zipcodelist VALUES (9340,'Asaa');
INSERT INTO zipcodelist VALUES (9352,'Dybvad');
INSERT INTO zipcodelist VALUES (9362,'Gandrup');
INSERT INTO zipcodelist VALUES (9370,'Hals');
INSERT INTO zipcodelist VALUES (9380,'Vestbjerg');
INSERT INTO zipcodelist VALUES (9381,'Sulsted');
INSERT INTO zipcodelist VALUES (9382,'Tylstrup');
INSERT INTO zipcodelist VALUES (9400,'Nørresundby');
INSERT INTO zipcodelist VALUES (9430,'Vadum');
INSERT INTO zipcodelist VALUES (9440,'Aabybro');
INSERT INTO zipcodelist VALUES (9460,'Brovst');
INSERT INTO zipcodelist VALUES (9480,'Løkken');
INSERT INTO zipcodelist VALUES (9490,'Pandrup');
INSERT INTO zipcodelist VALUES (9492,'Blokhus');
INSERT INTO zipcodelist VALUES (9493,'Saltum');
INSERT INTO zipcodelist VALUES (9500,'Hobro');
INSERT INTO zipcodelist VALUES (9510,'Arden');
INSERT INTO zipcodelist VALUES (9520,'Skørping');
INSERT INTO zipcodelist VALUES (9530,'Støvring');
INSERT INTO zipcodelist VALUES (9541,'Suldrup');
INSERT INTO zipcodelist VALUES (9550,'Mariager');
INSERT INTO zipcodelist VALUES (9560,'Hadsund');
INSERT INTO zipcodelist VALUES (9574,'Bælum');
INSERT INTO zipcodelist VALUES (9575,'Terndrup');
INSERT INTO zipcodelist VALUES (9600,'Aars');
INSERT INTO zipcodelist VALUES (9610,'Nørager');
INSERT INTO zipcodelist VALUES (9620,'Aalestrup');
INSERT INTO zipcodelist VALUES (9631,'Gedsted');
INSERT INTO zipcodelist VALUES (9632,'Møldrup');
INSERT INTO zipcodelist VALUES (9640,'Farsø');
INSERT INTO zipcodelist VALUES (9670,'Løgstør');
INSERT INTO zipcodelist VALUES (9681,'Ranum');
INSERT INTO zipcodelist VALUES (9690,'Fjerritslev');
INSERT INTO zipcodelist VALUES (9700,'Brønderslev');
INSERT INTO zipcodelist VALUES (9740,'Jerslev J');
INSERT INTO zipcodelist VALUES (9750,'Øster Vrå');
INSERT INTO zipcodelist VALUES (9760,'Vrå');
INSERT INTO zipcodelist VALUES (9800,'Hjørring');
INSERT INTO zipcodelist VALUES (9830,'Tårs');
INSERT INTO zipcodelist VALUES (9850,'Hirtshals');
INSERT INTO zipcodelist VALUES (9870,'Sindal');
INSERT INTO zipcodelist VALUES (9881,'Bindslev');
INSERT INTO zipcodelist VALUES (9900,'Frederikshavn');
INSERT INTO zipcodelist VALUES (9940,'Læsø');
INSERT INTO zipcodelist VALUES (9970,'Strandby');
INSERT INTO zipcodelist VALUES (9981,'Jerup');
INSERT INTO zipcodelist VALUES (9982,'Ålbæk');
INSERT INTO zipcodelist VALUES (9990,'Skagen');
INSERT INTO zipcodelist VALUES (9992,'Jylland USF P');
INSERT INTO zipcodelist VALUES (9993,'Jylland USF B');
INSERT INTO zipcodelist VALUES (9996,'Fakturaservice');
INSERT INTO zipcodelist VALUES (9997,'Fakturascanning');
INSERT INTO zipcodelist VALUES (9998,'Borgerservice');

commit;    
    
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
