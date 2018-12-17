package fr.uvsq.Max.RogueLikeMaven.IO;


import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.PlayerClass;
import fr.uvsq.Max.RogueLikeMaven.Screen.EarlyGameScreen;
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
            file = new FileOutputStream((new File("savestateWorld.txt")));

            for(int iDepth = 0; iDepth < 5; iDepth ++){
                for (int iHeight = 0; iHeight < 32; iHeight ++){
                    for (int iWidth = 0; iWidth < 90; iWidth ++){
                        if (world.creature(iWidth,iHeight,iDepth)==null){
                            file.write(world.getTiles(iWidth,iHeight,iDepth).glyph());
                        }
                        else file.write(world.creature(iWidth,iHeight,iDepth).glyph());
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
        try{
            file = new FileOutputStream((new File("savestatePlayer.txt")));
            file.write(player.mana());
            file.write(player.hp());
            file.write(player.attackValue());
            file.write(player.defenseValue());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SaveState (EarlyGameScreen earlyGameScreen){
        FileOutputStream file = null;
        System.out.println("coucou1");
        try{
            file = new FileOutputStream((new File("savestatePlayerClass.txt")));
            file.write(earlyGameScreen.getDifficulty().glyph());
            file.write(earlyGameScreen.getPlayerClass().glyph());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
