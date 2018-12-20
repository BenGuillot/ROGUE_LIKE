package fr.uvsq.Max.RogueLikeMaven.Creatures;

import fr.uvsq.Max.RogueLikeMaven.Spell;
import fr.uvsq.Max.RogueLikeMaven.Spells;
import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import java.util.List;

/** 
	* Classe PlayerAi Extends : CreatureAi
	* Description : Permet de gérer les déplacements du player
	* @author B. Guillot, M. Gonthier, L. Martin
 */
public class PlayerAi extends CreatureAi {
    private int stepCount = 1;
    public int stepCount() { return stepCount; }

    private List<String> messages;
    public List<String> messages() { 
    	return messages; 
    }
    
    /**
     * Constructeur de la classe PlayerAi
     * @param creature  Une créature
     * @param messages  La liste des messages
     */
    public PlayerAi(Creature creature, List<String> messages) {
        super(creature);
        this.messages = messages;
    }

	/** 	
	 * Méthode pour changer de case
	 * @param x
	 * @param y
	 * @param z Coordonnées de la case.
	 * @param tile  La case
	 */
    public void onEnter(int x, int y, int z, Tile tile){
        if (tile.isGround()){
            creature.x = x;
            creature.y = y;
            creature.z = z;
            stepCount += 1;
            regainHP_MANA();
        } else if (tile.isDiggable()) {
            creature.dig(x, y, z);
            creature.modifyHp(-1);
            messages.add("you lose 1 HP");
        }
    }

/** 	
	 * Méthode pour modifier HP et le MANA du player en marchant
	 */
    public void regainHP_MANA(){
        if (this.stepCount % 10 == 0){
            if (creature.hp() < creature.maxHp() -1){
                creature.modifyHp(2);
                messages.add("you regain 2 HP");
            }
            if (creature.mana() < creature.maxMana()){
                creature.setMANA(creature.mana()+1);
                messages.add("you regain 1 MANA");
            }
        }
    }

	/**
	 * Méthode pour gérer les messages au joueur
	 */
    public void onNotify(String message){
        messages.add(message);
    }
}
