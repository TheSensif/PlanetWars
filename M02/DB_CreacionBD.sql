DROP TABLE BattleLog;
DROP TABLE PLANET_SHIP;
DROP TABLE PLANET_DEFENSE;
DROP TABLE WARSHIPS;
DROP TABLE DEFENSE;
DROP TABLE ENEMIE;
DROP TABLE PLANET;
DROP TABLE USERS;


CREATE TABLE USERS(
    id_user NUMBER(5) PRIMARY KEY,
    username varchar2(50),
    birth_date date,
    password varchar2(50)
);

CREATE TABLE PLANET (
    id_planet number PRIMARY KEY,
    id_user number,
    namePlanet varchar(50),
    metal number,
    deuterium number,
    def_tech number,
    atk_tech number,
    CONSTRAINT planet_id_user
    FOREIGN KEY (id_user) REFERENCES USERS (id_user)
);

CREATE TABLE ENEMIE (
    metalEnemie number,
    deuteriumEnemie number,
    percent number,
    totalAtacks number
);

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