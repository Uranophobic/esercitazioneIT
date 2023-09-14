CREATE DATABASE  IF NOT EXISTS `universita` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `universita`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: universita
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `appello`
--

DROP TABLE IF EXISTS `appello`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appello` (
  `idappello` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `aula` varchar(45) NOT NULL,
  `orario` varchar(45) NOT NULL,
  `materia` varchar(45) NOT NULL,
  PRIMARY KEY (`idappello`),
  KEY `materia_idx` (`materia`),
  CONSTRAINT `materia nome` FOREIGN KEY (`materia`) REFERENCES `materia` (`nome_materia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appello`
--

LOCK TABLES `appello` WRITE;
/*!40000 ALTER TABLE `appello` DISABLE KEYS */;
INSERT INTO `appello` VALUES (1,'2023-10-10','A2','9:00','Ingegneria del software'),(2,'2023-10-10','B4','10:00','Programmazione Object Oriented');
/*!40000 ALTER TABLE `appello` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscrizione`
--

DROP TABLE IF EXISTS `iscrizione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `iscrizione` (
  `idiscrizione` int NOT NULL AUTO_INCREMENT,
  `matr_stud` int NOT NULL,
  `nome_mat` varchar(45) NOT NULL,
  PRIMARY KEY (`idiscrizione`),
  KEY `matric_idx` (`matr_stud`),
  KEY `nome_mat_idx` (`nome_mat`),
  CONSTRAINT `matric` FOREIGN KEY (`matr_stud`) REFERENCES `studente` (`matricola`),
  CONSTRAINT `nome_mat` FOREIGN KEY (`nome_mat`) REFERENCES `materia` (`nome_materia`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='tabella che indica quale corso segue ogni studente (quindi a quale si è iscritto)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizione`
--

LOCK TABLES `iscrizione` WRITE;
/*!40000 ALTER TABLE `iscrizione` DISABLE KEYS */;
INSERT INTO `iscrizione` VALUES (1,100,'Architettura degli elaboratori'),(2,101,'Architettura degli elaboratori'),(3,102,'Architettura degli elaboratori'),(4,100,'Programmazione Object Oriented'),(5,101,'Programmazione Object Oriented'),(6,102,'Ingegneria del software');
/*!40000 ALTER TABLE `iscrizione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lezione`
--

DROP TABLE IF EXISTS `lezione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lezione` (
  `idcorso` int NOT NULL,
  `materia` varchar(45) NOT NULL,
  `cattedra` int DEFAULT NULL,
  `orario` varchar(45) NOT NULL,
  `aula` varchar(45) NOT NULL,
  PRIMARY KEY (`idcorso`),
  KEY `materia _idx` (`materia`),
  CONSTRAINT `materia ` FOREIGN KEY (`materia`) REFERENCES `materia` (`nome_materia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lezione`
--

LOCK TABLES `lezione` WRITE;
/*!40000 ALTER TABLE `lezione` DISABLE KEYS */;
INSERT INTO `lezione` VALUES (1,'Architettura degli elaboratori',NULL,'9:00','A1'),(2,'Ingegneria del software',NULL,'12:00','B2'),(3,'Programmazione Object Oriented',NULL,'14:00','C4');
/*!40000 ALTER TABLE `lezione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia` (
  `nome_materia` varchar(45) NOT NULL,
  `id_prof` int NOT NULL,
  `anno_corso` varchar(45) NOT NULL,
  `semestre` varchar(45) NOT NULL,
  `cfu` int NOT NULL,
  PRIMARY KEY (`nome_materia`),
  KEY `id prof_idx` (`id_prof`),
  CONSTRAINT `identificativo` FOREIGN KEY (`id_prof`) REFERENCES `professore` (`idprofessore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES ('Architettura degli elaboratori',1,'1','1',9),('Ingegneria del software',3,'3','2',12),('Programmazione Object Oriented',2,'2','1',10);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazione` (
  `idprenotazione` int NOT NULL AUTO_INCREMENT,
  `id_prof` varchar(45) DEFAULT NULL,
  `id_app` int NOT NULL,
  `matricola_stud` int NOT NULL,
  PRIMARY KEY (`idprenotazione`),
  KEY `appello id_idx` (`id_app`),
  KEY `matricola_idx` (`matricola_stud`),
  CONSTRAINT `appello id` FOREIGN KEY (`id_app`) REFERENCES `appello` (`idappello`),
  CONSTRAINT `matricola` FOREIGN KEY (`matricola_stud`) REFERENCES `studente` (`matricola`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
INSERT INTO `prenotazione` VALUES (1,'1',1,100),(2,'2',2,101),(3,'3',2,102);
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `prevent_duplicate_booking` BEFORE INSERT ON `prenotazione` FOR EACH ROW BEGIN
DECLARE existing_prenotazione INT;

SELECT COUNT(*) INTO existing_prenotazione
FROM prenotazione
WHERE matricola_stud = NEW.matricola_stud AND id_app = NEW.id_app;

IF existing_prenotazione > 0 THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Una prenotazione per questo studente e appello esiste già.';
END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `professore`
--

DROP TABLE IF EXISTS `professore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professore` (
  `idprofessore` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idprofessore`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professore`
--

LOCK TABLES `professore` WRITE;
/*!40000 ALTER TABLE `professore` DISABLE KEYS */;
INSERT INTO `professore` VALUES (1,'Nicola','Gravino','n.gravino','n.gravino'),(2,'Sara','Rossi','s.rossi','s.rossi'),(3,'Mario','Verdi','m.verdi','m.verdi');
/*!40000 ALTER TABLE `professore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segreteria`
--

DROP TABLE IF EXISTS `segreteria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `segreteria` (
  `idsegreteria` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idsegreteria`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segreteria`
--

LOCK TABLES `segreteria` WRITE;
/*!40000 ALTER TABLE `segreteria` DISABLE KEYS */;
INSERT INTO `segreteria` VALUES (1,'Giorgia','Grigio','g.grigio','g.grigio'),(2,'Francesco','Pio','f.pio','f.pio');
/*!40000 ALTER TABLE `segreteria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studente`
--

DROP TABLE IF EXISTS `studente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studente` (
  `matricola` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `corso_di_laurea` varchar(45) NOT NULL,
  `anno_immatricolazione` varchar(45) NOT NULL,
  PRIMARY KEY (`matricola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studente`
--

LOCK TABLES `studente` WRITE;
/*!40000 ALTER TABLE `studente` DISABLE KEYS */;
INSERT INTO `studente` VALUES (100,'Alessia','Crispo','a.crispo','a.crispo','Triennale Informatica','2023'),(101,'Giovanni','Russo','g.russo','g.russo','Triennale in Ingegneria Informatica','2023'),(102,'Eugenia','Esposito','e.esposito','e.esposito','Triennale Informatica','2023');
/*!40000 ALTER TABLE `studente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `idticket` int NOT NULL AUTO_INCREMENT,
  `idstud` int NOT NULL,
  `idammministrativo` int NOT NULL,
  `richiesta` varchar(45) NOT NULL,
  `chiuso` tinyint DEFAULT NULL,
  PRIMARY KEY (`idticket`),
  KEY `ids_idx` (`idstud`),
  KEY `id ammm_idx` (`idammministrativo`),
  CONSTRAINT `id ammm` FOREIGN KEY (`idammministrativo`) REFERENCES `segreteria` (`idsegreteria`),
  CONSTRAINT `ids` FOREIGN KEY (`idstud`) REFERENCES `studente` (`matricola`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,100,1,'Come posso chiedere il tirocinio?',0),(2,101,2,'Quanto tempo ho per consegnare la tesi?',1);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'universita'
--

--
-- Dumping routines for database 'universita'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-14  9:57:08
