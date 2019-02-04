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

--2.2 ORDER BY
--Task � Select all albums in Album table and sort result set in descending order by title.
select * from album order by title desc;

--Task � Select first name from Customer and sort result set in ascending order by city
select firstname, city from Customer order by city;

--2.3 INSERT INTO
--Task � Insert two new records into Genre table
insert into Genre(genreid, name) values (26 ,'Christian Rock');
insert into Genre(genreid ,name) values (27 ,'Gospal');

--Task � Insert two new records into Employee table
insert into employee(EMPLOYEEID, FIRSTNAME, LASTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
    values (9, 'Philup', 'Adams', 'Invintory Manager', 1, TO_DATE('1981-10-15 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2000-3-20 00:00:00','yyyy-mm-dd hh24:mi:ss'), '1313 MockingBird Line', 'Elwood', 'Ohio', 'USA', 41658, '156-845-6466', '124-514-5614', '12padams@hotmail.com');

insert into employee(EMPLOYEEID, FIRSTNAME, LASTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
    values (10, 'Cave', 'Johnson', 'Marketing', 1, TO_DATE('1951-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('1983-7-25 00:00:00','yyyy-mm-dd hh24:mi:ss'), '123 Testing Avenue', 'Chicogo', 'Calafornia', 'USA', '41815', '546-561-6426', '651-321-6156', 'cjohnson@apature.labs.org');

--Task � Insert two new records into Customer table
insert into customer(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
    values (60, 'Philup', 'Adams', 'DELL', '1313 MockingBird Line', 'Elwood', 'Ohio', 'USA', 41658, '156-845-6466', '124-514-5614', '12padams@hotmail.com');

insert into customer(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
    values (61, 'Cave', 'Johnson', 'NASA', '123 Testing Avenue', 'Chicogo', 'Calafornia', 'USA', '41815', '546-561-6426', '651-321-6156', 'cjohnson@apature.labs.org');

--2.4 UPDATE
--Task � Update Aaron Mitchell in Customer table to Robert Walter
update customer 
set firstname = 'Robert', lastname = 'Walter'
where lastname = 'Mitchell';

--Task � Update name of artist in the Artist table �Creedence Clearwater Revival� to �CCR�
update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task � Select all invoices with a billing address like �T%�
select * from invoice where billingaddress like 'T%';

--2.6 BETWEEN
--Task � Select all invoices that have a total between 15 and 50
select * from invoice where invoiceid between 15 and 50;

--Task � Select all employees hired between 1st of June 2003 and 1st of March 2004
select * from employee where hiredate between TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') and TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

--2.7 DELETE
--Task � Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).
delete from invoiceline where invoiceid in (select invoiceid from invoice where customerid in (select c.customerid from customer c where customerid = 32));
delete from invoice where customerid in (select c.customerid from customer c where customerid = 32);
delete from customer where customerid = 32;

--3.1 System Defined Functions
--Task � Create a function that returns the current time.


--Task � create a function that returns the length of a mediatype from the mediatype table


--3.2 System Defined Aggregate Functions
--Task � Create a function that returns the average total of all invoices


--Task � Create a function that returns the most expensive track


--3.3 User Defined Functions
--Task � Create a function that returns the average price of invoiceline items in the invoiceline table


--3.4 User Defined Table Valued Functions
--Task � Create a function that returns all employees who are born after 1968.



--4.2
create or replace procedure getManager(
    eid in number, output out varchar2
)
is
begin
    select concat(concat(firstname, ' '), lastname) into output from employee where employeeid in (select reportsto from employee where employeeid = eid);
end;
/

declare
    manager varchar2(100);
begin
    getManager(2, manager);
    DBMS_OUTPUT.PUT_LINE('ID: 2, manager: ' || manager);
end;
/

select manager from dual;