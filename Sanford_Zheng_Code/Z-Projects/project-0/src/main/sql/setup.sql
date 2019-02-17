create sequence test_seq;
drop sequence test_seq;
/

/* Sequences and Triggers */

create sequence ba_pk_seq;
create sequence bat_pk_seq;
create sequence bu_pk_seq;

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

/* Procedures and Functions */

create or replace procedure add_bank_account(
    user_id in number,
    acc_type in varchar2
)
is
begin
    insert into bank_accounts values(ba_pk_seq.nextval, user_id, acc_type, 0.00);
    commit;
end;
/
create or replace procedure add_bank_account_type(
    acc_type in varchar2
)
is
begin
    insert into bank_account_types values(bat_pk_seq.nextval, acc_type);
    commit;
end;
/
create or replace procedure balance_tx(
    acc_id in number,
    amount in number
)
is
    new_amt number;
begin
    select account_balance into new_amt from bank_accounts where account_id = acc_id;
    new_amt := new_amt + amount;
    update bank_accounts set account_balance = new_amt where account_id = acc_id;
    commit;
end;
/
create or replace function update_bank_account_type(
    bat_id in number, new_type in varchar2
) return dbms_sql.varchar2_table
is
    del_type dbms_sql.varchar2_table;
begin
    select account_type bulk collect into del_type from bank_account_types;
    update bank_account_types
    set account_type = new_type
    where account_type_id = bat_id;
    commit;
    return del_type;
end;
