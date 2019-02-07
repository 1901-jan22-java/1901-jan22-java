select * from associates;

create table Associates(
    a_id number primary key,
    firstname varchar2(160),
    lastname varchar2(160),
    email varchar2(160) unique not null,
    a_password varchar2(160) not null,
    grade varchar2(160)
)

create SEQUENCE create_Associate_ID
start with 1
increment by 1;

create or replace procedure createAssociate (
    u_firstname in varchar2, u_lastname in varchar2, u_email in varchar2, u_password in varchar2, u_grade in varchar2, output_id out number
)
as
    u_num number;
begin
    u_num := create_Associate_ID.nextval;
    insert into associates(a_id, firstname, lastname, email, a_password, grade)
    values (u_num, u_firstname, u_lastname, u_email, u_password, u_grade);
    output_id := u_num;
end;
/

create or replace procedure login(
    temp_username in varchar2, temp_password in varchar2, out_result out number
)
as
    entries_avalable number; u_usernameid number; pass number;
begin
    select count(*) into entries_avalable from Associates a where a.email = temp_username;
    if entries_avalable != 0 then
        select a.a_id into u_usernameid from Associates a where a.email = temp_username;
        select count(*) into pass from Associates a where a.a_id = u_usernameid and a.a_password = temp_password;
        if pass = 1 then
            out_result := u_usernameid;
        else
            out_result := 0;
        end if;
    else
        out_result := -1;
    end if;
end;
/

create or replace procedure getAssociate(
    u_id in number, cursorParam out SYS_REFCURSOR
)
as
begin
    open cursorparam for select * from Associates where a_id = u_id;
end;
/
