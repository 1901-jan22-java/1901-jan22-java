CREATE TABLE Role(
role_id number(10),
name varchar(20) NOT NULL,
PRIMARY KEY (role_id));

CREATE TABLE Employees(
employee_id number(10),
firstname varchar(20) NOT NULL,
lastname varchar(20) NOT NULL,
email varchar2(50) UNIQUE NOT NULL,
e_role number(10) NOT NULL,
PRIMARY KEY (employee_id),
FOREIGN KEY (e_role) REFERENCES Role
                     ON DELETE CASCADE);

CREATE TABLE Batches(
batch_id number(10),
startdate Date NOT NULL,
enddate Date NOT NULL,
curriculum varchar(20) NOT NULL,
trainer number(10) NOT NULL,
PRIMARY KEY (batch_id),
FOREIGN KEY (trainer) REFERENCES Employees
                      ON DELETE CASCADE);

CREATE TABLE Associate(
associate_id number(10),
employee_id number(10) NOT NULL,
a_batch number(10) NOT NULL,
score number(6,2) NOT NULL,
PRIMARY KEY (associate_id),
FOREIGN KEY (employee_id) REFERENCES Employees
                          ON DELETE CASCADE,
FOREIGN KEY (a_batch) REFERENCES Batches
                      ON DELETE CASCADE);

--Fill Table Role--
INSERT INTO Role VALUES(1,'Associate');  
INSERT INTO Role VALUES(2, 'Trainer');
INSERT INTO Role VALUES(3, 'Recruiter');
INSERT INTO Role VALUES(4, 'Sales Rep');

SELECT * FROM Role;

--Triggers and Sequences--
CREATE SEQUENCE EMP_SEQ;

--The above sequence is represented by as the following--
CREATE SEQUENCE  "RDSDEMO"."EMP_SEQ"  
MINVALUE 1 
MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 
START WITH 1 
CACHE 20 
NOORDER  NOCYCLE  NOPARTITION ;

CREATE SEQUENCE TRAINER_SEQ;
CREATE SEQUENCE BATCH_SEQ;

--Triggers--
CREATE OR REPLACE TRIGGER Emp_trig
BEFORE INSERT ON Employees
FOR EACH ROW
BEGIN 
  SELECT emp_seq.nextval
  INTO :new.employee_id 
  FROM dual;
END;
/
CREATE OR REPLACE TRIGGER Bat_trig
BEFORE INSERT ON Batches
FOR EACH ROW
BEGIN 
  SELECT batch_seq.nextval
  INTO :new.batch_id 
  FROM dual;
END;
/
CREATE OR REPLACE TRIGGER Asc_trig
BEFORE INSERT ON Associate
FOR EACH ROW
BEGIN 
  SELECT trainer_seq.nextval
  INTO :new.associate_id 
  FROM dual;
END;
/

--Inserting with Triggers--
INSERT INTO Employees(e_role, firstname, lastname, email)
VALUES (2, 'Patrick', 'Walsh', 'patrick@revature.com');

SELECT * FROM Employees;

--REMEBER TO COMMIT--
commit;

SELECT * FROM Role;
