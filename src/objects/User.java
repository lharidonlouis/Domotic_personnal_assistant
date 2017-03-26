package objects;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.opencsv.CSVWriter;

public class User implements DbSetter, Runnable{

	private User(){
		
	}
	
	Map map;
	Clock clock;
	boolean testvar = false;
	
	public void act(String toDo, String objToUse){
		((Obj) map.get(objToUse)).do_i(toDo);
	    try {
	         String dir = System.getProperty("user.dir");
	    	 String csv = dir + "/log.csv";
		     CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
		    //Create record
		    String [] record = (objToUse + "," + toDo + "," + clock.getMinute() + "," + clock.getHour() + "," + clock.getDay() + "," + clock.getWeek()).split(",");
		    //Write the record to file
		    writer.writeNext(record);    
		    //close the writer
		    writer.close();

		} 
	   catch (FileNotFoundException e) {
			System.out.println("err");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("err");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("err");
			e.printStackTrace();
		}

	}
	
	public String test(){
		if (testvar==true){
			return "true";
		}
		else{
			return "false";
		}
	}
	
	private static class SingletonHolder
	{		
		/** Instance unique non préinitialisée */
		private final static User instance = new User();
	}
 
	/** Point d'accès pour l'instance unique du singleton */
	public static User getInstance()
	{
		return SingletonHolder.instance;
	}
	
	Map returnMap(){
		return map;
	}
	
	@Override
	public void setMap(Map map) {
		this.map = map;		
	}

	@Override
	public void setClock(Clock clock) {
		this.clock=clock;
	}
	


	@Override
	public void run() {
		System.out.println(clock.toString());
		testvar = true;
		System.out.println(test());
	}
}
		

