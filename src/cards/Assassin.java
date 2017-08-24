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
	
}
