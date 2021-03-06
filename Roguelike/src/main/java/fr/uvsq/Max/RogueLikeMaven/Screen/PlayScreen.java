package fr.uvsq.Max.RogueLikeMaven.Screen;

import  fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import  fr.uvsq.Max.RogueLikeMaven.Creatures.CreatureFactory;
import fr.uvsq.Max.RogueLikeMaven.IO.LoadState;
import fr.uvsq.Max.RogueLikeMaven.PlayerClass;
import fr.uvsq.Max.RogueLikeMaven.IO.SaveState;
import  fr.uvsq.Max.RogueLikeMaven.World.World;
import  fr.uvsq.Max.RogueLikeMaven.World.Tile;
import  fr.uvsq.Max.RogueLikeMaven.Item;
import  fr.uvsq.Max.RogueLikeMaven.World.WorldBuilder;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
PLAY SCREEN : écran principal du jeu
Affiche l'environnement de jeu et le modifie en fonction des actions du joueur
 */


public class PlayScreen implements Screen {
    private World world;
    private LoadState loadState;
    private Creature player;
    private PlayerClass playerClass;
    private Screen subscreen;
    private int screenWidth;
    private int screenHeight;
    private List<String> messages;



    /*
    Creation du constructeur a avec l'argument playerClass permettant l'initialisation du jeu et du personnage
     */
    public PlayScreen(PlayerClass playerClass){
        screenWidth = 80;
        screenHeight = 23;
        this.playerClass = playerClass;
        messages = new ArrayList<String>();
        createWorld();

        CreatureFactory creatureFactory = new CreatureFactory(world);
        createCreatures(creatureFactory);
    }

    public PlayScreen(World world, Creature player) {
        screenWidth = 80;
        screenHeight = 23;
        messages = new ArrayList<String>();
        this.player = player;
        this.world = world;

        CreatureFactory creatureFactory = new CreatureFactory(world);
        createCreatures(creatureFactory, player);
    }


   /* public PlayScreen(){
        screenWidth = 80;
        screenHeight = 23;
        messages = new ArrayList<String>();
        createWorld();

        CreatureFactory creatureFactory = new CreatureFactory(world);
        createCreatures(creatureFactory);
    }*/

    private void createCreatures(CreatureFactory creatureFactory){
        player = creatureFactory.newPlayer(messages, this.playerClass);
        
        for (int z = 0; z < world.depth()-1; z++){
        	creatureFactory.newPnj(z);
        }
        creatureFactory.newSuperPnj(world.depth()-1);
        
        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 8; i++){
                creatureFactory.newFungus(z);
            }
            
        }
        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 8; i++){
                creatureFactory.newRock(z);
            }
            
        }
        
        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 8; i++){
                creatureFactory.newBat(z);
            }
        }
        
        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 8; i++){
                creatureFactory.newpotionmana(z);
            }
        }
        
         for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 8; i++){
                creatureFactory.newpotionvie(z);
            }
        }
        
         for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 1; i++){
                creatureFactory.frostmourn(z);
            }
        }
        
        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 1; i++){
                creatureFactory.aluneth(z);
            }
        }
        
        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 1; i++){
                creatureFactory.woodenstaff(z);
            }
        }
        
        /* for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 1; i++){
                creatureFactory.shyamalan(z);
            }
        }
        
       
        
        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 1; i++){
                creatureFactory.ebonchill(z);
            }
        }
        
        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 1; i++){
                creatureFactory.gorehowl(z);
            }
        } */
        
    }
    private void createCreatures(CreatureFactory creatureFactory, Creature player){
        this.player = player;

        for (int z = 0; z < world.depth()-1; z++){
            creatureFactory.newPnj(z);
        }
        creatureFactory.newSuperPnj(world.depth()-1);

        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 8; i++){
                creatureFactory.newFungus(z);
            }

        }
        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 8; i++){
                creatureFactory.newRock(z);
            }

        }

        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 8; i++){
                creatureFactory.newBat(z);
            }
        }

        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 8; i++){
                creatureFactory.newpotionmana(z);
            }
        }

        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 8; i++){
                creatureFactory.newpotionvie(z);
            }
        }

        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 1; i++){
                creatureFactory.frostmourn(z);
            }
        }

        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 1; i++){
                creatureFactory.aluneth(z);
            }
        }

        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < 1; i++){
                creatureFactory.woodenstaff(z);
            }
        }

    }

    private void createWorld(){
        world = new WorldBuilder(90, 32, 5)
                .makeCaves()
                .build();
    }

    public int getScrollX() { return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth)); }

    public int getScrollY() { return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight)); }

    /*
    Fonction gérant l'affichage
     */
    public void displayOutput(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top);
        displayMessages(terminal, messages);

        if (subscreen != null)
            subscreen.displayOutput(terminal);


        String stats = String.format(" %3d/%3d hp" + " %3d/%3d mana" + " %3d BASE ATK" + "  %3d BASE DEF", player.hp(), player.maxHp(), player.mana(), player.maxMana(), player.attackValue(), player.defenseValue());
        terminal.write(stats , 1, 23);
    }

    private void displayMessages(AsciiPanel terminal, List<String> messages) {
        int top = screenHeight - messages.size();
        for (int i = 0; i < messages.size(); i++){
            terminal.writeCenter(messages.get(i), top + i);
        }
        messages.clear();
    }

    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++){
            for (int y = 0; y < screenHeight; y++){
                int wx = x + left;
                int wy = y + top;

                Creature creature = world.creature(wx, wy, player.z);
                if (creature != null)
                    terminal.write(creature.glyph(), creature.x - left, creature.y - top, creature.color());
                else
                    terminal.write(world.glyph(wx, wy, player.z), x, y, world.color(wx, wy, player.z));
            }
        }
    }
    
    private boolean userIsTryingToExit(){
        return player.z == 0 && world.tile(player.x, player.y, player.z) == Tile.STAIRS_UP;
    }

    private Screen userExits(){
        for (Item item : player.inventory().getItems()){
            if (item != null && item.name().equals("Chapeau"))
                return new WinScreen();
        }
        return new LoseScreen(playerClass);
    }

    /*
    liste des commandes utilisables par le joueur et actions effectuées dans ce cas
     */
    public Screen respondToUserInput(KeyEvent key) throws IOException {
    	 if (subscreen != null) {
             subscreen = subscreen.respondToUserInput(key);
         } else {
        switch (key.getKeyCode()){
            case KeyEvent.VK_LEFT: player.moveBy(-1, 0, 0); break;
            case KeyEvent.VK_RIGHT: player.moveBy( 1, 0, 0); break;
            case KeyEvent.VK_UP: player.moveBy( 0,-1, 0); break;
            case KeyEvent.VK_DOWN: player.moveBy( 0, 1, 0); break;
            case KeyEvent.VK_O: new SaveState(world); new SaveState(player); break;
            case KeyEvent.VK_D: subscreen = new DropScreen(player); break;
            case KeyEvent.VK_S: subscreen = new SpellSceen(player); break;
            case KeyEvent.VK_V: if ((player.hp() < player.maxHp() - 10) && (player.verification() == true)) { player.modifyHp(10);  } else { player.modifyHp(0); } break;
            case KeyEvent.VK_M: if ((player.mana() < player.maxMana() - 10) && (player.verification() == true)) { player.modifyMana(10);} else { player.modifyMana(0); } break;
        }

        switch (key.getKeyChar()){
            case '<':  if (userIsTryingToExit())
                {return userExits(); }
            else
             {player.moveBy( 0, 0, -1); }
            break;
            case '>': player.moveBy( 0, 0, 1); break;
            case ',': player.pickup(); break;
            case 'h': subscreen = new HelpScreen(); break;
        }
         }

    	  if (subscreen == null)
    	         world.update();
    	    
    	     if (player.hp() < 1)
    	         return new LoseScreen(playerClass);
    	    
        return this;
    }
    private void createItems(CreatureFactory factory) {
        for (int z = 0; z < world.depth(); z++){
            for (int i = 0; i < world.width() * world.height() / 20; i++){
                factory.newRock(z);
                factory.newRock(world.depth()-1);
                 factory.newpotionmana(z);
                factory.newpotionmana(world.depth()-1);
            }
        }
    }
}
