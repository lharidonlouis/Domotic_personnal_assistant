package objects;

import java.util.ArrayList;

//import objects.Position;

public class Obj{
	
	private String name;
	private Position pos;
	private Status status;
	private ArrayList<ObjPossibilityList> objPosList = new ArrayList<ObjPossibilityList>();
	
	public Obj(String name, Position pos) {
		this.name = name;
		this.pos = pos;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Position getPos() {
			return pos;
	}
	
	public void setPos(Position pos) {
		this.pos = pos;
	}

	public void display(){
		int i;
		for (i=0; i<objPosList.size(); i++){
			System.out.println(objPosList.get(i).toString());
		}
	}
	
	public void addPossibility(String name, String type, Reaction reaction, String timestamp){
		ObjPossibilityList temp = new ObjPossibilityList(name, type, reaction, timestamp);
		objPosList.add(temp);
	}
	
	public String toString(){
		return "0";// name + "/" + type + "/" + action + "/" + reaction + "/" + horodatage;
	}
	
}
