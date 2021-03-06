package fr.uvsq.Max.RogueLikeMaven.Creatures;

import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.Point;

/** 
	* Classe CreatureAi 
	* Description : Ensemble des méthodes pour l'intelligence des créatures
	* @author B. Guillot, M. Gonthier, L. Martin
 */
public class CreatureAi {
    protected Creature creature;

	/**
	 * Constructeur de la classe CreatureAi
	 * @param creature
	 */
    public CreatureAi(Creature creature){
        this.creature = creature;
        this.creature.setCreatureAi(this);
    }

	/**
	 * Méthode permettant de déplacer les créatures
	 */
    public void wander() {
    	int rx = (int)(Math.random()*3)-1;
    	int ry = (int)(Math.random()*3)-1;
    	
    	Creature other = creature.creature(creature.x + rx, creature.y + ry, creature.z);
        if (other != null) {
        	if (other.glyph() == this.creature.glyph()) {
        		return;
        	}
        }
        else {
            this.creature.moveBy(rx, ry, 0);
        }
    	
    }
    
    /** 	
	 * Méthode pour changer de case
	 * @param x
	 * @param y
	 * @param z Coordonnées de la case.
	 * @param tile
	 */
    public void onEnter(int x, int y, int z, Tile tile){
    	if(tile.isGround()) {
    		this.creature.x = x;
    		this.creature.y = y;
    		this.creature.z = z;
    	}
    	else {
    		this.creature.doAction("Bump into a wall");
    	}
    }

    public void onUpdate(){
    }

    public void onNotify(String message){
    }
}

/*    public boolean canSee(int wx, int wy, int wz) {
        if (creature.z != wz)
            return false;


    //~ public boolean canSee(int wx, int wy, int wz) {
        //~ if (creature.z != wz)
            //~ return false;

        //~ if ((creature.x-wx)*(creature.x-wx) + (creature.y-wy)*(creature.y-wy) > creature.visionRadius()*creature.visionRadius())
            //~ return false;

        //~ for (Point p : new Line(creature.x, creature.y, wx, wy)){
            //~ if (creature.tile(p.x, p.y, wz).isGround() || p.x == wx && p.y == wy)
                //~ continue;


        return true;
    } */


            //~ return false;
        //~ }

        //~ return true;
    //~ }
   




