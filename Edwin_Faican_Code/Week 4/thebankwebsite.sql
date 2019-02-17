--Create Tables--
CREATE TABLE USER_ROLES(
user_role_id number(20),
user_role varchar2(20) NOT NULL,
PRIMARY KEY (user_role_id))
/
CREATE TABLE USERS(
user_id number(20),
username varchar2(30) UNIQUE NOT NULL,
password varchar2(30) NOT NULL,
firstname varchar2(30) NOT NULL,
lastname varchar2(30) NOT NULL,
email varchar2(40) UNIQUE NOT NULL,
user_role_id number(20) NOT NULL,
PRIMARY KEY(user_id),
FOREIGN KEY (user_role_id) REFERENCES User_Roles
              ON DELETE CASCADE);
/
CREATE TABLE REIMBURSEMENT_STATUS(
reimb_status_id number(20),
reimb_status varchar2(10) NOT NULL,
PRIMARY KEY(reimb_status_id))
/
CREATE TABLE REIMBURSEMENT_TYPE(
reimb_type_id number(10),
reimb_type varchar2(10),
PRIMARY KEY(reimb_type_id))
/
CREATE TABLE REIMBURSEMENT(
reimb_id number(10),
reimb_amount number(38,2) NOT NULL,
reimb_submitted timestamp NOT NULL,
reimb_resolved timestamp,
reimb_description varchar2(250) NOT NULL,
reimb_reciept blob NOT NULL,
reimb_author number(10) NOT NULL,
reimb_resolver number(10),
reimb_status_id number(10) NOT NULL,
reimb_type_id number(10) NOT NULL,
PRIMARY KEY(reimb_id),
FOREIGN KEY(reimb_status_id) REFERENCES Reimbursement_status
                  ON DELETE CASCADE,
FOREIGN KEY(reimb_type_id) REFERENCES Reimbursement_type
                  ON DELETE CASCADE,
FOREIGN KEY(reimb_author) REFERENCES Users
                  ON DELETE CASCADE,
FOREIGN KEY(reimb_resolver) REFERENCES Users
                  ON DELETE CASCADE);
/
--Create Sequences--
CREATE SEQUENCE USER_SEQ;
CREATE SEQUENCE REIMB_SEQ;
/
--Create Triggers--
CREATE OR REPLACE TRIGGER USER_TRIG
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
  SELECT USER_SEQ.nextval
  INTO :new.user_id
  FROM dual;
END;
/
CREATE OR REPLACE TRIGGER REIMB_TRIG
BEFORE INSERT ON REIMBURSEMENT
FOR EACH ROW
BEGIN
  SELECT REIMB_SEQ.nextval
  INTO :new.reimb_id
  FROM dual;
END;
/

--Create Procedures--
CREATE OR REPLACE PROCEDURE resolve(
r_id IN NUMBER,
r_resolver IN NUMBER,
r_resolved IN TIMESTAMP,
r_status IN NUMBER)
AS
BEGIN
  UPDATE Reimbursement
  SET reimb_resolver = r_resolver, reimb_resolved = r_resolved, reimb_status_id = r_status
  WHERE reimb_id = r_id;
END;
/
--Inserting values into user roles--
INSERT INTO User_Roles VALUES(1, 'Employee');
INSERT INTO User_Roles VALUES(2, 'Finance Manager');

--Insert values into reimb roles--
INSERT INTO Reimbursement_Type VALUES(1, 'LODGING');
INSERT INTO Reimbursement_Type VALUES(2, 'TRAVEL');
INSERT INTO Reimbursement_Type VALUES(3, 'FOOD');
INSERT INTO Reimbursement_Type VALUES(4, 'OTHER');

--Insert Values into reimb status--
INSERT INTO Reimbursement_Status VALUES(1, 'PENDING');
INSERT INTO Reimbursement_Status VALUES(2, 'APPROVED');
INSERT INTO Reimbursement_Status VALUES(3, 'DENIED');

--Insert sample values into User Table--
INSERT INTO Users(firstname, lastname, username, password, email, user_role_id) VALUES('Edwin', 'Faican', 'edwinx', '1234','no@no.com',1);

--Insert sample values into Reimbursement Table--
INSERT INTO Reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (200, '01-Mar-18', '01-Mar-19', 'Woop Woop', '0f0000', 1, 2, 2, 1);
INSERT INTO Reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_reciept, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (200, '17-Apr-11', '17-Apr-19', 'Heart you', '7700f0', 1, 2, 2, 1);

--DROP TABLE REIMBURSEMENT;
SELECT * FROM REIMBURSEMENT;
SELECT * FROM REIMBURSEMENT WHERE reimb_resolved IS NULL ORDER BY reimb_submitted ASC;

commit;