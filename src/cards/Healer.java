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
	
	@Override
	public void receiveAssassinAttack(Assassin assassin) {
		receiveAttack(2 * assassin.getAttackPoints());
	}
	
	@Override
	public void receivePaladinAttack(Paladin paladin) {
		if (isAlive()) {
			raiseAttack(2 * paladin.getAttackPoints() / 3);
			heal(2 * paladin.getAttackPoints() / 3);
		}
	}

}
