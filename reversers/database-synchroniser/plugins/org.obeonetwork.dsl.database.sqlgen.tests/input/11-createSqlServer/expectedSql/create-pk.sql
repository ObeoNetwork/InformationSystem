-- ==============================================================
--  Primary Key : PK_Categories                                    
-- ==============================================================
CREATE UNIQUE INDEX Categories_PK1_1 ON DBO.CATEGORIES(CategoryID);
ALTER TABLE DBO.CATEGORIES ADD CONSTRAINT Categories_PK1_1 PRIMARY KEY(CategoryID);

-- ==============================================================
--  Primary Key : PK_CustomerCustomerDemo                                    
-- ==============================================================
CREATE UNIQUE INDEX CustomerCustomerDemo_PK1_1 ON DBO.CUSTOMERCUSTOMERDEMO(CustomerID, CustomerTypeID);
ALTER TABLE DBO.CUSTOMERCUSTOMERDEMO ADD CONSTRAINT CustomerCustomerDemo_PK1_1 PRIMARY KEY(CustomerID, CustomerTypeID);

-- ==============================================================
--  Primary Key : PK_CustomerDemographics                                    
-- ==============================================================
CREATE UNIQUE INDEX CustomerDemographics_PK1_1 ON DBO.CUSTOMERDEMOGRAPHICS(CustomerTypeID);
ALTER TABLE DBO.CUSTOMERDEMOGRAPHICS ADD CONSTRAINT CustomerDemographics_PK1_1 PRIMARY KEY(CustomerTypeID);

-- ==============================================================
--  Primary Key : PK_Customers                                    
-- ==============================================================
CREATE UNIQUE INDEX Customers_PK1_1 ON DBO.CUSTOMERS(CustomerID);
ALTER TABLE DBO.CUSTOMERS ADD CONSTRAINT Customers_PK1_1 PRIMARY KEY(CustomerID);

-- ==============================================================
--  Primary Key : PK_EmployeeTerritories                                    
-- ==============================================================
CREATE UNIQUE INDEX EmployeeTerritories_PK1_1 ON DBO.EMPLOYEETERRITORIES(EmployeeID, TerritoryID);
ALTER TABLE DBO.EMPLOYEETERRITORIES ADD CONSTRAINT EmployeeTerritories_PK1_1 PRIMARY KEY(EmployeeID, TerritoryID);

-- ==============================================================
--  Primary Key : PK_Employees                                    
-- ==============================================================
CREATE UNIQUE INDEX Employees_PK1_1 ON DBO.EMPLOYEES(EmployeeID);
ALTER TABLE DBO.EMPLOYEES ADD CONSTRAINT Employees_PK1_1 PRIMARY KEY(EmployeeID);

-- ==============================================================
--  Primary Key : PK_Order_Details                                    
-- ==============================================================
CREATE UNIQUE INDEX Order Details_PK1_1 ON DBO.ORDER DETAILS(OrderID, ProductID);
ALTER TABLE DBO.ORDER DETAILS ADD CONSTRAINT Order Details_PK1_1 PRIMARY KEY(OrderID, ProductID);

-- ==============================================================
--  Primary Key : PK_Orders                                    
-- ==============================================================
CREATE UNIQUE INDEX Orders_PK1_1 ON DBO.ORDERS(OrderID);
ALTER TABLE DBO.ORDERS ADD CONSTRAINT Orders_PK1_1 PRIMARY KEY(OrderID);

-- ==============================================================
--  Primary Key : PK_Products                                    
-- ==============================================================
CREATE UNIQUE INDEX Products_PK1_1 ON DBO.PRODUCTS(ProductID);
ALTER TABLE DBO.PRODUCTS ADD CONSTRAINT Products_PK1_1 PRIMARY KEY(ProductID);

-- ==============================================================
--  Primary Key : PK_Region                                    
-- ==============================================================
CREATE UNIQUE INDEX Region_PK1_1 ON DBO.REGION(RegionID);
ALTER TABLE DBO.REGION ADD CONSTRAINT Region_PK1_1 PRIMARY KEY(RegionID);

-- ==============================================================
--  Primary Key : PK_Shippers                                    
-- ==============================================================
CREATE UNIQUE INDEX Shippers_PK1_1 ON DBO.SHIPPERS(ShipperID);
ALTER TABLE DBO.SHIPPERS ADD CONSTRAINT Shippers_PK1_1 PRIMARY KEY(ShipperID);

-- ==============================================================
--  Primary Key : PK_Suppliers                                    
-- ==============================================================
CREATE UNIQUE INDEX Suppliers_PK1_1 ON DBO.SUPPLIERS(SupplierID);
ALTER TABLE DBO.SUPPLIERS ADD CONSTRAINT Suppliers_PK1_1 PRIMARY KEY(SupplierID);

-- ==============================================================
--  Primary Key : PK_Territories                                    
-- ==============================================================
CREATE UNIQUE INDEX Territories_PK1_1 ON DBO.TERRITORIES(TerritoryID);
ALTER TABLE DBO.TERRITORIES ADD CONSTRAINT Territories_PK1_1 PRIMARY KEY(TerritoryID);

