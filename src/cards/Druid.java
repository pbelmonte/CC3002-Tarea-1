package cards;

public class Druid extends AbstractCard {

	public Druid(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive()) {
			card.receiveDruidAttack(this);
		}		
	}

}
