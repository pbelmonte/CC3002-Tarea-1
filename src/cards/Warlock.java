package cards;

/**
 * Representa una carta Warlock
 * 
 * @author Pedro Belmonte
 *
 */
public class Warlock extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Nombre de la carta
   * @param life Vida total de la carta
   * @param damage Contador de daño
   * @param attackPoints Puntos de ataque o de accion
   */
  public Warlock(String name, int life, int damage, int attackPoints) {
    super(name, life, damage, attackPoints);
  }

  @Override
  public void attack(ICard card) {
    if (isAlive() && !card.equals(this)) {
      card.receiveWarlockAttack(this);
    }
  }

  @Override
  public void receiveHealerAttack(Healer healer) {
    receiveAttack(healer.getAttackPoints());
  }

  @Override
  public void receiveShamanAttack(Shaman shaman) {
    reduceAttack(2 * shaman.getAttackPoints() / 3);
    receiveAttack(2 * shaman.getAttackPoints() / 3);
  }

}
