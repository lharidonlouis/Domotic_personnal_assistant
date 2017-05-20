import java.util.HashMap;

import counters.Clock;
import gui2.Graphic;
import objects.DataStorage;
import objects.Home;
import objects.Obj;
import objects.User;


public class Main {
	public static void main(String[] args) throws InterruptedException {
		HashMap<String, Obj>objects = new HashMap<String, Obj>();
		Clock clock = new Clock(); 
		DataStorage ds = new DataStorage();
		ds.setMap(objects);
		ds.setClock(clock);
		ds.readObject();
		objects.get("fridge").setQT(10);
		objects.get("cofeemaker").setQT(10);

		User usr = User.getInstance();
		Home hme = Home.getInstance();
		Graphic gr = new Graphic();
		
		ds.giveClock(hme);
		ds.giveClock(usr);
		ds.giveClock(gr);

		
		ds.giveMap(usr);
		ds.giveMap(hme);
		ds.giveMap(gr);
		
		hme.iniAutomate();
		clock.set(0, 1, 1, 2);
	
		gr.window();
	}
}     
