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
DROP TABLE REIMBURSEMENT;
CREATE TABLE REIMBURSEMENT(
reimb_id number(10),
reimb_amount number(38,2) NOT NULL,
reimb_submitted timestamp NOT NULL,
reimb_resolved timestamp,
reimb_description varchar2(250) NOT NULL,
--reimb_reciept blob NOT NULL,
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
CREATE TABLE EMAILS(
e_id number(10),
email varchar2(50) UNIQUE NOT NULL,
user_role_id number(20) NOT NULL,
PRIMARY KEY(e_id),
FOREIGN KEY (user_role_id) REFERENCES User_Roles
              ON DELETE CASCADE);
/
--Create Sequences--
CREATE SEQUENCE USER_SEQ;
CREATE SEQUENCE REIMB_SEQ;
CREATE SEQUENCE EMAIL_SEQ;
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
CREATE OR REPLACE TRIGGER EMAIL_TRIG
BEFORE INSERT ON EMAILS
FOR EACH ROW
BEGIN
  SELECT EMAIL_SEQ.nextval
  INTO :new.e_id
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
CREATE OR REPLACE PROCEDURE update_user(
u_id IN NUMBER,
u_username IN VARCHAR2,
u_password IN VARCHAR2)
AS
BEGIN
  UPDATE Users
  SET username = u_username, password = u_password
  WHERE user_id = u_id;
END;
/
--Create View--
CREATE OR REPLACE VIEW reimbursement_data
AS 
SELECT reimb_id, reimb_author, u1.firstname AS author_first, u1.lastname AS author_last, reimb_amount, reimb_description, reimb_submitted, rt.reimb_type, reimb_resolver, u2.firstname, u2.lastname, rs.reimb_status, rs.reimb_status_id, reimb_resolved FROM Reimbursement r
JOIN Users u1 ON u1.user_id = reimb_author
LEFT JOIN Users u2 ON u2.user_id = reimb_resolver
JOIN Reimbursement_type rt ON r.reimb_type_id = rt.reimb_type_id
JOIN Reimbursement_status rs ON r.reimb_status_id = rs.reimb_status_id;
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
INSERT INTO Reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (200, '01-Mar-18', '01-Mar-19', 'Woop Woop',  1, 2, 2, 1);
INSERT INTO Reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (200, '17-Apr-11', '17-Apr-19', 'Heart you',  1, 2, 2, 1);

-- Inserting List of approved email addresses -- 
INSERT INTO Emails(email, user_role_id) VALUES('tree@ground.com', 2);
INSERT INTO Emails(email, user_role_id) VALUES('blah@blah.com', 1);
INSERT INTO Emails(email, user_role_id) VALUES('aeromancey@gmail.com', 2);
INSERT INTO Emails(email, user_role_id) VALUES('edwinxfaican@gmail.com', 2);
INSERT INTO Emails(email, user_role_id) VALUES('employeeatthecompany@gmail.com', 1);




--DROP TABLE REIMBURSEMENT;
SELECT * FROM REIMBURSEMENT;
SELECT * FROM REIMBURSEMENT WHERE reimb_resolved IS NULL ORDER BY reimb_submitted ASC;

commit;