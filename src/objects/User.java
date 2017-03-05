package objects;

import java.util.Map;

public class User implements MapSetter{
	Map map;
	
	public void test(){
		((Obj) map.get("fridge")).setQT(10);
	}
	
	@Override
	public void setMap(Map map) {
		this.map = map;		
	}

	
	
}
