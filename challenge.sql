-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: challenge
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `id_genero` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `imagen` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'Acción','\\images\\genero\\accion.jpg'),(2,'Animación','\\images\\genero\\animacion.jpg'),(3,'Aventura','\\images\\genero\\aventura.jpg'),(4,'Ciencia Ficción','\\images\\genero\\ciencia_ficcion.jpg'),(5,'Comedia','\\images\\genero\\comedia.jpg'),(6,'Drama','\\images\\genero\\drama.jpg'),(7,'Fantasía','\\images\\genero\\fantasia.jpg'),(8,'Musical','\\images\\genero\\musical.jpg'),(9,'Suspenso','\\images\\genero\\suspenso.jpg'),(10,'Terror','\\images\\genero\\terror.jpg');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `id_pelicula` int NOT NULL AUTO_INCREMENT,
  `imagen` varchar(45) DEFAULT NULL,
  `titulo` varchar(45) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL,
  `calificacion` int DEFAULT NULL,
  PRIMARY KEY (`id_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'\\images\\movies\\tarzan.jpg','Tarzán','1999-07-08',5),(2,'\\images\\movies\\el_rey_leon.jpg','El rey león','1994-07-07',4),(3,'\\images\\movies\\cenicienta.jpg','La cenicienta','1950-07-05',3);
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_genero`
--

DROP TABLE IF EXISTS `pelicula_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_genero` (
  `id_pelicula_genero` int NOT NULL AUTO_INCREMENT,
  `id_pelicula` int NOT NULL,
  `id_genero` int NOT NULL,
  PRIMARY KEY (`id_pelicula_genero`),
  KEY `fk_pelicula_genero_pelicula_idx` (`id_pelicula`),
  KEY `fk_pelicula_genero_genero_idx` (`id_genero`),
  CONSTRAINT `fk_pelicula_genero_genero` FOREIGN KEY (`id_genero`) REFERENCES `genero` (`id_genero`),
  CONSTRAINT `fk_pelicula_genero_pelicula` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_genero`
--

LOCK TABLES `pelicula_genero` WRITE;
/*!40000 ALTER TABLE `pelicula_genero` DISABLE KEYS */;
INSERT INTO `pelicula_genero` VALUES (1,2,2),(2,2,3),(3,2,5),(7,3,2),(8,3,7),(9,3,8),(10,1,1),(11,1,2),(12,1,3);
/*!40000 ALTER TABLE `pelicula_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula_personaje`
--

DROP TABLE IF EXISTS `pelicula_personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula_personaje` (
  `id_pelicula_personaje` int NOT NULL AUTO_INCREMENT,
  `id_pelicula` int NOT NULL,
  `id_personaje` int NOT NULL,
  PRIMARY KEY (`id_pelicula_personaje`),
  KEY `fk_id_pelicula_idx` (`id_pelicula`),
  KEY `fk_id_personaje_idx` (`id_personaje`),
  CONSTRAINT `fk_pelicula_personaje_pelicula` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`),
  CONSTRAINT `fk_pelicula_personaje_personaje` FOREIGN KEY (`id_personaje`) REFERENCES `personaje` (`id_personaje`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula_personaje`
--

LOCK TABLES `pelicula_personaje` WRITE;
/*!40000 ALTER TABLE `pelicula_personaje` DISABLE KEYS */;
INSERT INTO `pelicula_personaje` VALUES (1,1,1),(2,2,2),(3,3,3);
/*!40000 ALTER TABLE `pelicula_personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje`
--

DROP TABLE IF EXISTS `personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje` (
  `id_personaje` int NOT NULL AUTO_INCREMENT,
  `imagen` varchar(200) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `historia` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_personaje`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje`
--

LOCK TABLES `personaje` WRITE;
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` VALUES (1,'\\images\\personajes\\tarzán.jpg','Tarzán',20,100,'Personaje de la pelicula Tarzán'),(2,'\\images\\personajes\\mufasa.jpg','Mufasa',10,120,'Personaje de la pelicula El rey león'),(3,'\\images\\personajes\\cenicienta.jpg','Cenicienta',16,65,'Personaje de la pelicula La cenicienta');
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Néstor Gabriel','Escobar','nestor.escobar.nge@gmail.com','Hadoken','123');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-15  6:06:32
