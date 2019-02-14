/*******************************************************************************
    Drop Tables
********************************************************************************/
drop table ers_reimbursement;
drop table ers_reimbursement_type;
drop table ers_reimbursement_status;

drop table ers_users;
drop table ers_user_roles;

/*******************************************************************************
    Drop Triggers
********************************************************************************/
drop trigger ers_reimb_create_trig;
drop trigger ers_reimb_status_create_trig;
drop trigger ers_reimb_type_create_trig;
drop trigger ers_user_role_create_trig;
drop trigger ers_user_create_trig;

/*******************************************************************************
    Drop Sequences
********************************************************************************/
drop sequence ers_reimb_id_seq;
drop sequence ers_reimb_status_id_seq;
drop sequence ers_reimb_type_id_seq;
drop sequence ers_user_role_id_seq;
drop sequence ers_user_id_seq;