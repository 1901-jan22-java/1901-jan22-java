/*
* Genesis Bonds Week 2 Assignment [EXAMPLE of format]
*/


------------------------------------------------------------------------- SELECT

--Task – Select all records from the Employee table. 
SELECT * from Employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * from Employee where lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * from Employee where firstname = 'Andrew' AND reportsto IS null;

----------------------------------------------------------------------- ORDER BY

-- Task: Select all albums in Album Table and sort result set in descending order
SELECT * FROM album
ORDER BY title DESC;

--Task: Select first nae from customer and sort result set in ascending orer by city
SELECT firstname, city FROM customer
ORDER BY city;

-------------------------------------------------------------------- INSERT INTO

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

------------------------------------------------------------------------- UPDATE

--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = 32;

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';

--------------------------------------------------------------------------- LIKE

--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice
WHERE billingaddress LIKE 'T%';

------------------------------------------------------------------------ BETWEEN

--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice
WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04'; 

------------------------------------------------------------------------- DELETE

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

------------------------------------------------------- SYSTEM DEFINED FUNCTIONS

--Task – Create a function that returns the current time.
SELECT SYSTIMESTAMP FROM dual;

--Task – create a function that returns the length of a mediatype from the mediatype table
SELECT LENGTH(name)
FROM mediatype
WHERE mediatypeid = 3;

--------------------------------------------- System Defined Aggregate Functions

--Task – Create a function that returns the average total of all invoices
SELECT AVG(total)
FROM invoice;

--Task – Create a function that returns the most expensive track
SELECT trackid, name, unitprice
From track
WHERE unitprice = 
(SELECT MAX(unitprice) FROM track);

--------------------------------------------------------- USER DEFINED FUNCTIONS

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
-- Googled how to do this before I realized that a cursor would have be just fine
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



--------------------------------------------------------- BASIC STORED PROCEDURE 

-- Task: Create a stored procedure that selects the firstname and last names of all employees
CREATE OR REPLACE PROCEDURE employee_names(empNameCursor OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN empNameCursor FOR SELECT firstname, lastname FROM employee;
END;
/

-- TASK: Create a stored procedure that updates the personal info of an employee
CREATE OR REPLACE PROCEDURE updateEmployeeInfo(
employeeid IN NUMBER, lastname IN VARCHAR2, firstname IN VARCHAR2, title IN VARCHAR2, reportsto IN NUMBER,
birthdate IN DATE, hiredate IN DATE, address IN VARCHAR2, city IN VARCHAR2, state IN VARCHAR2, country IN VARCHAR2,
postalcode IN VARCHAR2, phone IN VARCHAR2, fax IN VARCHAR2, email IN VARCHAR2
)
AS 
BEGIN
UPDATE employee
SET employee.lastname = lastname, employee.firstname = firstname, employee.title = title,
employee.reportsto = reportsto, employee.birthdate = birthdate, employee.hiredate = hiredate, employee.address = address,
employee.city = city, employee.state = state, employee.country = country, employee.postalcode = postalcode, employee.phone = phone,
employee.fax = fax, employee.email = email
WHERE employee.employeeid = employeeid;
END;

-- Task: Create a stored procedure that returns the managers of an employee
CREATE OR REPLACE PROCEDURE getEmpManager( eid IN NUMBER, output OUT VARCHAR)
IS
BEGIN
    SELECT reportsto INTO output FROM employee WHERE employeeid = eid;
    dbms_output.put_line(output);
END;
/


-- Task: Create a stored procedure that returns the name and company of a customer
CREATE OR REPLACE PROCEDURE nameNcompany(cid IN NUMBER, fname OUT VARCHAR2, lname OUT VARCHAR2, comp OUT VARCHAR2)
IS
BEGIN
 SELECT firstname INTO fname FROM customer WHERE customerid = cid;
 SELECT lastname INTO lname FROM customer WHERE customerid = cid;
 SELECT company INTO comp FROM customer WHERE customerid = cid;
 dbms_output.put_line(fname || ' ' || lname || ', ' || comp);
END;

------------------------------------------------------------------- Transactions

-- Task: Create a transaction that given a invoiceid will delete that invoice
CREATE OR REPLACE PROCEDURE delete_inv(
  invId IN NUMBER
) IS
BEGIN
  DELETE FROM invoiceline WHERE invoiceid = invId;
  DELETE FROM invoice WHERE invoiceid = invId;
  commit;
END;
/
-- Task: Create a transaction nested within a stored procedure that inserts a new record in the customer table
CREATE OR REPLACE PROCEDURE newCustomer(
  cID IN NUMBER, fName IN VARCHAR2, lName IN VARCHAR2, company IN VARCHAR2, address IN VARCHAR2,
  city IN VARCHAR2, state IN VARCHAR2, country IN VARCHAR2, zip IN VARCHAR2, phone IN VARCHAR2,
  fax IN VARCHAR2, email IN VARCHAR2, supportRID IN NUMBER) 
IS
BEGIN
  INSERT INTO customer VALUES(
    cID, fName, lName, company, address, city, state, country, zip, phone, fax, email, supportRID
  );
  commit;
END;
/


----------------------------------------------------------------------- Triggers

-- Task: Create an after insert trigger on the employee table fired after a new record is inserted into the table
CREATE OR REPLACE TRIGGER e_Trigger
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
  dbms_output.put_line('Insert On Employee Excuted');
END;
/
-- Task: Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_TRIGGER
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
  dbms_output.put_line('Updated Executed On Album');
END;
/

-- Task: Create an after delete trigger on the customer table that fires after a row is deleted from the table
CREATE OR REPLACE TRIGGER customer_Trigger
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
dbms_output.put_line('Delete Executed On Customer');
END;
/


-------------------------------------------------------------------------- Joins

-- Task: Create an inner join that joins customers and orders and specifies the name of the customer and invoiceid
SELECT firstname, lastname, invoiceid FROM customer INNER JOIN invoice
ON customer.customerid = invoice.customerid;

-- Task: Create an outer join that joins the customer and invoice table specifying the CustomerId, fname, lname, invoiceid, and total
SELECT invoice.customerid, firstname, lastname, invoiceid, total FROM invoice FULL OUTER JOIN customer
ON invoice.customerid = customer.customerid;

-- Task: Create a right join that joins album and artist specifying artist name and title
SELECT name, title FROM artist RIGHT JOIN album
ON artist.artistid = album.artistid;

-- Task: Create a cross join that joins album and artist and sorts the artist name in ascending order
SELECT * FROM artist CROSS JOIN album
ORDER BY name ASC;

-- Task: Perform a self-join that joins on the employee table, joining on the reportsto column
SELECT * FROM employee;
SELECT e1.reportsto, e2.reportsto FROM employee e1, employee e2;

-- Task: Create an inner join between all tables in the DB
SELECT *
FROM track tr
INNER JOIN invoiceline ON invoiceline.trackid = tr.trackid
INNER JOIN genre ON genre.genreid = tr.genreid
INNER JOIN mediatype ON mediatype.mediatypeid = tr.mediatypeid
INNER JOIN album ON album.albumid = tr.albumid
INNER JOIN playlisttrack ON playlisttrack.trackid = tr.trackid
INNER JOIN playlist ON playlist.playlistid = playlisttrack.playlistid
INNER JOIN invoice ON invoice.invoiceid = invoiceline.invoiceid
INNER JOIN customer ON customer.customerid = invoice.customerid
INNER JOIN employee ON employee.reportsto = employee.reportsto;


commit;
