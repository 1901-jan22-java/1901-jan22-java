/* Setup Bank Account Database */

drop sequence ba_pk_seq;
drop sequence bat_pk_seq;
drop sequence bu_pk_seq;

create sequence ba_pk_seq;
create sequence bat_pk_seq;
create sequence bu_pk_seq;
/

create or replace trigger ba_pk_trig
before insert on bank_accounts
for each row
begin
    select ba_pk_seq.nextval into :new.account_id from dual;
end;
/

create or replace trigger bat_pk_trig
before insert on bank_account_types
for each row
begin
    select bat_pk_seq.nextval into :new.account_type_id from dual;
end;
/

create or replace trigger bu_pk_trig
before insert on bank_users
for each row
begin
    select bu_pk_seq.nextval into :new.user_id from dual;
end;
/

/* Cleaning DB */
/* Reminder: Drop dependents first */
drop type employee_t;
drop type employee_r;

drop type account_type;

