CREATE DATABASE  IF NOT EXISTS `customer`;
USE `customer`;

--
-- Table structure for table `customers`
--
DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `cust_id` int NOT NULL AUTO_INCREMENT,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `cust_name` varchar(100) DEFAULT NULL,
  `cust_address` bigint(200) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

