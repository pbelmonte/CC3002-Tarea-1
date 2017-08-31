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

public class PaladinTest {

  private Assassin assassin;
  private Warlock warlock;
  private Knight knight;
  private Mage mage;
  private Hunter hunter;
  private Healer healer;
  private Druid druid;
  private Paladin paladin;
  private Paladin paladin2;
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
    paladin = new Paladin("Paladin", 24, 0, 13);
    paladin2 = new Paladin("Paladin2", 23, 0, 12);
    shaman = new Shaman("Shaman", 16, 0, 10);
  }
  
  @Test
  public void testGetName() {
    assertEquals("Deberia ser Paladin", "Paladin", paladin.getName());
  }
  
  @Test
  public void testGetLife() {
    assertEquals("Deberia ser 24", 24, paladin.getLife());
  }

  @Test
  public void testNormalAttackPointsAttack() {
    paladin.attack(assassin);
    assertEquals("Deberia ser 16", 16, assassin.getAttackPoints());
  }

  @Test
  public void testNormalDamageAttack() {
    druid.attack(warlock);
    paladin.attack(warlock);
    assertEquals("Deberia ser 0", 0, warlock.getDamage());
  }

  @Test
  public void testSelfAttackPointsAttack() {
    paladin.attack(paladin);
    assertEquals("Deberia ser 13", 13, paladin.getAttackPoints());
  }

  @Test
  public void testSelfDamageAttack() {
    paladin.receiveAssassinAttack(assassin);
    paladin.attack(paladin);
    assertEquals("Deberia ser 12", 12, paladin.getDamage());
  }

  @Test
  public void testDeadAttackPointsAttack() {
    paladin.receiveAssassinAttack(assassin);
    paladin.receiveAssassinAttack(assassin);
    paladin.attack(assassin);
    assertEquals("Deberia ser 12", 12, assassin.getAttackPoints());
  }

  @Test
  public void testDeadDamageAttack() {
    paladin.receiveAssassinAttack(assassin);
    paladin.receiveAssassinAttack(assassin);
    knight.attack(assassin);
    paladin.attack(assassin);
    assertEquals("Deberia ser 9", 9, assassin.getDamage());
  }

  @Test
  public void testReceiveAssassinAttack() {
    paladin.receiveAssassinAttack(assassin);
    assertEquals("Deberia ser 12", 12, paladin.getDamage());
  }

  @Test
  public void testReceiveWarlockAttack() {
    paladin.receiveWarlockAttack(warlock);
    assertEquals("Deberia ser 10", 10, paladin.getDamage());
  }

  @Test
  public void testReceiveKnightAttack() {
    paladin.receiveKnightAttack(knight);
    assertEquals("Deberia ser 4", 4, paladin.getDamage());
  }

  @Test
  public void testReceiveMageAttack() {
    paladin.receiveMageAttack(mage);
    assertEquals("Deberia ser 26", 26, paladin.getDamage());
  }

  @Test
  public void testReceiveHunterAttack() {
    paladin.receiveHunterAttack(hunter);
    assertEquals("Deberia ser 10", 10, paladin.getDamage());
  }

  @Test
  public void testReceiveNormalHealerAttack() {
    paladin.receiveAssassinAttack(assassin);
    paladin.receiveHealerAttack(healer);
    assertEquals("Deberia ser 5", 5, paladin.getDamage());
  }

  @Test
  public void testReceiveCeroDamageHealerAttack() {
    paladin.receiveHealerAttack(healer);
    assertEquals("Deberia ser 0", 0, paladin.getDamage());
  }

  @Test
  public void testReceiveDeadHealerAttack() {
    paladin.receiveAssassinAttack(assassin);
    paladin.receiveAssassinAttack(assassin);
    paladin.receiveHealerAttack(healer);
    assertFalse("Deberia estar muerto", paladin.isAlive());
  }

  @Test
  public void testReceiveAttackPointsDruidAttack() {
    paladin.receiveDruidAttack(druid);
    assertEquals("Deberia ser 22", 22, paladin.getAttackPoints());
  }

  @Test
  public void testReceiveDamageDruidAttack() {
    paladin.receiveDruidAttack(druid);
    assertEquals("Deberia ser 4", 4, paladin.getDamage());
  }

  @Test
  public void testReceiveAttackPointsPaladinAttack() {
    paladin.receivePaladinAttack(paladin2);
    assertEquals("Deberia ser 17", 17, paladin.getAttackPoints());
  }

  @Test
  public void testReceiveCeroDamagePaladinAttack() {
    paladin.receivePaladinAttack(paladin2);
    assertEquals("Deberia ser 0", 0, paladin.getDamage());
  }

  @Test
  public void testReceiveDamagePaladinAttack() {
    paladin.receiveWarlockAttack(warlock);
    paladin.receivePaladinAttack(paladin2);
    assertEquals("Deberia ser 6", 6, paladin.getDamage());
  }

  @Test
  public void testReceiveDeadPaladinAttack() {
    paladin.receiveAssassinAttack(assassin);
    paladin.receiveAssassinAttack(assassin);
    paladin.receivePaladinAttack(paladin);
    assertFalse("Deberia estar muerto", paladin.isAlive());
  }

  @Test
  public void testReceiveAttackPointsShamanAttack() {
    paladin.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 10", 10, paladin.getAttackPoints());
  }

  @Test
  public void testReceiveDamageShamanAttack() {
    paladin.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 3", 3, paladin.getDamage());
  }

}
