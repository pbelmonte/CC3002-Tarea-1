package cards;

public class Druid extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Nombre de la carta
   * @param life Vida total de la carta
   * @param damage Contador de daño
   * @param attackPoints Puntos de ataque o de accion
   */
  public Druid(String name, int life, int damage, int attackPoints) {
    super(name, life, damage, attackPoints);
  }

  @Override
  public void attack(ICard card) {
    if (isAlive() && !card.equals(this)) {
      card.receiveDruidAttack(this);
    }
  }

  @Override
  public void receivePaladinAttack(Paladin paladin) {
    if (isAlive()) {
      raiseAttack(2 * paladin.getAttackPoints() / 3);
      heal(2 * paladin.getAttackPoints() / 3);
    }
  }

  @Override
  public void receiveShamanAttack(Shaman shaman) {
    reduceAttack(2 * shaman.getAttackPoints() / 3);
    receiveAttack(2 * shaman.getAttackPoints() / 3);
  }

}
