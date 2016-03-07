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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL1002_LOGIN_ACCESS`
--

LOCK TABLES `TBL1002_LOGIN_ACCESS` WRITE;
/*!40000 ALTER TABLE `TBL1002_LOGIN_ACCESS` DISABLE KEYS */;
INSERT INTO `TBL1002_LOGIN_ACCESS` VALUES (14,'','3e14e355c4e5aa270c629b2681b95178','127.0.0.1','2016-02-26',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(15,'','d62836c91fb8f7ae293a9ebacd0a40df','127.0.0.1','2016-02-26',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(16,'','c8f7b38cbfe3963aa95c56717553695c','127.0.0.1','2016-02-26',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(17,'','95f0443dfda4ec329f438dd9c056d249','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(18,'','9d5745f61327e3d91fb282da28184e9c','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(19,'s.arellano','4e52507483b59df0450022fa6552134b','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(20,'s.arellano','56c283ca33a6966b2a50a77c01829a32','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46',NULL,'S'),(21,'s.arellano','ed41229a59d5d15062614f9e2846f20e','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(22,'s.arellano',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(23,'s.arellano',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(24,'s.arellano','c4fbae5514f8b58d0fbdf56549d41f52','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(25,'s.arellano','287140a90d69fcce45c1c65770a2e0d2','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(26,'s.arellano',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'LDAP','Chrome 46','Linux',NULL),(27,'s.arellano','5c3e2875781c69b929319dc241d1cb3f','127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(28,'s.arellanoR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux',NULL),(29,'s.arellanoR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux',NULL),(30,'s.arellanoR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux',NULL),(31,'s.arellanodR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux',NULL),(32,'s.arellanodR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux',NULL),(33,'s.arellanodR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(34,'s.arellanodR',NULL,'127.0.0.1','2016-02-27',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(35,'s.arellanodR',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(36,'s.arellanodR',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(37,'s.arellanodR',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(38,'s.arellanodR',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(39,'s.arellanodR',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(40,'s.arellanodR',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(41,'s.arellanodR',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(42,'s.arellanodR',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(43,'s.arellanodR',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(44,'s.arellanodR',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(45,'s.arellano','6243bc4152f5ec36d4487c7b880a7d91','127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(46,'s.arellano','09523e2f98a13c3f5bfbe0706a1ab855','127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(47,'s.arellano',NULL,'127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(48,'s.arellano','65a91901ae5103c593a2250d9e118a81','127.0.0.1','2016-02-28',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(49,'s.arellano','4136ed5499770a7612726819a4777616','127.0.0.1','2016-03-03',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(50,'s.arellano','abe641aa355c89ed44ffd5950d841df1','127.0.0.1','2016-03-03',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(51,'s.arellano','d67cead2eb55271f34faa4d19490fc82','127.0.0.1','2016-03-03',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(52,'s.arellano','2f6167abaf6480c07c2f9e7c24609174','127.0.0.1','2016-03-03',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(53,'s.arellano','e4bdb7aaa86c4bfff325be331c568969','127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(54,'s.arellano','46a1d93533d5ab1a617af47825af3eb8','127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(55,'s.arellano','f7bcdc30d1f996d9d167ebc0fb034ac5','127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(56,'s.arellano','707fb41c4e35df2864653dfcf4aebb8f','127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(57,'s.arellano','e6b219761c01ce9a293a2c2ca1eb4249','127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(58,'s.arellano','91f003cbc2373cf72277d0b1ae3bb058','127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(59,'s.arellano','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(60,'s.arellano','d719640305f0f197b696bbe1edc1c31d','127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(61,'s.arellano','a248e865d204027d431f3b0216edbb66','127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S'),(62,'s.arellano',NULL,'127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','I'),(63,'s.arellano','935f51472dc9ede361473cf952e38a3c','127.0.0.1','2016-03-07',NULL,NULL,'BASIC_FORM','Chrome 46','Linux','S');
/*!40000 ALTER TABLE `TBL1002_LOGIN_ACCESS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TBL1003_REQUEST`
--

DROP TABLE IF EXISTS `TBL1003_REQUEST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TBL1003_REQUEST` (
  `PRG_IDE_REQUEST` int(10) NOT NULL AUTO_INCREMENT,
  `IDENTIFIER_REQUEST` varchar(100) DEFAULT NULL,
  `USER_NAME` varchar(30) DEFAULT NULL,
  `TOKEN` varchar(60) DEFAULT NULL,
  `IP_ADDRESS_LOCAL` varchar(60) DEFAULT NULL,
  `IP_ADDRESS_REMOTE` varchar(60) DEFAULT NULL,
  `REQUEST_TIME` bigint(20) DEFAULT NULL,
  `RESPONSE_TIME` bigint(20) DEFAULT NULL,
  `ELAPSED_TIME` bigint(20) unsigned DEFAULT NULL,
  `URI_API_REST` varchar(255) DEFAULT NULL,
  `VERB_API_REST` varchar(10) DEFAULT NULL,
  `PARAMS_QUERY` varchar(500) DEFAULT NULL,
  `AGENT_BROWSER` varchar(250) DEFAULT NULL,
  `CONTENT_TYPE` varchar(200) DEFAULT NULL,
  `RESPONSE_CODE` int(10) DEFAULT NULL,
  PRIMARY KEY (`PRG_IDE_REQUEST`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TBL1003_REQUEST`
--

LOCK TABLES `TBL1003_REQUEST` WRITE;
/*!40000 ALTER TABLE `TBL1003_REQUEST` DISABLE KEYS */;
INSERT INTO `TBL1003_REQUEST` VALUES (46,'97fe14be-1395-4c93-a0a9-2459671cb4ce','--MANCANTE--','2324324','127.0.0.1','127.0.0.1',1457364743279,1457364774306,31027,'/web/v1/user/authenticate','POST','{\n  \"pippo\": [\n    \"popopo\"\n  ]\n}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',200),(47,'65d9fb7a-168e-4e2a-9bd7-a4a8eacfe3db','--MANCANTE--','2324324','127.0.0.1','127.0.0.1',1457365020136,1457365050293,30157,'/web/v1/user/authenticate','POST','{\n  \"pippo\": \"popopo\"\n}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',200),(48,'3497ac42-5eef-422f-92b3-1111c842d521','--MANCANTE--','2324324','127.0.0.1','127.0.0.1',1457365212050,1457365229093,17043,'/web/v1/user/authenticate','POST','{\"pippo\":\"popopo\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',200),(49,'29fc5616-ad82-4da5-81a4-abe026d4022c','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457365705099,1457365711608,6509,'/web/v1/user/authenticate','POST','{\"pippo\":\"popopo\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',200),(50,'469f2561-34e1-4a8b-b96b-2d57c3958888','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457365762761,1457365762957,196,'/web/v1/user/authenticate','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',200),(51,'c1b89be7-cc0d-4a8c-a28f-eebe2fd1b8ce','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457365781476,1457365781560,84,'/web/v1/user/authenticate','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',400),(52,'ff048e48-12e6-4af6-a427-28e24f94c8fd','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457367125778,1457367125780,2,'/web/v1/user/authenticate99','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',404),(53,'fe54b51d-78df-44ff-b4a1-e138621ffaa9','--MANCANTE--',NULL,'127.0.0.1','127.0.0.1',1457367164079,1457367164084,5,'/web/v1/user/authenticate','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',400),(54,'9bed6b3b-8547-42a7-8a2c-461693437bb5','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457367179214,1457367179255,41,'/web/v1/user/authenticate','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',400),(55,'7edc8e0b-cbba-4af6-ab62-ba720dbc4c00','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457367185701,1457367185703,2,'/web/v1/user/authenticate','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',500),(56,'2207a4f7-0cc6-48e4-aba8-ac899db83385','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457367199796,1457367199797,1,'/web/v1/user/authenticate','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',500),(57,'807b1668-2782-4630-a1b6-d42d64fc54be','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457367219249,1457367219435,186,'/web/v1/user/authenticate','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',200),(58,'a8f86d3c-86fa-4175-b6d1-4527c55efd19','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457370535757,1457370536035,278,'/web/v1/user/authenticate','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',400),(59,'2546f04d-2b00-4742-b4cb-ccf9cbe83d59','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457370555140,1457370677081,121941,'/web/v1/user/authenticate','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',400),(60,'0557b08d-bad6-4570-ade3-b25d25bb0a45','--MANCANTE--','045da1028a7c6a1a3c9b5da403926ff8','127.0.0.1','127.0.0.1',1457371838523,1457371880134,41611,'/web/v1/user/authenticate','POST','{\"access\":\"private\"}','Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36','application/json',400);
/*!40000 ALTER TABLE `TBL1003_REQUEST` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-07 23:06:47
