package fr.uvsq.Max.RogueLikeMaven.Creatures;

import fr.uvsq.Max.RogueLikeMaven.PlayerClass;
import fr.uvsq.Max.RogueLikeMaven.Spells;
import fr.uvsq.Max.RogueLikeMaven.World.World;
import fr.uvsq.Max.RogueLikeMaven.Item;
import asciiPanel.AsciiPanel;

import java.util.List;

public class CreatureFactory {
    private World world;

    public CreatureFactory(World world){
        this.world = world;
    }

    /*
    utilisation des methodes de l'enum PlayerClass pour creer le personnage
    HP et MANA varient en fonction de la classe de départ
     */
    public Creature newPlayer(List<String> messages, PlayerClass playerClass){
        Creature player = new Creature(world, 'J', AsciiPanel.brightWhite, playerClass);
        world.addAtEmptyLocation(player, 0);
        new PlayerAi(player, messages);
        return player;
    }

    public Creature newFungus(int depth){
        Creature fungus = new Creature(world, 'f', AsciiPanel.green, 10, 0, 3, 0);
        world.addAtEmptyLocation(fungus, depth);
        new FungusAi(fungus, this);
        return fungus;
    }
    
    public Creature newPnj(int depth){
        Creature pnj = new Creature(world, 'P', AsciiPanel.white, 1, 0, 1, 0);
        world.addAtEmptyLocation(pnj, depth);
        new PnjAi(pnj, Chapeau(0));
        return pnj;
    }
    

    public Item newRock(int depth) {
        Item rock = new Item('R', AsciiPanel.brightCyan, "rock", 1);
        world.addAtEmptyLocation(rock, depth);
        return rock;
    }

    public Creature newBat(int depth) {
    	Creature bat = new Creature(world, 'b', AsciiPanel.yellow, 15, 0, 5, 0);
    	world.addAtEmptyLocation(bat, depth);
        new BatAi(bat);
        return bat;

    }
    
    public Item newpotionmana(int depth){
		Item potionmana = new Item('P', AsciiPanel.brightBlue, "potionmana", 1);
        world.addAtEmptyLocation(potionmana, depth);
        return potionmana;
	}
	
	public Item newpotionvie(int depth){
		Item potionvie = new Item('V', AsciiPanel.brightRed, "potionvie", 1);
        world.addAtEmptyLocation(potionvie, depth);
        return potionvie;
	}
    
    public Item frostmourn(int depth){
		 Item frostmourn = new Item('F', AsciiPanel.brightWhite, "frostmourn", 5);
		 
        world.addAtEmptyLocation(frostmourn, depth);
        return frostmourn;
    }
    
     public Item aluneth(int depth){
		 Item aluneth = new Item('A', AsciiPanel.brightWhite, "aluneth", 5);
		 
        world.addAtEmptyLocation(aluneth, depth);
        return aluneth;
    }
    
     public Item shyamalan(int depth){
		 Item shyamalan = new Item('S', AsciiPanel.brightWhite, "shyamalan", 5);
		 
        world.addAtEmptyLocation(shyamalan, depth);
        return shyamalan;
    }
    
     public Item ebonchill(int depth){
		 Item ebonchill = new Item('E', AsciiPanel.brightWhite, "ebonchill", 10);
		
        world.addAtEmptyLocation(ebonchill, depth);
        return ebonchill;
    }
    
     public Item gorehowl(int depth){
		 Item gorehowl = new Item('G', AsciiPanel.brightWhite, "gorehowl", 15);
		
        world.addAtEmptyLocation(gorehowl, depth);
        return gorehowl;
    }
    
     public Item woodenstaff(int depth){
		 Item woodenstaff = new Item('A', AsciiPanel.brightWhite, "woodenstaff", 2);
		 
        world.addAtEmptyLocation(woodenstaff, depth);
        return woodenstaff;
    }
    
      public Item Chapeau(int depth){
		 Item Chapeau = new Item('C', AsciiPanel.brightWhite, "Chapeau", 2);
		 
        world.addAtEmptyLocation(Chapeau, depth);
        return Chapeau;
    }
}
