package cards;

public class Knight extends AbstractCard {

	public Knight(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive()) {
			card.receiveKnightAttack(this);
		}
	}

}
