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

public class HealerTest {

  private Assassin assassin;
  private Warlock warlock;
  private Knight knight;
  private Mage mage;
  private Hunter hunter;
  private Healer healer;
  private Healer healer2;
  private Druid druid;
  private Paladin paladin;
  private Shaman shaman;

  @Before
  public void setUp() {
    assassin = new Assassin("Assassin", 20, 0, 12);
    warlock = new Warlock("Warlock", 22, 0, 10);
    knight = new Knight("Knight", 25, 0, 9);
    mage = new Mage("Mage", 14, 0, 13);
    hunter = new Hunter("Hunter", 19, 0, 10);
    healer = new Healer("Healer", 23, 0, 14);
    healer2 = new Healer("Healer2", 20, 0, 12);
    druid = new Druid("Druid", 17, 0, 9);
    paladin = new Paladin("Paladin", 25, 0, 13);
    shaman = new Shaman("Shaman", 16, 0, 10);
  }
  
  @Test
  public void testGetName() {
    assertEquals("Deberia ser Healer", "Healer", healer.getName());
  }
  
  @Test
  public void testGetLife() {
    assertEquals("Deberia ser 23", 23, healer.getLife());
  }

  @Test
  public void testNormalAttack() {
    hunter.attack(druid);
    healer.attack(druid);
    assertEquals("Deberia ser 3", 3, druid.getDamage());
  }

  @Test
  public void testSelfAttack() {
    healer.receiveHunterAttack(hunter);
    healer.attack(healer);
    assertEquals("Deberia ser 10", 10, healer.getDamage());
  }

  @Test
  public void testDeadAttack() {
    healer.receiveAssassinAttack(assassin);
    hunter.attack(druid);
    healer.attack(druid);
    assertEquals("Deberia ser 10", 10, druid.getDamage());
  }

  @Test
  public void testReceiveAssassinAttack() {
    healer.receiveAssassinAttack(assassin);
    assertEquals("Deberia ser 24", 24, healer.getDamage());
  }

  @Test
  public void testReceiveWarlockAttack() {
    healer.receiveWarlockAttack(warlock);
    assertEquals("Deberia ser 10", 10, healer.getDamage());
  }

  @Test
  public void testReceiveKnightAttack() {
    healer.receiveKnightAttack(knight);
    assertEquals("Deberia ser 9", 9, healer.getDamage());
  }

  @Test
  public void testReceiveMageAttack() {
    healer.receiveMageAttack(mage);
    assertEquals("Deberia ser 13", 13, healer.getDamage());
  }

  @Test
  public void testReceiveHunterAttack() {
    healer.receiveHunterAttack(hunter);
    assertEquals("Deberia ser 10", 10, healer.getDamage());
  }

  @Test
  public void testReceiveNormalHealerAttack() {
    healer.receiveKnightAttack(knight);
    healer.receiveHealerAttack(healer2);
    assertEquals("Deberia ser 3", 3, healer.getDamage());
  }

  @Test
  public void testReceiveCeroDamageHealerAttack() {
    healer.receiveHealerAttack(healer2);
    assertEquals("Deberia ser 0", 0, healer.getDamage());
  }

  @Test
  public void testReceiveDeadHealerAttack() {
    healer.receiveAssassinAttack(assassin);
    healer.receiveHealerAttack(healer2);
    assertFalse("Deberia estar muerto", healer.isAlive());
  }

  @Test
  public void testReceiveAttackPointsDruidAttack() {
    healer.receiveDruidAttack(druid);
    assertEquals("Deberia ser 23", 23, healer.getAttackPoints());
  }

  @Test
  public void testReceiveDamageDruidAttack() {
    healer.receiveDruidAttack(druid);
    assertEquals("Deberia ser 4", 4, healer.getDamage());
  }

  @Test
  public void testReceiveAttackPointsPaladinAttack() {
    healer.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 22", 22, healer.getAttackPoints());
  }

  @Test
  public void testReceiveCeroDamagePaladinAttack() {
    healer.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 0", 0, healer.getDamage());
  }

  @Test
  public void testReceiveDamagePaladinAttack() {
    healer.receiveWarlockAttack(warlock);
    healer.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 2", 2, healer.getDamage());
  }
  
  @Test
  public void testReceiveDeadPaladinAttack() {
    healer.receiveAssassinAttack(assassin);
    healer.receivePaladinAttack(paladin);
    assertFalse("Deberia estar muerto", healer.isAlive());
  }

  @Test
  public void testReceiveAttackPointsShamanAttack() {
    healer.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 11", 11, healer.getAttackPoints());
  }

  @Test
  public void testReceiveDamageShamanAttack() {
    healer.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 3", 3, healer.getDamage());
  }

}
