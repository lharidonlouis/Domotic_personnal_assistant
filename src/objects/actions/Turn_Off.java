package objects.actions;

import java.util.Map;

import objects.MapSetter;
import objects.Interaction;
import objects.Obj;

public class Turn_Off implements MapSetter, Interaction{
	String name;
	Map map;
	public Turn_Off(String name){
		this.name = name;
	}
	public void do_interact(String name){
		System.out.println("j'eteinds");
		Obj temp = (Obj) map.get(name);
		temp.getStatus().setOn(true);
		map.put(name, temp);
	}
	
	public String getName(){
		return name;
	}
	@Override
	public void setMap(Map map) {
		this.map = map;
	}
}
