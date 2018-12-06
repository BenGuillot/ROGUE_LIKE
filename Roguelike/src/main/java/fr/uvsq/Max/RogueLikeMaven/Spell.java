package fr.uvsq.Max.RogueLikeMaven;

public class Spell {

    private String name;
    public String name(){return name;}

    private int manaCost;
    public int manaCost(){return manaCost;}

    private int Heal;
    public int Heal(){return Heal;}

    private int Damage;
    public int Damage(){return Damage;}

    private char glyph;
    public char glyph(){return  glyph;}

    public Spell(Spells spell){
        this.name = spell.name();
        this.manaCost = spell.manaCost();
        this.Heal = spell.HealingFactor();
        this.Damage = spell.DamageDone();
        this.glyph = spell.SpellGlyph();
    }
}
