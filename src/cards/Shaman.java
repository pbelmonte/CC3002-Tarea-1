package cards;

/**
 * Represents a Shaman card
 * 
 * @author Pedro Belmonte
 *
 */
public class Shaman extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Name of the card
   * @param life Total life
   * @param damage Damage taken
   * @param attackPoints Attack or action points
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
