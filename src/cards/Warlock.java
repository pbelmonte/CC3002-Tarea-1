package cards;

/**
 * Represents a Warlock card
 * 
 * @author Pedro Belmonte
 *
 */
public class Warlock extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Name of the card
   * @param life Total life
   * @param damage Damage taken
   * @param attackPoints Attack or action points
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
