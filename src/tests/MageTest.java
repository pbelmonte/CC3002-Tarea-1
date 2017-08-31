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

public class MageTest {

  private Assassin assassin;
  private Warlock warlock;
  private Knight knight;
  private Mage mage;
  private Mage mage2;
  private Hunter hunter;
  private Healer healer;
  private Druid druid;
  private Paladin paladin;
  private Shaman shaman;

  @Before
  public void setUp() {
    assassin = new Assassin("Assassin", 20, 0, 12);
    warlock = new Warlock("Warlock", 22, 0, 10);
    knight = new Knight("Knight", 25, 0, 9);
    mage = new Mage("Mage", 14, 0, 13);
    mage2 = new Mage("Mage2", 14, 0, 10);
    hunter = new Hunter("Hunter", 19, 0, 10);
    healer = new Healer("Healer", 23, 0, 14);
    druid = new Druid("Druid", 17, 0, 9);
    paladin = new Paladin("Paladin", 25, 0, 13);
    shaman = new Shaman("Shaman", 16, 0, 10);
  }
  
  @Test
  public void testGetName() {
    assertEquals("Deberia ser Mage", "Mage", mage.getName());
  }
  
  @Test
  public void testGetLife() {
    assertEquals("Deberia ser 14", 14, mage.getLife());
  }

  @Test
  public void testNormalAttack() {
    mage.attack(druid);
    assertEquals("Deberia ser 13", 13, druid.getDamage());
  }

  @Test
  public void testSelfAttack() {
    mage.attack(mage);
    assertEquals("Deberia ser 0", 0, mage.getDamage());
  }

  @Test
  public void testDeadAttack() {
    mage.receiveHunterAttack(hunter);
    mage.receiveWarlockAttack(warlock);
    mage.attack(druid);
    assertEquals("Deberia ser 0", 0, druid.getDamage());
  }

  @Test
  public void testReceiveAssassinAttack() {
    mage.receiveAssassinAttack(assassin);
    assertEquals("Deberia ser 24", 24, mage.getDamage());
  }

  @Test
  public void testReceiveWarlockAttack() {
    mage.receiveWarlockAttack(warlock);
    assertEquals("Deberia ser 5", 5, mage.getDamage());
  }

  @Test
  public void testReceiveKnightAttack() {
    mage.receiveKnightAttack(knight);
    assertEquals("Deberia ser 9", 9, mage.getDamage());
  }

  @Test
  public void testReceiveMageAttack() {
    mage.receiveMageAttack(mage2);
    assertEquals("Deberia ser 10", 10, mage.getDamage());
  }

  @Test
  public void testReceiveHunterAttack() {
    mage.receiveHunterAttack(hunter);
    assertEquals("Deberia ser 10", 10, mage.getDamage());
  }

  @Test
  public void testReceiveNormalHealerAttack() {
    mage.receiveKnightAttack(knight);
    mage.receiveHealerAttack(healer);
    assertEquals("Deberia ser 2", 2, mage.getDamage());
  }

  @Test
  public void testReceiveCeroDamageHealerAttack() {
    mage.receiveHealerAttack(healer);
    assertEquals("Deberia ser 0", 0, mage.getDamage());
  }

  @Test
  public void testReceiveDeadHealerAttack() {
    mage.receiveHunterAttack(hunter);
    mage.receiveHunterAttack(hunter);
    mage.receiveHealerAttack(healer);
    assertFalse("Deberia estar muerto", mage.isAlive());
  }

  @Test
  public void testReceiveAttackPointsDruidAttack() {
    mage.receiveDruidAttack(druid);
    assertEquals("Deberia ser 22", 22, mage.getAttackPoints());
  }

  @Test
  public void testReceiveDamageDruidAttack() {
    mage.receiveDruidAttack(druid);
    assertEquals("Deberia ser 4", 4, mage.getDamage());
  }

  @Test
  public void testReceiveAttackPointsPaladinAttack() {
    mage.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 17", 17, mage.getAttackPoints());
  }

  @Test
  public void testReceiveCeroDamagePaladinAttack() {
    mage.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 0", 0, mage.getDamage());
  }

  @Test
  public void testReceiveDamagePaladinAttack() {
    mage.receiveHunterAttack(hunter);
    mage.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 6", 6, mage.getDamage());
  }

  @Test
  public void testReceiveAttackPointsShamanAttack() {
    mage.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 10", 10, mage.getAttackPoints());
  }

  @Test
  public void testReceiveDamageShamanAttack() {
    mage.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 3", 3, mage.getDamage());
  }

}
