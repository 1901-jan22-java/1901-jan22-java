/* 
 * Week 2 Assignment:
 *      SQL Worksheet
 *      Section 2.7
 * Description: Triggers on deleting invoices
 * Author: Sanford Zheng
 * 
 */
 
create or replace trigger del_invoice_trig
before delete on invoice
for each row
begin
    dbms_output.put_line('Invoice deleted:' || :old.invoiceid);
    dbms_output.put_line('Invoice Lines being deleted: ');
    for il in (select * from invoiceline where invoiceid = :old.invoiceid)
    loop
        dbms_output.put_line(
            'Invoice Line:\n\tInvoiceLineID: ' || il.invoicelineid ||
            '\n\tInvoiceID: ' || il.invoiceid
        );
    end loop;
    delete from invoiceline where invoiceid = :old.invoiceid;
end;

-- I didn't know about / to break...
