CREATE TABLE RevatureBankUser(
userid number(10) Primary Key,
RBAid number(10) NOT NULL,
FirstName Varchar2(100) NOT NULL,
LastName Varchar2(100) NOT NULL,
userpassword Varchar2(100) NOT NULL,
Email varchar2(100) Unique NOT NULL


);



CREATE TABLE RevatureBankAccount(
RBAid number(10) Primary Key,
Email varchar2(100) NOT NULL,
AccountType Varchar2(100) NOT NULL,
amount number(12,2) NOT NULL
);




create sequence RevatureBankUser_Seq;


create or replace TRIGGER NewUser_Trigger
  BEFORE INSERT ON RevatureBankUser
  FOR EACH ROW
BEGIN
  SELECT RevatureBankUser_Seq.nextval
  INTO :new.userid
  FROM dual;
END;
/


create sequence New_Account_Type_Seq;

create or replace TRIGGER NewAccount_Trigger
  BEFORE INSERT ON RevatureBankAccount
  FOR EACH ROW
BEGIN
  SELECT New_Account_Type_Seq.nextval
  INTO :new.RBAid
  FROM dual;
  END;
  /
  
INSERT INTO REVATUREBANKACCOUNT (EMAIL, ACCOUNTTYPE, AMOUNT) VALUES ('as@gmail.com', 'SAVINGS', 0);
INSERT INTO REVATUREBANKACCOUNT (USERID, ACCOUNTTYPE, AMOUNT) VALUES (1, 'CHECKINGS', 0);
UPDATE REVATUREBANKACCOUNT set amount = 100 WHERE userid = 1 AND ACCOUNTTYPE = 'CHECKINGS';

TRUNCATE TABLE REVATUREBANKACCOUNT ;
DROP TABLE REVATUREBANKACCOUNT ;

select * from REVATUREBANKUSER where EMAIL = 'as@gmail.com';

select * from REVATUREBANKACCOUNT;





commit;
SELECT * FROM REVATUREBANKACCOUNT WHERE email = 'as@gmail.com';


SELECT * FROM REVATUREBANKACCOUNT ;
