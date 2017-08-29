package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cards.Assassin;
import cards.Druid;
import cards.Healer;
import cards.Hunter;
import cards.Knight;
import cards.Mage;
import cards.Paladin;
import cards.Shaman;
import cards.Warlock;

public class WarlockTest {

  private Assassin assassin;
  private Warlock warlock;
  private Warlock warlock2;
  private Knight knight;
  private Mage mage;
  private Hunter hunter;
  private Healer healer;
  private Druid druid;
  private Paladin paladin;
  private Shaman shaman;

  @Before
  public void setUp() {
    assassin = new Assassin("Assassin", 20, 0, 12);
    warlock = new Warlock("Warlock", 22, 0, 10);
    warlock2 = new Warlock("Warlock2", 20, 0, 9);
    knight = new Knight("Knight", 25, 0, 9);
    mage = new Mage("Mage", 14, 0, 13);
    hunter = new Hunter("Hunter", 19, 0, 10);
    healer = new Healer("Healer", 23, 0, 14);
    druid = new Druid("Druid", 17, 0, 9);
    paladin = new Paladin("Paladin", 25, 0, 13);
    shaman = new Shaman("Shaman", 16, 0, 10);
  }
  
  @Test
  public void testNormalAttack() {
    warlock.attack(druid);
    assertEquals("Deberia ser 10", 10, druid.getDamage());
  }

  @Test
  public void testSelfAttack() {
    warlock.attack(warlock);
    assertEquals("Deberia ser 0", 0, warlock.getDamage());
  }

  @Test
  public void testDeadAttack() {
    warlock.receiveAssassinAttack(assassin);
    warlock.receiveAssassinAttack(assassin);
    warlock.attack(druid);
    assertEquals("Deberia ser 0", 0, druid.getDamage());
  }

  @Test
  public void testReceiveAssassinAttack() {
    warlock.receiveAssassinAttack(assassin);
    assertEquals("Deberia ser 12", 12, warlock.getDamage());
  }

  @Test
  public void testReceiveWarlockAttack() {
    warlock.receiveWarlockAttack(warlock2);
    assertEquals("Deberia ser 9", 9, warlock.getDamage());
  }

  @Test
  public void testReceiveKnightAttack() {
    warlock.receiveKnightAttack(knight);
    assertEquals("Deberia ser 9", 9, warlock.getDamage());
  }

  @Test
  public void testReceiveMageAttack() {
    warlock.receiveMageAttack(mage);
    assertEquals("Deberia ser 13", 13, warlock.getDamage());
  }

  @Test
  public void testReceiveHunterAttack() {
    warlock.receiveHunterAttack(hunter);
    assertEquals("Deberia ser 10", 10, warlock.getDamage());
  }

  @Test
  public void testReceiveHealerAttack() {
    warlock.receiveHealerAttack(healer);
    assertEquals("Deberia ser 14", 14, warlock.getDamage());
  }
  
  @Test
  public void testReceiveAttackPointsDruidAttack() {
    warlock.receiveDruidAttack(druid);
    assertEquals("Deberia ser 19", 19, warlock.getAttackPoints());
  }

  @Test
  public void testReceiveDamageDruidAttack() {
    warlock.receiveDruidAttack(druid);
    assertEquals("Deberia ser 4", 4, warlock.getDamage());
  }
  
  @Test
  public void testReceiveAttackPointsPaladinAttack() {
    warlock.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 14", 14, warlock.getAttackPoints());
  }

  @Test
  public void testReceiveCeroDamagePaladinAttack() {
    warlock.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 0", 0, warlock.getDamage());
  }

  @Test
  public void testReceiveDamagePaladinAttack() {
    warlock.receiveHunterAttack(hunter);
    warlock.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 6", 6, warlock.getDamage());
  }
  
  @Test
  public void testReceiveAttackPointsShamanAttack() {
    warlock.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 4", 4, warlock.getAttackPoints());
  }

  @Test
  public void testReceiveDamageShamanAttack() {
    warlock.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 4", 4, warlock.getAttackPoints());
    assertEquals("Deberia ser 6", 6, warlock.getDamage());
  }

}
