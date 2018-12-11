package fr.uvsq.Max.RogueLikeMaven.Screen;

import asciiPanel.AsciiPanel;
import fr.uvsq.Max.RogueLikeMaven.Creatures.Creature;
import fr.uvsq.Max.RogueLikeMaven.Spell;
import fr.uvsq.Max.RogueLikeMaven.Spells;

import java.awt.event.KeyEvent;


public class SpellSceen implements Screen {

    Creature player;
    Spell ATK;
    Spell DEF;

    SpellSceen(Creature creature){
        this.player = creature;
        this.ATK = player.ATKSpell();
        this.DEF = player.DEFSpell();
    }
    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        terminal.writeCenter("Spell selection", 1);
        int y = 6;
        terminal.write("available spells : ", 2, y++);
        terminal.write(DEF.name() + " ["+ DEF.glyph() + "] to use. cost " + DEF.manaCost() + " mana", 2, y++);
        if(ATK.name() != "NULL"){
            terminal.write(ATK.name() + " ["+ATK.glyph()+"] to use. cost "+ATK.manaCost()+"mana", 2, y++);
        }
        terminal.writeCenter("-- press any key to continue --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyChar()){
            case 'h' : player.cast(DEF); break;
            case 'a' : player.cast(ATK); break;
        }
        return null;
    }
}
