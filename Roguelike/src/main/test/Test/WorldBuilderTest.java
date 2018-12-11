package Test;

import junit.framework.TestCase;
import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.World;
import fr.uvsq.Max.RogueLikeMaven.World.WorldBuilder;
import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import java.awt.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WorldBuilderTest extends TestCase {
	
	World a = new WorldBuilder(50,50,2);
	
	public void testrandomizeTiles() {
		a.randomizeTiles();
		boolean b = false;
		for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                for (int z = 0; z < 2; z++) {
					if ((tiles[x][y][z] > 0,5) || (tiles[x][y][z] < 0)) { b = false; }
				}}}
		b = true;
		assertTrue(b);
		
	}
	
	
	

}
