/*******************************************************************************
   Create Tables
********************************************************************************/
create table ers_user_roles(
    role_id number not null,
    user_role varchar2(20) not null unique,
    constraint pk_ers_user_role primary key (role_id)
);

create table ers_users(
    user_id number not null,
    username varchar2(50) not null unique,
    password varchar2(50) not null,
    first_name varchar2(100) not null,
    last_name varchar2(100) not null,
    email varchar2(150) not null unique,
    role_id number not null,
    constraint pk_ers_user primary key (user_id)
);

create table ers_reimbursement_status(
    status_id number not null,
    reimb_status varchar2(20) not null unique,
    constraint pk_ers_reimb_status primary key (status_id)
);

create table ers_reimbursement_type(
    type_id number not null,
    reimb_type varchar2(20) not null unique,
    constraint pk_ers_reimb_type primary key (type_id)
);

create table ers_reimbursement(
    reimb_id number not null,
    amount number(,2) not null,
    submitted timestamp not null,
    resolved timestamp,
    reimb_description varchar2(250),
    receipt blob,
    author_id number not null,
    resolver_id number,
    reimb_status_id number not null,
    reimb_type_id number not null,
    constraint pk_ers_reimb primary key (reimb_id)
);

/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
alter table ers_users add constraint fk_user_role
    foreign key (role_id) references ers_user_roles (role_id) on delete cascade;
    
alter table ers_reimbursement add constraint fk_author_id
    foreign key (author_id) references ers_users (user_id) on delete cascade;
    
alter table ers_reimbursement add constraint fk_resolver_id
    foreign key (resolver_id) references ers_users (user_id) on delete set null;
    
alter table ers_reimbursement add constraint fk_reimb_status_id
    foreign key (reimb_status_id) references ers_reimbursement_status (status_id) on delete cascade;
    
alter table ers_reimbursement add constraint fk_reimb_type_id
    foreign key (reimb_type_id) references ers_reimbursement_type (type_id) on delete cascade;
    
/*******************************************************************************
    Create Sequences
********************************************************************************/
create sequence ers_reimb_id_seq;
create sequence ers_reimb_status_id_seq;
create sequence ers_reimb_type_id_seq;
create sequence ers_user_role_id_seq;
create sequence ers_user_id_seq;
/
/*******************************************************************************
    Create Triggers
********************************************************************************/
create or replace trigger ers_reimb_create_trig
before insert or update on ers_reimbursement
for each row
begin
    select ers_reimb_id_seq.nextval into :new.reimb_id from dual;
end;
/
create or replace trigger ers_reimb_status_create_trig
before insert on ers_reimbursement_status
for each row
begin
    select ers_reimb_status_id_seq.nextval into :new.status_id from dual;
end;
/
create or replace trigger ers_reimb_type_create_trig
before insert on ers_reimbursement_type
for each row
begin
    select ers_reimb_type_id_seq.nextval into :new.type_id from dual;
end;
/
create or replace trigger ers_user_role_create_trig
before insert on ers_user_roles
for each row
begin
    select ers_user_role_id_seq.nextval into :new.role_id from dual;
end;
/
create or replace trigger ers_user_create_trig
before insert on ers_users
for each row
begin
    select ers_user_id_seq.nextval into :new.user_id from dual;
end;
/
/*******************************************************************************
    Create Views
********************************************************************************/
create or replace view ers_reimbursement_view as
    select r.amount, r.submitted, r.resolved, r.reimb_description as description,
        r.receipt, auth.first_name + ' ' + auth.last_name as author,
        res.first_name + ' ' + res.last_name as resolver, s.reimb_status as status,
        t.reimb_type as type from ers_reimbursement r
    left join ers_users auth on auth.user_id = r.author_id
    left join ers_users res on res.user_id = r.resolver_id
    left join ers_reimbursement_status s on s.status_id = r.reimb_status_id
    left join ers_reimbursement_type t on t.type_id = r.reimb_type_id;
/
create or replace view ers_users_view as
    select u.username, u.password, u.first_name, u.last_name, u.email, r.user_role from ers_users u
    left join ers_user_roles r on u.role_id = r.role_id;
/
