package cards;

/**
 * Representa una carta Healer
 * 
 * @author Pedro Belmonte
 *
 */
public class Healer extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Nombre de la carta
   * @param life Vida total de la carta
   * @param damage Contador de daño
   * @param attackPoints Puntos de ataque o de accion
   */
  public Healer(String name, int life, int damage, int attackPoints) {
    super(name, life, damage, attackPoints);
  }

  @Override
  public void attack(ICard card) {
    if (isAlive() && !card.equals(this)) {
      card.receiveHealerAttack(this);
    }
  }

  @Override
  public void receiveAssassinAttack(Assassin assassin) {
    receiveAttack(2 * assassin.getAttackPoints());
  }

  @Override
  public void receivePaladinAttack(Paladin paladin) {
    if (isAlive()) {
      raiseAttack(2 * paladin.getAttackPoints() / 3);
      heal(2 * paladin.getAttackPoints() / 3);
    }
  }

}
