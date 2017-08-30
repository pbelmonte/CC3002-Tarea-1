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

public class HunterTest {

  private Assassin assassin;
  private Warlock warlock;
  private Knight knight;
  private Mage mage;
  private Hunter hunter;
  private Hunter hunter2;
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
    hunter = new Hunter("Hunter", 19, 0, 10);
    hunter2 = new Hunter("Hunter2", 17, 0, 8);
    healer = new Healer("Healer", 23, 0, 14);
    druid = new Druid("Druid", 17, 0, 9);
    paladin = new Paladin("Paladin", 25, 0, 13);
    shaman = new Shaman("Shaman", 16, 0, 10);
  }

  @Test
  public void testNormalAttack() {
    hunter.attack(druid);
    assertEquals("Deberia ser 10", 10, druid.getDamage());
  }

  @Test
  public void testSelfAttack() {
    hunter.attack(hunter);
    assertEquals("Deberia ser 0", 0, hunter.getDamage());
  }

  @Test
  public void testDeadAttack() {
    hunter.receiveWarlockAttack(warlock);
    hunter.receiveWarlockAttack(warlock);
    hunter.attack(druid);
    assertEquals("Deberia ser 0", 0, druid.getDamage());
  }

  @Test
  public void testReceiveAssassinAttack() {
    hunter.receiveAssassinAttack(assassin);
    assertEquals("Deberia ser 12", 12, hunter.getDamage());
  }

  @Test
  public void testReceiveWarlockAttack() {
    hunter.receiveWarlockAttack(warlock);
    assertEquals("Deberia ser 10", 10, hunter.getDamage());
  }

  @Test
  public void testReceiveKnightAttack() {
    hunter.receiveKnightAttack(knight);
    assertEquals("Deberia ser 9", 9, hunter.getDamage());
  }

  @Test
  public void testReceiveMageAttack() {
    hunter.receiveMageAttack(mage);
    assertEquals("Deberia ser 26", 26, hunter.getDamage());
  }

  @Test
  public void testReceiveHunterAttack() {
    hunter.receiveHunterAttack(hunter2);
    assertEquals("Deberia ser 8", 8, hunter.getDamage());
  }

  @Test
  public void testReceiveNormalHealerAttack() {
    hunter.receiveKnightAttack(knight);
    hunter.receiveHealerAttack(healer);
    assertEquals("Deberia ser 2", 2, hunter.getDamage());
  }

  @Test
  public void testReceiveCeroDamageHealerAttack() {
    hunter.receiveHealerAttack(healer);
    assertEquals("Deberia ser 0", 0, hunter.getDamage());
  }

  @Test
  public void testReceiveDeadHealerAttack() {
    hunter.receiveWarlockAttack(warlock);
    hunter.receiveKnightAttack(knight);
    hunter.receiveHealerAttack(healer);
    assertFalse("Deberia estar muerto", hunter.isAlive());
  }

  @Test
  public void testReceiveAttackPointsDruidAttack() {
    hunter.receiveDruidAttack(druid);
    assertEquals("Deberia ser 10", 10, hunter.getAttackPoints());
  }

  @Test
  public void testReceiveDamageDruidAttack() {
    hunter.receiveDruidAttack(druid);
    assertEquals("Deberia ser 4", 4, hunter.getDamage());
  }

  @Test
  public void testReceiveAttackPointsPaladinAttack() {
    hunter.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 14", 14, hunter.getAttackPoints());
  }

  @Test
  public void testReceiveCeroDamagePaladinAttack() {
    hunter.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 0", 0, hunter.getDamage());
  }

  @Test
  public void testReceiveDamagePaladinAttack() {
    hunter.receiveAssassinAttack(assassin);
    hunter.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 8", 8, hunter.getDamage());
  }

  @Test
  public void testReceiveDeadPaladinAttack() {
    hunter.receiveWarlockAttack(warlock);
    hunter.receiveWarlockAttack(warlock);
    hunter.receivePaladinAttack(paladin);
    assertFalse("Deberia estar muerto", hunter.isAlive());
  }

  @Test
  public void testReceiveAttackPointsShamanAttack() {
    hunter.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 7", 7, hunter.getAttackPoints());
  }

  @Test
  public void testReceiveDamageShamanAttack() {
    hunter.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 3", 3, hunter.getDamage());
  }

}
