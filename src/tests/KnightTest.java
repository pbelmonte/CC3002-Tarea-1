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

public class KnightTest {

  private Assassin assassin;
  private Warlock warlock;
  private Knight knight;
  private Knight knight2;
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
    knight = new Knight("Knight", 25, 0, 9);
    knight2 = new Knight("Knight2", 20, 0, 8);
    mage = new Mage("Mage", 14, 0, 13);
    hunter = new Hunter("Hunter", 19, 0, 10);
    healer = new Healer("Healer", 23, 0, 14);
    druid = new Druid("Druid", 17, 0, 9);
    paladin = new Paladin("Paladin", 25, 0, 13);
    shaman = new Shaman("Shaman", 16, 0, 10);
  }
  
  @Test
  public void testGetName() {
    assertEquals("Deberia ser Knight", "Knight", knight.getName());
  }
  
  @Test
  public void testGetLife() {
    assertEquals("Deberia ser 25", 25, knight.getLife());
  }

  @Test
  public void testNormalAttack() {
    knight.attack(druid);
    assertEquals("Deberia ser 9", 9, druid.getDamage());
  }

  @Test
  public void testSelfAttack() {
    knight.attack(knight);
    assertEquals("Deberia ser 0", 0, knight.getDamage());
  }

  @Test
  public void testDeadAttack() {
    knight.receiveHunterAttack(hunter);
    knight.receiveWarlockAttack(warlock);
    knight.attack(druid);
    assertEquals("Deberia ser 0", 0, druid.getDamage());
  }

  @Test
  public void testReceiveAssassinAttack() {
    knight.receiveAssassinAttack(assassin);
    assertEquals("Deberia ser 6", 6, knight.getDamage());
  }

  @Test
  public void testReceiveWarlockAttack() {
    knight.receiveWarlockAttack(warlock);
    assertEquals("Deberia ser 10", 10, knight.getDamage());
  }

  @Test
  public void testReceiveKnightAttack() {
    knight.receiveKnightAttack(knight2);
    assertEquals("Deberia ser 8", 8, knight.getDamage());
  }

  @Test
  public void testReceiveMageAttack() {
    knight.receiveMageAttack(mage);
    assertEquals("Deberia ser 13", 13, knight.getDamage());
  }

  @Test
  public void testReceiveHunterAttack() {
    knight.receiveHunterAttack(hunter);
    assertEquals("Deberia ser 20", 20, knight.getDamage());
  }

  @Test
  public void testReceiveNormalHealerAttack() {
    knight.receiveMageAttack(mage);
    knight.receiveHealerAttack(healer);
    assertEquals("Deberia ser 6", 6, knight.getDamage());
  }

  @Test
  public void testReceiveCeroDamageHealerAttack() {
    knight.receiveHealerAttack(healer);
    assertEquals("Deberia ser 0", 0, knight.getDamage());
  }

  @Test
  public void testReceiveDeadHealerAttack() {
    knight.receiveHunterAttack(hunter);
    knight.receiveHunterAttack(hunter);
    knight.receiveHealerAttack(healer);
    assertFalse("Deberia estar muerto", knight.isAlive());
  }

  @Test
  public void testReceiveAttackPointsDruidAttack() {
    knight.receiveDruidAttack(druid);
    assertEquals("Deberia ser 18", 18, knight.getAttackPoints());
  }

  @Test
  public void testReceiveDamageDruidAttack() {
    knight.receiveDruidAttack(druid);
    assertEquals("Deberia ser 4", 4, knight.getDamage());
  }

  @Test
  public void testReceiveAttackPointsPaladinAttack() {
    knight.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 13", 13, knight.getAttackPoints());
  }

  @Test
  public void testReceiveCeroDamagePaladinAttack() {
    knight.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 0", 0, knight.getDamage());
  }

  @Test
  public void testReceiveDamagePaladinAttack() {
    knight.receiveHunterAttack(hunter);
    knight.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 16", 16, knight.getDamage());
  }
  
  @Test
  public void testReceiveAttackPointsShamanAttack() {
    knight.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 6", 6, knight.getAttackPoints());
  }

  @Test
  public void testReceiveDamageShamanAttack() {
    knight.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 3", 3, knight.getDamage());
  }

}
