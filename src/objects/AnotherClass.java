package objects;

import java.util.Map;

public class AnotherClass implements DbSetter {
    private Map map;
    private Clock clock;
    
    public void displayMap() {
    	System.out.println("val : ");

        System.out.println(map);

    }

    public void add(String var, int t){
    	map.put(var,t);

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