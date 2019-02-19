-- TESTING SCRIPT FOR TABLES
select * from ers_reimbursement_status;
select * from ers_reimbursement_type;
select * from ers_reimbursement;

select * from ers_user_roles;
select * from ers_users;

-- TESTING SCRIPT FOR REIMBURSEMENT DTO --
select * from ers_reimbursement_view;

-- TESTING SCRIPT FOR USER DTO --
select * from ers_users_view;

disconnect;
-- Hot Fix Stuff here...
alter table ers_user_roles modify user_role varchar2(20);
update ers_user_roles set user_role = 'Finance Manager' where role_id = 3;

alter table ers_reimbursement_status add constraint status_unique unique (reimb_status);
alter table ers_reimbursement_type add constraint type_unique unique (reimb_type);

alter table ers_user_roles add constraint role_unique unique (user_role);