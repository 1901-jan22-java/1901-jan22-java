/*
 * Week 2 Assignment:
 *      SQL WorkBook
 *      Section 7.0 JOINS
 * By: Sanford Zheng
 * Description: In this section you will be working with combing various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
 */

------------------------ 7.1 INNER JOIN ------------------------
-- Task 1 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select c.firstname, c.lastname, i.invoiceid  from customer c
join invoice i on c.customerid = i.customerid;
/
------------------------ 7.2 OUTER JOIN ------------------------
-- Task 1 Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select c.customerid as CustomerID, c.firstname as FirstName, c.lastname as LastName, i.invoiceid as InvoiceID, i.total as Total
from customer c full join invoice i on c.customerid = i.customerid;
/
------------------------ 7.3 RIGHT JOIN ------------------------
-- Task 1 Create a right join that joins album and artist specifying artist name and title.
select art.name as "Artist Name", alb.title as "Album Title"
from artist art right join album alb on art.artistid = alb.artistid;
/
------------------------ 7.4 CROSS JOIN ------------------------
-- Task 1 Create a cross join that joins album and artist and sorts by artist name in ascending order.
select art.name as "Artist Name", alb.title as "Album Title"
from artist art, album alb
order by art.name;
/
------------------------ 7.5 SELF JOIN ------------------------
-- Task 1 Perform a self-join on the employee table, joining on the reportsto column.
select e1.firstname || ' ' || e1.lastname as "Employee", coalease(e2.firstname || ' ' || e2.lastname, null) as "Reports To"
from employee e1, employee e2
where e1.reportsto = e2.employeeid or reportsto is null;

/
------------------------ 7.6 Complicated Join assignment ------------------------
-- Task 1 Create an inner join between all tables in the chinook database.
select * 
from album -- 1
join artist on artist.artistid = album.artistid -- 2
join track on track.albumid = album.albumid -- 3
join playlisttrack on playlisttrack.trackid = track.trackid -- 4
join playlist on playlist.playlistid = playlisttrack.playlistid -- 5
join mediatype on mediatype.mediatypeid = track.mediatypeid -- 6
join invoiceline on invoiceline.trackid = track.trackid -- 7
join invoice on invoice.invoiceid = invoiceline.invoiceid -- 8
join customer on customer.customerid = invoice.customerid -- 9
join genre on genre.genreid = track.genreid -- 10
join employee on employee.employeeid = customer.supportrepid; -- 11
/

/*
 * Week 2 Assignment:
 *      SQL WorkBook
 *      Section 9.0 Administration (ignored)
 * By: Sanford Zheng
 * Description: In this section you will be creating backup files of your database. After you create the backup file you will also restore the database.
 */
 
-- Task 1 Create a .bak file for the Chinook database 
-- something with fileio maybe? googling time!

