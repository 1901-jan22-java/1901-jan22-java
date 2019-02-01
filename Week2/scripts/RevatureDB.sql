-- Revature DB DDL

--CREATE TABLE [table name]([info]);
DROP TABLE ROLES;

CREATE TABLE Roles(
  RId number(2) PRIMARY KEY,
  Title varchar(30) NOT NULL UNIQUE
);
CREATE TABLE Employees (
  EmpId number(10) PRIMARY KEY,
  FirstName varchar2(50) NOT NULL,
  LastName varchar2(50) NOT NULL,
  Email varchar2(50) UNIQUE NOT NULL,
  RoleId number(2) NOT NULL,
  FOREIGN KEY (RoleId) REFERENCES Roles(RId)
);

CREATE TABLE Batches(
  BId number(10) PRIMARY KEY, 
  Trainer number(10) NOT NULL, -- FK
  Curriculum varchar2(50) NOT NULL,
  StartDate Date,
  EndDate Date, 
  FOREIGN KEY (Trainer) references Employees(empid)
);

CREATE TABLE Associates(
  AId number(10) PRIMARY KEY,
  EmpId number(10) NOT NULL,
  BatchId number(10) NOT NULL,
  Grade number(3) NOT NULL,
  Note varchar2(250),
  FOREIGN KEY(empid) REFERENCES EMPLOYEES(empid),
  FOREIGN KEY(batchid) REFERENCES Batches(bid)
);

select * from roles;

-- add values to our lookup table 
insert into Roles values(99, 'adding role');
insert into Roles values(4, 'Sales Rep');

update Roles 
set title = 'HR Representative'
where rid = 5;

select r_seq.nextval from dual;
select max(rid) from roles;

------------------- TRIGGERS , SEQUENCES 
/*  a sequence in a DB is a set of integers that are generated and 
supported by the DB system itself to support the production of 
unique values on demand 
- A user defined schema bound object that generates a sequence 
of numeric values 
- we will use these more often than not to auto generate a PK value
*/
CREATE SEQUENCE R_SEQ;

-- creating a sequence with the no specified settings will create one as follows
CREATE SEQUENCE  "DEMO1901JAN22RDS"."EMP_SEQ"  
MINVALUE 1 
MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 
START WITH 1 
CACHE 20 
NOORDER  
NOCYCLE 
NOPARTITION ;

drop sequence trainer_seq;
CREATE SEQUENCE A_SEQ;
CREATE SEQUENCE BATCH_SEQ;

/* TRIGGERS
A trigger is a special type of stored procedure that happens 
automatically when an event occurs in the database 
*/
CREATE OR REPLACE TRIGGER r_trig -- declare and name trigger
BEFORE INSERT ON Roles -- specify when it will execute
FOR EACH ROW -- necessary to change values in rows 
BEGIN -- start what we want to happen
  select r_seq.nextval into :new.rid from dual;      
END; -- end of what we want to happen 
/

------ DUAL
/*
Dual is a special one-row, one-column table present by 
default in Oracle (and some other) database installations
It exists for various reasons including being able to select 
values not associated with a table
*/
select * from dual;
select emp_seq.nextval from dual;
select SYSDATE from dual;


-------------- DML
select * from employees;

insert into employees( firstname, lastname, email, roleid)
values('Malik', 'White', 'mw@gmail.com', 1);

update employees 
set firstname = 'John'
where empid = 9;

select * from roles;

----- REMEMBER TO COMMIT!
commit;

