
-- Revature DB DDL
drop table Revature_Employee;
create table Revature_Employee (
    EmployeeID number primary key not null,
    FirstName varchar2(50) not null,
    LastName varchar2(50) not null,
    Email varchar2(100) unique not null,
    BirthDate date,
    SSN number(9) unique not null,
    RoleID number not null,
    foreign key (RoleID) REFERENCES Revature_Roles(RoleID)
);

drop table Revature_Roles;
create table Revature_Roles (
    RoleID number primary key not null,
    RoleTitle varchar2(50) unique not null
);

drop table Revature_Associates;
create table Revature_Associates (
    AssociateID number(10) primary key,
    EmployeeID number(10) not null,
    BatchID number not null,
    Grade number(3) not null,
    Note varchar2(250),
    foreign key (EmployeeID) REFERENCES Revature_Employee(EmployeeID),
    foreign key (BatchID) REFERENCES Revature_Batches(BatchID)
);

drop table Revature_Batches;
create table Revature_Batches (
    BatchID number primary key,
    StartDate date,
    EndDate date,
    Curriculum varchar2(50),
    TrainerID number(10),
    foreign key (TrainerID) REFERENCES Revature_Employee(EmployeeID)
);

insert into revature_roles(RoleID, RoleTitle) values (1, 'Associate');
insert into revature_roles(RoleID, RoleTitle) values (2, 'Trainer');
insert into revature_roles(RoleID, RoleTitle) values (3, 'Recruiter');
insert into revature_roles(RoleID, RoleTitle) values (4, 'Sales Rep');
insert into revature_roles(RoleTitle) values ('CEO');

-------------------------------------Sequences---------------------------------
/*
    sequences in a db is a set of integers that are generated
    is used to auto generate a PK.
*/

create sequence EMP_SEQ;
create sequence Role_SEQ;
drop sequence TRAINER_SEQ;
create sequence Associate_SEQ;
create sequence BATCH_SEQ;

---------------Trigger
/*
    A trigger is a speccial type of stored procedure
*/

create or replace trigger Emp_trig
BEFORE insert on Revature_Employee
for each row
begin
    select EMP_SEQ.nextval into :new.EmployeeID from dual;
end;
/

create or replace trigger Associates_trig
BEFORE insert on Revature_Associates
for each row
begin
    select EMP_SEQ.nextval into :new.AssociateID from dual;
end;
/

create or replace trigger Roles_trig
BEFORE insert on Revature_Roles
for each row
begin
    select Role_SEQ.nextval into :new.RoleID from dual;
end;
/

select * from Revature_Roles

update Revature_Roles


commit;


----------- Dual
-- dual is a special one-row, one column table present by default
select * from dual;
select EMP_SEQ.currval from dual;
select sysdate from dual;


insert into revature_Employee(RoleID, FirstName, LastName, Email, SSN) values (2, 'Genesis', 'Bonds', 'gbonds@revature.com', 561256458);
insert into revature_Employee(RoleID, FirstName, LastName, Email, SSN) values (2, 'Partric', 'Jones', 'partrick@revature.com', 182161654);
insert into revature_Employee(RoleID, FirstName, LastName, Email, SSN) values (2, 'Partric', 'Smith', 'psmitch@revature.com', 185465164);



--------------Set Operators-----------------

select * from employee

select * from employee where title like 'S%' minus
select * from employee where employeeid > 4;
