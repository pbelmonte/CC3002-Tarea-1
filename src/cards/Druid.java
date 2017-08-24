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
	
	@Override
	public void receivePaladinAttack(Paladin paladin) {
		if (isAlive()) {
			raiseAttack(2 * paladin.getAttackPoints() / 3);
			heal(2 * paladin.getAttackPoints() / 3);
		}
	}
	
	@Override
	public void receiveShamanAttack(Shaman shaman) {
		reduceAttack(2 * shaman.getAttackPoints() / 3);
		receiveAttack(2 * shaman.getAttackPoints() / 3);
	}

}
