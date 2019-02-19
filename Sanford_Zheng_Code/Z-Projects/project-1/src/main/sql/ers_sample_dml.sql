
/*******************************************************************************
    Insert Prepared Expected Data (DML)
********************************************************************************/
insert into ers_reimbursement_status(reimb_status) values('Pending');
insert into ers_reimbursement_status(reimb_status) values('Approved');
insert into ers_reimbursement_status(reimb_status) values('Denied');

insert into ers_reimbursement_type(reimb_type) values('Lodging');
insert into ers_reimbursement_type(reimb_type) values('Travel');
insert into ers_reimbursement_type(reimb_type) values('Food');
insert into ers_reimbursement_type(reimb_type) values('Education');

insert into ers_user_roles(user_role) values('Admin');
insert into ers_user_roles(user_role) values('Employee');
insert into ers_user_roles(user_role) values('Finance Manager');

commit;


rollback;