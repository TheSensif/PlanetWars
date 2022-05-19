
public interface MilitaryUnit {
	abstract int attack();
	// Nos devolver� el poder de ataque que tenga la unidad.
	abstract void takeDamage(int receivedDamage);
	// Restar� a nuestro blindaje el da�o recibido por par�metro.
	abstract int getActualArmor();
	// Nos devolver� el blindaje que tengamos actualmente, despu�s de haber recibido un ataque.
	abstract int getMetalCost();
	// Nos devolver� el coste de Metal que tiene crear una nueva unidad.
	abstract int getDeuteriumCost();
	// Nos devolver� el coste de Deuterium que tiene crear una nueva unidad.
	abstract int[] getChanceGeneratinWaste();
	// Nos la probabilidad de generar residuos al ser totalmente eliminada (blindaje 0 o inferior).
	abstract int getChanceAttackAgain();
	// Nos la probabilidad de generar volver a atacar.
	abstract void resetArmor();
	// Nos restablecer� nuestro blindaje a su valor original
	abstract int getDamage();
}
