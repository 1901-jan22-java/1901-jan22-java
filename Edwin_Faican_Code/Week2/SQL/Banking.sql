--CREATING TABLES FOR BANKING APPLICATION--
CREATE TABLE Client(
client_id number(15),
firstname varchar(20) NOT NULL,
lastname varchar(20) NOT NULL,
username varchar(30) UNIQUE NOT NULL,
pass varchar(30) NOT NULL,
PRIMARY KEY (client_id));

CREATE TABLE Type(
type_id number(10),
type_name varchar(20) UNIQUE NOT NULL,
PRIMARY KEY (type_id));

CREATE TABLE Account(
account_id number(15),
client_id number(15) NOT NULL,
account_type number(10) NOT NULL,
balance numeric(20,2) NOT NULL CHECK(balance > 0),
PRIMARY KEY (account_id),
FOREIGN KEY (client_id) REFERENCES client
              ON DELETE CASCADE,
FOREIGN KEY (account_type) REFERENCES Type
              ON DELETE CASCADE);

--Sequences--
CREATE SEQUENCE ACCT_SEQ;
CREATE SEQUENCE TYPE_SEQ;
CREATE SEQUENCE CLIENT_SEQ;

--Triggers--
CREATE OR REPLACE TRIGGER acct_trig
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
  SELECT ACCT_SEQ.nextval
  INTO :new.account_id 
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