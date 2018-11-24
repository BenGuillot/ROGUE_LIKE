import asciiPanel.AsciiPanel;

import java.util.List;


public class CreatureFactory {
    private World world;

    public CreatureFactory(World world){
        this.world = world;
    }

    public Creature newPlayer(List<String> messages){
        Creature player = new Creature(world, '@', AsciiPanel.brightWhite, 100, 10, 5);
        world.addAtEmptyLocation(player);
        new PlayerAi(player, messages);
        return player;
    }


    public Creature newFungus(){
        Creature fungus = new Creature(world, 'f', AsciiPanel.green, 20, 0, 0);
        world.addAtEmptyLocation(fungus);
        new FungusAi(fungus, this);
        return fungus;
    }


    /*public Creature Goblin(){
        Creature goblin = new Creature(world, 'g', AsciiPanel.brightGreen);
        new CreatureAi(goblin);
        return  goblin;
    }*/
}