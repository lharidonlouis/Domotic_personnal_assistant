package objects;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import com.opencsv.CSVReader;

import counters.Clock;


public class DataStorage implements DbSetter, DbGiver{
    private Map<String, Obj> objects;
    private Clock clock;

    @Override
    public void setMap(Map objects) {
        this.objects = objects;            
    }

    @Override
    public void giveMap(DbSetter acceptMap) {
        acceptMap.setMap(objects);
  
    }
    @Override
	public void giveClock(DbSetter acceptclock) {
        acceptclock.setClock(clock);
	}
    
    @Override
   	public void setClock(Clock clock) {
    	this.clock = clock;
   	}
    private   String OBJPATH = System.getProperty("user.dir") + "/object.csv";


	
	public Obj searchByObjName(String name){
		Obj result = null;
		if(objects.containsKey(name)){
			result = (Obj) objects.get(name);
		}
		if (result == null) {
			throw new NoSuchElementException("Object " + name + " does not exists.");
		} else {
			return result;
		}
	}
	
	public void readObject(){		
			CSVReader reader = null;
	          try {
	        	  reader = new CSVReader(new FileReader(OBJPATH));
	              String[] readingObject;
	              while ((readingObject = reader.readNext()) != null) {
	            	 Position pos_temp = new Position(Integer.parseInt(readingObject[1]),Integer.parseInt(readingObject[2]));
	                 Obj current = new Obj(pos_temp);
	                 int i = Integer.valueOf(readingObject[3]);
	                 for(int j=0; j<i; j++){
		                 //current.addInteraction("objects.actions."+readingObject[4+2*j], readingObject[5+2*j]);
		                 current.addInteraction(readingObject[5+2*j], readingObject[4+2*j]);
	                 }
	                 current.iniStatus();
	                 
	                objects.put(readingObject[0], current);
	              }    
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
		}



	public void display(){
		System.out.println("----------------------------");
		System.out.println("Liste des objets");
		Iterator iterator = objects.entrySet().iterator();
        while (iterator.hasNext()) {
          Map.Entry mapentry = (Map.Entry) iterator.next();
          Obj temp = objects.get(mapentry.getKey());
          System.out.println("appareil: "+mapentry.getKey() + temp.toString());
        } 
		System.out.println("----------------------------");
	}
	
	public void displayStatus(){
		int i;
		System.out.println("----------------------------");
		System.out.println("Statut des objets");
		Iterator iterator = objects.entrySet().iterator();
	        while (iterator.hasNext()) {
	          Map.Entry mapentry = (Map.Entry) iterator.next();
	          Obj temp = objects.get(mapentry.getKey());
	          System.out.println(mapentry.getKey() + " => " + temp.getStatus().toString());	          
	        }     		
		System.out.println("----------------------------");
		//test
	}

	
}
