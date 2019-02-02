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
