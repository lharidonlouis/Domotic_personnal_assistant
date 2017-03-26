package objects;

import java.util.Map;

public class Home implements DbSetter{
	Map map;
	Clock clock;
	
	public void interact(String toDo, String objToUse){
		((Obj) map.get(objToUse)).do_i(toDo);
		
	}
	
	
	@Override
	public void setMap(Map map) {
		this.map = map;		
	}

	@Override
	public void setClock(Clock clock) {
		this.clock = clock;
	}
}
