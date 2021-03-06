
public class LightHunter extends Ship implements Variables{
	@Override
	public String toString() {
		return "Light Hunter";
	}
	public LightHunter(int armor, int baseDamage) {
		super(armor, baseDamage);
	}
	
	public LightHunter() {
		super(ARMOR_LIGTHHUNTER, BASE_DAMAGE_LIGTHHUNTER);
		
	}
	
	@Override
	public int attack() {
		return getBaseDamage();
	}

	@Override
	public void takeDamage(int receivedDamage) {
		this.setArmor(this.getActualArmor() - receivedDamage);		
	}

	@Override
	public int getActualArmor() {
		return getArmor();
	}

	@Override
	public int getMetalCost() {
		int metalCost = 0;
		return metalCost;
	}

	@Override
	public int getDeuteriumCost() {
		int deutCost = 0;
		return deutCost;
	}

	@Override
	public int[] getChanceGeneratinWaste() {
		int[] gen = new int[2];
		// CHANCE_GENERATNG_WASTE_LIGTHHUNTER
		double r = Math.random() * 100;
		int random = (int) r;
		if (random > CHANCE_GENERATNG_WASTE_LIGTHHUNTER) {
			System.out.println("No se generan");
			gen[0] = 0;
			gen[1] = 0;
		}
		else if (random <= CHANCE_GENERATNG_WASTE_LIGTHHUNTER) {
			gen[0] = ((int)(METAL_COST_LIGTHHUNTER + (METAL_COST_LIGTHHUNTER * 0.7)));
			gen[1] = ((int)(DEUTERIUM_COST_LIGTHHUNTER + (DEUTERIUM_COST_LIGTHHUNTER * 0.7)));;
			return gen;
		}
		return gen;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetArmor() {
		this.setArmor(this.getInitialArmor());
	}

	@Override
	public int getDamage() {
		return getBaseDamage();
	}
}
