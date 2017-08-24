package cards;

public interface ICard {
	
	boolean isAlive();
	
	int getAttackPoints();
	
	void attack(ICard card);
	
	void receiveAttack(int points);
	
	void heal(int points);
	
	void raiseAttack(int points);
	
	void reduceAttack(int points);
	
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
