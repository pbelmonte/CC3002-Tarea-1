package cards;

/**
 * Representa a Healer card
 * 
 * @author Pedro Belmonte
 *
 */
public class Healer extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Name of the card
   * @param life Total life
   * @param damage Damage taken
   * @param attackPoints Attack or action points
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
