--CREATING TABLES FOR BANKING APPLICATION--
CREATE TABLE Client
(client_id varchar(8),
 firstname varchar(20) NOT NULL,
 lastname varchar(20) NOT NULL,
 username varchar(20) NOT NULL,
 pass numeric(20) NOT NULL,
 PRIMARY KEY (client_id));


CREATE TABLE Account
(account_id varchar(8),
 client_id varchar(8),
 account_type varchar(10),
 balance numeric(20,2),
 PRIMARY KEY (account_id),
 FOREIGN KEY (client_id) REFERENCES client
              ON DELETE CASCADE);


 INSERT INTO Client VALUES(1,'Edwin', 'Faican', 'Edwin', 3254818);
 
 SELECT * FROM Client;