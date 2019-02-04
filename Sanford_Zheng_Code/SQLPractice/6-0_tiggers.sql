/*
 * Week 2 Assignment:
 *      SQL WorkBook
 *      Section 6.0 Triggers
 * By: Sanford Zheng
 * Description: In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
 */

------------------------ 6.1 AFTER/FOR ------------------------
-- Task 1 Create an after insert trigger on the employee table fired after a new record is inserted into the table.
create or replace trigger insert_employee_trig
after insert on employee
for each row
begin
    dbms_output.put_line('Inserted: ' || :new.employeeid);
end;
/
-- Task 2 Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger update_album_trig
after update on album
for each row
begin
    dbms_output.put_line('Changed: ' || :old.albumid);
end;

/
-- Task 3 Create an after delete trigger on the customer table that fires after a row is deleted from the table.
create or replace trigger delete_customer_trig
after delete on customer
for each row
begin
    dbms_output.put_line('Makes more sense to get rid of foreign key references with a before clause instead...');
    dbmd_output.put_line('Deleted: ' || :old.customerid);
end;
/

