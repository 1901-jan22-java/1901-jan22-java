--SELECT
select*from artist;
select name from artist;
select name from artist order by name desc;

--SELECT with clauses
select*from artist where artistid < 10;
select*from artist where artistid BETWEEN 5 AND 15; --inclusive
select*from artist where artistid <100 AND name like 'T%';

--Using system defined functions
/*
Scalar functions - functions that operate on single values ie upper(), lower()
aggregate functions - functions that operate on multiple rows of data - min(), max()

*/

select*from artist order by length(name);
select * from artist where lower(name) like '%z%';

select count(*) from artist;
select count(*) AS INVOICES, count(billingstate) AS STATES from invoice;

/*
Subqueries AKA nested queries
*/

-- subquery setting outer where clause to euqal singular outcoem of inner query

select*from album where artistid = 
(select artistid from artist where name = 'Aerosmith');

--but what if the inner query returns more than one row
select*from album where artistid IN (
select artistid from artist where name LIKE 'A%');
--IN is used as select where this value is IN the set returned 

/*
VIEWS

"virtual tables" that allow us to store a query as an object in our database
we cannot I/U/D in views multiple tables but we can view them
*/

create view m_artists as
select*from artist where name like 'M%' OR name like 'A%';

select*from m_artists;

create view album_view as
select* from album where albumid < 50;

select * from album_view;


-----JOINS --------

--INNER JOIN
SELECT album.title, artist.name
from album
join artits -- if no join type is specified, the default is inner join
on album.artist.artistid = artist.artistid; --equijoin meaning the relationship that we are joining upon is the equality between two values

select al.title AS Album, art.name AS Artist
from album_view al
full outer join m_artists art
on al.artistid = art.ARTISTID;

select*from track;

-- Natural join - where Oracel attempts to match columns based on names
select*from artist natural join album;

-- Cross join - cartestian product of two tables
select al.title, art.name
from album al, artist art;





-- joining more than two tables
select track.name, album.title, artist.name
from track
join album on track.albumid = album.albumid
join artist on artist.artistid = album.artistid;

select employee.firstname as Employee, customer.firstname as Customer, invoice.invoiceid as Invoice,
invoiceline.unitprice as Price, track.name as Track, album.title as Album, artist.name as Artist, genre.name as Genre,
mediatype.name as Media, playlisttrack.playlistid as PlaylistID, playlist.name as Playlist
from employee
join customer on employee.employeeid = customer.supportrepid
join INVOICE on customer.customerid = invoice.customerid
join invoiceline on INVOICE.INVOICEID = invoiceline.invoiceid
join track on invoiceline.trackid = track.trackid
join album on track.albumid = album.ALBUMID
join artist on album.artistid = artist.artistid
join genre on track.genreid = genre.genreid
join mediatype on track.MEDIATYPEID = mediatype.MEDIATYPEID
join playlisttrack on track.trackid = playlisttrack.trackid
join playlist on playlisttrack.playlistid = playlist.playlistid;

select*from employee;

select e1.lastname AS manager, e2.lastname as EMPLOYEE
from employee e1
full outer join employee e2
on e1.employeeid = e2.reportsto;

-----SET OPERATORS -------
select*from employee;

select*from employee where title LIKE 'S%' minus
select*from employee where employeeid > 4;

---find the number of songs per genre -- ex of HAVING

select genreid, count(trackid)
from track
group by genreid; -- shows genreid not genre name

select genre.name GENRE, count(track.trackid) "NUM SONGS"
from track
inner join genre on genre.genreid = track.genreid
group by genre.name
order by genre.name;






