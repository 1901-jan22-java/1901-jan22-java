DROP TABLE associates;

CREATE TABLE associates (
ID NUMBER PRIMARY KEY,
firstname VARCHAR2(25) NOT NULL,
lastname VARCHAR2(25) NOT NULL,
email VARCHAR2(30) UNIQUE NOT NULL,
password VARCHAR2(25) NOT NULL,
grade NUMBER NOT NULL
);

CREATE SEQUENCE classAssociate_SEQ;

CREATE OR REPLACE TRIGGER classAssociate_TRIG
BEFORE INSERT ON associates
FOR EACH ROW
BEGIN
SELECT classAssociate_SEQ.nextval INTO :new.id FROM dual;
END;
/

INSERT INTO associates(firstname, lastname, email, password, grade)
VALUES ('Hank', 'Hill', 'strickland@propane.com', 'ladybird', 100);

SELECT * FROM associates;


commit;



