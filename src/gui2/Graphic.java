package gui2;
import map.MapInit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;

import objects.MapSetter;


public class Graphic extends MapInit implements MapSetter{
	public Map map;
	public  void window() {
		
		JFrame window = new JFrame() ;
		JPanel pan2 = new JPanel() ; 
		JPanel panGrid= new JPanel( new GridLayout(50,50)) ;
		
		window.setTitle("Grille") ;
		window.setSize(1200,780);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		JPanel tabPanel[][] = new JPanel[50][50] ; 
		
		
		
		// creat grid display
		
		for (int index1=0 ; index1<50; index1++ ){
			for (int index2=0 ; index2<50; index2++ ){
				if (tab[index1][index2] == 1) {
					JPanel wall = new JPanel() ;
					wall.setBackground(Color.BLACK);
					panGrid.add(wall);
				}
				else {
					JPanel j = new JPanel() ;
					j.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					panGrid.add(j) ;
				}
				
			}
		}
		
		for (int index1=0 ; index1<50; index1++ ){
			for (int index2=0 ; index2<50; index2++ ){
					System.out.println(tab[index1][index2]);
			}
		}
		
		String test12 =  map.get("fridge").toString();
		JLabel test23 = new JLabel(test12);
		
		
		panGrid.setSize(800, 760);
		pan2.setSize(400,760);
		
		pan2.add(test23);

		window.add(panGrid) ;
		window.add(pan2);
		window.setVisible(true);
	
		
	}

	@Override
	public void setMap(Map map) {
		this.map = map;
	}	
}