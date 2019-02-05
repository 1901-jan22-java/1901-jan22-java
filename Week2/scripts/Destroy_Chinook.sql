/* 
 * File: destroy_chinook.sql
 * Description: I want to clean my DB of Chinook.
 * 
 * Author: Sanford Zheng
 * 
 * 
 */

-- singular branches
drop table genre;
drop table mediatype;

-- branch
drop table artist;
drop table album;

-- track branch
drop table playlist;
drop table playlisttrack;
drop table track;

-- customer service branch 
drop table employee;
drop table customer;
drop table invoice;
-- root
drop table invoiceline;
