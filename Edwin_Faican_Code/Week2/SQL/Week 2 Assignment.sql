--Part 1: Setting up Chinook Database: COMPLETE --

--Part 2.1: Select Problems --
--Select all from Employee table --
SELECT * FROM employee;

--Select all records where last name is 'KING' --
SELECT * FROM employee
WHERE lastname = 'King';

--Select all records where first name is Andrew and reports to is NULL --
SELECT * FROM employee 
WHERE firstname = 'Andrew' AND reportsto IS NULL;

--Part 2.2: Order By Problems --
--Select all albums in Albums table and sort in descending order by title --
SELECT * FROM album
ORDER BY title DESC;

--Select first names from Costumer and order by city in ascending order --
SELECT firstname FROM customer
ORDER BY city;

--Part 2.3: Insert Into Problems --
--Insert two new records into genre table --
INSERT INTO genre VALUES (26,'Pop Metal');
INSERT INTO genre VALUES (27,'Disco');

--Part 2.4: Update Problems --
--Update Robert Walter into Customer in place of Aaron Mitchell --
UPDATE customer 
SET firstname = 'Robert', lastname = 'Walter'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

--Update Creedence Clearwater Revival to CCR in Artist table--
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--Part 2.5: Like Problems--
--Select invoices with billing address beginning in 'T'--
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

--Part 2.6: Between Problems--
--Select all invoices with a total between 15 and 50--
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

--Select employees hired between June 1, 2003 to March 1, 2004--
SELECT * FROM employee
WHERE hiredate BETWEEN '01-JUN-2003' AND '01-MAR-2004';

--Part 2.7: Delete Problems-- 
--Delete Robert Walter from the Customer table--
--Delete smallest dependency first according to integrity constraints--
DELETE FROM invoiceline
WHERE invoiceid IN (SELECT invoiceid FROM invoice
                   WHERE customerid IN (Select customerid FROM customer
                                        WHERE firstname = 'Robert' AND lastname = 'Walter'));

--Delete from next dependency--
DELETE FROM invoice 
WHERE customerid = (Select customerid FROM customer
                    WHERE firstname = 'Robert' AND lastname = 'Walter');
                    
--Finally, there are no foriegn references to this value so it can be deleted without violating integrity constraints--
DELETE FROM customer 
WHERE firstname = 'Robert' AND lastname = 'Walter';

--Part 3.0: Oracle Systemm Functions--

--Part 3.1: System Defined Functions--
--Return current time--
SELECT TO_CHAR
    (SYSDATE, 'MM-DD-YYYY HH24:MI:SS')
     FROM DUAL;
     
--Return length of a mediatype from mediatype table--
SELECT length(name) FROM mediatype
WHERE mediatypeid = 1;

--Part3.2: System Defined Aggregate Functions--
--Return average of all total invoices--
SELECT AVG(total) FROM invoice;

--Return most expensive track--
SELECT name , unitprice FROM track
WHERE unitprice = (SELECT MAX(unitprice) FROM track);

--Part 3.3: User-Defined Functions--
--Return average price of invoiceline items from invoiceline table--
CREATE FUNCTION invoicelineavg  
RETURN number
IS average_invoiceline number(8,2);

BEGIN
  SELECT AVG(unitprice)
  INTO average_invoiceline
  FROM invoiceline;
  
  RETURN (average_invoiceline);
  
END;
/
SELECT invoicelineavg() FROM dual;

--Part 3.4: User-Defined Table Valued Functions--
--Return number of employees born after 1968--

CREATE OR REPLACE FUNCTION bornAfter1968
RETURN NUMBER
IS numEmp NUMBER;
BEGIN 
  SELECT COUNT(*) INTO numEmp FROM Employee
  WHERE birthdate >= '01-JAN-1968';
  RETURN numEmp;
END;
/

SELECT bornAfter1968() FROM DUAL;


--Part 4.0: Stored Procedures--

--Part 4.1: Basic Stored Procedure--
--Select first and last names of all employees--
CREATE OR REPLACE PROCEDURE firstLast(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cursorParam FOR SELECT firstname || ' ' || lastname AS fullName FROM Employee;
END;
/

--Part 4.2: Stored Procedure Input Parameters--
--Update personal information of an employee--
CREATE OR REPLACE PROCEDURE updateTitle(newTitle IN VARCHAR2, empId IN NUMBER)
AS
BEGIN
  UPDATE Employee
  SET title = newTitle
  WHERE employeeid = empId;
  commit;
END;
/
SELECT * FROM Employee;
EXEC updateTitle('General Manager', 1);

--Return the managers of an employee--
CREATE OR REPLACE PROCEDURE managers(empId IN NUMBER, man_id OUT NUMBER)
AS
BEGIN 
  SELECT reportsto INTO man_id FROM Employee
  WHERE employeeid = empId;
END;
/

DECLARE man_id NUMBER;
BEGIN
  managers(2, man_id);
  dbms_output.put_line('Manager id: ' || man_id);
END;
/

--Part 4.3: Stored Procedure Output Paramters--
--Return the name and company of a customer--
CREATE OR REPLACE PROCEDURE nameAndCompany(cus_id IN NUMBER, cus_name OUT VARCHAR2, cus_company OUT VARCHAR2)
AS
BEGIN
  SELECT firstname || ' ' || lastname AS fullname, company INTO cus_name, cus_company FROM Customer
  WHERE customerid = cus_id;
END;
/

DECLARE 
  cus_name VARCHAR2(200); 
  cus_company VARCHAR2(200);
BEGIN
  nameAndCompany(1, cus_name, cus_company);
  dbms_output.put_line('Name: ' || cus_name || ', Comapany: ' || cus_company);
END;
/

--Part 5.0: Transactions--

--Given an invoice id, delete that invoice--
START TRANSACTION;
  DELETE FROM invoiceline
  WHERE invoiceid = 2;
  
  DELETE FROM invoice
  WHERE invoiceid = 2;
COMMIT;
/

--Insert new record into Customer Table--
CREATE OR REPLACE PROCEDURE insertCusInUS(
cus_id IN NUMBER,
cus_first IN VARCHAR2,
cus_last IN VARCHAR2,
cus_comp IN VARCHAR2,
cus_addr IN VARCHAR2,
cus_city IN VARCHAR2,
cus_state IN VARCHAR2,
cus_post IN VARCHAR2,
cus_phone IN VARCHAR2,
cus_fax IN VARCHAR2,
cus_email IN VARCHAR2,
cus_supp IN NUMBER)
AS
BEGIN
  INSERT INTO Customer VALUES(cus_id,cus_first,cus_last,cus_comp,cus_addr,cus_city,cus_state,'USA',cus_post,cus_phone,cus_fax,cus_email,cus_supp);
  COMMIT;
END;
/

EXEC insertCusInUS(501,'Tim','Banks','Alpine Theater','7193 29 Street','New York','New York','23981','3475728567','347286529','no@no.com',2);


--Part 6.0: Triggers--
CREATE TABLE Employee_Backup(
employeeid number(10),
lastname varchar2(20),
firstname varchar2(20),
title varchar2(20),
reportsto number(10),
birthdate Date,
hiredate Date,
address varchar2(50),
city varchar2(20),
state varchar2(20),
country varchar2(20),
postalcode varchar2(20),
phone varchar2(50),
fax varchar2(50),
email varchar2(50),
PRIMARY KEY (employeeid));

--Trigger for after insertion--
CREATE OR REPLACE TRIGGER Empoyee_trig
AFTER INSERT ON Employee
FOR EACH ROW
BEGIN 
  INSERT INTO Employee_Backup VALUES (:new.employeeid, :new.firstname, :new.lastname, :new.title, :new.reportsto, :new.birthdate, :new.hiredate, :new.address, :new.city, :new.state, :new.country, :new.postalcode, :new.phone, :new.fax, :new.email);
END;
/
INSERT INTO Employee VALUES (327, 'qwiu','wiqunui','dc',4,SYSDATE,SYSDATE,'wqdoj','owqid','wqodio','oqwid','idqud','wdohqwd','owqduod','owdhq');

SELECT * FROM EMPLOYEE_BACKUP;

--Trigger for after update--
CREATE OR REPLACE TRIGGER Album_trig
AFTER UPDATE ON Album
FOR EACH ROW
BEGIN
    dbms_output.put_line('Ensure updated values are correct!');
END;
/
UPDATE Album 
SET albumid = 23123
WHERE albumid = 23123;
SELECT * FROM Album WHERE albumid > 9000;

--Trigger for after deletion--
CREATE TABLE LegacyCustomers(
customerid NUMBER(10) PRIMARY KEY,
name VARCHAR2(20));

CREATE OR REPLACE TRIGGER Customer_trig
AFTER DELETE ON Customer
FOR EACH ROW
BEGIN
  INSERT INTO LegacyCustomers VALUES(:old.customerid, :old.firstname || ' ' || :old.lastname);
END;
/

INSERT INTO Customer VALUES (327, 'qwiu','wiqunui','dc','wqdoj','owqid','wqodio','oqwid','idqud','wdohqwd','owqduod','owdhq',2);

DELETE FROM Customer
WHERE customerid = 327;

SELECT * FROM LegacyCustomers;

--Part 7.0: Joins--

--Inner Join--
SELECT firstname || ' ' || lastname AS name, invoiceid FROM Customer 
JOIN Invoice ON invoice.customerid = customer.customerid;

--Outer Join--
SELECT c.customerid, firstname, lastname, i.invoiceid, i.total FROM Customer c
LEFT OUTER JOIN invoice i ON i.customerid = c.customerid;

--Right Outer Join--
SELECT name, title FROM Artist
RIGHT OUTER JOIN Album ON artist.artistid = album.artistid;

--Cross Join--
SELECT * FROM Artist 
CROSS JOIN Album WHERE artist.artistid = album.artistid
ORDER BY name;

--Self Join--
SELECT * FROM Employee e1
JOIN Employee e2 ON e1.employeeid = e2.employeeid;

--Complex Join--
SELECT * FROM Artist ar
JOIN Album al ON al.artistid = ar.artistid
JOIN Track t ON t.albumid = al.albumid
JOIN Genre g ON g.genreid = t.genreid
JOIN Mediatype m ON m.mediatypeid = t.mediatypeid
JOIN Playlisttrack pt ON pt.trackid = t.trackid
JOIN Playlist p ON p.playlistid = pt.playlistid
JOIN invoiceline il ON il.trackid = t.trackid
JOIN invoice i ON i.invoiceid = il.invoiceid
JOIN customer c ON c.customerid = i.customerid
JOIN employee e ON e.employeeid = c.supportrepid;

--Part 9.0: Backup Database--