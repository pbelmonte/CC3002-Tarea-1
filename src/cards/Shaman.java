package cards;

public class Shaman extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Nombre de la carta
   * @param life Vida total de la carta
   * @param damage Contador de daño
   * @param attackPoints Puntos de ataque o de accion
   */
  public Shaman(String name, int life, int damage, int attackPoints) {
    super(name, life, damage, attackPoints);
  }

  @Override
  public void attack(ICard card) {
    if (isAlive() && !card.equals(this)) {
      card.receiveShamanAttack(this);
    }
  }

  @Override
  public void receiveHunterAttack(Hunter hunter) {
    receiveAttack(2 * hunter.getAttackPoints());
  }

}
