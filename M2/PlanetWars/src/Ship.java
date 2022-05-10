public abstract class Ship implements MilitaryUnit, Variables{
	private int armor;
	private int initialArmor;
	private int baseDamage;

	public Ship(int armor, int initialArmor, int baseDamage) {
		super();
		this.armor = armor;
		this.initialArmor = initialArmor;
		this.baseDamage = baseDamage;
	}

	public Ship() {	}
}