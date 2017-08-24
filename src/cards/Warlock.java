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

}
