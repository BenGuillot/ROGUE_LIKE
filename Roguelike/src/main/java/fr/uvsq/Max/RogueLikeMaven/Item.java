package fr.uvsq.Max.RogueLikeMaven;

import java.awt.Color;

public class Item {

    private char glyph;
    public char glyph() { return glyph; }

    private Color color;
    public Color color() { return color; }

    private String name;
    public String name() { return name; }
   
private int attackValue;
	public int attackValue() { return attackValue; }
	public void modifyAttackValue(int amount) { attackValue += amount; }
    public Item(char glyph, Color color, String name, int attackValue){
        this.glyph = glyph;
        this.color = color;
        this.name = name;
        this.attackValue = attackValue;
    }
}
