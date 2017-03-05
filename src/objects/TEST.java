package objects;

import java.util.HashMap;

import objects.DataStorage;

import objects.AnotherClass;

public class TEST {
    public static void main(String[] args) {
    	System.out.println("MAIN");
    	HashMap<String, Integer> people = new HashMap<String, Integer>();

        people.put("bob", 2);
        people.put("susan", 5);

        DataStorage ds = new DataStorage();
        ds.setMap(people);

        AnotherClass ac = new AnotherClass();

        ds.giveMap(ac);
        
        ac.displayMap();
        
        ac.add("TEST1",1);
        ac.displayMap();
        ac.add("TEST2",2);
        ac.displayMap();
        ac.add("TEST3",3);
        ac.displayMap();
        ac.add("TEST3",3);
        ac.displayMap();
        AnotherClass ac2 = new AnotherClass();
        
        ds.giveMap(ac2);
        ac2.displayMap();
        ac2.add("TESTAX2", 2);
        ac2.displayMap();
        ac.displayMap();
        ds.giveMap(ac);
        ac.displayMap();
    
        System.out.println("anothervoid");
        anothervoid();
    
    
   }
    
    public static void anothervoid(){
    	HashMap<String, Integer> people = new HashMap<String, Integer>();

        people.put("bob", 2);
        people.put("susan", 5);

        DataStorage ds = new DataStorage();
        ds.setMap(people);

        AnotherClass ac = new AnotherClass();

        ds.giveMap(ac);
        
        ac.displayMap();
        
        ac.add("TEST1",1);
        ac.displayMap();
        ac.add("TEST2",2);
        ac.displayMap();
        ac.add("TEST3",3);
        ac.displayMap();
        ac.add("TEST3",3);
        ac.displayMap();
        AnotherClass ac2 = new AnotherClass();
        
        ds.giveMap(ac2);
        ac2.displayMap();
        ac2.add("TESTAX2", 2);
        ac2.displayMap();
        ac.displayMap();
        ds.giveMap(ac);
        ac.displayMap();
    }
}
