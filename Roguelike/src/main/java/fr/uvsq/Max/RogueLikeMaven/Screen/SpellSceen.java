package fr.uvsq.Max.RogueLikeMaven.Screen;

import asciiPanel.AsciiPanel;
import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.Spells;

import java.awt.event.KeyEvent;

public class SpellSceen implements Screen {
    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        terminal.writeCenter("Spell selection", 1);
        int y = 6;
        terminal.write("available spells : ", 2, y++);
        for (Spells spell: Creature.spells()) {
            terminal.write(spell.nom(), 2, y++);
        }

        terminal.writeCenter("-- press any key to continue --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }
}