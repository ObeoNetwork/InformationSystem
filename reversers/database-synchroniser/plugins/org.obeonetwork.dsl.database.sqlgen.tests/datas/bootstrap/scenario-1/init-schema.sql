CREATE TABLE Employees (
	EmployeeID integer NOT NULL,
	LastName varchar2 (20) NOT NULL ,
	FirstName varchar2 (10) NOT NULL ,
	Title varchar2 (30) NULL ,
	TitleOfCourtesy varchar2 (25) NULL ,
	BirthDate date NULL ,
	HireDate date NULL ,
	Address varchar2 (60) NULL ,
	City varchar2 (15) NULL ,
	Region varchar2 (15) NULL ,
	PostalCode varchar2 (10) NULL ,
	Country varchar2 (15) NULL ,
	HomePhone varchar2 (24) NULL ,
	Extension varchar2 (4) NULL ,
	Photo blob NULL ,
	Notes clob NULL ,
	ReportsTo integer NULL ,
	PhotoPath varchar2 (255) NULL
	);

	Create Unique Index PK_Employees
		On Employees(EmployeeID);
		
	Alter Table Employees
		Add (Constraint PK_Employees Primary Key(EmployeeID));
		
	Alter Table Employees
		Add (CONSTRAINT FK_Employees_Employees FOREIGN KEY (ReportsTo) REFERENCES Employees (EmployeeID)); 

 	CREATE  INDEX IX_Employees_LastName 
 		ON Employees(LastName);

 	CREATE  INDEX IX_Employees_PostalCode 
 		ON Employees(PostalCode);
 		

CREATE TABLE Categories (
    CategoryID integer NOT NULL,
    CategoryName varchar2 (15) NOT NULL,
    Description varchar(2000) NULL,
    Picture blob
    );
    
	Create Unique Index PK_Categories
		On Categories(CategoryID);
        
    Alter Table Categories
        Add (Constraint PK_Categories Primary Key(CategoryID));
        
    Create Index Categories_CategoryName ON Categories(CategoryName);



CREATE TABLE Customers (
    CustomerID char (5) NOT NULL , -- Sequence
    CompanyName varchar2 (40) NOT NULL ,
    ContactName varchar2 (30) NULL ,
    ContactTitle varchar2 (30) NULL ,
    Address varchar2 (60) NULL ,
    City varchar2 (15) NULL ,
    Region varchar2 (15) NULL ,
    PostalCode varchar2 (10) NULL ,
    Country varchar2 (15) NULL ,
    Phone varchar2 (24) NULL ,
    Fax varchar2 (24) NULL
    );
    
    Create Unique Index PK_Customers
        On Customers(CustomerID);
        
    Alter Table Customers
        Add (Constraint PK_Customers Primary key(CustomerID));
        
    CREATE  INDEX Customers_City ON Customers(City);
 
    CREATE  INDEX Customers_CompanyName ON Customers(CompanyName);

    CREATE  INDEX Customers_PostalCode ON Customers(PostalCode);

    CREATE  INDEX Customers_Region ON Customers(Region);
 
CREATE TABLE Shippers (
	ShipperID Integer NOT NULL ,
	CompanyName varchar2 (40) NOT NULL ,
	Phone varchar2 (24) NULL
    );
    
    Create Unique Index PK_Shippers
        On Shippers(ShipperID);
        
    Alter Table Shippers
        Add (Constraint PK_Shippers Primary Key(ShipperID));
        


CREATE TABLE Suppliers (
    SupplierID integer not null,  --  IDENTITY (1, 1) NOT NULL ,
    CompanyName varchar2 (40) NOT NULL ,
    ContactName varchar2 (30) NULL ,
    ContactTitle varchar2 (30) NULL ,
    Address varchar2 (60) NULL ,
    City varchar2 (15) NULL ,
    Region varchar2 (15) NULL ,
    PostalCode varchar2 (10) NULL ,
    Country varchar2 (15) NULL ,
    Phone varchar2 (24) NULL ,
    Fax varchar2 (24) NULL ,
    HomePage varchar2(2000) NULL
    );
    
    Create Unique Index PK_Suppliers
        On Suppliers(SupplierID);
        
    Alter Table Suppliers
        Add (Constraint PK_Suppliers Primary Key(SupplierID));
  
    CREATE  INDEX Suppliers_CompanyName ON Suppliers(CompanyName);

    CREATE  INDEX Suppliers_PostalCode ON Suppliers(PostalCode) ;    



CREATE TABLE Orders (
    OrderID integer not null, -- IDENTITY (1, 1) NOT NULL ,
    CustomerID char (5) NULL ,
    EmployeeID integer NULL ,
    OrderDate date NULL ,
    RequiredDate date NULL ,
    ShippedDate date NULL ,
    ShipVia integer NULL,
    Freight number(12,2)  Default 0 ,
    ShipName varchar2 (40) NULL ,
    ShipAddress varchar2 (60) NULL ,
    ShipCity varchar2 (15) NULL ,
    ShipRegion varchar2 (15) NULL ,
    ShipPostalCode varchar2 (10) NULL ,
    ShipCountry varchar2 (15) NULL
    );
    
    Create Unique Index PK_Orders
        On Orders(OrderID);
        
    Alter Table Orders
        Add (Constraint PK_Orders Primary Key(OrderID));
        
    Alter Table Orders
        Add (Constraint FK_Orders_Customers Foreign Key (CustomerId) References Customers (CustomerID));
        
    Alter Table Orders
        Add (Constraint FK_Orders_Employees Foreign Key (EmployeeID) References Employees (EmployeeID));        
        
    Alter Table Orders
        Add (Constraint FK_Orders_Shippers Foreign Key (ShipVia) References Shippers (ShipperID));        
        
 CREATE  INDEX Orders_CustomerID ON Orders(CustomerID);

 CREATE  INDEX Orders_EmployeeID ON Orders(EmployeeID);

 CREATE  INDEX Orders_OrderDate ON Orders(OrderDate);

 CREATE  INDEX Orders_ShippedDate ON Orders(ShippedDate);

 CREATE  INDEX Orders_ShippersOrders ON Orders(ShipVia);

 CREATE  INDEX Orders_ShipPostalCode ON Orders(ShipPostalCode);



CREATE TABLE Products (
    ProductID integer not null, -- IDENTITY (1, 1) NOT NULL ,
    ProductName varchar2 (40) NOT NULL ,
    SupplierID integer NULL ,
    CategoryID integer NULL ,
    QuantityPerUnit varchar2 (20) NULL ,
    UnitPrice number(12,2) default 0,
    UnitsInStock smallint DEFAULT 0,
    UnitsOnOrder smallint default 0,
    ReorderLevel smallint default 0,
    Discontinued smallint default 0
    );
    
Create Unique Index PK_Products
    on Products(ProductID);
    
Alter Table Products
    Add (Constraint PK_Products Primary Key(ProductID));
    
Alter Table Products
    Add (Constraint FK_Products_Categories Foreign Key (CategoryID) References Categories(CategoryID));
    
Alter Table Products
    Add (Constraint FK_Products_Suppliers Foreign Key (SupplierID) References Suppliers(SupplierID));
    
Alter Table Products
    Add Check (UnitPrice >=0);
    
Alter Table Products
    Add Check (ReorderLevel >= 0) ;
    
Alter Table Products
    Add Check (UnitsInStock >= 0) ;
    
Alter Table Products
    Add Check (UnitsOnOrder >=0);
                    
Create Index Products_ProductName on Products(ProductName);


CREATE TABLE Order_Details (
    OrderID int NOT NULL ,
    ProductID int NOT NULL ,
    UnitPrice Number(12,2) NOT NULL,
    Quantity smallint default 1,
    Discount real  default 0
    );       
    
Create Unique Index PK_Order_Details
    on Order_Details(OrderID, ProductID);    
    
Alter Table Order_Details
    Add (Constraint PK_Order_Details Primary Key(OrderID, ProductID));
    
Alter Table Order_Details
    Add (Constraint FK_Order_Details_Orders Foreign Key(OrderId) References Orders(OrderID));   
    
Alter Table Order_Details
    Add (Constraint FK_Order_Details_Products Foreign Key(ProductID) References Products(ProductID));    
    
Alter Table Order_Details
    Add Check (Discount >= 0 and (Discount <=1));
    
Alter Table Order_Details
    Add Check (Quantity > 0);
    
Alter Table Order_Details
    Add Check (UnitPrice >= 0);
 
