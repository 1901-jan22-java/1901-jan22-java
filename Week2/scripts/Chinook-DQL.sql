-- SELECT 
select * from artist;
select name from artist;
select name from artist order by name desc; -- sort by column 

-- SELECT with clauses 
select * from artist where artistid < 10;
select * from artist where artistid BETWEEN 5 AND 15; --inclusive 
select * from artist where artistid < 100 AND name like 'T%';

--Using system defined functions 
/*
Scalar functions - functions that operate on single values ie upper(), lower(), length()
Aggregate functions - functions that operate on multiple rows of data - min(), max(), count()
*/
select * from artist order by length(name);
select * from artist where lower(name) like '%z%';

select count(*) from artist;

select count(*) AS "INVOICE COUNT", count(billingstate) AS STATES from invoice;
select * from invoice;



/*********
Subqueries AKA nested queries
*********/

select * from artist;

select * from album;

--subquery setting outer where clause to equal singular outcome of inner query
select * from album where artistid = 
(select artistid from artist where name = 'Aerosmith');

--but what if the inner query returns more than one row!?
select * from album where artistid IN (
select artistid from artist where name LIKE 'A%');
--IN is used as select where this value is IN the set returned

/**********************
VIEWS -
"virtual tables" that allow us to store a query as an object 
in our database 
cannot I/U/D in views that use multiple tables but we can view them
*/

create view m_artists as
select * from artist where name like 'M%' OR name like 'A%';

select * from m_artists;

create view album_view as
select * from album where albumid < 50;

select * from album_view;
----------------JOINS--------------------------


select album.title, artist.name 
from album 
join artist -- if no join type is specified, the default is inner join
on album.artistid = artist.artistid; --equi join meaning the relationship that we are joining upon is the equality between two values and not > <, etc

select al.title AS Album, art.name AS Artist 
from album_view al
right join m_artists art
on al.artistid = art.artistid;


select * from track;

--Natural join - where Oracle attempts to match columns based on names
select * from artist natural join album;

-- Cross join - cartesian product of two tables 
select al.title, art.name 
from album al, artist art;

--joining more than two tables
select track.name, album.title, artist.name 
from track 
join album on track.albumid = album.albumid 
join artist on artist.artistid = album.artistid;






----------------- FUN QUERIES
-- find # of tracks of each genre. alphabetize by genre
select g.name ,  g.genreid, count(t.trackid)
from track t
inner join genre g
on g.genreid = t.genreid
group by g.name, g.genreid
order by g.name;

-- find longest song in each genre
select g.name , max(t.milliseconds)/1000 as "Longest Song(s)"
from track t
inner join genre g
on g.genreid = t.genreid
group by g.name
order by g.name;



--Select from a join
select count(albumid) as "# of Albums", name
from 
      (select album.albumid, artist.artistid, artist.name 
      from album 
      join artist 
      on album.artistid = artist.artistid)
  where artistid > 5
  group by name
  having count(albumid) > 1
  order by "# of Albums";
  
  --VIEWS - virtual tables
  -- essentially saved queries. cannot update table via views
  create view Al_Art_View as
   select album.albumid as album , artist.artistid as artist, artist.name 
      from album 
      join artist 
      on album.artistid = artist.artistid;
      
select count(album) as "# of Albums", name
from al_art_view
  where artist > 5
  group by name
  having count(album) > 1
  order by "# of Albums";


  select * from al_art_view;
  drop view al_art_view;
