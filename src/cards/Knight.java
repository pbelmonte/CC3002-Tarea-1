package cards;

/**
 * Represents a Knight card
 * 
 * @author Pedro Belmonte
 *
 */
public class Knight extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Name of the card
   * @param life Total life
   * @param damage Damage taken
   * @param attackPoints Attack or action points
   */
  public Knight(String name, int life, int damage, int attackPoints) {
    super(name, life, damage, attackPoints);
  }

  @Override
  public void attack(ICard card) {
    if (isAlive() && !card.equals(this)) {
      card.receiveKnightAttack(this);
    }
  }

  @Override
  public void receiveHunterAttack(Hunter hunter) {
    receiveAttack(2 * hunter.getAttackPoints());
  }

  @Override
  public void receiveAssassinAttack(Assassin assassin) {
    receiveAttack(assassin.getAttackPoints() / 2);
  }

}
