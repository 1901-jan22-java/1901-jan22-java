CREATE TABLE Associates(
associate_id number(20),
firstname varchar2(20) NOT NULL,
lastname varchar2(20) NOT NULL,
email varchar2(50) UNIQUE NOT NULL,
password varchar2(50) NOT NULL,
grade number(5,2) check (grade >= 0),
PRIMARY KEY (associate_id));
/
CREATE SEQUENCE a_seq;
/
CREATE OR REPLACE TRIGGER a_trig
BEFORE INSERT ON Associates
FOR EACH ROW
BEGIN
  SELECT a_seq.nextval
  INTO :new.associate_id 
  FROM dual;
END;
/

CREATE OR REPLACE PROCEDURE update_grade(
a_id IN NUMBER, 
a_grade IN NUMBER)
AS
BEGIN
  UPDATE Associates
  SET grade = a_grade
  WHERE associate_id = a_id;
  commit;
END;
/
INSERT INTO Associates(firstname, lastname, email, password,grade) VALUES('edwin','faican','nono','123',75.44);

SELECT * FROM Associates;

commit;