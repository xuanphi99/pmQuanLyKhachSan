-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: qlykhachsan
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblbill`
--

DROP TABLE IF EXISTS `tblbill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblbill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idBooking` int DEFAULT NULL,
  `paymentDate` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `paymentType` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `notes` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`),
  KEY `fk_booking_idx` (`idBooking`),
  CONSTRAINT `fk_booking` FOREIGN KEY (`idBooking`) REFERENCES `tblbooking` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbill`
--

LOCK TABLES `tblbill` WRITE;
/*!40000 ALTER TABLE `tblbill` DISABLE KEYS */;
INSERT INTO `tblbill` VALUES (9,13,'2021-05-03 17:04:44',20800000,'Card',''),(10,14,'2021-05-03 17:04:54',4000000,'Card',''),(11,40,'2021-05-03 17:06:06',120000,'Card',''),(13,26,'2021-05-03 17:07:01',647000,'Card',''),(14,15,'2021-05-03 17:07:12',4000000,'Card',''),(15,22,'2021-05-03 17:15:55',1998,'Card','');
/*!40000 ALTER TABLE `tblbill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblbooking`
--

DROP TABLE IF EXISTS `tblbooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblbooking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idRoom` int DEFAULT NULL,
  `idUser` int DEFAULT NULL,
  `startDate` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `endDate` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `status` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_idx` (`idUser`),
  KEY `fk_room_idx` (`idRoom`),
  CONSTRAINT `fk_room` FOREIGN KEY (`idRoom`) REFERENCES `tblroom` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user` FOREIGN KEY (`idUser`) REFERENCES `tbluser` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblbooking`
--

LOCK TABLES `tblbooking` WRITE;
/*!40000 ALTER TABLE `tblbooking` DISABLE KEYS */;
INSERT INTO `tblbooking` VALUES (13,1,1,'2021-05-06 04:0:00','2021-05-14 20:0:00',100000,'',' Đã Thanh Toán'),(14,1,1,'2021-05-13 04:0:00','2021-05-14 20:0:00',100000,'',' Đã Thanh Toán'),(15,1,1,'2021-05-02 04:0:00','2021-05-03 20:0:00',100000,'',' Đã Thanh Toán'),(16,1,1,'2021-05-27 04:0:00','2021-05-28 20:0:00',100000,'',' Chưa Thanh Toán'),(17,1,1,'2021-05-14 20:0:00','2021-05-14 21:0:00',1222,'',' Chưa Thanh Toán'),(18,1,1,'2021-05-30 0:0:00','2021-05-31 0:0:00',1000,'ê',' Chưa Thanh Toán'),(21,1,1,'2021-05-25 1:0:00','2021-05-26 0:0:00',3,'',' Chưa Thanh Toán'),(22,1,1,'2021-05-31 0:0:00','2021-05-31 18:0:00',111,'',' Đã Thanh Toán'),(23,1,1,'2021-05-01 02:00:00','2021-05-01 10:00:00',1000,'',' Chưa Thanh Toán'),(24,1,1,'2021-05-01 10:03:00','2021-05-01 18:10:00',1000,'',' Chưa Thanh Toán'),(25,1,2,'2021-05-19 00:00:00','2021-05-21 00:00:00',1000,'',' Chưa Thanh Toán'),(26,9,1,'2021-05-04 04:00:00','2021-05-31 03:00:00',1000,'fff',' Đã Thanh Toán'),(37,1,1,'2021-06-01 00:00:00','2021-06-06 00:00:00',1000,'',' Chưa Thanh Toán'),(38,9,1,'2021-06-01 00:00:00','2021-06-06 00:00:00',1000,'',' Chưa Thanh Toán'),(39,5,1,'2021-06-01 00:00:00','2021-06-06 00:00:00',1000,'',' Chưa Thanh Toán'),(40,5,1,'2021-06-01 00:00:00','2021-06-06 00:00:00',1000,'',' Đã Thanh Toán'),(41,5,1,'2021-06-01 00:00:00','2021-06-06 00:00:00',1000,'',' Chưa Thanh Toán'),(42,5,1,'2021-06-01 00:00:00','2021-06-09 00:00:00',1000,'',' Chưa Thanh Toán');
/*!40000 ALTER TABLE `tblbooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblhotel`
--

DROP TABLE IF EXISTS `tblhotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblhotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startLevel` int DEFAULT NULL,
  `address` text COLLATE utf8_unicode_ci,
  `description` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblhotel`
--

LOCK TABLES `tblhotel` WRITE;
/*!40000 ALTER TABLE `tblhotel` DISABLE KEYS */;
INSERT INTO `tblhotel` VALUES (1,'quan tb',4,'for previ','Lo'),(2,'ka ki',5,'gg','e'),(3,'naiki',5,'Dui','Excepteur'),(4,'trigkg',3,'Lorem ipsum','Purus'),(5,'thinh Vương',5,'12 nam định','Integer'),(8,'chan',1,'12 nam định',' Không ngừng học hỏi trau'),(9,'ks01',5,'101010','1010');
/*!40000 ALTER TABLE `tblhotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblroom`
--

DROP TABLE IF EXISTS `tblroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblroom` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `displayPrice` float DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  `idHotel` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_hotel_idx` (`idHotel`),
  CONSTRAINT `fk_hotel` FOREIGN KEY (`idHotel`) REFERENCES `tblhotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblroom`
--

LOCK TABLES `tblroom` WRITE;
/*!40000 ALTER TABLE `tblroom` DISABLE KEYS */;
INSERT INTO `tblroom` VALUES (1,'phisua','sua',12000,'fofo',4),(2,'phong11','thuong',100000,'no ',1),(3,'phisua','sua',12000,'fofo',4),(5,'p432','vip',1234.65,'phi\ndep trai',2),(6,'phi','rmi',12,'phi crazy		',2),(7,'minh tus','vip',12,'fs\nh',2),(8,'phiii','vip',1010010,'',2),(9,'phongAk','Vip',320302,'10101',9),(10,'dfd','vip',1000,'gtt',2),(11,'56','vip',1000,'gtt',5),(12,'12','vip',1000,'gtt',5),(13,'20','vip',1000,'gtt',5),(14,'20','vip',1000,'gtt',4),(15,'20','vip',1000,'gtt',4),(16,'33','vip',1000,'gtt',8);
/*!40000 ALTER TABLE `tblroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbluser`
--

DROP TABLE IF EXISTS `tbluser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbluser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullName` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` text COLLATE utf8_unicode_ci,
  `idCardNumber` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idCardType` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbluser`
--

LOCK TABLES `tbluser` WRITE;
/*!40000 ALTER TABLE `tbluser` DISABLE KEYS */;
INSERT INTO `tbluser` VALUES (1,'minh','minhcute','12321','nam dinh','076423423','the tin dung','Diam in arcu cursus euismod quis. Ullamcorper dignissim cras tincidunt lobortis feugiat vivamus'),(2,'phi','phi01','123','nam dinh','086546544','the ngan hang','Diam in arcu cursus euismod quis. Ullamcorper dignissim cras tincidunt lobortis feugiat vivamus'),(3,'ngoc','ngoccc','321','nam minh','03434Ab455','the tin dung','Diam in arcu cursus euismod quis. Ullamcorper dignissim cras tincidunt lobortis feugiat vivamus'),(4,'','','','','','','');
/*!40000 ALTER TABLE `tbluser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hay` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,'a'),(2,'b'),(3,'c'),(4,'d');
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'qlykhachsan'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-03 17:26:54
