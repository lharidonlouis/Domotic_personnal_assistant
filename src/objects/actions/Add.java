package objects.actions;

import java.util.Map;

import objects.Interaction;
import objects.MapSetter;

public class Add implements Interaction, MapSetter{
	String name;
	Map map;
	public Add(String name){
		this.name = name;
	}
	public void do_interact(){
		System.out.println("j'ajoute");
	}
	
	public String getName(){
		return name;
	}
	@Override
	public void setMap(Map map) {
		this.map = map;
	}
}
