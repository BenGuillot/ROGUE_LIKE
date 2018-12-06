package fr.uvsq.Max.RogueLikeMaven;

public enum Spells {
    HEALING_PULSE("Healing pulse", 5),
    ARCAN_BLAST("Arcan Blast", 10),
    HEALING_WAVE("Healing wave", 5),
    EBONBOLT("Ebonbolt", 6),
    SMALL_HEAL("Small heal", 3),
    FIREBOLT("FireBolt", 5);

    private String nom;
    public String nom(){ return nom;}

    private int manaCost;
    public int manaCost(){return manaCost;}

    Spells(String nom, int manaCost){
        this.nom = nom;
        this.manaCost = manaCost;
    }
}
