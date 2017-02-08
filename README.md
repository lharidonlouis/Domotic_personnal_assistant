# Assistant Personnel dans une maison connectée (domotique) <br> Personal assistant in a connected house (Automation)
*Dernière modification : 8/02/2017 - 11H00*
<br>
*Last update : 02/08/2017 - 11H00*

- [Français](https://github.com/lharidonlouis/Domotic_personnal_assistant#français)
- [English](https://github.com/lharidonlouis/Domotic_personnal_assistant#english)
- [Changelog](https://github.com/lharidonlouis/Domotic_personnal_assistant#changelog)

##Français

###Présentation du projet

####Contexte

Nous étions tous intéressés par ce projet car il est nouveau et innovant. En effet, il évoque le domaine de la domotique, un sujet intéressant et suffisamment ouvert. Nous avions déjà un certain nombre d’idées et d’ambitions ce qui nous a poussé à placer ce sujet en premier choix. 

###Le projet

Ce projet consiste à créer un assistant personnel dans une maison entièrement connectée (domotique) avec son utilisateur. En effet ce dernier communique avec elle par le biais d'interactions (grâce à une interface utilisateur/assistant). Cet assistant est capable de proposer des actions comme par exemple passer l’aspirateur, éteindre des lampes ou la télé. Etant connecté à l’ensemble de la maison, il permet de reporter l’état des objets, tout problème ou information de ce dernier afin d’en informer son utilisateur. L’assistant a donc pour but d’améliorer le quotidien, notamment en proposant des actions comme souhaiter un anniversaire avec un message prédéfini, ayant auparavant vérifié le calendrier. Même des petites actions comme les informations météorologiques ou les réunions à venir parviennent à l’utilisateur dès son réveil afin d’organiser au mieux sa journée et ainsi de gagner en temps et en l’efficacité. 

L’assistant personnel est donc un véritable outil, très prometteur et avec un nombre indéfini d’actions possibles.


####L’organisation	

L’équipe est composée de 3 personnes : Louis (CMI), Valentin (MI) et Julien (MI). 

Calendrier du projet :

- [ ] 6 Mars 2017 : présentation brève de notre projet (en 180 secondes)
- [ ] 27 Mars 2017: pré-soutenance (objectif : projet fini à 60-70%)
- [ ] 20 Mai 2017: rendu final du projet (projet + rapport + diaporama)
- [ ] 22-23 Mai 2017: soutenance orale du projet 

####Environnement de travail

Pour le projet nous utiliserons différents logiciels :

- Logiciel d’architecture pour la modélisation de la maison
- Eclipse pour le développement
- Traitement de texte et Présentateur pour les différentes présentations et rapport
- Dropbox pour le travail collaboratif
- Git pour le développement collaboratif

###Livraisons attendues
Pour ce projet, les documents suivants seront fournis :

- Fichier Exécutable 
- Code source
- Manuel d’installation du logiciel
	- Dans ce manuel nous détaillerons toutes les étapes nécessaires à l’installation correcte du programme.
- Manuel d’utilisation du logiciel
	- Dans ce manuel nous listerons 
		- Les fonctionnalités du logiciel
		- Comment les utiliser
		- Les options de personnalisation

###Objectif du projet et spécifications

####Fonctionnalités du programme

Notre programme consiste donc en la création d’un assistant personnel permettant au propriétaire de la maison de gérer ses diverses interactions. Pour cela nous auront besoin de diverses fonctionnalités.

- Simulation d’un environnement d’habitation
	- Création d’une liste d’objets connectés
		- Réfrigérateur
			- Listage de la quantité d’aliments disponibles
				- En acheter si nécessaire
			- Alerte porte mal fermée
			- Alerte problème de température 
		- Téléviseur
			- Automatisation
			- Connection au canapé
				- Extinction de l’appareil ou mise en pause automatisée
		- Aspirateur
			- Automatisation du lancement
			- Si évènement ou détection de saleté, proposer nettoyage
		- Radiateur Salle de bain
			- S’allumer automatiquement en fonction de l’heure du lever
		- Lumière
			- Automatisation
			- Ambiance variée
				- Aspect Social
				- Allumage de la télévision
		- Lit
			- Détection de l’endormissement et du réveil
				- Briefing matinal
				- Gérer l’allumage d’appareils
		- Canapé
			- Détection de la présence de l’utilisateur
			- Détection de mouvement et d’endormissement
				- Recommandations de santé
				- Extinction du téléviseur
		- Voiture (optionnel)
			- Démarrage automatique de la voiture
			- Automatisation du GPS
		- Porte (optionnel)
			- Détection des visiteurs
	- Possibilité pour l’utilisateur du logiciel (optionnel)
		- De créer un objet connecté
			- De définir ses actions
			- De définir ses relations avec l’assistant
- Simulation d’un utilisateur
	- Simulation de tâches quotidiennes
		- Simulation d’un emploi du temps
		- Simulation d’aspects sociaux
		- Simulations d’interactions avec l’environnement d’habitation
		- Simulations d’interactions avec l’assistant personnel
- Création d’un assistant personnel
	- Simulation d’une interface utilisateur / assistant
	- Centralisation des informations des appareils connectés
		- Contrôle des appareils
		- Récupération des informations des appareils
		- Transmission des informations des appareils à l’utilisateur
		- Automatisation, si prévue, des appareils, basée sur le comportement de l’utilisateur
	- Centralisation des informations de l’utilisateur
		- Gestion des aspects sociaux
		- Gestion de l’emploi du temps
		- Gestion des commandes de l’utilisateur
		- Gestion de la météo (optionnel)

####Interface

L’interface de notre logiciel doit comprendre un certains nombres de fonctionnalités afin de permettre la correcte utilisation des fonctionnalités vues précédemment.

- Affichage et simulation d’un environnement d’habitation
	- Simulation sur cet environnement d’objets connectés
		- Positionnement des objets
		- Signification de l’état de l’appareil
			- L’appareil est opérationnel
			- L’appareil est utilisé par le propriétaire
			- L’assistant communique à l’utilisateur à propos de l’appareil
- Affichage et simulation d’un dashboard
	- Simulation de l’interaction utilisateur / assistant
		- Reconnaissance vocale (optionnel)
		- Modélisation vocale de l’assistant (optionnel)
	- Gestion des actions de l’utilisateur
	- Possibilité d’ajouter des objets connectés

##English


###Project presentation

####Context

We were all interested about this project because it's new and innovating. Indeed, it is about the automation domain, a very interesting open subject. We all had a certain number of ideas and hopes  for this project, which pushed us to work put in in first choice.

###The project

This project is about creating a personal assistant in an entirely connected house with its user. The user will communicate with her via interactions (with a user/assistant interface). This assistant is able to propose actions such as clean the house, turn off the light or the TV. Being connected with the entire house, it can report object's status, every problem or information about this last to inform its user. The assistant has for goal to improve the life, by proposing actions such as wish a happy birthday with personalized messages, checking the calendar. Even small actions such as meteorologic datas, or today planning are coming to the user at his wake up to allow him to organize his day the best way possible and to make him win in efficiency.

The personal assistant is a really too, very promising and undefined number of possible actions.

####The organisation

We are 3 members in the team : Louis (CMI), Valentin (MI) et Julien (MI). 

Project calendar :

- [ ] 2017, March the 6th : brief presentation of our project (in 180 seconds)
- [ ] 2017, March the 27th : pre-oral (objective : Project finished about 60-70%)
- [ ] 2017, May the 20th : final return of the project (project + report + slides)
- [ ] 2017, May the 23rd : Oral

####Environnement de travail

For this project we used different softwares:

- Architecture modeling for the house plan
- Eclipse for development 
- Word processing program and Slide Show Program for orals and report
- Dropbox for collaborative work
- Git for collaborative devloppment 

###Waited delivery
For this project : the following documents are waited :

- Executable file
- Source code
- Installation manuel of the software
	- In this manuel we will describe all the necessaries steps to correctly install this software
- User manuel of the software
	- In this manuel we will list 
		- The software's functionalities
		- How to use them
		- The personalization options

###Project objectives and specifications

####Software's functionalities

Our project consist in an personal assistant creation allowing the house's owner to handle diverses interactions. For this, we will need some functionalities:

- House simulation
	- Creation of connected objects
		- Fridge
			- Listing of available food  
				- Buying if necessary
			- Open door alert
			- Temperature problem alert
		- Television
			- Automation
			- Connection to Sofa
				- Extinction of the TV or automated pausing
		- Vacuum
			- Automation of launching 
			- If dirt detection, propose a cleaning
		- Bathroom radiator
			- Automation of launching based on wake up hour
		- Lights
			- Automations
			- Varied athmosphere
				- Social aspect
				- TV ignition
		- Bed
			- Falling asleep and waking up detection
				- Morning briefing
				- Handle devices launching
		- Sofa
			- User presence detection 
			- Movement and falling asleep detection
				- Health recommendations
				- TV extinction
		- Car (optional)
			- Automation of launching
			- Automation of GPS
		- Door (optional)
			- Visitor detection
	- Possibility for the user to (optional)
		- Create a new connected device
			- Define its actions
			- Define its relations with the assistant
- User simulation
	- Daily task simulation
		- Schedule simulation
		- Social aspects simulation
		- Interaction with the house simulations
		- Interaction with the assistant simulation
- Creation of a personal assistant
	- User/assistant interface simulation
	- Connected devices' informations centralization
		- Device's control
		- Devices' information recuperation
		- Devices' information to User transmission
		- Automation, if handled, of the devices, based on the user behavior
	- User's information centralization
		- Socials aspects management 
		- Schedule management
		- User's command management
		- Weather management (optional)

####Interface

Our software interface has to handle a certain number of functionalities to allow the good working of the previous functionalities.

- Displaying and simulation of a house
	- Connected devices' environment simulation
		- Object positionnant
		- Object's status signification
			- The device if operational
			- The device is used by the owner
			- The assistant communicate to the user about the device
- Displaying and simulation of a  dashboard
	- User/assistant interaction's simulation 
		- Vocal recognition (optional)
		- Assistant vocal modelling (optional)
	- User's action management
	- Adding new connected objects possibility

##Changelog
- 23/01/2017 - 11h30 : GitHub creation
- 23/01/2017 - 12h00 : Eclipse project creation
- 23/01/2017 - 21h30 : adding of README.txt
- 25/01/17 - 11h00 : adding julien
- 08/02/17 - 11h00 : Creating datas objects and classes
