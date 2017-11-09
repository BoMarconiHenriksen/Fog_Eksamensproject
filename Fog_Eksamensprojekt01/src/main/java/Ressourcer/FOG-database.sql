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
`varenummer`int (20) not null, 
`materialetype`varchar (45) ,
`materialenavn` varchar(50),
`enhed`varchar(10), 
`enhedspris`double (11,2),
`type`varchar (45),
`længde`int (11),
primary key (varenummer)
);

drop table if exists `odetaljer`;
create table `odetaljer`(

	`odetaljer_id`int(11) not null auto_increment, 
    `ordre_id` int(11),
	`length`int(11),
	`width`int(11), 
	`height`int(11), 
	`tagtype`int (11), 
    `redskabsrum`boolean default false,  
    primary key (odetaljer_id),
	FOREIGN key (`ordre_id`)references orderlist(`ordre_id`));
    
    

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;