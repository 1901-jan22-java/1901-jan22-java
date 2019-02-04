--Part I

-- 2.1 SELECT
-- Select all records from Employee table
SELECT * FROM EMPLOYEE;
-- Select all records from Employee table where last name is King
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
-- Select all records from Employee table where first name is Andres
-- and REPORTSTO is null
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY
-- Select all albums in Album table and sort result in descending order by title
SELECT * FROM ALBUM ORDER BY TITLE DESC;
-- Select all first name and Customer and sort result set in asc order by city
SELECT * FROM CUSTOMER ORDER BY CITY;

-- 2.3 INSERT INTO
-- Insert two new records into Genre Table
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Audiobook/Spoken');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'Podcast');
-- Insert two new records into Employee Table
SELECT * FROM ALBUM ORDER BY TITLE DESC;
INSERT  INTO Employee   (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
        VALUES          (9, 'Smith', 'Catherine', 'Sales Support Agent', TO_DATE('1972-1-22 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2004-5-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1020 2nd Ave', 'Calgary', 'AB', 'Canada', 'T5K 21Y7', '+1 (408) 430-7744', '+1 (408) 428-0001', 'catsmith@chinookcorp.com');
INSERT  INTO Employee   (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
        VALUES          (10, 'Brown', 'Peter', 'IT Staff', TO_DATE('1981-9-22 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2014-8-24 00:00:00','yyyy-mm-dd hh24:mi:ss'), '110 Main Street', 'Calgary', 'AB', 'Canada', 'T2P 2T3', '+1 (780) 428-1234', '+1 (780) 428-00012', 'petbrown@chinookcorp.com');
INSERT  INTO Employee   (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
        VALUES          (11, 'Carrion', 'Amber', 'Sales Support Agent', TO_DATE('1993-11-12 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2016-3-4 00:00:00','yyyy-mm-dd hh24:mi:ss'), '200 1st Ave', 'Calgary', 'AB', 'Canada', 'T5K 2N1', '+1 (403) 428-7744', '+1 (408) 428-0022', 'catsmith@chinookcorp.com');
-- Insert two new records into Customer table
INSERT  INTO Customer   (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
        VALUES          (60, 'Carlos', 'Santos', '3 Roca Blv', 'Lisbon', 'Portugal', '1000-008', '+351 2 1234 4321', 'carlinhoss2012@yahoo.com.br', 3);
INSERT  INTO Customer   (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
        VALUES          (61, 'Amilda', 'Carvalho', '110 DosBrancos Av', 'Lisbon', 'Portugal', '1000-003', '+351 2 0022 0088', 'doggyfan_amilda@aol.com.br', 4);
INSERT  INTO Customer   (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId) 
        VALUES          (62, 'Joshua', 'Araujo', '3 Roca Blv', 'Lison', 'Portugal', '1000-002', '+351 2 3312 9999', 'josh_ara_hulk@terra.com.br', 5);

--2.4 UPDATE
-- Update Aaron Mitchel in Customer T to Robert Walter
UPDATE  CUSTOMER
SET     FIRSTNAME   = 'Robert', LASTNAME = 'Walter'
WHERE   CUSTOMERID  = ( SELECT  CUSTOMERID FROM CUSTOMER 
                        WHERE   FIRSTNAME = 'Alfred' AND
                                LASTNAME  = 'Schmidt');
-- Update name of artist in the Artist table "Creedence Clearwater Revival" to "CC"
UPDATE  ARTIST
SET     NAME        = 'CCC'
WHERE   ARTISTID  = ( SELECT  ARTISTID FROM ARTIST 
                        WHERE   NAME = 'Creedence Clearwater Revival');
                        
--2.5 LIKE
-- Select all invoices with a billing address like "T%"
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
-- Select all invoces that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 20;
-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('01-JUN-2003') AND TO_DATE('01-JUN-2004');

--2.7 DELETE
-- delete record in customer table where name is robert walter (there may be constraints, solve them)
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.0 SQL FUNCTIONS

--3.1 SYSTEM DEFINED FUNCTIONS
-- create a function that returns the current time

CREATE OR REPLACE FUNCTION getCurrentTime
  return varchar 
is -- or AS -- var declarations
  CT varchar(5);
begin 
  SELECT  TO_CHAR(SYSDATE, 'HH24:MI') into CT FROM DUAL;
  return CT;
end;
/
select getCurrentTime() from dual;
-- create a function that returns the length of a mediatype from the mediatype table
CREATE OR REPLACE FUNCTION getMediaTypeLength(media_id number)
  return number 
is -- or AS -- var declarations
  mediaLength number(20);
begin 
  SELECT LENGTH(( SELECT NAME FROM MEDIATYPE WHERE MEDIATYPEID = MEDIA_ID ))
  INTO mediaLength FROM DUAL;
  return mediaLength;
end;
/
select getMediaTypeLength(3) from dual;
/
--3.2 System Defined Aggregate Functions
--create function that returns the avg total of all invoices
CREATE OR REPLACE FUNCTION invoice_avg
  return number 
is -- or AS -- var declarations
  avg number(20);
begin 
  SELECT AVG(TOTAL )
  INTO avg FROM INVOICE;
  return avg;
end;
/
select invoice_avg from dual;

--create function that returns the most expensive track