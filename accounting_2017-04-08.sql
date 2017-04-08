# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.11)
# Database: accounting
# Generation Time: 2017-04-08 10:07:20 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `accountNum` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `accountName` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT '',
  UNIQUE KEY `id` (`id`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;

INSERT INTO `account` (`id`, `userId`, `deleted`, `type`, `accountNum`, `accountName`)
VALUES
	(1,10,1,'1','99481','COGS');

/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table bill
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bill`;

CREATE TABLE `bill` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `creationDate` date DEFAULT NULL,
  `dueDate` date DEFAULT NULL,
  `itemName` longtext COLLATE utf8mb4_unicode_ci,
  `accountName` longtext COLLATE utf8mb4_unicode_ci,
  `accountNumber` longtext COLLATE utf8mb4_unicode_ci,
  `amount` longtext COLLATE utf8mb4_unicode_ci,
  `vendorName` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `payeeName` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `payeeEmail` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `phoneNumber` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `total` bigint(60) DEFAULT '0',
  UNIQUE KEY `id` (`id`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;

INSERT INTO `bill` (`id`, `userId`, `deleted`, `creationDate`, `dueDate`, `itemName`, `accountName`, `accountNumber`, `amount`, `vendorName`, `payeeName`, `payeeEmail`, `phoneNumber`, `total`)
VALUES
	(1,10,1,'2017-02-13','2017-02-13','','','','','Dusan','Dusan Stanojevic','dusan@dusan.com','0637538100',0);

/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table invoice
# ------------------------------------------------------------

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `creationDate` date DEFAULT NULL,
  `dueDate` date DEFAULT NULL,
  `itemName` longtext COLLATE utf8mb4_unicode_ci,
  `accountName` longtext COLLATE utf8mb4_unicode_ci,
  `accountNumber` longtext COLLATE utf8mb4_unicode_ci,
  `amount` longtext COLLATE utf8mb4_unicode_ci,
  `vendorName` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `payeeName` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `payeeEmail` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `phoneNumber` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `total` bigint(60) DEFAULT '0',
  UNIQUE KEY `id` (`id`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;



# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(24) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `password` varchar(24) COLLATE utf8mb4_unicode_ci DEFAULT '',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `username`, `password`)
VALUES
	(10,'admin','admin');

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table vendor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vendor`;

CREATE TABLE `vendor` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `deleted` tinyint(4) DEFAULT NULL,
  `vendorName` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `payeeName` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `payeeEmail` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `phoneNumber` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT '',
  UNIQUE KEY `id` (`id`),
  KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;

INSERT INTO `vendor` (`id`, `userId`, `deleted`, `vendorName`, `payeeName`, `payeeEmail`, `phoneNumber`)
VALUES
	(10,10,0,'Dusan','Dusan Stanojevic','dusan@dusan.com','0637538100');

/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
