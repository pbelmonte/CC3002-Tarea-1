package cards;

public class Hunter extends AbstractCard {

	public Hunter(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive()) {
			card.receiveHunterAttack(this);		
		}
	}

}
