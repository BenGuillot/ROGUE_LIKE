package fr.uvsq.Max.RogueLikeMaven.IO;

import fr.uvsq.Max.RogueLikeMaven.World.Tile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadState {
    Tile[][][] tile;
    FileInputStream file;

    public Tile[][][] getTile() {
        return tile;
    }

    public FileInputStream getFile() {
        return file;
    }

    public LoadState() throws IOException {
        this.file = new FileInputStream("savestate.txt");
        this.tile = LoadTile(this.file);
    }
    public Tile[][][] LoadTile(FileInputStream file) throws IOException {
        Tile[][][] tiles = new Tile[90][32][5];
        try {
            byte[] buff = new byte[8];
            for(int iDepth = 0; iDepth < 5; iDepth ++) {
                for (int iHeight = 0; iHeight < 32; iHeight++) {
                    for (int iWidth = 0; iWidth < 90; iWidth++) {
                        file.read(buff);
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tile;
    }
}



