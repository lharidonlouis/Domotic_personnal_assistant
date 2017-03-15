package map;

import java.awt.Color;

public class MapInit{
	protected int tab[][] = new int [50][50];
	
	public void initMap() {
		// Initialization of the grid


		for (int index1=0 ; index1<50; index1++ ){ 		
			for (int index2=0 ; index2<50; index2++ ){
				tab[index1][index2] = 0 ;
			}
		}
			
		// outside walls
			
		for (int index=0 ; index<50 ; index++) {
			tab[index][0]=1 ;
			tab[0][index]=1 ;
			tab[index][49]=1 ;
			tab[49][index]=1 ;
		}
			
			// garage door and front door
		for (int index=5 ; index<=10 ; index++) {
			tab[49][index]=0 ;
		}
		for (int index=25 ; index<=27 ; index++) {
			tab[49][index]=0 ;
		}
		
		// walls house 
		for (int i=0 ; i<50 ; i++) {
			tab[i][15]=1 ;
		}
			
		// house's door
		for (int i=5 ; i<=7 ; i++) {
			tab[i][15]=0 ;
		}
		
		for (int i=25 ; i<=27 ; i++) {
			tab[i][15]=0 ;
		}
		
		for (int i=40 ; i<=42 ; i++) {
			tab[i][15]=0 ;
		}
		
			
		// Inside walls
			

		for (int i=0 ; i<15 ; i++) {
			tab[13][i]=1 ;
			tab[29][i]=1 ;	
		}

		// Inside walls
			
		for (int i=0 ; i<15 ; i++) {
			tab[13][i]=1 ;
			tab[29][i]=1 ;			
		}		
	}
}
