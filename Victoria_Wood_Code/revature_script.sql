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

CREATE TABLE Associate
(
  AssociateId NUMBER NOT NULL,
  EmployeeId NUMBER NOT NULL,
  BatchId NUMBER NOT NULL,
  OverallScore NUMBER NOT NULL,
  CONSTRAINT PK_Associate PRIMARY KEY (AssociateId)


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

INSERT INTO Role (ROLEID, NAME) VALUES (1, 'Trainer');
INSERT INTO Role (ROLEID, NAME) VALUES (2, 'Associate');
INSERT INTO Role (ROLEID, NAME) VALUES (3, 'HR');

SELECT*FROM employees;

SELECT employees.firstname as Employee, role.name as Role
from Employees
join Role on employees.roleid = role.roleid;









