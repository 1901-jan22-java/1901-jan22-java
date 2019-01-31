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


