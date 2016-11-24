-- ==============================================================
--  Index : CategoryName                                    
-- ==============================================================
CREATE INDEX CategoryName ON CATEGORIES(CategoryName)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_Categories                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_Categories ON CATEGORIES(CategoryID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_CustomerCustomerDemo                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_CustomerCustomerDemo ON CUSTOMERCUSTOMERDEMO(CustomerID, CustomerTypeID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_CustomerDemographics                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_CustomerDemographics ON CUSTOMERDEMOGRAPHICS(CustomerTypeID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : City                                    
-- ==============================================================
CREATE INDEX City ON CUSTOMERS(City)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : CompanyName                                    
-- ==============================================================
CREATE INDEX CompanyName ON CUSTOMERS(CompanyName)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_Customers                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_Customers ON CUSTOMERS(CustomerID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PostalCode                                    
-- ==============================================================
CREATE INDEX PostalCode ON CUSTOMERS(PostalCode)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : Region                                    
-- ==============================================================
CREATE INDEX Region ON CUSTOMERS(Region)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_EmployeeTerritories                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_EmployeeTerritories ON EMPLOYEETERRITORIES(EmployeeID, TerritoryID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : LastName                                    
-- ==============================================================
CREATE INDEX LastName ON EMPLOYEES(LastName)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_Employees                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_Employees ON EMPLOYEES(EmployeeID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PostalCode                                    
-- ==============================================================
CREATE INDEX PostalCode ON EMPLOYEES(PostalCode)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_Order_Details                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_Order_Details ON ORDER DETAILS(OrderID, ProductID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : OrderDate                                    
-- ==============================================================
CREATE INDEX OrderDate ON ORDERS(OrderDate)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_Orders                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_Orders ON ORDERS(OrderID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : ShipPostalCode                                    
-- ==============================================================
CREATE INDEX ShipPostalCode ON ORDERS(ShipPostalCode)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : ShippedDate                                    
-- ==============================================================
CREATE INDEX ShippedDate ON ORDERS(ShippedDate)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_Products                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_Products ON PRODUCTS(ProductID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : ProductName                                    
-- ==============================================================
CREATE INDEX ProductName ON PRODUCTS(ProductName)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_Region                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_Region ON REGION(RegionID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_Shippers                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_Shippers ON SHIPPERS(ShipperID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : CompanyName                                    
-- ==============================================================
CREATE INDEX CompanyName ON SUPPLIERS(CompanyName)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_Suppliers                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_Suppliers ON SUPPLIERS(SupplierID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PostalCode                                    
-- ==============================================================
CREATE INDEX PostalCode ON SUPPLIERS(PostalCode)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

-- ==============================================================
--  Index : PK_Territories                                    
-- ==============================================================
CREATE UNIQUE INDEX PK_Territories ON TERRITORIES(TerritoryID)
  pctfree 10
  pctused 40
  initrans 1
  online
  compute statistics
  tablespace TS_INDEX_DBO
  logging
  nosort
  noparallel
  parallel
  (
       1
  );

