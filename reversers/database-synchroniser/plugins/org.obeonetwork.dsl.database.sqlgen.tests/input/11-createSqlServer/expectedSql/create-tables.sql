-- ==============================================================
--  Table : CATEGORIES                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.CATEGORIES;
CREATE TABLE DBO.CATEGORIES(
    CategoryID int(10) IDENTITY (1, 1) NOT NULL,
    CategoryName nvarchar(15) NOT NULL,
    Description ntext NULL,
    Picture image NULL
);

-- ==============================================================
--  Table : CUSTOMERCUSTOMERDEMO                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.CUSTOMERCUSTOMERDEMO;
CREATE TABLE DBO.CUSTOMERCUSTOMERDEMO(
    CustomerID nchar(5) NOT NULL,
    CustomerTypeID nchar(10) NOT NULL
);

-- ==============================================================
--  Table : CUSTOMERDEMOGRAPHICS                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.CUSTOMERDEMOGRAPHICS;
CREATE TABLE DBO.CUSTOMERDEMOGRAPHICS(
    CustomerTypeID nchar(10) NOT NULL,
    CustomerDesc ntext NULL
);

-- ==============================================================
--  Table : CUSTOMERS                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.CUSTOMERS;
CREATE TABLE DBO.CUSTOMERS(
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
);

-- ==============================================================
--  Table : EMPLOYEETERRITORIES                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.EMPLOYEETERRITORIES;
CREATE TABLE DBO.EMPLOYEETERRITORIES(
    EmployeeID int(10) NOT NULL,
    TerritoryID nvarchar(20) NOT NULL
);

-- ==============================================================
--  Table : EMPLOYEES                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.EMPLOYEES;
CREATE TABLE DBO.EMPLOYEES(
    EmployeeID int(10) IDENTITY (1, 1) NOT NULL,
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
    ReportsTo int(10) NULL,
    PhotoPath nvarchar(255) NULL
);

-- ==============================================================
--  Table : ORDER DETAILS                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.ORDER DETAILS;
CREATE TABLE DBO.ORDER DETAILS(
    OrderID int(10) NOT NULL,
    ProductID int(10) NOT NULL,
    UnitPrice money DEFAULT (0) NOT NULL,
    Quantity smallint DEFAULT (1) NOT NULL,
    Discount real DEFAULT (0) NOT NULL
);

-- ==============================================================
--  Table : ORDERS                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.ORDERS;
CREATE TABLE DBO.ORDERS(
    OrderID int(10) IDENTITY (1, 1) NOT NULL,
    CustomerID nchar(5) NULL,
    EmployeeID int(10) NULL,
    OrderDate datetime NULL,
    RequiredDate datetime NULL,
    ShippedDate datetime NULL,
    ShipVia int(10) NULL,
    Freight money DEFAULT (0) NULL,
    ShipName nvarchar(40) NULL,
    ShipAddress nvarchar(60) NULL,
    ShipCity nvarchar(15) NULL,
    ShipRegion nvarchar(15) NULL,
    ShipPostalCode nvarchar(10) NULL,
    ShipCountry nvarchar(15) NULL
);

-- ==============================================================
--  Table : PRODUCTS                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.PRODUCTS;
CREATE TABLE DBO.PRODUCTS(
    ProductID int(10) IDENTITY (1, 1) NOT NULL,
    ProductName nvarchar(40) NOT NULL,
    SupplierID int(10) NULL,
    CategoryID int(10) NULL,
    QuantityPerUnit nvarchar(20) NULL,
    UnitPrice money DEFAULT (0) NULL,
    UnitsInStock smallint DEFAULT (0) NULL,
    UnitsOnOrder smallint DEFAULT (0) NULL,
    ReorderLevel smallint DEFAULT (0) NULL,
    Discontinued bit DEFAULT (0) NOT NULL
);

-- ==============================================================
--  Table : REGION                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.REGION;
CREATE TABLE DBO.REGION(
    RegionID int(10) NOT NULL,
    RegionDescription nchar(50) NOT NULL
);

-- ==============================================================
--  Table : SHIPPERS                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.SHIPPERS;
CREATE TABLE DBO.SHIPPERS(
    ShipperID int(10) IDENTITY (1, 1) NOT NULL,
    CompanyName nvarchar(40) NOT NULL,
    Phone nvarchar(24) NULL
);

-- ==============================================================
--  Table : SUPPLIERS                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.SUPPLIERS;
CREATE TABLE DBO.SUPPLIERS(
    SupplierID int(10) IDENTITY (1, 1) NOT NULL,
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
);

-- ==============================================================
--  Table : TERRITORIES                                    
-- ==============================================================

DROP TABLE IF EXISTS DBO.TERRITORIES;
CREATE TABLE DBO.TERRITORIES(
    TerritoryID nvarchar(20) NOT NULL,
    TerritoryDescription nchar(50) NOT NULL,
    RegionID int(10) NOT NULL
);

