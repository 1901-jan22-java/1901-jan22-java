/*
 * Week 2 Assignment:
 *      SQL WorkBook
 *      Section 5.0 Transactions
 * By: Sanford Zheng
 * Description: In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
 */

-- Task 1 Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace procedure del_invoice_by_id(
    inv_id number
)
is
    cid number;
begin
    delete from invoice where invoiceid = inv_id
        returning customerid into cid;
    dbms_output.put_line('Deleted Invoice for Customer: ' || cid);
    commit;
end;
-- Testing
/
select max(invoiceid) from invoice;
create sequence invid_seq
    start with 413;
/
declare
    cid number := 1;
    invid number := invid_seq.nextval;
begin
    insert into invoice(invoiceid, customerid, invoicedate, total)
        values(invid, cid, '02-FEB-19', 10000);
    del_invoice_by_id(cid);
end;
/
select * from invoice where total = 10000;

-- Task 2 Create a transaction nested within a stored procedure that inserts a new record in the Customer table

select max(customerid) from customer;
create sequence cid_seq
    start with 62;
/

create or replace procedure insert_customer(
    fname varchar,
    lname  varchar,
    e_mail  varchar
)
is
begin
    insert into customer(customerid, firstname, lastname, email)
        values (cid_seq.nextval, fname, lname, e_mail);
    rollback;
end;
/

