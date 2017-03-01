package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class graphic {
	public static void main(String[] args) {
		JFrame window = new JFrame() ;
	
		JPanel pan2 = new JPanel() ; 
		JPanel panGrid= new JPanel( new GridLayout(20,20)) ;
		
		
		window.setTitle("Grille") ;
		window.setSize(1200,780);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	
		for(int i = 0; i<(20*20);i++){
		
		   Border blackline = BorderFactory.createLineBorder(Color.black,1); 
		   JPanel panTest = new JPanel();
		   panGrid.setBackground(Color.red);
		   panTest.setBorder(blackline);
		   panTest.setBackground(Color.blue);
		   if(i==23*9){
			   panTest.setBackground(Color.GREEN);
		   }
		   panGrid.setBorder(blackline);
		   panGrid.add(panTest);
		}		
		panGrid.setSize(800, 760);
		window.add(panGrid) ;
		window.add(pan2);	
		window.setVisible(true);

	}		
}