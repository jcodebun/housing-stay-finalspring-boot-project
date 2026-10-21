/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.22 : Database - housing-stay
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`housing-stay` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `housing-stay`;

/*Table structure for table `book_stay` */

DROP TABLE IF EXISTS `book_stay`;

CREATE TABLE `book_stay` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `room_no` varchar(225) DEFAULT NULL,
  `booking_date` date DEFAULT NULL,
  `booking_no` bigint DEFAULT NULL,
  `check_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  `home_stay_id` bigint DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `home_stay` bigint NOT NULL,
  `user` bigint NOT NULL,
  `owner_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkqh0j45s7ksou44avgmdyk8td` (`home_stay`),
  KEY `FKtaj7nupi0tycyathmp66xay0m` (`user`),
  CONSTRAINT `FKkqh0j45s7ksou44avgmdyk8td` FOREIGN KEY (`home_stay`) REFERENCES `housing_stay` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKtaj7nupi0tycyathmp66xay0m` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `book_stay` */

insert  into `book_stay`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`room_no`,`booking_date`,`booking_no`,`check_in`,`check_out`,`home_stay_id`,`room_id`,`user_id`,`home_stay`,`user`,`owner_id`) values 
(5,'User123','2021-07-21 09:13:21.518000','User123','2021-07-21 09:13:21.518000','101','2021-07-21',754742344946,'2021-07-21','2021-07-23',2,2,4,2,4,2),
(6,'User123','2021-07-21 09:22:52.852000','User123','2021-07-21 09:22:52.852000','102','2021-07-21',842225129921,'2021-07-22','2021-07-30',3,3,4,3,4,5);

/*Table structure for table `book_tour` */

DROP TABLE IF EXISTS `book_tour`;

CREATE TABLE `book_tour` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `booking_date` date DEFAULT NULL,
  `booking_no` bigint DEFAULT NULL,
  `check_in` date DEFAULT NULL,
  `check_out` date DEFAULT NULL,
  `tour_package_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `tour_package` bigint NOT NULL,
  `user` bigint NOT NULL,
  `owner_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc2m6y6do56omd6i4e914gtndb` (`tour_package`),
  KEY `FKs1ih0fgkehykvf1oa4v7rkb8k` (`user`),
  CONSTRAINT `FKc2m6y6do56omd6i4e914gtndb` FOREIGN KEY (`tour_package`) REFERENCES `tour_package` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKs1ih0fgkehykvf1oa4v7rkb8k` FOREIGN KEY (`user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `book_tour` */

insert  into `book_tour`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`booking_date`,`booking_no`,`check_in`,`check_out`,`tour_package_id`,`user_id`,`tour_package`,`user`,`owner_id`) values 
(2,'User123','2021-07-21 09:13:30.675000','User123','2021-07-21 09:13:30.675000','2021-07-21',295290692182,'2021-07-24','2021-07-27',2,4,2,4,5);

/*Table structure for table `feed_back` */

DROP TABLE IF EXISTS `feed_back`;

CREATE TABLE `feed_back` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `question` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `feed_back` */

insert  into `feed_back`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`question`) values 
(2,'Admin123','2021-07-21 09:23:36.046000','Admin123','2021-07-21 09:23:36.046000','Possimus repellendu');

/*Table structure for table `help` */

DROP TABLE IF EXISTS `help`;

CREATE TABLE `help` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `comment` varchar(225) DEFAULT NULL,
  `date` datetime(6) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `issue` varchar(225) DEFAULT NULL,
  `request_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `help` */

insert  into `help`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`comment`,`date`,`description`,`issue`,`request_id`) values 
(4,'Admin123','2021-07-21 09:23:29.716000','Admin123','2021-07-21 09:23:29.716000','sdvsdv','2021-07-21 09:23:29.716000','Enim et quis et reru','Odio eu non exceptur',7285);

/*Table structure for table `housing_stay` */

DROP TABLE IF EXISTS `housing_stay`;

CREATE TABLE `housing_stay` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `address` varchar(1500) DEFAULT NULL,
  `contact_no` varchar(225) DEFAULT NULL,
  `facilities` varchar(1500) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `no_of_rooms` varchar(225) DEFAULT NULL,
  `stay_date` date DEFAULT NULL,
  `location` varchar(225) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `housing_stay` */

insert  into `housing_stay`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`address`,`contact_no`,`facilities`,`name`,`no_of_rooms`,`stay_date`,`location`,`user_id`) values 
(2,'Owner123','2021-07-21 09:03:55.525000','Owner123','2021-07-21 09:03:55.525000','Tempora assumenda ladvcsdvsdvsdv','96854658525','Voluptatem saepe mol','Miriam Rocha','3',NULL,'Maxime sapiente tene',5),
(3,'Owner123','2021-07-21 09:04:05.504000','Owner123','2021-07-21 09:04:05.504000','Similique ut harum d','96854658525','Quam mollitia quidem','Angela Foreman','5',NULL,'Aut consequat Nesci',5);

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `description` varchar(225) DEFAULT NULL,
  `facilities` varchar(1500) DEFAULT NULL,
  `home_stay_id` bigint DEFAULT NULL,
  `room_no` varchar(225) DEFAULT NULL,
  `home_stay` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqh5j99esqk4b4t1qk85myvko9` (`home_stay`),
  CONSTRAINT `FKqh5j99esqk4b4t1qk85myvko9` FOREIGN KEY (`home_stay`) REFERENCES `housing_stay` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `room` */

insert  into `room`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`description`,`facilities`,`home_stay_id`,`room_no`,`home_stay`) values 
(2,'Owner123','2021-07-21 09:09:24.494000','Owner123','2021-07-21 09:09:24.494000','Consequatur Tempore','Proident non esse d',2,'101',2),
(3,'Owner123','2021-07-21 09:11:04.333000','Owner123','2021-07-21 09:11:04.333000','Vitae distinctio Cusdvsdv','Nostrud aut occaecat',3,'102',3);

/*Table structure for table `tour_package` */

DROP TABLE IF EXISTS `tour_package`;

CREATE TABLE `tour_package` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `contact_no` varchar(225) DEFAULT NULL,
  `tour_date` date DEFAULT NULL,
  `destination` varchar(225) DEFAULT NULL,
  `facilities` varchar(225) DEFAULT NULL,
  `home_stay_id` bigint DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `no_of_days` varchar(225) DEFAULT NULL,
  `price` varchar(225) DEFAULT NULL,
  `home_stay` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmpcniw9utp6hcv519ihjqfek2` (`home_stay`),
  CONSTRAINT `FKmpcniw9utp6hcv519ihjqfek2` FOREIGN KEY (`home_stay`) REFERENCES `housing_stay` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tour_package` */

insert  into `tour_package`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`contact_no`,`tour_date`,`destination`,`facilities`,`home_stay_id`,`name`,`no_of_days`,`price`,`home_stay`,`user_id`) values 
(2,'Owner123','2021-07-21 09:04:37.865000','Owner123','2021-07-21 09:04:37.865000','9685465852',NULL,'Officia tempore non','Dolor inventore nihi',3,'Piper Kline','22','360',3,5),
(3,'Owner123','2021-07-21 09:09:06.297000','Owner123','2021-07-21 09:09:06.297000','9685465852',NULL,'Veritatis esse neces','Voluptas modi laboru',2,'Quemby Key','2','66',2,5);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `contact_no` varchar(225) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `first_name` varchar(225) DEFAULT NULL,
  `gender` varchar(225) DEFAULT NULL,
  `last_name` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  `role_name` varchar(225) DEFAULT NULL,
  `user_id` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`contact_no`,`dob`,`email`,`first_name`,`gender`,`last_name`,`password`,`role_id`,`role_name`,`user_id`) values 
(1,'root','2021-07-17 12:30:33.571000','root','2021-07-17 12:30:33.571000','9685456585','1997-02-27','pesinyxyr@mailinator.com,repava@mailinator.com','Marvin','Female','Figueroa','Pa$$w0rd!',1,'ADMIN','Admin123'),
(4,'root','2021-07-21 08:59:51.659000','root','2021-07-21 08:59:51.659000','9685465856','2021-07-06','waqakile@mailinator.com,porynah@mailinator.com','Cooper','Male','Vaughan','Pa$$w0rd!',2,'USER','User123'),
(5,'root','2021-07-21 09:00:19.110000','root','2021-07-21 09:00:19.110000','9685456585','2021-07-12','pikopod@mailinator.com,jucutyce@mailinator.com','Grady','Female','Maldonado','Pa$$w0rd!',3,'OWNER','Owner123');

/*Table structure for table `user_feed_back` */

DROP TABLE IF EXISTS `user_feed_back`;

CREATE TABLE `user_feed_back` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `created_datetime` datetime(6) DEFAULT NULL,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_datetime` datetime(6) DEFAULT NULL,
  `feed_back` varchar(1500) DEFAULT NULL,
  `question` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user_feed_back` */

insert  into `user_feed_back`(`id`,`created_by`,`created_datetime`,`modified_by`,`modified_datetime`,`feed_back`,`question`) values 
(1,'User123','2021-07-21 09:23:50.103000','User123','2021-07-21 09:23:50.103000','Minima ut et omnis s','Possimus repellendu');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
