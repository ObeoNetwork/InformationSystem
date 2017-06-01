-- ==============================================================
--  Foreign Key : FK_CustomerCustomerDemo                                    
-- ==============================================================
ALTER TABLE CUSTOMERCUSTOMERDEMO 
	ADD CONSTRAINT FK_CustomerCustomerDemo FOREIGN KEY(CustomerTypeID) 
	REFERENCES CUSTOMERDEMOGRAPHICS(CustomerTypeID);

-- ==============================================================
--  Foreign Key : FK_CustomerCustomerDemo_Customers                                    
-- ==============================================================
ALTER TABLE CUSTOMERCUSTOMERDEMO 
	ADD CONSTRAINT FK_CustomerCustomerDemo_Customers FOREIGN KEY(CustomerID) 
	REFERENCES CUSTOMERS(CustomerID);

-- ==============================================================
--  Foreign Key : FK_EmployeeTerritories_Employees                                    
-- ==============================================================
ALTER TABLE EMPLOYEETERRITORIES 
	ADD CONSTRAINT FK_EmployeeTerritories_Employees FOREIGN KEY(EmployeeID) 
	REFERENCES EMPLOYEES(EmployeeID);

-- ==============================================================
--  Foreign Key : FK_EmployeeTerritories_Territories                                    
-- ==============================================================
ALTER TABLE EMPLOYEETERRITORIES 
	ADD CONSTRAINT FK_EmployeeTerritories_Territories FOREIGN KEY(TerritoryID) 
	REFERENCES TERRITORIES(TerritoryID);

-- ==============================================================
--  Foreign Key : FK_Employees_Employees                                    
-- ==============================================================
ALTER TABLE EMPLOYEES 
	ADD CONSTRAINT FK_Employees_Employees FOREIGN KEY(ReportsTo) 
	REFERENCES EMPLOYEES(EmployeeID);

-- ==============================================================
--  Foreign Key : FK_Order_Details_Orders                                    
-- ==============================================================
ALTER TABLE ORDER DETAILS 
	ADD CONSTRAINT FK_Order_Details_Orders FOREIGN KEY(OrderID) 
	REFERENCES ORDERS(OrderID);

-- ==============================================================
--  Foreign Key : FK_Order_Details_Products                                    
-- ==============================================================
ALTER TABLE ORDER DETAILS 
	ADD CONSTRAINT FK_Order_Details_Products FOREIGN KEY(ProductID) 
	REFERENCES PRODUCTS(ProductID);

-- ==============================================================
--  Foreign Key : FK_Orders_Customers                                    
-- ==============================================================
ALTER TABLE ORDERS 
	ADD CONSTRAINT FK_Orders_Customers FOREIGN KEY(CustomerID) 
	REFERENCES CUSTOMERS(CustomerID);

-- ==============================================================
--  Foreign Key : FK_Orders_Employees                                    
-- ==============================================================
ALTER TABLE ORDERS 
	ADD CONSTRAINT FK_Orders_Employees FOREIGN KEY(EmployeeID) 
	REFERENCES EMPLOYEES(EmployeeID);

-- ==============================================================
--  Foreign Key : FK_Orders_Shippers                                    
-- ==============================================================
ALTER TABLE ORDERS 
	ADD CONSTRAINT FK_Orders_Shippers FOREIGN KEY(ShipVia) 
	REFERENCES SHIPPERS(ShipperID);

-- ==============================================================
--  Foreign Key : FK_Products_Categories                                    
-- ==============================================================
ALTER TABLE PRODUCTS 
	ADD CONSTRAINT FK_Products_Categories FOREIGN KEY(CategoryID) 
	REFERENCES CATEGORIES(CategoryID);

-- ==============================================================
--  Foreign Key : FK_Products_Suppliers                                    
-- ==============================================================
ALTER TABLE PRODUCTS 
	ADD CONSTRAINT FK_Products_Suppliers FOREIGN KEY(SupplierID) 
	REFERENCES SUPPLIERS(SupplierID);

-- ==============================================================
--  Foreign Key : FK_Territories_Region                                    
-- ==============================================================
ALTER TABLE TERRITORIES 
	ADD CONSTRAINT FK_Territories_Region FOREIGN KEY(RegionID) 
	REFERENCES REGION(RegionID);

