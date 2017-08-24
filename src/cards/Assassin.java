package cards;

public class Assassin extends AbstractCard {

	public Assassin(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive()) {
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
