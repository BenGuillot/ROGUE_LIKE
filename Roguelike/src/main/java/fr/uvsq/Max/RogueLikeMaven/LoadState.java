package fr.uvsq.Max.RogueLikeMaven;

import fr.uvsq.Max.RogueLikeMaven.Screen.PlayScreen;
import fr.uvsq.Max.RogueLikeMaven.Screen.Screen;

import java.io.File;

public class LoadState {
    public Screen LoadState(File file){
        //creer le monde en lisant un fichier
        return new PlayScreen();
    }
}