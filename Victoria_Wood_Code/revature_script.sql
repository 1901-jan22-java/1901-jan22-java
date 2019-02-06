--Revature DB DDL

CREATE TABLE Employees
(
  EmployeeId NUMBER NOT NULL,
  FirstName VARCHAR2(40) NOT NULL,
  LastName VARCHAR2(40) NOT NULL,
  Email VARCHAR2(60) NOT NULL,
  RoleId NUMBER NOT NULL,
  CONSTRAINT PK_Employees PRIMARY KEY (EmployeeId)

);


drop table associate;

CREATE TABLE Associate
(
  AssociateId NUMBER PRIMARY KEY,
  FirstName VARCHAR2(20) NOT NULL,
  LastName VARCHAR2(20) NOT NULL,
  Email VARCHAR2(60) UNIQUE NOT NULL,
  Password VARCHAR2(20) NOT NULL,
  Grade NUMBER NOT NULL,
  AdminUser Number constraint bool check(adminuser = 0 or adminuser = 1)
  
);

CREATE TABLE Batches
(
  BatchId NUMBER NOT NULL,
  StartDate DATE NOT NULL,
  EndDate DATE NOT NULL,
  Curriculum VARCHAR2(40),
  TrainerId NUMBER,
  CONSTRAINT PK_Batch PRIMARY KEY (BatchId)

);

CREATE TABLE Role
(
  RoleId NUMBER NOT NULL,
  Name VARCHAR2(20) NOT NULL,  
  CONSTRAINT PK_Role PRIMARY KEY (RoleId)

);

ALTER TABLE Employees ADD CONSTRAINT FK_EmployeeRole
  FOREIGN KEY (RoleId) REFERENCES Role (RoleId);
  
ALTER TABLE Associate ADD CONSTRAINT FK_AssociateEmployeeId
  FOREIGN KEY (EmployeeId) REFERENCES Employees (EmployeeId);
  
ALTER TABLE Associate ADD CONSTRAINT FK_AssociateBatchId
  FOREIGN KEY (BatchId) REFERENCES Batches (BatchId);
  
ALTER TABLE Batches ADD CONSTRAINT FK_BatchTrainer
  FOREIGN KEY (TrainerId) REFERENCES Employees (EmployeeId);
  
 
INSERT INTO Employees (EMPLOYEEID, FIRSTNAME, LASTNAME, EMAIL, ROLEID) VALUES (1, 'Victoria', 'Wood', 'vwood@gmail.com', 2);
INSERT INTO Employees (EMPLOYEEID, FIRSTNAME, LASTNAME, EMAIL, ROLEID) VALUES (2, 'John', 'Smith', 'jsmith@revature.com', 1);
INSERT INTO Employees (EMPLOYEEID, FIRSTNAME, LASTNAME, EMAIL, ROLEID) VALUES (3, 'Alleyha', 'Dannett', 'adannett@revature.com',3);

INSERT INTO Employees (FIRSTNAME, LASTNAME, EMAIL, ROLEID) VALUES ('Genesis', 'Bonds', 'g.bonds@revature.com',2);

INSERT INTO Role (ROLEID, NAME) VALUES (1, 'Trainer');
INSERT INTO Role (ROLEID, NAME) VALUES (2, 'Associate');
INSERT INTO Role (ROLEID, NAME) VALUES (3, 'HR');

SELECT*FROM employees;

SELECT employees.firstname as Employee, role.name as Role
from Employees
join Role on employees.roleid = role.roleid;


------TRIGGERS, SEQUENCES
/* a sequence in a DB is a set of integers that are generated and supported by the 
DB system itself to support the production of unique values on demand

A user defined schema bound object that generates a sequence of numeric values

we will use these more often than not to autogenerate a PK value
*/

CREATE SEQUENCE EMP_SEQ;

CREATE SEQUENCE ASSOCIATE_SEQ;
CREATE SEQUENCE BATCH_SEQ;
CREATE SEQUENCE ROLE_SEQ;



/* TRIGGERS
A trigger is a special type of stored procedure that happens automatically
when an event occurs in the database
*/

CREATE OR REPLACE TRIGGER Emp_trig --declare and name trigger
BEFORE INSERT ON Employees --specify when it will execute
FOR EACH ROW --necessary to change values in rows
BEGIN -- start what we want to happen
  select emp_seq.nextval into : new.employeeid from dual;
END; --end of what we want to happen
/

CREATE OR REPLACE TRIGGER Batch_trig
BEFORE INSERT ON Batches 
FOR EACH ROW
BEGIN
  select batch_seq.nextval into : new.batchid from dual;
END;
/

CREATE OR REPLACE TRIGGER Assoc_trig
BEFORE INSERT ON Associate
FOR EACH ROW
BEGIN
  select associate_seq.nextval into : new.associateid from dual;
END;
/



CREATE OR REPLACE TRIGGER role_trig
BEFORE INSERT ON Role
FOR EACH ROW
BEGIN
  select role_seq.nextval into : new.roleid from dual;
END;
/

CREATE OR REPLACE PROCEDURE getAll(associates OUT SYS_REFCURSOR)
AS
BEGIN
  OPEN associates FOR SELECT firstname, lastname, email, grade FROM associate;
END;
/



--DUAL
/*
dual is a special, one-row, one-column table present by default in Oracle
and some other database installations
it exists for various reasons including being able to select values not associated with a table
*/

select*from dual;
select emp_seq.currval from dual;
select SYSDATE from dual;

select*from Role;

select role_seq.nextval from dual;

update Role
set name = 'Recruiter'
where roleid = 5;

-- REMEMBER TO COMMIT:
commit;



