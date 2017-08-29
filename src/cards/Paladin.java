package cards;

/**
 * Represents a Paladin card
 * 
 * @author Pedro Belmonte
 *
 */
public class Paladin extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Name of the card
   * @param life Total life
   * @param damage Damage taken
   * @param attackPoints Attack or action points
   */
  public Paladin(String name, int life, int damage, int attackPoints) {
    super(name, life, damage, attackPoints);
  }

  @Override
  public void attack(ICard card) {
    if (isAlive() && !card.equals(this)) {
      card.receivePaladinAttack(this);
    }
  }

  @Override
  public void receiveKnightAttack(Knight knight) {
    receiveAttack(knight.getAttackPoints() / 2);
  }

  @Override
  public void receiveMageAttack(Mage mage) {
    receiveAttack(2 * mage.getAttackPoints());
  }

}
