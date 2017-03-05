import java.util.HashMap;

import objects.DataStorage;
import objects.Obj;
import objects.User;


public class Test {

	public static void main(String[] args) {
		HashMap<String, Obj>objects = new HashMap<String, Obj>();
		DataStorage ds = new DataStorage();
		ds.setMap(objects);
		
		ds.readObject();
		ds.display();
		ds.displayStatus();
		
		objects.get("TV").do_i("turn tv on");
		ds.display();
		ds.displayStatus();
	
		
		User usr = new User();
		ds.giveMap(usr);
		
		usr.test();
		ds.display();
		ds.displayStatus();
		objects.get("fridge").do_i("take food");
		ds.display();
		ds.displayStatus();
	}

}     
