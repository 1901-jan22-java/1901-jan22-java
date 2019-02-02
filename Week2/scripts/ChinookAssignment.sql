/*
* Genesis Bonds Week 2 Assignment [EXAMPLE of format]
*/


------------------------2.1 SELECT
--Task � Select all records from the Employee table. 
SELECT * from Employee;

--Task � Select all records from the Employee table where last name is King.
SELECT * from Employee where lastname = 'King';

--Task � Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
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







