package objects;

public class Reaction {
	private String obj;
	private String action;
	
	public Reaction(String obj, String action){
		this.obj = obj;
		this.action = action;
	}
	
	public String toString(){
		return "" + obj + " " + action +  " ";
	}
}
