-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: db_proyecto
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_id_authority` (`user_id`,`authority`),
  UNIQUE KEY `UKrimuuii4fm3j9qt8uupyiy8nd` (`user_id`,`authority`),
  CONSTRAINT `fk_authorities_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,1,'ROLE_USER'),(3,2,'ROLE_ADMIN'),(2,2,'ROLE_USER'),(4,3,'ROLE_USER'),(5,8,'ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `create_at` date NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `address` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Machicao Quispe','2024-02-21','gmachicaoq@unsa.edu.pe','56dc36d8-c0c0-48d6-bb64-3a7a40b23743_Leonardo_Diffusion_XL_Give_me_an_80_creative_20_simple_image_f_1.jpg','Gabriel Steven','La Joya Zona B Manzaba B'),(2,'Guzman','2017-08-01','profesor@bolsadeideas.com','','Andres',NULL),(3,'Torvalds','2017-08-03','linus.torvalds@gmail.com','','Linus',NULL),(4,'Doe','2017-08-04','jane.doe@gmail.com','','Jane',NULL),(5,'Doe','2017-08-04','jane.doe@gmail.com','','Jane',NULL),(6,'Lerdorf','2017-08-05','rasmus.lerdorf@gmail.com','','Rasmus',NULL),(7,'Gamma','2017-08-06','erich.gamma@gmail.com','','Erich',NULL),(8,'Helm','2017-08-07','richard.helm@gmail.com','','Richard',NULL),(9,'Johnson','2017-08-08','ralph.johnson@gmail.com','','Ralph',NULL),(10,'Lee','2017-08-11','bruce.lee@gmail.com','','Bruce',NULL),(11,'Doe','2017-08-12','johnny.doe@gmail.com','','Johnny',NULL),(12,'Roe','2017-08-13','john.roe@gmail.com','','John',NULL),(13,'Roe','2017-08-14','jane.roe@gmail.com','','Jane',NULL),(14,'Doe','2017-08-15','richard.doe@gmail.com','','Richard',NULL),(15,'Doe','2017-08-16','janie.doe@gmail.com','','Janie',NULL),(16,'Webb','2017-08-17','phillip.webb@gmail.com','','Phillip',NULL),(17,'Nicoll','2017-08-18','stephane.nicoll@gmail.com','309aa2ec-ea8a-46cc-b920-c456912bee3b_Leonardo_Diffusion_XL_Give_me_an_80_creative_20_simple_image_f_1.jpg','Stephane',NULL),(18,'Brannen','2017-08-19','sam.brannen@gmail.com','','Sam',NULL),(19,'Hoeller','2017-08-20','juergen.Hoeller@gmail.com','','Juergen',NULL),(20,'Roe','2017-08-21','janie.roe@gmail.com','','Janie',NULL),(21,'Smith','2017-08-22','john.smith@gmail.com','','John',NULL),(22,'Bloggs','2017-08-23','joe.bloggs@gmail.com','','Joe',NULL),(23,'Stiles','2017-08-24','john.stiles@gmail.com','','John',NULL),(24,'Roe','2017-08-25','stiles.roe@gmail.com','','Richard',NULL),(25,'Perez','2024-10-11','maria@example.com','4f5f75d1-560c-45ec-9973-fb0334b346ec_46a59977f84a3615b2ccdee1a05fef2b.jpg','Maria Garcia','El Triunfo Zona B Mz B lt 8, La Joya');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` date DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `observacion` varchar(255) DEFAULT NULL,
  `cliente_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1qiuk10rfkovhlfpsk7oic0v8` (`cliente_id`),
  CONSTRAINT `FK1qiuk10rfkovhlfpsk7oic0v8` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (3,'2024-04-30','Compras de Oficina ','Es una compra',1),(4,'2024-04-30','Compras de Oficina ','Compras 2 de la anterior compra',2),(5,'2024-05-03','Compras de Oficina ','Ninguna',2),(7,'2024-05-11','Compras de Oficina ','Ninguna',1),(8,'2024-05-11','Compras de Oficina ','Ninguna',1),(9,'2024-05-11','Compras de Oficina ','Ninguna',1),(10,'2024-05-11','Compras de Oficina ','Ninguna',1),(11,'2024-05-11','Compras de Oficina ','Ninguna',4),(12,'2024-05-11','Compras de Oficina ','Quiero un producto mas a la moda ',13),(13,'2024-05-11','Compras de Oficina ','Ninguna',1);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas_items`
--

DROP TABLE IF EXISTS `facturas_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas_items` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `producto_id` bigint DEFAULT NULL,
  `factura_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdumnm9x14hjfp9fufn7q8389r` (`producto_id`),
  KEY `FKnv8ijya20df661b0p6drqcx7u` (`factura_id`),
  CONSTRAINT `FKdumnm9x14hjfp9fufn7q8389r` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`),
  CONSTRAINT `FKnv8ijya20df661b0p6drqcx7u` FOREIGN KEY (`factura_id`) REFERENCES `facturas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas_items`
--

LOCK TABLES `facturas_items` WRITE;
/*!40000 ALTER TABLE `facturas_items` DISABLE KEYS */;
INSERT INTO `facturas_items` VALUES (6,2,1,3),(7,2,1,4),(8,1,1,5),(29,103,1,7),(30,30,1,8),(31,5,2,9),(32,2,2,10),(33,1,11,11),(34,5,4,12),(35,1,2,13);
/*!40000 ALTER TABLE `facturas_items` ENABLE KEYS */;
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
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `actualizar_stock_despues_insert` AFTER INSERT ON `facturas_items` FOR EACH ROW BEGIN
    -- Declarar variables locales
    DECLARE cantidad_producto INT;
    DECLARE stock_actual INT;

    -- Obtener la cantidad del producto y su stock actual utilizando una consulta
    SELECT productos.stock - NEW.cantidad INTO stock_actual
    FROM productos
    WHERE productos.id = NEW.producto_id;

    -- Actualizar el stock del producto
    UPDATE productos
    SET stock = stock_actual
    WHERE id = NEW.producto_id;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'0',
  `stock` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'2024-04-29','Panasonic Pantalla LCD',780.6,_binary '',0),(2,'2024-04-29','Sony Camara digital DSC-W320B',1460,_binary '',4),(3,'2025-04-28','Apple iPod shuffle',698.4,_binary '\0',13),(4,'2024-04-29','Sony Notebook Z110',3780.8,_binary '',7),(5,'2024-04-29','Hewlett Packard Multifuncional F2280',1200.2,_binary '',14),(6,'2024-04-29','Bianchi Bicicleta Aro 26',1525.9,_binary '',10),(7,'2024-04-29','Mica Comoda 5 Cajones',59.6,_binary '',12),(11,'2024-05-11',' Bateria Portatil 130 52000mAH',150,_binary '\0',29);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `nombre` varchar(300) NOT NULL,
  `apellido` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'gabriel','$2a$10$sEi1xze6u8SCG9il518WDuJzJ/sZayjFkKdtE3XXo3Ljntifj83BK',_binary '','Gabriel ','Machicao Quispe'),(2,'admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',_binary '','Marco Aedo','Perez Suarez'),(3,'mila123','$2a$10$506B2sEdkbfB.xEfBfCYnOwbMFzP.sI2xlbUkG.pRtn1JEG/4kP6m',_binary '','Milagros','Machicao'),(4,'mia123','$2a$10$hi1u8yCj3Q6CYIt4CixgJeJ.yCCUsRBkh6kukTnLdm4Rq8Br8GMcu',_binary '','Mia','Machicao'),(5,'ariam','$2a$10$1buTur7gUUjBWuEiFN4KpOeL6J1rfHC15rWoW32lZsVVQ4AHCMNqe',_binary '','Ariana','Machicao'),(6,'Gua','$2a$10$D/JNLFha2/MCwz.ciaszTepdZXuqQhW8utr7vVyHG8gjsmR1GM4XW',_binary '','Guadalupe','Machicao'),(7,'irma','$2a$10$5gPqFyKmXNdP0SYYbyWqDO6/GNX6AdxbGE2aGWsaApbaVIe3clWvu',_binary '','Irma','Machicao'),(8,'juan','$2a$10$UPfcVmHgnYsEq1SZMo7ATus8fKc1CmeH2aeyl5xCxLfyCMgdpu6qu',_binary '','Gustavo','Machicao');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_proyecto'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-11 22:19:45
