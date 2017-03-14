package map;

public class MapInit{
	protected int tab[][] = new int [50][50];
	
	
	public void initMap() {
		// Initialisation of the grid

		for (int index1=0 ; index1<50; index1++ ){ 		
			for (int index2=0 ; index2<50; index2++ ){
				tab[index1][index2] = 0 ;
			}
		}
			
		// outside walls
			
		for (int index3=0 ; index3<50 ; index3++) {
			tab[index3][0]=1 ;
			tab[0][index3]=1 ;
			tab[index3][49]=1 ;
			tab[49][index3]=1 ;
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
	}
}
