/*
Zachary Borodin Week 2 Assignment- SQL Workbook
*/

---2.1 Select
-- Task-select all records from the Employee table
select * from employee;

--Task – Select all records from the Employee table where last name is King.
select * from employee where lastname = 'King';

--TaskTask – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
select * from employee where firstname = 'Andrew' and reportsto is null;


--2.2 Order by
--Task – Select all albums in Album table and sort result set in descending order by title.
select * from album order by title desc;

--Task – Select first name from Customer and sort result set in ascending order by city
select * from customer order by city asc;


--2.3 Insert into
-- Task – Insert two new records into Genre table 
select * from genre;
insert into genre values(26,'test1');
insert into genre values(27,'test2');
commit;

--Task – Insert two new records into Employee table 
select * from employee;
insert into employee values(9,'Zach','Borodin','Associate',1,
'23-nov-95','22-jan-19','address','malverne','ny','usa','11565','5166689420','fax','zbroda@aol.com');

insert into employee values(10,'FN','LN','title',2,'1-jan-90','2-dec-90','add','city','ny','usa','11111','1234567890','fax','email');


--Task – Insert two new records into Customer table 
select * from customer;
insert into customer values(60,'z','b','rev','addres','malverne','ny','usa','11565','phone',null,'email',1);
insert into customer values(61,'a','b','app','addres','malverne','ny','usa','11565','phone',null,'email',1);


--2.3 update
--Task – Update Aaron Mitchell in Customer table to Robert Walter 
select * from customer where firstname = 'Robert';
update customer
set firstname = 'Robert', lastname = 'Walter'
where firstname = 'Aaron' and lastname = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR” 
select * from artist where name like 'C%';

update artist
set name = 'CCR'
where name = 'Creedence Clearwater Revival';

select * from artist where name = 'CCR';


--2.5 Like
--Task  – Select all invoices with a billing address like “T%” 
select * from invoice where billingaddress like 'T%';


--2.6 Between
--Task – Select all invoices that have a total between 15 and 50 
select * from invoice where total >15 and total < 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004 
select * from employee;
select * from employee where hiredate > '1-jun-03' and hiredate < '1-mar-04';


--2.7 Delete
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them). 
select * from customer where firstname = 'Robert';
update customer
 set lastname = 'Walter'
 where lastname = 'Walker';
delete from invoiceline where invoiceid = (select invoiceid from invoice where customerid =(select customerid from customer where firstname = 'Robert' and lastname = 'Walter'));
delete from invoice where customerid = (select customerid from customer where firstname = 'Robert' and lastname = 'Walter');
delete from customer where customerid = (select customerid from customer where firstname = 'Robert' and lastname = 'Walter');


--3.1 System defined functions
--Task – Create a function that returns the current time.
create or replace function getCurrTime
return timestamp
is 
 total timestamp;
 
 begin
  select localtimestamp into total from dual;
  return total;
 end;
 /
 select getCurrTime() from dual;
 
 --Task – create a function that returns the length of a mediatype from the mediatype table 
--will return the length of the name of a mediatype given its id
create or replace function getlengthMediaType(
 mtid in number
 )
 return number
 
 is 
  mtname varchar2(50);
  total number;
  
  begin
   
   select name into mtname from mediatype where mediatypeid = mtid ;
   select length(mtname) into total from dual;
   return total;
 end;
 /
 select * from mediatype;
 select getlengthMediaType(2) from dual;
 
 select name from mediatype where  mediatypeid = 2;
 
 
 --3.2 System Defined Aggregate Functions
 --Task – Create a function that returns the average total of all invoices
 
create or replace function getAvgInvoices
 return number
 is 
  average number;
  
  begin
   select AVG(total) into  average from invoice;
   return average;
 end;
 /
 
 select getAvgInvoices() from dual;
 
 
 --Task – Create a function that returns the most expensive track 
create or replace function getMaxInvoices
 return number
 is 
  MaxInv number;
  
  begin
   select MAX(total) into  MaxInv from invoice;
   return MaxInv;
 end;
 /
 select getMaxInvoices() from dual;
 
 
 
 --3.3 user defined functions
 --Task – Create a function that returns the average price of invoiceline items in the invoiceline table 
 /
 create or replace function avginvoiceline
 return number
 is
 avginvl number;
 begin
  select AVG(total) into avginvl from(
   --joins the two tables so we have the total for every element in invoiceline
   select invoiceline.invoiceid, invoice.total from invoiceline 
   left outer join  invoice on invoiceline.invoiceid = invoice.invoiceid) ;
  
  return avginvl;
 end;
 /
 select avginvoiceline() from dual;
 
 
 --3.4 User defined table valued functions
 --Task – Create a function that returns all employees who are born after 1968. 
 /
 --gets employees after jan 1st 1968
 create or replace function empafter
 return sys_refcursor
 as
 temp sys_refcursor;
 begin
     open temp for
     select firstname,lastname,birthdate from employee where birthdate > '01-JAN-68' order by birthdate;
     return temp;
 end;
 /
select empafter() from dual;
 
 
 --Stored Procedures
 
 --4.1 Basic Stored Procedure
 --Task – Create a stored procedure that selects the first and last names of all the employees
 /
 create or replace procedure gettempnames(temp out sys_refcursor)
 is
 begin
 open temp for
 select firstname,lastname from employee;
 end;
/



--4.2 Stored procedure input parameters
--Task – Create a stored procedure that updates the personal information of an employee. 
/
create or replace procedure updatename(eid in number,newfn in varchar2,newln in varchar2)
is
begin
update employee
set firstname = newfn, lastname = newln
where employeeid = eid;
commit;
end;
/
select * from employee;
execute updatename(9,'Zach','Borodin');

--Task – Create a stored procedure that returns the managers of an employee. 
/
create or replace procedure mangofemp(eid in number)
is
begin
select firstname,lastname from employee where employeeid =
    (select reportsto from employee where employeeid = eid);
end;
/

select firstname,lastname from employee where employeeid =
    (select reportsto from employee where employeeid = 9);

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer. 
/
create or replace procedure getCusNameComp(CusID in number)
is
begin
select firstname,lastname,company from customer
    where customerid = cusID into outtable;
end;
/
 
 
 --5.0 Transactions
 --Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them)
 /
 create or replace procedure delInvoice(invid in number)
 is
 begin
    delete from invoiceline where invoiceid = invid;
    delete from invoice where invoiceid= invid;
    commit;
 end;
 /
 select * from invoice;
execute delInvoice(216);

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
/
create or replace procedure addCus(cid in number,fn in varchar2,ln in varchar2,email in varchar2)
is
begin
 insert into customer(customerid,firstname,lastname,email) values(cid,fn,ln,email);
 commit;
end;
/
select * from customer;
execute addCus(62,'z','z','email');

--6.0 Triggers
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
/
create or replace trigger emp2_trig 
after insert on employee
for each row 
begin
 --do something   
end; 
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table 
/
create or replace trigger album_trig 
after update on album
for each row 
begin
 --do something   
end; 
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
/
create or replace trigger customer_trig 
after delete on customer
for each row 
begin
 --do something   
end; 
/

--7.0 Joins

--7.1 Inner joins
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
/
select customer.firstname,customer.lastname,invoice.invoiceid
from customer
inner join  invoice on customer.customerid = invoice.customerid;
/

--7.2 Outer Join
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total. 
select customer.customerid,customer.firstname,customer.lastname,invoice.invoiceid,invoice.total
from customer
join invoice on customer.customerid = invoice.customerid;

--7.3 right join
--Task – Create a right join that joins album and artist specifying artist name and title.
select album.title,artist.name
from album
right join artist on  album.artistid = artist.artistid;


--7.4 Cross join
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select *
from album
cross join artist
order by artist.name ASC;


--7.5 Self join
--Task – Perform a self-join on the employee table, joining on the reportsto column. 
/
select a.employeeid as emp1, a.reportsto
from employee a, employee b
where a.reportsto = b.reportsto
order by a.reportsto;
/

--7.6
--Create an inner join between all tables in the chinook database
select album.title,artist.name,customer.state,employee.title,genre.name,invoice.total,invoiceline.unitprice,mediatype.name,playlist.name,playlisttrack.playlistid,track.name
from invoiceline
inner join invoice on invoiceline.invoiceid = invoice.invoiceid
inner join customer on invoice.customerid = customer.customerid
inner join employee on customer.supportrepid = employee.employeeid
inner join track on invoiceline.trackid = track.trackid
inner join genre on track.genreid = genre.genreid
inner join mediatype on track.mediatypeid = mediatype.mediatypeid
inner join album on track.albumid = album.albumid
inner join playlisttrack on track.trackid = playlisttrack.trackid
inner join playlist on playlisttrack.playlistid = playlist.playlistid
inner join artist on album.artistid = artist.artistid