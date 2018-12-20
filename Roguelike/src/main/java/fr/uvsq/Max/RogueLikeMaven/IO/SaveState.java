package fr.uvsq.Max.RogueLikeMaven.IO;


import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.Screen.EarlyGameScreen;
import fr.uvsq.Max.RogueLikeMaven.World.World;


import java.io.*;

//90 width, 32 height, 5 depth

public class SaveState {

    public SaveState(World world){
        //ecrire info dans un fichier
        FileOutputStream file = null;
        ObjectOutputStream oos;

        try{
            file = new FileOutputStream((new File("savestateWorld.txt")));
            oos = new ObjectOutputStream(file);
            for(int iDepth = 0; iDepth < 5; iDepth ++){
                for (int iHeight = 0; iHeight < 32; iHeight ++){
                    for (int iWidth = 0; iWidth < 90; iWidth ++){
                            oos.writeObject(world.getTiles(iWidth,iHeight,iDepth));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SaveState (Creature player){//sauvegarder HP, MANA, ATK SPELL DEF SPELL, utiliser player ET playerClass
        FileOutputStream file = null;
        ObjectOutputStream oos;
        try{
            file = new FileOutputStream((new File("savestatePlayer.txt")));
            oos = new ObjectOutputStream(file);
            oos.writeObject(player);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
