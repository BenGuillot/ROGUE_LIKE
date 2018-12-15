package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.Max.RogueLikeMaven.World.*;

public class WorldBuilderTest  {
	
	WorldBuilder a;
	private Tile[][][] tiles;
	@Before
	public void initialize() { a = new WorldBuilder(50,50,1); }
	
	@Test
	public void testAddExitStairs(){
		
		tiles = null;
		a.addExitStairs();
		boolean a = false;
		int x = 0; int y = 0;
		for (x = 0; x < 50; x++)
		{
			for (y = 0; y < 50; y++)
			{
				
				if (tiles[x][y][0] == Tile.STAIRS_UP) { a = true; }
			}
		}
		assertTrue(a == true);
	}
	
	

}
