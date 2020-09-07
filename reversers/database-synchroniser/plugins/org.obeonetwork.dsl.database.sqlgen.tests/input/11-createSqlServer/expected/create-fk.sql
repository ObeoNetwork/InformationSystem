-- ==============================================================
--  Foreign Key : FK_CustomerCustomerDemo                                    
-- ==============================================================
ALTER TABLE DBO.CUSTOMERCUSTOMERDEMO 
	ADD CONSTRAINT FK_CustomerCustomerDemo FOREIGN KEY(CustomerTypeID) 
	REFERENCES DBO.CUSTOMERDEMOGRAPHICS(CustomerTypeID);

-- ==============================================================
--  Foreign Key : FK_CustomerCustomerDemo_Customers                                    
-- ==============================================================
ALTER TABLE DBO.CUSTOMERCUSTOMERDEMO 
	ADD CONSTRAINT FK_CustomerCustomerDemo_Customers FOREIGN KEY(CustomerID) 
	REFERENCES DBO.CUSTOMERS(CustomerID);

-- ==============================================================
--  Foreign Key : FK_EmployeeTerritories_Employees                                    
-- ==============================================================
ALTER TABLE DBO.EMPLOYEETERRITORIES 
	ADD CONSTRAINT FK_EmployeeTerritories_Employees FOREIGN KEY(EmployeeID) 
	REFERENCES DBO.EMPLOYEES(EmployeeID);

-- ==============================================================
--  Foreign Key : FK_EmployeeTerritories_Territories                                    
-- ==============================================================
ALTER TABLE DBO.EMPLOYEETERRITORIES 
	ADD CONSTRAINT FK_EmployeeTerritories_Territories FOREIGN KEY(TerritoryID) 
	REFERENCES DBO.TERRITORIES(TerritoryID);

-- ==============================================================
--  Foreign Key : FK_Employees_Employees                                    
-- ==============================================================
ALTER TABLE DBO.EMPLOYEES 
	ADD CONSTRAINT FK_Employees_Employees FOREIGN KEY(ReportsTo) 
	REFERENCES DBO.EMPLOYEES(EmployeeID);

-- ==============================================================
--  Foreign Key : FK_Order_Details_Orders                                    
-- ==============================================================
ALTER TABLE DBO.ORDER DETAILS 
	ADD CONSTRAINT FK_Order_Details_Orders FOREIGN KEY(OrderID) 
	REFERENCES DBO.ORDERS(OrderID);

-- ==============================================================
--  Foreign Key : FK_Order_Details_Products                                    
-- ==============================================================
ALTER TABLE DBO.ORDER DETAILS 
	ADD CONSTRAINT FK_Order_Details_Products FOREIGN KEY(ProductID) 
	REFERENCES DBO.PRODUCTS(ProductID);

-- ==============================================================
--  Foreign Key : FK_Orders_Customers                                    
-- ==============================================================
ALTER TABLE DBO.ORDERS 
	ADD CONSTRAINT FK_Orders_Customers FOREIGN KEY(CustomerID) 
	REFERENCES DBO.CUSTOMERS(CustomerID);

-- ==============================================================
--  Foreign Key : FK_Orders_Employees                                    
-- ==============================================================
ALTER TABLE DBO.ORDERS 
	ADD CONSTRAINT FK_Orders_Employees FOREIGN KEY(EmployeeID) 
	REFERENCES DBO.EMPLOYEES(EmployeeID);

-- ==============================================================
--  Foreign Key : FK_Orders_Shippers                                    
-- ==============================================================
ALTER TABLE DBO.ORDERS 
	ADD CONSTRAINT FK_Orders_Shippers FOREIGN KEY(ShipVia) 
	REFERENCES DBO.SHIPPERS(ShipperID);

-- ==============================================================
--  Foreign Key : FK_Products_Categories                                    
-- ==============================================================
ALTER TABLE DBO.PRODUCTS 
	ADD CONSTRAINT FK_Products_Categories FOREIGN KEY(CategoryID) 
	REFERENCES DBO.CATEGORIES(CategoryID);

-- ==============================================================
--  Foreign Key : FK_Products_Suppliers                                    
-- ==============================================================
ALTER TABLE DBO.PRODUCTS 
	ADD CONSTRAINT FK_Products_Suppliers FOREIGN KEY(SupplierID) 
	REFERENCES DBO.SUPPLIERS(SupplierID);

-- ==============================================================
--  Foreign Key : FK_Territories_Region                                    
-- ==============================================================
ALTER TABLE DBO.TERRITORIES 
	ADD CONSTRAINT FK_Territories_Region FOREIGN KEY(RegionID) 
	REFERENCES DBO.REGION(RegionID);

