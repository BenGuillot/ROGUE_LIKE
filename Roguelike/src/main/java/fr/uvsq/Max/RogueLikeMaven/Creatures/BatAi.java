package fr.uvsq.Max.RogueLikeMaven.Creatures;

import fr.uvsq.Max.RogueLikeMaven.World.Tile;
import fr.uvsq.Max.RogueLikeMaven.World.Point;

/** 
	* Classe BatAi Extends : CreatureAi
	* Description : Permet de gérer les déplacements des chauves-souris
	* @author B. Guillot, M. Gonthier, L. Martin
 */
public class BatAi extends CreatureAi {
	/**
		* Constructeur de la classe
		* @param creature
	*/
	public BatAi(Creature creature) {
		super(creature);
	}
	
	/**
		* Méthode permettant de mettre à jour les déplacements des chauves souris
	 */
	public void onUpdate() {
		wander();
		wander();
	}
}
