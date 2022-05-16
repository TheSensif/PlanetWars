create or replace procedure getdefensevalues
(
idDef in number, nameDef out varchar, metalCostDef out number,
crystalCostDef  out number, deuteriumCostDef out number, initArmorDef  out number,
armorDef  out number, baseDamageDef  out number, speedDef  out number,
generate_wastingsDef  out number
)
is
begin
    select name,metal_cost, crystal_cost,deuterium_cost,initial_armor,armor, basedamage, speed, generate_wastings
    into nameDef,metalCostDef,crystalCostDef,deuteriumCostDef,initArmorDef,armorDef,baseDamageDef,speedDef,generate_wastingsDef
    from defense where id_defense = idDef;
    
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE ('No data found');
end;