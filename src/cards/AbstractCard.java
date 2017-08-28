package cards;

/**
 * Representa una carta abstracta
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

  /**
   * Retorna true si la vida total es mayor que el daño
   */
  public boolean isAlive() {
    return life > damage;
  }

  /**
   * Retorna el nombre de la carta
   */
  public String getName() {
    return name;
  }

  /**
   * Retorna la vida total
   */
  public int getLife() {
    return life;
  }

  /**
   * Retorna el daño
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Retorna los puntos de ataque
   */
  public int getAttackPoints() {
    return attackPoints;
  }

  /**
   * Ataca a otra carta
   */
  public abstract void attack(ICard card);

  /**
   * Aumenta los puntos de daño
   * 
   * @param points Cantidad a aumentar
   */
  void receiveAttack(int points) {
    damage += points;
  }

  /**
   * Reduce el daño
   * 
   * @param points Cantidad a reducir
   */
  void heal(int points) {
    damage = Math.max(0, damage - points);
  }

  /**
   * Aumenta los puntos de ataque
   * 
   * @param points Cantidad a aumentar
   */
  void raiseAttack(int points) {
    attackPoints += points;
  }

  /**
   * Reduce los puntos de ataque
   * 
   * @param points Cantidad a reducir
   */
  void reduceAttack(int points) {
    attackPoints -= points;
  }

  /**
   * Recibe un ataque de una carta tipo Assassin
   */
  public void receiveAssassinAttack(Assassin assassin) {
    receiveAttack(assassin.getAttackPoints());
  }

  /**
   * Recibe un ataque de una carta tipo Warlock
   */
  public void receiveWarlockAttack(Warlock warlock) {
    receiveAttack(warlock.getAttackPoints());
  }

  /**
   * Recibe un ataque de una carta tipo Knight
   */
  public void receiveKnightAttack(Knight knight) {
    receiveAttack(knight.getAttackPoints());
  }

  /**
   * Recibe un ataque de una carta tipo Mage
   */
  public void receiveMageAttack(Mage mage) {
    receiveAttack(mage.getAttackPoints());
  }

  /**
   * Recibe un ataque de una carta tipo Hunter
   */
  public void receiveHunterAttack(Hunter hunter) {
    receiveAttack(hunter.getAttackPoints());
  }

  /**
   * Recibe un ataque de una carta tipo Healer
   */
  public void receiveHealerAttack(Healer healer) {
    if (isAlive()) {
      heal(healer.getAttackPoints() / 2);
    }
  }

  /**
   * Recibe un ataque de una carta tipo Druid
   */
  public void receiveDruidAttack(Druid druid) {
    raiseAttack(druid.getAttackPoints());
    receiveAttack(druid.getAttackPoints() / 2);
  }

  /**
   * Recibe un ataque de una carta tipo Paladin
   */
  public void receivePaladinAttack(Paladin paladin) {
    if (isAlive()) {
      raiseAttack(paladin.getAttackPoints() / 3);
      heal(paladin.getAttackPoints() / 3);
    }
  }

  /**
   * Recibe un ataque de una carta tipo Shaman
   */
  public void receiveShamanAttack(Shaman shaman) {
    reduceAttack(shaman.getAttackPoints() / 3);
    receiveAttack(shaman.getAttackPoints() / 3);
  }

}
