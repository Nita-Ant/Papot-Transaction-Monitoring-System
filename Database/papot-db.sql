-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: papot-db
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` varchar(11) NOT NULL COMMENT 'Product type and respective number for each product.',
  `product_name` char(30) NOT NULL COMMENT 'Product type and product’s full name.',
  `product_description` mediumtext NOT NULL COMMENT 'Full and descriptive details of the product.',
  `product_type` enum('Bundle_SoftToys','Bundle_HardToys','Solo_HardToys','Solo_SoftToys') NOT NULL COMMENT 'The first part would be Bundle  or  Solo  to  be followed by SoftToys or HardToys. ',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('BLHT0001','BNDLHT_Pooh Baymax Snoopy','Baymax, Pooh Outline,Pooh,Tigger Keychain Snoopy Bundle','Bundle_HardToys'),('BLHT0002','BNDLHT_Pooh Daisy MyMelody','Pooh Head & Platform, Daisy & Platform, My Melody Bundle','Bundle_HardToys'),('BLHT0003','BNDLHT_Yokai Pooh Frozen','Yokai Pen, Pooh Pumpkin, Daisy & Daisy Platform, Frozen Tin Can Bundle','Bundle_HardToys'),('BLST0001','BNDLST_Pooh Jibang','5 Jibang & 3 pooh stuffed toys ','Bundle_SoftToys'),('SLHT0001','SLHT_Doorables','Disney Doorables','Solo_HardToys'),('SLST0001','SLST_Pooh w/ patch','Stuffed Toy of Pooh with Patch','Solo_SoftToys'),('SLST0002','SLST_Winking Chef Pooh','Stuffed toy Winking Pooh holding a Tomato','Solo_SoftToys'),('SLST0003','SLST_PompompurinRed','Pompompurin in red paw suit ','Solo_SoftToys'),('SLST0004','SLST_PompompurinDown','Pompompurin with green hat lying down','Solo_SoftToys'),('SLST0005','SLST_PompompurinRare','Pompompurin in green suit & black hat','Solo_SoftToys'),('SLST0006','SLST_Santa Rilakkuma','Rilakkuma in a santa hat and red cape','Solo_SoftToys'),('SLST0007','SLST_Sailor Korilakkuma','Korilakkuma in a Sailor ','Solo_SoftToys'),('SLST0008','SLST_Shiro','White stuffed toy of Shiro','Solo_SoftToys'),('SLST0009','SLST_EeyoreDown','Mid-Size Eeyore Lying Down ','Solo_SoftToys'),('SLST0010','SLST_PoohFurry','Mid-Size Furry Pooh','Solo_SoftToys'),('SLST0011','SLST_WoodStock','Mid-Size WoodStock','Solo_SoftToys'),('SLST0012','SLST_Usahana','Usahana with flowers on hat','Solo_SoftToys');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `supplier_id` varchar(20) NOT NULL COMMENT 'Abbreviated form  of  the  supplier’s name.',
  `supplier_name` char(30) NOT NULL COMMENT 'Full name of the supplier.  ',
  `supplier_address` mediumtext NOT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('LVANK','Love Anik','23 Kalachuchi, Taguig'),('MCSCRNR','MCS Corner','Hulo, Mandaluyong'),('MM','Meg Morata','Sierra Homes, Antipolo'),('MRKTPLC_MARIE','Chloei Marie','88 Calcite St., Twin River Subdivision, Parang, Marikina'),('SYM','Say Mine','San Pedro-Laguna, Pacita Complex 1'),('TTW','Toys To The World','Imus, Cavite');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplycostprice`
--

DROP TABLE IF EXISTS `supplycostprice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplycostprice` (
  `transaction_no` varchar(9) NOT NULL COMMENT 'Year and respective number (incremented)  that  is dependent to the previous entry.',
  `product_id` varchar(11) NOT NULL COMMENT 'Product type and respective number for each product.',
  `product_qty` int NOT NULL COMMENT 'quantity of the product ordered by the shop to the supplier. ',
  `unit_price` float(13,2) NOT NULL COMMENT 'Price  set by the supplier to the certain product.',
  `total_prod_price` float(13,2) NOT NULL COMMENT 'Derived from the product of unit_price and product_qty.',
  PRIMARY KEY (`transaction_no`,`product_id`),
  KEY `product_id_idx` (`product_id`),
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplycostprice`
--

LOCK TABLES `supplycostprice` WRITE;
/*!40000 ALTER TABLE `supplycostprice` DISABLE KEYS */;
INSERT INTO `supplycostprice` VALUES ('2021-0001','BLST0001',1,500.00,500.00),('2021-0002','BLHT0001',1,240.00,240.00),('2021-0002','BLHT0002',1,270.00,270.00),('2021-0002','BLHT0003',1,130.00,130.00),('2021-0003','SLHT0001',54,30.00,1620.00),('2021-0004','BLHT0001',1,300.00,300.00),('2021-0004','BLST0001',1,350.00,350.00),('2021-0004','SLST0001',2,180.00,360.00),('2021-0004','SLST0002',4,140.00,560.00),('2021-0004','SLST0003',2,100.00,200.00),('2021-0005','SLST0003',1,100.00,100.00),('2021-0005','SLST0004',3,120.00,360.00),('2021-0005','SLST0005',1,50.00,50.00),('2021-0005','SLST0006',1,120.00,120.00),('2021-0005','SLST0007',1,120.00,120.00),('2021-0005','SLST0008',2,60.00,120.00),('2021-0005','SLST0009',1,180.00,180.00),('2021-0006','SLST0001',4,150.00,600.00),('2021-0006','SLST0003',5,80.00,400.00),('2021-0006','SLST0010',1,180.00,180.00),('2021-0006','SLST0011',6,180.00,1080.00),('2021-0006','SLST0012',1,100.00,100.00);
/*!40000 ALTER TABLE `supplycostprice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_no` varchar(9) NOT NULL COMMENT 'referenced to transaction_no in supplycostprice',
  `order_date` date NOT NULL COMMENT 'Date of order',
  `supplier_id` varchar(20) NOT NULL COMMENT 'referenced to supplier id in supplier table',
  `mode_of_delivery` char(15) DEFAULT NULL COMMENT 'Name of the courier service for the transaction order ',
  `order_status` enum('1','0') NOT NULL COMMENT '0 for not-yet-received status and 1 for on- hand status.  ',
  `date_received` date DEFAULT NULL COMMENT 'Date when the ordered was received. Date will also \nautomatically register as soon as the order status’s value become 1 (on-hand status).',
  `subtotal` float(13,2) NOT NULL COMMENT 'Derived from  the  sum  of  all total_prod_price under one transaction',
  `ship_fee` float(10,2) DEFAULT NULL COMMENT 'Fee provided  the  courier service.',
  `grand_total` float(13,2) DEFAULT NULL COMMENT 'Derived from the sum of subtotal and ship_fee. ',
  PRIMARY KEY (`transaction_no`),
  KEY `Supplier_id_idx` (`supplier_id`),
  CONSTRAINT `Supplier_id` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Transaction_no` FOREIGN KEY (`transaction_no`) REFERENCES `supplycostprice` (`transaction_no`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES ('2021-0001','2021-03-10','SYM','J&T Express','1','2021-03-21',500.00,195.00,695.00),('2021-0002','2021-03-16','LVANK','Lalamove','1','2021-03-19',640.00,126.00,766.00),('2021-0003','2021-03-20','MRKTPLC_MARIE','Grab Delivery','1','2021-03-21',1620.00,159.00,1779.00),('2021-0004','2021-03-30','MCSCRNR','J&T Express','0',NULL,1770.00,0.00,NULL),('2021-0005','2021-04-04','MM','Lalamove','0',NULL,1050.00,NULL,NULL),('2021-0006','2021-04-06','TTW','Lalamove','1','2021-04-14',2360.00,120.00,2480.00);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-18 23:57:31
