-- ==============================================================
--  Index : CategoryName                                    
-- ==============================================================
CREATE INDEX CategoryName ON DBO.CATEGORIES(CategoryName)
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
CREATE UNIQUE INDEX PK_Categories ON DBO.CATEGORIES(CategoryID)
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
CREATE UNIQUE INDEX PK_CustomerCustomerDemo ON DBO.CUSTOMERCUSTOMERDEMO(CustomerID, CustomerTypeID)
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
CREATE UNIQUE INDEX PK_CustomerDemographics ON DBO.CUSTOMERDEMOGRAPHICS(CustomerTypeID)
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
CREATE INDEX City ON DBO.CUSTOMERS(City)
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
CREATE INDEX CompanyName ON DBO.CUSTOMERS(CompanyName)
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
CREATE UNIQUE INDEX PK_Customers ON DBO.CUSTOMERS(CustomerID)
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
CREATE INDEX PostalCode ON DBO.CUSTOMERS(PostalCode)
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
CREATE INDEX Region ON DBO.CUSTOMERS(Region)
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
CREATE UNIQUE INDEX PK_EmployeeTerritories ON DBO.EMPLOYEETERRITORIES(EmployeeID, TerritoryID)
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
CREATE INDEX LastName ON DBO.EMPLOYEES(LastName)
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
CREATE UNIQUE INDEX PK_Employees ON DBO.EMPLOYEES(EmployeeID)
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
CREATE INDEX PostalCode ON DBO.EMPLOYEES(PostalCode)
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
CREATE UNIQUE INDEX PK_Order_Details ON DBO.ORDER DETAILS(OrderID, ProductID)
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
CREATE INDEX OrderDate ON DBO.ORDERS(OrderDate)
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
CREATE UNIQUE INDEX PK_Orders ON DBO.ORDERS(OrderID)
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
CREATE INDEX ShipPostalCode ON DBO.ORDERS(ShipPostalCode)
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
CREATE INDEX ShippedDate ON DBO.ORDERS(ShippedDate)
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
CREATE UNIQUE INDEX PK_Products ON DBO.PRODUCTS(ProductID)
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
CREATE INDEX ProductName ON DBO.PRODUCTS(ProductName)
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
CREATE UNIQUE INDEX PK_Region ON DBO.REGION(RegionID)
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
CREATE UNIQUE INDEX PK_Shippers ON DBO.SHIPPERS(ShipperID)
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
CREATE INDEX CompanyName ON DBO.SUPPLIERS(CompanyName)
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
CREATE UNIQUE INDEX PK_Suppliers ON DBO.SUPPLIERS(SupplierID)
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
CREATE INDEX PostalCode ON DBO.SUPPLIERS(PostalCode)
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
CREATE UNIQUE INDEX PK_Territories ON DBO.TERRITORIES(TerritoryID)
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

