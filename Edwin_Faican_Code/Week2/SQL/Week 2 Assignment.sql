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

SELECT invoicelineavg() FROM dual;

--





