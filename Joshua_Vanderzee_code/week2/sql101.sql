-- select 
select * from artist
select name from artist
select name from artist
select name from artist order by name desc

select name from artist where artistid < 10
select name from artist where between 5 and 15
select name from artist where artistid < 100 and name like 't%'

select * from artist order by length(name);
select * from artist where lower(name) like '%z%'

select count(*) from artist;
select count(*) as invoice, count(invoice.billingstate) as states from invoice;

select * from artist where 

select * from album where artistid in (select artistid from artist where name like 'A%');

/**************************************
virtual tables that allow us to store a query.
*/

create view m_artist as select * from artist where name like 'M%' or name like 'A%';

select * from m_artist;

create view album_view as select * from album where albumid < 50;

select * from album_view;


------------------Joins-------------------------------

select b.title, a.name from album b join artist a on a.artistid = b.artistid

select b.title, a.name from album b inner join artist a on a.artistid = b.artistid where a.name = 'Aerosmith';

select b.title as album, a.name as artist from album_view b inner join m_artist a on a.artistid = b.artistid;

select b.title as album, a.name as artist from album_view b left join m_artist a on a.artistid = b.artistid;

select b.title as album, a.name as artist from album_view b full outer join m_artist a on a.artistid = b.artistid;

select * from track;

select t.name, b.title, a.name from track t 
join album b on t.albumid = b.albumid 
join artist a on a.artistid = b.artistid;



-- task 1 join all 11 tables

select distinct c.firstname as "First Name", c.lastname as "Last Name", c.email as Email, concat(concat(e.firstname, ' '), e.lastname) as "Support Representitive Name", il.unitprice as "Unit Price", il.quantity as Quantity, i.total as "Total Price", b.title as Album, a.name as Artist, t.composer as Composer, t.name as Track, g.name as Genre, m.name as Media, p.name
from track t 
inner join album b on t.albumid = b.albumid 
inner join artist a on a.artistid = b.artistid
inner join genre g on t.genreid = g.genreid
inner join mediatype m on m.mediatypeid = t.mediatypeid
inner join playlisttrack pt on pt.trackid = t.trackid
inner join playlist p on p.playlistid = pt.playlistid
inner join invoiceline il on il.trackid = t.trackid
inner join invoice i on i.invoiceid = il.invoiceid
inner join customer c on c.customerid = i.customerid
inner join employee e on e.employeeid = c.supportrepid
order by c.lastname;

-- task 2 list the number of tracks in each genre, and alphabetize by genre
select t.composer as Composer, t.name as Track, g.name as Genre
from track t 
inner join genre g on t.genreid = g.genreid;
order by g.name;
