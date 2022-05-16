create or replace procedure getPlanetName(pID in number, planetname out VARCHAR) is
begin
    select nameplanet into planetname from planet where id_planet = pID;
end;
/
create or replace procedure getPlanetMetal(pID in number,planetMetal out number)
is
begin
    select metal into planetMetal from planet where id_planet = pID;
end;
/
create or replace procedure getPlanetDeuterium(pID in number,planetDeuterium out number)
is
begin
    select deuterium into planetDeuterium from planet where id_planet = pID;
end;
/
create or replace procedure setPlanetMetal(addMetal in number)
is
begin
    update planet set metal = addMetal where id_planet = 1;
end;
/
create or replace procedure setPlanetDeuterium(addDeuterium in number)
is
begin
    update planet set deuterium = addDeuterium where id_planet = 1;
end;
/
create or replace procedure getPlanetTechDef(pID in number, techCant out number)
is
begin
    update planet set def_tech = techCant where id_planet = pID;
end;
/
create or replace procedure setPlanetTechDef(pID in number, techCant in number)
is
begin
    update planet set def_tech = techCant where id_planet = pID;
end;
/
create or replace procedure getPlanetTechAtk(pID in number, techCant out number)
is
begin
    update planet set atk_tech = techCant where id_planet = pID;
end;
/
create or replace procedure setPlanetTechAtk(pID in number, techCant in number)
is
begin
    update planet set atk_tech = techCant where id_planet = pID;
end;
/
create or replace procedure addShip(pID in number, warshipID in number, shipCant in number, shipLvL in number)
is
    existe number;
    pCant number;
begin
    select count(*) into existe from planet_ship where id_planet = pId and id_warship = warshipID and ship_level = shipLvL;
    if (existe = 0) then
        insert into planet_ship(id_planet, id_warship, cant, ship_level)
        values (pID,warshipID,shipCant,shipLvL);
    elsif (existe != 0) then
        select cant into pCant from planet_ship where id_planet = pID and id_warship = warshipID and ship_level = shipLvL;
        pCant := pCant + shipCant;
        update planet_ship set cant = pCant
        where id_planet = pID and id_warship = warshipID and ship_level = shipLvL;
    end if;
end;
/
create or replace procedure addDefense(pID in number, defenseID in number, defenseCant in number, defLvL in number)
is
    existe number;
    pCant number;
begin
    select count(*) into existe from planet_defense where id_planet = pId and id_defense = defenseID and deflevel= defLvL;
    if (existe = 0) then
        insert into planet_defense(id_planet, id_defense, cant, deflevel)
        values (pID,defenseID,defenseCant,defLvL);
    elsif (existe != 0) then
        select cant into pCant from planet_defense where id_planet = pID and id_defense = defenseID and deflevel = defLvL;
        pCant := pCant + defenseCant;
        update planet_defense set cant = pCant
        where id_planet = pID and id_defense = defenseID and deflevel = defLvL;
        DBMS_OUTPUT.PUT_LINE('Despues update');
    end if;
end;
/ 
-- select * from planet_defense order by id_defense; 
-- select * from planet_ship order by id_warship; 
-- select * from planet; 
-- delete planet_ship;
-- delete planet_defense;
-- update planet set atk_tech = 1 where id_planet = 1;