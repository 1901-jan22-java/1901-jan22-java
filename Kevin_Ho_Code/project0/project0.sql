CREATE TABLE bankuser
(
    username        VARCHAR2(20)    PRIMARY KEY,
    password        VARCHAR2(20)    NOT NULL,
    first_name      VARCHAR2(20)    NOT NULL,
    last_name       VARCHAR2(20)    NOT NULL,
    birthdate       DATE            NOT NULL,
    phone           VARCHAR2(20)    NOT NULL UNIQUE,
    email           VARCHAR2(20)    NOT NULL UNIQUE
);
CREATE TABLE bankaccount
(
    account_number  NUMBER          PRIMARY KEY,
    money           NUMBER          NOT NULL,
    type            VARCHAR2(20)    NOT NULL,
    owner           VARCHAR2(20)    CONSTRAINT account_to_username_fk REFERENCES bankuser(username)
);

CREATE SEQUENCE acc_sequence;
CREATE OR REPLACE TRIGGER acc_trigger
BEFORE INSERT ON bankaccount
FOR EACH ROW
BEGIN
    SELECT acc_sequence.nextval into :new.account_number FROM dual;
END;
/

SELECT * FROM bankuser;
SELECT * FROM bankaccount;

drop table bankaccount;
drop table bankuser;

commit;

CREATE OR REPLACE PROCEDURE deposit (accID IN NUMBER, amount IN NUMBER)
AS
BEGIN
    UPDATE bankaccount
    SET money = amount
    WHERE bankaccount.account_number = accID;
END;
/

CREATE OR REPLACE PROCEDURE withdraw (accID IN NUMBER, amount IN NUMBER)
AS
BEGIN
    UPDATE bankaccount
    SET money = amount
    WHERE bankaccount.account_number = accID;
END;
/