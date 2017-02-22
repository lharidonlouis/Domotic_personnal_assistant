package objects;

public class Position {
	private int posX;
	private int posY;
	
	public Position(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}
	public int getposX()  {
		return posX;
	}
	
	public int getposY(){
		return posY;
	}
	
	public void setPosX(int posX){
		this.posX = posX;
	}
	
	public void setPosY(int posY){
		this.posY = posY;
	}
}
