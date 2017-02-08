package objects;

public class Object {
	String name;
	Position pos;
	Status status;
	
	public Object(){
		
	}
	
	public void change_status(String var){
		this.status.switchStatus(var);
	}
	
	public void interact(){
	 	
	}
	
}
