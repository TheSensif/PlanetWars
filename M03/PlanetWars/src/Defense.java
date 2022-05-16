
public class Defense implements MilitaryUnit, Variables{
	public Defense(int armor2, int baseDamage2) {
		
	}
	private int armor;
	private int initialArmor;
	private int baseDamage;
	
	
	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void takeDamage(int receivedDamage) {
		this.armor -= receivedDamage;
		
	}
	@Override
	public int getActualArmor() {
		return armor;
	}
	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int[] getChanceGeneratinWaste() {
		return null;
	}
	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void resetArmor() {
		this.armor = initialArmor;
	}
}
