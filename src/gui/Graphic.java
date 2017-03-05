package gui;

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
import objects.Obj;


public class Graphic implements MapSetter{
	public Map map;
	public  void window() {
		
		JFrame window = new JFrame() ;
		JPanel pan2 = new JPanel() ; 
		JPanel panGrid= new JPanel( new GridLayout(50,50)) ;
		
		window.setTitle("Grille") ;
		window.setSize(1200,780);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		int tab[][] = new int [50][50] ; 
		JPanel tabPanel[][] = new JPanel[50][50] ; 
		
		// Initialisation of the grid
		
		for (int index1=0 ; index1<50; index1++ ){ 		
			for (int index2=0 ; index2<50; index2++ ){
				tab[index1][index2] = 0 ;
			}
		}
		
		// outside walls
		
		for (int i=0 ; i<50 ; i++) {
			tab[i][0]=1 ;
			tab[0][i]=1 ;
			tab[i][49]=1 ;
			tab[49][i]=1 ;
		}
		
		// garage door and front door
		
		tab[49][5]=0 ;
		tab[49][6]=0 ;
		tab[49][7]=0 ;
		tab[49][8]=0 ;
		tab[49][9]=0 ;
		tab[49][10]=0 ;
		
		tab[49][25]=0 ;
		tab[49][26]=0 ;
		tab[49][27]=0 ;
		
		// walls house 
		for (int i=0 ; i<50 ; i++) {
			tab[i][15]=1 ;
			
		}
		
		// house's door
		
		tab[5][15]=0 ;
		tab[6][15]=0 ;
		tab[7][15]=0 ;
		tab[25][15]=0 ;
		tab[26][15]=0 ;
		tab[27][15]=0 ;
		tab[40][15]=0 ;
		tab[41][15]=0 ;
		tab[42][15]=0 ;
		
		// Inside walls
		
		for (int i=0 ; i<15 ; i++) {
			tab[13][i]=1 ;
			tab[29][i]=1 ;			
		}
		
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
					//System.out.println(tab[index1][index2]);
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