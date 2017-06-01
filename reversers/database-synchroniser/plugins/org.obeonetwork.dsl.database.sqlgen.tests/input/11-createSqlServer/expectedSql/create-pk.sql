-- ==============================================================
--  Primary Key : PK_Categories                                    
-- ==============================================================
CREATE UNIQUE INDEX Categories_PK1_1 ON CATEGORIES(CategoryID);
ALTER TABLE CATEGORIES ADD CONSTRAINT Categories_PK1_1 PRIMARY KEY(CategoryID);

-- ==============================================================
--  Primary Key : PK_CustomerCustomerDemo                                    
-- ==============================================================
CREATE UNIQUE INDEX CustomerCustomerDemo_PK1_1 ON CUSTOMERCUSTOMERDEMO(CustomerID, CustomerTypeID);
ALTER TABLE CUSTOMERCUSTOMERDEMO ADD CONSTRAINT CustomerCustomerDemo_PK1_1 PRIMARY KEY(CustomerID, CustomerTypeID);

-- ==============================================================
--  Primary Key : PK_CustomerDemographics                                    
-- ==============================================================
CREATE UNIQUE INDEX CustomerDemographics_PK1_1 ON CUSTOMERDEMOGRAPHICS(CustomerTypeID);
ALTER TABLE CUSTOMERDEMOGRAPHICS ADD CONSTRAINT CustomerDemographics_PK1_1 PRIMARY KEY(CustomerTypeID);

-- ==============================================================
--  Primary Key : PK_Customers                                    
-- ==============================================================
CREATE UNIQUE INDEX Customers_PK1_1 ON CUSTOMERS(CustomerID);
ALTER TABLE CUSTOMERS ADD CONSTRAINT Customers_PK1_1 PRIMARY KEY(CustomerID);

-- ==============================================================
--  Primary Key : PK_EmployeeTerritories                                    
-- ==============================================================
CREATE UNIQUE INDEX EmployeeTerritories_PK1_1 ON EMPLOYEETERRITORIES(EmployeeID, TerritoryID);
ALTER TABLE EMPLOYEETERRITORIES ADD CONSTRAINT EmployeeTerritories_PK1_1 PRIMARY KEY(EmployeeID, TerritoryID);

-- ==============================================================
--  Primary Key : PK_Employees                                    
-- ==============================================================
CREATE UNIQUE INDEX Employees_PK1_1 ON EMPLOYEES(EmployeeID);
ALTER TABLE EMPLOYEES ADD CONSTRAINT Employees_PK1_1 PRIMARY KEY(EmployeeID);

-- ==============================================================
--  Primary Key : PK_Order_Details                                    
-- ==============================================================
CREATE UNIQUE INDEX Order Details_PK1_1 ON ORDER DETAILS(OrderID, ProductID);
ALTER TABLE ORDER DETAILS ADD CONSTRAINT Order Details_PK1_1 PRIMARY KEY(OrderID, ProductID);

-- ==============================================================
--  Primary Key : PK_Orders                                    
-- ==============================================================
CREATE UNIQUE INDEX Orders_PK1_1 ON ORDERS(OrderID);
ALTER TABLE ORDERS ADD CONSTRAINT Orders_PK1_1 PRIMARY KEY(OrderID);

-- ==============================================================
--  Primary Key : PK_Products                                    
-- ==============================================================
CREATE UNIQUE INDEX Products_PK1_1 ON PRODUCTS(ProductID);
ALTER TABLE PRODUCTS ADD CONSTRAINT Products_PK1_1 PRIMARY KEY(ProductID);

-- ==============================================================
--  Primary Key : PK_Region                                    
-- ==============================================================
CREATE UNIQUE INDEX Region_PK1_1 ON REGION(RegionID);
ALTER TABLE REGION ADD CONSTRAINT Region_PK1_1 PRIMARY KEY(RegionID);

-- ==============================================================
--  Primary Key : PK_Shippers                                    
-- ==============================================================
CREATE UNIQUE INDEX Shippers_PK1_1 ON SHIPPERS(ShipperID);
ALTER TABLE SHIPPERS ADD CONSTRAINT Shippers_PK1_1 PRIMARY KEY(ShipperID);

-- ==============================================================
--  Primary Key : PK_Suppliers                                    
-- ==============================================================
CREATE UNIQUE INDEX Suppliers_PK1_1 ON SUPPLIERS(SupplierID);
ALTER TABLE SUPPLIERS ADD CONSTRAINT Suppliers_PK1_1 PRIMARY KEY(SupplierID);

-- ==============================================================
--  Primary Key : PK_Territories                                    
-- ==============================================================
CREATE UNIQUE INDEX Territories_PK1_1 ON TERRITORIES(TerritoryID);
ALTER TABLE TERRITORIES ADD CONSTRAINT Territories_PK1_1 PRIMARY KEY(TerritoryID);

