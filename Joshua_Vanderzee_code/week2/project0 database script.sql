CREATE TABLE Users
(
    UserId NUMBER primary key,
    UserName varchar2(30) not null unique,
    Password varchar2(100) not null,
    FirstName VARCHAR2(40) NOT NULL,
    LastName VARCHAR2(20) NOT NULL,
    SecurityQuestion1 varchar2(100) not null,
    SecurityAnswer1 varchar2(100)not null,
    SecurityQuestion2 varchar2(100)not null,
    SecurityAnswer2 varchar2(100)not null,
    SecurityQuestion3 varchar2(100) not null,
    SecurityAnswer3 varchar2(100) not null,
    Addressline1 VARCHAR2(70) not null,
    Addressline2 VARCHAR2(70),
    City VARCHAR2(40) not null,
    States VARCHAR2(40) not null,
    Country VARCHAR2(40) not null,
    PostalCode VARCHAR2(10) not null,
    HomePhone VARCHAR2(24),
    CellPhone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60) NOT NULL,
    SSN NUMBER(9) not null,
    BirthDate DATE not null,
    Maritalstatus Varchar2(15) not null
);

create sequence add_user_id
    start with 1
    increment by 1;
    
create or replace trigger create_user
before Insert on Users
for each row
begin
    select add_user_id.nextval INTO :new.UserId FROM DUAL;
end;
/


CREATE TABLE Accounts
(
    AccountId NUMBER primary key,
    AccountType VarChar2(20) not null,
    AccountNumber number(9) not null,
    RoutingNumber number(9) not null,
    Balance number not null
);

select * from accounts;

select * from Useraccounts;

Create sequence Accountid_sequence 
start with 1
increment by 1;

Create sequence UserAccountid_sequence 
start with 1
increment by 1;

CREATE TABLE UserAccounts (
    UserID number,
    AccountID number,
    Active number(1) DEFAULT 0 NOT NULL,
    primary key(UserID,AccountID),
    foreign key (UserID) references Users(UserId),
    foreign key (AccountID) references Accounts(AccountId)
);

create or replace procedure add_Acount(
    u_id in number, u_type varchar2, u_AccountNumber in number, u_RoutingNumber in number, u_amount in number
)
as
    a_id number;
begin
    a_id := Accountid_sequence.nextval;
    insert into Accounts(AccountId, AccountType, AccountNumber, RoutingNumber, Balance) values (a_id, u_type, u_AccountNumber, u_RoutingNumber, u_amount);
    
    insert into UserAccounts(UserID, AccountID, Active) values (u_id, a_id, 1);
end;
/



create table transactionTypes (
    transactionTypeID number primary key,
    transactionTypeState varchar2(20) not null
);

insert into transactionTypes(transactionTypeID, transactionTypeState)
    values (1, 'Withdraw');
insert into transactionTypes(transactionTypeID, transactionTypeState)
    values (2, 'Deposit');
insert into transactionTypes(transactionTypeID, transactionTypeState)
    values (3, 'Transfer');
insert into transactionTypes(transactionTypeID, transactionTypeState)
    values (4, 'Payment');
insert into transactionTypes(transactionTypeID, transactionTypeState)
    values (5, 'Overdraft Fee');
insert into transactionTypes(transactionTypeID, transactionTypeState)
    values (6, 'Service Charges');
insert into transactionTypes(transactionTypeID, transactionTypeState)
    values (7, 'Bounced Check Fee');
insert into transactionTypes(transactionTypeID, transactionTypeState)
    values (8, 'Interest');

drop table transactions;
create table transactions (
    TransactionID number primary key,
    AccountId number not null,
    TransactionTypeID number not null,
    Amount number not null,
    TransactionDate date not null,
    Memo varchar2(50) not null,
    RunningBalance number not null,
    foreign key (AccountId) references Accounts(AccountId),
    foreign key (TransactionTypeID) references transactionTypes(transactionTypeID)
);

Create sequence transactions_sequence 
start with 1
increment by 1;

commit;

create or replace procedure CreateAccount(
    temp_username in varchar2, password in varchar2, firstname in varchar2, lastname in varchar2, 
    SecurityQuestion1 in varchar2, SecurityAnswer1 in varchar2,
    SecurityQuestion2 in varchar2, SecurityAnswer2 in varchar2,
    SecurityQuestion3 in varchar2, SecurityAnswer3 in varchar2,
    Addressline1 in VARCHAR2, Addressline2 in VARCHAR2, City in VARCHAR2, States in VARCHAR2, Country in VARCHAR2, PostalCode in VARCHAR2,
    HomePhone in VARCHAR2, CellPhone in VARCHAR2, Fax in VARCHAR2,
    Email in VARCHAR2, SSN in NUMBER, BirthDate in DATE, Maritalstatus in Varchar2, return_id out number
)
as
begin
    insert into Users(UserName, Password, FirstName, LastName, SecurityQuestion1, SecurityAnswer1, SecurityQuestion2, SecurityAnswer2, SecurityQuestion3, SecurityAnswer3, 
        Addressline1, Addressline2, City, States, Country, PostalCode, HomePhone, CellPhone, Fax, Email, SSN, BirthDate, Maritalstatus)
    values(temp_username, password, firstname, lastname, 
        SecurityQuestion1, SecurityAnswer1,
        SecurityQuestion2, SecurityAnswer2,
        SecurityQuestion3, SecurityAnswer3,
        Addressline1, Addressline2, City, States, Country, PostalCode,
        HomePhone, CellPhone, Fax,
        Email, SSN, BirthDate, Maritalstatus);
        select u.UserId into return_id from Users u where u.UserName = temp_username;
end;
/

create or replace procedure login(
    temp_username in varchar2, temp_password in varchar2, out_result out number, email_alert out varchar2
)
as
    entries_avalable number; u_usernameid number; pass number;
begin
    select count(*) into entries_avalable from Users u where u.username = temp_username;
    if entries_avalable != 0 then
        select u.userid into u_usernameid from Users u where u.username = temp_username;
        select count(*) into pass from Users u where u.UserId = u_usernameid and u.password = temp_password;
        if pass = 1 then
            out_result := u_usernameid;
        else
            out_result := 0;
            select u.Email into email_alert from Users u where u.username = temp_username;
        end if;
    else
        out_result := -1;
    end if;
end;
/

create or replace procedure countUsers(
    out_result out number
)
as
begin
    select count(*) into out_result from Users;
end;
/

create or replace procedure Withdraw(
    a_id in number, u_amount in number, output out number
)
as
    a_amount number;
begin
    select Balance into a_amount from Accounts where AccountId = a_id;
    update Accounts set Balance = (a_amount - u_amount) where AccountId = a_id;
    insert into transactions(TransactionID, AccountId,
        TransactionTypeID, Amount, TransactionDate, Memo,
        RunningBalance)
    values (transactions_sequence.nextval, a_id, 1, u_amount, CURRENT_DATE, 'Withdraw from account', (a_amount - u_amount));
    select Balance into output from Accounts where AccountId = a_id;
end;
/

create or replace procedure Deposit(
    a_id in number, u_amount in number, output out number
)
as
    a_amount number;
begin
    select Balance into a_amount from Accounts where AccountId = a_id;
    update Accounts set Balance = (a_amount + u_amount) where AccountId = a_id;
    insert into transactions(TransactionID, AccountId,
        TransactionTypeID, Amount, TransactionDate, Memo,
        RunningBalance)
    values (transactions_sequence.nextval, a_id, 1, u_amount, CURRENT_DATE, 'Deposite into account', (a_amount + u_amount));
    select Balance into output from Accounts where AccountId = a_id;
end;
/

SELECT TO_CHAR(CURRENT_DATE, 'DD-MON-YYYY') FROM dual;



declare
    return_id number; temp_username varchar2(100);
begin
    temp_username := 'szig';
    select u.UserId into return_id from Users u where u.UserName = temp_username;
    DBMS_OUTPUT.PUT_LINE('ID: ' || return_id);
end;
/

declare
    u_num number; u_email varchar2(100);
begin
    login('bobzg', '1303350090', u_num, u_email);
    DBMS_OUTPUT.PUT_LINE('id: ' || u_num);
    DBMS_OUTPUT.PUT_LINE('Email: ' || u_email);
end;
/

declare
    u_num number; u_email varchar2(100);
begin
    Deposit(2, 50.20);
end;
/

select * from Accounts;

select * from transactions;
