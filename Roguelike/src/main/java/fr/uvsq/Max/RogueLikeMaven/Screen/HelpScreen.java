package fr.uvsq.Max.RogueLikeMaven.Screen;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class HelpScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        terminal.writeCenter("ROGER's DOOM help", 1);
        terminal.write("Descend the Caves Of Slight Danger, find the lost Teddy Bear, and return to", 1, 3);
        terminal.write("the surface to win. Use what you find to avoid dying.", 1, 4);

        int y = 6;
        terminal.write("[,] to pick up", 2, y++);
        terminal.write("[s] to choose spell", 2, y++);
        terminal.write("[d] to drop", 2, y++);
        terminal.write("[o] to save", 2, y++);
        //terminal.write("[e] to eat (regen HP)", 2, y++);
        //terminal.write("[b] to drink (regen MANA)", 2, y++);
        terminal.write("[w] to wear or wield", 2, y++);
        terminal.write("[h] for help", 2, y++);
        terminal.write("[<] & [>] to take stairs", 2, y++);
        terminal.write("[UP][DOWN][RIGHT][LEFT] to move", 2, y++);

        terminal.writeCenter("-- press any key to continue --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }
}