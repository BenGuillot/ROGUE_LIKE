package fr.uvsq.Max.RogueLikeMaven.Creatures;
import  fr.uvsq.Max.RogueLikeMaven.Item;
import fr.uvsq.Max.RogueLikeMaven.Inventory;

public class PnjAi extends CreatureAi {

	public PnjAi(Creature creature, Item item) {
		super(creature);
		creature.inventory.add(item);
	}
	
	
	///// Override la méthode inventory
	///// Pour mettre une clé ou un truc comme ça dans l'inventaire
	///// Regarder PlayerClass pour ajuster la classe du PNJ dans CreatureFactory
}
