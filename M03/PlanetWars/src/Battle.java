import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Battle implements Variables{
	private ArrayList<MilitaryUnit>[] planetArmy;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	private String battleDevelopment;
	private int[][] initialCostFleet;
	private int[] initialUnitsCant;
	private int[] wasteMetalDeuterium;
	private int[] enemyDrops;
	private int[] planetDrops;
	private int[][] resourcesLooses;
	private int[] actualNumberUnitsPlanet;
	private int[] actualNumberUnitsEnemy;
	
	public static void main(String[] args) throws IOException {		
		System.out.println("1");
		Planet p = new Planet();
		BaseDatos bd = new BaseDatos();
		Battle b = new Battle();
		Main m = new Main();
		System.out.println("2");
		bd.setPlanetDeuterium(1, 10000000);
		bd.setPlanetMetal(1, 10000000);
		System.out.println("3");
		try {
			p.addLigthHunter(10);
			p.addHeavyHunter(8);
			p.addBattleShip(6);
			p.addArmoredShip(0);
			
			p.addMissileLauncher(9);
			p.addIonCannon(1);
			p.addPlasmaCannon(1);
			
			b.planetArmy = p.getArmy();
			b.enemyArmy = m.createEnemyArmy();
			
			System.out.println("--------");
			b.initialCostFleet = b.getCostFleets(b.planetArmy, b.enemyArmy);
			System.out.println("Metal Army: " + b.initialCostFleet[0][0]);
			System.out.println("Deuterium Army: " + b.initialCostFleet[0][1]);
			System.out.println("Metal Enemie: " + b.initialCostFleet[1][0]);
			System.out.println("Deuterium Enemie: " + b.initialCostFleet[1][1]);
			System.out.println("--------");
			b.initialUnitsCant = b.getInitialUnits(b.planetArmy, b.enemyArmy);
			System.out.println("Planet Units: " + b.initialUnitsCant[0]);
			System.out.println("Enemy Units: " + b.initialUnitsCant[1]);
			System.out.println("--------");
			
			int[] units = new int[2];
			units = b.getUnits(b.planetArmy, b.enemyArmy);
			
			System.out.println("Actual planet Units: " + units[0]);
			System.out.println("Actual enemy Units: " + units[1]);
			
			int army_pcent = (int) (units[0] * 0.25f);
			int enemy_pcent = (int) (units[1] * 0.25f);
			int turn = 0;
			while (army_pcent < units[0] && enemy_pcent < units[1]){
				System.out.println("On Battle");
				if (turn % 2 == 0) {
					
					int atkGroup = (int) (Math.random() * p.getArmy().length);
					System.out.println(atkGroup);
					int atkUnit = (int) (Math.random() * p.getArmy()[atkGroup].size());				
					System.out.println(atkUnit);
					
					int defGroup = (int) (Math.random() * b.enemyArmy.length);
					System.out.println(defGroup);
					int defUnit = (int) (Math.random() * b.enemyArmy[defGroup].size());				
					System.out.println(defUnit);
					
					
					
					b.planetArmy[atkGroup].get(atkUnit).takeDamage(b.enemyArmy[defGroup].get(defUnit).attack());
					turn += 1;
				}
				
				break;
			}
			
		} catch (ResourceException e) { }
	}
	
	public int[][] getCostFleets(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy)
	{
				
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
	
	public int[] getInitialUnits(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy)
	{
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
	
	public int[] getUnits(ArrayList<MilitaryUnit>[] planetArmy, ArrayList<MilitaryUnit>[] enemyArmy)
	{
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

}