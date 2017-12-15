/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */; -- 0 er true, 1 = false
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Vi har en database, der hedder fog, og som har følgende tabeller: materialeliste, odetaljer, ordreliste, userlist, zipcodelist.
-- Test databasen hedder fogTest. 

CREATE DATABASE `fogTest`;

USE `fogTest`;

-- Vi starter med at lave en kopi af vores tabeller fra fog databasen til fogTest databasen. 
CREATE TABLE fogTest.userlist LIKE fog.userlist;

-- Laver en ny tabel, som hedder userlistTest. 
CREATE TABLE userlistTest LIKE fogTest.userlist;

-- Du 2 ovenstående sql statements gentages nu for hver tabel, så vi har muligheden for at teste mapper metoderne til alle tabellerne. 
CREATE TABLE fogTest.zipcodelist LIKE fog.zipcodelist;
CREATE TABLE zipcodelistTest LIKE fogTest.zipcodelist;

CREATE TABLE fogTest.ordreliste LIKE fog.ordreliste;
CREATE TABLE ordrelisteTest LIKE fogTest.ordreliste;

CREATE TABLE fogTest.odetaljer LIKE fog.odetaljer;
CREATE TABLE odetaljerTest LIKE fogTest.odetaljer;

CREATE TABLE fogTest.materialeliste LIKE fog.materialeliste;
CREATE TABLE materialelisteTest LIKE fogTest.materialeliste;

-- DEMO DATA TIL TEST

-- Laver en ny bruger til test databasen og giver privileger til databasen. Laves kun en gang derfor eer den udkommenteret. 
 -- CREATE USER 'testinguser' IDENTIFIED BY 'tryALot';
 -- GRANT ALL PRIVILEGES ON fogTest.* TO 'testinguser';

-- Demo Data til zipcodelistTest
INSERT INTO zipcodelistTest VALUES (1000,'København K');

-- Demo data til userlistTest 
INSERT INTO userlistTest VALUES 
	(1, 1000, 'ansat@ansat.dk', 'a', 'employee', 'Jens', 'Jensen', 'Flyvervej 1',40404040),
    (2, 1000, 'kunde@kunde.dk', 'b', 'customer', 'Winnie', 'Hansen', 'Ved Søen 2', 50505050),
    (4, 1000, 'kunde4@kunde.dk', 'b', 'customer', 'Hans', 'Hansen', 'Ved Søen 2', 50505050);
    
-- Demo data ordrelisteTest
INSERT INTO ordrelisteTest VALUES
	(1, 1, '2017-9-9');
INSERT INTO ordrelisteTest VALUES
	(2, 1, '2017-12-12');

-- Demo til odetaljerTest
INSERT INTO odetaljerTest VALUES
	(1,1,'Bestilt',240, 240, 225,210,150,1,4600.00);
INSERT INTO odetaljerTest VALUES
	(2,2,'Godkendt',240, 240, 225,0,0,1,2900.00);

-- Data til materialelisteTest 
INSERT INTO materialelisteTest values -- vareid, varenummer, materialetype, materialenavn, enhed, enhedsprise, længde 
	(1, 'Træ', '25x200 mm. trykimp. Brædt', 'stk', 26.95, 100, 'Basis'); -- 1085025200 0300
INSERT INTO materialelisteTest values  
	(2, 'Træ', '25x125 mm. trykimp. Brædt', 'stk', 29.95, 100, 'Basis');
 INSERT INTO materialelisteTest values   
 	(3, 'Træ', '38x73 mm. Lægte ubh.', 'stk', 20.95, 100, 'Skur'); -- skurdel
 INSERT INTO materialelisteTest values   
 	(4, 'Træ', '45x95 mm. Reglar ub.', 'm', 14.75, 100, 'Skur'); -- skurdel, skal bruges to gange
 INSERT INTO materialelisteTest values   
 	(5, 'Træ', '45x195 mm. spærtræ ubh.', 'm', 37.95, 100, 'Skur'); -- skurdel
INSERT INTO materialelisteTest values   
	(6, 'Træ', '97x97 mm. trykimp. Stolpe 300 cm', 'stk', 83.85, 1, 'Basis'); -- Også skurdel!
INSERT INTO materialelisteTest values   
	(7, 'Træ', '19x100	mm. trykimp. Brædt', 'm', 6.95, 100, 'Basis');
-- Ovenstående tilføjes igen
INSERT INTO materialelisteTest values  
	(10, 'Træ', '25x150 mm. trykimp. Brædt', 'm', 37.95, 100, 'Basis'); -- 1085025150 0300
INSERT INTO materialelisteTest values  
	(11, 'Træ', '25x50 mm. trykimp. Brædt', 'Sm', 19.95, 100, 'Basis'); -- ingen vr.
INSERT INTO materialelisteTest values  
	(12, 'Træ', 'Færdigskåret (byg-selv spær)', 'sæt', 2200.00, 1, 'Basis'); -- ingen vr. 

-- Beslag og Skruer    
INSERT INTO materialelisteTest values   
	(13, 'Beslag & Skruer', 'Plastmo bundskruer 200 stk', 'Pakke', 197.95, 1, 'Basis');
INSERT INTO materialelisteTest values   
	(14, 'Beslag & Skruer', 'hulbånd 1x20 mm. 10 mtr.', 'Rulle', 189.00, 1, 'Basis');
INSERT INTO materialelisteTest values   
	(15, 'Beslag & Skruer', 'Universal 190 mm højre', 'Stk', 37.00, 1, 'Basis');
INSERT INTO materialelisteTest values   
	(16, 'Beslag & Skruer', 'Universal 190 mm venstre', 'Stk', 37.00, 1, 'Basis');
INSERT INTO materialelisteTest values   
	(17, 'Beslag & Skruer', '4,5 x 60 mm. skruer 200 stk.', 'Pakke', 109.00, 1, 'Basis');
INSERT INTO materialelisteTest values   
	(18, 'Beslag & Skruer', '4,0 x 50 mm. beslagskruer 250 stk.', 'Pakke', 159.00, 1, 'Basis');
INSERT INTO materialelisteTest values   
	(19, 'Beslag & Skruer', 'Bræddebolt 10 x 120 mm.', 'Stk', 18.76, 1, 'Basis');
INSERT INTO materialelisteTest values   
	(20, 'Beslag & Skruer', 'Firkantskiver 40x40x11mm.', 'Stk', 9.76, 1, 'Basis');
INSERT INTO materialelisteTest values   
	(21, 'Beslag & Skruer', '4,5 x 70 mm. Skruer 400 stk.', 'Pakke', 289.00, 1, 'Basis');
INSERT INTO materialelisteTest values   
	(22, 'Beslag & Skruer', '4,5 x 50 mm. Skruer 300 stk.', 'Pakke', 229.00, 1, 'Basis');
 INSERT INTO materialelisteTest values   
 	(23, 'Beslag & Skruer', 'Stalddørsgreb 50x75', 'Sæt', 189.00, 1, 'Skur'); -- skurdel
 INSERT INTO materialelisteTest values   
 	(24, 'Beslag & Skruer', 'T hængsel 390 mm.', 'Stk', 119.95, 1, 'Skur'); -- skurdel
 INSERT INTO materialelisteTest values   
 	(25, 'Beslag & Skruer', 'Vinkelbeslag 35', 'Stk', 2.50, 1, 'Skur'); -- skurdel
INSERT INTO materialelisteTest values   
	(26, 'Beslag & Skruer', '5,0 x 40 mm. beslagskruer 250 stk.', 'Pakke', 229.00, 1, 'Basis'); -- ingen vr.
INSERT INTO materialelisteTest values   
	(27, 'Beslag & Skruer', '5,0 x 100 mm. Skruer 100 stk.', 'Pakke', 339.00, 1, 'Basis'); -- ingen vr.
    
-- Tagpakken
 INSERT INTO materialelisteTest values   
	(8, 'Tagpakken', 'Plastmo Ecolite blåtonet 600', 'Stk', 330.00, 1, 'Basis_tag');
 INSERT INTO materialelisteTest values   
 	(9, 'Tagpakken', 'Plastmo Ecolite blåtonet 300', 'Stk', 119.00, 1, 'Basis_tag');
 INSERT INTO materialelisteTest values   
 	(28, 'Tagpakken', 'B & C Dobbelt -s sort', 'Stk', 49.95, 1, 'Tag'); -- ingen vr.
 INSERT INTO materialelisteTest values   
 	(29, 'Tagpakken', 'B & C Rygsten sort', 'Stk', 89.95, 1, 'Tag'); -- 7921695
 INSERT INTO materialelisteTest values   
 	(30, 'Tagpakken', 'B & C Toplægtholder', 'Stk', 18.50, 1, 'Tag'); -- ingen vr.
INSERT INTO materialelisteTest values   
 	(31, 'Tagpakken', 'B & C Rygstensbeslag', 'Stk', 294.00, 1, 'Tag'); -- ingen vr. 
 INSERT INTO materialelisteTest values   
 	(32, 'Tagpakken', 'B & C Tagstensbindere & nakkekroge', 'Pk', 524.00, 1, 'Tag'); -- ingen vr.
INSERT INTO materialelisteTest values   
	(33, 'Tagpakken', 'Plastmo Ecolite blåtonet 480', 'Stk', 199.00, 1, 'Basis_tag'); 
    
commit;    
    
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;