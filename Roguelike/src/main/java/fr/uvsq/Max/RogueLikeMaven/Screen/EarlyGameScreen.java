package fr.uvsq.Max.RogueLikeMaven.Screen;

import asciiPanel.AsciiPanel;
import fr.uvsq.Max.RogueLikeMaven.Difficulty;
import fr.uvsq.Max.RogueLikeMaven.PlayerClass;
import fr.uvsq.Max.RogueLikeMaven.Spell;
import fr.uvsq.Max.RogueLikeMaven.Spells;


import java.awt.event.KeyEvent;

public class EarlyGameScreen implements  Screen{
    private Difficulty difficulty;
    private PlayerClass playerClass;


    EarlyGameScreen(){
        this.difficulty = Difficulty.NULL;
        this.playerClass = PlayerClass.NULL;
    }




    public void displayOutput(AsciiPanel terminal) {
        terminal.write("ROGUE LIKE : PARAMETER" + "", 10, 1);
        terminal.write("DIFFICUTLY", 30, 4);
        terminal.write("Easy--[e]", 20, 5);
        terminal.write("Normal--[n]", 30, 5);
        terminal.write("Hard--[h]", 42, 5);
        terminal.write ("chosen Difficutly : "+ difficulty.nom(), 25, 7);
        terminal.write("AVAILABLE CLASS", 30, 9);
        terminal.write("WARRIOR--[w]", 20, 10);
        terminal.write("MAGE--[m]",40,10);
        terminal.write ("chosen player class : "+ playerClass.nom(), 25, 12);

        if (this.difficulty.nom() == "EasyMode"){
            playerClass.setHealingSpell(new Spell(Spells.HEALING_PULSE));
            playerClass.setAttackSpell(new Spell((Spells.NULL)));
            if (this.playerClass.nom() == "Warrior"){
                playerClass.setMANA(50);
                playerClass.setHP(100);
                playerClass.setATK(10);
                playerClass.setDEF(10);
            }
            else if (this.playerClass.nom()=="Mage"){
                playerClass.setMANA(100);
                playerClass.setHP(80);
                playerClass.setATK(3);
                playerClass.setDEF(7);
                playerClass.setAttackSpell(new Spell(Spells.ARCAN_BLAST));
            }

        }
        else if (this.difficulty.nom() == "NormalMode"){
            playerClass.setHealingSpell(new Spell(Spells.HEALING_WAVE));
            playerClass.setAttackSpell(new Spell((Spells.NULL)));
            if (this.playerClass.nom() == "Warrior"){
                playerClass.setMANA(30);
                playerClass.setHP(80);
                playerClass.setATK(8);
                playerClass.setDEF(8);
            }
            else if (this.playerClass.nom()=="Mage"){
                playerClass.setMANA(80);
                playerClass.setHP(60);
                playerClass.setATK(2);
                playerClass.setDEF(6);
                playerClass.setAttackSpell(new Spell(Spells.EBONBOLT));
            }

        }
        else if (this.difficulty.nom() == "HardMode"){
            playerClass.setHealingSpell(new Spell(Spells.SMALL_HEAL));
            playerClass.setAttackSpell(new Spell((Spells.NULL)));
            if (this.playerClass.nom() == "Warrior"){
                playerClass.setMANA(10);
                playerClass.setHP(40);
                playerClass.setATK(7);
                playerClass.setDEF(7);
            }
            else if (this.playerClass.nom()=="Mage"){
                playerClass.setMANA(50);
                playerClass.setHP(40);
                playerClass.setATK(1);
                playerClass.setDEF(5);
                playerClass.setAttackSpell(new Spell(Spells.FIREBOLT));
            }

        }
        /*
        si le joueur passe l'ecran de selection il joue par defaut un war en mode facile
         */
        else if (difficulty.nom() == " "){
            this.difficulty = Difficulty.EASY;
            this.playerClass = PlayerClass.WARRIOR;
            playerClass.setHealingSpell(new Spell(Spells.HEALING_PULSE));
            playerClass.setAttackSpell(new Spell((Spells.NULL)));
            playerClass.setMANA(50);
            playerClass.setHP(100);
            playerClass.setATK(10);
            playerClass.setDEF(10);
        }

        String stats = String.format(" %3d hp" + " %3d mana", playerClass.HP(), playerClass.MANA());
        terminal.write(stats,30, 14);
        terminal.write("spell : *" + playerClass.HealingSpellName(), 30, 17);
        if (playerClass.AttackSpellName() != "NULL")
        terminal.write("        *" + playerClass.AttackSpellName(),30,18);


        terminal.writeCenter("-- press [enter] to start --", 22);

    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ENTER: return new PlayScreen(playerClass);
        }

        switch (key.getKeyChar()){
            case 'e': this.difficulty = Difficulty.EASY; break;
            case 'n': this.difficulty = Difficulty.NORMAL; break;
            case 'h': this.difficulty = Difficulty.HARD; break;
            case 'w': this.playerClass = PlayerClass.WARRIOR; break;
            case 'm' : this.playerClass = PlayerClass.MAGE; break;
        }
        return this;
    }

}
