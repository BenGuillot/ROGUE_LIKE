package fr.uvsq.Max.RogueLikeMaven;

public enum Difficulty {
    NULL( " "),
    EASY("EasyMode"),
    NORMAL("NormalMode"),
    HARD("HardMode");

    private String nom;
    public String nom(){return nom;}

    Difficulty(String nom) {
        this.nom = nom;
    }
}
