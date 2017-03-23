package objects;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Chat extends JPanel implements KeyListener{
	JPanel p=new JPanel();
	JPanel chat =new JPanel();
	JTextArea dialog=new JTextArea(30,30);
	JTextArea input=new JTextArea(1,10);
	JScrollPane scroll=new JScrollPane(dialog,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel scrolljp = new JPanel() ;
	String[][] chatBot={
			//standard greetings
			{"hey","bonjour","salut","bonjour"},
			{"Bonjour","Comment allez vous ?","Hey"},
			//question greetings
			{"Comment vas tu ?", "ca va ?", "ça va ?", "comment ca va ?", "comment ça va ?"},
			{"Très bien, merci","Tout vas bien pour moi"},
			
			{"Allume la lumière", "allume la lumiere", "allume la lumière"},
			{"Très bien j'allume la lumière"},
			//default
			{"Désolé je ne comprends pas","Pouvez vous mieux vous exprimer ? ","Euh ??",
			"(Désolé je ne suis pas disponible)"}
		};
		
		public static void main(String[] args){	
			new Chat();
		}
		
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
				while(response==0){
					if(inArray(quote.toLowerCase(),chatBot[j*2])){
						response=2;
						int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
						addText("\nHome : \t"+chatBot[(j*2)+1][r]);
					}
					else if(quote.contains("lumiere")){
						response = 2;
						addText("\nHome : prout");
					}
					j++;
					if(j*2==chatBot.length-1 && response==0){
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
				if(str[i].equals(in)){
					match=true;
				}
			}
			return match;
		}
	}
