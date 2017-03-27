package objects;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Chat extends JPanel implements KeyListener{
	User usr = User.getInstance();
	JPanel p=new JPanel();
	JPanel chat =new JPanel();
	JTextArea dialog=new JTextArea(30,30);
	JTextArea input=new JTextArea(1,10);
	JScrollPane scroll=new JScrollPane(dialog,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel scrolljp = new JPanel();	
	
	String[][] chatBot={
			//standard greetings
			{"hey","bonjour","salut","bonjour"},
			{"Bonjour","Comment allez vous ?","Hey"},
			//question greetings
			{"Comment vas tu ?", "ca va ?", "ça va ?", "comment ca va ?", "comment ça va ?"},
			{"Très bien, merci","Tout vas bien pour moi"},
			
			{"Allume la lumière", "allume la lumiere", "allume la lumière"},
			{"Très bien j'allume la lumière"},
			{"frigo", "manger"},
			{"test de frigo ok, il reste"  + "aliments", "test2 de frigo ok"},
			//default
			{"Désolé je ne comprends pas","Pouvez vous mieux vous exprimer ? ","Euh ??",
			"(Désolé je ne suis pas disponible)"}
		};
		
	String[][][] chatBot2={
			{
				{"bonjour","salut"},
				{""},
				{"Bonjour","Comment allez vous?","Hey"},
				{"none"}
			},
			{
				{"frigo","manger","refrigerateur","cuisiner"},
				{"ouvrir","nourriture"},
				{"je fais ça!","j'ai pris de la nouriture"},
				{"take food","fridge"},
			},
			{
				{"café","déca","cafetière"},
				{"préparer","faire","allumer","fais","allumes","prépares"},
				{"je fais ça!","Je prépare ça immédiatement"},
				{"Make cofee", "cofeemaker"}
			},
			{
				{"TV","télé","télévision","série","film"},
				{"allumes","allumer","regarder"},
				{"Regardons la télévision!","C'est allumé","Regardons ça"},
				{"turn tv on", "TV"}
			},
			{
				{"TV","télé","télévision","série","film"},
				{"éteindre","éteins","eteindre","eteins","arrêter"},
				{"J'ai arrêté télévision!","C'est éteind","Eteignons ça"},
				{"turn tv off", "TV"}
			},
			//Default
			{
				{"Désolé je ne comprends pas","Pouvez vous mieux vous exprimer ? ","Euh ??", "(Désolé je ne suis pas disponible)"}
			}
	};
		
		public Chat(){

			dialog.setEditable(false);
			input.addKeyListener(this);
			chat.setLayout(new GridLayout(2, 1));
			scrolljp.add(scroll);
			chat.add(scrolljp);
			
			chat.add(input);
			add(chat);
			
			setVisible(true);
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
				/*while(response==0){
					if(inArray(quote,chatBot[j*2])){
						response=2;
						int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
						addText("\nHome : \t"+chatBot[(j*2)+1][r]);
					}
					j++;
					if(j*2==chatBot.length-1 && response==0){
						response=1;
					}
				}
				*/
				while(response==0){
					if(inArray(quote,chatBot2[j][0])&&(inArray(quote,chatBot2[j][1]))){
						response=2;
						int r=(int)Math.floor(Math.random()*chatBot2[(j)][2].length);
						addText("\nHome : \t"+chatBot2[j][2][r]);
						if(!(chatBot2[j][3].equals("none"))){
							usr.act(chatBot2[j][3][0],chatBot2[j][3][1]);
						}
					}
					j++;
					if(j==chatBot2.length-1 && response==0){
						response=1;
					}
				}
				//-----default--------------
				if(response==1){
					int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
					addText("\nHome : \t"+chatBot[chatBot.length-1][r]);
				}
				addText("\n");
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
