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
    Addressline1 VARCHAR2(70),
    Addressline2 VARCHAR2(70),
    City VARCHAR2(40),
    States VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    HomePhone VARCHAR2(24),
    CellPhone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60) NOT NULL,
    SSN NUMBER(9) not null,
    BirthDate DATE not null,
    Maritalstatus Varchar2(15) not null
);

CREATE TABLE UserAccounts (
    UserID number,
    AccountID number,
    Active number(1) DEFAULT 0 NOT NULL,
    primary key(UserID,AccountID),
    foreign key (UserID) references Users(UserId),
    foreign key (AccountID) references Accounts(AccountId)
);

CREATE TABLE Accounts
(
    AccountId NUMBER primary key,
    AccountType VarChar2(20) not null,
    AccountNumber number not null,
    RoutingNumber number not null,
    Balance number not null
);

create table transactionTypes (
    transactionTypeID number primary key,
    transactionTypeState varchar2(10) not null
);

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