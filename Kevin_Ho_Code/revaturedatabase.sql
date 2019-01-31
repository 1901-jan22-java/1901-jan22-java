CREATE TABLE BATCHES
(
    batch_id        int             NOT NULL PRIMARY KEY,
    startdate       date            NOT NULL,
    enddate         date            NOT NULL,
    curriculum      varchar2(100)   NOT NULL,
    employee_id     int             NOT NULL
);
--drop table batches;

INSERT INTO BATCHES
VALUES(1, '2019/02/02', '2019/03/02', 'JAVA', 69);
INSERT INTO BATCHES
VALUES(2, '2019-03-02', '2019-04-02', 'XD', 70);

CREATE TABLE EMPLOYEE
(
    EMPLOYEE_ID     INT             NOT NULL PRIMARY KEY,
    FIRSTNAME       VARCHAR2(20)    NOT NULL,
    LASTNAME        VARCHAR2(20)    NOT NULL,
    EMAIL           VARCHAR2(20)    NOT NULL,
    ROLE            VARCHAR2(20)    NOT NULL
);

INSERT INTO EMPLOYEE
VALUES(1, 'Kevin', 'Ho', 'kevho48@gmail.com', 'intern');
INSERT INTO EMPLOYEE
VALUES(2, 'Nevik', 'Oh', 'xd@gmail.com', 'intern');
INSERT INTO EMPLOYEE
VALUES(69, 'Genesis', 'XD', 'xd2@gmail.com', 'trainer');


CREATE TABLE ROLE
(
    ROLE_ID         INT             NOT NULL PRIMARY KEY,
    NAME            VARCHAR2(20)    NOT NULL
);
INSERT INTO ROLE
VALUES(69, 'trainer');
INSERT INTO ROLE
VALUES(96, 'intern');

CREATE TABLE ASSOCIATE
(
    FIRST_NAME      VARCHAR2(20)    NOT NULL,
    LAST_NAME       VARCHAR2(20)    NOT NULL,
    ASSOCIATE_ID    INT             NOT NULL PRIMARY KEY,
    EMPLOYEE_ID     INT             NOT NULL UNIQUE,
    BATCH_ID        INT             ,
    OVERALL_SCORE   INT             
);
INSERT INTO ASSOCIATE
VALUES('Genesis', 'xd', 69, 69, 69, 10);
INSERT INTO ASSOCIATE
VALUES('Kevin', 'Ho', 10, 1, 69, 5);
