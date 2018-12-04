package fr.uvsq.Max.RogueLikeMaven;

public enum PlayerClass {
    NULL( " "),
    WARRIOR("Warrior"),
    MAGE("Mage");


    private String nom;
    public String nom(){return nom;}

    PlayerClass(String nom) {
        this.nom = nom;
    }
}
