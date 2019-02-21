-- SQL Assignment --

-- 2.1 SELECT --
SELECT * FROM employee;

SELECT * FROM employee 
WHERE lastname = 'King';

SELECT * FROM employee
WHERE firstname = 'Andrew'
AND
reportsto IS NULL;

-- 2.2 ORDER BY --
SELECT * FROM album
ORDER BY title DESC;

SELECT firstname, city FROM customer
ORDER BY city;

-- 2.3 INSERT INTO --
SELECT * FROM genre;
SELECT * FROM employee;
SELECT * FROM customer;

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

-- 2.4 UPDATE --
SELECT * FROM customer;
SELECT * FROM artist;

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;

UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

-- Like --
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

-- BETWEEN -
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

SELECT * FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04'; 

-- DELETE --
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
SELECT SYSTIMESTAMP FROM dual;

SELECT LENGTH(name)
FROM mediatype
WHERE mediatypeid = 3;

-- System Defined Aggregate Functions --
SELECT * FROM invoice;

SELECT AVG(total)
FROM invoice;

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