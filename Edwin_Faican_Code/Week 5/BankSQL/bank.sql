CREATE TABLE BANK_USERS(
user_id NUMBER(20),
firstname VARCHAR2(50) NOT NULL,
lastname VARCHAR2(50) NOT NULL,
username VARCHAR2(50)UNIQUE NOT NULL,
pass VARCHAR2(50) NOT NULL,
PRIMARY KEY (user_id));
/

CREATE TABLE BANK_ACCOUNT(
account_id NUMBER(20),
user_id NUMBER(20) NOT NULL,
account_type VARCHAR2(20) NOT NULL,
balance NUMBER(38,2) NOT NULL,
PRIMARY KEY (account_id),
FOREIGN KEY (user_id) REFERENCES Bank_Users
                      ON DELETE CASCADE);
/

CREATE SEQUENCE BU_SEQ;
CREATE SEQUENCE BA_SEQ MINVALUE 3812;

CREATE OR REPLACE TRIGGER BU_TRIG
BEFORE INSERT ON Bank_Users
FOR EACH ROW
BEGIN 
  SELECT BU_SEQ.nextval
  INTO :new.user_id
  FROM dual;
END;
/

CREATE OR REPLACE TRIGGER BA_TRIG
BEFORE INSERT ON Bank_Account
FOR EACH ROW
BEGIN
  SELECT BA_SEQ.nextval
  INTO :new.account_id
  FROM dual;
END;
/

CREATE OR REPLACE VIEW selection
AS 
SELECT account_id, firstname, lastname, balance, account_type FROM Bank_Account a
JOIN Bank_Users u ON u.user_id = a.user_id;
/

SELECT * FROM selection;

commit;