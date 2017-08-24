package cards;

public class Paladin extends AbstractCard {

	public Paladin(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive()) {
			card.receivePaladinAttack(this);
		}
	}

}
