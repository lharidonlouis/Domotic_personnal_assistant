package gui2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import objects.Home;
import objects.User;

/**
 * Jpanel du Chat
 */
public class Chat extends JPanel implements KeyListener {
	/**
	 * Instance de User
	 */
	User usr = User.getInstance();
	/**
	 * Instance de Hime
	 */
	Home hme = Home.getInstance();
	/**
	 * JPanel de Chat
	 */
	JPanel chat = new JPanel();
	/**
	 * JText Area pour le Dialog
	 */
	JTextArea dialog = new JTextArea(20, 30);
	/**
	 * JText Area pour l'input
	 */
	JTextArea input = new JTextArea(1, 2);
	/**
	 * JScrollPane pour composer le chat
	 */
	JScrollPane scroll = new JScrollPane(dialog, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	/**
	 * JPanel pour le scroll
	 */
	JPanel scrolljp = new JPanel();

	/**
	 * Tableau des dialogues
	 */
	String[][][] chatBot2 = {

			{ { "allume", "chauffe", "réchauffe" }, { "salle de bain", "radiateur", "chauffage" },
					{ "La température est idéale!", "C'est chauffé", "C'est allumé", "J'ai lancé le radiateur" },
					{ "set radiator on", "radiator" }, },
			{ { "éteindre", "éteins", "eteindre", "eteins", "arrêter", "coupe", "arretes" },
					{ "salle de bain", "radiateur", "chauffage" },
					{ "C'est noté!", "J'ai arrêté le radiateur", "C'est éteins", "A votre guise" },
					{ "set radiator off", "radiator" }, },
			{ { "frigo", "manger", "refrigerateur", "cuisiner", "prepares" }, { "ouvrir", "nourriture", "manger" },
					{ "je fais ça!", "j'ai pris de la nouriture", "Bon appétit Bernard", "Attention à votre ligne..." },
					{ "take food", "fridge" }, },
			{ { "recharger", "acheter", "courses", "charger", "remplir" },
					{ "frigo", "nourriture", "refrigerateur", "faire", "fais" },
					{ "je fais ça!", "Je remplis votre frigo", "C'est commandé", "Vous devriez acheter autre chose!" },
					{ "faire les courses", "fridge" }, },
			{ { "aller", "avoir", "j'ai", "suis", "bonne", "dors", "vais" }, { "dormir", "coucher", "nuit", "bien" },
					{ "Bonne nuit Bernard, à demain!", "Dormez bien", "Faites de beaux rêves" }, { "sleep", "bed" }, },
			{ { "salut", "bonjour", "bien", "comment" }, { "dormir", "coucher", "nuit", "bien", "dormi" },
					{ "Bonjour, Bien dormi?", "Avez-vous passé une bonne nuit Bernard?", "Bien reposé?" },
					{ "wake up", "bed" }, },
			{ { "nettoies", "nettois", "nettoyer", "passer" }, { "maison", "aspirateur", "l'aspirateur" },
					{ "Je lance le nettoyage", "C'est comme si c'était fait",
							"L'aspirateur est en route attention à vous!" },
					{ "clean the house", "vacum" }, },
			{ { "café", "déca", "cafetière" }, { "préparer", "faire", "allumer", "fais", "allumes", "prépares" },
					{ "je fais ça!", "Je prépare ça immédiatement", "Votre café est prêt" },
					{ "Make cofee", "cofeemaker" } },
			{ { "café", "déca", "cafetière", "machine" }, { "recharge", "remet", "recharger", "remettre", "remplis" },
					{ "je fais ça!", "J'ai remis du café", "J'ai rechargé la machine Bernard" },
					{ "fill cofee maker", "cofeemaker" } },
			{ { "TV", "télé", "télévision", "série", "film" }, { "allumes", "allumer", "regarder" },
					{ "Regardons la télévision!", "C'est allumé", "Regardons ça" }, { "watch tv", "TV" } },
			{ { "TV", "télé", "télévision", "série", "film" },
					{ "éteindre", "éteins", "eteindre", "eteins", "arrêter" },
					{ "J'ai arrêté télévision!", "C'est éteind", "Eteignons ça" }, { "turn tv off", "TV" } },
			// BASIC
			{ { "bonjour", "salut", "coucou" }, { "" },
					{ "Bonjour je suis Home, votre assistant personnel", "Comment allez vous?", "Salut Bernard" },
					{ "none" } },
			{ { "oui", "yep", "affirmatif", "Bien" }, { "", "et toi?", "et vous?" },
					{ "Ravi de l'apprendre !", "Excellente nouvelle", "Très bien" }, { "none" } },
			{ { "non", "moyen", "mouais", "mouai", "pas" }, { "" },
					{ "Je suis désolé de l'apprendre", "Désolé Bernard" }, { "none" } },
			{ { "Qui" }, { "créateur", "createur" },
					{ "Et bien mes créateurs sont de talenteux futurs ingénieurs en informatique, le premier Julien est celui qui a fait la jolie "
							+ "application que je suis. En effet grâce à mon design amélioré, et très avantageux, on ne peut pas dire que "
							+ "je ne palise pas à tous les autres porgralles de GLP (surtour Ubrain...)\n"
							+ "Le deuxième c'est Valetin, celui qui m'a donné la parole et qui me permet aujourd'hui d'écouter toutes vos demandes"
							+ ", même les plus folles... Grâce à lui je suis heurex de pouvoir vous répondre\n"
							+ "Mon dernier est Louis, c'est lui qui m'a donné mon intelligence, ma connaisance, mon savoir, mon humour, mon savoir faire,"
							+ "mon efficacité et encore plus important, la vie... Grâce à lui je suis qui je suis et pas "
							+ "seulement un beau programme aux lignes séductrices mais pas bien intelligentes...\n"
							+ "Voila qui sont mes créateurs, mes dieux, mes parents, la sauce de mes kebabs..." },
					{ "none" } },
			{ { "blague", "rire" }, { "" },
					{ "Il y a 10 types de gens dans le monde. \n Ceux qui parlent binaire, et les autres.",
							"Comment un développeur tente-t-il de réparer sa voiture lorsqu'elle a un problème ? \nIl sort de la voiture, ferme toutes les fenêtres, retourne dans la voiture, et essaie de redémarrer.",
							"Il y a deux sortes de gens : ceux qui comprennent la notion de récursivité et ceux qui ne comprennent pas qu’il y a deux sortes de gens : ceux qui comprennent la notion de récursivité et ceux qui ne comprennent pas qu’il y a deux "
									+ "sortes de gens : ceux qui comprennent la notion de récursivité et ceux qui ne comprennent pas qu’il y a deux sortes de gens...",
							"C'est l'histoire d'un administrateur qui configure ses variables d'environnement, et là......... PATH le chemin !",
							"Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?"
									+ "\n Vous connaissez la blague du mec qui a oublié d'augmenter la variable dans sa boucle while ?",
							"Comment reconnaître un programmeur avec un verre vide ? \n - Le pessimiste dit que le verre est à moitié vide \n - L'optimiste dit que le verre est à moitié plein \n- Le programmeur dit que le verre est deux fois trop grand",
							"Combien faut-il d'ingénieurs pour changer une ampoule chez Microsoft ? \n Aucun, tout le monde reste dans le noir et Billou décide que c'est le nouveau standard. ",
							"C'est deux informaticiens qui discutent \n -Fécilitaction pour bon bébé c'est un garçon ou une fille? \n -Oui." },
					{ "none" } },
			{ { "Siri", "Google", "Cortana" }, { "", "Now" }, { "Désolé mais je ne connais pas ces prototypes" },
					{ "none" } },
			{ { "CIA" }, { "", "Now" },
					{ "can neither confirm nor deny the existence of the information requested but, hypothetically, if such data were to exist, the subject matter would be classified, and could not be disclosed.",
							"...", "Si je répondais je devrais vous tuer", "*S'enfuit*" },
					{ "none" } },
			{ { "Spoil" }, { "" },
					{ "Glenn est mort", "John Snow est mort", "En fait depuis le début, c'était un rêve",
							"Bruce Willis est un fantome", "Il est son père" },
					{ "none" } },
			{ { "merci", "remercie", "excellent" }, { "" },
					{ "Je vous en prie Bernard", "Ce n'est rien", "C'est mon travail" }, { "none" } },
			// Default
			{ { "Désolé je ne comprends pas", "Pouvez vous mieux vous exprimer ? ", "Euh ??",
					"(Désolé je ne suis pas disponible)" } } };

	/**
	 * Constructeru du chat
	 */
	public Chat() {
		dialog.setEditable(false);
		dialog.setLineWrap(true);
		dialog.setWrapStyleWord(true);
		input.addKeyListener(this);
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		input.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		setLayout(new GridLayout(2, 1));
		scrolljp.add(scroll);
		add(scrolljp);

		dialog.setBackground(Color.decode("#4B77BE"));
		dialog.setForeground(Color.WHITE);

		input.setBackground(Color.decode("#4B77BE"));
		input.setForeground(Color.WHITE);
		add(input);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			input.setEditable(false);
			// -----grab quote-----------
			String quote = input.getText();
			input.setText("");
			addText("Me :\t" + quote);
			quote.trim();

			while (quote.charAt(quote.length() - 1) == '!' || quote.charAt(quote.length() - 1) == '.'
					|| quote.charAt(quote.length() - 1) == '?') {
				quote = quote.substring(0, quote.length() - 1);
			}
			quote.trim();
			byte response = 0;
			/*
			 * 0:we're searching through chatBot[][] for matches 1:we didn't
			 * find anything 2:we did find something
			 */
			// -----check for matches----
			int j = 0;// which group we're checking
			while (response == 0) {
				if (inArray(quote, chatBot2[j][0]) && (inArray(quote, chatBot2[j][1]))) {
					response = 2;
					int r = (int) Math.floor(Math.random() * chatBot2[(j)][2].length);
					addText("\nHome : \t" + chatBot2[j][2][r]);

					if (!(chatBot2[j][3][0].equals("none"))) {
						hme.act(chatBot2[j][3][0], chatBot2[j][3][1]);
					} else {

					}
				}
				j++;
				if (j == chatBot2.length - 1 && response == 0) {
					response = 1;
				}
			}
			// -----default--------------
			if (response == 1) {
				int r = (int) Math.floor(Math.random() * chatBot2[chatBot2.length - 1][0].length);
				addText("\nHome : \t" + chatBot2[chatBot2.length - 1][0][r]);
			}
			addText("\n-------------------------");
			addText("\n");
			// updateMap();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			input.setEditable(true);
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Ajout du texte au dialogue
	 * @param str
	 * 	texte à ajouter au dialogue
	 */
	public void addText(String str) {
		dialog.setText(dialog.getText() + str);
	}

	/**
	 * Véfification de la présence d'un String dans un tableau de Strings
	 * @param in
	 * 	String dont la présence est à vérifier
	 * @param str
	 * 	tableau de String pour vérifier la présence
	 * @return vrai si in est présent dans str, faux sinon
	 */
	public boolean inArray(String in, String[] str) {
		boolean match = false;
		for (int i = 0; i < str.length; i++) {
			// if(str[i].equals(in)){
			if ((in.toLowerCase()).contains(str[i].toLowerCase())) {
				match = true;
			}
		}
		return match;
	}
}
