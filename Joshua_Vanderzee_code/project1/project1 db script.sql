create table ERS_USER_ROLES(
    ERS_USER_ROLE_ID number primary key,
    USER_ROLE varchar2(10)
);

create table ERS_REIMBURSEMENT_TYPE(
    REIMB_TYPE_ID number primary key,
    REIMB_TYPE varchar2(10)
);

create table ERS_REIMBURSEMENT_STATUS(
    REIMB_STATUS_ID number primary key,
    REIMB_STATUS varchar2(10)
);

create table ERS_USERS(
    ERS_USERS_ID number primary key,
    ERS_USERNAME varchar2(50) unique not null,
    ERS_PASSWORD varchar2(50) not null,
    USER_FIRST_NAME varchar2(100) not null,
    USER_LAST_NAME varchar2(100) not null,
    USER_EMAIL varchar2(100) unique not null,
    USER_ROLE_ID number not null,
    foreign key (USER_ROLE_ID) REFERENCES ERS_USER_ROLES(ERS_USER_ROLE_ID)
);

create table ERS_REIMBURSEMENT(
    REIMB_ID number PRIMARY key,
    REIMB_amount number not null,
    REIMB_submitted TIMESTAMP not null,
    REIMB_resolved TIMESTAMP,
    REIMB_Description varchar2(250),
    REIMB_receipt blob,
    REIMB_author number not null,
    REIMB_resolver number,
    REIMB_status_ID number not null,
    REIMB_type_ID number not null,
    foreign key (REIMB_author) REFERENCES ERS_USERS(ERS_USERS_ID),
    foreign key (REIMB_resolver) REFERENCES ERS_USERS(ERS_USERS_ID),
    foreign key (REIMB_status_ID) REFERENCES ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID),
    foreign key (REIMB_type_ID) REFERENCES ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID)
);




