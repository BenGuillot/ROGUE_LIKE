package fr.uvsq.Max.RogueLikeMaven.Creatures;

import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.Line;
import fr.uvsq.Max.RogueLikeMaven.World.Point;

public class BatAi extends CreatureAi {
	public BatAi(Creature creature) {
		super(creature);
	}
	
	public void onUpdate() {
		wander();
		wander();
	}
}
