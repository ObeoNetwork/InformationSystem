
Create or Replace View Customer and Suppliers by City AS
SELECT City, CompanyName, ContactName, 'Customers' AS Relationship 
FROM Customers
UNION SELECT City, CompanyName, ContactName, 'Suppliers'
FROM Suppliers
--ORDER BY City, CompanyName


Create or Replace View Alphabetical_list_of_products AS
SELECT Products.*, Categories.CategoryName
FROM Categories INNER JOIN Products ON Categories.CategoryID = Products.CategoryID
WHERE (((Products.Discontinued)=0));


Create or Replace View Current_Product_List AS
SELECT ProductID, ProductName
FROM Products 
WHERE (((Discontinued)=0));
--ORDER BY Product_List.ProductName


Create or Replace View Orders_Qry AS
SELECT Orders.OrderID, Orders.CustomerID, Orders.EmployeeID, Orders.OrderDate, Orders.RequiredDate, 
	Orders.ShippedDate, Orders.ShipVia, Orders.Freight, Orders.ShipName, Orders.ShipAddress, Orders.ShipCity, 
	Orders.ShipRegion, Orders.ShipPostalCode, Orders.ShipCountry, 
	Customers.CompanyName, Customers.Address, Customers.City, Customers.Region, Customers.PostalCode, Customers.Country
FROM Customers INNER JOIN Orders ON Customers.CustomerID = Orders.CustomerID;


Create or Replace View Products_Above_Average_Price AS
SELECT Products.ProductName, Products.UnitPrice
FROM Products
WHERE Products.UnitPrice>(SELECT AVG(UnitPrice) From Products);
--ORDER BY Products.UnitPrice DESC


Create or Replace View Products_By_Category AS
SELECT Categories.CategoryName, Products.ProductName, Products.QuantityPerUnit, Products.UnitsInStock, Products.Discontinued
FROM Categories INNER JOIN Products ON Categories.CategoryID = Products.CategoryID
WHERE Products.Discontinued <> 1;
--ORDER BY Categories.CategoryName, Products.ProductName


Create or Replace View Quarterly_Orders AS
SELECT DISTINCT Customers.CustomerID, Customers.CompanyName, Customers.City, Customers.Country
FROM Customers RIGHT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
WHERE Orders.OrderDate BETWEEN '19970101' And '19971231';


Create or Replace View Invoices AS
SELECT Orders.ShipName, Orders.ShipAddress, Orders.ShipCity, Orders.ShipRegion, Orders.ShipPostalCode, 
    Orders.ShipCountry, Orders.CustomerID, Customers.CompanyName AS CustomerName, Customers.Address, Customers.City, 
    Customers.Region, Customers.PostalCode, Customers.Country, 
    (FirstName || ' ' || LastName) AS Salesperson, 
    Orders.OrderID, Orders.OrderDate, Orders.RequiredDate, Orders.ShippedDate, Shippers.CompanyName As ShipperName, 
    Order_Details.ProductID, Products.ProductName, Order_Details.UnitPrice, Order_Details.Quantity, 
    Order_Details.Discount, 
   (((Order_Details.UnitPrice*Quantity*(1-Discount)/100))*100) AS ExtendedPrice,
    Orders.Freight
FROM     Shippers INNER JOIN 
        (Products INNER JOIN 
            (
                (Employees INNER JOIN 
                    (Customers INNER JOIN Orders ON Customers.CustomerID = Orders.CustomerID) 
                ON Employees.EmployeeID = Orders.EmployeeID) 
            INNER JOIN Order_Details ON Orders.OrderID = Order_Details.OrderID) 
        ON Products.ProductID = Order_Details.ProductID) 
    ON Shippers.ShipperID = Orders.ShipVia;


Create or Replace View Order_Details_Extended AS
SELECT Order_Details.OrderID, Order_Details.ProductID, Products.ProductName, 
    Order_Details.UnitPrice, Order_Details.Quantity, Order_Details.Discount, 
    (((Order_Details.UnitPrice*Quantity*(1-Discount)/100))*100) AS ExtendedPrice
FROM Products INNER JOIN Order_Details ON Products.ProductID = Order_Details.ProductID;
--ORDER BY Order_Details.OrderID


Create or Replace View Order_Subtotals AS
SELECT Order_Details.OrderID, Sum(((Order_Details.UnitPrice*Quantity*(1-Discount)/100))*100) AS Subtotal
FROM Order_Details
GROUP BY Order_Details.OrderID;


Create or Replace View Product_Sales_for_1997 AS
SELECT Categories.CategoryName, Products.ProductName, 
Sum(((Order_Details.UnitPrice*Quantity*(1-Discount)/100))*100) AS ProductSales
FROM (Categories INNER JOIN Products ON Categories.CategoryID = Products.CategoryID) 
    INNER JOIN (Orders 
        INNER JOIN Order_Details ON Orders.OrderID = Order_Details.OrderID) 
    ON Products.ProductID = Order_Details.ProductID
WHERE (((Orders.ShippedDate) Between '19970101' And '19971231'))
GROUP BY Categories.CategoryName, Products.ProductName;


Create or Replace View Category_Sales_for_1997 AS
SELECT Product_Sales_for_1997.CategoryName, Sum(Product_Sales_for_1997.ProductSales) AS CategorySales
FROM Product_Sales_for_1997
GROUP BY Product_Sales_for_1997.CategoryName;


Create or Replace View Sales_by_Category AS
SELECT Categories.CategoryID, Categories.CategoryName, Products.ProductName, 
	Sum(Order_Details_Extended.ExtendedPrice) AS ProductSales
FROM 	Categories INNER JOIN 
		(Products INNER JOIN 
			(Orders INNER JOIN Order_Details_Extended ON Orders.OrderID = Order_Details_Extended.OrderID) 
		ON Products.ProductID = Order_Details_Extended.ProductID) 
	ON Categories.CategoryID = Products.CategoryID
WHERE Orders.OrderDate BETWEEN '19970101' And '19971231'
GROUP BY Categories.CategoryID, Categories.CategoryName, Products.ProductName;
--ORDER BY Products.ProductName


Create or Replace View Sales_Totals_by_Amount AS
SELECT Order_Subtotals.Subtotal AS SaleAmount, Orders.OrderID, Customers.CompanyName, Orders.ShippedDate
FROM 	Customers INNER JOIN 
		(Orders INNER JOIN Order_Subtotals ON Orders.OrderID = Order_Subtotals.OrderID) 
	ON Customers.CustomerID = Orders.CustomerID
WHERE (Order_Subtotals.Subtotal >2500) AND (Orders.ShippedDate BETWEEN '19970101' And '19971231');


Create or Replace View Summary_of_Sales_by_Quarter AS
SELECT Orders.ShippedDate, Orders.OrderID, Order_Subtotals.Subtotal
FROM Orders INNER JOIN Order_Subtotals ON Orders.OrderID = Order_Subtotals.OrderID
WHERE Orders.ShippedDate IS NOT NULL;
--ORDER BY Orders.ShippedDate


Create or Replace View Summary_of_Sales_by_Year AS
SELECT Orders.ShippedDate, Orders.OrderID, Order_Subtotals.Subtotal
FROM Orders INNER JOIN Order_Subtotals ON Orders.OrderID = Order_Subtotals.OrderID
WHERE Orders.ShippedDate IS NOT NULL;
--ORDER BY Orders.ShippedDate
/