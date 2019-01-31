/*
* Kevin Ho SQL Week 2 Assignment
*/


------------------------2.1 SELECT
--Task – Select all records from the Employee table. 
SELECT * from Employee;

--Task – Select all records from the Employee table where last name is King.
SELECT * from Employee where lastname = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * from Employee where firstname = 'Andrew' AND reportsto IS null;

-------------------------2.2 ORDER BY
--Task . Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title DESC;

--Task . Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer ORDER BY city ASC;

-------------------------2.3 INSERT INTO
--Task . Insert two new records into Genre table
INSERT INTO GENRE VALUES (26, 'Math Rock');
INSERT INTO GENRE VALUES (27, 'Eurobeat');

--Task . Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) 
            VALUES   (9, 'Ho', 'Kevin', 'XD', 3, '27-FEB-97', '01-JAN-01', '240 Bay 35 St', 'Brooklyn', 'NY', 'USA', 'XD', '1 (917) 621 6996', '1 (917) 621 6906', 'xd@xd.com');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) 
            VALUES   (10, 'Ho2', 'Kevin2', 'XD2', 3, '27-FEB-97', '01-JAN-01', '241 Bay 35 St', 'Brooklyn', 'NY', 'USA', 'XD', '1 (917) 621 6997', '1 (917) 621 6999', 'xd2@xd.com');

--Task . Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
            VALUES   (60, 'Kevin', 'Ho', 'Revature', '240 Bay 69 Street', 'Brooklyn', 'NY', 'USA', '69696', '+1 (696) 969 6969' , null, 'kevho48@gmail.com', 3);
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
            VALUES   (61, 'Kevin', 'Ho', null, null, 'Brooklyn', 'NY', 'USA', '69626', '+1 (696) 969 6922' , null, 'kevho482@gmail.com', 4);

-------------------------2.4 UPDATE
--Task . Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' 
WHERE CUSTOMERID = 32;

--Task . Update name of artist in the Artist table ?gCreedence Clearwater Revival?h to ?gCCR?h
UPDATE ARTIST
SET NAME = '?gCCR?h'
WHERE NAME = '?gCreedence Clearwater Revival?h';

-------------------------2.5 LIKE
--Task . Select all invoices with a billing address like ?gT%?h

-------------------------2.6 BETWEEN
--Task . Select all invoices that have a total between 15 and 50

--Task . Select all employees hired between 1st of June 2003 and 1st of March 2004

-------------------------2.7 DELETE
--Task . Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

-------------------------3.0 SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

-------------------------3.1 System Defined Functions
--Task – Create a function that returns the current time.

--Task – create a function that returns the length of a mediatype from the mediatype table

-------------------------3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices

--Task – Create a function that returns the most expensive track

-------------------------3.3 User Defined Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

-------------------------3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

-------------------------4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.

-------------------------4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

-------------------------4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.

--Task – Create a stored procedure that returns the managers of an employee.

-------------------------4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

-------------------------5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

-------------------------6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

-------------------------6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.

-------------------------7.0 JOINS
--In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.

-------------------------7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

-------------------------7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

-------------------------7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

-------------------------7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

-------------------------7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

-------------------------7.6 Complicated Join assignment
--Create an inner join between all tables in the chinook database.

-------------------------9.0 Administration
--In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.

--Task – Create a .bak file for the Chinook database
