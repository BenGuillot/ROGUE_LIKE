package fr.uvsq.Max.RogueLikeMaven.IO;

import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.Screen.Screen;
import fr.uvsq.Max.RogueLikeMaven.Screen.StartScreen;
import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.World;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadState {
    Tile[][][] tile;
    FileInputStream fileW, fileP;
    Creature player;
    World world;

    public Tile[][][] getTile() {
        return tile;
    }

    public World getWorld() {
        return world;
    }
    public Creature getPlayer() {
        return player;
    }

    public LoadState() throws IOException {
        this.fileW = new FileInputStream("savestateWorld.txt");
        this.fileP = new FileInputStream("savestatePlayer.txt");
        this.tile = LoadTile();
        this.world = new World(tile);
        this.player = LoadPlayer();
    }

    public Screen loadfailure(){
        return new StartScreen();
    }
    public Tile[][][] LoadTile() throws IOException {
        Tile[][][] tiles = new Tile[90][32][5];
        try {
            byte[] buff = new byte[8];
            for(int iDepth = 0; iDepth < 5; iDepth ++) {
                for (int iHeight = 0; iHeight < 32; iHeight++) {
                    for (int iWidth = 0; iWidth < 90; iWidth++) {
                        this.fileW.read(buff);
                        for (byte bit : buff) {
                            if ((char) bit == (char) 250) { //FLOOR
                                tiles[iWidth][iHeight][iDepth] = Tile.FLOOR;
                            } else if ((char) bit == (char) 177) { //WALL
                                tiles[iWidth][iHeight][iDepth] = Tile.WALL;
                            }
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

        return tile;
    }

    public Creature LoadPlayer (){
        try {
            byte[] buff = new byte[8];
            this.fileW.read(buff);
            this.player = new Creature(this.world, 'J', Color.WHITE, 100,100, 5, 5);
            buff = new byte[8];
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            loadfailure();
        } catch (IOException e) {
            e.printStackTrace();
            loadfailure();
        }
        return player;
    }
}



