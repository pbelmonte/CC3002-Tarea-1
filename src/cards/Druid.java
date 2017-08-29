package cards;

/**
 * Represents a Druid card
 * 
 * @author Pedro Belmonte
 *
 */
public class Druid extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Name of the card
   * @param life Total life
   * @param damage Damage taken
   * @param attackPoints Attack or action points
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
