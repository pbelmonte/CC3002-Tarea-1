package cards;

public interface ICard {
	
	boolean isAlive();
	
	String getName();
	
	int getLife();
	
	int getDamage();
	
	int getAttackPoints();
	
	void attack(ICard card);
	
	void receiveAssassinAttack(Assassin assassin);
	
	void receiveWarlockAttack(Warlock warlock);
	
	void receiveKnightAttack(Knight knight);
	
	void receiveMageAttack(Mage mage);
	
	void receiveHunterAttack(Hunter hunter);
	
	void receiveHealerAttack(Healer healer);
	
	void receiveDruidAttack(Druid druid);
	
	void receivePaladinAttack(Paladin paladin);
	
	void receiveShamanAttack(Shaman shaman);
	
}
