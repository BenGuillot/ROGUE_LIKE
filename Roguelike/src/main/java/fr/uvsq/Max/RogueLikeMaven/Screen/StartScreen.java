package fr.uvsq.Max.RogueLikeMaven.Screen;

import asciiPanel.AsciiPanel;
import fr.uvsq.Max.RogueLikeMaven.IO.LoadState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class StartScreen implements Screen {

    /*
    Affiche les informations utiles au joueur pour commencer à jouer
     */
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("ROGUE LIKE : ROGER'DOOM", 30, 10);
        terminal.writeCenter("-- press [enter] to start --", 22);


        terminal.write("FIND THE MIGHTY *", 10, 4);
        terminal.write("TO RETREIVE THE ONE CHAPEAU", 10, 5);
        terminal.write("AND WIN THE GAME BY", 10, 6);
        terminal.write("TAKING THE STAIR UP AT 1RST LVL", 10, 7);
        terminal.write("COMMAND LIST : [h] ", 30, 18);
        terminal.write("load previous game : [l] ", 30, 21);

    }




    /*
    Réagie en fonction des entrées clavier du joueur
     */
    public Screen respondToUserInput(KeyEvent key) throws IOException {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ENTER: return new EarlyGameScreen();
        }
        /*switch (key.getKeyChar()){
            case 'l': LoadState load = new LoadState(); load.LoadTile(); return new PlayScreen(load.getTile());
        }*/
        return this;
    }
}