package cards;

public class Mage extends AbstractCard {

	public Mage(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive()) {
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
