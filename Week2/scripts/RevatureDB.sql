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


