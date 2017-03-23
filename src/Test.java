import java.util.HashMap;

import gui2.Graphic;
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
		objects.get("fridge").setQT(10);

		objects.get("TV").do_i("turn tv on");
		ds.displayStatus();
	
		
		User usr = new User();
		ds.giveMap(usr);
		
		usr.act("set radiator on", "radiator");
		ds.displayStatus();
		
		usr.act("set radiator off", "radiator");
		ds.displayStatus();
		
		objects.get("fridge").do_i("take food");
		ds.displayStatus();
		
		Graphic gr = new Graphic();
		ds.giveMap(gr);
		gr.window();
	}

}     
