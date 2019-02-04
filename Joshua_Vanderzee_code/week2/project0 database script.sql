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
    AccountNumber number not null,
    RoutingNumber number not null,
    Balance number not null
);

CREATE TABLE UserAccounts (
    UserID number,
    AccountID number,
    Active number(1) DEFAULT 0 NOT NULL,
    primary key(UserID,AccountID),
    foreign key (UserID) references Users(UserId),
    foreign key (AccountID) references Accounts(AccountId)
);

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
commit;

create or replace procedure CreateAccount(
    username in varchar2, password in varchar2, firstname in varchar2, lastname in varchar2, 
    SecurityQuestion1 in varchar2, SecurityAnswer1 in varchar2,
    SecurityQuestion2 in varchar2, SecurityAnswer2 in varchar2,
    SecurityQuestion3 in varchar2, SecurityAnswer3 in varchar2,
    Addressline1 in VARCHAR2, Addressline2 in VARCHAR2, City in VARCHAR2, States in VARCHAR2, Country in VARCHAR2, PostalCode in VARCHAR2,
    HomePhone in VARCHAR2, CellPhone in VARCHAR2, Fax in VARCHAR2,
    Email in VARCHAR2, SSN in NUMBER, BirthDate in DATE, Maritalstatus in Varchar2
)
as
begin
    insert into Users(UserName, Password, FirstName, LastName, SecurityQuestion1, SecurityAnswer1, SecurityQuestion2, SecurityAnswer2, SecurityQuestion3, SecurityAnswer3, 
        Addressline1, Addressline2, City, States, Country, PostalCode, HomePhone, CellPhone, Fax, Email, SSN, BirthDate, Maritalstatus)
    values(username, password, firstname, lastname, 
        SecurityQuestion1, SecurityAnswer1,
        SecurityQuestion2, SecurityAnswer2,
        SecurityQuestion3, SecurityAnswer3,
        Addressline1, Addressline2, City, States, Country, PostalCode,
        HomePhone, CellPhone, Fax,
        Email, SSN, BirthDate, Maritalstatus);
end;
/

create or replace procedure login(
    username in varchar2, password in varchar2, out_result out number
)
as
    u_usernameid number; pass number;
begin
    select u.userid into u_usernameid from Users u where u.username = username;
    if u_usernameid != null then
        select count(*) into pass from Users u where u.UserId = u_usernameid and u.password = password;
        if pass = 1 then
            out_result := 1;
        else
            out_result := 0;
        end if;
    end if;
end;
/

insert into Users(UserName, Password, FirstName, LastName, SecurityQuestion1, SecurityAnswer1, SecurityQuestion2, SecurityAnswer2, SecurityQuestion3, SecurityAnswer3,
    Addressline1, City, States, Country, PostalCode, CellPhone, Email, SSN, BirthDate, Maritalstatus)
    values ()

declare
    u_num number;
begin
    login('john', 'dfgfgbdfn', u_num);
    DBMS_OUTPUT.PUT_LINE('ID: ' || u_num);
end;
/

select manager from dual;
