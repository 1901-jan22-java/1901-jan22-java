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


