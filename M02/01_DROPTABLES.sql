create or replace procedure drop_tables as
begin
    DROP TABLE BattleLog;
    DROP TABLE PLANET_SHIP;
    DROP TABLE PLANET_DEFENSE;
    DROP TABLE WARSHIPS;
    DROP TABLE DEFENSE;
    DROP TABLE ENEMY;
    DROP TABLE PLANET;
    DROP TABLE USERS;
end;