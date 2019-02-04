CREATE TABLE bankuser
(
    username        VARCHAR2(20)    PRIMARY KEY,
    password        VARCHAR2(20)    NOT NULL,
    first_name      VARCHAR2(20)    NOT NULL,
    last_name       VARCHAR2(20)    NOT NULL,
    birthdate       DATE            NOT NULL,
    address         VARCHAR2(20)    NOT NULL,
    city            VARCHAR2(20)    NOT NULL,
    state           VARCHAR2(20)    NOT NULL,
    postalcode      VARCHAR2(20)    NOT NULL,
    country         VARCHAR2(20)    NOT NULL,
    phone           VARCHAR2(20)    NOT NULL UNIQUE,
    email           VARCHAR2(20)    NOT NULL UNIQUE
);
INSERT INTO bankuser VALUES ('kevinuser', 'kevinpass', 'Kevin', 'Ho', '27-FEB-1997', '69 Smashing Street', 'Brooklyn', 'NY', '69696', 'USA', '1-(917)-621-6996', 'kevho482@gmail.com');

CREATE TABLE bankaccount
(
    account_number  NUMBER          PRIMARY KEY,
    money           NUMBER          NOT NULL,
    type            VARCHAR2(20)    NOT NULL,
    owner           VARCHAR2(20)    CONSTRAINT account_to_username_fk REFERENCES bankuser(username),
    name            VARCHAR2(20)    
);
INSERT INTO bankaccount VALUES (00000001, 6969, 'CHECKING', 'kevinuser', 'KevinChecking');

CREATE TABLE bank
(
    bankaccount         NUMBER CONSTRAINT bank_to_account_fk REFERENCES bankaccount(account_number),
    bankuser            VARCHAR2(20) CONSTRAINT bank_to_user_fk REFERENCES bankuser(username)
);
INSERT INTO bank VALUES (00000001, 'kevinuser');

SELECT * FROM bankuser;
SELECT * FROM bankaccount;
SELECT * FROM bank;