package cards;

/**
 * Representa una carta abstracta
 * @author pbelmonte
 *
 */
public abstract class AbstractCard implements ICard {
	
	private String name;
	private int life;
	private int damage;
	private int attackPoints;
	
	/**
	 * Constructor
	 * @param name Nombre de la carta
	 * @param life Vida total de la carta
	 * @param damage Contador de daño
	 * @param attackPoints Puntos de ataque o de accion
	 */
	public AbstractCard(String name, int life, int damage, int attackPoints) {
		this.name = name;
		this.life = life;
		this.damage = damage;
		this.attackPoints = attackPoints;
	}
	
	public boolean isAlive() {
		return life > damage;
	}
	
	public int getAttackPoints() {
		return attackPoints;
	}
	
	public abstract void attack(ICard card);
	
	public void receiveAttack(int points) {
		damage += points;
	}
	
	public void heal(int points) {
		damage -= points;
	}
	
	public void raiseAttack(int points) {
		attackPoints += points;
	}
	
	public void reduceAttack(int points) {
		attackPoints -= points;
	}
	
	public void receiveAssassinAttack(Assassin assassin) {
		receiveAttack(assassin.getAttackPoints());
	}
	
	public void receiveWarlockAttack(Warlock warlock) {
		receiveAttack(warlock.getAttackPoints());
	}
	
	public void receiveKnightAttack(Knight knight) {
		receiveAttack(knight.getAttackPoints());
	}
	
	public void receiveMageAttack(Mage mage) {
		receiveAttack(mage.getAttackPoints());
	}
	
	public void receiveHunterAttack(Hunter hunter) {
		receiveAttack(hunter.getAttackPoints());
	}
	
	public void receiveHealerAttack(Healer healer) {
		if (isAlive()) {
			heal(healer.getAttackPoints() / 2);
		}
	}
	
	public void receiveDruidAttack(Druid druid) {
		raiseAttack(druid.getAttackPoints());
		receiveAttack(druid.getAttackPoints() / 2);
	}
	
	public void receivePaladinAttack(Paladin paladin) {
		if (isAlive()) {
			raiseAttack(paladin.getAttackPoints() / 3);
			heal(paladin.getAttackPoints() / 3);
		}
	}
	
	public void receiveShamanAttack(Shaman shaman) {
		reduceAttack(shaman.getAttackPoints() / 3);
		receiveAttack(shaman.getAttackPoints() / 3);
	}
	
}
