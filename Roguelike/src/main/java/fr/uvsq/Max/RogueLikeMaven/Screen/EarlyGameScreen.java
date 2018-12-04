package fr.uvsq.Max.RogueLikeMaven.Screen;

import asciiPanel.AsciiPanel;
import fr.uvsq.Max.RogueLikeMaven.Difficulty;
import fr.uvsq.Max.RogueLikeMaven.PlayerClass;


import java.awt.event.KeyEvent;

public class EarlyGameScreen implements  Screen{
    private Difficulty difficulty = Difficulty.NULL;
    private PlayerClass playerClass = PlayerClass.NULL;

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("ROGUE LIKE : PARAMETER" + "", 10, 1);
        terminal.write("DIFFICUTLY", 30, 4);
        terminal.write("Easy--[e]", 20, 5);
        terminal.write("Normal--[n]", 30, 5);
        terminal.write("Hard--[h]", 42, 5);
        terminal.write ("chosen Difficutly : "+ difficulty.nom(), 25, 7);
        if (this.difficulty.nom() == "EasyMode"){
            terminal.write("AVAILABLE CLASS", 30, 9);
            terminal.write("WARLORD--[w]", 20, 10);
            terminal.write("ARCHMAGE--[a]",40,10);
        }
        if (this.difficulty.nom() == "NormalMode"){
            terminal.write("AVAILABLE CLASS", 30, 9);
            terminal.write("WARRIOR--[w]", 20, 10);
            terminal.write("MAGE--[m]",40,10);
        }
        if (this.difficulty.nom() == "HardMode"){
            terminal.write("AVAILABLE CLASS", 30, 9);
            terminal.write("MERCENARY--[m]", 20, 10);
            terminal.write("NOVICE--[n]",40,10);
        }
        terminal.write ("chosen player class : "+ playerClass.nom(), 25, 12);
        terminal.writeCenter("-- press [enter] to start --", 22);

    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ENTER: return new PlayScreen();
        }

        switch (key.getKeyChar()){
            case 'e': this.difficulty = Difficulty.EASY;
                        switch (key.getKeyCode()){
                            case 'w' : this.playerClass = PlayerClass.WARLORD; break;
                            case 'a' : this.playerClass = PlayerClass.ARCHMAGE; break;
                        } break;
            case 'n': this.difficulty = Difficulty.NORMAL;
                        switch (key.getKeyCode()){
                            case 'w' : this.playerClass = PlayerClass.WARRIOR; break;
                            case 'm' : this.playerClass = PlayerClass.MAGE; break;
                        } break;
            case 'h': this.difficulty = Difficulty.HARD;
                        switch (key.getKeyCode()){
                            case 'm' : this.playerClass = PlayerClass.MERCENARY; break;
                            case 'n' : this.playerClass = PlayerClass.NOVICE; break;
                        } break;
        }
        return this;
    }

}
