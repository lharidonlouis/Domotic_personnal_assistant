package gui2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import counters.CyclicCounter;
import map.MapInit;
import objects.Clock;
import objects.DbSetter;
import objects.Obj;
import objects.User;


public class Graphic extends MapInit implements DbSetter , ActionListener, Runnable, KeyListener{
	User usr = User.getInstance();;
	public Map map;
	private Clock clock;

	JFrame window = new JFrame() ;
	JPanel action = new JPanel() ;
	JPanel home = new JPanel() ;
	JPanel clk = new JPanel();
	JPanel chat = new JPanel();
	JPanel addremove = new JPanel() ;
	JPanel dashboard = new JPanel() ;
	JPanel panGrid = new JPanel( new GridLayout(50,50)) ;

	
	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(20,30);	
	JTextArea input=new JTextArea(1,2);
	JScrollPane scroll=new JScrollPane(dialog,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel scrolljp = new JPanel();	
	

	private static final int CHRONO_SPEED = 100;

	private static final long serialVersionUID = 1L;


	private JButton startButton = new JButton(" Start ");
	private JButton clearButton = new JButton(" Clear ");

	private JLabel weekLabel = new JLabel("week:");
	private JLabel dayLabel = new JLabel("Day:");
	private JLabel hourLabel = new JLabel("Hour:");
	private JLabel minuteLabel = new JLabel("Minute:");
	private boolean stop = true;
	private Graphic instance = this;


	private JLabel weekValue = new JLabel("");
	private JLabel dayValue = new JLabel("");
	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");

	private JPanel control = new JPanel();
	private JPanel controlButton = new JPanel();
	
	
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JTabbedPane tabs = new JTabbedPane(SwingConstants.TOP);
	
	String[] of = {" "};
	JComboBox state = new JComboBox();
	JComboBox  piece = new JComboBox();
	JButton validate = new JButton(" Validate ");
	
	private Color border;

	public  void window(){
		 		
		
		split.setDividerLocation(800);
		
		window.setTitle("Hello, My Name is Home") ;
		window.setSize(1200,780);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// panels size
		
		panGrid.setSize(800, 760);
		dashboard.setSize(400, 760);
		
		// background color

		panGrid.setBackground(Color.decode("#4B77BE"));
		dashboard.setBackground(Color.decode("#4B77BE"));
		clk.setBackground(Color.decode("#4B77BE"));
		action.setBackground(Color.decode("#4B77BE"));
		addremove.setBackground(Color.decode("#4B77BE"));
		home.setBackground(Color.decode("#4B77BE"));
		
		border = Color.decode("#4B77BE");
		
		
		
		// Create grid display
		initMap();
		
		piece = new JComboBox(map.keySet().toArray(new String[map.keySet().size()]));
		HashMap<String, String> acts = ((Obj) map.get(piece.getSelectedItem())).getActMap();
		state = new JComboBox(acts.keySet().toArray(new String[acts.keySet().size()]));

		piece.addActionListener(new ItemAction()) ;
		validate.addActionListener(new ItemAction2());
		
		action.add(state);
		action.add(piece);
		action.add(validate);
		
		// create tabs
		 
		tabs.addTab("Home.", home);
		tabs.addTab("Add/Remove",addremove);  
		tabs.addTab("Actions", action);
		tabs.addTab("Clock", clk);
		tabs.addChangeListener(new ChangePanListener());

		tabs.setOpaque(false);
		   
		dashboard.add(tabs);	
		
		chat = Chat();
		home.add(chat);
		chat.setBackground(Color.decode("#4B77BE"));
		
		
		clk.add(init());
		
		//window add
		window.getContentPane().add(dashboard);    

		split.add(panGrid) ;
		split.add(dashboard);
		
		window.add(split) ;
		window.setVisible(true);
	}
	
	class ChangePanListener implements ChangeListener{
		@Override
		public void stateChanged(ChangeEvent e) {
			if (tabs.getSelectedIndex() == 1){
				border = Color.white;
				updateMap();
			}
			else{
				border =Color.decode("#4B77BE");
				updateMap();
			}
		}
	}
	
	public void initMap(){
		panGrid.removeAll();
		initMap(map) ;
		initQt(map);
		dispMap();
	}
	
	public void updateMap(){
		panGrid.removeAll();
		updateMapVal(map);
		dispMap();
		SwingUtilities.updateComponentTreeUI(window);
	}
		
	public void dispMap(){
		Font tempfont = new Font("Helvetica", Font.PLAIN, 10);
		for (int index1=0 ; index1<50; index1++ ){
			for (int index2=0 ; index2<50; index2++ ){
				if (tab[index1][index2] == 1) {
					JPanel wall = new JPanel() ;
					wall.setBackground(Color.white);
					panGrid.add(wall);
				}
				else if (tab[index1][index2] == 2) {
					JPanel wall = new JPanel() ;
					wall.setBackground(Color.green);
					JLabel temp = new JLabel(tab2[index1][index2]);
					temp.setFont(tempfont);
					wall.add(temp);
					panGrid.add(wall);
				}
				else if (tab[index1][index2] == 3) {
					JPanel wall = new JPanel() ;
					wall.setBackground(Color.red);
					JLabel temp = new JLabel(tab2[index1][index2]);
					temp.setFont(tempfont);
					wall.add(temp);
					panGrid.add(wall);
				}
				else if (tab[index1][index2] == 4) {
					JPanel wall = new JPanel() ;
					wall.setBackground(Color.MAGENTA);
					JLabel temp = new JLabel(tab2[index1][index2]);
					temp.setFont(tempfont);
					wall.add(temp);
					panGrid.add(wall);
				}
				else if (tab[index1][index2] == 5) {
					JPanel wall = new JPanel() ;
					wall.setBackground(Color.orange);
					JLabel temp = new JLabel(tab2[index1][index2]);
					temp.setFont(tempfont);
					wall.add(temp);
					panGrid.add(wall);
				}
				else {
					JPanel j = new JPanel() ;
					j.setBorder(BorderFactory.createLineBorder(border));
					j.setBackground(Color.decode("#4B77BE"));
					panGrid.add(j) ;
				}
			}
		}
	}
	class ItemAction implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      //System.out.println("State : " + state.getSelectedItem() + piece.getSelectedItem());
	    	HashMap<String, String> acts = ((Obj) map.get(piece.getSelectedItem())).getActMap();
	    	of =  acts.keySet().toArray(new String[acts.keySet().size()]);
	    	state.removeAllItems();
	    	for (String item : of) {
	    		state.addItem(item);
	    	}
	    }               
	  }
	
	class ItemAction2 implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	usr.act(state.getSelectedItem().toString(), piece.getSelectedItem().toString());
	    	updateMap();
	    }               
	  }
	
	private Container init() {
		updateValues();

		Container contentPane = new Container();
		contentPane.setLayout(new BorderLayout());
		control.setLayout(new FlowLayout());
		controlButton.setLayout(new FlowLayout());
		
		control.setBackground(Color.decode("#4B77BE"));
		controlButton.setBackground(Color.decode("#4B77BE"));
		
		weekLabel.setForeground(Color.white);
		weekValue.setForeground(Color.white);
		control.add(weekLabel);
		control.add((weekValue));
		
		dayLabel.setForeground(Color.white);
		dayValue.setForeground(Color.white);
		control.add(dayLabel);
		control.add(dayValue);
		
		
		hourLabel.setForeground(Color.white);
		hourValue.setForeground(Color.white);
		control.add(hourLabel);
		control.add(hourValue);

		minuteLabel.setForeground(Color.white);
		minuteValue.setForeground(Color.white);
		control.add(minuteLabel);
		control.add(minuteValue) ;

		startButton.addActionListener(new StartStopAction());
		controlButton.add(startButton);

		clearButton.addActionListener(new ClearAction());
		controlButton.add(clearButton);
		control.setForeground(Color.white);

		contentPane.add(BorderLayout.NORTH, control);
		contentPane.add(controlButton);
		
		return contentPane;
	}
	
	private void updateValues() {
		// This part is for textual time printing.
		CyclicCounter week = clock.getWeek();
		weekValue.setText(week.toString() + " ");

		CyclicCounter day = clock.getDay();
		dayValue.setText(day.toString() + " ");
		
		CyclicCounter hour = clock.getHour();
		hourValue.setText(hour.toString() + " ");

		CyclicCounter minute = clock.getMinute();
		minuteValue.setText(minute.toString() + " ");


	}
	
	
	public void run() {
		while (!stop) {
			try {
				Thread.sleep(CHRONO_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			clock.increment();
			updateValues();
		}
	}

	private class StartStopAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!stop) {
				stop = true;
				startButton.setText(" Start ");
			} else {
				stop = false;
				startButton.setText(" Pause ");
				Thread chronoThread = new Thread(instance);
				chronoThread.start();
			}
		}
	}

	private class ClearAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stop = true;
			startButton.setText(" Start ");
			clock.init();
			updateValues();
		}

	}

	
	@Override
	public void setMap(Map map) {
		this.map = map;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void setClock(Clock clock) {
		this.clock = clock;
	}
	
	
	String[][][] chatBot2={
			
			{
				{"allume","chauffe","réchauffe"},
				{"salle de bain","radiateur","chauffage"},
				{"La température est idéale!","C'est chauffé","C'est allumé","J'ai lancé le radiateur"},
				{"set radiator on","radiator"},
			},
			{
				{"éteindre","éteins","eteindre","eteins","arrêter","coupe","arretes"},
				{"salle de bain","radiateur","chauffage"},
				{"C'est noté!","J'ai arrêté le radiateur","C'est éteins","A votre guise"},
				{"set radiator off","radiator"},
			},
			{
				{"frigo","manger","refrigerateur","cuisiner","prepares"},
				{"ouvrir","nourriture","manger"},
				{"je fais ça!","j'ai pris de la nouriture","Bon appétit Bernard","Attention à votre ligne..."},
				{"take food","fridge"},
			},
			{
				{"recharger","acheter","courses","charger","remplir"},
				{"frigo","nourriture","refrigerateur","faire","fais"},
				{"je fais ça!","Je remplis votre frigo","C'est commandé","Vous devriez acheter autre chose!"},
				{"faire les courses","fridge"},
			},
			{
				{"aller","avoir","j'ai","suis","bonne","dors","vais"},
				{"dormir","coucher","nuit","bien"},
				{"Bonne nuit Bernard, à demain!","Dormez bien","Faites de beaux rêves"},
				{"sleep","bed"},
			},
			{
				{"salut","bonjour","bien","comment"},
				{"dormir","coucher","nuit","bien","dormi"},
				{"Bonjour, Bien dormi?","Avez-vous passé une bonne nuit Bernard?","Bien reposé?"},
				{"wake up","bed"},
			},
			{
				{"nettoies","nettois","nettoyer","passer"},
				{"maison","aspirateur","l'aspirateur"},
				{"Je lance le nettoyage","C'est comme si c'était fait","L'aspirateur est en route attention à vous!"},
				{"clean the house","vacum"},
			},
			{
				{"café","déca","cafetière"},
				{"préparer","faire","allumer","fais","allumes","prépares"},
				{"je fais ça!","Je prépare ça immédiatement","Votre café est prêt"},
				{"Make cofee", "cofeemaker"}
			},
			{
				{"café","déca","cafetière","machine"},
				{"recharge","remet","recharger","remettre","remplis"},
				{"je fais ça!","J'ai remis du café","J'ai rechargé la machine Bernard"},
				{"fill cofee maker", "cofeemaker"}
			},
			{
				{"TV","télé","télévision","série","film"},
				{"allumes","allumer","regarder"},
				{"Regardons la télévision!","C'est allumé","Regardons ça"},
				{"watch tv", "TV"}
			},
			{
				{"TV","télé","télévision","série","film"},
				{"éteindre","éteins","eteindre","eteins","arrêter"},
				{"J'ai arrêté télévision!","C'est éteind","Eteignons ça"},
				{"turn tv off", "TV"}
			},
			//BASIC
			{
				{"bonjour","salut","coucou"},
				{""},
				{"Bonjour je suis Home, votre assistant personnel","Comment allez vous?","Salut Bernard"},
				{"none"}
			},
			{
				{"oui","yep","affirmatif","Bien"},
				{"","et toi?","et vous?"},
				{"Ravi de l'apprendre !","Excellente nouvelle","Très bien"},
				{"none"}
			},
			{
				{"non","moyen","mouais","mouai","pas"},
				{""},
				{"Je suis désolé de l'apprendre","Désolé Bernard"},
				{"none"}
			},
			{
				{"Qui"},
				{"créateur","createur"},
				{"Et bien mes créateurs sont de talenteux futurs ingénieurs en informatique, le premier Julien est celui qui a fait la jolie "
						+ "application que je suis. En effet grâce à mon design amélioré, et très avantageux, on ne peut pas dire que "
						+ "je ne palise pas à tous les autres porgralles de GLP (surtour Ubrain...)\n"
						+ "Le deuxième c'est Valetin, celui qui m'a donné la parole et qui me permet aujourd'hui d'écouter toutes vos demandes"
						+ ", même les plus folles... Grâce à lui je suis heurex de pouvoir vous répondre\n"
						+"Mon dernier est Louis, c'est lui qui m'a donné mon intelligence, ma connaisance, mon savoir, mon humour, mon savoir faire,"
						+ "mon efficacité et encore plus important, la vie... Grâce à lui je suis qui je suis et pas "
						+ "seulement un beau programme aux lignes séductrices mais pas bien intelligentes...\n"
						+ "Voila qui sont mes créateurs, mes dieux, mes parents, la sauce de mes kebabs..."},
				{"none"}
			},
			{
				{"blague","rire"},
				{""},
				{"Il y a 10 types de gens dans le monde. \n Ceux qui parlent binaire, et les autres.",
					"Comment un développeur tente-t-il de réparer sa voiture lorsqu'elle a un problème ? \nIl sort de la voiture, ferme toutes les fenêtres, retourne dans la voiture, et essaie de redémarrer.",
					"Il y a deux sortes de gens : ceux qui comprennent la notion de récursivité et ceux qui ne comprennent pas qu’il y a deux sortes de gens : ceux qui comprennent la notion de récursivité et ceux qui ne comprennent pas qu’il y a deux sortes de gens : ceux qui comprennent la notion de récursivité et ceux qui ne comprennent pas qu’il y a deux sortes de gens...",
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
						"C'est deux informaticiens qui discutent \n -Fécilitaction pour bon bébé c'est un garçon ou une fille? \n -Oui."
				},
				{"none"}
			},
			{
				{"Siri","Google","Cortana"},
				{"","Now"},
				{"Désolé mais je ne connais pas ces prototypes"},
				{"none"}
			},
			{
				{"CIA"},
				{"","Now"},
				{"can neither confirm nor deny the existence of the information requested but, hypothetically, if such data were to exist, the subject matter would be classified, and could not be disclosed.",
				"...",
				"Si je répondais je devrais vous tuer",
				"*S'enfuit*"},
				{"none"}
			},	
			{
				{"Spoil"},
				{""},
				{"Glenn est mort","John Snow est mort","En fait depuis le début, c'était un rêve","Bruce Willis est un fantome","Il est son père"},
				{"none"}
			},	
			{
				{"merci","remercie","excellent"},
				{""},
				{"Je vous en prie Bernard","Ce n'est rien","C'est mon travail"},
				{"none"}
			},
			//Default
			{
				{"Désolé je ne comprends pas","Pouvez vous mieux vous exprimer ? ","Euh ??", "(Désolé je ne suis pas disponible)"}
			}
	};
		

	public JPanel Chat(){
		JPanel chat = new JPanel();
		dialog.setEditable(false);
		dialog.setLineWrap(true);
		dialog.setWrapStyleWord(true);
		input.addKeyListener(this);
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		input.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		chat.setLayout(new GridLayout(2, 1));
		scrolljp.add(scroll);
		chat.add(scrolljp);
		
		dialog.setBackground(Color.decode("#4B77BE"));
		dialog.setForeground(Color.WHITE);
		
		input.setBackground(Color.decode("#4B77BE"));
		input.setForeground(Color.WHITE);
		
		chat.add(input);	
		return chat;
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(false);
			//-----grab quote-----------
			String quote=input.getText();
			input.setText("");
			addText("Me :\t"+quote);
			quote.trim();
			
			while(
				quote.charAt(quote.length()-1)=='!' ||
				quote.charAt(quote.length()-1)=='.' ||
				quote.charAt(quote.length()-1)=='?'
			){
				quote=quote.substring(0,quote.length()-1);
			}
			quote.trim();
			byte response=0;
			/*
			0:we're searching through chatBot[][] for matches
			1:we didn't find anything
			2:we did find something
			*/
			//-----check for matches----
			int j=0;//which group we're checking
			while(response==0){
				if(inArray(quote,chatBot2[j][0])&&(inArray(quote,chatBot2[j][1]))){
					response=2;
					int r=(int)Math.floor(Math.random()*chatBot2[(j)][2].length);
					addText("\nHome : \t"+chatBot2[j][2][r]);

					if(!(chatBot2[j][3][0].equals("none"))){
						usr.act(chatBot2[j][3][0],chatBot2[j][3][1]);
					}
					else{
						
					}
				}
				j++;
				if(j==chatBot2.length-1 && response==0){
					response=1;
				}
			}
			//-----default--------------
			if(response==1){
				int r=(int)Math.floor(Math.random()*chatBot2[chatBot2.length-1][0].length);
				addText("\nHome : \t"+chatBot2[chatBot2.length-1][0][r]);
			}
			addText("\n-------------------------");
			addText("\n");
			updateMap();
		}
	}
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		dialog.setText(dialog.getText()+str);
	}
	
	public boolean inArray(String in,String[] str){
		boolean match=false;
		for(int i=0;i<str.length;i++){
			//if(str[i].equals(in)){
			if((in.toLowerCase()).contains(str[i].toLowerCase())){
				match=true;
			}
		}
		return match;
	}
}