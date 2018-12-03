package fr.uvsq.Max.RogueLikeMaven.Screen;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    /*
    Affiche les informations utiles au joueur pour commencer à jouer
     */
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("ROGUE LIKE : first step", 10, 10);
        terminal.writeCenter("-- press [enter] to start --", 22);

        /*
        LISTE DES COMMANDES
         */
        terminal.write("-[UP] to go up", 30, 18);
        terminal.write("-[DOWN] to go down", 30, 17);
        terminal.write("-[LEFT] to go left", 30, 16);
        terminal.write("-[RIGHT] to go right", 30, 15);
        terminal.write("-[>] or [<] to take stairs", 30, 14);
        terminal.write("COMMAND LIST : ", 30, 13);
    }




    /*
    Réagie en fonction des entrées clavier du joueur
     */
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}