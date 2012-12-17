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
-- Table structure for table `eb_cuenta`
--

DROP TABLE IF EXISTS `eb_cuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eb_cuenta` (
  `CodigoCuenta` int(11) NOT NULL AUTO_INCREMENT,
  `CodigoCliente` int(11) NOT NULL,
  `CodigoMoneda` int(11) NOT NULL,
  `Activo` bit(1) DEFAULT NULL,
  `CodigoLocal` int(11) DEFAULT NULL,
  `CodigoUsuario` int(11) DEFAULT NULL,
  `FechaCreacionCuenta` date DEFAULT NULL,
  `SaldoCuenta` decimal(14,3) DEFAULT NULL,
  `UsuarioNombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CodigoCuenta`),
  KEY `R_2` (`CodigoCliente`),
  KEY `R_3` (`CodigoMoneda`),
  KEY `R_5` (`CodigoLocal`),
  KEY `R_7` (`CodigoUsuario`),
  CONSTRAINT `eb_cuenta_ibfk_1` FOREIGN KEY (`CodigoCliente`) REFERENCES `eb_cliente` (`CodigoCliente`),
  CONSTRAINT `eb_cuenta_ibfk_2` FOREIGN KEY (`CodigoMoneda`) REFERENCES `eb_moneda` (`CodigoMoneda`),
  CONSTRAINT `eb_cuenta_ibfk_3` FOREIGN KEY (`CodigoLocal`) REFERENCES `eb_local` (`CodigoLocal`),
  CONSTRAINT `eb_cuenta_ibfk_4` FOREIGN KEY (`CodigoUsuario`) REFERENCES `eb_usuario` (`CodigoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eb_cuenta`
--

LOCK TABLES `eb_cuenta` WRITE;
/*!40000 ALTER TABLE `eb_cuenta` DISABLE KEYS */;
INSERT INTO `eb_cuenta` VALUES (1,1,1,'',1,NULL,'2012-12-17',230.000,'admin');
/*!40000 ALTER TABLE `eb_cuenta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-12-17  2:28:39
