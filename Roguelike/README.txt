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
	b : Boire/Regagner MANA
	< ou > : Prendre un escalier
