**************
*** README ***
**************

Installation :
	mvn install:install-file -Dfile=asciiPanel.jar -DgroupId=asciipanel -DartifactId=asciipanel -Dversion=1.0 -Dpackaging=jar

Execution :
	java -jar target/Roguelike-0.0.1-SNAPSHOT-jar-with-dependencies.jar

Pour lancer une partie :
	Appuyer sur Entrer
	Choisissez votre niveau de difficulté 
		Tappez : e pour facile, n pour normal ou h pour difficile
	Choisissez votre classe
		Tapez : w pour guerrier ou m pour mage
	Appuyer sur entrer

Pour accéder à la liste des commandes pendant la partie, appuyer sur h.
Liste des commandes :
	Flèches Haut, Bas, Gauche, Droite : se déplacer
	, : Ramasser un objet
	d : Déposer un objet
	e : Manger/Regagner HP
	v : Boire une potion de vie
	m : Boire une potion de mana
	s : pour ouvrir les pouvoirs
	o : pour sauvegarder le monde
	h : ouvrir l'aide
	< ou > : Prendre un escalier

Liste des symboles dans le jeu :
	J : le joueur
	f : un champignon
	b : une chauve-souris
	R : un rocher
	V : une potionvie
	P : une potionmana
	A : un bâton (arme)
	F : une épée (arme)
	! : PNJ
	* : Super PNJ
	< ou > : escaliers
	- : sol
	[#] : mur (creusable) 

Pour gagner la partie il faut parler au Super PNJ dont le symbole est *. Ensuite il faut remonter
tout en haut de la cave.

Description des packages :
Creature :
	Gestion des personnages et de leurs items.

Screen :
	Permet d'afficher le jeu mais aussi les écrans et les messages dans 
	le jeu comme lorsque l'on ramasse un objet.

World :
	Permet de créer le monde, les escaliers, les murs etc..


IO:
	Permet la gestion de la sauvegarde de la partie ainsi que du 
	chargement d'une partie (un jour peut-être)


Sans package :
	AppletMain et ApplicationMain qui lancent le jeu.
	Inventory et Item pour la gestion et la déclaration des objets.
	PlayerClass, Difficulty et Spells sont des énumérations qui servent 
	a la création du personnage.
