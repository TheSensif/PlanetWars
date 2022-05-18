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
    select def_tech into techCant from planet where id_planet = pID;
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
    select atk_tech into techCant from planet where id_planet = pID;
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
create or replace procedure addBattleLog(battleID in number, userID in number, iuserlighthunter_start in number, iuserheavyhunter_start in number, iuserbattleship_start in number, iuserarmoredship_start in number, iusermissilelauncher_start in number,
    iuserioncannon_start in number, iuserplasmacannon_start in number, ienemielighthunter_start in number, ienemieheavyhunter_start in number, ienemiebattleship_start in number, ienemiearmoredship_start in number,
    iuserlighthunter_end in number, iuserheavyhunter_end in number, iuserbattleship_end in number, iuserarmoredship_end in number, iusermissilelauncher_end in number,
    iuserioncannon_end in number, iuserplasmacannon_end in number, ienemielighthunter_end in number, ienemieheavyhunter_end in number, ienemiebattleship_end in number, ienemiearmoredship_end in number)
is
begin
    insert into battlelog(id_battle, id_user, userLightHunter_start, userHeavyHunter_start, userBattleShip_start, userArmoredShip_start, userMissileLauncher_start,
    userIonCannon_start, userPlasmaCannon_start, enemieLightHunter_start, enemieHeavyHunter_start, enemieBattleShip_start, enemieArmoredShip_start,
    userLightHunter_end, userHeavyHunter_end, userBattleShip_end, userArmoredShip_end, userMissileLauncher_end,
    userIonCannon_end, userPlasmaCannon_end, enemieLightHunter_end, enemieHeavyHunter_end, enemieBattleShip_end, enemieArmoredShip_end)
    
    values(battleID, userID, iuserLightHunter_start, iuserHeavyHunter_start, iuserBattleShip_start, iuserArmoredShip_start, iuserMissileLauncher_start,
    iuserIonCannon_start, iuserPlasmaCannon_start, ienemieLightHunter_start, ienemieHeavyHunter_start, ienemieBattleShip_start, ienemieArmoredShip_start,
    iuserLightHunter_end, iuserHeavyHunter_end, iuserBattleShip_end, iuserArmoredShip_end, iuserMissileLauncher_end,
    iuserIonCannon_end, iuserPlasmaCannon_end, ienemieLightHunter_end, ienemieHeavyHunter_end, ienemieBattleShip_end, ienemieArmoredShip_end);
end; -- select * from battlelog
/
create or replace procedure addLog(battleID in number,planetID in number, turnID in number, LogAdd in varchar2)
is
begin
    insert into logs (id_battle,id_planet,turn,log) values(battleID,planetID,turnID,LogAdd);
end;
/
create or replace procedure getdef(idDef in number, cantDef out number) is
begin
    select sum(cant) into cantDef from planet_defense where id_defense=idDef GROUP BY id_defense;
end;
/
create or replace procedure getship(idShip in number, cantShip out number) is
begin
    select sum(cant) into cantShip from planet_ship where id_warship = idShip group by id_warship;
end;
/
create or replace procedure getIdBattle(idNumBat in number,idBattle out number) is
begin
select id_battle into idBattle from(select rownum as num, id_battle from(select id_battle from logs order by id_battle desc))WHERE num = idNumBat;
end;
/
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