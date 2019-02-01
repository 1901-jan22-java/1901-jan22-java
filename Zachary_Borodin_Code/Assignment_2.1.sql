/*
Zachary Borodin

*/

-- Task 1: write a stored procedure that will insert data into a table with parameters
-- inserts an entry into artist with the inputted id and name
/
create or replace procedure insertartist(
 inid number,
 artname in varchar2
 )
 as
 begin
     insert into artist(artistid,name) values(inid,artname);
     commit;
end;
/


--Task 2 make a function that does something
--A function that returns the number of almbums an inputted band name has
/
 create or replace function CountAlbumFromArtname(
  aname in varchar2)
  return number
  is
  total number;
  begin
  select count(*) into total from album where artistid = (select artistid from artist where name = aname);
  return total;
 end;
 /
 
 select CountAlbumFromArtname('Metallica') from dual;
 
