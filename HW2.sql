/* HW2 SQL Daysi Granados
*/
-----2.1 SELECT

--Task select all records from Employee table

SELECT * FROM Employee;

--Task select all records from the Employee table where last name is king

SELECT * FROM Employee WHERE lastname='King';

--Task select all records from the Employee table where first name is Andrew and Reportsto is null

SELECT * from Employee WHERE firstname='Andrew' and reportsto IS NULL;

-----2.2 ORDER BY

--Task select first name from customer and sort result set in ascending order by city

SELECT firstname from Customer ORDER BY city ASC;

--Task select all albums in Album table and sort result set in descending order by title

SELECT * from Album ORDER BY title DESC;

-----2.3 INSERT INTO

--Task insert two new records into genre table

INSERT INTO Genre(GENREID,NAME)
VALUES (26,'Disco')
;

INSERT INTO Genre(GENREID,NAME)
VALUES (27,'Depressing Music')
;

--Task insert two new records into Employee table
INSERT INTO Employee(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
VALUES(9,'GRANADOS','DAYSI','MASTER',7,to_date('19960104,'YYYYMMDD'),to_date('20140404,'YYYYMMDD'),'101 myHouse st','nice city','Russia',11452,666666,898989,'meep@gmail.com')
;

INSERT INTO Employee(EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
VALUES(10,'GRANADOS','ANA','PLEBIAN',7,to_date('19901204,'YYYYMMDD'),to_date('20100404,'YYYYMMDD'),'101 myHouse st','nice city','Russia',11452,666666,898989,'meep@gmail.com')
;
--Task insert two new records into Customer table
INSERT INTO Customer(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
VALUEs(60,'BOB','BERT','LAYS','101 myHouse st','nice city','Russia',11222,666666,898989,'meep@gmail.com',9)
;
INSERT INTO Customer(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
VALUEs(60,'ROB','BERT','NSA','101 myHouse st','nice city','Russia',11222,666666,898989,'chi@gmail.com',9)
;
-----2.4 UPDATE

--Task update Aaron mitchell in customer table to Robert Walter
UPDATE Customer set firstname='Robert',lastname='Walter'
WHERE firstname='Aaron'AND lastname='Mitchell'
;

--Task update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
UPDATE Artist set name='CCR'
WHERE name='Creedence Clearwater Revival'
;

--------2.5 LIKE
--Task select all invoices with billing address like "T%"
SELECT billingaddress
FROM Invoice
WHERE billingaddress LIKE 'T%'
;

------2.6 BETWEEN
--Task select all invoices that have a total between 15 and 50
SELECT * 
FROM Invoice
WHERE total BETWEEN 15 AND 50
;
--Task select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM Employee
WHERE Hiredate BETWEEN to_date('2003-06-01','yyyy-mm-dd')
AND to_date('2004-03-01','yyyy-mm-dd')
;
----2.7 DELETE
--Task Delete a record in Customer table where the name is Robert Walter
-- foriegn key  FOREIGN KEY (SupportRepId) REFERENCES Employee (EmployeeId)  ;
ALTER TABLE CUSTOMER 
DROP CONSTRAINT FK_CustomerSupportRepId
;
---FK_EmployeeReportsTo,FK_InvoiceCustomerId
ALTER TABLE EMPLOYEE
DROP CONSTRAINT FK_EmployeeReportsTo
;
ALTER TABLE INVOICE
DROP CONSTRAINT FK_InvoiceCustomerId
;
DELETE 
FROM CUSTOMER
WHERE firstname='Robert'AND lastname='Walter'
;
SELECT *FROM Customer;

------3.1 System Defined Functions
--Task create a function that returns the current time
SELECT TO_CHAR
(SYSDATE,'MM-DD-YYYY HH:MI:SS')"NOW"
FROM DUAL;

--Task create a function that returns the length of a mediatype from the mediatype table
SELECT name,LENGTH(name) 
AS LENGTH 
FROM Mediatype
;
--Task create a function that returns the most expensive track
SELECT MAX(unitprice) 
FROM Track
;
------3.2 System Defined Aggregate Functions
--Task create a function that returns the average total of all invoices
SELECT AVG(total)
FROM Invoice
;
-----3.3 User DEfined Function
--task create a function that returns the average price of invoiceline items in the invoiceline table
SELECT AVG(unitprice)
FROM Invoiceline
;
-----3.4
--Task create function that returns all employees who are born after 1968
----SELECT billingaddress
---FROM Invoice
----WHERE billingaddress LIKE 'T%'
----to_date('2003-06-01','yyyy-mm-dd')
SELECT *
FROM EMPLOYEE
WHERE birthdate > to_date('1968-12-31','yyyy-mm-dd')
;
-----4.0 Stored Procedures
--4.1 basic stored procedure
--Task create a stored procedure that selects the first and last names of all employees
/
create or replace procedure getEmployeeName(
a1_firstName out varchar2,
a1_lastName out varchar2
)
is
begin
select FIRSTNAME into a1_firstName
from EMPLOYEE;
select LASTNAME into a1_lastName
from EMPLOYEE;
end;
/
-----4.2 Stored Procedure Input Parameters 
--Task create a stored procedure that updates the personal info of an employee
/*
UPDATE Customer set firstname='Robert',lastname='Walter'
WHERE firstname='Aaron'AND lastname='Mitchell'
;
*/
/
create or replace procedure updateInfo(a2_firstName in varchar2,
a2_lastName in varchar2,emp_id in number)
is 
begin
update EMPLOYEE set lastname=a2_lastName,firstname=a2_firstName
where employeeid=emp_id;
end;
/

/
--task return manager of certain employee
create or replace procedure getManager(emp_id in number,managerName out varchar2)
is
begin
select reportsto into managerName
from Employee
where EMPLOYEEID=emp_id;
end;
/
----4.3 output parameter
/
create or replace procedure getNameComp(custid in number,first_name out varchar2,comp out varchar2)
is begin
select firstname into first_name
from customer where customerid=custid;
select company into comp
from customer where customerid=custid;
end;
/
------6.1 Triggers
--Task create an after insert trigger on the employee table fired after a new record is inserted into the table

/
create or replace trigger eTrigger
after insert on Employee
for each row 
begin 
UPDATE employee set firstname='Bob'
WHERE employeeid > 5
;
end;
/
---after update trigger on the album table that fires after row is inserted 
/
create or replace trigger aTrigger
after update on album
for each row 
begin 
UPDATE artist set name='Bob'
WHERE artistid > 5
;
end;
/
--delete trigger on customer table that fires after row is deleted
/
create or replace trigger cTrigger
after delete on customer
for each row 
begin 
UPDATE customer set firstname='Bob'
WHERE customerid > 5
;
end;
/
------Inner joins 
---create an inner join that joins customers and orders and specifies the name of the customer and invoive id 

select Customer.firstname,invoice.invoiceid
from invoice
inner join customer on invoice.customerid=customer.customerid;

-----outer joins 
---outer join customer invoice table, specify customerid,firstname,lastname,invoiceid,and total
select *
from customer
full outer join invoice
on customer.customerid=invoice.customerid;

----right join that joins album and artist specifying artist name and title
select *
from album
right outer join artist
on album.title=artist.name;
-----cross join that joins album and artist and sorts artist name in ascending order
select ar.name,al.title,
from artist ar,album al;
----self join on employee table joining reportsto column
select a.employeeid,b.title,c.reportsto
from employee a,employee b, employee c
where a.title<>c.reportsto;

-----inner join on tables
select customerid cperson,employeeid eperson

