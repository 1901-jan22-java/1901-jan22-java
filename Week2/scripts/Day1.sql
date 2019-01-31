/*SubQueries, Nested Queries
*/

SELECT * FROM artist;

SELECT * FROM album;

--subquery setting outer where clause to equal singular outcome and inner query 
SELECT * FROM album WHERE artistid =
(SELECT artistid FROM artist WHERE NAME = 'Aerosmith');

--but what if the inner query returns more than one row?
SELECT * FROM album WHERE artistid IN(
SELECT artistid FROM artist WHERE NAME LIKE 'A%');

--IN is used as select where this value is IN the set returned

/*VIEWS - virtual tables that allow us to store a query as an object in our DB
Cannot Insert, Update, Delete in views that use multiple tabeles, but we can view them
*/

CREATE VIEW m_artists
AS 
SELECT * FROM artist
WHERE NAME LIKE 'M%' OR NAME LIKE 'A%';

SELECT * FROM m_artists;

CREATE VIEW album_view AS
SELECT * FROM album
WHERE albumid < 50;

SELECT * FROM album_view;
-----------Joins---------------
SELECT album.title, artist.name
FROM album
JOIN artist -- If not join type specified, default is INNER
ON album.artistid = artist.artistid;

--Join with views

SELECT al.title AS Album, art.name AS Artist
FROM album_view al
FULL OUTER JOIN m_artists art
ON al.artistid = art.artistid;

SELECT track.name, album.title, artist.name
FROM track
JOIN album ON track.albumid = album.albumid
JOIN artist ON artist.artistid = album.artistid;
