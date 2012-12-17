CREATE DATABASE  IF NOT EXISTS `eb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `eb`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: eb
-- ------------------------------------------------------
-- Server version	5.5.10

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
-- Table structure for table `eb_movimiento`
--

DROP TABLE IF EXISTS `eb_movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eb_movimiento` (
  `CodigoMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoCuenta` int(11) DEFAULT NULL,
  `CostoMovimiento` decimal(14,3) DEFAULT NULL,
  `CodigoLocal` int(11) DEFAULT NULL,
  `CodigoUsuario` int(11) DEFAULT NULL,
  `FechaMovimiento` date DEFAULT NULL,
  `HoraMovimiento` time DEFAULT NULL,
  `TipoMovimiento` int(11) DEFAULT NULL,
  `MontoMovimiento` decimal(14,3) DEFAULT NULL,
  `UsuarioNombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CodigoMovimiento`),
  KEY `R_4` (`CodigoCuenta`),
  KEY `R_6` (`CodigoLocal`),
  KEY `R_8` (`CodigoUsuario`),
  CONSTRAINT `eb_movimiento_ibfk_1` FOREIGN KEY (`CodigoCuenta`) REFERENCES `eb_cuenta` (`CodigoCuenta`),
  CONSTRAINT `eb_movimiento_ibfk_2` FOREIGN KEY (`CodigoLocal`) REFERENCES `eb_local` (`CodigoLocal`),
  CONSTRAINT `eb_movimiento_ibfk_3` FOREIGN KEY (`CodigoUsuario`) REFERENCES `eb_usuario` (`CodigoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eb_movimiento`
--

LOCK TABLES `eb_movimiento` WRITE;
/*!40000 ALTER TABLE `eb_movimiento` DISABLE KEYS */;
INSERT INTO `eb_movimiento` VALUES (1,1,0.000,1,NULL,'2012-12-17','01:39:02',-1,50.000,'admin'),(2,1,0.000,2,NULL,'2012-12-17','01:39:48',1,60.000,'admin');
/*!40000 ALTER TABLE `eb_movimiento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-12-17  2:28:38
