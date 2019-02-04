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
CREATE SEQUENCE ROLE_SEQ;

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
CREATE OR REPLACE TRIGGER Rol_trig
BEFORE INSERT ON Role
FOR EACH ROW
BEGIN 
  SELECT role_seq.nextval
  INTO :new.role_id 
  FROM dual;
END;
/

--Inserting with Triggers--
INSERT INTO Employees(e_role, firstname, lastname, email)
VALUES (2, 'Patrick', 'Walsh', 'patrick@revature.com');

INSERT INTO Role(name) VALUES('Frog');

SELECT * FROM Role;

--REMEBER TO COMMIT--
commit;

SELECT * FROM Role;

UPDATE Role
SET name = 'HR'
WHERE role_id = 6;

--PROCEDURES--
/
CREATE OR REPLACE PROCEDURE helloWorld
AS 
BEGIN
  dbms_output.put_line('Hello World');
END;
/
execute helloWorld;

CREATE OR REPLACE PROCEDURE getArtistById(a_id IN NUMBER, a_name OUT VARCHAR2)
AS
BEGIN 
  SELECT name INTO a_name FROM artist
  WHERE artistid = a_id;
END;
/

--PL/SQL Block to execute procedure--
DECLARE a_name VARCHAR2(100);
BEGIN 
  getArtistById(2, a_name);
  dbms_output.put_line('ID: 2, Artist: ' || a_name);
END;
/

--CURSOR--
CREATE OR REPLACE PROCEDURE getAllArtists(cursorParam OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN cursorParam FOR SELECT * FROM Artist;
END;
/

--Transactional Procedure--
CREATE OR REPLACE PROCEDURE Delete_Invoice(inv_id IN NUMBER)
AS
BEGIN
  DELETE FROM invoiceline 
  WHERE invoiceid = inv_id;
  
  DELETE FROM invoice 
  WHERE invoiceid = inv_id;
  
  commit;
END;
/

SELECT * FROM invoice
WHERE invoiceid = 1;

EXEC Delete_Invoice(1);

SELECT * FROM invoice
WHERE invoiceid = 1;

--Write a stored procedure that will insert data into a table with params given--
CREATE OR REPLACE PROCEDURE insertIntoArtist(a_name IN VARCHAR2, a_id IN NUMBER) 
AS 
BEGIN   
  INSERT INTO Artist(name, artistid) VALUES(a_name, a_id);
  commit;
END;
/

EXEC insertIntoArtist('Paul McCartney', 276);

SELECT * FROM Artist;

--FUNCTIONS--
SELECT COUNT(*) FROM Artist;

CREATE OR REPLACE FUNCTION getNumArtists
RETURN NUMBER
IS total NUMBER;
BEGIN 
  SELECT COUNT(*) INTO total FROM Artist;
  RETURN total;
END;
/

SELECT getNumArtists() FROM DUAL;

CREATE OR REPLACE FUNCTION numArtistWithSingleAlbum
RETURN NUMBER
IS total NUMBER;
BEGIN
  SELECT COUNT(*) INTO total FROM Album a1
  WHERE NOT EXISTS (SELECT a2.artistid FROM Album a2
                    WHERE a1.artistid = a2.artistid AND a1.albumid != a2.albumid);
  RETURN total;
END;
/
INSERT INTO Album VALUES(348,'AAAA',276);
INSERT INTO Album VALUES(349,'BBBB', 276);
SELECT COUNT(*) FROM Album;
SELECT numArtistWithSingleAlbum() FROM DUAL;