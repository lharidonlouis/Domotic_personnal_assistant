package gui2;
import map.MapInit;


import java.awt.Color;
import java.awt.GridLayout;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import objects.MapSetter;
import objects.Chat;


public class Graphic extends MapInit implements MapSetter{
	public Map map;
	
	public  void window() {
		
		JFrame window = new JFrame() ;
		JPanel chat = new Chat() ; 
		JPanel dashboard = new JPanel() ;
		JPanel panGrid= new JPanel( new GridLayout(50,50)) ;
		JButton Actions = new JButton("Actions") ;
		JButton Ajouter = new JButton("Ajouter") ;
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
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
		
		
		JPanel tabPanel[][] = new JPanel[50][50] ; 
		
		// creat grid display

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
		
		//JTextArea textArea = new JTextArea(40, 30);
		//JScrollPane scrollPane = new JScrollPane(textArea); 
		//textArea.setEditable(true);
		chat.setSize(10,10);
		dashboard.add(Actions) ;
		Actions.setSize(20,20);
		dashboard.add(Ajouter) ;
		Ajouter.setSize(20,20);
		dashboard.add(chat);
		chat.setBackground(Color.black);
		//dashboard.add(textArea);
		//pan2.add(test23);
		
		split.add(panGrid) ;
		split.add(dashboard);
		window.add(split) ;
		window.setVisible(true);
		
		
	
	}

	@Override
	public void setMap(Map map) {
		this.map = map;
	}	
}