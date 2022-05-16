create or replace procedure create_tables is
    users varchar2(50);
    planet varchar2(50);
    enemy varchar2(50);
    defense varchar2(50);
    warships varchar2(50);
    planet_ship varchar2(50);
    planet_defense varchar2(50);
    battlelog varchar2(50);
begin
    users :=  
    '
    CREATE TABLE USERS(
        id_user NUMBER(5) PRIMARY KEY,
        username varchar2(50),
        birth_date date,
        password varchar2(50)
    );
    '
    planet := 
    '
    CREATE TABLE PLANET (
        id_planet number PRIMARY KEY,
        id_user number,
        namePlanet varchar(50),
        metal number,
        deuterium number,
        atk_tech number,
        def_tech number,
        CONSTRAINT planet_id_user
        FOREIGN KEY (id_user) REFERENCES USERS (id_user)
    );
    '
    enemy :=
    '
    CREATE TABLE ENEMIE (
        metalEnemie number,
        deuteriumEnemie number,
        percent number,
        totalAtacks number
    );
    '

    defense := 
    '
    CREATE TABLE DEFENSE(
        id_defense NUMBER(5) PRIMARY KEY,
        name varchar2(50),
        metal_cost number,
        crystal_cost number,
        deuterium_cost number,
        initial_armor number,
        armor number,
        basedamage number,
        speed number,
        generate_wastings number
    );
    '

    warships :=
    '
    CREATE TABLE WARSHIPS (
        id_ship NUMBER(5) PRIMARY KEY,
        name varchar2(50),
        metal_cost number,
        crystal_cost number,
        deuterium_cost number,
        initial_armor number,
        armor number,
        basedamage number,
        speed number,
        generate_wastings number
    );
    '

    planet_defense :=
    '
    CREATE TABLE PLANET_DEFENSE(
        id_planet number,
        id_defense number,
        cant number,
        defLevel number,
        CONSTRAINT planet_defense_id_planet
        FOREIGN KEY (id_planet) REFERENCES PLANET (id_planet),
        CONSTRAINT planet_defense_id_defense
        FOREIGN KEY (id_defense) REFERENCES DEFENSE (id_defense)
    );
    '

    planet_ship :=
    '
    CREATE TABLE PLANET_SHIP(
        id_planet number,
        id_warship number,
        cant number,
        ship_level number,

        CONSTRAINT planet_ship_id_planet
        FOREIGN KEY (id_planet) REFERENCES PLANET (id_planet),
        CONSTRAINT planet_ship_id_warship
        FOREIGN KEY (id_warship) REFERENCES WARSHIPS (id_ship)
    );
    '

    battlelog := 
    '
    CREATE TABLE BattleLog(
        id_Battle number PRIMARY KEY,
        id_user number,
        
        userLightHunter_start number,
        userHeavyHunter_start number,
        userBattleShip_start number,
        userArmoredShip_start number,
        
        enemieLightHunter_start number,
        enemieHeavyHunter_start number,
        enemieBattleShip_start number,
        enemieArmoredShip_start number,
        
        userLightHunter_end number,
        userHeavyHunter_end number,
        userBattleShip_end number,
        userArmoredShip_end number,
        
        enemieLightHunter_end number,
        enemieHeavyHunter_end number,
        enemieBattleShip_end number,
        enemieArmoredShip_end number,
        
        CONSTRAINT battlelog_id_user
        FOREIGN KEY (id_user) REFERENCES USERS (id_user)
    );
    '

    EXECUTE IMMEDIATE users;

    EXECUTE IMMEDIATE planet;

    EXECUTE IMMEDIATE enemy;

    EXECUTE IMMEDIATE defense;

    EXECUTE IMMEDIATE warships;

    EXECUTE IMMEDIATE planet_defense;

    EXECUTE IMMEDIATE planet_ship;

    EXECUTE IMMEDIATE warships

end;
