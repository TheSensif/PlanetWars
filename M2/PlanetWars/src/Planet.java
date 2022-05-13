import java.util.ArrayList;
import java.util.Iterator;

public class Planet implements Variables{
	private int technologyDefense;
	private int technologyAtack;
	private int metal = 1000000;
	private int deuterium = 1000;
	private int upgradeDefenseTechnologyDeuteriumCost;
	private int upgradeAttackTechnologyDeuteriumCost;
	private ArrayList<MilitaryUnit>[] army = new ArrayList[7];
	private BaseDatos bd;
	private Main m;
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
		army[0] = new ArrayList<MilitaryUnit>();
		army[1] = new ArrayList<MilitaryUnit>();
		army[2] = new ArrayList<MilitaryUnit>();
		army[3] = new ArrayList<MilitaryUnit>();
		army[4] = new ArrayList<MilitaryUnit>();
		army[5] = new ArrayList<MilitaryUnit>();
		army[6] = new ArrayList<MilitaryUnit>();
	}
	
	public static void main(String[] args) {
		Planet p = new Planet();
		try {
			p.addLigthHunter(10, 1);
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
	
	
	public void addLigthHunter(int planetID, int n) throws ResourceException
	{
		if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_LIGTHHUNTER * n) && bd.getPlanetMetal(1) >= (METAL_COST_LIGTHHUNTER * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(bd.getPlanetMetal(1) - METAL_COST_LIGTHHUNTER * n);
			setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_LIGTHHUNTER * n));
			for (int i = 0; i < n; i++) {
				army[0].add(new LightHunter(ARMOR_LIGTHHUNTER, BASE_DAMAGE_LIGTHHUNTER));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_LIGTHHUNTER * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_LIGTHHUNTER * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(bd.getPlanetMetal(1) - (METAL_COST_LIGTHHUNTER * (n-i)));
					setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_LIGTHHUNTER * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[0].add(new LightHunter(ARMOR_LIGTHHUNTER, BASE_DAMAGE_LIGTHHUNTER));
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
			if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_HEAVYHUNTER * n) && bd.getPlanetMetal(1) >= (METAL_COST_HEAVYHUNTER * n)) {
				System.out.println("Se pueden comprar todos");
				setMetal(bd.getPlanetMetal(1) - METAL_COST_HEAVYHUNTER * n);
				setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_HEAVYHUNTER * n));
				for (int i = 0; i < n; i++) {
					army[1].add(new HeavyHunter(ARMOR_HEAVYHUNTER, BASE_DAMAGE_HEAVYHUNTER));
				}
				System.out.println(army[0].toString());
			}
			else
			{
				for (int i = 0; i < n; i++) {
					if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_HEAVYHUNTER * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_HEAVYHUNTER * (n-i))) {
						System.out.println("Se pueden comprar " + (n-i));
						setMetal(bd.getPlanetMetal(1) - (METAL_COST_HEAVYHUNTER * (n-i)));
						setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_HEAVYHUNTER * (n-i)));
						for (int j = 0; j < (n-i); j++) {
							army[1].add(new HeavyHunter(ARMOR_HEAVYHUNTER, BASE_DAMAGE_HEAVYHUNTER));
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
		if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_BATTLESHIP * n) && bd.getPlanetMetal(1) >= (METAL_COST_BATTLESHIP * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(bd.getPlanetMetal(1) - METAL_COST_BATTLESHIP * n);
			setDeuterium(getDeuterium() - (DEUTERIUM_COST_BATTLESHIP * n));
			for (int i = 0; i < n; i++) {
				army[2].add(new BattleShip(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_BATTLESHIP * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_BATTLESHIP * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(bd.getPlanetMetal(1) - (METAL_COST_BATTLESHIP * (n-i)));
					setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_BATTLESHIP * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[2].add(new BattleShip(ARMOR_BATTLESHIP, BASE_DAMAGE_BATTLESHIP));
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
		if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_ARMOREDSHIP * n) && bd.getPlanetMetal(1) >= (METAL_COST_ARMOREDSHIP * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(bd.getPlanetMetal(1) - METAL_COST_ARMOREDSHIP * n);
			setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_ARMOREDSHIP * n));
			for (int i = 0; i < n; i++) {
				army[3].add(new ArmoredShip(ARMOR_ARMOREDSHIP, BASE_DAMAGE_ARMOREDSHIP));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_ARMOREDSHIP * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_ARMOREDSHIP * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(bd.getPlanetMetal(1) - (METAL_COST_ARMOREDSHIP * (n-i)));
					setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_ARMOREDSHIP * (n-i)));
					for (int j = 0; j < (n-i); j++) {
						army[3].add(new ArmoredShip(ARMOR_ARMOREDSHIP, BASE_DAMAGE_ARMOREDSHIP));
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
		if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_MISSILELAUNCHER * n) && bd.getPlanetMetal(1) >= (METAL_COST_MISSILELAUNCHER * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(bd.getPlanetMetal(1) - METAL_COST_MISSILELAUNCHER * n);
			setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_MISSILELAUNCHER * n));
			for (int i = 0; i < n; i++) {
				army[4].add(new MisileLauncher(ARMOR_MISSILELAUNCHER,BASE_DAMAGE_MISSILELAUNCHER));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_MISSILELAUNCHER * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_MISSILELAUNCHER * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(bd.getPlanetMetal(1) - (METAL_COST_MISSILELAUNCHER * (n-i)));
					setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_MISSILELAUNCHER * (n-i)));
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
		if (bd.getPlanetDeuterium(1)  >= (DEUTERIUM_COST_IONCANNON * n) && bd.getPlanetMetal(1) >= (METAL_COST_IONCANNON * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(bd.getPlanetMetal(1) - METAL_COST_IONCANNON * n);
			setDeuterium(bd.getPlanetDeuterium(1)  - (DEUTERIUM_COST_IONCANNON * n));
			for (int i = 0; i < n; i++) {
				army[5].add(new IonCannon(ARMOR_IONCANNON,BASE_DAMAGE_IONCANNON));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_IONCANNON * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_IONCANNON * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(bd.getPlanetMetal(1) - (METAL_COST_IONCANNON * (n-i)));
					setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_IONCANNON * (n-i)));
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
		if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_PLASMACANNON * n) && bd.getPlanetMetal(1) >= (METAL_COST_PLASMACANNON * n)) {
			System.out.println("Se pueden comprar todos");
			setMetal(bd.getPlanetMetal(1) - METAL_COST_PLASMACANNON * n);
			setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_PLASMACANNON * n));
			for (int i = 0; i < n; i++) {
				army[6].add(new PlasmaCannon(ARMOR_PLASMACANNON,BASE_DAMAGE_PLASMACANNON));
			}
			System.out.println(army[0].toString());
		}
		else
		{
			for (int i = 0; i < n; i++) {
				if (bd.getPlanetDeuterium(1) >= (DEUTERIUM_COST_PLASMACANNON * (n-i)) && bd.getPlanetMetal(1) >= (METAL_COST_PLASMACANNON * (n-i))) {
					System.out.println("Se pueden comprar " + (n-i));
					setMetal(bd.getPlanetMetal(1) - (METAL_COST_PLASMACANNON * (n-i)));
					setDeuterium(bd.getPlanetDeuterium(1) - (DEUTERIUM_COST_PLASMACANNON * (n-i)));
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
		String planetName = bd.getPlanetName(1);
		
		int LightHunterUnits = getArmy()[0].size();
		int HeavyHunterUnits =  getArmy()[1].size();;
		int BattleShipUnits =  getArmy()[2].size();;
		int ArmoredShipUnits =  getArmy()[3].size();;
		
		int MissileLauncherUnits =  getArmy()[4].size();;
		int IonCannonUnits =  getArmy()[5].size();;
		int PlasmaCannonUnits =  getArmy()[6].size();;

		Integer metal = getMetal();
		Integer deuterium = getDeuterium();
		
		m.getnMetal().setText(metal.toString());
		m.getnDeuterium().setText(deuterium.toString());
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
