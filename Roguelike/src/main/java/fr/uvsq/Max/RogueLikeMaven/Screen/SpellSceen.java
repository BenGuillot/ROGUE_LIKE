package fr.uvsq.Max.RogueLikeMaven.Screen;

import asciiPanel.AsciiPanel;
import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.Spells;

import java.awt.event.KeyEvent;
import java.util.List;

public class SpellSceen implements Screen {

    Creature player;

    SpellSceen(Creature creature){
        this.player = creature;
    }
    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        terminal.writeCenter("Spell selection", 1);
        int y = 6;
        terminal.write("available spells : ", 2, y++);
        for (Spells spell: player.spells()) {
            terminal.write(spell.nom() + " ["+spell.SpellGlyph() + "] to use", 2, y++);
        }

        terminal.writeCenter("-- press [enter] continue --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyChar()){
            case 'h' : player.setHP(player.hp()+5); break;
        }
        return null;
    }
}
