package objects;

import java.util.Map;

import objects.DbSetter;

public class AnotherClass implements DbSetter {
    private Map map;

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
}