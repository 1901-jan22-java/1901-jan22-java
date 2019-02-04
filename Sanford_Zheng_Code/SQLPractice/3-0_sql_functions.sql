/*
 * Week 2 Assignment:
 *      SQL WorkBook
 *      Section 3.0 SQL Functions
 * By: Sanford Zheng
 * Description: In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
 */

------------------------ 3.1 System Defined Functions -------------------------
-- Task 1 - Create a function that returns the current time.
create or replace function curr_time return timestamp
is
begin
    return current_timestamp();
end;
/
-- Task 2 - Create a function that returns the length of a mediatype from the mediatype table
create or replace function count_mediatype return number
is
    total number;
begin
    select count(*) into total from mediatype;
    return total;
end;
/



------------------ 3.2 System Defined Aggregate Functions ---------------------
-- Task 1 Create a function that returns the average total of all invoices
create or replace function avg_total_invoice return number
is
    average number;
begin
    select avg(total) into average from invoice;
    return average;
end;
/
-- Task 2 Create a function that returns the most expensive track
create or replace function most_expensive_track return number
is
    most_expensive number;
begin
    select max(unitprice) into most_expensive from track;
    return most_expensive;
end;
/


------------------------- 3.3 User Defined Functions --------------------------
-- Task 1 Create a function that returns the average price of invoiceline items in the invoiceline table
create or replace function avg_price_invoiceline return number
is
    average number;
    total number := 0;
    num_il number := 0;
begin
    for il in (select * from invoiceline)
    loop
        total := total + il.unitprice;
        num_il := num_il + 1;
    end loop;
    average := total / num_il;
    return average;
end;
/
------------------- 3.4 User Defined Table Valued Functions -------------------
-- Task 1 Create a function that returns all employees who are born after 1968.

create or replace type employee_r is object (
    EmployeeId NUMBER,
    LastName VARCHAR2(20),
    FirstName VARCHAR2(20),
    Title VARCHAR2(30),
    ReportsTo NUMBER,
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60)
);
/
create or replace type employee_t is table of employee_r; -- index by BINARY_INTEGER;
--create or replace type employee_t as table of employee%rowtype index by binary_integer;
/
create or replace function after_1968 return employee_t
is
    born employee_t;
begin
    select * bulk collect into born from employee where birthdate > '19680101';
    return born;
end;
/
declare
    curs sys_refcursor;
begin
    select * from after_1968;
end;
/

