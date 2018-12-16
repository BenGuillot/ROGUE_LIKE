package Test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.Creatures.FungusAi;
import fr.uvsq.Max.RogueLikeMaven.Creatures.PlayerAi;
import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.World;

public class FungusAiTest {

	FungusAi p;
	Tile[][][] t;
	World a;
	Creature c;
	@Before
	public void init() {
		t = new Tile[50][50][2];
		a = new World(t);
		c = new Creature(a,'A',Color.YELLOW, 100, 100, 10, 10);
		p = new FungusAi(c, null);
	
	}
	
	@Test
	public void testSPread() {
		p.spread();
		assertEquals(p.spreadcount(),0);	
	}
	
	
	

}
