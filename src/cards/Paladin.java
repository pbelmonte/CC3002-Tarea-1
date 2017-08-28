package cards;

public class Paladin extends AbstractCard {

	public Paladin(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive() && !card.equals(this)) {
			card.receivePaladinAttack(this);
		}
	}
	
	@Override
	public void receiveKnightAttack(Knight knight) {
		receiveAttack(knight.getAttackPoints() / 2);
	}
	
	@Override
	public void receiveMageAttack(Mage mage) {
		receiveAttack(2 * mage.getAttackPoints());
	}

}
