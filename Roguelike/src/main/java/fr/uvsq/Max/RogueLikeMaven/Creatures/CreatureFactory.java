package fr.uvsq.Max.RogueLikeMaven.Creatures;

import fr.uvsq.Max.RogueLikeMaven.World.FieldOfView;
import fr.uvsq.Max.RogueLikeMaven.World.World;
import asciiPanel.AsciiPanel;

import java.util.List;

public class CreatureFactory {
    private World world;

    public CreatureFactory(World world){
        this.world = world;
    }

    public Creature newPlayer(List<String> messages, FieldOfView fov){
        Creature player = new Creature(world, 'J', AsciiPanel.brightWhite, 100, 100, 5);
        world.addAtEmptyLocation(player, 0);
        new PlayerAi(player, messages, fov);
        return player;
    }

    public Creature newFungus(int depth){
        Creature fungus = new Creature(world, 'f', AsciiPanel.green, 10, 0, 0);
        world.addAtEmptyLocation(fungus, depth);
        new FungusAi(fungus, this);
        return fungus;
    }
}