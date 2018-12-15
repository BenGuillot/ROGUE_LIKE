package fr.uvsq.Max.RogueLikeMaven.IO;

import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.World.World;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//90 width, 32 height, 5 depth

public class SaveState {

    public SaveState(World world){
        //ecrire info dans un fichier
        FileOutputStream file = null;

        try{
            file = new FileOutputStream((new File("savestate.txt")));

            for(int iDepth = 0; iDepth < 5; iDepth ++){
                for (int iHeight = 0; iHeight < 32; iHeight ++){
                    for (int iWidth = 0; iWidth < 90; iWidth ++){
                        file.write(world.getTiles(iWidth,iHeight,iDepth).glyph());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
