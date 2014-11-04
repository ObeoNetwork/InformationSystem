/* The following adds stored procedures */

CREATE OR REPLACE Package SouthWind_PKG AS
    Type t_cursor is ref cursor;
Procedure CustOrdersDetail(p_OrderID in integer, io_cursor out t_cursor);
PROCEDURE CustOrdersOrders (p_CustomerID in char, io_cursor out t_cursor);
Procedure CustOrderHist(p_CustomerID char, io_cursor out t_cursor);
Procedure SalesByCategory (p_CategoryName in varchar2, i_OrdYear varchar2 := '1998', io_cursor out t_cursor);
Procedure TenMostExpensiveProducts (io_cursor out t_cursor); 
Procedure EmployeeSalesByCountry (Beginning_Date in date, Ending_date in date, io_cursor out t_cursor);
Procedure SalesByYear (Beginning_Date in  Date, Ending_Date in  Date, io_cursor out t_cursor);
End SouthWind_PKG;
/
CREATE OR REPLACE Package Body SouthWind_PKG AS
Procedure CustOrdersDetail (p_OrderID in integer, io_Cursor out t_cursor)
Is
    v_cursor t_cursor;
Begin
    Open v_cursor For
        SELECT ProductName,
            ROUND(Od.UnitPrice, 2) as UnitPrice,
            Quantity,
            Floor(Discount * 100) as Discount,  
            ROUND((Quantity * (1 - Discount) * Od.UnitPrice), 2) as ExtendedPrice
        FROM Products P, Order_Details Od
        WHERE Od.ProductID = P.ProductID and Od.OrderID = p_OrderID;
        io_cursor := v_cursor;
End CustOrdersDetail;

Procedure CustOrdersOrders (p_CustomerID in char, io_cursor out t_cursor)
Is
    v_cursor t_cursor;
Begin
    Open v_cursor For    
        SELECT OrderID, 
            OrderDate,
            RequiredDate,
            ShippedDate
        FROM Orders
        WHERE CustomerID = p_CustomerID
        ORDER BY OrderID;
    io_cursor := v_cursor;
End CustOrdersOrders;        


Procedure CustOrderHist(p_CustomerID char, io_cursor out t_cursor)
Is
    v_cursor t_cursor;
Begin
    open v_cursor for    
        SELECT ProductName, 
               SUM(Quantity) as Total
        FROM Products P, Order_Details OD, Orders O, Customers C
        WHERE C.CustomerID = p_CustomerID
        AND C.CustomerID = O.CustomerID AND O.OrderID = OD.OrderID AND OD.ProductID = P.ProductID
        GROUP BY ProductName;
    io_cursor := v_cursor;
End CustOrderHist;  

Procedure SalesByCategory 
    (p_CategoryName in varchar2, i_OrdYear varchar2 := '1998', io_cursor out t_cursor)
Is
    v_cursor t_cursor;
    p_OrdYear varchar2(5) := i_OrdYear;
Begin
    If p_OrdYear <> '1996' and p_OrdYear <> '1997' and p_OrdYear <> '1998' Then 
        p_OrdYear := '1998';
    End If;

    Open v_cursor for
        SELECT ProductName,
            ROUND(SUM((OD.Quantity * (1-OD.Discount) * OD.UnitPrice)), 0) as TotalPurchase
        FROM Order_Details OD, Orders O, Products P, Categories C
        WHERE OD.OrderID = O.OrderID 
            AND OD.ProductID = P.ProductID 
            AND P.CategoryID = C.CategoryID
            AND Upper(C.CategoryName) = Upper(p_CategoryName)
            AND TO_CHAR(O.OrderDate, 'YYYY') = p_OrdYear
        GROUP BY ProductName
        ORDER BY ProductName;
       
    io_cursor := v_cursor;    
End SalesByCategory ; 

procedure TenMostExpensiveProducts (io_cursor out t_cursor) 
is
    v_cursor t_cursor;
Begin
    Open v_cursor for
        SELECT Products.ProductName AS TenMostExpensiveProducts, Products.UnitPrice
        FROM Products
        ORDER BY Products.UnitPrice DESC;
    
    io_cursor := v_cursor;
End TenMostExpensiveProducts;    

Procedure EmployeeSalesByCountry (Beginning_Date in date, Ending_date in date, io_cursor out t_cursor)
Is
    v_cursor t_cursor; 
Begin
    Open v_cursor for
        SELECT Employees.Country, Employees.LastName, Employees.FirstName, Orders.ShippedDate, Orders.OrderID, Order_Subtotals.Subtotal AS SaleAmount
        FROM Employees INNER JOIN 
            (Orders INNER JOIN Order_Subtotals ON Orders.OrderID = Order_Subtotals.OrderID) 
            ON Employees.EmployeeID = Orders.EmployeeID
        WHERE Orders.ShippedDate Between Beginning_Date And Ending_Date;
        
        io_cursor := v_cursor;
End EmployeeSalesByCountry ;

Procedure SalesByYear (Beginning_Date in  Date, Ending_Date in  Date, io_cursor out t_cursor)
Is
    v_cursor t_cursor;
Begin
    Open v_cursor for    
        SELECT Orders.ShippedDate, Orders.OrderID, Order_Subtotals.Subtotal, TO_CHAR(ShippedDate, 'YYYY') AS Year
        FROM Orders INNER JOIN Order_Subtotals ON Orders.OrderID = Order_Subtotals.OrderID
        WHERE Orders.ShippedDate Between Beginning_Date And Ending_Date;
     
    io_cursor := v_cursor;
End SalesByYear;                
End SouthWind_PKG;
/

/




/* The follwing adds tables to the Northwind database */


Create Table CustomerCustomerDemo 
	(CustomerID Char (5) NOT NULL,
	CustomerTypeID varchar2 (10) NOT NULL
) ; 


Create Table CustomerDemographics 
	(CustomerTypeID varchar2 (10) NOT NULL ,
	CustomerDesc varchar2(2000) NULL 
)  ; 
	
	
Create Table Region 
	( RegionID integer NOT NULL ,
	RegionDescription varchar2 (50) NOT NULL 
) ;


Create Table Territories 
	(TerritoryID varchar2 (20) NOT NULL ,
	TerritoryDescription varchar2 (50) NOT NULL ,
        RegionID integer NOT NULL
) ;

Create Table EmployeeTerritories 
	(EmployeeID integer NOT NULL,
	TerritoryID varchar2 (20) NOT NULL 
) ;

-- The following adds data to the tables just created.

Insert Into Region Values (1,'Eastern');
Insert Into Region Values (2,'Western');
Insert Into Region Values (3,'Northern');
Insert Into Region Values (4,'Southern');
commit;

Insert Into Territories Values ('01581','Westboro',1);
Insert Into Territories Values ('01730','Bedford',1);
Insert Into Territories Values ('01833','Georgetow',1);
Insert Into Territories Values ('02116','Boston',1);
Insert Into Territories Values ('02139','Cambridge',1);
Insert Into Territories Values ('02184','Braintree',1);
Insert Into Territories Values ('02903','Providence',1);
Insert Into Territories Values ('03049','Hollis',3);
Insert Into Territories Values ('03801','Portsmouth',3);
Insert Into Territories Values ('06897','Wilton',1);
Insert Into Territories Values ('07960','Morristown',1);
Insert Into Territories Values ('08837','Edison',1);
Insert Into Territories Values ('10019','New York',1);
Insert Into Territories Values ('10038','New York',1);
Insert Into Territories Values ('11747','Mellvile',1);
Insert Into Territories Values ('14450','Fairport',1);
Insert Into Territories Values ('19428','Philadelphia',3);
Insert Into Territories Values ('19713','Neward',1);
Insert Into Territories Values ('20852','Rockville',1);
Insert Into Territories Values ('27403','Greensboro',1);
Insert Into Territories Values ('27511','Cary',1);
Insert Into Territories Values ('29202','Columbia',4);
Insert Into Territories Values ('30346','Atlanta',4);
Insert Into Territories Values ('31406','Savannah',4);
Insert Into Territories Values ('32859','Orlando',4);
Insert Into Territories Values ('33607','Tampa',4);
Insert Into Territories Values ('40222','Louisville',1);
Insert Into Territories Values ('44122','Beachwood',3);
Insert Into Territories Values ('45839','Findlay',3);
Insert Into Territories Values ('48075','Southfield',3);
Insert Into Territories Values ('48084','Troy',3);
Insert Into Territories Values ('48304','Bloomfield Hills',3);
Insert Into Territories Values ('53404','Racine',3);
Insert Into Territories Values ('55113','Roseville',3);
Insert Into Territories Values ('55439','Minneapolis',3);
Insert Into Territories Values ('60179','Hoffman Estates',2);
Insert Into Territories Values ('60601','Chicago',2);
Insert Into Territories Values ('72716','Bentonville',4);
Insert Into Territories Values ('75234','Dallas',4);
Insert Into Territories Values ('78759','Austin',4);
Insert Into Territories Values ('80202','Denver',2);
Insert Into Territories Values ('80909','Colorado Springs',2);
Insert Into Territories Values ('85014','Phoenix',2);
Insert Into Territories Values ('85251','Scottsdale',2);
Insert Into Territories Values ('90405','Santa Monica',2);
Insert Into Territories Values ('94025','Menlo Park',2);
Insert Into Territories Values ('94105','San Francisco',2);
Insert Into Territories Values ('95008','Campbell',2);
Insert Into Territories Values ('95054','Santa Clara',2);
Insert Into Territories Values ('95060','Santa Cruz',2);
Insert Into Territories Values ('98004','Bellevue',2);
Insert Into Territories Values ('98052','Redmond',2);
Insert Into Territories Values ('98104','Seattle',2);
commit;

Insert Into EmployeeTerritories Values (1,'06897');
Insert Into EmployeeTerritories Values (1,'19713');
Insert Into EmployeeTerritories Values (2,'01581');
Insert Into EmployeeTerritories Values (2,'01730');
Insert Into EmployeeTerritories Values (2,'01833');
Insert Into EmployeeTerritories Values (2,'02116');
Insert Into EmployeeTerritories Values (2,'02139');
Insert Into EmployeeTerritories Values (2,'02184');
Insert Into EmployeeTerritories Values (2,'40222');
Insert Into EmployeeTerritories Values (3,'30346');
Insert Into EmployeeTerritories Values (3,'31406');
Insert Into EmployeeTerritories Values (3,'32859');
Insert Into EmployeeTerritories Values (3,'33607');
Insert Into EmployeeTerritories Values (4,'20852');
Insert Into EmployeeTerritories Values (4,'27403');
Insert Into EmployeeTerritories Values (4,'27511');
Insert Into EmployeeTerritories Values (5,'02903');
Insert Into EmployeeTerritories Values (5,'07960');
Insert Into EmployeeTerritories Values (5,'08837');
Insert Into EmployeeTerritories Values (5,'10019');
Insert Into EmployeeTerritories Values (5,'10038');
Insert Into EmployeeTerritories Values (5,'11747');
Insert Into EmployeeTerritories Values (5,'14450');
Insert Into EmployeeTerritories Values (6,'85014');
Insert Into EmployeeTerritories Values (6,'85251');
Insert Into EmployeeTerritories Values (6,'98004');
Insert Into EmployeeTerritories Values (6,'98052');
Insert Into EmployeeTerritories Values (6,'98104');
Insert Into EmployeeTerritories Values (7,'60179');
Insert Into EmployeeTerritories Values (7,'60601');
Insert Into EmployeeTerritories Values (7,'80202');
Insert Into EmployeeTerritories Values (7,'80909');
Insert Into EmployeeTerritories Values (7,'90405');
Insert Into EmployeeTerritories Values (7,'94025');
Insert Into EmployeeTerritories Values (7,'94105');
Insert Into EmployeeTerritories Values (7,'95008');
Insert Into EmployeeTerritories Values (7,'95054');
Insert Into EmployeeTerritories Values (7,'95060');
Insert Into EmployeeTerritories Values (8,'19428');
Insert Into EmployeeTerritories Values (8,'44122');
Insert Into EmployeeTerritories Values (8,'45839');
Insert Into EmployeeTerritories Values (8,'53404');
Insert Into EmployeeTerritories Values (9,'03049');
Insert Into EmployeeTerritories Values (9,'03801');
Insert Into EmployeeTerritories Values (9,'48075');
Insert Into EmployeeTerritories Values (9,'48084');
Insert Into EmployeeTerritories Values (9,'48304');
Insert Into EmployeeTerritories Values (9,'55113');
Insert Into EmployeeTerritories Values (9,'55439');
commit;



--  The following adds constraints to the Northwind database

ALTER TABLE CustomerCustomerDemo
	ADD CONSTRAINT PK_CustomerCustomerDemo PRIMARY KEY   
	(
		CustomerID,
		CustomerTypeID
	) ;
commit;

ALTER TABLE CustomerDemographics
	ADD CONSTRAINT PK_CustomerDemographics PRIMARY KEY   
	(
		CustomerTypeID
	) ;
commit;

ALTER TABLE CustomerCustomerDemo
	ADD CONSTRAINT FK_CustomerCustomerDemo FOREIGN KEY 
	(
		CustomerTypeID
	) REFERENCES CustomerDemographics (
		CustomerTypeID
	);
commit;

ALTER TABLE CustomerCustomerDemo
	ADD CONSTRAINT FK_CustomerDemo_Customers FOREIGN KEY
	(
		CustomerID
	) REFERENCES Customers (
		CustomerID
	);
commit;

ALTER TABLE Region
	ADD CONSTRAINT PK_Region Primary KEY   
	(
		RegionID
	)  ; 
commit;

ALTER TABLE Territories
	ADD CONSTRAINT PK_Territories PRIMARY KEY   
	(
		TerritoryID
	)  ; 
commit;

ALTER TABLE Territories
	ADD CONSTRAINT FK_Territories_Region FOREIGN KEY 
	(
		RegionID
	) REFERENCES Region (
		RegionID
	);
commit;

ALTER TABLE EmployeeTerritories
	ADD CONSTRAINT PK_EmployeeTerritories PRIMARY KEY   
	(
		EmployeeID,
		TerritoryID
	) ;
commit;

ALTER TABLE EmployeeTerritories
	ADD CONSTRAINT FK_Territories_Employees FOREIGN KEY 
	(
		EmployeeID
	) REFERENCES Employees (
		EmployeeID
	);
commit;


ALTER TABLE EmployeeTerritories	
	ADD CONSTRAINT FK_Territories_Territories FOREIGN KEY 
	(
		TerritoryID
	) REFERENCES Territories (
		TerritoryID
	);
commit;

CREATE SEQUENCE Employees_Seq
START WITH 10
INCREMENT BY 1
MAXVALUE 999999999999;

CREATE SEQUENCE Categories_SEQ
START WITH 9
INCREMENT BY 1
MAXVALUE 999999999999;


CREATE SEQUENCE Shippers_SEQ
START WITH 4
INCREMENT BY 1
MAXVALUE 999999999999;

CREATE SEQUENCE Suppliers_SEQ
START WITH 30
INCREMENT BY 1
MAXVALUE 999999999999;

CREATE SEQUENCE Orders_SEQ
START WITH 11078
INCREMENT BY 1
MAXVALUE 999999999999;

CREATE SEQUENCE Products_SEQ
START WITH 78
INCREMENT BY 1
MAXVALUE 999999999999;

Commit;