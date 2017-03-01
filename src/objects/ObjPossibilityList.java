package objects;

public class ObjPossibilityList {
	
	private String name;
	private String type;
	private Reaction reaction;
	private String timestamp;
	
	
	public ObjPossibilityList(String name, String type, Reaction reaction, String horodatage){
		this.name = name;
		this.type = type;
		this.reaction = reaction;
		this.timestamp = horodatage;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Reaction getReaction() {
		return reaction;
	}
	public void setReaction(Reaction reaction) {
		this.reaction = reaction;
	}
	
	public String getTtimestamp() {
		return timestamp;
	}
	public void setTimestamp(String horodatage) {
		this.timestamp = horodatage;
	}
	
	public String toString(){
		return "Name :" + name + "type :" + type + "reaction :" + reaction + "timestampp" + timestamp;
	}
	
}
