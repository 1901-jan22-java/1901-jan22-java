

create or replace procedure helloworld
as
begin
 dbms_output.put_line('hello world');
end;
/

execute helloworld;

select title as "album Title" from album;


--plsql

declare 
    a_name varchar2(100);
begin
    getartistid(2, a_name);
    DBMS_OUTPUT.PUT_LINE('ID: 2, artist: ' || a_name);
end;
/

--artist id procedure
create or replace procedure getArtistID(
    a_id in number, 
    a_name out varchar2
)
as
begin
    select name into a_name 
    from artist where artistid = a_id;
end;
/





create or replace procedure getAllArtist(
    cursorParam out SYS_REFCURSOR
)
as
begin
    open cursorparam for select * from artist;
end;
/


---------Transactional procedure


create or replace procedure Delect_invoice(
    inv_id in number
)
as
begin
    delete from invoiceline where invoiceid = inv_id;
    delete from invoice where invoiceid = inv_id;
    commit;
end;
/

select * from invoice where invoiceid = 1;

execute delect_invoice(1);






create or replace function getNumArtists
return number 
as
total number;
begin
    select count(*) into total from artist;
    return total;
end;
/



select getNumArtists() from dual;


create or replace procedure setNewArtist(
    a_id in number, 
    a_name in varchar2
)
as
begin
    insert into artist(artistID, name) VALUES (a_id, a_name);
end;
/

execute setNewArtist(276, 'crush 40');


create or replace function getLastArtist
return varchar2 
as
a_name varchar2(100);
begin
    select name into a_name from artist where artistid in (select count(artistid) from artist);
    return a_name;
end;
/
/
