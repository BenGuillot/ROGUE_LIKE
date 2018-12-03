package fr.uvsq.Max.RogueLikeMaven.Screen;

import asciiPanel.AsciiPanel; //librairie utilisée pour l'affichage
import java.awt.event.KeyEvent;

public interface Screen {
    public void displayOutput(AsciiPanel terminal); //permet l'affichage du jeu

    public Screen respondToUserInput(KeyEvent key); //permet la gesiton des entrée d'instructions au clavier
}