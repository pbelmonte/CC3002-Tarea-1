package cards;

/**
 * Represents a Mage card
 * 
 * @author Pedro Belmonte
 *
 */
public class Mage extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Name of the card
   * @param life Total life
   * @param damage Damage taken
   * @param attackPoints Attack or action points
   */
  public Mage(String name, int life, int damage, int attackPoints) {
    super(name, life, damage, attackPoints);
  }

  @Override
  public void attack(ICard card) {
    if (isAlive() && !card.equals(this)) {
      card.receiveMageAttack(this);
    }
  }

  @Override
  public void receiveAssassinAttack(Assassin assassin) {
    receiveAttack(2 * assassin.getAttackPoints());
  }

  @Override
  public void receiveWarlockAttack(Warlock warlock) {
    receiveAttack(warlock.getAttackPoints() / 2);
  }

}
