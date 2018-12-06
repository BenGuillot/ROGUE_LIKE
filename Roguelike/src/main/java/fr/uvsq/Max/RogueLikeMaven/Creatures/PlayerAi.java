package fr.uvsq.Max.RogueLikeMaven.Creatures;

import fr.uvsq.Max.RogueLikeMaven.Spell;
import fr.uvsq.Max.RogueLikeMaven.Spells;
import fr.uvsq.Max.RogueLikeMaven.World.Tile;


import java.util.List;
public class PlayerAi extends CreatureAi {
    private int stepCount = 1;

    private List<String> messages;

    public PlayerAi(Creature creature, List<String> messages) {
        super(creature);
        this.messages = messages;
    }

    public void onEnter(int x, int y, int z, Tile tile){
        if (tile.isGround()){
            creature.x = x;
            creature.y = y;
            creature.z = z;
            stepCount += 1;
            regainHP_MANA();
        } else if (tile.isDiggable()) {
            creature.dig(x, y, z);
            creature.setHP(creature.hp()-1);
            messages.add("you lose 1 HP");
        }
    }

    public void regainHP_MANA(){
        if (this.stepCount % 10 == 0){
            if (creature.hp() < creature.maxHp() -1){
                creature.setHP(creature.hp() + 2);
                messages.add("you regain 2 HP");
            }
            if (creature.mana() < creature.maxMana()){
                creature.setMANA(creature.mana()+1);
                messages.add("you regain 1 MANA");
            }
        }
    }


    public void onNotify(String message){
        messages.add(message);
    }
}