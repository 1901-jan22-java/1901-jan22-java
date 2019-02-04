-- 2.1 SELECT 
SELECT * FROM Employee;
SELECT * FROM Employee WHERE lastname='King';
SELECT * FROM Employee WHERE firstname='Andrew' AND REPORTSTO IS NULL;
-- 2.2 ORDER BY 
SELECT * FROM ALBUM ORDER BY title DESC; 
SELECT firstname FROM Customer ORDER BY city ASC;
--2.3 INSERT INTO
INSERT INTO Genre (GENREID, NAME) VALUES (26, 'Symphonic Black Metal');
INSERT INTO Genre (GENREID, NAME) VALUES (27, 'Jpop');
INSERT INTO Employee (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (9, 'George', 'Lopez');
INSERT INTO Employee (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (10, 'Will', 'Smith');
INSERT INTO Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, 'LARS', 'ULRICH', 'lars.ulrich@metallica.com');
INSERT INTO Customer (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61, 'BRUCE', 'DICKINSON', 'bruce.dicksinson@ironmaiden.com');
SELECT * FROM Customer;
SELECT * FROM Employee;
SELECT * FROM Genre;
--2.4 UPDATE
UPDATE Customer SET FIRSTNAME='Robert', LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE Artist SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';
SELECT * FROM Customer WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';
SELECT * FROM Artist WHERE NAME ='CCR';
--2.5 LIKE
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';

--2.6 BETWEEN
SELECT * FROM Invoice WHERE INVOICEID BETWEEN 15 AND 50;
SELECT * FROM Employee WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';

--2.7 DELETE -- is there an issue without deleting the children. there is only 1 row deleted
ALTER TABLE Invoice
    DROP CONSTRAINT FK_InvoiceCustomerId;
ALTER TABLE Invoice 
    ADD CONSTRAINT FK_InvoiceCustomerId
    FOREIGN KEY (CustomerId) REFERENCES Customer (CustomerId)
    ON DELETE CASCADE; 
ALTER TABLE InvoiceLine 
    DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE InvoiceLine 
    ADD CONSTRAINT FK_InvoiceLineInvoiceId
    FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId)
    ON DELETE CASCADE;
    
DELETE FROM Customer WHERE FirstName='Robert' AND LastName='Walter';

/*3.1 System Defined Functions*/
/* Task � Create a function that returns the current time. */
ALTER SESSION SET TIME_ZONE = '-1:00';

SELECT CURRENT_TIMESTAMP
FROM dual;
/* Task � create a function that returns the length of a mediatype from the mediatype table */
SELECT NAME, LENGTH2(NAME)
FROM MEDIATYPE;
--3.2 System Defined Aggregate Functions 
/* Task � Create a function that returns the average total of all invoices */
SELECT AVG(TOTAL)
FROM INVOICE;
/* Task � Create a function that returns the most expensive track */
SELECT MAX(UNITPRICE)
FROM INVOICELINE;
-- 3.3 User Defined Functions
/*Task � Create a function that returns the average price of invoiceline items in the invoiceline table*/
SELECT AVG(UNITPRICE)
FROM INVOICELINE;
--3.4 User Defined Table Valued Functions
/*Task � Create a function that returns all employees who are born after 1968.*/
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
IS
  EMPLOYEE_C SYS_REFCURSOR;
BEGIN
  OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= TO_DATE('01-01-1968','DD-MM-YYYY');
  RETURN EMPLOYEE_C;
END;
/
SELECT AFTER_1968 FROM DUAL;
--4.1 Basic Stored Procedure
/*Task � Create a stored procedure that selects the first and last names of all the employees.*/
CREATE OR REPLACE PROCEDURE EMPLOYEE_INFO(cursorParam OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN cursorParam FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
DECLARE
  EMPLOYEE_C SYS_REFCURSOR;
  FIRSTNAME VARCHAR2(100);
  LASTNAME VARCHAR2(100);
BEGIN
  EMPLOYEE_INFO(EMPLOYEE_C);
  LOOP
    FETCH EMPLOYEE_C INTO FIRSTNAME, LASTNAME;
    EXIT WHEN EMPLOYEE_C%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ', ' || LASTNAME);
  END LOOP;
END;
/
--4.2
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE 
(
  THE_EMPLOYEEID IN NUMBER,
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
  SET LASTNAME = 
        CASE NEW_LASTNAME 
        WHEN NULL THEN 
          LASTNAME
        ELSE NEW_LASTNAME
        END,
      FIRSTNAME =
        CASE NEW_FIRSTNAME 
        WHEN NULL THEN 
          FIRSTNAME
        ELSE NEW_FIRSTNAME
        END,
      TITLE = NEW_TITLE,
      REPORTSTO = NEW_REPORTSTO,
      BIRTHDATE = NEW_BIRTHDATE,
      HIREDATE = NEW_HIREDATE,
      ADDRESS = NEW_ADDRESS,
      CITY = NEW_CITY,
      STATE = NEW_STATE,
      COUNTRY = NEW_COUNTRY,
      POSTALCODE = NEW_POSTALCODE,
      PHONE = NEW_PHONE,
      FAX = NEW_FAX,
      EMAIL = NEW_EMAIL
    WHERE EMPLOYEEID = THE_EMPLOYEEID;
END UPDATE_EMPLOYEE;
--4.3
/*CREATE OR REPLACE PROCEDURE CUSTOMER_COMPANY(cursorParam OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN cursorParam FOR SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER;
END;
/
DECLARE
  CUSTOMER_C SYS_REFCURSOR;
  FIRSTNAME VARCHAR2(100);
  LASTNAME VARCHAR2(100);
  COMPANY VARCHAR2(100);
BEGIN
  CUSTOMER_COMPANY(CUSTOMER_C);
  LOOP
    FETCH CUSTOMER_C INTO FIRSTNAME, LASTNAME, COMPANY;
    EXIT WHEN CUSTOMER_C%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ', ' || LASTNAME || ', ' || COMPANY);
  END LOOP;
END;
/
*/
CREATE OR REPLACE PROCEDURE Delete_invoice(
inv_id IN Number)
AS
BEGIN
  -- first delete invoicelines which depend on the invoice 
  DELETE FROM INVOICELINE WHERE INVOICEID = inv_id;
  DELETE FROM INVOICE WHERE INVOICEID = inv_id;
  
  commit;
END;
/
--
select * from invoice where invoiceid = 1;
exec delete_invoice(1);
--7.1
/* Inner Join CUSTOMERS & INVOICE - cols = custname & invoiceid */
SELECT CUSTOMER.FIRSTNAME || CUSTOMER.LASTNAME AS Name, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.INVOICEID;
--7.2
/* Outer Join on CUSTOMERS and INVOICE - cols customerid, firstname, lastname, invoiceid, total */
SELECT  CUSTOMER.CUSTOMERID as ID,
        CUSTOMER.FIRSTNAME || CUSTOMER.LASTNAME as Name,
        INVOICE.INVOICEID as Invoice,
        INVOICE.TOTAL as Total
FROM CUSTOMER
LEFT OUTER JOIN INVOICE on CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.3
/* Right join ALBUM and ARTIST - cols artistname & title */
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ARTIST
RIGHT OUTER JOIN ALBUM
ON ALBUM.ARTISTID = ARTIST.ARTISTID;
--7.4
/* Cross Join ALBUM and ARTIST - sort by artist name ASC */
SELECT *
FROM ALBUM
    CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;
--7.5
/* SELF JOIN self-join on the employee table, joining on the reportsto column. */
SELECT FIRST.EMPLOYEEID, FIRST.LASTNAME || FIRST.FIRSTNAME AS Name, SECOND.REPORTSTO
FROM EMPLOYEE FIRST, EMPLOYEE SECOND
WHERE FIRST.EMPLOYEEID = SECOND.REPORTSTO; 