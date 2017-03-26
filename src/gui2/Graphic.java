package gui2;
import map.MapInit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import objects.DbSetter;
import objects.Chat;


public class Graphic extends MapInit implements DbSetter , ActionListener{
	
	public Map map;
	JFrame window = new JFrame() ;
	JPanel chat = new Chat() ; 
	JPanel action = new JPanel() ;
	JPanel home = new JPanel() ;
	JPanel addremove = new JPanel() ;
	JPanel dashboard = new JPanel() ;
	JPanel panGrid= new JPanel( new GridLayout(50,50)) ;
	
	
	JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JTabbedPane tabs = new JTabbedPane(SwingConstants.TOP);
	
	String[] of = {"","On", "Off"};
	JComboBox state = new JComboBox(of);
	
	String[] items = {"","living room", "kitchen","room","garage"};
	JComboBox  piece = new JComboBox(items);

	
	public  void window() {
		 		
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
		action.setBackground(Color.decode("#4B77BE"));
		addremove.setBackground(Color.decode("#4B77BE"));
		home.setBackground(Color.decode("#4B77BE"));
		
		
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
				else if (tab[index1][index2] == 2) {
					JPanel wall = new JPanel() ;
					wall.setBackground(Color.red);
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
		
		state.addActionListener(new ItemAction()) ;
		piece.addActionListener(new ItemAction()) ;
		
		action.add(state);
		action.add(piece);
		
		
		// create tabs
		 
		tabs.addTab("Home.", home);
		tabs.addTab("Add/Remove",addremove);  
		tabs.addTab("Actions", action);

		tabs.setOpaque(false);
		   
		dashboard.add(tabs);
		home.add(chat);
		chat.setBackground(Color.decode("#4B77BE"));
		
		
		
		//window add
		
		window.getContentPane().add(dashboard);    
		
		split.add(panGrid) ;
		split.add(dashboard);
		
		window.add(split) ;
		window.setVisible(true);
			
	}
		
	class ItemAction implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      System.out.println("State : " + state.getSelectedItem() + piece.getSelectedItem());
	      if (state.getSelectedItem() == "On"){
	    	  tab[10][10]=2 ;  
	      }
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
}