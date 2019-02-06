--CREATING TABLES FOR BANKING APPLICATION--
CREATE TABLE Client(
client_id number(15),
firstname varchar2(20) NOT NULL,
lastname varchar2(20) NOT NULL,
username varchar2(30) UNIQUE NOT NULL,
pass number(38) NOT NULL,
PRIMARY KEY (client_id));

CREATE TABLE Type(
type_id number(10),
type_name varchar2(20) UNIQUE NOT NULL,
PRIMARY KEY (type_id));

DROP Table Account;


CREATE TABLE Account(
account_number number(38),
client_id number(15) NOT NULL,
account_type number(10) NOT NULL,
balance number(30,2) NOT NULL CHECK(balance >= 0),
PRIMARY KEY (account_number),
FOREIGN KEY (client_id) REFERENCES client
              ON DELETE CASCADE,
FOREIGN KEY (account_type) REFERENCES Type
              ON DELETE CASCADE);

--Sequences--
CREATE SEQUENCE ACCT_SEQ MINVALUE 123456;
CREATE SEQUENCE TYPE_SEQ;
CREATE SEQUENCE CLIENT_SEQ;

--Triggers--
CREATE OR REPLACE TRIGGER acct_trig
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
  SELECT ACCT_SEQ.nextval
  INTO :new.account_number
  FROM dual;
END;
/
CREATE OR REPLACE TRIGGER type_trig
BEFORE INSERT ON Type
FOR EACH ROW
BEGIN
  SELECT TYPE_SEQ.nextval
  INTO :new.type_id 
  FROM dual;
END;
/
CREATE OR REPLACE TRIGGER client_trig
BEFORE INSERT ON Client
FOR EACH ROW
BEGIN
  SELECT CLIENT_SEQ.nextval
  INTO :new.client_id 
  FROM dual;
END;
/

CREATE OR REPLACE PROCEDURE updateBalance(
a_balance IN NUMBER,
a_account_num IN NUMBER)
AS
BEGIN
  UPDATE Account
  SET balance = a_balance
  WHERE account_number = a_account_num;
END;
/

--Adding the initial specified types of accounts--
INSERT INTO Type(type_name) VALUES('Checking');
INSERT INTO Type(type_name) VALUES('Savings');
INSERT INTO Type(type_name) VALUES('Student');
INSERT INTO Type(type_name) VALUES('Interest');
INSERT INTO Type(type_name) VALUES('Retirement');
SELECT * FROM Client;

Commit;
