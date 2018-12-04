package fr.uvsq.Max.RogueLikeMaven;

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
