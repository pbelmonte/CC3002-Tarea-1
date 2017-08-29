package cards;

/**
 * Represents a Hunter card
 * 
 * @author Pedro Belmonte
 *
 */
public class Hunter extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Name of the card
   * @param life Total life
   * @param damage Damage taken
   * @param attackPoints Attack or action points
   */
  public Hunter(String name, int life, int damage, int attackPoints) {
    super(name, life, damage, attackPoints);
  }

  @Override
  public void attack(ICard card) {
    if (isAlive() && !card.equals(this)) {
      card.receiveHunterAttack(this);
    }
  }

  @Override
  public void receiveDruidAttack(Druid druid) {
    receiveAttack(druid.getAttackPoints() / 2);
  }

  @Override
  public void receiveMageAttack(Mage mage) {
    receiveAttack(2 * mage.getAttackPoints());
  }

}
