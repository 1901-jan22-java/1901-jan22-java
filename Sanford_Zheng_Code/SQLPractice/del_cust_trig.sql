/* 
 * Week 2 Assignment:
 *      SQL Worksheet
 *      Section 2.7
 * Description: Triggers on deleting customers
 * Author: Sanford Zheng
 * 
 */
 
create or replace trigger del_cust_trig
before delete on customer
for each row
begin
    dbms_output.put_line('Customer deleted:\n\tCustomerID: ' || :old.customerid);
    dbms_output.put_line('Invoices being deleted: ');
    for i in (select * from invoice where customerid = :old.customerid)
    loop
        dbms_output.put_line(
            'Invoice:\n\tInvoiceID: ' || i.invoiceid ||
            '\n\tCustomerID: ' || i.customerid
        );
    end loop;
    delete from invoice where customerid = :old.customerid;
end;

-- I didn't know about / to break...
