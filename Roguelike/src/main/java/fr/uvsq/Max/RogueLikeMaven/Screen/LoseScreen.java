package fr.uvsq.Max.RogueLikeMaven.Screen;

import asciiPanel.AsciiPanel;
import fr.uvsq.Max.RogueLikeMaven.PlayerClass;

import java.awt.event.KeyEvent;

public class LoseScreen implements Screen {
    private PlayerClass playerClass;

    LoseScreen(PlayerClass playerClass){
        this.playerClass = playerClass;
    }

    public void displayOutput(AsciiPanel terminal) {

        terminal.write("You lost.", 1, 1);
        terminal.write("Don't forget the chapeau before leaving", 1, 2);
        terminal.write("And try not to die too",1,3);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    /*
    permet de recommancer une partie
     */
    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new EarlyGameScreen() : this;
    }
}