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
	JPanel pan = new JPanel (new GridLayout (10,10));
	
	
	window.setTitle("Grille") ;
	window.setVisible(true);
	window.setSize(500,500);
	window.setLocationRelativeTo(null);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
	Border blackline = BorderFactory.createLineBorder(Color.black,1); 
	for(int i = 0; i<100;i++){
	   JPanel ptest = new JPanel();
	   ptest.setBorder(blackline);
	   pan.add(ptest);
	}
	
	pan.setBorder(blackline);
	window.add(pan) ;
	}
}
