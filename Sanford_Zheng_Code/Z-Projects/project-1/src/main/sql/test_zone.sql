
select * from ers_reimbursement_type;

select * from ers_reimbursement_view;

--alter table ers_user_roles modify user_role varchar2(20);
--update ers_user_roles set user_role = 'Finance Manager' where role_id = 3;

insert into ers_user_roles(user_role) values('Admin');
insert into ers_user_roles(user_role) values('Employee');
insert into ers_user_roles(user_role) values('Finance Manager');

select * from ers_user_roles;

-- TESTING SCRIPT FOR REIMBURSEMENT DTO --
select * from ers_reimbursement;

-- TESTING SCRIPT FOR USER DTO --
select username, password, first_name, last_name, email, user_role as role from ers_users u 
join ers_user_roles ur on u.role_id = ur.role_id;