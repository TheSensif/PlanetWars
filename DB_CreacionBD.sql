DROP TABLE USERS;
DROP TABLE WARSHIPS;
DROP TABLE DEFENSE;
DROP TABLE BattleLog;

CREATE TABLE USERS(
    id_user NUMBER(5) PRIMARY KEY,
    username varchar2(50),
    birth_date date,
    password varchar2(50)
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

CREATE TABLE DEFENSE(
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
    
    CONSTRAINT id_user
    FOREIGN KEY (id_user) REFERENCES USERS (id_user)
);
