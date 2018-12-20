package fr.uvsq.Max.RogueLikeMaven.Creatures;
import fr.uvsq.Max.RogueLikeMaven.Item;

/** 
	* Classe PnjAi Extends : CreatureAi
	* Description : Permet de créer un pnj
	* @author B. Guillot, M. Gonthier, L. Martin
 */
public class PnjAi extends CreatureAi {
	/**
     * Constructeur de la classe PnjAi
     * @param creature  Une créature
     * @param item  Un objet que possède le pnj
     */
	public PnjAi(Creature creature, Item item) {
		super(creature);
	}

}
