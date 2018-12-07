package fr.uvsq.Max.RogueLikeMaven.PathFind;


import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.PathFind.PathFinder;;


public class Path {
	private static PathFinder pf = new PathFinder();
	private List<Point> points;
	public List<Point> points() { return points; }

	public Path(Creature creature, int x, int y){
	      points = pf.findPath(creature, 
	                           new Point(creature.x, creature.y), 
	                           new Point(x, y), 
	                           300);
	  }
	
	

}
