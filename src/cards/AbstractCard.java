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
	
	public void receiveAssassinAttack(Assassin assassin) {
		damage += assassin.getAttackPoints();
	}
	
	public void receiveWarlockAttack(Warlock warlock) {
		damage += warlock.getAttackPoints();
	}
	public void receiveKnightAttack(Knight knight) {
		damage += knight.getAttackPoints();
	}
	
	public void receiveMageAttack(Mage mage) {
		damage += mage.getAttackPoints();
	}
	
	public void receiveHunterAttack(Hunter hunter) {
		damage += hunter.getAttackPoints();
	}
	
	public void receiveHealerAttack(Healer healer) {
		if (isAlive()) {
			damage -= healer.getAttackPoints() / 2;
		}
	}
	
	public void receiveDruidAttack(Druid druid) {
		attackPoints += druid.getAttackPoints();
		damage += druid.getAttackPoints() / 2;
	}
	
	public void receivePaladinAttack(Paladin paladin) {
		attackPoints += paladin.getAttackPoints() / 3;
		if (isAlive()) {
			damage -= paladin.getAttackPoints() / 3;
		}
	}
	
	public void receiveShamanAttack(Shaman shaman) {
		attackPoints -= shaman.getAttackPoints() / 3;
		damage += shaman.getAttackPoints() / 3;
	}
	
}
