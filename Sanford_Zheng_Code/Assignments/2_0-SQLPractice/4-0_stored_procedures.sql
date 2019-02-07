/*
 * Week 2 Assignment:
 *      SQL WorkBook
 *      Section 4.0 Stored Procedures 
 * By: Sanford Zheng
 * Description: In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
 */

--------------------- 4.1 Basic Stored Procedure ----------------------
-- Task 1 Create a stored procedure that selects the first and last names of all the employees.
create or replace procedure employee_names(curs out sys_refcursor)
is
begin
    open curs for select firstname, lastname from employee;
end;
/
select firstname, lastname from employee;



--------------- 4.2 Stored Procedure Input Parameters -----------------
-- Task 1 Create a stored procedure that updates the personal information of an employee.
create or replace procedure update_employee(
    p_EmployeeId in NUMBER,
    p_LastName in VARCHAR2,
    p_FirstName in VARCHAR2,
    p_Title in VARCHAR2,
    p_ReportsTo in NUMBER,
    p_BirthDate in DATE,
    p_HireDate in DATE,
    p_Address in VARCHAR2,
    p_City in VARCHAR2,
    p_State in VARCHAR2,
    p_Country in VARCHAR2,
    p_PostalCode in VARCHAR2,
    p_Phone in VARCHAR2,
    p_Fax in VARCHAR2,
    p_Email in VARCHAR2
)
is
begin
    update employee
    set EmployeeId = p_EmployeeId,
        LastName = p_LastName,
        FirstName = p_FirstName,
        Title = p_Title,
        ReportsTo = p_ReportsTo,
        BirthDate = p_BirthDate,
        HireDate = p_HireDate,
        Address = p_Address,
        City = p_City,
        State = p_State,
        Country = p_Country,
        PostalCode = p_PostalCode,
        Phone = p_Phone,
        Fax = p_Fax,
        Email = p_Email;
end;
/

-- Task 2 Create a stored procedure that returns the managers of an employee.
create or replace procedure manager_of(
    p_employeeid in number,
    manager out number
)
is
begin
    select reportsto into manager from employee where employeeid = p_employeeid;
end;
/


-------------- 4.3 Stored Procedure Output Parameters -----------------
-- Task 1 Create a stored procedure that returns the name and company of a customer.
create or replace procedure name_comp_of(
    p_cust in number,
    p_name out varchar2,
    p_comp out varchar2
)
is
    fname varchar2;
    lname varchar2;
begin
    select firstname, lastname, company into fname, lname, p_comp from customer;
    p_name := fname || ' ' || lname;
end;
/
