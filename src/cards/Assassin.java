package cards;

/**
 * Represents an Assassin card
 * 
 * @author Pedro Belmonte
 *
 */
public class Assassin extends AbstractCard {

  /**
   * Constructor
   * 
   * @param name Name of the card
   * @param life Total life
   * @param damage Damage taken
   * @param attackPoints Attack or action points
   */
  public Assassin(String name, int life, int damage, int attackPoints) {
    super(name, life, damage, attackPoints);
  }

  @Override
  public void attack(ICard card) {
    if (isAlive() && !card.equals(this)) {
      card.receiveAssassinAttack(this);
    }
  }

  @Override
  public void receiveWarlockAttack(Warlock warlock) {
    receiveAttack(warlock.getAttackPoints() * 2);
  }

  @Override
  public void receiveDruidAttack(Druid druid) {
    raiseAttack(druid.getAttackPoints() / 2);
  }

}
