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
-- Table structure for table `TBL1001_USER`
--

DROP TABLE IF EXISTS `TBL1001_USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL1001_USER` (
  `PRG_IDE_USR` int(10) NOT NULL AUTO_INCREMENT,
  `USR_NAM` varchar(30) NOT NULL,
  `MTC_LDP` varchar(30) DEFAULT NULL,
  `PAS_USR` varchar(100) NOT NULL,
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
-- Dumping data for table `TBL1001_USER`
--

LOCK TABLES `TBL1001_USER` WRITE;
/*!40000 ALTER TABLE `TBL1001_USER` DISABLE KEYS */;
INSERT INTO `TBL1001_USER` VALUES (1,'s.arellano','s.arellano','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','Sergio Alexander','Arellano Diaz','sergioarellanodiaz@gmail.com','NULL','2016-02-10','2999-12-31','2016-02-10','SYS','127.0.0.1'),(2,'u.name_1','matricola_1','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 1','name 1','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(3,'u.name_2','matricola_2','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 2','name 2','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(5,'u.name_3','matricola_3','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 3','name 3','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(6,'u.name_4','matricola_4','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 4','name 4','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(7,'u.name_5','matricola_5','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 5','name 5','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(8,'u.name_6','matricola_6','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 6','name 6','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(9,'u.name_7','matricola_7','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 7','name 7','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(10,'u.name_8','matricola_8','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 8','name 8','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(11,'u.name_9','matricola_9','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 9','name 9','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(12,'u.name_10','matricola_10','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 10','name 10','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1'),(13,'u.name_11','matricola_11','zFJVJOiOiDIQxLLTk5Ul+DA6hBij4203','user 11','name 11','NULL','NULL',NULL,NULL,NULL,'BATCH','127.0.0.1');
/*!40000 ALTER TABLE `TBL1001_USER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL1002_LOGIN_ACCESS`
--

DROP TABLE IF EXISTS `TBL1002_LOGIN_ACCESS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL1002_LOGIN_ACCESS` (
  `PRG_LOG_ACC` int(10) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(30) NOT NULL,
  `TOKEN` varchar(60) DEFAULT NULL,
  `IP_ADDRESS` varchar(60) NOT NULL,
  `LOGIN_TIME` date DEFAULT NULL,
  `LOGOUT_TIME` date DEFAULT NULL,
  `ELAPSED_TIME` int(6) unsigned DEFAULT NULL,
  `TYPE_ACCESS` varchar(20) DEFAULT NULL,
  `BROWSER` varchar(40) DEFAULT NULL,
  `OS` varchar(50) DEFAULT NULL,
  `STATUS` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`PRG_LOG_ACC`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL1002_LOGIN_ACCESS`
--

LOCK TABLES `TBL1002_LOGIN_ACCESS` WRITE;
/*!40000 ALTER TABLE `TBL1002_LOGIN_ACCESS` DISABLE KEYS */;
INSERT INTO `TBL1002_LOGIN_ACCESS` VALUES (14,'','3e14e355c4e5aa270c629b2681b95178','127.0.0.1','2016-02-26',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(15,'','d62836c91fb8f7ae293a9ebacd0a40df','127.0.0.1','2016-02-26',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(16,'','c8f7b38cbfe3963aa95c56717553695c','127.0.0.1','2016-02-26',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(17,'','95f0443dfda4ec329f438dd9c056d249','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(18,'','9d5745f61327e3d91fb282da28184e9c','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(19,'s.arellano','4e52507483b59df0450022fa6552134b','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(20,'s.arellano','56c283ca33a6966b2a50a77c01829a32','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46',NULL,'S'),(21,'s.arellano','ed41229a59d5d15062614f9e2846f20e','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(22,'s.arellano',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(23,'s.arellano',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(24,'s.arellano','c4fbae5514f8b58d0fbdf56549d41f52','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(25,'s.arellano','287140a90d69fcce45c1c65770a2e0d2','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(26,'s.arellano',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'LDAP','Chrome 46','Linux',NULL),(27,'s.arellano','5c3e2875781c69b929319dc241d1cb3f','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(28,'s.arellanoR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux',NULL),(29,'s.arellanoR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux',NULL),(30,'s.arellanoR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux',NULL),(31,'s.arellanodR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux',NULL),(32,'s.arellanodR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux',NULL),(33,'s.arellanodR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(34,'s.arellanodR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I');
/*!40000 ALTER TABLE `TBL1002_LOGIN_ACCESS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-27 21:04:00
