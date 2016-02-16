CREATE DATABASE  IF NOT EXISTS `db_master_jee` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `db_master_jee`;
-- MySQL dump 10.13  Distrib 5.6.28, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db_master_jee
-- ------------------------------------------------------
-- Server version	5.6.28-0ubuntu0.15.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `TBL1001_USERS`
--

DROP TABLE IF EXISTS `TBL1001_USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL1001_USERS` (
  `PRG_IDE_USR` int(10) NOT NULL AUTO_INCREMENT,
  `USR_NAM` varchar(30) NOT NULL,
  `MTC_LDP` varchar(30) DEFAULT NULL,
  `PAS_USR` varchar(30) NOT NULL,
  `NOM_USR` varchar(30) NOT NULL,
  `COG_USR` varchar(20) NOT NULL,
  `EML_USR` varchar(60) DEFAULT NULL,
  `TEL_USR` varchar(20) DEFAULT NULL,
  `DAT_STA_VAL` date DEFAULT NULL,
  `DAT_END_VAL` date DEFAULT NULL,
  `DAT_ORA_ULT_MOD` date DEFAULT NULL,
  `COD_USR_ULT_MOD` varchar(40) DEFAULT NULL,
  `PTN_ULT_MOD` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`PRG_IDE_USR`),
  UNIQUE KEY `USR_NAM_UNIQUE` (`USR_NAM`),
  UNIQUE KEY `MTC_LDP_UNIQUE` (`MTC_LDP`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL1001_USERS`
--

LOCK TABLES `TBL1001_USERS` WRITE;
/*!40000 ALTER TABLE `TBL1001_USERS` DISABLE KEYS */;
INSERT INTO `TBL1001_USERS` VALUES (1,'master','master','password','Super','User','info@db_master_jee.com','NULL','2016-02-10','2999-12-31','2016-02-10','SYS','127.0.0.1'),(2,'u.name_1','matricola_1','password','user 1','name 1','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(3,'u.name_2','matricola_2','password','user 2','name 2','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(5,'u.name_3','matricola_3','password','user 3','name 3','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(6,'u.name_4','matricola_4','password','user 4','name 4','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(7,'u.name_5','matricola_5','password','user 5','name 5','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(8,'u.name_6','matricola_6','password','user 6','name 6','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(9,'u.name_7','matricola_7','password','user 7','name 7','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(10,'u.name_8','matricola_8','password','user 8','name 8','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(11,'u.name_9','matricola_9','password','user 9','name 9','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(12,'u.name_10','matricola_10','password','user 10','name 10','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(13,'u.name_11','matricola_11','password','user 11','name 11','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1');
/*!40000 ALTER TABLE `TBL1001_USERS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-16 21:43:39
