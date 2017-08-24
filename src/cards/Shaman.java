package cards;

public class Shaman extends AbstractCard {

	public Shaman(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive()) {
			card.receiveShamanAttack(this);
		}		
	}

}
