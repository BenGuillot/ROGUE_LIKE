package fr.uvsq.Max.RogueLikeMaven;

import java.util.ArrayList;
import java.util.List;

/*
Enumeration permettant la creation du personnage
 */
public enum PlayerClass {
    NULL( " ", 0, 0),
    WARRIOR("Warrior", 0, 0),
    MAGE("Mage",0,0);


    private String nom;
    public String nom(){return nom;}

    private int HP;
    public int HP(){return HP;}

    private int MANA;
    public int MANA(){return MANA;}

    private int ATK;
    public int ATK(){return ATK;}

    private int DEF;
    public int DEF(){return DEF;}

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public List<Spells> AvailableSpells = new ArrayList<Spells>();
    public List<Spells> AvailableSpells(){return AvailableSpells;}

    public void addSpell (Spells spell){
        AvailableSpells.add(spell);
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setMANA(int MANA) {
        this.MANA = MANA;
    }

    PlayerClass(String nom, int hp, int mana) {
        this.nom = nom;
        this.HP = hp;
        this.MANA = mana;
    }
}
