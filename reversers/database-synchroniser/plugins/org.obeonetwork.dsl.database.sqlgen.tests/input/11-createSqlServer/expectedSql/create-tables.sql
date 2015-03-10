-- ==============================================================
--  Table : CATEGORIES                                    
-- ==============================================================


DROP TABLE CATEGORIES;
CREATE TABLE CATEGORIES(
    CategoryID int IDENTITY (1, 1) NOT NULL,
    CategoryName nvarchar(15) NOT NULL,
    Description ntext NULL,
    Picture image NULL
)
;

-- ==============================================================
--  Table : CUSTOMERCUSTOMERDEMO                                    
-- ==============================================================


DROP TABLE CUSTOMERCUSTOMERDEMO;
CREATE TABLE CUSTOMERCUSTOMERDEMO(
    CustomerID nchar(5) NOT NULL,
    CustomerTypeID nchar(10) NOT NULL
)
;

-- ==============================================================
--  Table : CUSTOMERDEMOGRAPHICS                                    
-- ==============================================================


DROP TABLE CUSTOMERDEMOGRAPHICS;
CREATE TABLE CUSTOMERDEMOGRAPHICS(
    CustomerTypeID nchar(10) NOT NULL,
    CustomerDesc ntext NULL
)
;

-- ==============================================================
--  Table : CUSTOMERS                                    
-- ==============================================================


DROP TABLE CUSTOMERS;
CREATE TABLE CUSTOMERS(
    CustomerID nchar(5) NOT NULL,
    CompanyName nvarchar(40) NOT NULL,
    ContactName nvarchar(30) NULL,
    ContactTitle nvarchar(30) NULL,
    Address nvarchar(60) NULL,
    City nvarchar(15) NULL,
    Region nvarchar(15) NULL,
    PostalCode nvarchar(10) NULL,
    Country nvarchar(15) NULL,
    Phone nvarchar(24) NULL,
    Fax nvarchar(24) NULL
)
;

-- ==============================================================
--  Table : EMPLOYEES                                    
-- ==============================================================


DROP TABLE EMPLOYEES;
CREATE TABLE EMPLOYEES(
    EmployeeID int IDENTITY (1, 1) NOT NULL,
    LastName nvarchar(20) NOT NULL,
    FirstName nvarchar(10) NOT NULL,
    Title nvarchar(30) NULL,
    TitleOfCourtesy nvarchar(25) NULL,
    BirthDate datetime NULL,
    HireDate datetime NULL,
    Address nvarchar(60) NULL,
    City nvarchar(15) NULL,
    Region nvarchar(15) NULL,
    PostalCode nvarchar(10) NULL,
    Country nvarchar(15) NULL,
    HomePhone nvarchar(24) NULL,
    Extension nvarchar(4) NULL,
    Photo image NULL,
    Notes ntext NULL,
    ReportsTo int NULL,
    PhotoPath nvarchar(255) NULL
)
;

-- ==============================================================
--  Table : EMPLOYEETERRITORIES                                    
-- ==============================================================


DROP TABLE EMPLOYEETERRITORIES;
CREATE TABLE EMPLOYEETERRITORIES(
    EmployeeID int NOT NULL,
    TerritoryID nvarchar(20) NOT NULL
)
;

-- ==============================================================
--  Table : ORDER DETAILS                                    
-- ==============================================================


DROP TABLE ORDER DETAILS;
CREATE TABLE ORDER DETAILS(
    OrderID int NOT NULL,
    ProductID int NOT NULL,
    UnitPrice money default (0) NOT NULL,
    Quantity smallint default (1) NOT NULL,
    Discount real default (0) NOT NULL
)
;

-- ==============================================================
--  Table : ORDERS                                    
-- ==============================================================


DROP TABLE ORDERS;
CREATE TABLE ORDERS(
    OrderID int IDENTITY (1, 1) NOT NULL,
    CustomerID nchar(5) NULL,
    EmployeeID int NULL,
    OrderDate datetime NULL,
    RequiredDate datetime NULL,
    ShippedDate datetime NULL,
    ShipVia int NULL,
    Freight money default (0) NULL,
    ShipName nvarchar(40) NULL,
    ShipAddress nvarchar(60) NULL,
    ShipCity nvarchar(15) NULL,
    ShipRegion nvarchar(15) NULL,
    ShipPostalCode nvarchar(10) NULL,
    ShipCountry nvarchar(15) NULL
)
;

-- ==============================================================
--  Table : PRODUCTS                                    
-- ==============================================================


DROP TABLE PRODUCTS;
CREATE TABLE PRODUCTS(
    ProductID int IDENTITY (1, 1) NOT NULL,
    ProductName nvarchar(40) NOT NULL,
    SupplierID int NULL,
    CategoryID int NULL,
    QuantityPerUnit nvarchar(20) NULL,
    UnitPrice money default (0) NULL,
    UnitsInStock smallint default (0) NULL,
    UnitsOnOrder smallint default (0) NULL,
    ReorderLevel smallint default (0) NULL,
    Discontinued bit default (0) NOT NULL
)
;

-- ==============================================================
--  Table : REGION                                    
-- ==============================================================


DROP TABLE REGION;
CREATE TABLE REGION(
    RegionID int NOT NULL,
    RegionDescription nchar(50) NOT NULL
)
;

-- ==============================================================
--  Table : SHIPPERS                                    
-- ==============================================================


DROP TABLE SHIPPERS;
CREATE TABLE SHIPPERS(
    ShipperID int IDENTITY (1, 1) NOT NULL,
    CompanyName nvarchar(40) NOT NULL,
    Phone nvarchar(24) NULL
)
;

-- ==============================================================
--  Table : SUPPLIERS                                    
-- ==============================================================


DROP TABLE SUPPLIERS;
CREATE TABLE SUPPLIERS(
    SupplierID int IDENTITY (1, 1) NOT NULL,
    CompanyName nvarchar(40) NOT NULL,
    ContactName nvarchar(30) NULL,
    ContactTitle nvarchar(30) NULL,
    Address nvarchar(60) NULL,
    City nvarchar(15) NULL,
    Region nvarchar(15) NULL,
    PostalCode nvarchar(10) NULL,
    Country nvarchar(15) NULL,
    Phone nvarchar(24) NULL,
    Fax nvarchar(24) NULL,
    HomePage ntext NULL
)
;

-- ==============================================================
--  Table : TERRITORIES                                    
-- ==============================================================


DROP TABLE TERRITORIES;
CREATE TABLE TERRITORIES(
    TerritoryID nvarchar(20) NOT NULL,
    TerritoryDescription nchar(50) NOT NULL,
    RegionID int NOT NULL
)
;

