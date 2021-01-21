-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: test
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
-- Table structure for table `attend`
--

DROP TABLE IF EXISTS `attend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attend` (
  `at_num` int NOT NULL,
  `at_st_num` int NOT NULL,
  `at_co_num` int NOT NULL,
  `at_mid` int NOT NULL DEFAULT '0',
  `at_final` int NOT NULL DEFAULT '0',
  `at_attend` int NOT NULL DEFAULT '0',
  `at_homework` int NOT NULL DEFAULT '0',
  `at_score` varchar(45) DEFAULT NULL,
  `at_pass` varchar(1) NOT NULL DEFAULT 'N',
  `at_repetition` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`at_num`),
  KEY `at_co_num_idx` (`at_co_num`),
  KEY `at_st_num_idx` (`at_st_num`),
  CONSTRAINT `at_co_num` FOREIGN KEY (`at_co_num`) REFERENCES `course` (`co_num`),
  CONSTRAINT `at_st_num` FOREIGN KEY (`at_st_num`) REFERENCES `student` (`st_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attend`
--

LOCK TABLES `attend` WRITE;
/*!40000 ALTER TABLE `attend` DISABLE KEYS */;
INSERT INTO `attend` VALUES (1,2020123001,1,0,0,0,0,NULL,'N','N'),(2,2020123001,2,0,0,0,0,NULL,'N','N'),(3,2020123001,3,0,0,0,0,NULL,'N','N'),(4,2020123001,5,0,0,0,0,NULL,'N','N'),(5,2020123002,2,0,0,0,0,NULL,'N','N'),(6,2020123002,4,0,0,0,0,NULL,'N','N'),(7,2020123002,6,0,0,0,0,NULL,'N','N'),(8,2020160001,1,0,0,0,0,NULL,'N','N'),(9,2020160001,3,0,0,0,0,NULL,'N','N'),(10,2020160001,6,0,0,0,0,NULL,'N','N'),(11,2020160002,2,0,0,0,0,NULL,'N','N'),(12,2020160002,4,0,0,0,0,NULL,'N','N'),(13,2020160002,5,0,0,0,0,NULL,'N','N'),(14,2020456001,1,0,0,0,0,NULL,'N','N'),(15,2020456001,3,0,0,0,0,NULL,'N','N'),(16,2020456001,4,0,0,0,0,NULL,'N','N'),(17,2020456001,5,0,0,0,0,NULL,'N','N'),(18,2020456001,6,0,0,0,0,NULL,'N','N');
/*!40000 ALTER TABLE `attend` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-16 14:14:02
