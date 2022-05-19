import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Planet implements Variables{
	private int technologyDefense;
	private int technologyAtack;
	private int metal = 1000000000;
	private int deuterium = 1000000000;
	private int upgradeDefenseTechnologyDeuteriumCost;
	private int upgradeAttackTechnologyDeuteriumCost;
	private ArrayList<MilitaryUnit>[] army = new ArrayList[7];
	private BaseDatos bd = new BaseDatos();
	private int battleCant;
	
	public int getTechnologyDefense() {
		return technologyDefense;
	}
	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}
	public int getTechnologyAtack() {
		return technologyAtack;
	}
	public void setTechnologyAtack(int technologyAtack) {
		this.technologyAtack = technologyAtack;
	}
	public int getMetal() {
		return metal;
	}
	public void setMetal(int metal) {
		this.metal = metal;
	}
	public int getDeuterium() {
		return deuterium;
	}
	public void setDeuterium(int deuterium) {
		this.deuterium = deuterium;
	}
	public int getUpgradeDefenseTechnologyDeuteriumCost() {
		return upgradeDefenseTechnologyDeuteriumCost;
	}
	public void setUpgradeDefenseTechnologyDeuteriumCost(int upgradeDefenseTechnologyDeuteriumCost) {
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
	}
	public int getUpgradeAttackTechnologyDeuteriumCost() {
		return upgradeAttackTechnologyDeuteriumCost;
	}
	public void setUpgradeAttackTechnologyDeuteriumCost(int upgradeAttackTechnologyDeuteriumCost) {
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
	}
	public ArrayList<MilitaryUnit>[] getArmy() {
		return army;
	}
	public void setArmy(ArrayList<MilitaryUnit>[] army) {
		this.army = army;
	}
	
	public Planet()
	{
		this.battleCant = 0;
		army[0] = new ArrayList<MilitaryUnit>();
		army[1] = new ArrayList<MilitaryUnit>();
		army[2] = new ArrayList<MilitaryUnit>();
		army[3] = new ArrayList<MilitaryUnit>();
		army[4] = new ArrayList<MilitaryUnit>();
		army[5] = new ArrayList<MilitaryUnit>();
		army[6] = new ArrayList<MilitaryUnit>();
	}
	
	public void upgradeTechnologyDefense(int n) throws ResourceException, ClassNotFoundException, SQLException
	{
		int price = UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST + (UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST / UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST);		
		int cant = 0;
		if (bd.getPlanetDeuterium(1) >= (price * n)) {
			System.out.println("Se pueden comprar todos");
			bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (price * n));
			try {
				bd.setPlanetDefTech(getPlanetID(), bd.getPlanetDefTech(getPlanetID()) + n);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (price * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (price * (n-i)));
					try {
						bd.setPlanetDefTech(getPlanetID(), bd.getPlanetDefTech(getPlanetID()) + (n-i));
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			throw new ResourceException();
		}
	}
		
	public void upgradeTechnologyAttack(int n) throws ResourceException, ClassNotFoundException, SQLException
	{
		int price = UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST + (UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST / UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST);		
		int cant = 0;
		
		if (bd.getPlanetDeuterium(1) >= (price * n)) {
			System.out.println("Se pueden comprar todos");
			bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (price * n));
			try {
				bd.setPlanetAtkTech(getPlanetID(), bd.getPlanetAtkTech(getPlanetID()) + n);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (price * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (price * (n-i)));
					try {
						bd.setPlanetAtkTech(getPlanetID(), bd.getPlanetAtkTech(getPlanetID()) + (n-i));
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			throw new ResourceException();
		}

	}
	
	public void addLigthHunter(int n) throws ResourceException
	{
		int cant = 0;
		System.out.println("GEPLANETDEU -> " + bd.getPlanetDeuterium(1));
		System.out.println("GEPLANETMETAL -> " + bd.getPlanetMetal(1));
		if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_LIGTHHUNTER * n) && bd.getPlanetMetal(1) >= (METAL_COST_LIGTHHUNTER * n)) {
			System.out.println("Se pueden comprar todos");
			bd.setPlanetMetal(1, bd.getPlanetMetal(1) - METAL_COST_LIGTHHUNTER * n);
			bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_LIGTHHUNTER * n));
			for (int i = 0; i < n; i++) {
				army[0].add(new LightHunter(ARMOR_LIGTHHUNTER, BASE_DAMAGE_LIGTHHUNTER));
				cant += 1;
			}
			System.out.println(army[0].toString());
			try {
				bd.addShip(1, 1, cant, bd.getPlanetAtkTech(1));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_LIGTHHUNTER * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_LIGTHHUNTER * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					bd.setPlanetMetal(1, bd.getPlanetMetal(1) - (METAL_COST_LIGTHHUNTER * (n-i)));
					bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_LIGTHHUNTER * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[0].add(new LightHunter(ARMOR_LIGTHHUNTER, BASE_DAMAGE_LIGTHHUNTER));
						cant+=1;
					}
					try {
						bd.addShip(1, 1, cant, bd.getPlanetAtkTech(1));
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			System.out.println(army.toString());
			throw new ResourceException();
		}
	}
	
	public void addHeavyHunter(int n) throws ResourceException
		{
			int cant = 0;
			if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_HEAVYHUNTER * n) && bd.getPlanetMetal(1) >= (METAL_COST_HEAVYHUNTER * n)) {
				System.out.println("Se pueden comprar todos");
				bd.setPlanetMetal(1, bd.getPlanetMetal(1) - METAL_COST_HEAVYHUNTER * n);
				bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_HEAVYHUNTER * n));
				for (int i = 0; i < n; i++) {
					army[1].add(new HeavyHunter(ARMOR_HEAVYHUNTER, BASE_DAMAGE_HEAVYHUNTER));
					cant += 1;
				}
				try {
					bd.addShip(1, 2, cant, bd.getPlanetAtkTech(1));
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(army[1].toString());
			}
			else
			{
				for (int i = 0; i < n; i++) {
					if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_HEAVYHUNTER * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_HEAVYHUNTER * (n-i))) {
						System.out.println("Se pueden comprar " + (n-i));
						bd.setPlanetMetal(1, bd.getPlanetMetal(1) - (METAL_COST_HEAVYHUNTER * (n-i)));
						bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_HEAVYHUNTER * (n-i)));
						for (int j = 0; j < (n-i); j++) {
							army[1].add(new HeavyHunter(ARMOR_HEAVYHUNTER, BASE_DAMAGE_HEAVYHUNTER));
							cant += 1;
						}
						try {
							bd.addShip(1, 2, cant, bd.getPlanetAtkTech(1));
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					}
				}
				throw new ResourceException();
			}
		}

	public void addBattleShip(int n) throws ResourceException
	{
		int cant = 0;
		if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_BATTLESHIP * n) && bd.getPlanetMetal(1) >= (METAL_COST_BATTLESHIP * n)) {
			System.out.println("Se pueden comprar todos");
			bd.setPlanetMetal(1, bd.getPlanetMetal(1) - METAL_COST_BATTLESHIP * n);
			bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_BATTLESHIP * n));
			for (int i = 0; i < n; i++) {
				army[2].add(new BattleShip(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
				cant += 1;
			}
			try {
				bd.addShip(1, 3, cant, bd.getPlanetAtkTech(1));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(army[2].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_BATTLESHIP * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_BATTLESHIP * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					bd.setPlanetMetal(1, bd.getPlanetMetal(1) - (METAL_COST_BATTLESHIP * (n-i)));
					bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_BATTLESHIP * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[2].add(new BattleShip(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
						cant += 1;
					}
					try {
						bd.addShip(1, 3, cant, bd.getPlanetAtkTech(1));
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			throw new ResourceException();
		}
	}
	
	public void addArmoredShip(int n) throws ResourceException
	{
		int cant = 0;
		if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_ARMOREDSHIP * n) && bd.getPlanetMetal(1) >= (METAL_COST_ARMOREDSHIP * n)) {
			System.out.println("Se pueden comprar todos");
			bd.setPlanetMetal(1, bd.getPlanetMetal(1) - METAL_COST_ARMOREDSHIP * n);
			bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_ARMOREDSHIP * n));
			for (int i = 0; i < n; i++) {
				army[3].add(new ArmoredShip(ARMOR_ARMOREDSHIP, BASE_DAMAGE_ARMOREDSHIP));
				cant += 1;
			}
			try {
				bd.addShip(1, 4, cant, bd.getPlanetAtkTech(1));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(army[3].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_ARMOREDSHIP * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_ARMOREDSHIP * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					bd.setPlanetMetal(1, bd.getPlanetMetal(1) - (METAL_COST_ARMOREDSHIP * (n-i)));
					bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_ARMOREDSHIP * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[3].add(new ArmoredShip(ARMOR_ARMOREDSHIP, BASE_DAMAGE_ARMOREDSHIP));
						cant += 1;
					}
					try {
						bd.addShip(1, 4, cant, bd.getPlanetAtkTech(1));
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			throw new ResourceException();
		}
	}
	
	
	public void addMissileLauncher(int n) throws ResourceException
	{
		int cant = 0;
		if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_MISSILELAUNCHER * n) && bd.getPlanetMetal(1) >= (METAL_COST_MISSILELAUNCHER * n)) {
			System.out.println("Se pueden comprar todos");
			bd.setPlanetMetal(1, bd.getPlanetMetal(1) - METAL_COST_MISSILELAUNCHER * n);
			bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_MISSILELAUNCHER * n));
			for (int i = 0; i < n; i++) {
				army[4].add(new MisileLauncher(ARMOR_MISSILELAUNCHER,BASE_DAMAGE_MISSILELAUNCHER));
				cant += 1;
			}
			try {
				bd.addDefense(1, 1, cant, bd.getPlanetDefTech(1));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(army[4].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_MISSILELAUNCHER * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_MISSILELAUNCHER * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					bd.setPlanetMetal(1, bd.getPlanetMetal(1) - (METAL_COST_MISSILELAUNCHER * (n-i)));
					bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_MISSILELAUNCHER * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[4].add(new MisileLauncher(ARMOR_MISSILELAUNCHER,BASE_DAMAGE_MISSILELAUNCHER));
						cant += 1;
					}
					try {
						bd.addDefense(1, 1, cant, bd.getPlanetDefTech(1));
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			throw new ResourceException();
		}
	}
	
	public void addIonCannon(int n) throws ResourceException
	{
		int cant = 0;
		if (bd.getPlanetDeuterium(1)  >= (DEUTERIUM_COST_IONCANNON * n) && bd.getPlanetMetal(1) >= (METAL_COST_IONCANNON * n)) {
			System.out.println("Se pueden comprar todos");
			bd.setPlanetMetal(1, bd.getPlanetMetal(1) - METAL_COST_IONCANNON * n);
			bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_IONCANNON * n));
			for (int i = 0; i < n; i++) {
				army[5].add(new IonCannon(ARMOR_IONCANNON,BASE_DAMAGE_IONCANNON));
				cant += 1;
			}
			try {
				bd.addDefense(1, 2, cant, bd.getPlanetDefTech(1));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(army[5].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_IONCANNON * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_IONCANNON * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					bd.setPlanetMetal(1, bd.getPlanetMetal(1) - (METAL_COST_IONCANNON * (n-i)));
					bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_IONCANNON * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[5].add(new IonCannon(ARMOR_IONCANNON,BASE_DAMAGE_IONCANNON));
						cant += 1;
					}
					try {
						bd.addDefense(1, 2, cant, bd.getPlanetDefTech(1));
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			System.out.println(army.toString());
			throw new ResourceException();
		}
	}
	
	public void addPlasmaCannon(int n) throws ResourceException
	{
		int cant = 0;
		if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_PLASMACANNON * n) && bd.getPlanetMetal(1) >= (METAL_COST_PLASMACANNON * n)) {
			System.out.println("Se pueden comprar todos");
			bd.setPlanetMetal(1, bd.getPlanetMetal(1) - METAL_COST_PLASMACANNON * n);
			bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_PLASMACANNON * n));
			for (int i = 0; i < n; i++) {
				army[6].add(new PlasmaCannon(ARMOR_PLASMACANNON,BASE_DAMAGE_PLASMACANNON));
				cant += 1;
			}
			try {
				bd.addDefense(1, 3, cant, bd.getPlanetDefTech(1));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(army[6].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_PLASMACANNON * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_PLASMACANNON * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					bd.setPlanetMetal(1, bd.getPlanetMetal(1) - (METAL_COST_PLASMACANNON * (n-i)));
					bd.setPlanetDeuterium(1, bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_PLASMACANNON * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[6].add(new PlasmaCannon(ARMOR_PLASMACANNON,BASE_DAMAGE_PLASMACANNON));
						cant += 1;
					}
					try {
						bd.addDefense(1, 3, cant, bd.getPlanetDefTech(1));
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
			throw new ResourceException();
		}
	}
	public int getUserID() {
		return 55555;
	}
	public int getPlanetID() {
		return 1;
	}
	public int getBattleID() {
		return this.battleCant;
	}
	public void setBattleID(int battleID) {
		this.battleCant = battleID;		
	}

}

class ResourceException extends Exception
{
	public ResourceException() {
		 System.out.println("You don't have the resources to build this");
	}
	
	public ResourceException(String m){ super(m); }
}
