package objects;

import java.util.Map;

public class Home implements DbSetter{
	Map map;
	
	public void interact(String toDo, String objToUse){
		((Obj) map.get(objToUse)).do_i(toDo);
		
	}
	
	public void automate(){
		
	}
	
	@Override
	public void setMap(Map map) {
		this.map = map;		
	}
}
