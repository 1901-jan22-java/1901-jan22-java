/*
STORED PROCEDURES
- Blocks of code stored in our db as a part of the schema 
- 0 or more IN and OUT parameters 
- can execute full DML and TCL commands 
*/
--CREATE [OR REPLACE] PROCEDURE

CREATE OR REPLACE PROCEDURE helloWorld
AS -- where we would declare any variables. interchangable with IS
BEGIN
  dbms_output.put_line('Hello World!');
END;
/
execute helloWorld;

--- get artist by id procedure 
CREATE OR REPLACE PROCEDURE getArtistById(
  a_id IN NUMBER, -- VarName IN/OUT dataType
  a_name OUT VARCHAR2
)
IS -- AS or IS
BEGIN
  SELECT name INTO a_name 
  FROM artist WHERE artistid = a_id;
END;
/
-- PL/SQL block to execute this procedure 
declare 
  a_name varchar2(100);
begin 
  getArtistByID(2, a_name);
  dbms_output.put_line('ID: 2, Artist: ' || a_name);
end;
/


select * from artist; 

/*
CURSOR 
- In oracle, a cursor is a mechanism by which you can assign 
a name to a select statement and manipulate information within it 

- pointer to a context area, which is what oracle stores the 
results from a query in 

- explicit/implicit cursors
*/

--CURSOR AS A PASS BY REFERENCE EXAMPLE
CREATE OR REPLACE PROCEDURE EMPLOYEE_INFO(JUSTIN_CURSOR OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN JUSTIN_CURSOR FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

--TESTING EXAMPLE 1
DECLARE
  EMPLOYEE_C SYS_REFCURSOR;
  FIRSTNAME VARCHAR2(100);
  LASTNAME VARCHAR2(100);
BEGIN
  EMPLOYEE_INFO(EMPLOYEE_C);
  LOOP
    FETCH EMPLOYEE_C INTO FIRSTNAME, LASTNAME;
    EXIT WHEN EMPLOYEE_C%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(FIRSTNAME || ', ' || LASTNAME);
  END LOOP;
END;
/

CREATE OR REPLACE PROCEDURE getAllArtists(
  cursorParam OUT SYS_REFCURSOR
)
IS 
BEGIN
  open cursorParam for select * from artist;
END;
/

CREATE OR REPLACE PROCEDURE getAllRoles(
  cursorParam OUT SYS_REFCURSOR
)
IS 
BEGIN
  open cursorParam for select * from roles;
END;
/


--TRANSACTIONAL PROCEDURE 
CREATE OR REPLACE PROCEDURE Delete_invoice(
inv_id IN Number)
AS
BEGIN
  -- first delete invoicelines which depend on the invoice 
  DELETE FROM INVOICELINE WHERE INVOICEID = inv_id;
  DELETE FROM INVOICE WHERE INVOICEID = inv_id;
  
  commit;
END;
/


--
select * from invoice where invoiceid = 1;
exec delete_invoice(1);


--write a stored procedure that will insert data into a 
--  table with parameters given 


/*
FUNCTIONS
- blocks of code we can execute that MUST return 1 calue 
- they may take in 0 or more in or out parameters 
- invoke functions using () 
- can only use DQL statements
*/
/
-- get the total number of artists 
CREATE OR REPLACE FUNCTION getNumArtists
  return number 
is -- or AS -- var declarations
  total number;
begin 
  select count(*) into total from artist;
  return total;
end;
/

select getNumArtists() from dual;


--REGULAR RETURN TYPE FUNCTION
CREATE OR REPLACE FUNCTION INVOICELINE_AVG RETURN NUMBER
IS
  AVERAGE NUMBER;
BEGIN
  --FILL VARIABLE WITH QUERY (QUERY INTO VARIABLE)
  SELECT SUM(UNITPRICE)/COUNT(UNITPRICE) INTO AVERAGE FROM INVOICELINE;
  RETURN AVERAGE;
END;
/

--TESTING EXAMPLE 3
SELECT INVOICELINE_AVG FROM DUAL;

--CURSOR RETURN TYPE FUNCTION
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
IS
  EMPLOYEE_C SYS_REFCURSOR;
BEGIN
  OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE >= TO_DATE('01-01-1968','DD-MM-YYYY');
  RETURN EMPLOYEE_C;
END;
/

--TESTING EXAMPLE 4
SELECT AFTER_1968 FROM DUAL;
  
  /*
  An index is a performance-tuning method of allowing faster
  retrieval of records. An index creates an entry for each value
  that appears in the indexed columns
  */
create index artist_name_index 
on artist(name);