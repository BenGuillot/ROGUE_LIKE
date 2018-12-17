package fr.uvsq.Max.RogueLikeMaven.IO;

import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.Screen.PlayScreen;
import fr.uvsq.Max.RogueLikeMaven.Screen.Screen;
import fr.uvsq.Max.RogueLikeMaven.Screen.StartScreen;
import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.World;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoadState {
    Tile[][][] tiles;
    ArrayList<Creature> creature = new ArrayList<Creature>();
    FileInputStream fileW;//
    FileInputStream fileP;// = new FileInputStream("saveStatePlayer.txt");
    FileInputStream filePC;// = new FileInputStream("saveStatePlayerClass.txt");
    Creature player;
    World world;

    public Screen loadfailure(){
        return new StartScreen();
    }

    public Creature LoadPlayer() throws FileNotFoundException {
        fileP = new FileInputStream("saveStateWorld.txt");
        try {
            byte[] buff = new byte[8];
            this.fileP.read(buff);
            for (byte bit : buff) {
                this.player.setHP((int) bit);
                this.player.setMANA((int) bit);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            loadfailure();
        } catch (IOException e) {
            e.printStackTrace();
            loadfailure();
        }

        return player;
    }

    public LoadState() throws IOException{
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
    }
}



