package fr.uvsq.Max.RogueLikeMaven.Creatures;

/** 
	* Classe FungusAi Extends : CreatureAi
	* Description : Permet de gérer la prolifération des champigions
	* @author B. Guillot, M. Gonthier, L. Martin
 */
public class FungusAi extends CreatureAi {
    private CreatureFactory factory;
    private int spreadcount;
    public int spreadcount() { return spreadcount; }

	/**
	 * Constructeur de la classe FungusAi
	 * @param creature  Créature
	 * @param factory  
	 */
    public FungusAi(Creature creature, CreatureFactory factory) {
        super(creature);
        this.factory = factory;
    }

	/**
	 * Méthode permettant de mettre à jour les déplacements des chauves souris
	 */
    public void onUpdate(){
        if (spreadcount < 5 && Math.random() < 0.01)
            spread();
    }

	/**
	 * Méthode pour créer un nouvel enfant
	 */
    public void spread(){
        int x = creature.x + (int)(Math.random() * 11) - 5;
        int y = creature.y + (int)(Math.random() * 11) - 5;

        if (!creature.canEnter(x, y, creature.z))
            return;
        creature.doAction("spawn a child");
        Creature child = factory.newFungus(creature.z);
        child.x = x;
        child.y = y;
        child.z = creature.z;
        spreadcount++;
    }
}
