create or replace procedure initialize as
    users_exists number;
begin
    select count(*) into users_exists from user_tables where table_name='USERS';
    if (users_exists = 0) then
        drop_tables(); -- ??
        create_tables();
        insert_data();
    end if;
end;