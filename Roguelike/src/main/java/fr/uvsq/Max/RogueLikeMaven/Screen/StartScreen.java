package fr.uvsq.Max.RogueLikeMaven.Screen;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    /*
    Affiche les informations utiles au joueur pour commencer à jouer
     */
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("ROGUE LIKE : ROGER'DOOM", 30, 10);
        terminal.writeCenter("-- press [enter] to start --", 22);


        terminal.write("DEFEAT THE MIGHT ROGER", 10, 4);
        terminal.write("TO RETREIVE THE ONE TEDDY BEAR", 10, 5);
        terminal.write("AND WIN THE GAME", 10, 6);
        terminal.write("COMMAND LIST : [h] ", 30, 18);

    }




    /*
    Réagie en fonction des entrées clavier du joueur
     */
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new EarlyGameScreen() : this;
    }
}