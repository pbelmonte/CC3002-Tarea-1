package cards;

public class Healer extends AbstractCard {

	public Healer(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive()) {
			card.receiveHealerAttack(this);
		}		
	}

}
