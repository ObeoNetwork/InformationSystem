CREATE OR REPLACE TRIGGER Employees_Id
BEFORE INSERT 
ON EMPLOYEES 
REFERENCING NEW AS New OLD AS Old
FOR EACH ROW
DECLARE
tmpVar NUMBER;
BEGIN
   tmpVar := 0;

   SELECT Employees_Seq.NEXTVAL INTO tmpVar FROM dual;
   :NEW.EmployeeId := tmpVar;

END Employees_Id;
/
CREATE OR REPLACE TRIGGER Categories_Id
BEFORE INSERT 
ON Categories
REFERENCING NEW AS New OLD AS Old
FOR EACH ROW
DECLARE
tmpVar NUMBER;
BEGIN
   tmpVar := 0;

   SELECT categories_Seq.NEXTVAL INTO tmpVar FROM dual;
   :NEW.CategoryID := tmpVar;

END Categories_Id;
/

CREATE OR REPLACE TRIGGER Shippers_Id
BEFORE INSERT 
ON Shippers
REFERENCING NEW AS New OLD AS Old
FOR EACH ROW
DECLARE
tmpVar NUMBER;
BEGIN
   tmpVar := 0;

   SELECT Shippers_Seq.NEXTVAL INTO tmpVar FROM dual;
   :NEW.ShipperID := tmpVar;

END Shippers_Id;
/
CREATE OR REPLACE TRIGGER Suppliers_Id
BEFORE INSERT 
ON Suppliers
REFERENCING NEW AS New OLD AS Old
FOR EACH ROW
DECLARE
tmpVar NUMBER;
BEGIN
   tmpVar := 0;

   SELECT Suppliers_Seq.NEXTVAL INTO tmpVar FROM dual;
   :NEW.SupplierID := tmpVar;

END Suppliers_Id;
/
CREATE OR REPLACE TRIGGER Orders_Id
BEFORE INSERT 
ON Orders
REFERENCING NEW AS New OLD AS Old
FOR EACH ROW
DECLARE
tmpVar NUMBER;
BEGIN
   tmpVar := 0;

   SELECT Orders_Seq.NEXTVAL INTO tmpVar FROM dual;
   :NEW.OrderID := tmpVar;

END Orders_Id;
/
CREATE OR REPLACE TRIGGER Products_Id
BEFORE INSERT 
ON Products
REFERENCING NEW AS New OLD AS Old
FOR EACH ROW
DECLARE
tmpVar NUMBER;
BEGIN
   tmpVar := 0;

   SELECT Products_Seq.NEXTVAL INTO tmpVar FROM dual;
   :NEW.ProductID := tmpVar;

END Products_Id;
/