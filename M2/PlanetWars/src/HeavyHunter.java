
public class HeavyHunter extends Ship{

	public HeavyHunter(int armor, int baseDamage) {
		super(armor, baseDamage);
	}

	public HeavyHunter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void takeDamage(int receivedDamage) {
		this.setArmor(this.getArmor() - receivedDamage);		
		
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
		if (random > CHANCE_GENERATNG_WASTE_HEAVYHUNTER) {
			System.out.println("No se generan");
			gen[0] = 0;
			gen[1] = 0;
		}
		else if (random <= CHANCE_GENERATNG_WASTE_HEAVYHUNTER) {
			gen[0] = ((int)(METAL_COST_HEAVYHUNTER + (METAL_COST_HEAVYHUNTER * 0.7)));
			gen[1] = ((int)(DEUTERIUM_COST_HEAVYHUNTER + (DEUTERIUM_COST_HEAVYHUNTER * 0.7)));;
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
		// TODO Auto-generated method stub
		
	}

}
