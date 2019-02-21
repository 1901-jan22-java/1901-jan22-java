DROP TABLE ers_user_roles;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_reimbursement_status;
DROP TABLE ers_users;
DROP TABLE ers_reimbursement;

CREATE TABLE ers_user_roles(
user_role_id NUMBER PRIMARY KEY,
user_role VARCHAR2(10) NOT NULL
);

CREATE TABLE ers_reimbursement_type(
reimb_type_id NUMBER PRIMARY KEY,
reimb_type VARCHAR2(10) NOT NULL
);

CREATE TABLE ers_reimbursement_status(
reimb_status_id NUMBER PRIMARY KEY,
reimb_status VARCHAR2(10) NOT NULL
);

CREATE TABLE ers_users(
ers_users_id NUMBER PRIMARY KEY,
ers_username VARCHAR2(50) UNIQUE,
ers_password VARCHAR2(50) NOT NULL,
user_first_name VARCHAR2(100) NOT NULL,
user_last_name VARCHAR2(100) NOT NULL,
user_email VARCHAR2(100) UNIQUE,
user_role_id NUMBER NOT NULL,
FOREIGN KEY (user_role_id) REFERENCES ers_user_roles(user_role_id)
);

CREATE TABLE ers_reimbursement (
reimb_id NUMBER PRIMARY KEY,
reimb_amount NUMBER NOT NULL,
reimb_submitted TIMESTAMP NOT NULL,
reimb_resolved TIMESTAMP,
reimb_description VARCHAR2(250),
reimb_author NUMBER NOT NULL,
reimb_resolver NUMBER,
reimb_status_id NUMBER NOT NULL,
reimb_type_id NUMBER NOT NULL,
CONSTRAINT ers_users_fk_auth FOREIGN KEY (reimb_author) 
REFERENCES ers_users(ers_users_id),
CONSTRAINT ers_users_fk_reslver FOREIGN KEY (reimb_resolver) 
REFERENCES ers_users(ers_users_id),
CONSTRAINT ers_reimbursement_status_fk FOREIGN KEY (reimb_status_id) 
REFERENCES ers_reimbursement_status(reimb_status_id),
CONSTRAINT ers_reimbursement_type_fk FOREIGN KEY (reimb_type_id) 
REFERENCES ers_reimbursement_type(reimb_type_id)
);

INSERT INTO ers_user_roles(user_role, user_role_id) VALUES ('employee', 1);
INSERT INTO ers_user_roles(user_role, user_role_id) VALUES ('manager', 2);

INSERT ALL 
INTO ers_users(ers_users_id, ers_username, ers_password, user_first_name,
user_last_name, user_email, user_role_id) 
VALUES(1, 'dsmith', 'nyknicks', 'dennis', 'smith', 'dsmith@gmail.com', 1)
INTO ers_users(ers_users_id, ers_username, ers_password, user_first_name,
user_last_name, user_email, user_role_id) 
VALUES(2, 'ftili', 'nyknicks', 'frank', 'ntilikina', 'ftili@gmail.com', 1)
INTO ers_users(ers_users_id, ers_username, ers_password, user_first_name,
user_last_name, user_email, user_role_id) 
VALUES(3, 'mrobinson', 'nyknicks', 'mitchell', 'robinson', 'mrobinson@gmail.com', 1)
INTO ers_users(ers_users_id, ers_username, ers_password, user_first_name,
user_last_name, user_email, user_role_id) 
VALUES(4, 'kdurant', 'nyknicks', 'kevin', 'durant', 'kd@gmail.com', 1)
SELECT 1 FROM dual;

INSERT ALL 
INTO ers_users(ers_users_id, ers_username, ers_password, user_first_name,
user_last_name, user_email, user_role_id) 
VALUES(5, 'jdolan', 'nyknicks', 'james', 'dolan', 'jdolan@gmail.com', 2)
INTO ers_users(ers_users_id, ers_username, ers_password, user_first_name,
user_last_name, user_email, user_role_id) 
VALUES(6, 'dfizdale', 'nyknicks', 'david', 'fizdale', 'dfizdale@gmail.com', 2)
INTO ers_users(ers_users_id, ers_username, ers_password, user_first_name,
user_last_name, user_email, user_role_id) 
VALUES(7, 'sperry', 'nyknicks', 'scott', 'perry', 'sperry@gmail.com', 2)
SELECT 1 FROM dual;

commit;

