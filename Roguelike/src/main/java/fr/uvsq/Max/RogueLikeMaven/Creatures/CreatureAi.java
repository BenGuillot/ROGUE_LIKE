package fr.uvsq.Max.RogueLikeMaven.Creatures;

import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.Point;

public class CreatureAi {
    protected Creature creature;

    public CreatureAi(Creature creature){
        this.creature = creature;
        this.creature.setCreatureAi(this);
    }

    public void wander() {
    	int rx = (int)(Math.random()*3)-1;
    	int ry = (int)(Math.random()*3)-1;
    	//// this.creature.moveBy(rx, ry, 0);
    	
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