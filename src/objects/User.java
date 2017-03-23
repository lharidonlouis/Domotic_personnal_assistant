package objects;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class User implements DbSetter{
	Map map;
	
	public void act(String toDo, String objToUse){
		((Obj) map.get(objToUse)).do_i(toDo);
	    try {
	    	 String current = new java.io.File( "." ).getCanonicalPath();
	    	 current = current + "/log.txt";
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter((current))));
			writer.println(((Obj) map.get(objToUse)).getPos());;
		} 
	   catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void setMap(Map map) {
		this.map = map;		
	}

	
	
}
