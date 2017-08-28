package cards;

public class Knight extends AbstractCard {

	public Knight(String name, int life, int damage, int attackPoints) {
		super(name, life, damage, attackPoints);
	}

	@Override
	public void attack(ICard card) {
		if (isAlive() && !card.equals(this)) {
			card.receiveKnightAttack(this);
		}
	}
	
	@Override
	public void receiveHunterAttack(Hunter hunter) {
		receiveAttack(2 * hunter.getAttackPoints());
	}
	
	@Override
	public void receiveAssassinAttack(Assassin assassin) {
		receiveAttack(assassin.getAttackPoints() / 2);
	}

}
