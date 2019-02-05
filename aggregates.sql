-- find the number of songs per genre

select genreid, count(trackid)
from track
group by genreid
order by genreid;

select genre.name GENRE , count(track.trackid) "NUM SONGS"
from track 
inner join genre on genre.genreid = track.genreid
group by genre.name
order by genre.name;

--how do we add conditions to functions with aggregate data?
select genre.name GENRE , count(track.trackid) "NUM SONGS"
from track 
inner join genre on genre.genreid = track.genreid 
group by genre.name
HAVING count(track.trackid) > 100
order by genre.name;


select * from genre;