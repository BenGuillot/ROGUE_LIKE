package fr.uvsq.Max.RogueLikeMaven;


/*
Enumeration permettant la creation du personnage
 */
public enum PlayerClass {
    NULL( " ", 0, 0, ' '),
    WARRIOR("Warrior", 0, 0, 'w'),
    MAGE("Mage",0,0,'m');


    private String nom;
    public String nom(){return nom;}

    private char glyph;
    public char glyph(){return glyph;}

    private int HP;
    public int HP(){return HP;}

    private int MANA;
    public int MANA(){return MANA;}

    private int ATK;
    public int ATK(){return ATK;}

    private int DEF;
    public int DEF(){return DEF;}

    private Spell AttackSpell;
    public Spell AttackSpell(){return AttackSpell;}
    public void setAttackSpell(Spell attackSpell) {
        AttackSpell = attackSpell;
    }
    public String AttackSpellName(){return AttackSpell.name();}

    private Spell HealingSpell;
    public Spell HealingSpell(){return HealingSpell;}
    public void setHealingSpell(Spell healingSpell) {
        HealingSpell = healingSpell;
    }
    public String HealingSpellName(){return HealingSpell.name();}

    public void setATK(int ATK) {
        this.ATK = ATK;
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

    PlayerClass(String nom, int hp, int mana, char glyph) {
        this.nom = nom;
        this.HP = hp;
        this.MANA = mana;
        this.glyph = glyph;
    }
}
