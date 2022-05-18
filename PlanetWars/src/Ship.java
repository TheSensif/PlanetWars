public abstract class Ship implements MilitaryUnit, Variables{
	private int armor;
	private int initialArmor;
	private int baseDamage;


	public Ship(int armor, int baseDamage) {		
		super();
		this.setArmor(armor);
		this.initialArmor = getArmor();
		this.baseDamage = baseDamage;	
	}


	public Ship() {	}


	public int getArmor() {
		return this.armor;
	}


	public void setArmor(int armor) {
		this.armor = armor;
	}


	public int getInitialArmor() {
		return initialArmor;
	}


	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
	}


	public int getBaseDamage() {
		return baseDamage;
	}


	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
}