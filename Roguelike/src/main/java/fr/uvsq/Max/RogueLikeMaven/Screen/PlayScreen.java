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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    public PlayScreen(boolean load) throws IOException {
        screenWidth = 80;
        screenHeight = 23;
        messages = new ArrayList<String>();
        createWorld(true);

        CreatureFactory creatureFactory = new CreatureFactory(world);
        createCreatures(creatureFactory);
    }


    public PlayScreen(){
        screenWidth = 80;
        screenHeight = 23;
        messages = new ArrayList<String>();
        createWorld();

        CreatureFactory creatureFactory = new CreatureFactory(world);
        createCreatures(creatureFactory);
    }

    private void createCreatures(CreatureFactory creatureFactory){
        player = creatureFactory.newPlayer(messages, this.playerClass);
        
        for (int z = 0; z < world.depth()-1; z++){
        	creatureFactory.newPnj(z);
        }
        //creatureFactory.newSuperPnj(world.depth());
        
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

    private void createWorld(){
        world = new WorldBuilder(90, 32, 5)
                .makeCaves()
                .build();
    }

    private void createWorld(boolean load) throws IOException {
        if (load == true){
            loadState = new LoadState();
        }
        Tile[][][] tile = loadState.LoadTile(loadState.getFile());
        world = new WorldBuilder(loadState.getTile()).build();
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
            //case KeyEvent.VK_ESCAPE: return new LoseScreen();
            //case KeyEvent.VK_ENTER: return new WinScreen();
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H: player.moveBy(-1, 0, 0); break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L: player.moveBy( 1, 0, 0); break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_K: player.moveBy( 0,-1, 0); break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J: player.moveBy( 0, 1, 0); break;
            case KeyEvent.VK_Y: player.moveBy(-1,-1, 0); break;
            case KeyEvent.VK_U: player.moveBy( 1,-1, 0); break;
            case KeyEvent.VK_B: player.moveBy(-1, 1, 0); break;
            case KeyEvent.VK_N: player.moveBy( 1, 1, 0); break;
            case KeyEvent.VK_O: new SaveState(world); break;
            case KeyEvent.VK_D: subscreen = new DropScreen(player); break;
            case KeyEvent.VK_S: subscreen = new SpellSceen(player); break;
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
    	    
    	     /*if (player.hp() < 1)
    	         return new LoseScreen(playerClass);*/
    	    
        return this;
    }

    public Screen death(){
        if(player.hp() <= 0) {
            return new LoseScreen(playerClass);
        }
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
