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

public class DruidTest {

  private Assassin assassin;
  private Warlock warlock;
  private Knight knight;
  private Mage mage;
  private Hunter hunter;
  private Healer healer;
  private Druid druid;
  private Druid druid2;
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
    druid = new Druid("Druid", 17, 0, 9);
    druid2 = new Druid("Druid2", 15, 0, 9);
    paladin = new Paladin("Paladin", 25, 0, 13);
    shaman = new Shaman("Shaman", 16, 0, 10);
  }

  @Test
  public void testNormalAttackPointsAttack() {
    druid.attack(warlock);
    assertEquals("Deberia ser 19", 19, warlock.getAttackPoints());
  }

  @Test
  public void testNormalDamageAttack() {
    druid.attack(warlock);
    assertEquals("Deberia ser 4", 4, warlock.getDamage());
  }

  @Test
  public void testSelfAttackPointsAttack() {
    druid.attack(druid);
    assertEquals("Deberia ser 9", 9, druid.getAttackPoints());
  }

  @Test
  public void testSelfDamageAttack() {
    druid.attack(druid);
    assertEquals("Deberia ser 0", 0, druid.getDamage());
  }

  @Test
  public void testDeadAttackPointsAttack() {
    druid.receiveKnightAttack(knight);
    druid.receiveKnightAttack(knight);
    druid.attack(assassin);
    assertEquals("Deberia ser 12", 12, assassin.getAttackPoints());
  }

  @Test
  public void testDeadDamageAttack() {
    druid.receiveKnightAttack(knight);
    druid.receiveKnightAttack(knight);
    druid.attack(assassin);
    assertEquals("Deberia ser 0", 0, assassin.getDamage());
  }

  @Test
  public void testReceiveAssassinAttack() {
    druid.receiveAssassinAttack(assassin);
    assertEquals("Deberia ser 12", 12, druid.getDamage());
  }

  @Test
  public void testReceiveWarlockAttack() {
    druid.receiveWarlockAttack(warlock);
    assertEquals("Deberia ser 10", 10, druid.getDamage());
  }

  @Test
  public void testReceiveKnightAttack() {
    druid.receiveKnightAttack(knight);
    assertEquals("Deberia ser 9", 9, druid.getDamage());
  }

  @Test
  public void testReceiveMageAttack() {
    druid.receiveMageAttack(mage);
    assertEquals("Deberia ser 13", 13, druid.getDamage());
  }

  @Test
  public void testReceiveHunterAttack() {
    druid.receiveHunterAttack(hunter);
    assertEquals("Deberia ser 10", 10, druid.getDamage());
  }

  @Test
  public void testReceiveNormalHealerAttack() {
    druid.receiveKnightAttack(knight);
    druid.receiveHealerAttack(healer);
    assertEquals("Deberia ser 2", 2, druid.getDamage());
  }

  @Test
  public void testReceiveCeroDamageHealerAttack() {
    druid.receiveHealerAttack(healer);
    assertEquals("Deberia ser 0", 0, druid.getDamage());
  }

  @Test
  public void testReceiveDeadHealerAttack() {
    druid.receiveKnightAttack(knight);
    druid.receiveKnightAttack(knight);
    druid.receiveHealerAttack(healer);
    assertFalse("Deberia estar muerto", druid.isAlive());
  }

  @Test
  public void testReceiveAttackPointsDruidAttack() {
    druid.receiveDruidAttack(druid2);
    assertEquals("Deberia ser 18", 18, druid.getAttackPoints());
  }

  @Test
  public void testReceiveDamageDruidAttack() {
    druid.receiveDruidAttack(druid2);
    assertEquals("Deberia ser 4", 4, druid.getDamage());
  }

  @Test
  public void testReceiveAttackPointsPaladinAttack() {
    druid.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 17", 17, druid.getAttackPoints());
  }

  @Test
  public void testReceiveCeroDamagePaladinAttack() {
    druid.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 0", 0, druid.getDamage());
  }

  @Test
  public void testReceiveDamagePaladinAttack() {
    druid.receiveWarlockAttack(warlock);
    druid.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 2", 2, druid.getDamage());
  }

  @Test
  public void testReceiveDeadPaladinAttack() {
    druid.receiveKnightAttack(knight);
    druid.receiveKnightAttack(knight);
    druid.receivePaladinAttack(paladin);
    assertFalse("Deberia estar muerto", druid.isAlive());
  }

  @Test
  public void testReceiveAttackPointsShamanAttack() {
    druid.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 3", 3, druid.getAttackPoints());
  }

  @Test
  public void testReceiveDamageShamanAttack() {
    druid.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 6", 6, druid.getDamage());
  }

}
