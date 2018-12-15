package Test;

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

public class WorldTest extends TestCase {
	
	Tile[][][] t = new Tile[50][50][2];
	World a = new World(t);
	
	public void testWidth() {
		assertEquals(a.width(),50);
	}
	
	public void testHeigth() {
		assertEquals(a.height(),50);
	}
	
	public void testDepth() {
		assertTrue(a.depth() > 1);
	}

}
