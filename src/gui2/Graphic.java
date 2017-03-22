package gui2;
import map.MapInit;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import objects.MapSetter;
import objects.Chat;


public class Graphic extends MapInit implements MapSetter , ActionListener{
	public Map map;
	JFrame window = new JFrame() ;
	JPanel chat = new Chat() ; 
	JPanel action = new JPanel() ;
	JPanel dashboard = new JPanel() ;
	JPanel panGrid= new JPanel( new GridLayout(50,50)) ;
	JButton ActionsBt = new JButton("Actions") ;
	JButton Ajouter = new JButton("Ajouter") ;
	
	
	final static String CHAT = "Card with JButtons and chat";
	final static String ACTIONS = "Card with actions";
	
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	public  void window() {
				
		split.setDividerLocation(800);
		
		window.setTitle("Hello, My Name is Home") ;
		window.setSize(1200,780);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panGrid.setSize(800, 760);
		panGrid.setBackground(Color.decode("#4B77BE"));
		
		dashboard.setSize(400, 760);
		dashboard.setBackground(Color.decode("#4B77BE"));
		dashboard.setLocation(400, 0);
		
		action.setSize(400, 760);
		action.setBackground(Color.decode("#4B77BE"));
		action.setLocation(400, 0);
		
		
		
		JPanel tabPanel[][] = new JPanel[50][50] ; 
		
		// Create grid display

		initMap() ;
		
		for (int index1=0 ; index1<50; index1++ ){
			for (int index2=0 ; index2<50; index2++ ){
				if (tab[index1][index2] == 1) {
					JPanel wall = new JPanel() ;
					wall.setBackground(Color.white);
					panGrid.add(wall);
				}
				else {
					JPanel j = new JPanel() ;
					j.setBorder(BorderFactory.createLineBorder(Color.white));
					j.setBackground(Color.decode("#4B77BE"));
					panGrid.add(j) ;
				}
				
			}
		}
		
		for (int index1=0 ; index1<50; index1++ ){
			for (int index2=0 ; index2<50; index2++ ){
					//System.out.println(tab[index1][index2]);
			}
		}
		
		String test12 =  map.get("fridge").toString();
		JLabel test23 = new JLabel(test12);
		
		
		
		dashboard.add(ActionsBt) ;
		ActionsBt.setSize(20,20);
		dashboard.add(Ajouter) ;
		Ajouter.setSize(20,20);
		dashboard.add(chat);
		chat.setSize(10,10);
		chat.setBackground(Color.decode("#4B77BE"));
		// dashboard.
		
		split.add(panGrid) ;
		split.add(dashboard);
		//split.add(action) ;
		action.setVisible(false) ;
		window.add(split) ;
		window.setVisible(true);
		
		ActionsBt.addActionListener(this) ;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ActionsBt) {
			split.remove(dashboard);	
			
		}
	}
	
	@Override
	public void setMap(Map map) {
		this.map = map;
	}	
}