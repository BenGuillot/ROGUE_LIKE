package fr.uvsq.Max.RogueLikeMaven;

public enum Spells {
    HEALING_PULSE("Healing pulse", 5, 'H'),
    ARCAN_BLAST("Arcan Blast", 10,'A'),
    HEALING_WAVE("Healing wave", 5, 'H'),
    EBONBOLT("Ebonbolt", 6,'A'),
    SMALL_HEAL("Small heal", 3,'H'),
    FIREBOLT("FireBolt", 5, 'A');

    private String nom;
    public String nom(){ return nom;}

    private int manaCost;
    public int manaCost(){return manaCost;}

    private char SpellGlyph;
    public char SpellGlyph(){return SpellGlyph;}

    Spells(String nom, int manaCost, char SpellGlyph){
        this.nom = nom;
        this.manaCost = manaCost;
        this.SpellGlyph = SpellGlyph;
    }
}
