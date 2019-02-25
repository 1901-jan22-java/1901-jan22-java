drop table ers_reimbursement;
drop table ers_users;
drop table ers_reimbursement_status;
drop table ers_reimbursement_type;
drop table ers_user_roles;

create table ers_reimbursement_status(
reimb_status_id number primary key,
reimb_status varchar2(10) not null
);
create table ers_reimbursement_type(
reimb_type_id number primary key,
reimb_type varchar2(10) not null
);
create table ers_user_roles(
ers_user_role_id number primary key,
user_role varchar2(10) not null
);
create table ers_users(
ers_users_id number primary key,
ers_username varchar2(50) unique, 
ers_password varchar2(50) not null,
user_first_name varchar2(100) not null,
user_last_name varchar2(100) not null,
user_email varchar2(150) unique,
user_role_id number,
constraint user_roles_fk foreign key (user_role_id) references ers_user_roles(ers_user_role_id)
);
create table ers_reimbursement(
reimb_id number primary key,
reimb_amount number(20,2) not null,
reimb_submitted timestamp not null,
reimb_resolved timestamp,
reimb_description varchar2(250),
reimb_author number not null,
reimb_resolver number,
reimb_status_id number not null,
reimb_type_id number not null,
constraint ers_users_fk_auth foreign key (reimb_author) references ers_users(ers_users_id),
constraint ers_users_fk_reslvr foreign key (reimb_resolver) references ers_users(ers_users_id),
constraint ers_reimbursement_status_fk foreign key (reimb_status_id) references ers_reimbursement_status(reimb_status_id),
constraint ers_reimbursement_type_fk foreign key (reimb_type_id) references ers_reimbursement_type(reimb_type_id)
);

drop sequence ers_reimbursement_type_seq;
drop sequence ers_users_seq;
drop sequence ers_reimbursement_seq;

create sequence ers_reimbursement_type_seq;
create sequence ers_users_seq;
create sequence ers_reimbursement_seq;

CREATE OR REPLACE TRIGGER ers_type_trigger
BEFORE INSERT ON ers_reimbursement_type
FOR EACH ROW
BEGIN
    SELECT ers_reimbursement_type_seq.nextval into :new.reimb_type_id FROM dual;
END;
/
CREATE OR REPLACE TRIGGER ers_users_trigger
BEFORE INSERT ON ers_users
FOR EACH ROW
BEGIN
    SELECT ers_users_seq.nextval into :new.ers_users_id FROM dual;
END;
/
CREATE OR REPLACE TRIGGER ers_reimbursement_trigger
BEFORE INSERT ON ers_reimbursement
FOR EACH ROW
BEGIN
    SELECT ers_reimbursement_seq.nextval into :new.reimb_id FROM dual;
END;
/
CREATE OR REPLACE PROCEDURE resolve (
r_id            in number,
new_status      in number,
new_resolved    in date,
new_resolver    in number
)
AS
BEGIN
    UPDATE ers_reimbursement
    SET reimb_resolved = new_resolved,
        reimb_resolver = new_resolver,
        reimb_status_id = new_status
    WHERE reimb_id = r_id;
END;
/

select * from ers_reimbursement_status;
select * from ers_reimbursement_type;
select * from ers_user_roles;
select * from ers_users;
select * from ers_reimbursement;

insert into ers_reimbursement_status values(3, 'Pending');
insert into ers_reimbursement_status values(2, 'Approved');
insert into ers_reimbursement_status values(1, 'Denied');
insert into ers_reimbursement_type(reimb_type) values('Lodging');
insert into ers_reimbursement_type(reimb_type) values('Food');
insert into ers_reimbursement_type(reimb_type) values('Travel');
insert into ers_user_roles values (0, 'employee');
insert into ers_user_roles values (1, 'manager');
insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) 
                values ('user', 'pass', 'Kevin', 'Ho', 'kevho48@gmail.com', 0);
insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
                values ('will', 'smith', 'Will', 'Smith', 'agentj@gmail.com', 1);
insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) 
                values ('kevinuser', 'kevinpass', 'Rich', 'Kid', 'kevho482@gmail.com', 0);

insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) 
                        values(1000, '17-FEB-2019', '18-FEB-2019', 'This is a test reimbursement', 1, 2, 2, 1);
insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) 
                        values(1000, '17-FEB-2019', 'Lost my house need company to help pay', 1, 1, 1);
insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) 
                        values(1000, '17-FEB-2019', '18-FEB-2019', 'Treated employees to food', 2, 2, 1, 1);
insert into ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id) 
                        values(1000, '17-FEB-2019', 'Yes', 2, 3, 1);

commit;