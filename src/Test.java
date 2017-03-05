import java.util.HashMap;

import objects.DataStorage;
import objects.Obj;


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
		objects.get("TV").do_i("turn tv off");
		ds.display();
		ds.displayStatus();
	}

}     
