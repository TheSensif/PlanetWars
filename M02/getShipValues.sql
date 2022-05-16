create or replace procedure getshipvalues
(
idShip in number, nameShip out varchar, metalCostShip out number,
crystalCostShip  out number, deuteriumCostShip out number, initArmorShip  out number,
armorShip  out number, baseDamageShip  out number, speedShip  out number,
generate_wastingsShip  out number
)
is
begin
    select name,metal_cost, crystal_cost,deuterium_cost,initial_armor,armor, basedamage, speed, generate_wastings
    into nameShip,metalCostShip,crystalCostShip,deuteriumCostShip,initArmorShip,armorShip,baseDamageShip,speedShip,generate_wastingsShip
    from warships where id_ship = idShip;
    
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE ('No data found');
end;