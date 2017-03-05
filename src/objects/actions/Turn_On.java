package objects.actions;
import java.util.Map;

import objects.Interaction;
import objects.MapSetter;

public class Turn_On implements Interaction, MapSetter{
	String name;
	Map map;
	public Turn_On(String name){
		this.name = name;
	}
	public void do_interact(){
		System.out.println("j'allume");
	}
	
	public String getName(){
		return name;
	}
	@Override
	public void setMap(Map map) {
		this.map = map;
	}
}
