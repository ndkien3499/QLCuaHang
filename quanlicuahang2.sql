-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quanlicuahang2
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ngayxuat` date DEFAULT NULL,
  `khachhang_id` int DEFAULT NULL,
  `nv_banhang_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa6vb7kwsuhyjr6p87p6a10vwa` (`khachhang_id`),
  KEY `FKrgddi61q321myl20ncdan5o4m` (`nv_banhang_id`),
  CONSTRAINT `FKa6vb7kwsuhyjr6p87p6a10vwa` FOREIGN KEY (`khachhang_id`) REFERENCES `khachhang` (`id`),
  CONSTRAINT `FKrgddi61q321myl20ncdan5o4m` FOREIGN KEY (`nv_banhang_id`) REFERENCES `nvbanhang` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (1,'2022-04-27',1,1),(2,'2022-04-28',1,1),(3,'2022-04-28',2,1),(4,'2022-04-28',2,2);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `diachi` varchar(255) DEFAULT NULL,
  `dt` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `loaithe` varchar(255) DEFAULT NULL,
  `sothe` varchar(255) DEFAULT NULL,
  `tenkh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'Hà Nội','032165498','hung@gmail.com','Agribank','123567','Hùng'),(2,'Thái Bình','026543129','mai@gmail.com','TechcomBank','3265987','Mai');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mathang`
--

DROP TABLE IF EXISTS `mathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mathang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `giatien` int NOT NULL,
  `hansd` varchar(255) DEFAULT NULL,
  `loaimh` varchar(255) DEFAULT NULL,
  `ngaynhap` date DEFAULT NULL,
  `soluong` int NOT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `quanli_thanhvien_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo9nymnvt7i3fbks709k2of9n` (`quanli_thanhvien_id`),
  CONSTRAINT `FKo9nymnvt7i3fbks709k2of9n` FOREIGN KEY (`quanli_thanhvien_id`) REFERENCES `quanli` (`thanhvien_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mathang`
--

LOCK TABLES `mathang` WRITE;
/*!40000 ALTER TABLE `mathang` DISABLE KEYS */;
INSERT INTO `mathang` VALUES (1,200000,'3','Áo','2022-04-27',100,'Áo Hoody Đen',1),(2,300000,'3','Quần','2022-04-27',200,'Quần Baggy Jean',1),(3,100000,'2','Mũ','2022-04-27',100,'Mũ Lưỡi Trai Đen',1);
/*!40000 ALTER TABLE `mathang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mathang_hoadon`
--

DROP TABLE IF EXISTS `mathang_hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mathang_hoadon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `soluong` int NOT NULL,
  `hoadon_id` int DEFAULT NULL,
  `mathang_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8tnqj5ot17usyooxlfiqxur78` (`hoadon_id`),
  KEY `FK11srphbujnvpbfuc8arxry3no` (`mathang_id`),
  CONSTRAINT `FK11srphbujnvpbfuc8arxry3no` FOREIGN KEY (`mathang_id`) REFERENCES `mathang` (`id`),
  CONSTRAINT `FK8tnqj5ot17usyooxlfiqxur78` FOREIGN KEY (`hoadon_id`) REFERENCES `hoadon` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mathang_hoadon`
--

LOCK TABLES `mathang_hoadon` WRITE;
/*!40000 ALTER TABLE `mathang_hoadon` DISABLE KEYS */;
INSERT INTO `mathang_hoadon` VALUES (1,2,1,1),(2,2,1,2),(3,1,1,3),(4,1,2,1),(5,1,2,2),(6,1,2,3),(7,1,3,1),(8,1,4,2);
/*!40000 ALTER TABLE `mathang_hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nvbanhang`
--

DROP TABLE IF EXISTS `nvbanhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nvbanhang` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `quanli_thanhvien_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf20xh7l1b6v86r6gju27xbv2v` (`quanli_thanhvien_id`),
  CONSTRAINT `FKf20xh7l1b6v86r6gju27xbv2v` FOREIGN KEY (`quanli_thanhvien_id`) REFERENCES `quanli` (`thanhvien_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nvbanhang`
--

LOCK TABLES `nvbanhang` WRITE;
/*!40000 ALTER TABLE `nvbanhang` DISABLE KEYS */;
INSERT INTO `nvbanhang` VALUES (1,'2000-03-03','hoalt@gmail.com','0123456','Hoa',1),(2,'2000-03-06','linhnk@gmail.com','0321654987','Linh',1),(3,'2000-06-06','trang@gmail.com','03215847','Trang',1),(4,'2000-10-10','lan@gmail.com','0654321','Lan',2),(5,'2000-12-12','chi@gmail.com','0326541902','Chi',2),(7,'2022-05-02','mailt@gmail.com','0326541902','Mai',1);
/*!40000 ALTER TABLE `nvbanhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quanli`
--

DROP TABLE IF EXISTS `quanli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quanli` (
  `thanhvien_id` int NOT NULL,
  PRIMARY KEY (`thanhvien_id`),
  CONSTRAINT `FKfddvffo7y7oyuo6wxcijvr9nq` FOREIGN KEY (`thanhvien_id`) REFERENCES `thanhvien` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quanli`
--

LOCK TABLES `quanli` WRITE;
/*!40000 ALTER TABLE `quanli` DISABLE KEYS */;
INSERT INTO `quanli` VALUES (1),(2);
/*!40000 ALTER TABLE `quanli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thanhvien`
--

DROP TABLE IF EXISTS `thanhvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thanhvien` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `vaitro` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thanhvien`
--

LOCK TABLES `thanhvien` WRITE;
/*!40000 ALTER TABLE `thanhvien` DISABLE KEYS */;
INSERT INTO `thanhvien` VALUES (1,'1999-03-04','Hà Nội','kiennd@gmail.com','123456','123456789','Kiên','kiennd','quản lí'),(2,'2000-02-02','Hà Nội','huy@gmail.com','123456','123654987','Huy','huyld','quản lí'),(3,'2000-03-03','Hà Nội','minh@gmail.com','123456','123654789','Minh','minhbc','quản lí'),(4,'2022-05-01','Hà Nội','kien@gmail.com','123','321654987','Kiên','admin','quản lí');
/*!40000 ALTER TABLE `thanhvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-03 20:59:22
