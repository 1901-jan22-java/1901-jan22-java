CREATE TABLE ASSOCIATES(
A_ID NUMBER(10) PRIMARY KEY, 
FIRSTNAME VARCHAR2(32) NOT NULL,
LASTNAME VARCHAR2(32) NOT NULL,
EMAIL VARCHAR2(32) UNIQUE NOT NULL,
PASSWORD VARCHAR2(32) NOT NULL,
GRADE NUMBER(5,2) CHECK(GRADE>0)
);

CREATE SEQUENCE A_SEQ;
CREATE OR REPLACE TRIGGER A_TRIGGER
BEFORE INSERT ON ASSOCIATES 
FOR EACH ROW 
BEGIN 
SELECT A_SEQ.NEXTVAL INTO :NEW.A_ID FROM DUAL;
END;

/
insert into associates(firstname, lastname, email, password, grade)
values('AJ', 'Bonds', 'ab@gmail.com', 'pass', 100);
select * From associates;
/
 select a_id from associates where grade = (select max(grade) from associates);
/ 
create or replace function getBestAssociate
  return number
  is 
  grade number(5, 2);
  begin 
   select a_id into grade from associates where grade = (select max(grade) from associates);
  return grade;
  end;
  
  /
  select getbestassociate() from dual;

/
create or replace procedure getAllAssociates(
curParam out sys_refcursor)
is
begin 
open curParam for select * from associates;
end;

/
--testing get all associates
declare 
-- declare variables to actually view whats inside of the cursor
   cur sys_refcursor;
   a_id number(10);
   fn varchar2(50);
   ln varchar2(50);
   email varchar2(50);
   pw varchar2(50);
   grade number(5,2);
 begin
    getAllAssociates(cur);
    LOOP
    fetch cur into a_id, fn, ln, email, pw, grade;
    EXIT WHEN cur%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(fn || ' ' || ln);
  end loop;
  end;

/
create or replace procedure getAssociateById(
curParam out sys_refcursor, aId in number)
is 
begin 
open curParam for select * from associates where a_id = aid;
end;

/ 
-- testing get associate by id 
declare 
-- declare variables to actually view whats inside of the cursor
   cur sys_refcursor;
   a_id number(10);
   fn varchar2(50);
   ln varchar2(50);
   email varchar2(50);
   pw varchar2(50);
   grade number(5,2);
 begin
    getAssociateById(cur, 1);
    fetch cur into a_id, fn, ln, email, pw, grade;
    DBMS_OUTPUT.PUT_LINE(fn);
  end;
  
  /
  commit;