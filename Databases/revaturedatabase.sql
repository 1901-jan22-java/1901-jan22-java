--Revature DB DDL
--DROP TABLE [table name];
--CREATE TABLE [table name] ([info]);
CREATE TABLE Roles(
    RId         number(2)       PRIMARY KEY,        --foreign key to employees
    Title       varchar(30)     NOT NULL UNIQUE
);
CREATE TABLE Employees(
    Empid       number(10)      PRIMARY KEY,
    FirstName   varchar2(50)    NOT NULL,
    LastName    varchar2(50)    NOT NULL,
    Email       varchar2(50)    UNIQUE NOT NULL,
    RoleId      number(2)       NOT NULL,
    FOREIGN KEY (RoleId) REFERENCES Roles(RId)
);
CREATE TABLE Batches(
    BId         number(10)      PRIMARY KEY,
    Trainer     number(10)      NOT NULL,
    Curriculum  varchar2(50)    NOT NULL,
    StartDate   date            ,
    EndDate     date            ,
    FOREIGN KEY (Trainer) REFERENCES Employees(empid)
);
CREATE TABLE ASSOCIATES(
    AId         number(10)      PRIMARY KEY,
    EmpID       number(10)      NOT NULL,
    Batchid     number(10)      NOT NULL,
    Grade       number(3)       NOT NULL,
    Note        varchar2(250)   ,
    FOREIGN KEY (empid) REFERENCES Employees(empid),
    FOREIGN KEY (batchid) REFERENCES Batches(bid)
);

--add values into our lookup table
INSERT INTO Roles(RID, TITLE) VALUES (1, 'Associate');
INSERT INTO Roles VALUES (2, 'Trainer');
INSERT INTO Roles Values (3, 'Recruiter');
INSERT INTO Roles Values (4, 'Sales Rep');

-----TRIGGERS, SEQUENCES-----
/* A sequence in a DB is a set of integers that are generated 
and supported by the DB system itself to support the production of 
unique values on demand.
-a user defined schema bound object that generates a sequence of numeric values
-we will use these more often than not to auto generate a PK value*/
CREATE SEQUENCE EMP_SEQ;
--creating a sequence with the no specified settings will create one as follows
CREATE SEQUENCE  "KEVHO48"."EMP_SEQ"  
MINVALUE        1 
MAXVALUE        9999999999999999999999999999 
INCREMENT BY    1
START WITH      1
CACHE           20 
NOORDER  
NOCYCLE  
NOPARTITION ;

CREATE SEQUENCE A_SEQ;
CREATE SEQUENCE BATCH_SEQ;
CREATE SEQUENCE role_seq;

----TRIGGERS----
/*
A special type of stored procedure that happens automatically when an event occurs in the database
*/
create or replace trigger emp_trig --declare and name trigger
before insert on employees --specify when it will execute
for each row --necessary to change values in rows
begin --start what we want to happen
    select emp_seq.nextval into :new.empid from dual;
end; --end of what we want to happen
/
create or replace trigger batch_trig --declare and name trigger
before insert on batches --specify when it will execute
for each row --necessary to change values in rows
begin --start what we want to happen
    select batch_seq.nextval into :new.bid from dual;
end; --end of what we want to happen
/
create or replace trigger associate_trig --declare and name trigger
before insert on associates --specify when it will execute
for each row --necessary to change values in rows
begin --start what we want to happen
    select a_seq.nextval into :new.aid from dual;
end; --end of what we want to happen
/
create or replace trigger role_trig --declare and name trigger
before insert on roles --specify when it will execute
for each row --necessary to change values in rows
begin --start what we want to happen
    select role_seq.nextval into :new.rid from dual;
end; --end of what we want to happen
/
insert into Roles(Title) values (5, 'Hires');

----DUAL----
/*
Dual is a special one-row one-column table present by default in Oracle (and some other) database installations
it exists for various reasons including being able to select values not associated with a table
*/
select * from dual;
select emp_seq.nextval from dual;
select sysdate from dual;


----DML----
insert into employees(roleid, firstname, lastname, email)
values (2, 'Patrick', 'Jones', 'jones@revature.com');
insert into employees(firstname, lastname, email, roleid)
values ('Malik', 'White', 'mw@revature.com', 1);

update employees
set firstname = 'John'
where empid = 9;

SELECT * FROM ROLES;

----REMEMBER TO COMMIT!
commit;
