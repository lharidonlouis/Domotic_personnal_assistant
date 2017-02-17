package objects;

//import objects.Position;

public class InfoObj{
	
	private String name;
	private String type;
	private String action;
	private String reaction;
	//private Position pos;
	private String horodatage;
	
	public InfoObj(){
		
	}
	
	public InfoObj(String name, String type, String action, String reaction, String horodatage) {
		super();
		this.name = name;
		this.type = type;
		this.action = action;
		this.reaction = reaction;
		//this.pos = pos;
		this.horodatage = horodatage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getReaction() {
		return reaction;
	}
	public void setReaction(String reaction) {
		this.reaction = reaction;
	}
	
	/*
	 public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	*/
	
	public String getHorodatage() {
		return horodatage;
	}
	public void setHorodatage(String horodatage) {
		this.horodatage = horodatage;
	}
	
	public String toString(){
		return name + "/" + type + "/" + action + "/" + reaction + "/" + horodatage;
	}
	
}
