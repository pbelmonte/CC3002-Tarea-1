package cards;

public class Warlock extends AbstractCard {

	public Warlock(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive()) {
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
