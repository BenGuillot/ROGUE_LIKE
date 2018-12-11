package Test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.Creatures.PlayerAi;
import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.World;

public class PlayerAiTest {

	
		Tile[][][] t = new Tile[50][50][2];
		World a = new World(t);
		Creature c = new Creature(a,'A',Color.YELLOW, 100, 100, 10, 10);
		PlayerAi p = new PlayerAi(c, null);
	
	
	@Test
	public void testOnEnter() {
		p.onEnter(1,1,1,Tile.FLOOR);
		assertEquals(p.stepCount(),2);	
	}
	
	
	

}
