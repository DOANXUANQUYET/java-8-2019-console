CREATE DATABASE  IF NOT EXISTS `doanxuanquyetjspservlet82019` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `doanxuanquyetjspservlet82019`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: doanxuanquyetjspservlet82019
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assignmentstaff`
--

DROP TABLE IF EXISTS `assignmentstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assignmentstaff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `buildingid` bigint(20) NOT NULL,
  `staffid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_assignment_building` (`buildingid`),
  KEY `fk_assignment_staff_idx` (`staffid`),
  CONSTRAINT `fk_assignment_building` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`),
  CONSTRAINT `fk_assignment_staff` FOREIGN KEY (`staffid`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentstaff`
--

LOCK TABLES `assignmentstaff` WRITE;
/*!40000 ALTER TABLE `assignmentstaff` DISABLE KEYS */;
INSERT INTO `assignmentstaff` VALUES (1,1,2,NULL,NULL,NULL,NULL),(2,3,2,NULL,NULL,NULL,NULL),(3,1,3,NULL,NULL,NULL,NULL),(4,4,3,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `assignmentstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assinmentcustomer`
--

DROP TABLE IF EXISTS `assinmentcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `assinmentcustomer` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `customerid` bigint(100) NOT NULL,
  `staffid` bigint(100) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerfk_idx` (`customerid`),
  CONSTRAINT `customerfk` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assinmentcustomer`
--

LOCK TABLES `assinmentcustomer` WRITE;
/*!40000 ALTER TABLE `assinmentcustomer` DISABLE KEYS */;
INSERT INTO `assinmentcustomer` VALUES (1,4,2,NULL,NULL,NULL,NULL),(2,2,2,NULL,NULL,NULL,NULL),(3,1,3,NULL,NULL,NULL,NULL),(4,3,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `assinmentcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `building` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `numberofbasement` int(11) DEFAULT NULL,
  `buildingarea` int(11) DEFAULT NULL,
  `district` varchar(100) DEFAULT NULL,
  `ward` varchar(100) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `structure` varchar(100) DEFAULT NULL,
  `costrent` int(11) DEFAULT NULL,
  `costdescription` text,
  `servicecost` varchar(255) DEFAULT NULL,
  `carcost` varchar(255) DEFAULT NULL,
  `motorbikecost` varchar(255) DEFAULT NULL,
  `overtimecost` varchar(255) DEFAULT NULL,
  `electricitycost` varchar(255) DEFAULT NULL,
  `deposit` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `timerent` varchar(255) DEFAULT NULL,
  `timedecorator` varchar(255) DEFAULT NULL,
  `managername` varchar(255) DEFAULT NULL,
  `managerphone` varchar(255) DEFAULT NULL,
  `type` text,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,'FCL Buiding',2,500,'QUAN_1','Phường 2','59 Pham Xích Long',NULL,15,'15 triệu/m2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Hùng','012345678','TANG_TRET,NGUYEN_CAN',NULL,NULL,NULL,NULL),(2,'ACM Tower',2,650,'QUAN_2','Phường 4','96 Cao Thắng',NULL,18,'18 triệu/m2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Cường','012345678','NGUYEN_CAN',NULL,NULL,NULL,NULL),(3,'Alpha 2 Building',1,200,'QUAN_3','Phường 6','153 Nguyễn Đình Chiểu',NULL,20,'20 triệu/m2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Huy','012345678','TANG_TRET,NGUYEN_CAN,NOI_THAT',NULL,NULL,NULL,NULL),(4,'IDD 1 Building',1,200,'QUAN_4','Phường 7','111 Lý Chính Thắng',NULL,12,'12 triệu/m2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Vy','012345678','NOI_THAT',NULL,NULL,NULL,NULL),(5,'VINACONEXT',1,150,'QUAN_3','Phường 10','134/1 Cách Mạng Tháng 8',NULL,1000,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Mai','012345678','NGUYEN_CAN,NOI_THAT','2019-08-22 10:34:09',NULL,NULL,NULL),(10,'vincom center danang',NULL,NULL,'QUAN_5','bac',' 910A Ngô Quyền',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NGUYEN_CAN,NOI_THAT','2019-10-20 19:44:09',NULL,'quyet dep trai',NULL),(11,'doan xuan quyet 123789',NULL,NULL,'QUAN_6','bac','208 hai ba trung',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TANG_TRET,NGUYEN_CAN,NOI_THAT','2019-10-27 23:46:56','2019-10-29 00:31:25','quyet dep trai','quyet dep trai part 2'),(12,'vincom center quyet dep trai 123',NULL,NULL,'QUAN_4','bac',' 910A Ngô Quyền',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NGUYEN_CAN,NOI_THAT','2019-10-29 00:28:11',NULL,'quyet dep trai',NULL),(13,'building 123 quyet test 3456',5,900,'QUAN_3',NULL,'hoang hoa tham','',50,NULL,'400',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'tung lam nguyen','0904567984','TANG_TRET,NGUYEN_CAN,NOI_THAT','2019-11-12 01:26:51',NULL,'quyet dep trai',NULL);
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customername` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `request` text,
  `createddate` datetime DEFAULT NULL,
  `createdby` varchar(100) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'truong van lam','0961234789','truongvanlam@gmail.com','tìm biệt thự 1000m2 cho vơ 2',NULL,NULL,NULL,NULL,1),(2,'vu van canh','0934234974','canhkute@gmail.com','nhà mặt phố, 300m2 ở hà nội',NULL,NULL,NULL,NULL,1),(3,'hoang van tinh','0953451263','tinhdonphuong@gmail.com','nhà 5 lầu, 6 phòng wc, có gara xe hơi',NULL,NULL,NULL,NULL,1),(4,'pham van dat','0985789346','datkhongsung@gmail.com','nhà 800m2 có bể bơi, sân gôn',NULL,NULL,NULL,NULL,1),(7,'quyet 123789','09061000000','doanquyet@gmail.com',NULL,'2019-10-29 00:32:03','quyet dep trai','2019-10-29 00:42:59','quyet dep trai part 2',1);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentarea`
--

DROP TABLE IF EXISTS `rentarea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rentarea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `value` int(11) NOT NULL,
  `buildingid` bigint(20) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rentarea_building` (`buildingid`),
  CONSTRAINT `fk_rentarea_building` FOREIGN KEY (`buildingid`) REFERENCES `building` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentarea`
--

LOCK TABLES `rentarea` WRITE;
/*!40000 ALTER TABLE `rentarea` DISABLE KEYS */;
INSERT INTO `rentarea` VALUES (1,100,1,NULL,NULL,NULL,NULL),(2,200,1,NULL,NULL,NULL,NULL),(3,200,2,NULL,NULL,NULL,NULL),(4,300,2,NULL,NULL,NULL,NULL),(5,400,2,NULL,NULL,NULL,NULL),(6,300,3,NULL,NULL,NULL,NULL),(7,400,3,NULL,NULL,NULL,NULL),(8,500,3,NULL,NULL,NULL,NULL),(9,100,4,NULL,NULL,NULL,NULL),(10,400,4,NULL,NULL,NULL,NULL),(11,250,4,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `rentarea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Quản lý','MANAGER',NULL,NULL,NULL,NULL),(2,'Nhân viên','STAFF',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `staffname` varchar(100) NOT NULL,
  `position` varchar(100) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'Trương Văn Lâm','Nhân viên',NULL,NULL,NULL,NULL),(2,'Văn Quyết','Nhân viên',NULL,NULL,NULL,NULL),(3,'Hoàng Thị Thu','Nhân viên',NULL,NULL,NULL,NULL),(4,'Trần Văn Cảnh','Nhân viên',NULL,NULL,NULL,NULL),(5,'Lương Văn Khoa','Nhân viên',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `fullname` varchar(150) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `createdby` varchar(255) DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'NguyenDucCanh','123456','Nguyễn Đức Cảnh',1,NULL,NULL,NULL,NULL),(2,'MaiDinhChi','123456','Mai Đinh Chi',1,NULL,NULL,NULL,NULL),(3,'NguyenAnhVan','123456','Nguyễn Anh Văn',1,NULL,NULL,NULL,NULL),(4,'CaoThaiSon','123456','Cao Thái Sơn',1,NULL,NULL,NULL,NULL),(5,'Quyet dep trai','128977','quyet 12345',1,'2019-10-29 01:18:56',NULL,'quyet dep trai',NULL),(6,'Quyet dep trai 02','128977',NULL,1,'2019-10-29 01:19:36',NULL,'quyet dep trai',NULL),(7,'Quyet tot bung 3332','128977','quy111112222',1,'2019-10-29 01:20:48','2019-10-29 01:23:25','quyet dep trai','quyet dep trai part 2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleid` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userrole_role` (`roleid`),
  KEY `fk_userrole_user` (`userid`),
  CONSTRAINT `fk_userrole_role` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_userrole_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,2,2),(3,2,3),(4,2,4);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-13  7:01:52
