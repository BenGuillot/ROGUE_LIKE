package Test;

import static org.junit.Assert.*;

import java.awt.Color;

import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.World;
import fr.uvsq.Max.RogueLikeMaven.World.WorldBuilder;
import fr.uvsq.Max.RogueLikeMaven.Creatures.*;

import org.junit.Test;

public class CreatureTest {

	Tile[][][] t = new Tile[50][50][2];
	World a = new World(t);
	Creature c = new Creature(a,'A',Color.YELLOW, 100, 100, 10, 10);



	@Test
	public void testCreatureGlyph() { 
		assertEquals(c.glyph(),'A');
	}
	@Test
	public void testCreatureCouleur() {
		assertEquals(c.color(), Color.YELLOW);
	}
	@Test
	public void testCreatureHpmax() {
		assertTrue(c.maxHp() < 101 && c.maxHp() > 0);
	}
	@Test
	public void testCreatureManamax() {
		assertTrue(c.maxMana() < 101 && c.maxMana() > 0);
	}
	@Test
	public void testCreatureAttackValue() {
		assertTrue(c.attackValue() < 51 && c.attackValue() > 0);
	}
	@Test
	public void testCreatureDefenseValue() {
		assertTrue(c.defenseValue() < 51 && c.defenseValue() > 0);
	}
	@Test
	public void testCreatureHp() {
		assertTrue(c.hp() < 101 && c.hp() >= 0);
	}
	@Test
	public void testCreatureMana() {
		assertTrue(c.mana() < 101 && c.mana() >= 0);
	}
	@Test
	public void testModifyHp() {
		c.modifyHp(-10);
		assertEquals(c.hp(),90);
	}

}

