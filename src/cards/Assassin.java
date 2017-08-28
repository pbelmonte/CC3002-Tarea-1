package cards;

/**
 * Representa una carta Assassin
 * 
 * @author Pedro Belmonte
 *
 */
public class Assassin extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Nombre de la carta
   * @param life Vida total de la carta
   * @param damage Contador de daño
   * @param attackPoints Puntos de ataque o de accion
   */
  public Assassin(String name, int life, int damage, int attackPoints) {
    super(name, life, damage, attackPoints);
  }

  @Override
  public void attack(ICard card) {
    if (isAlive() && !card.equals(this)) {
      card.receiveAssassinAttack(this);
    }
  }

  @Override
  public void receiveWarlockAttack(Warlock warlock) {
    receiveAttack(warlock.getAttackPoints() * 2);
  }

  @Override
  public void receiveDruidAttack(Druid druid) {
    raiseAttack(druid.getAttackPoints() / 2);
  }

}
