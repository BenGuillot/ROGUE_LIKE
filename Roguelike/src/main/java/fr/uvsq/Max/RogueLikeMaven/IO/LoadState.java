package fr.uvsq.Max.RogueLikeMaven.IO;

import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.PlayerClass;
import fr.uvsq.Max.RogueLikeMaven.Screen.PlayScreen;
import fr.uvsq.Max.RogueLikeMaven.Screen.Screen;
import fr.uvsq.Max.RogueLikeMaven.Screen.StartScreen;
import fr.uvsq.Max.RogueLikeMaven.Spell;
import fr.uvsq.Max.RogueLikeMaven.Spells;
import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.World;
import fr.uvsq.Max.RogueLikeMaven.World.WorldBuilder;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class LoadState {
    Tile[][][] tiles;
    ArrayList<Creature> creature = new ArrayList<Creature>();
    FileInputStream fileW;
    FileInputStream fileP;
    FileInputStream filePC;
    PlayerClass playerClass;
    World world;
    Creature player = new Creature(world, 'J', Color.WHITE, 100, 100 ,0,0);


    public Screen loadfailure(){
        return new StartScreen();
    }

    public Creature LoadPlayer() throws FileNotFoundException {
        fileP = new FileInputStream("savestatePlayer.txt");
        filePC =  new FileInputStream("savestatePlayerClass.txt");
        int cpt = 0;
        try {
            byte[] buff = new byte[8];
                for (byte bit : buff) {
                    //System.out.println((int)bit);
                    if (cpt == 0) {
                        this.player.setHP((int) bit);
                        cpt++;
                    } else if (cpt == 1) {
                        this.player.setMANA((int) bit);
                        cpt++;

                    } else if (cpt == 2) {
                        this.player.setAttackValue((int) bit);
                        cpt++;
                    } else if (cpt == 3) {
                        this.player.setAttackValue((int) bit);
                        cpt++;
                    }
                }
                buff = new byte[8];

            playerClass = PlayerClass.NULL;
                for (byte bit : buff) {
                    if (bit == 'e'){
                        playerClass.setHealingSpell(new Spell(Spells.HEALING_PULSE));
                        buff = new byte[8];
                        this.filePC.read(buff);
                        if (bit == 'm'){
                            playerClass.setAttackSpell(new Spell(Spells.ARCAN_BLAST));
                        }
                    }
                    else if (bit == 'n'){
                        playerClass.setHealingSpell(new Spell(Spells.HEALING_WAVE));
                        buff = new byte[8];
                        this.filePC.read(buff);
                        if (bit == 'm'){
                            playerClass.setAttackSpell(new Spell(Spells.EBONBOLT));
                        }
                    }
                    else if (bit == 'h'){
                        playerClass.setHealingSpell(new Spell(Spells.SMALL_HEAL));
                        buff = new byte[8];
                        this.filePC.read(buff);
                        if (bit == 'm'){
                            playerClass.setAttackSpell(new Spell(Spells.FIREBOLT));
                        }
                    }
                }

            player = new Creature(world, 'J', Color.WHITE, playerClass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            loadfailure();
        } catch (IOException e) {
            e.printStackTrace();
            loadfailure();
        }

        return player;
    }

    public Tile[][][] LoadTile() throws  FileNotFoundException{
        Tile[][][] tiles = new Tile[90][32][5];
        fileW = new FileInputStream("savestateWorld.txt");
        try {
            byte[] buff = new byte[8];
            for(int iDepth = 0; iDepth < 5; iDepth ++) {
                for (int iHeight = 0; iHeight < 32; iHeight++) {
                    for (int iWidth = 0; iWidth < 90; iWidth++) {
                        this.fileW.read(buff);
                        for (byte bit : buff) {
                            if ((char) bit == Tile.FLOOR.glyph()) { //FLOOR
                                tiles[iWidth][iHeight][iDepth] = Tile.FLOOR;
                            } else if ((char) bit == Tile.WALL.glyph()) { //WALL
                                tiles[iWidth][iHeight][iDepth] = Tile.WALL;
                            } /*else if((char) bit == (char) 60) {
                                tiles[iWidth][iHeight][iDepth] = Tile.STAIRS_UP;
                            } else if((char) bit == (char) 62){
                                tiles[iWidth][iHeight][iDepth] = Tile.STAIRS_DOWN;
                            }*/
                            else tiles[iWidth][iHeight][iDepth] = Tile.FLOOR;
                        }
                        buff = new byte[8];
                    }
                }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            loadfailure();
        } catch (IOException e) {
            e.printStackTrace();
            loadfailure();
        }
        return tiles;
    }

    public LoadState() throws IOException{
        this.player = LoadPlayer();
        this.tiles = new Tile[90][32][5];
        this.tiles = LoadTile();
        this.world = new WorldBuilder(tiles).build();
        for (int i = 0; i < 5; i ++){
            for (int y = 0; y < 32; y ++){
                for (int z = 0; z < 90; z ++){
                    System.out.println(this.tiles[z][y][i].glyph());
                }
            }
        }
        Load(world, player);
    }

    public Screen Load(World world, Creature player){
        return new PlayScreen(world, player);
    }
}



