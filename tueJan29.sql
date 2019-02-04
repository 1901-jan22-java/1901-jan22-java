--SQL Assignment week 2
--Task – Select all records from the Employee table. 
--2.1 SELECT
SELECT * from Employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * from Employee where lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * from Employee where firstname = 'Andrew' AND reportsto IS null;

--2.2 ORDER BY
--Task - Select all albums in Album table and sort result set in descending order by title
SELECT * from album 
order by title DESC; 

--Task - Select first name from Customer and sort result set in ascending order by city
SELECT * from customer
order by city ASC;

--2.3 INSERT INTO
--Task - Insert two new records into Genre table
INSERT INTO Genre (GENREID, NAME)
VALUES(26, 'Horror');
      
INSERT INTO Genre (GENREID, NAME)
VALUES(27, 'Folk');

SELECT * from Genre;

--Task - Insert two new records into Employee table
SELECT * from Employee;
INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES('9', 'Max', 'Mike', 'It Manager', '3', '09-JAN-69', '08-AUG-15', '156 Ave', 'Edmonton', 'AB', 'Canada', 'T5K 2Y7', '+1 (780) 567-9876', '+1 (780) 789-0987', 'mike@tuejan.com'); 

INSERT INTO Employee (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES('10', 'Lily', 'Singh', 'It Staff', '1', '10-FEB-76', '12-NOV-15', '107 2nd street', 'Lethbridge', 'AB', 'Canada', '8Tk 2Y7', '+1 (780) 987-0098', '+1 (780) 098-0021', 'singh@aol.com'); 

--Task - Insert two new records into Customer table
SELECT * from Customer; 
INSERT INTO Customer (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES('60', 'Rosy', 'John', 'Microsoft', '89 Street', 'Queens', 'NY', 'USA', '17049', '+43 01 567389', '+43 01 8759', 'rosy@aol.com','4');

INSERT INTO Customer (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES('61', 'Nila', 'Joe', 'Null', '7th Ave', 'Hartford', 'CT', 'USA', '06101', '+1 860 797389', '+1 860 09789', 'nila@aol.com','6');

--2.4 UPDATE
--Task - Update Aaron Mitchelle in Customer table to Rober Walter
UPDATE Customer
Set FIRSTNAME = 'Rober', LASTNAME = 'Walter'
where customerId = '32'; 

--Task - Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
SELECT * from Artist;
UPDATE Artist
Set NAME = 'CCR' where artistid = '76';

--2.5 LIKE
--Task - Select all invoices with a billing address like "T%"
SELECT * from Invoice where billingaddress like 'T%';

--2.6 BETWEEN
--Task - Select all invoices that have a total between 15 and 50
SELECT * from Invoice where Total Between 15 AND 50; 

--Task - Select all employees hired between 1st of june 2003 and 1st of march 2004
Select * from employee where hiredate between '2003-01-06' AND '2004-01-03';

--2.7 DELETE
--Task - Delete a record in Customer table where the is Robert Walter (There may be constraints that rely on this, find out how to resolve them)
DELETE from customer where FIRSTNAME = 'Robert', LASTNAME = 'Walter'; 

--3.0 SQL Functions
--3.1 System Defined Functions
--Task - Create a function that returns the current time
SELECT CURRENT_TIMESTAMP;

--Task - Create a function that returns the length of a mediatype from the mediatype table
Select * from Mediatype;
SELECT LENGTH(MEDIATYPEID) AS LengthOfId from Mediatype;

--3.2 System Defined Aggregate Functions
--Task - Create a function that returns the average total of all invoices
SELECT * from invoice;
SELECT AVG(Total) from invoice; 

--Task - Create a function that returns the most expensive track
SELECT * from Track;
SELECT Sum(UNITPRICE) from track; 

--3.3 User Defined Functions
--Task - Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT * from invoiceline; 
SELECT AVG(UNITPRICE) from invoiceline;

--3.4 User Defined Table Valued Functions
--Task - Create a function that returns all employees who are born after 1968
SELECT *from employee 
where birthdate > to_date('1968-12-31','yyyy-mm-dd'); 


--4.0 Stored Procedures
--4.1 Basic Stored Procedure
--Task - Create a stored procedure that selects the first and last names of all the employees
CREATE OR REPLACE procedure getAllArtists(
    cursorParam OUT SYS_REFUCURSOR
)
is
begin
    open cursorParam for select firstname 
    lastname from employee;
end;
/

--4.2 Stored Procedure Input Parameters 
--Task - Create a stored procedure that updates the personal info of an employee
SELECT * from Employee;
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE 
(
  EMP_EMPLOYEEID IN NUMBER,
  NEW_LASTNAME IN VARCHAR2,
  NEW_FIRSTNAME IN VARCHAR2,
  NEW_TITLE IN VARCHAR2,
  NEW_REPORTSTO IN NUMBER,
  NEW_BIRTHDATE IN DATE,
  NEW_HIREDATE IN DATE,
  NEW_ADDRESS IN VARCHAR2,
  NEW_CITY IN VARCHAR2,
  NEW_STATE IN VARCHAR2,
  NEW_COUNTRY VARCHAR2,
  NEW_POSTALCODE VARCHAR2,
  NEW_PHONE VARCHAR2,
  NEW_FAX VARCHAR2,
  NEW_EMAIL VARCHAR2
)
AS 
BEGIN
  UPDATE EMPLOYEE
  SET LASTNAME = CASE WHEN NEW_LASTNAME IS NULL THEN LASTNAME ELSE NEW_LASTNAME END,
      FIRSTNAME = CASE WHEN NEW_FIRSTNAME IS NULL THEN FIRSTNAME ELSE NEW_FIRSTNAME END,
      TITLE = NEW_TITLE, REPORTSTO = NEW_REPORTSTO, BIRTHDATE = NEW_BIRTHDATE, HIREDATE = NEW_HIREDATE, ADDRESS = NEW_ADDRESS,
      CITY = NEW_CITY, STATE = NEW_STATE, COUNTRY = NEW_COUNTRY,POSTALCODE = NEW_POSTALCODE,
      PHONE = NEW_PHONE, FAX = NEW_FAX, EMAIL = NEW_EMAIL
WHERE EMPLOYEEID = EMP_EMPLOYEEID;
END UPDATE_EMPLOYEE;

--Task - Create a stored procedure that returns the managers of an employee

--4.3 Stored Procedure Output Parameters
--Task - Create a stored procedure that returns the name and company of a customer
create or replace procedure getCustomerByName(
 a_name OUT VARCHAR2
)
Is --AS or IS
Begin
 Select name INTO a_name
 FROM Customer WHERE customerId = a_id;
END;

/

--5.0 Transactions
--Task - Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them)
DELETE FROM INVOICE WHERE INVOICEID = inv_id;
COMMIT;

--Task - Create a transaction nested within a stored procedure that inserts a new record in the customer table


--6.0 Triggers
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE TRIGGER Employee_trig
AFTER INSERT on Employee
FOR EACH ROW
Begin
    select emp_seq.nextval into :new.employeeId from employee;
END;
/
--Task - Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE TRIGGER Album_trig
AFTER UPDATE on Album
FOR EACH ROW
BEGIN

END;
/
--Task - Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE TRIGGER Customer_trig
AFTER DELETE ON Customer 
FOR EACH ROW
BEGIN


END;
/

--7.0 JOINS
--7.1 INNER
--Task - Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, ORDER.INVOICEID
From Customer
INNER JOIN Order on Customer.CustomerID = Orders.Customer_ID;

--7.2 OUTER
--Task - Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceid and total
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
From Customer
OUTER JOIN 
on Customer.Customer_ID = Invoice.Invoice_ID;

--7.3 RIGHT
--Task - Create a right join that joins album and artist specifying artist name and title
select artist.name, album.title
from artist
RIGHT join album on artist.albumid = album.albumid 
ORDER by artist.artistid;

--7.4 CROSS
--Task - Create a cross join that joins album and artist and sorts by artist name in ascending order
SELECT * from artist.Fristname, artist.Lastname ASC
CROSS JOIN album;

--7.5 SELF
--Task - perfom a self-join on the employee table, joining on the reportsto column
SELECT A.CustomerFirstname AS CustomerFirstname1, B.CustomerFirstname AS CustomerFirstname2, A.Reportsto
FROM Customers A, Customers B
WHERE A.CustomerID <> B.CustomerID
AND A.Reportsto = B.Reportsto
ORDER BY A.Reportsto;

--7.6 Complicated Join Assignment
--Task - Create an inner join betweent all tables in the chinook database


--9.0 Administration
--Task - Create a .bak file for the chinook database