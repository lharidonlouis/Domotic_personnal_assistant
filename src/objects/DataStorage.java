package objects;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import com.opencsv.CSVReader;

public class DataStorage implements MapSetter, MapGiver{
    private Map<String, Obj> objects;

    @Override
    public void setMap(Map objects) {
        this.objects = objects;            
    }

    @Override
    public void giveMap(MapSetter acceptMap) {
        acceptMap.setMap(objects);

    }
    
   
    private   String OBJPATH = System.getProperty("user.dir") + "/object.csv";

	public void add(Obj object) {
		objects.put(object.getName(), object);
	}
	
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
	                 Obj current = new Obj(readingObject[0], pos_temp);
	                 int i = Integer.valueOf(readingObject[3]);
	                 for(int j=0; j<i; j++){
		                 //current.addInteraction("objects.actions."+readingObject[4+2*j], readingObject[5+2*j]);
		                 current.addInteraction(readingObject[5+2*j], readingObject[4+2*j]);
	                 }
	                 current.iniStatus();
	                 
	                objects.put(current.getName(), current);
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

	}
}