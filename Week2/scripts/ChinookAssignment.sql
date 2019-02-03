/*
* Genesis Bonds Week 2 Assignment [EXAMPLE of format]
*/


------------------------2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * from Employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * from Employee where lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * from Employee where firstname = 'Andrew' AND reportsto IS null;

-- 2.2 ORDER BY --
-- Task: Select all albums in Album Table and sort result set in descending order
SELECT * FROM album
ORDER BY title DESC;

--Task: Select first nae from customer and sort result set in ascending orer by city
SELECT firstname, city FROM customer
ORDER BY city;

-- 2.3 INSERT INTO --
SELECT * FROM genre;
SELECT * FROM employee;
SELECT * FROM customer;

-- Task: Insert tew new records into Genre Table, Employee Table, Customer Table
INSERT ALL 
INTO genre (genreid, name) VALUES (26, 'Funk')
INTO genre (genreid, name) VALUES (27, 'Acoustic')
SELECT * FROM DUAL;

INSERT ALL 
INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email) 
VALUES (9, 'Rodgers', 'Steve', 'IT Staff', 6, '09-MAY-75', '14-APR-04', '123 Doris Lane', 'Sunnyvale', 'AB', 'Canada', 'T2P 5G3', '+1 (403) 345-5674', '+1 (403) 345-5674', 'steverodgers@tpb.com')
INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
VALUES (10, 'Lahey', 'Randy', 'IT Staff', 6, '09-MAY-85', '17-APR-04', '123 Doris Lane', 'Sunnyvale', 'AB', 'Canada', 'T2P 5G3', '+1 (403) 634-6774', '+1 (403) 345-5674', 'randylahey@tpb.com')
SELECT * FROM DUAL;

SELECT * FROM customer;
INSERT ALL
INTO customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
VALUES (60, 'Garth', 'Smith', 'Avoy', 'Sequoia Way', 'Holbrook', 'NY', 'USA', '11741', '631-283-4838', null, 'garth.smith@aol.com', 3)
INTO customer (customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
VALUES (61, 'Sally', 'Smith', 'Neiman Marcus', 'Sequoia Way', 'Holbrook', 'NY', 'USA', '11741', '631-183-4838', null, 'sally.smith@aol.com', 3)
SELECT * FROM dual;

-- 2.4 UPDATE --
SELECT * FROM customer;
SELECT * FROM artist;

--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

-- Like --
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

-- BETWEEN -
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04'; 

-- DELETE --
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).
ALTER TABLE invoice
DISABLE CONSTRAINT fk_invoicecustomerid;

DELETE FROM customer
WHERE firstname = 'Robert' 
AND lastname = 'Walter';

-- I think this deleted too many records
-- not related to customer Robert Walter
DELETE FROM invoiceline
WHERE invoiceid IN (245, 268, 290, 342, 50, 61, 116);

DELETE FROM invoice
WHERE customerid = 32;

ALTER TABLE invoice
ENABLE CONSTRAINT FK_INVOICECUSTOMERID;

-- SYSTEM DEFINED FUNCTIONS --
--Task – Create a function that returns the current time.
SELECT SYSTIMESTAMP FROM dual;

--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name)
FROM mediatype
WHERE mediatypeid = 3;

-- System Defined Aggregate Functions --
SELECT * FROM invoice;
--Task – Create a function that returns the average total of all invoices
SELECT AVG(total)
FROM invoice;

--Task – Create a function that returns the most expensive track
SELECT trackid, name, unitprice
From track
WHERE unitprice = 
(SELECT MAX(unitprice) FROM track);

-- USER DEFINED FUNCTIONS --
SELECT * FROM invoiceline;

-- Task: Create a function that returns the avg rpice of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION getAvgPrice
RETURN NUMBER
IS average NUMBER;
BEGIN
 SELECT AVG(UNITPRICE) INTO average
 FROM invoiceline;
 RETURN average;
END;
/
SELECT getAvgPrice() FROM Dual;

-- Task: Create a function that returns all employees who are born after 1968
CREATE TYPE emp_birthdate_obj IS OBJECT (
empid NUMBER,
empFname VARCHAR2(50),
empLname VARCHAR2(50)
);
/
CREATE OR REPLACE TYPE emp_birthdate_table IS TABLE OF emp_birthdate_obj;
/

CREATE OR REPLACE FUNCTION bornAfter1968
RETURN emp_birthdate_table
IS emp_tbl emp_birthdate_table := emp_birthdate_table();
n NUMBER := 0;
BEGIN
FOR e in (SELECT employeeid, firstname, lastname FROM employee 
WHERE (EXTRACT(YEAR FROM BIRTHDATE)) > 1968)
LOOP
emp_tbl.extend;
n := n + 1;
emp_tbl(n) := emp_birthdate_obj(e.employeeid, e.firstname, e.lastname);
END LOOP;
RETURN emp_tbl;
END;
/
SELECT * FROM TABLE (bornAfter1968); 

-- BASIC STORED PROCEDURE --
-- Task: Create a stored procedure that selects the firstname and last names of all employees

-- TASK: Create a stored procedure that updates the personal info of an employee

-- Task: reate a stored procedure that returns the managers of an employee

-- Task: Create a stored procedure that returns the name and company of a customer



-- Transactions --
-- Task: Create a transaction that given a invoiceid will delete that invoice

-- Task: Create a transaction nested within a stored procedure that inserts a new record in the customer table



-- Triggers -- 
-- Task: Create an after insert trigger on the empployee table fired after a new record is inserted into the table

-- Task: Create an after update trigger on the album table that fires after a row is inserted in the table

-- Task: Create an after delete trigger on the customer table that fires after a row is deleted from the table



-- Joins --
-- Task: Create an inner join that joins customers and orders and specifies the name of the customer and invoiceid

-- Task: Create an outer join that joins the customer and invoice table specifying the CustomerId, fname, lname, invoiceid, and total

-- Task: Create a right join that joins album and artist specifying artist name and title

-- Task: Create a cross join that joins album and artist and sorts the artist name in ascending order

-- Task: Perform a self-join that joins on the employee table, joining on the reportsto column

-- Task: Create an inner join between all tables in the DB

