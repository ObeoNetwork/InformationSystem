/*
SQLyog Community Edition- MySQL GUI v7.02 
MySQL - 5.0.51b-community-nt : Database - northwind
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`northwind` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `northwind`;

/*Table structure for table `Categories` */

DROP TABLE IF EXISTS `Categories`;

CREATE TABLE `Categories` (
  `CategoryID` int(11) NOT NULL auto_increment,
  `CategoryName` varchar(15) NOT NULL,
  `Description` longtext,
  `Picture` longblob,
  PRIMARY KEY  (`CategoryID`),
  KEY `CategoryName` (`CategoryName`)
) ENGINE=INNODB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `Customercustomerdemo` */

DROP TABLE IF EXISTS `Customercustomerdemo`;

CREATE TABLE `Customercustomerdemo` (
  `CustomerID` char(5) NOT NULL,
  `CustomerTypeID` char(10) NOT NULL,
  PRIMARY KEY  (`CustomerID`,`CustomerTypeID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


/*Table structure for table `Customerdemographics` */

DROP TABLE IF EXISTS `Customerdemographics`;

CREATE TABLE `Customerdemographics` (
  `CustomerTypeID` char(10) NOT NULL,
  `CustomerDesc` longtext,
  PRIMARY KEY  (`CustomerTypeID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


/*Table structure for table `Customers` */

DROP TABLE IF EXISTS `Customers`;

CREATE TABLE `Customers` (
  `CustomerID` char(5) NOT NULL,
  `CompanyName` varchar(40) NOT NULL,
  `ContactName` varchar(30) default NULL,
  `ContactTitle` varchar(30) default NULL,
  `Address` varchar(60) default NULL,
  `City` varchar(15) default NULL,
  `Region` varchar(15) default NULL,
  `PostalCode` varchar(10) default NULL,
  `Country` varchar(15) default NULL,
  `Phone` varchar(24) default NULL,
  `Fax` varchar(24) default NULL,
  PRIMARY KEY  (`CustomerID`),
  KEY `City` (`City`),
  KEY `CompanyName` (`CompanyName`),
  KEY `PostalCode` (`PostalCode`),
  KEY `Region` (`Region`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `Employees` */

DROP TABLE IF EXISTS `Employees`;

CREATE TABLE `Employees` (
  `EmployeeID` int(11) NOT NULL auto_increment,
  `LastName` varchar(20) NOT NULL,
  `FirstName` varchar(10) NOT NULL,
  `Title` varchar(30) default NULL,
  `TitleOfCourtesy` varchar(25) default NULL,
  `BirthDate` datetime default NULL,
  `HireDate` datetime default NULL,
  `Address` varchar(60) default NULL,
  `City` varchar(15) default NULL,
  `Region` varchar(15) default NULL,
  `PostalCode` varchar(10) default NULL,
  `Country` varchar(15) default NULL,
  `HomePhone` varchar(24) default NULL,
  `Extension` varchar(4) default NULL,
  `Photo` longblob,
  `Notes` longtext,
  `ReportsTo` int(11) default NULL,
  `PhotoPath` varchar(255) default NULL,
  PRIMARY KEY  (`EmployeeID`),
  KEY `IX_Employees_LastName` (`LastName`),
  KEY `IX_Employees_PostalCode` (`PostalCode`)
) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

Alter Table Employees
		Add (CONSTRAINT FK_Employees_Employees FOREIGN KEY (ReportsTo) REFERENCES Employees (EmployeeID)); 

/*Table structure for table `EmployeeTerritories` */

DROP TABLE IF EXISTS `EmployeeTerritories`;

CREATE TABLE `EmployeeTerritories` (
  `EmployeeID` int(11) NOT NULL,
  `TerritoryID` varchar(20) NOT NULL,
  PRIMARY KEY  (`EmployeeID`,`TerritoryID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


/*Table structure for table `Order_details` */

DROP TABLE IF EXISTS `Order_details`;

CREATE TABLE `Order_details` (
  `OrderID` int(11) NOT NULL,
  `ProductID` int(11) NOT NULL,
  `UnitPrice` decimal(12,2) NOT NULL,
  `Quantity` smallint(6) default 1,
  `Discount` float default 0,
  PRIMARY KEY  (`OrderID`,`ProductID`),
  KEY `OrderID` (`OrderID`),
  KEY `OrdersOrder_details` (`OrderID`),
  KEY `ProductID` (`ProductID`),
  KEY `ProductsOrder_details` (`ProductID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `Orders` */

DROP TABLE IF EXISTS `Orders`;

CREATE TABLE `Orders` (
  `OrderID` int(11) NOT NULL auto_increment,
  `CustomerID` char(5) default NULL,
  `EmployeeID` int(11) default NULL,
  `OrderDate` datetime default NULL,
  `RequiredDate` datetime default NULL,
  `ShippedDate` datetime default NULL,
  `ShipVia` int(11) default NULL,
  `Freight` decimal(19,4) default NULL,
  `ShipName` varchar(40) default NULL,
  `ShipAddress` varchar(60) default NULL,
  `ShipCity` varchar(15) default NULL,
  `ShipRegion` varchar(15) default NULL,
  `ShipPostalCode` varchar(10) default NULL,
  `ShipCountry` varchar(15) default NULL,
  PRIMARY KEY  (`OrderID`),
  KEY `CustomerID` (`CustomerID`),
  KEY `CustomersOrders` (`CustomerID`),
  KEY `EmployeeID` (`EmployeeID`),
  KEY `EmployeesOrders` (`EmployeeID`),
  KEY `OrderDate` (`OrderDate`),
  KEY `ShippedDate` (`ShippedDate`),
  KEY `ShippersOrders` (`ShipVia`),
  KEY `ShipPostalCode` (`ShipPostalCode`)
) ENGINE=INNODB AUTO_INCREMENT=11078 DEFAULT CHARSET=utf8;


/*Table structure for table `Products` */

DROP TABLE IF EXISTS `Products`;

CREATE TABLE `Products` (
  `ProductID` int(11) NOT NULL auto_increment,
  `ProductName` varchar(40) NOT NULL,
  `SupplierID` int(11) default NULL,
  `CategoryID` int(11) default NULL,
  `QuantityPerUnit` varchar(20) default NULL,
  `UnitPrice` decimal(19,4) default NULL,
  `UnitsInStock` smallint(6) default NULL,
  `UnitsOnOrder` smallint(6) default NULL,
  `ReorderLevel` smallint(6) default NULL,
  `Discontinued` tinyint(4) NOT NULL,
  PRIMARY KEY  (`ProductID`),
  KEY `CategoriesProducts` (`CategoryID`),
  KEY `CategoryID` (`CategoryID`),
  KEY `ProductName` (`ProductName`),
  KEY `SupplierID` (`SupplierID`),
  KEY `SuppliersProducts` (`SupplierID`)
) ENGINE=INNODB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

/*Table structure for table `Region` */

DROP TABLE IF EXISTS `Region`;

CREATE TABLE `Region` (
  `RegionID` int(11) NOT NULL,
  `RegionDescription` char(50) NOT NULL,
  PRIMARY KEY  (`RegionID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `Shippers` */

DROP TABLE IF EXISTS `Shippers`;

CREATE TABLE `Shippers` (
  `ShipperID` int(11) NOT NULL auto_increment,
  `CompanyName` varchar(40) NOT NULL,
  `Phone` varchar(24) default NULL,
  PRIMARY KEY  (`ShipperID`)
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Table structure for table `Shippers_tmp` */

DROP TABLE IF EXISTS `Shippers_tmp`;

CREATE TABLE `Shippers_tmp` (
  `ShipperID` int(11) NOT NULL auto_increment,
  `CompanyName` varchar(40) NOT NULL,
  `Phone` varchar(24) default NULL,
  PRIMARY KEY  (`ShipperID`)
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Table structure for table `Suppliers` */

DROP TABLE IF EXISTS `Suppliers`;

CREATE TABLE `Suppliers` (
  `SupplierID` int(11) NOT NULL auto_increment,
  `CompanyName` varchar(40) NOT NULL,
  `ContactName` varchar(30) default NULL,
  `ContactTitle` varchar(30) default NULL,
  `Address` varchar(60) default NULL,
  `City` varchar(15) default NULL,
  `Region` varchar(15) default NULL,
  `PostalCode` varchar(10) default NULL,
  `Country` varchar(15) default NULL,
  `Phone` varchar(24) default NULL,
  `Fax` varchar(24) default NULL,
  `HomePage` longtext,
  PRIMARY KEY  (`SupplierID`),
  KEY `CompanyName` (`CompanyName`),
  KEY `PostalCode` (`PostalCode`)
) ENGINE=INNODB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Table structure for table `Territories` */

DROP TABLE IF EXISTS `Territories`;

CREATE TABLE `Territories` (
  `TerritoryID` varchar(20) NOT NULL,
  `TerritoryDescription` char(50) NOT NULL,
  `RegionID` int(11) NOT NULL,
  PRIMARY KEY  (`TerritoryID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `Usstates` */

DROP TABLE IF EXISTS `Usstates`;

CREATE TABLE `Usstates` (
  `StateID` int(11) NOT NULL,
  `StateName` varchar(100) default NULL,
  `StateAbbr` varchar(2) default NULL,
  `StateRegion` varchar(50) default NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
