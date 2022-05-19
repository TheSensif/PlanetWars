create or replace procedure insert_data as
begin
    insert into warships(id_ship,name, metal_cost, crystal_cost,deuterium_cost,initial_armor, armor, BaseDamage, speed,generate_wastings) 
    values(1,'Light Hunter',3000,0,50,400,0,80,3,20);

    insert into warships(id_ship,name, metal_cost, crystal_cost,deuterium_cost,initial_armor, armor, BaseDamage, speed,generate_wastings) 
    values(2,'Heavy Hunter',6500,0,50,1000,0,150,7,30);

    insert into warships(id_ship,name, metal_cost, crystal_cost,deuterium_cost,initial_armor, armor, BaseDamage, speed,generate_wastings) 
    values(3,'Battle Ship',45000,0,7000,6000,0,1000,45,60);

    insert into warships(id_ship,name, metal_cost, crystal_cost,deuterium_cost,initial_armor, armor, BaseDamage, speed,generate_wastings) 
    values(4,'Armored Ship',30000,0,15000,80000,0,700,70,75);


    insert into defense(id_defense, name, metal_cost, crystal_cost,deuterium_cost,initial_armor, armor, BaseDamage,speed,generate_wastings)
    values(1,'Missile Launcher',2000,0,0,200,0,80,5,10);

    insert into defense(id_defense, name, metal_cost, crystal_cost,deuterium_cost,initial_armor, armor, BaseDamage,speed,generate_wastings)
    values(2,'Ion Cannon',4000,0,500,1200,0,250,12,25);

    insert into defense(id_defense, name, metal_cost, crystal_cost,deuterium_cost,initial_armor, armor, BaseDamage,speed,generate_wastings)
    values(3,'Plasma Cannon',50000,0,5000,7000,0,2000,30,50);

    insert into enemy(metalEnemy, deuteriumEnemy, percent, totalAtacks) 
    values(180000, 4000, 5, 0);

    insert into users (id_user,username, birth_date, password) values(55555, 'ItsIvanPsk',null,'P@ssw0rd');

    insert into planet(id_planet, id_user, namePlanet, metal, deuterium, def_tech, atk_tech) values(1, 55555,'PlatLand',10000,2000,1,1);
end;