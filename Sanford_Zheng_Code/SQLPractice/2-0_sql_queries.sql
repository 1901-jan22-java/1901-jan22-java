/*
 * Week 2 Assignment:
 *      SQL WorkBook
 *      Section 2.0 SQL Queries
 * 
 * By: Sanford Zheng
 */

------------------------ 2.1 SELECT ------------------------

-- Task 1 - Select all records from Employee
select * from employee;
-- Task 2 - Select all records from Employee table where last name is King
select * from employee where lastname = "King";
-- Task 3 - Select all records from Employee table where first name is Andrew and REPORSTO is NULL.
select * from employee where firstname = "Andrew" and reportsto is null;

----------------------- 2.2 ORDER BY -----------------------

-- Task 1 - Select all albums in Album table and sort resutl set in descending order by title.
select * from album order by title desc;
-- Task 2 - Select first name from Customer and sort result set in ascending order by city
select customer.firstname, customer.city from customer order by city;

---------------------- 2.3 INSERT INTO ---------------------

-- Task 1 - Insert two new records into Genre table
insert into genre values(26, 'K-Pop');
insert into genre values(27, 'J-Pop');
select * from genre;

-- Task 2 - Insert two new records into Employee table
insert into employee values(
    9,
    'Dumbledore',
    'Albus',
    'Headmaster',
    null,
    null,
    null,
    'Hogwarts',
    'London',
    null,
    'United Kingdom',
    null,
    null,
    null,
    'albus.dumbledore@faculty.hogwarts.com'
);
insert into employee values(
    10,
    'Snape',
    'Severus',
    'Potions Master',
    null,
    null,
    null,
    'Hogwarts',
    'London',
    null,
    'United Kingdom',
    null,
    null,
    null,
    'severus.snape@faculty.hogwarts.com'
);
select * from employee order by employeeid;

-- Task 3 - Insert two new records into Customer table
insert into customer values(
    60,
    'Tom',
    'Riddle',
    'Death Eaters',
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    'hewhoshallnotbenamed@deatheater.com',
    null
);
insert into customer values(
    61,
    'Harry',
    'Potter',
    'Dumbledore''s Army ',
    'Privet Drive',
    'London',
    null,
    'United Kingdom',
    null,
    null,
    null,
    'theboywholived@hogwarts.com',
    null
);
select * from customer;



------------------------ 2.4 UPDATE ------------------------

-- Task 1 - Update Aaron Mitchell in Customer table to Robert Walter
select * from customer where firstname = 'Aaron';

update customer
    set firstname = 'Robert', lastname = 'Walter'
where
    firstname = 'Aaron' and
    lastname = 'Mitchell';
    
select * from customer where customerid = 32;

-- Task 2 - Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
select * from artist where name = 'Creedence Clearwater Revival';
update artist set
    name = 'CCR'
where
    name = 'Creedence Clearwater Revival';
select * from artist where artistid = 76;



------------------------- 2.4 LIKE -------------------------

-- Task 1 - Select all invoices with billing address like "T%"
select * from invoice where billingaddress like 'T%';




----------------------- 2.6 BETWEEN ------------------------

-- Task 1 - Select all invoices that have a total between 15 and 50
select * from invoice where total between 15 and 50;
-- Task 2 - Select all employees hired between 1 of June 2003 and 1 of March 2004
select * from employee order by hiredate;
select * from employee where hiredate between '01-JUN-03' and '01-MAR-4';


------------------------ 2.7 DELETE ------------------------

-- Task 1 Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
select * from customer where firstname = 'Robert';
select * from invoice where customerid = 32;
-- Triggers made in different files
delete from customer where firstname = 'Robert' and lastname = 'Walter';
