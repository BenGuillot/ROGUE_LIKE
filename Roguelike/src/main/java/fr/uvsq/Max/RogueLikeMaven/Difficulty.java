package fr.uvsq.Max.RogueLikeMaven;

public enum Difficulty {
    NULL( " ", ' '),
    EASY("EasyMode", 'e'),
    NORMAL("NormalMode",'n'),
    HARD("HardMode",'d');

    private String nom;
    public String nom(){return nom;}

    private char glyph;
    public char glyph(){return glyph;}

    Difficulty(String nom, char glyph) {
        this.nom = nom;
        this.glyph = glyph;
    }
}
