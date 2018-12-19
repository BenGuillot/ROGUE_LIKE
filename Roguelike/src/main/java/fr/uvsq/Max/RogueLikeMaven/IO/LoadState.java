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
import java.io.*;
import java.util.ArrayList;

public class LoadState {
    Tile[][][] tiles;
    ArrayList<Creature> creature = new ArrayList<Creature>();
    FileInputStream fileW;
    FileInputStream fileP;
    World world;
    Creature player;


    public Screen loadfailure(){
        return new StartScreen();
    }

    public Creature LoadPlayer() throws IOException {
        fileP = new FileInputStream("savestatePlayer.txt");
        ObjectInputStream ois = new ObjectInputStream(fileP);
        Creature player = null;
        try {
                player = (Creature) ois.readObject();
                ois.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            loadfailure();
        } catch (IOException e) {
            e.printStackTrace();
            loadfailure();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return player;
    }

    public Tile[][][] LoadTile() throws IOException {
        Tile[][][] tiles = new Tile[90][32][5];
        fileW = new FileInputStream("savestateWorld.txt");
        ObjectInputStream ois = new ObjectInputStream(fileW);
        Tile tile;
        try {
            for(int iDepth = 0; iDepth < 5; iDepth ++) {
                for (int iHeight = 0; iHeight < 32; iHeight++) {
                    for (int iWidth = 0; iWidth < 90; iWidth++) {
                        tile = (Tile) ois.readObject();
                        System.out.println(tile.glyph());
                            if ( tile == Tile.FLOOR){ //FLOOR
                                tiles[iWidth][iHeight][iDepth] = Tile.FLOOR;
                            } else if (tile == Tile.WALL){ //WALL
                                tiles[iWidth][iHeight][iDepth] = Tile.WALL;
                            } else if(tile == Tile.STAIRS_UP) {
                                tiles[iWidth][iHeight][iDepth] = Tile.STAIRS_UP;
                            } else if(tile == Tile.STAIRS_DOWN){
                                tiles[iWidth][iHeight][iDepth] = Tile.STAIRS_DOWN;
                            }
                            else tiles[iWidth][iHeight][iDepth] = Tile.BOUNDS;
                    }
                }
            }
        ois.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            loadfailure();
        } catch (IOException e) {
            e.printStackTrace();
            loadfailure();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tiles;
    }

    public LoadState() throws IOException{
        this.tiles = new Tile[90][32][5];
        this.tiles = LoadTile();
        this.world = new WorldBuilder(tiles).build();
        this.player = LoadPlayer();
        Load(world, player);
    }

    public Screen Load(World world, Creature player){
        return new PlayScreen(world, player);
    }
}



