/*******************************************************************************
    RANDOM DATE FUNCTION FOR TESTING
********************************************************************************/

create or replace
FUNCTION getRandomDate(pStartDate IN DATE, pEndDate IN DATE)
    RETURN DATE
IS
    dRandomDate	DATE;
    piStartNumber PLS_INTEGER;
    piEndNumber	PLS_INTEGER;
BEGIN
    -- 1. Convert the start date to Julian date numbers
    piStartNumber := TO_NUMBER(TO_CHAR(pStartDate, 'J'));
    piEndNumber := TO_NUMBER(TO_CHAR(pEndDate, 'J'));
 
    -- 2. Using the DBMS_RANDOM function to get the random date
    dRandomDate := TO_DATE(TRUNC(DBMS_RANDOM.VALUE(piStartNumber, piEndNumber)), 'J');
 
    -- Test output
    dbms_output.put_line('Random date between ' 
        || TO_CHAR(pStartDate, 'MM/DD/YYYY') || ' and '
        || TO_CHAR(pEndDate, 'MM/DD/YYYY') || ' is: '
        || TO_CHAR(dRandomDate, 'MM/DD/YYYY') );
 
    RETURN dRandomDate;
END;
/

/*******************************************************************************
    Insert Sample User Data For Testing
********************************************************************************/

insert into ers_users(username, password, first_name, last_name, email, role_id)
values('sxzinit', 'password123', 'steve', 'zach', 'sxz@gmail.com', 1);
insert into ers_users(username, password, first_name, last_name, email, role_id)
values('sxz1', 'password123', 'evets', 'hank', 'evets@hank.com', 2);
insert into ers_users(username, password, first_name, last_name, email, role_id)
values('sxz2', 'password123', 'faican', 'evets', 'edwin@henry.com', 2);
insert into ers_users(username, password, first_name, last_name, email, role_id)
values('sxz3', 'password123', 'real', 'steve', 'steve@real.com', 3);

declare
    dgStartDate date;
    dgEndDate date;
    dgRandomDate date;
begin
    dgStartDate	:= TO_DATE('01/01/2018', 'MM/DD/YYYY');
    dgEndDate := SYSDATE; -- About 20 years ago
     
     
    -- Run it ten times to see that it shows different dates each time
    FOR i IN 1..10 LOOP
        dgRandomDate := getRandomDate(dgStartDate, dgEndDate);
        insert into ers_reimbursement(amount, 
            submitted, 
            author_id, 
            reimb_status_id, 
            reimb_type_id)
        values(dbms_random.value(100, 200),
            dgRandomDate, 
            round(dbms_random.value(6,9)), 
            round(dbms_random.value(1,3)),
            round(dbms_random.value(1,4))
        );
    END LOOP;
end;
/

/*******************************************************************************
    Insert Prepared/Expected Data (DML)
********************************************************************************/
insert into ers_reimbursement_status(reimb_status) values('Pending');
insert into ers_reimbursement_status(reimb_status) values('Approved');
insert into ers_reimbursement_status(reimb_status) values('Denied');
insert into ers_reimbursement_status(reimb_status) values('Action Required');
insert into ers_reimbursement_status(reimb_status) values('Delivered');

insert into ers_reimbursement_type(reimb_type) values('Lodging');
insert into ers_reimbursement_type(reimb_type) values('Travel');
insert into ers_reimbursement_type(reimb_type) values('Food');
insert into ers_reimbursement_type(reimb_type) values('Education');
insert into ers_reimbursement_type(reimb_type) values('Business');
insert into ers_reimbursement_type(reimb_type) values('Supplies');

insert into ers_user_roles(user_role) values('Admin');
insert into ers_user_roles(user_role) values('Employee');
insert into ers_user_roles(user_role) values('Finance Manager');

--rollback;