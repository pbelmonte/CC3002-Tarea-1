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

public class AssassinTest {

  private Assassin assassin;
  private Assassin assassin2;
  private Warlock warlock;
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
    assassin2 = new Assassin("Assassin2", 18, 0, 10);
    warlock = new Warlock("Warlock", 22, 0, 10);
    knight = new Knight("Knight", 25, 0, 9);
    mage = new Mage("Mage", 14, 0, 13);
    hunter = new Hunter("Hunter", 19, 0, 10);
    healer = new Healer("Healer", 23, 0, 14);
    druid = new Druid("Druid", 17, 0, 9);
    paladin = new Paladin("Paladin", 25, 0, 13);
    shaman = new Shaman("Shaman", 16, 0, 10);
  }

  @Test
  public void testAttack() {
    assassin.attack(druid);
    assertEquals("Deberia ser 12", 12, druid.getDamage());

    // No se puede atacar a si mismo
    assassin.attack(assassin);
    assertEquals("Deberia ser 0", 0, assassin.getDamage());

    // Si esta muerto no puede atacar
    assassin.receiveHunterAttack(hunter);
    assassin.receiveHunterAttack(hunter);
    assassin.attack(druid);
    assertEquals("Deberia ser 12", 12, druid.getDamage());
  }

  @Test
  public void testReceiveAssassinAttack() {
    assassin.receiveAssassinAttack(assassin2);
    assertEquals("Deberia ser 10", 10, assassin.getDamage());
  }

  @Test
  public void testReceiveWarlockAttack() {
    assassin.receiveWarlockAttack(warlock);
    assertEquals("Deberia ser 20", 20, assassin.getDamage());
  }

  @Test
  public void testReceiveKnightAttack() {
    assassin.receiveKnightAttack(knight);
    assertEquals("Deberia ser 9", 9, assassin.getDamage());
  }

  @Test
  public void testReceiveMageAttack() {
    assassin.receiveMageAttack(mage);
    assertEquals("Deberia ser 13", 13, assassin.getDamage());
  }

  @Test
  public void testReceiveHunterAttack() {
    assassin.receiveHunterAttack(hunter);
    assertEquals("Deberia ser 10", 10, assassin.getDamage());
  }

  @Test
  public void testReceiveHealerAttack() {
    // Si el da�o es 0 no puede volverse negativo
    assassin.receiveHealerAttack(healer);
    assertEquals("Deberia ser 0", 0, assassin.getDamage());

    // Se cura normalmente
    assassin.receiveHunterAttack(hunter);
    assassin.receiveHealerAttack(healer);
    assertEquals("Deberia ser 3", 3, assassin.getDamage());

    // Se cura solo lo necesario (nuevamente no puede tener dano negativo)
    assassin.receiveHealerAttack(healer);
    assertEquals("Deberia ser 0", 0, assassin.getDamage());

    // Si esta muerto no resucita
    assassin.receiveHunterAttack(hunter);
    assassin.receiveHunterAttack(hunter);
    assassin.receiveHealerAttack(healer);
    assertFalse("Deberia estar muerto", assassin.isAlive());
  }

  @Test
  public void testReceiveDruidAttack() {
    assassin.receiveDruidAttack(druid);
    assertEquals("Deberia ser 16", 16, assassin.getAttackPoints());
    assertEquals("Deberia ser 0", 0, assassin.getDamage());
  }

  @Test
  public void testReceivePaladinAttack() {
    assassin.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 0", 0, assassin.getDamage());
    assertEquals("Deberia ser 16", 16, assassin.getAttackPoints());
    assassin.receiveHunterAttack(hunter);
    assassin.receivePaladinAttack(paladin);
    assertEquals("Deberia ser 6", 6, assassin.getDamage());
    assertEquals("Deberia ser 20", 20, assassin.getAttackPoints());
  }

  @Test
  public void testReceiveShamanAttack() {
    assassin.receiveShamanAttack(shaman);
    assertEquals("Deberia ser 9", 9, assassin.getAttackPoints());
    assertEquals("Deberia ser 3", 3, assassin.getDamage());
  }

}
