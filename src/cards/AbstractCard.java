package cards;

/**
 * Represents an abstract card
 * 
 * @author Pedro Belmonte
 *
 */
public abstract class AbstractCard implements ICard {

  private String name;
  private int life;
  private int damage;
  private int attackPoints;

  /**
   * Constructor
   * 
   * @param name Name of the card
   * @param life Total life
   * @param damage Damage taken
   * @param attackPoints Attack or action points
   */
  public AbstractCard(String name, int life, int damage, int attackPoints) {
    this.name = name;
    this.life = life;
    this.damage = damage;
    this.attackPoints = attackPoints;
  }

  /**
   * Return true if total life is greater than damage
   */
  public boolean isAlive() {
    return life > damage;
  }

  /**
   * Return the name of the card
   */
  public String getName() {
    return name;
  }

  /**
   * Return total life
   */
  public int getLife() {
    return life;
  }

  /**
   * Return damage
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Return the attack points
   */
  public int getAttackPoints() {
    return attackPoints;
  }

  /**
   * Attack another card
   */
  public abstract void attack(ICard card);

  /**
   * Increase damage
   * 
   * @param points Amount to increase
   */
  void receiveAttack(int points) {
    damage += points;
  }

  /**
   * Decrease damage
   * 
   * @param points Amount to decrease
   */
  void heal(int points) {
    damage = Math.max(0, damage - points);
  }

  /**
   * Increase attack points
   * 
   * @param points Amount to increase
   */
  void raiseAttack(int points) {
    attackPoints += points;
  }

  /**
   * Decrease attack points
   * 
   * @param points Amount to decrease
   */
  void reduceAttack(int points) {
    attackPoints -= points;
  }

  /**
   * Receive an attack from an Assassin type card
   */
  public void receiveAssassinAttack(Assassin assassin) {
    receiveAttack(assassin.getAttackPoints());
  }

  /**
   * Receive an attack from a Warlock type card
   */
  public void receiveWarlockAttack(Warlock warlock) {
    receiveAttack(warlock.getAttackPoints());
  }

  /**
   * Receive an attack from a Knight type card
   */
  public void receiveKnightAttack(Knight knight) {
    receiveAttack(knight.getAttackPoints());
  }

  /**
   * Receive an attack from a Mage type card
   */
  public void receiveMageAttack(Mage mage) {
    receiveAttack(mage.getAttackPoints());
  }

  /**
   * Receive an attack from a Hunter type card
   */
  public void receiveHunterAttack(Hunter hunter) {
    receiveAttack(hunter.getAttackPoints());
  }

  /**
   * Receive an attack from a Healer type card
   */
  public void receiveHealerAttack(Healer healer) {
    if (isAlive()) {
      heal(healer.getAttackPoints() / 2);
    }
  }

  /**
   * Receive an attack from a Druid type card
   */
  public void receiveDruidAttack(Druid druid) {
    raiseAttack(druid.getAttackPoints());
    receiveAttack(druid.getAttackPoints() / 2);
  }

  /**
   * Receive an attack from a Paladin type card
   */
  public void receivePaladinAttack(Paladin paladin) {
    if (isAlive()) {
      raiseAttack(paladin.getAttackPoints() / 3);
      heal(paladin.getAttackPoints() / 3);
    }
  }

  /**
   * Receive an attack from a Shaman type card
   */
  public void receiveShamanAttack(Shaman shaman) {
    reduceAttack(shaman.getAttackPoints() / 3);
    receiveAttack(shaman.getAttackPoints() / 3);
  }

}
