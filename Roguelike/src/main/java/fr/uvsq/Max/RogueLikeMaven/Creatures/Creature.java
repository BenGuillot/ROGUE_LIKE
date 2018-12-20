package fr.uvsq.Max.RogueLikeMaven.Creatures;

import fr.uvsq.Max.RogueLikeMaven.*;
import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.World;
import java.awt.*;
import asciiPanel.AsciiPanel;

/** 
	* Classe Creature
	* Description : Ensemble des méthodes pour les différentes créatures du jeus
	* @author B. Guillot, M. Gonthier, L. Martin
 */
public class Creature {
    private World world;

    public int x;
    public int y;
    public int z;

    private char glyph;
    /**
     * Getteur de l'attribut glyph
     * @return glyph  Lettre permettant d'identifier un type de créature
     */
    public char glyph() { return glyph; }
    
    public Inventory inventory;
    /**
     * Getteur de l'attribut inventory
     * @return inventory  L'inventaire de la créature
     */
    public Inventory inventory() { return inventory; }

    private Color color;
    /**
     * Getteur de l'attribut color
     * @return color  Couleur de la lettre de la créature qui apparait dans le jeu
     */
    public Color color() { return color; }

    private CreatureAi ai;
    /**
     * Setteur de l'attribut ai
     * @param ai 
     */
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }

    private int maxHp;
    /**
     * Getteur de l'attribut maxHp
     * @return maxHp  Maximum de vie pour une créature
     */
    public int maxHp() { return maxHp; }

    private int hp;
    /**
     * Getteur de l'attribut hp
     * @return hp  Vie de la créature
     */
    public int hp() { return hp; }
    /**
     * Setteur de l'attribut hp
     * @param p_hp  Vie de la créature
     */
    public void setHP(int p_hp){ this.hp = p_hp;}

    private int maxMana;
    /**
     * Getteur de l'attribut maxMana
     * @return maxMana  Maximum de mana pour une créature
     */
    public int maxMana(){return maxMana;}

    private int mana;
    /**
     * Getteur de l'attribut mana
     * @return mana  Mana de la créature
     */
    public int mana(){return mana;}
    /**
     * Setteur de l'attribut mana
     * @param p_mana  Valeur du mana à modifier
     */
    public  void setMANA(int p_mana){ this.mana = p_mana;}

    private int attackValue;
    /**
     * Getteur de l'attribut attackValue
     * @return attackValue  Valeur d'une attaque lancée
     */
    public int attackValue() { return attackValue; }
	/**
     * Setteur de l'attribut attackValue
     * @param attackValue  Valeur d'une attaque lancée
     */
    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    private int defenseValue;
    /**
     * Getteur de l'attribut defenseValue
     * @return defenseValue  Valeur de la défense
     */
    public int defenseValue() { return defenseValue; }
	/**
     * Setteur de l'attribut defenseValue
     * @param defenseValue  Valeur de la défense
     */
    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }
11
    private Spell ATKSpell;
    /**
     * Getteur de l'attribut ATKSpell
     * @return ATKSpell 
     */
    public Spell ATKSpell(){return  ATKSpell;}

    private Spell DEFSpell;
    /**
     * Getteur de l'attribut ATKSpell
     * @return ATKSpell 
     */
    public  Spell DEFSpell(){return DEFSpell;}
	
	/**
     * Getteur de l'attribut ATKSpell
     * @param wx
     * @param wy
     * @param wz Coordonnées de la case
     * @return world.tile(wx,wy,wz)  Ce qu'il y a à cette case
     */
    public Tile tile(int wx, int wy, int wz) {
        return world.tile(wx, wy, wz);
    }

	/**
	 * Constructeur de la classe Creature
	 * @param world  Le jeu
	 * @param glyph  La lettre de la créature
	 * @param color  La couleur de la créature
	 * @param maxHp  Le maximum de Hp d'une créature
	 * @param maxMana  Le maximumum de mana d'une créature
	 * @param attack  Valeur d'une attaque
	 * @param defense  Valeur de la défense
	 */
    public Creature(World world, char glyph, Color color, int maxHp, int maxMana, int attack, int defense){
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHp = maxHp;
        this.maxMana= maxMana;
        this.hp = maxHp;
        this.mana = maxMana;
        this.attackValue = attack;
        this.defenseValue = defense;
    }
	
	/**
	 * Constructeur de la classe Creature
	 * @param world  Le jeu
	 * @param glyph  La lettre de la créature player
	 * @param color  La couleur de la créature player
	 * @param playerClass  Classe de la créature player
	 */
    public Creature(World world, char glyph, Color color, PlayerClass playerClass){
        this.world = world;
        this.glyph = glyph;
        this.color = color;
        this.maxHp = 100;
        this.maxMana = 100;
        this.hp = playerClass.HP();
        this.mana = playerClass.MANA();
        this.attackValue = playerClass.ATK();
        this.defenseValue = playerClass.DEF();
        this.ATKSpell = playerClass.AttackSpell();
        this.DEFSpell = playerClass.HealingSpell();
        this.inventory = new Inventory(20);
    }

	/**
	 * Méthode pour le mouvement d'une créature
	 * @param mx
	 * @param my
	 * @param mz
	 */
    public void moveBy(int mx, int my, int mz){
        Tile tile = world.tile(x+mx, y+my, z+mz);

        if (mz == -1){
            if (tile == Tile.STAIRS_DOWN) {
                doAction("walk up the stairs to level %d", z+mz+1);
            }
            else {
                doAction("try to go up but are stopped by the cave ceiling");
                return;
            }
        } 
        else if (mz == 1){
            if (tile == Tile.STAIRS_UP) {
                doAction("walk down the stairs to level %d", z+mz+1);
            }
            else {
                doAction("try to go down but are stopped by the cave floor");
                return;
            }
			if (mx == 0 && my == 0 && mz == 0) {
                return;
			}
		}

        Creature other = world.creature(x+mx, y+my, z+mz);

        if (other == null)
            ai.onEnter(x+mx, y+my, z+mz, tile);
        else {
        	if(other.glyph() == '!')
        		meetPnj();
        	else if(other.glyph() == '*')
        		meetSuperPnj();
        	else
        		attack(other);
        }
    }

	/**
	 * @param other  Créature rencontrée
	 */
    public void attack(Creature other){
    	int amount = Math.max(0, attackValue() - other.defenseValue());
    	amount = (int)(Math.random() * amount) + 1;
   		doAction("attack the '%s' for %d damage", other.glyph, amount);
   		other.modifyHp(-amount);
    }    
	
	/**
	 * Méthode pour parler avec un PNJ
	 */
    public void meetPnj() {
		float rand = (float)Math.random();
		if(rand < 0.25)
			doAction("must find the Chapeau to escap !");
		else if(rand < 0.50)
			doAction("must pay attention to bats !");
		else if(rand < 0.75)
			doAction("must meet *, it's important !");
		else
			doAction("speak with PNJ");
    }
    
    /**
	 * Méthode pour parler avec le superPNJ et obtenir le Chapeau
	 */
    public void meetSuperPnj() {
    	Item Chapeau = new Item('C', AsciiPanel.brightWhite, "Chapeau", 2);
    	doAction("receive the Chapeau");
    	inventory.add(Chapeau);
    }
	
	/**
	 * Méthode pour modifier le HP d'une créature
	 * et supprimer la créature si son HP tombe à 0 ou moins.
	 * @param amount
	 */
    public void modifyHp(int amount) {
        hp += amount;

        if (hp < 1) {
            doAction("die");
            world.remove(this);
        }
    }
    
    /**
	 * Méthode pour modifier le Mana d'une créature
	 * @param amount
	 */
    public void modifyMana(int amount) {
        mana += amount;
    }
	
	/**
	 * Méthode pour creuser dans les murs
	 * @param wx
	 * @param wy
	 * @param wz Coordonnées de la case.
	 */
    public void dig(int wx, int wy, int wz) {
        world.dig(wx, wy, wz);
        doAction("dig");
    }

    public void update(){
        ai.onUpdate();
    }
	
	/** 	
	 * Méthode si une case est vide
	 * @param wx
	 * @param wy
	 * @param wz Coordonnées de la case.
	 * @return True sila case est du sol et qu'il n'y pas de personnage, false sion
	 */
    public boolean canEnter(int wx, int wy, int wz) {
        return world.tile(wx, wy, wz).isGround() && world.creature(wx, wy, wz) == null;
    }

	/**
	 * @param message
	 * @param params
	 */
    public void notify(String message, Object ... params){
        ai.onNotify(String.format(message, params));
    }

	/**
	 * Méthode pour des messages
	 * @param message
	 * @param params
	 */
    public void doAction(String message, Object ... params){
        int r = 9;
        for (int ox = -r; ox < r+1; ox++){
            for (int oy = -r; oy < r+1; oy++){
                if (ox*ox + oy*oy > r*r)
                    continue;

                Creature other = world.creature(x+ox, y+oy, z);
                if (other == null)
                    continue;
                if (other == this)
                    other.notify("You " + message + ".", params);
                else {
                    other.notify(String.format("The '%s' %s.", glyph, makeSecondPerson(message)), params);
                }
            }
        }
    }
    
    /**
     * Méthode pour permettre au player de ramasser un objet
     */
    public void pickup(){
        Item item = world.item(x, y, z);
    
        if (inventory.isFull() || item == null){
            doAction("grab at the ground");
<<<<<<< HEAD
        } 
        else {
			if ((item.glyph() == 'P') && (this.mana < this.maxMana - 9)){
				this.mana = this.mana + 10;
				world.remove(x,y,z); 
			}
		else
		if ((item.glyph() == 'V') && (this.hp < this.maxHp - 9))
				{ this.hp = this.hp + 10;
					world.remove(x,y,z); }
		else
		if (item.glyph() == 'F') {this.attackValue += 5; }
		else
		if (item.glyph() == 'A') {this.attackValue += 3; }
		else
		if(item.glyph() == 'W') {this.attackValue += 2; }
		else		
            doAction("pickup a %s", item.name());
            world.remove(x, y, z);
            inventory.add(item); } }
=======
            
        } else {
            if ((item.glyph() == 'P') && (this.mana < this.maxMana - 9)) {
                this.mana = this.mana + 10;
				world.remove(x,y,z);
            }
		    else if ((item.glyph() == 'V') && (this.hp < this.maxHp - 9)) {
		            this.hp = this.hp + 10;
					world.remove(x,y,z);
		    } else if (item.glyph() == 'F') {
		        this.attackValue += 5;
		    } else if (item.glyph() == 'A') {
		        this.attackValue += 3;
		    } else if(item.glyph() == 'W') {
		        this.attackValue += 2;
		    } else
		        doAction("pickup a %s", item.name());
                world.remove(x, y, z);
                inventory.add(item);
        }
    }
     
>>>>>>> c3922f932956963e501fc01e7f4851f9179152fc

	/**
	 * Méthode pour envoyer un sort
	 * @param spell  Type de sort
	 */
    public void cast(Spell spell){
        if (mana() < spell.manaCost()){
            doAction("don't have enough MANA");
        }
        else{
            if(spell.Heal() != 0 && hp() < maxHp()){
                modifyHp(spell.Heal());
                if (hp() > maxHp()){
                   modifyHp(maxHp());
                }
                String hp = String.format("%3d",spell.Heal());
                String mana = String.format("%3d", spell.manaCost());
                doAction("GAIN" + hp + " HP " + "FOR" + mana + " MANA");
                setMANA(mana() - spell.manaCost());
            }
            else if(spell.Damage() != 0){
                int range = 5;
                for(int px = -range; px < range; px ++){
                    for (int py = -range; py < range; py ++){
                        if (px*px + py*py > range*range)
                            continue;
                        Creature other = world.creature(x+px, y+py, z);
                        if (other == null)
                            continue;
                        if (other == this)
                            continue;
                        if (other.glyph == '*')
                            continue;
                        else{
                            other.modifyHp(-spell.Damage());
                            String damage = String.format("%3d", spell.Damage());
                            //doAction("HIT "+ other.glyph +" WITH " + spell.name() + "." + damage + " DAMAGE");
                        }
                    }
                }
                String mana = String.format("%3d", spell.manaCost());
                doAction(" LOST" + mana + " MANA");
                setMANA(mana()- spell.manaCost());
            }
            else {
                doAction("already are full HP");
            }
        }
    }

	/**
	 * Méthode permettant de déposer un objet
	 * @param item  L'objet à déposer
	 */
   public void drop(Item item){	
		doAction("drop a " + item.name());
		inventory.remove(item);
		world.addAtEmptySpace(item,x, y, z);		
	}

	/**
	 * @param text
	 */
    private String makeSecondPerson(String text){
        String[] words = text.split(" ");
        words[0] = words[0] + "s";

        StringBuilder builder = new StringBuilder();
        for (String word : words){
            builder.append(" ");
            builder.append(word);
        }
        return builder.toString().trim();
    }

    /**
     * Getteur d'une créature pour une case donnée
     * @param wx
     * @param wy
     * @param wz  Coordonnées d'une case
     */
    public Creature creature(int wx, int wy, int wz) {
        return world.creature(wx, wy, wz);
    }
    
    /**
     * Permet vérifier si une potion est disponible
     * et la supprimer après la consommation
     * @return true si il y a une potion dans l'inventaire, false sinon
     */
	public boolean verification() {
		int i;
		
		for (i = 0; i < 20; i++){
			if ((inventory.get(i).glyph() == 'V') || (inventory.get(i).glyph() == 'P')) {
				inventory.remove(inventory.get(i));
				return true;
			}
		}
		doAction("don't have a potion");
		return false;
	}
}


