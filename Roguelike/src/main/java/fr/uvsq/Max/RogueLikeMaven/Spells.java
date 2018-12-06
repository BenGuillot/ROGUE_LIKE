package fr.uvsq.Max.RogueLikeMaven;

public enum Spells {
    HEALING_PULSE("Healing pulse", 5, 'h',15,0),
    ARCAN_BLAST("Arcan Blast", 10,'a',0,20),
    HEALING_WAVE("Healing wave", 5, 'h',10,0),
    EBONBOLT("Ebonbolt", 6,'a',0,20),
    SMALL_HEAL("Small heal", 3,'h',5,0),
    FIREBOLT("FireBolt", 5, 'a',0,15),
    NULL("NULL",0,'?',0,0);

    private String nom;
    public String nom(){ return nom;}

    private int manaCost;
    public int manaCost(){return manaCost;}

    private char SpellGlyph;
    public char SpellGlyph(){return SpellGlyph;}

    private int HealingFactor;
    public int HealingFactor(){return HealingFactor;}

    private int DamageDone;
    public int DamageDone(){return DamageDone;}

    Spells(String nom, int manaCost, char SpellGlyph, int HealingFactor, int DamageDone){
        this.nom = nom;
        this.manaCost = manaCost;
        this.SpellGlyph = SpellGlyph;
        this.HealingFactor = HealingFactor;
        this.DamageDone = DamageDone;
    }
}
