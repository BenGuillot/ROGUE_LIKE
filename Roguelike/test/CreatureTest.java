

import junit.framework.TestCase;
import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.World;
import fr.uvsq.Max.RogueLikeMaven.Inventory;
import fr.uvsq.Max.RogueLikeMaven.Item;
import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;

import java.awt.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class CreatureTest extends TestCase {

	
	Tile[][][] t = new Tile[50][50][2];
	World a = new World(t);
	Creature c = new Creature(a,'A',Color.YELLOW, 100, 100, 10, 10);
	
	
	
	
	public void testCreatureGlyph() { 
		assertEquals(c.glyph(),'A');
	}
	public void testCreatureCouleur() {
		assertEquals(c.color(), Color.YELLOW);
	}
	public void testCreatureHpmax() {
		assertTrue(c.maxHp() < 101 && c.maxHp() > 0);
	}
	public void testCreatureManamax() {
		assertTrue(c.maxMana() < 101 && c.maxMana() > 0);
	}
	public void testCreatureAttackValue() {
		assertTrue(c.attackValue() < 51 && c.attackValue() > 0);
	}
	public void testCreatureDefenseValue() {
		assertTrue(c.defenseValue() < 51 && c.defenseValue() > 0);
	}
	public void testCreatureHp() {
		assertTrue(c.hp() < 101 && c.hp() >= 0);
	}
	public void testCreatureMana() {
		assertTrue(c.mana() < 101 && c.mana() >= 0);
	}
}

