import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Battle implements Variables {
    private ArrayList<MilitaryUnit>[] planetArmy;
    private ArrayList<MilitaryUnit>[] enemyArmy;
    private String battleDevelopment;

    private int totalMetalWaste;
    private int totalDeuteriumWaste;

    private int[][] initialCostFleet;
    private int[] initialUnitsCant;
    private int[] wasteMetalDeuterium;
    private int[] enemyDrops;
    private int[] planetDrops;
    private int[][] resourcesLooses;
    private int[] actualNumberUnitsPlanet;
    private int[] actualNumberUnitsEnemy;

    private int userLHInit;
    private int userHHInit;
    private int userBSInit;
    private int userARInit;
    private int userMSInit;
    private int userICInit;
    private int userPCInit;

    private int enemyLHInit;
    private int enemyHHInit;
    private int enemyBSInit;
    private int enemyARInit;

    private int army_pcent;
    private int enemy_pcent;

    private boolean pWinner;

    public boolean ispWinner() {
        return pWinner;
    }

    public void setpWinner(boolean pWinner) {
        this.pWinner = pWinner;
    }

    public static void main(String[] args) throws IOException {

    }

    public void Battle(ArrayList<MilitaryUnit>[] Army, ArrayList<MilitaryUnit>[] eArmy) throws ResourceException {
        Planet p = new Planet();
        BaseDatos bd = new BaseDatos();
        Battle b = new Battle();
        try {
            // System.out.println("BattleID: " + p.getBattleID());

            // System.out.println("BattleID: " + bd.getLastBattle(1));


            b.planetArmy = Army;
            b.enemyArmy = eArmy;
            System.out.println("LH COUNT: " + b.planetArmy[0].size());
            b.initialCostFleet = b.getCostFleets(b.planetArmy, b.enemyArmy);

            b.initialUnitsCant = b.getInitialUnits(b.planetArmy, b.enemyArmy);

            int[] units = new int[2];
            units = b.getUnits(b.planetArmy, b.enemyArmy);

            army_pcent = (int) (units[0] * 0.25f);

            enemy_pcent = (int) (units[1] * 0.25f);

            int turn = 1;
            String log = "";
            boolean validAtk = false;
            boolean validDef = false;

            int atkGroup = 0;
            int defGroup = 0;
            int atkUnit = 0;
            int defUnit = 0;

            pWinner = false;
            System.out.println(b.planetArmy);
            bd.addBattleLog(bd.getLastBattle(1) + 1, p.getUserID(), b.planetArmy[0].size(), b.planetArmy[1].size(), b.planetArmy[2].size(), b.planetArmy[3].size()
                    , b.planetArmy[4].size(), b.planetArmy[5].size(), b.planetArmy[6].size(), b.enemyArmy[0].size(), b.enemyArmy[1].size(), b.enemyArmy[2].size()
                    , b.enemyArmy[3].size(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            System.out.println("DespuesBattleLog");

            bd.addCostArmy(bd.getLastBattle(1),b.initialCostFleet[0][0],b.initialCostFleet[1][0],b.initialCostFleet[0][1],b.initialCostFleet[1][1]);

            p.setBattleID(bd.getLastBattle(1));

            userLHInit = b.planetArmy[0].size();
            userHHInit = b.planetArmy[1].size();;
            userBSInit = b.planetArmy[2].size();;
            userARInit = b.planetArmy[3].size();;
            userMSInit = b.planetArmy[4].size();;
            userICInit = b.planetArmy[5].size();;
            userPCInit = b.planetArmy[6].size();;

            enemyLHInit = b.enemyArmy[0].size();
            enemyHHInit = b.enemyArmy[1].size();;
            enemyBSInit = b.enemyArmy[2].size();;
            enemyARInit = b.enemyArmy[3].size();;

            while (units[0] > army_pcent && units[1] > enemy_pcent) {
                // System.out.println("On Battle");
                validAtk = false;
                validDef = false;

                // System.out.println(turn % 2 == 0);
                if (turn % 2 == 0) {
                    while (!validAtk) {
                        // System.out.println("Planet ataca");
                        atkGroup = (int) (Math.random() * b.planetArmy.length);
                        // System.out.println("ATK GROUP: " + atkGroup);
                        // System.out.println("ATK SIZE: " + b.planetArmy[atkGroup].size());
                        if (b.planetArmy[atkGroup].size() == 0) {
                            validAtk = false;
                        } else {
                            validAtk = true;
                            atkUnit = (int) (Math.random() * b.planetArmy[atkGroup].size());
                            // System.out.println("ATK UNIT: " + atkUnit);

                            while (!validDef) {
                                defGroup = (int) (Math.random() * b.enemyArmy.length);
                                // System.out.println("DEF GROUP: " + defGroup);
                                // System.out.println("DEF SIZE: " + b.enemyArmy[defGroup].size());
                                if (b.enemyArmy[defGroup].size() == 0) {
                                    validDef = false;
                                } else {
                                    validDef = true;
                                    defUnit = (int) (Math.random() * b.enemyArmy[defGroup].size());
                                    // System.out.println("DEF UNIT: " + defUnit);

                                    if (b.enemyArmy[defGroup].size() != 0) {
                                        System.out.println("---------");
                                        // System.out.println(b.planetArmy[atkGroup].get(atkUnit) + " vs " + b.enemyArmy[defGroup].get(defUnit));
                                        // System.out.println("ARMOR: " + b.enemyArmy[defGroup].get(defUnit).getActualArmor());
                                        b.enemyArmy[defGroup].get(defUnit).takeDamage(b.planetArmy[atkGroup].get(atkUnit).getDamage());
                                        // System.out.println("ARMOR: " + b.enemyArmy[defGroup].get(defUnit).getActualArmor());

                                        // System.out.println(b.enemyArmy[defGroup].get(defUnit).getActualArmor());

                                        log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();

                                        if (b.enemyArmy[defGroup].get(defUnit).getActualArmor() <= 0) {
                                            // System.out.println("Nave destruida");

                                            log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                    + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o."
                                                    + b.enemyArmy[defGroup].get(defUnit) + " ha sido destruido.";

                                            int[] gen = b.enemyArmy[defGroup].get(defUnit).getChanceGeneratinWaste();

                                            if (gen[0] != 0 && gen[1] != 0) {
                                                totalMetalWaste += gen[0];
                                                totalDeuteriumWaste += gen[1];
                                            }

                                            b.enemyArmy[defGroup].remove(b.enemyArmy[defGroup].get(defUnit));
                                        } else {
                                            double c = Math.random() * 100;
                                            int chance = (int) c;

                                            if (b.planetArmy[defGroup] == b.planetArmy[0]) {
                                                if (chance <= CHANCE_ATTACK_AGAIN_LIGTHHUNTER && chance >= 0) {
                                                    b.enemyArmy[defGroup].get(defUnit).takeDamage(b.planetArmy[atkGroup].get(atkUnit).getDamage());
                                                    log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor()
                                                            + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                    if (b.enemyArmy[defGroup].get(defUnit).getActualArmor() <= 0) {
                                                        // System.out.println("Nave destruida");

                                                        log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o."
                                                                + b.enemyArmy[defGroup].get(defUnit) + " ha sido destruido."
                                                                + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                                + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                        ;
                                                        b.enemyArmy[defGroup].remove(b.enemyArmy[defGroup].get(defUnit));
                                                    }
                                                }

                                            }
                                            if (b.planetArmy[defGroup] == b.planetArmy[1]) {
                                                if (chance <= CHANCE_ATTACK_AGAIN_HEAVYHUNTER && chance >= 0) {
                                                    b.enemyArmy[defGroup].get(defUnit).takeDamage(b.planetArmy[atkGroup].get(atkUnit).getDamage());
                                                    log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor()
                                                            + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                    if (b.enemyArmy[defGroup].get(defUnit).getActualArmor() <= 0) {
                                                        // System.out.println("Nave destruida");

                                                        log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o."
                                                                + b.enemyArmy[defGroup].get(defUnit) + " ha sido destruido."
                                                                + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                                + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                        ;
                                                        b.enemyArmy[defGroup].remove(b.enemyArmy[defGroup].get(defUnit));
                                                    }
                                                }

                                            }
                                            if (b.planetArmy[defGroup] == b.planetArmy[2]) {
                                                if (chance <= CHANCE_ATTACK_AGAIN_BATTLESHIP && chance >= 0) {
                                                    b.enemyArmy[defGroup].get(defUnit).takeDamage(b.planetArmy[atkGroup].get(atkUnit).getDamage());
                                                    log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor()
                                                            + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                    if (b.enemyArmy[defGroup].get(defUnit).getActualArmor() <= 0) {
                                                        // System.out.println("Nave destruida");

                                                        log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o."
                                                                + b.enemyArmy[defGroup].get(defUnit) + " ha sido destruido."
                                                                + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                                + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                        ;
                                                        b.enemyArmy[defGroup].remove(b.enemyArmy[defGroup].get(defUnit));
                                                    }
                                                }

                                            }
                                            if (b.planetArmy[defGroup] == b.planetArmy[3]) {
                                                if (chance <= CHANCE_ATTACK_AGAIN_ARMOREDSHIP && chance >= 0) {
                                                    b.enemyArmy[defGroup].get(defUnit).takeDamage(b.planetArmy[atkGroup].get(atkUnit).getDamage());
                                                    log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor()
                                                            + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                    if (b.enemyArmy[defGroup].get(defUnit).getActualArmor() <= 0) {
                                                        // System.out.println("Nave destruida");

                                                        log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o."
                                                                + b.enemyArmy[defGroup].get(defUnit) + " ha sido destruido."
                                                                + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                                + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                        ;
                                                        b.enemyArmy[defGroup].remove(b.enemyArmy[defGroup].get(defUnit));
                                                    }
                                                }

                                            }
                                            if (b.planetArmy[defGroup] == b.planetArmy[4]) {
                                                if (chance <= CHANCE_ATTACK_AGAIN_MISSILELAUNCHER && chance >= 0) {
                                                    b.enemyArmy[defGroup].get(defUnit).takeDamage(b.planetArmy[atkGroup].get(atkUnit).getDamage());
                                                    log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor()
                                                            + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                    if (b.enemyArmy[defGroup].get(defUnit).getActualArmor() <= 0) {
                                                        // System.out.println("Nave destruida");

                                                        log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o."
                                                                + b.enemyArmy[defGroup].get(defUnit) + " ha sido destruido."
                                                                + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                                + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                        ;
                                                        b.enemyArmy[defGroup].remove(b.enemyArmy[defGroup].get(defUnit));
                                                    }
                                                }

                                            }
                                            if (b.planetArmy[defGroup] == b.planetArmy[5]) {
                                                if (chance <= CHANCE_ATTACK_AGAIN_IONCANNON && chance >= 0) {
                                                    b.enemyArmy[defGroup].get(defUnit).takeDamage(b.planetArmy[atkGroup].get(atkUnit).getDamage());
                                                    log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor()
                                                            + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                    if (b.enemyArmy[defGroup].get(defUnit).getActualArmor() <= 0) {
                                                        // System.out.println("Nave destruida");

                                                        log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o."
                                                                + b.enemyArmy[defGroup].get(defUnit) + " ha sido destruido."
                                                                + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                                + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                        ;
                                                        b.enemyArmy[defGroup].remove(b.enemyArmy[defGroup].get(defUnit));
                                                    }
                                                }

                                            }

                                            if (b.planetArmy[defGroup] == b.planetArmy[6]) {
                                                if (chance <= CHANCE_ATTACK_AGAIN_PLASMACANNON && chance >= 0) {
                                                    b.enemyArmy[defGroup].get(defUnit).takeDamage(b.planetArmy[atkGroup].get(atkUnit).getDamage());
                                                    log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor()
                                                            + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                            + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                            + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                    if (b.enemyArmy[defGroup].get(defUnit).getActualArmor() <= 0) {
                                                        // System.out.println("Nave destruida");

                                                        log = "El planeta ataca con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o."
                                                                + b.enemyArmy[defGroup].get(defUnit) + " ha sido destruido."
                                                                + "El planeta vuelve a atacar con " + b.planetArmy[atkGroup].get(atkUnit) + " a " + b.enemyArmy[defGroup].get(defUnit)
                                                                + " con " + b.planetArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                                + ". Armadura restante " + b.enemyArmy[defGroup].get(defUnit).getActualArmor();
                                                        ;
                                                        b.enemyArmy[defGroup].remove(b.enemyArmy[defGroup].get(defUnit));
                                                    }
                                                }

                                            }
                                        }
                                        System.out.println(log);
                                        // System.out.println("Battle ID: " + bd.getLastBattle(1));
                                        // System.out.println("PLANET ID : " + p.getPlanetID());


                                        try {

                                            bd.addLog(p.getBattleID(), p.getPlanetID(), turn, log);
                                        } catch (ClassNotFoundException | SQLException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                        turn += 1;
                                        units = b.getUnits(b.planetArmy, b.enemyArmy);
                                        if (units[0] < army_pcent) {
                                            pWinner = false;
                                        }
                                        if (units[1] < enemy_pcent) {
                                            pWinner = true;
                                        }
                                    }

                                }

                            }
                        }
                    }
                }

                if (turn % 2 == 1) {
                    while (!validAtk) {
                        // System.out.println("Planet ataca");

                        atkGroup = (int) (Math.random() * b.enemyArmy.length);
                        // System.out.println("ATK GROUP: " + atkGroup);
                        // System.out.println("ATK SIZE: " + b.enemyArmy[atkGroup].size());
                        if (b.enemyArmy[atkGroup].size() == 0) {
                            validAtk = false;
                        } else {
                            validAtk = true;
                            atkUnit = (int) (Math.random() * b.enemyArmy[atkGroup].size());
                            // System.out.println("ATK UNIT: " + atkUnit);

                            while (!validDef) {
                                defGroup = (int) (Math.random() * b.planetArmy.length);
                                // System.out.println("DEF GROUP: " + defGroup);
                                // System.out.println("DEF SIZE: " + b.planetArmy[defGroup].size());
                                if (b.planetArmy[defGroup].size() == 0) {
                                    validDef = false;
                                } else {
                                    validDef = true;
                                    defUnit = (int) (Math.random() * b.planetArmy[defGroup].size());
                                    // System.out.println("DEF UNIT: " + defUnit);

                                    if (b.planetArmy[defGroup].size() != 0) {
                                        System.out.println("---------");
                                        // System.out.println(b.enemyArmy[atkGroup].get(atkUnit) + " vs " + b.planetArmy[defGroup].get(defUnit));
                                        // System.out.println("ARMOR: " + b.planetArmy[defGroup].get(defUnit).getActualArmor());
                                        b.planetArmy[defGroup].get(defUnit).takeDamage(b.enemyArmy[atkGroup].get(atkUnit).getDamage());
                                        // System.out.println("ARMOR: " + b.planetArmy[defGroup].get(defUnit).getActualArmor());

                                        // System.out.println(b.planetArmy[defGroup].get(defUnit).getActualArmor());

                                        log = "El enemigo ataca con " + b.enemyArmy[atkGroup].get(atkUnit) + " a " + b.planetArmy[defGroup].get(defUnit)
                                                + " con " + b.enemyArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o"
                                                + ". Armadura restante " + b.planetArmy[defGroup].get(defUnit).getActualArmor();

                                        if (b.planetArmy[defGroup].get(defUnit).getActualArmor() <= 0) {
                                            // System.out.println("Nave destruida");


                                            log = "El enemigo ataca con " + b.enemyArmy[atkGroup].get(atkUnit) + " a " + b.planetArmy[defGroup].get(defUnit)
                                                    + " con " + b.enemyArmy[atkGroup].get(atkUnit).getDamage() + " puntos de daï¿½o."
                                                    + b.planetArmy[defGroup].get(defUnit) + " ha sido destruido.";

                                            b.planetArmy[defGroup].remove(b.planetArmy[defGroup].get(defUnit));
                                        }
                                        System.out.println(log);
                                        try {
                                            bd.addLog(p.getBattleID(), p.getPlanetID(), turn, log);
                                        } catch (ClassNotFoundException | SQLException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                        turn += 1;
                                        units = b.getUnits(b.planetArmy, b.enemyArmy);
                                        if (units[0] < army_pcent) {
                                            pWinner = false;
                                        }
                                        if (units[1] < enemy_pcent) {
                                            pWinner = true;
                                        }
                                    }

                                }

                            }
                        }
                    }
                }

            }

        } catch (ClassNotFoundException | SQLException e) {
        }

        if (!ispWinner()) {
            System.out.println("PLANETA GANA");
            bd.setPlanetMetal(p.getBattleID(), bd.getPlanetMetal(p.getPlanetID()) + totalMetalWaste);
            bd.setPlanetDeuterium(p.getBattleID(), bd.getPlanetDeuterium(p.getPlanetID()) + totalDeuteriumWaste);
            System.out.println("Metal generado: " + totalMetalWaste);
            System.out.println("Deuterio generado: " + totalDeuteriumWaste);
            try {
                bd.addWastGen(bd.getLastBattle(1),totalMetalWaste,totalDeuteriumWaste);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            int totalLH =  b.planetArmy[0].size();
            System.out.println(totalLH);

        }
        if (ispWinner()) {
            System.out.println("ENEMIGO GANA");
        }

    }

    public int getArmy_pcent() {
        return army_pcent;
    }

    public void setArmy_pcent(int army_pcent) {
        this.army_pcent = army_pcent;
    }

    public int getEnemy_pcent() {
        return enemy_pcent;
    }

    public void setEnemy_pcent(int enemy_pcent) {
        this.enemy_pcent = enemy_pcent;
    }

    public int[][] getCostFleets(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy) {

        int[][] costs = new int[2][2];
        int metalArmyCost = 0;
        int deuteriumArmyCost = 0;
        int metalEnemyCost = 0;
        int deuteriumEnemyCost = 0;

        int LH = planetArmy[0].size();
        int HH = planetArmy[1].size();
        int BS = planetArmy[2].size();
        int AR = planetArmy[3].size();
        int MS = planetArmy[4].size();
        int IC = planetArmy[5].size();
        int PC = planetArmy[6].size();

        int eLH = enemyArmy[0].size();
        int eHH = enemyArmy[1].size();
        int eBS = enemyArmy[2].size();
        int eAR = enemyArmy[3].size();

        metalArmyCost += ((LH * METAL_COST_LIGTHHUNTER) + (HH * METAL_COST_HEAVYHUNTER)
                + (BS * METAL_COST_BATTLESHIP) + (AR * METAL_COST_ARMOREDSHIP)
                + (MS * METAL_COST_MISSILELAUNCHER) + (IC * METAL_COST_IONCANNON)
                + (PC * METAL_COST_PLASMACANNON));
        deuteriumArmyCost += ((LH * METAL_COST_LIGTHHUNTER) + (HH * METAL_COST_HEAVYHUNTER)
                + (BS * METAL_COST_BATTLESHIP) + (AR * METAL_COST_ARMOREDSHIP)
                + (MS * METAL_COST_MISSILELAUNCHER) + (IC * METAL_COST_IONCANNON)
                + (PC * METAL_COST_PLASMACANNON));

        metalEnemyCost += ((eLH * METAL_COST_LIGTHHUNTER) + (eHH * METAL_COST_HEAVYHUNTER)
                + (eBS * METAL_COST_BATTLESHIP) + (eAR * METAL_COST_ARMOREDSHIP));
        deuteriumEnemyCost += ((eLH * METAL_COST_LIGTHHUNTER) + (eHH * METAL_COST_HEAVYHUNTER)
                + (eBS * METAL_COST_BATTLESHIP) + (eAR * METAL_COST_ARMOREDSHIP));

        costs[0][0] = metalArmyCost;
        costs[0][1] = deuteriumArmyCost;

        costs[1][0] = metalEnemyCost;
        costs[1][1] = deuteriumEnemyCost;
        return costs;
    }

    public int[] getInitialUnits(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
        int[] initial = new int[2];
        int pArmy = 0;
        int eArmy = 0;

        pArmy += planetArmy[0].size();
        pArmy += planetArmy[1].size();
        pArmy += planetArmy[2].size();
        pArmy += planetArmy[3].size();
        pArmy += planetArmy[4].size();
        pArmy += planetArmy[5].size();
        pArmy += planetArmy[6].size();

        eArmy += enemyArmy[0].size();
        eArmy += enemyArmy[1].size();
        eArmy += enemyArmy[2].size();
        eArmy += enemyArmy[3].size();

        initial[0] = pArmy;
        initial[1] = eArmy;

        return initial;
    }

    public int[] getUnits(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
        int[] initial = new int[2];
        int pArmy = 0;
        int eArmy = 0;

        pArmy += planetArmy[0].size();
        pArmy += planetArmy[1].size();
        pArmy += planetArmy[2].size();
        pArmy += planetArmy[3].size();
        pArmy += planetArmy[4].size();
        pArmy += planetArmy[5].size();
        pArmy += planetArmy[6].size();

        eArmy += enemyArmy[0].size();
        eArmy += enemyArmy[1].size();
        eArmy += enemyArmy[2].size();
        eArmy += enemyArmy[3].size();

        initial[0] = pArmy;
        initial[1] = eArmy;

        return initial;
    }


    public int getTotalMetalWaste() {
        return totalMetalWaste;
    }

    public void setTotalMetalWaste(int totalMetalWaste) {
        this.totalMetalWaste = totalMetalWaste;
    }


}