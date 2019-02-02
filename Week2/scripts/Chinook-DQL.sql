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
*/

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
  

  --Set operators--
--Union all = A + B
SELECT * FROM employee WHERE title LIKE 'S%' UNION
SELECT * FROM employee WHERE employeeid > 4;

-- STORED PROCEDURES
--Compile procedure
CREATE OR REPLACE PROCEDURE helloWorld
AS -- would declare any variables
BEGIN
dbms_output.put_line('Hello World');
END;
-- execute
execute helloWorld;

-- get artist by id procedure
CREATE OR REPLACE PROCEDURE getArtistById (
a_id IN NUMBER, --Variable name IN/OUT datatype
a_name OUT VARCHAR2
)
IS -- AS or IS
BEGIN
SELECT name INTO a_name
FROM artist WHERE artistid = a_id;
END;

declare
a_name VARCHAR2(100);
begin
getArtistById(50, a_name);
dbms_output.put_line('ID: 50, Artist: '|| a_name);
END;

-- Cursor is a mechanism by which you can assign a name
-- a select statement and manipulate information from within it

-- pointer to a context area which is what oracle stores the results 
-- from a query in

-- explicit/implicit cursors
/
CREATE OR REPLACE PROCEDURE getAllArtists(
cursorParam OUT SYS_REFCURSOR
)
IS
BEGIN
OPEN cursorParam FOR SELECT * FROM artist;
END;
/

--Transactional procedure
CREATE OR REPLACE PROCEDURE Delete_invoice(
inv_id IN NUMBER)
AS
BEGIN
 --first delete invoice lines which depend on the invoice
 DELETE FROM invoiceline WHERE invoiceid = inv_id;
 DELETE FROM invoice WHERE invoiceid = inv_id;
 
 commit;
END;
/

SELECT * FROM invoice WHERE invoiceid = 1;
EXECUTE delete_invoice(1);

-- write a stores procedure that will insert data 
-- into a table with parameters given

-- FUNCTIONS
-- blocks of code we can execute that must return 1 value
-- they may take in 0 or more in or out parameters
-- invoke functions using ()
-- can only use DQL statements

CREATE OR REPLACE FUNCTION getNumArtist
 RETURN NUMBER
 IS
 total NUMBER;
 BEGIN
 SELECT count(*) INTO total FROM artist;
 RETURN total;
 END;
 /
 
 SELECT getNumArtist() FROM Dual;
 
 
 