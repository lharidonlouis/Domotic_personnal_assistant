package objects;
	
public interface Interaction extends MapSetter{
	public default void do_interact(String name){
		
	}
	
	public default String getName(){
		return "default";
	}
	
	
}
