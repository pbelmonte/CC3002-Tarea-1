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

public class ShamanTest {

  private Assassin assassin;
  private Warlock warlock;
  private Knight knight;
  private Mage mage;
  private Hunter hunter;
  private Healer healer;
  private Druid druid;
  private Paladin paladin;
  private Shaman shaman;
  private Shaman shaman2;

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
    shaman = new Shaman("Shaman", 18, 0, 10);
    shaman2 = new Shaman("Shaman2", 14, 0, 9);
  }
  
  @Test
  public void testGetName() {
    assertEquals("Deberia ser Shaman", "Shaman", shaman.getName());
  }
  
  @Test
  public void testGetLife() {
    assertEquals("Deberia ser 18", 18, shaman.getLife());
  }

  @Test
  public void testNormalAttackPointsAttack() {
    shaman.attack(assassin);
    assertEquals("Deberia ser 9", 9, assassin.getAttackPoints());
  }

  @Test
  public void testNormalDamageAttack() {
    shaman.attack(assassin);
    assertEquals("Deberia ser 3", 3, assassin.getDamage());
  }

  @Test
  public void testSelfAttackPointsAttack() {
    shaman.attack(shaman);
    assertEquals("Deberia ser 10", 10, shaman.getAttackPoints());
  }

  @Test
  public void testSelfDamageAttack() {
    shaman.attack(shaman);
    assertEquals("Deberia ser 0", 0, paladin.getDamage());
  }

  @Test
  public void testDeadAttackPointsAttack() {
    shaman.receiveHunterAttack(hunter);
    shaman.attack(assassin);
    assertEquals("Deberia ser 12", 12, assassin.getAttackPoints());
  }

  @Test
  public void testDeadDamageAttack() {
    shaman.receiveHunterAttack(hunter);
    paladin.attack(assassin);
    assertEquals("Deberia ser 0", 0, assassin.getDamage());
  }

  @Test
  public void testReceiveAssassinAttack() {
    shaman.receiveAssassinAttack(assassin);
    assertEquals("Deberia ser 12", 12, shaman.getDamage());
  }

  @Test
  public void testReceiveWarlockAttack() {
    shaman.receiveWarlockAttack(warlock);
    assertEquals("Deberia ser 10", 10, shaman.getDamage());
  }

  @Test
  public void testReceiveKnightAttack() {
    shaman.receiveKnightAttack(knight);
    assertEquals("Deberia ser 9", 9, shaman.getDamage());
  }

  @Test
  public void testReceiveMageAttack() {
    shaman.receiveMageAttack(mage);
    assertEquals("Deberia ser 13", 13, shaman.getDamage());
  }

  @Test
  public void testReceiveHunterAttack() {
    shaman.receiveHunterAttack(hunter);
    assertEquals("Deberia ser 20", 20, shaman.getDamage());
  }

  @Test
  public void testReceiveNormalHealerAttack() {
    shaman.receiveAssassinAttack(assassin);
    shaman.receiveHealerAttack(healer);
    assertEquals("Deberia ser 5", 5, shaman.getDamage());
  }

  @Test
  public void testReceiveCeroDamageHealerAttack() {
    shaman.receiveHealerAttack(healer);
    assertEquals("Deberia ser 0", 0, shaman.getDamage());
  }

  @Test
  public void testReceiveDeadHealerAttack() {
    shaman.receiveHunterAttack(hunter);
    shaman.receiveHealerAttack(healer);
    assertFalse("Deberia estar muerto", shaman.isAlive());
  }

  @Test
  public void testReceiveAttackPointsDruidAttack() {
    shaman.receiveDruidAttack(druid);
    assertEquals("Deberia ser 19", 19, shaman.getAttackPoints());
  }

  @Test
  public void testReceiveDamageDruidAttack() {
    shaman.receiveDruidAttack(druid);
    assertEquals("Deberia ser 4", 4, shaman.getDamage());
  }

  @Test
  public void testReceiveAttackPointsPaladinAttack() {
    shaman.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 14", 14, shaman.getAttackPoints());
  }

  @Test
  public void testReceiveCeroDamagePaladinAttack() {
    shaman.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 0", 0, shaman.getDamage());
  }

  @Test
  public void testReceiveDamagePaladinAttack() {
    shaman.receiveWarlockAttack(warlock);
    shaman.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 6", 6, shaman.getDamage());
  }

  @Test
  public void testReceiveDeadPaladinAttack() {
    shaman.receiveHunterAttack(hunter);
    shaman.receivePaladinAttack(paladin);
    assertFalse("Deberia estar muerto", shaman.isAlive());
  }

  @Test
  public void testReceiveAttackPointsShamanAttack() {
    shaman.receiveShamanAttack(shaman2);
    assertEquals("Deberia ser 7", 7, shaman.getAttackPoints());
  }

  @Test
  public void testReceiveDamageShamanAttack() {
    shaman.receiveShamanAttack(shaman2);
    assertEquals("Deberia ser 3", 3, shaman.getDamage());
  }

}
