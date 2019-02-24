-- TESTING SCRIPT FOR TABLES
select * from ers_reimbursement_status;
select * from ers_reimbursement_type;
select * from ers_reimbursement;

select * from ers_user_roles;
select * from ers_users where user_id = 7;

-- TESTING SCRIPT FOR REIMBURSEMENT DTO --
select * from ers_reimbursement_view;

-- TESTING SCRIPT FOR USER DTO --
select * from ers_users_view;

-- Hot Fix Stuff here...
--alter table ers_user_roles modify user_role varchar2(20);
--update ers_user_roles set user_role = 'Finance Manager' where role_id = 3;

--alter table ers_reimbursement_status add constraint status_unique unique (reimb_status);
--alter table ers_reimbursement_type add constraint type_unique unique (reimb_type);

--alter table ers_user_roles add constraint role_unique unique (user_role);
select r.reimb_id as id, r.amount, r.submitted, r.resolved, r.reimb_description as description, 
r.receipt, auth.username as author,
res.username as resolver, s.reimb_status as status,
t.reimb_type as type from ers_reimbursement r
join (select * from ers_users where user_id = 7) auth on r.author_id = auth.user_id
left join ers_users res on res.user_id = r.resolver_id 
left join ers_reimbursement_status s on s.status_id = r.reimb_status_id
left join ers_reimbursement_type t on t.type_id = r.reimb_type_id;




