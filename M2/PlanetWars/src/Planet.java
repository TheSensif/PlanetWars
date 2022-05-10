import java.util.ArrayList;
import java.util.Iterator;

public class Planet implements Variables{
	private int technologyDefense;
	private int technologyAtack;
	private int metal;
	private int deuterium;
	private int upgradeDefenseTechnologyDeuteriumCost;
	private int upgradeAttackTechnologyDeuteriumCost;
	private ArrayList<MilitaryUnit>[] army = new ArrayList[7];
	
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
	
	public static void main(String[] args) {
		Planet p = new Planet();
		p.army[0] = new ArrayList<MilitaryUnit>();
		p.army[1] = new ArrayList<MilitaryUnit>();
		p.army[2] = new ArrayList<MilitaryUnit>();
		p.army[3] = new ArrayList<MilitaryUnit>();
		p.army[4] = new ArrayList<MilitaryUnit>();
		p.army[5] = new ArrayList<MilitaryUnit>();
		p.army[6] = new ArrayList<MilitaryUnit>();
		
		try {
			p.upgradeTechnologyDefense();
		} catch (ResourceException e) { }
	}
	
	public void upgradeTechnologyDefense() throws ResourceException
	{
		int price = 0;
		int total = 0;
		if (getTechnologyDefense() == 0) {
			price = UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
		}
		else
		{
			for (int i = 0; i < getTechnologyDefense(); i++) {
				int p = UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST 
						+ ((UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST 
						* UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST) / 100);
				total += p;
			}
		}
		
		System.out.println(total);
		
		if (price <= getDeuterium()) {
			setDeuterium(getDeuterium() - price);
			setTechnologyDefense(getTechnologyDefense() + 1);
		}
		else
		{
			String str = "You can't upgrade the DEF Tech";
			throw new ResourceException();
		}
	}
		
	public void upgradeTechnologyAttack() throws ResourceException
	{
		int price = 0;
		int total = 0;
		if (getTechnologyAtack() == 0) {
			price = UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
		}
		else
		{
			for (int i = 0; i < getTechnologyAtack(); i++) {
				int p = UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST
						+ ((UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST 
						* UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST) / 100);
				total += p;
			}
		}
		
		System.out.println(total);
		
		if (price <= getDeuterium()) {
			setDeuterium(getDeuterium() - price);
			setTechnologyAtack(getTechnologyAtack() + 1);
		}
		else
		{
			String str = "You can't upgrade the DEF Tech";
			throw new ResourceException();
		}
	}
	
	
	public void addLigthHunter(int n) throws ResourceException
	{
		if (getDeuterium() >= (DEUTERIUM_COST_LIGTHHUNTER * n) && getMetal() >= (METAL_COST_LIGTHHUNTER * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(getMetal() - METAL_COST_LIGTHHUNTER * n);
			setDeuterium(getDeuterium() - (DEUTERIUM_COST_LIGTHHUNTER * n));
			for (int i = 0; i < n; i++) {
				army[0].add(new LightHunter(ARMOR_LIGTHHUNTER,ARMOR_LIGTHHUNTER, BASE_DAMAGE_LIGTHHUNTER));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (getDeuterium() >= (DEUTERIUM_COST_LIGTHHUNTER * (n-i)) && getMetal() >= (METAL_COST_LIGTHHUNTER * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(getMetal() - (METAL_COST_LIGTHHUNTER * (n-i)));
					setDeuterium(getDeuterium() - (DEUTERIUM_COST_LIGTHHUNTER * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[0].add(new LightHunter(ARMOR_LIGTHHUNTER,ARMOR_LIGTHHUNTER, BASE_DAMAGE_LIGTHHUNTER));
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
			if (getDeuterium() >= (DEUTERIUM_COST_HEAVYHUNTER * n) && getMetal() >= (METAL_COST_HEAVYHUNTER * n)) {
				System.out.println("Se pueden comprar todos");
				setMetal(getMetal() - METAL_COST_HEAVYHUNTER * n);
				setDeuterium(getDeuterium() - (DEUTERIUM_COST_HEAVYHUNTER * n));
				for (int i = 0; i < n; i++) {
					army[1].add(new HeavyHunter(ARMOR_HEAVYHUNTER,ARMOR_HEAVYHUNTER, BASE_DAMAGE_HEAVYHUNTER));
				}
				System.out.println(army[0].toString());
			}
			else
			{
				for (int i = 0; i < n; i++) {
					if (getDeuterium() >= (DEUTERIUM_COST_HEAVYHUNTER * (n-i)) && getMetal() >= (METAL_COST_HEAVYHUNTER * (n-i))) {
						System.out.println("Se pueden comprar " + (n-i));
						setMetal(getMetal() - (METAL_COST_HEAVYHUNTER * (n-i)));
						setDeuterium(getDeuterium() - (DEUTERIUM_COST_HEAVYHUNTER * (n-i)));
						for (int j = 0; j < (n-i); j++) {
							army[1].add(new HeavyHunter(ARMOR_HEAVYHUNTER,ARMOR_HEAVYHUNTER, BASE_DAMAGE_HEAVYHUNTER));
						}
						break;
					}
				}
				System.out.println(army.toString());
				throw new ResourceException();
			}
		}

	public void addBattleShip(int n) throws ResourceException
	{
		if (getDeuterium() >= (DEUTERIUM_COST_BATTLESHIP * n) && getMetal() >= (METAL_COST_BATTLESHIP * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(getMetal() - METAL_COST_BATTLESHIP * n);
			setDeuterium(getDeuterium() - (DEUTERIUM_COST_BATTLESHIP * n));
			for (int i = 0; i < n; i++) {
				army[2].add(new BattleShip(ARMOR_BATTLESHIP,ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (getDeuterium() >= (DEUTERIUM_COST_BATTLESHIP * (n-i)) && getMetal() >= (METAL_COST_BATTLESHIP * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(getMetal() - (METAL_COST_BATTLESHIP * (n-i)));
					setDeuterium(getDeuterium() - (DEUTERIUM_COST_BATTLESHIP * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[2].add(new BattleShip(ARMOR_BATTLESHIP,ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
					}
					break;
				}
			}
			System.out.println(army.toString());
			throw new ResourceException();
		}
	}
	
	public void addArmoredShip(int n) throws ResourceException
	{
		if (getDeuterium() >= (DEUTERIUM_COST_ARMOREDSHIP * n) && getMetal() >= (METAL_COST_ARMOREDSHIP * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(getMetal() - METAL_COST_ARMOREDSHIP * n);
			setDeuterium(getDeuterium() - (DEUTERIUM_COST_ARMOREDSHIP * n));
			for (int i = 0; i < n; i++) {
				army[3].add(new ArmoredShip(ARMOR_ARMOREDSHIP,ARMOR_ARMOREDSHIP, BASE_DAMAGE_ARMOREDSHIP));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (getDeuterium() >= (DEUTERIUM_COST_ARMOREDSHIP * (n-i)) && getMetal() >= (METAL_COST_ARMOREDSHIP * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(getMetal() - (METAL_COST_ARMOREDSHIP * (n-i)));
					setDeuterium(getDeuterium() - (DEUTERIUM_COST_ARMOREDSHIP * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[3].add(new ArmoredShip(ARMOR_ARMOREDSHIP,ARMOR_ARMOREDSHIP, BASE_DAMAGE_ARMOREDSHIP));
					}
					break;
				}
			}
			System.out.println(army.toString());
			throw new ResourceException();
		}
	}
	
	public void addMissileLauncher(int n) throws ResourceException
	{
		if (getDeuterium() >= (DEUTERIUM_COST_MISSILELAUNCHER * n) && getMetal() >= (METAL_COST_MISSILELAUNCHER * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(getMetal() - METAL_COST_MISSILELAUNCHER * n);
			setDeuterium(getDeuterium() - (DEUTERIUM_COST_MISSILELAUNCHER * n));
			for (int i = 0; i < n; i++) {
				army[4].add(new MisileLauncher(ARMOR_MISSILELAUNCHER,BASE_DAMAGE_MISSILELAUNCHER));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (getDeuterium() >= (DEUTERIUM_COST_MISSILELAUNCHER * (n-i)) && getMetal() >= (METAL_COST_MISSILELAUNCHER * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(getMetal() - (METAL_COST_MISSILELAUNCHER * (n-i)));
					setDeuterium(getDeuterium() - (DEUTERIUM_COST_MISSILELAUNCHER * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[4].add(new MisileLauncher(ARMOR_MISSILELAUNCHER,BASE_DAMAGE_MISSILELAUNCHER));
					}
					break;
				}
			}
			System.out.println(army.toString());
			throw new ResourceException();
		}
	}
	
	public void addIonCannon(int n) throws ResourceException
	{
		if (getDeuterium() >= (DEUTERIUM_COST_IONCANNON * n) && getMetal() >= (METAL_COST_IONCANNON * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(getMetal() - METAL_COST_IONCANNON * n);
			setDeuterium(getDeuterium() - (DEUTERIUM_COST_IONCANNON * n));
			for (int i = 0; i < n; i++) {
				army[5].add(new IonCannon(ARMOR_IONCANNON,BASE_DAMAGE_IONCANNON));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (getDeuterium() >= (DEUTERIUM_COST_IONCANNON * (n-i)) && getMetal() >= (METAL_COST_IONCANNON * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(getMetal() - (METAL_COST_IONCANNON * (n-i)));
					setDeuterium(getDeuterium() - (DEUTERIUM_COST_IONCANNON * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[5].add(new IonCannon(ARMOR_IONCANNON,BASE_DAMAGE_IONCANNON));
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
		if (getDeuterium() >= (DEUTERIUM_COST_PLASMACANNON * n) && getMetal() >= (METAL_COST_PLASMACANNON * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(getMetal() - METAL_COST_PLASMACANNON * n);
			setDeuterium(getDeuterium() - (DEUTERIUM_COST_PLASMACANNON * n));
			for (int i = 0; i < n; i++) {
				army[6].add(new PlasmaCannon(ARMOR_PLASMACANNON,BASE_DAMAGE_PLASMACANNON));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (getDeuterium() >= (DEUTERIUM_COST_PLASMACANNON * (n-i)) && getMetal() >= (METAL_COST_PLASMACANNON * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(getMetal() - (METAL_COST_PLASMACANNON * (n-i)));
					setDeuterium(getDeuterium() - (DEUTERIUM_COST_PLASMACANNON * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[6].add(new PlasmaCannon(ARMOR_PLASMACANNON,BASE_DAMAGE_PLASMACANNON));
					}
					break;
				}
			}
			System.out.println(army.toString());
			throw new ResourceException();
		}
	}

	
	public void refreshPlanetStats()
	{
		String planetName = "SICKLAND";
		
		int LightHunterUnits = 0;
		int HeavyHunterUnits = 0;
		int BattleShipUnits = 0;
		int ArmoredShipUnits = 0;
		
		int MissileLauncherUnits = 0;
		int IonCannonUnits = 0;
		int PlasmaCannonUnits = 0;
		
		int Metal = 0;
		int Deuterium = 0;
	}
}

class ResourceException extends Exception
{
	public ResourceException() {
		 System.out.println("You don't have the resources to build this");
	}
	
	public ResourceException(String m){
		super(m);
	}
}
