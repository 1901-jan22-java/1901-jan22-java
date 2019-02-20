CREATE TABLE BANK_USERS(
  U_ID NUMBER(10) PRIMARY KEY, 
  FIRSTNAME VARCHAR2(50) NOT NULL, 
  LASTNAME VARCHAR2(50) NOT NULL, 
  USERNAME VARCHAR2(50) NOT NULL UNIQUE, -- SHOULD NOT HAVE 2 OF THE SAME USERNAME
  PASSWORD VARCHAR2(50) NOT NULL
);

CREATE TABLE BANK_ACCOUNTS(
  A_ID NUMBER(10) PRIMARY KEY,
  USER_ID NUMBER(10) NOT NULL, 
  BALANCE NUMBER(15, 2) NOT NULL,
  ACC_TYPE VARCHAR2(20) NOT NULL,
  FOREIGN KEY (USER_ID) REFERENCES 
      BANK_USERS(U_ID)
);

-- CREATE SEQUENCES FOR TABLES
CREATE SEQUENCE BU_SEQ;
CREATE SEQUENCE BA_SEQ;
/
-- TRIGGERS 
CREATE OR REPLACE TRIGGER BU_AUTO
BEFORE INSERT ON BANK_USERS
FOR EACH ROW 
BEGIN 
  SELECT BU_SEQ.NEXTVAL INTO :NEW.U_ID FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER BA_AUTO
BEFORE INSERT ON BANK_ACCOUNTS
FOR EACH ROW 
BEGIN 
  SELECT BA_SEQ.NEXTVAL INTO :NEW.A_ID FROM DUAL;
END;
/

select * from bank_users;

select  * from bank_accounts;

--VIEWS : virtual tables, represent the results of a query
create view account_view as
select a.a_id, u.firstname, u.lastname, a.balance, a.acc_type
from bank_accounts a
inner join bank_users u
on a.user_id = u.u_id;

select * from account_view;


-- DML
insert into bank_users (firstname, lastname, username, password)
values ('Ravi', 'Singh', 'revboss1', 'eljefe');

insert into bank_accounts(USER_ID, balance, acc_type)
values (1, 10000, 'Checking');

