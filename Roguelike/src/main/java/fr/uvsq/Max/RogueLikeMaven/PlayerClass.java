package fr.uvsq.Max.RogueLikeMaven;

public enum PlayerClass {
    NULL( " "),
    WARLORD("Warlord"),
    ARCHMAGE("Archmage"),
    WARRIOR("WARRIOR"),
    MAGE("Mage"),
    MERCENARY("Mercenary"),
    NOVICE("Novice");

    private String nom;
    public String nom(){return nom;}

    PlayerClass(String nom) {
        this.nom = nom;
    }
}
