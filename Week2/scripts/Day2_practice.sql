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

INSERT INTO Roles(RID, Title) VALUES(1, 'Associate');
INSERT INTO Roles(RID, Title) VALUES(2, 'Trainer');
INSERT INTO Roles(RID, Title) VALUES(3, 'Recruiter');
INSERT INTO Roles(RID, Title) VALUES(4, 'Sales Rep');

SELECT * FROM Roles;

--Triggers, Sequences

-- A sequence is a set of integers that are generated and supported by the db
-- system itself to support the production of unique values on demand.
-- a user defined schema bound object that generates a sequence of numeric values
-- Used to auto generate a PK value
CREATE SEQUENCE EMP_SEQ;

-- Long form
/*
CREATE SEQUENCE  "MKOERBER"."EMP_SEQ"  
MINVALUE 1 
MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 
START WITH 1 
CACHE 20 
NOORDER  
NOCYCLE  
NOPARTITION ;
*/

CREATE SEQUENCE TRAINER_SEQ;
CREATE SEQUENCE BATCH_SEQ;
CREATE SEQUENCE A_SEQ;
CREATE SEQUENCE R_SEQ;

DROP SEQUENCE TRAINER_SEQ;

--Dual
-- A Special one-row, one-column table present by default
-- It exists for various reasons including being able to select values not
-- associated with a table.
-- Dummy table we use to hold syntax - doesnt hold values beyond the query

SELECT * FROM Dual;
SELECT emp.seq.currval FROM Dual;
SELECT emp_seq.nextval FROM Dual;
SELECT SYSDATE FROM Dual;

-- Triggers 
-- A special type of store procedure that happens automatically
-- when an event occurs in the DB
CREATE OR REPLACE TRIGGER Emp_trig --declare a name trigger
BEFORE INSERT ON Employees -- sepcify when it will execute
FOR EACH ROW --necessary to change values in rows
BEGIN -- start what we want to happen
 SELECT emp_seq.nextval INTO : new.empId FROM Dual;
END;

CREATE OR REPLACE TRIGGER batch_trig
BEFORE INSERT ON Batches
FOR EACH ROW
BEGIN
 SELECT BATCH_SEQ.nextval INTO : new.BId FROM Dual;
END;

CREATE OR REPLACE TRIGGER a_trig
BEFORE INSERT ON Associates
FOR EACH ROW
BEGIN
 SELECT A_SEQ.nextval INTO : new.AId FROM Dual;
END;

CREATE OR REPLACE TRIGGER R_SEQ
BEFORE INSERT ON Roles
FOR EACH ROW
BEGIN
  SELECT R_SEQ.nextval INTO : new.RId FROM DUAL;
END;
--DML
SELECT * FROM Employees;
INSERT INTO employees(roleid, firstname, lastname, email)
VALUES(2, 'Genesis', 'Bonds', 'genesis.bonds@revature.com'); 

INSERT INTO employees(roleid, firstname, lastname, email)
VALUES(2, 'Patrick', 'Jones', 'patrick.jones@revature.com'); 

Update employees
SET firstname = 'John'
WHERE empid = 3;

SELECT * FROM Roles;

SELECT r_seq.nextval from dual;
select max(RId) from roles;

--REMEMBER TO COMMIT!
commit;

