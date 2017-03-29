import java.util.HashMap;

import gui2.Graphic;
import objects.Clock;
import objects.DataStorage;
import objects.Obj;
import objects.User;


public class Test {

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
		Graphic gr = new Graphic();
		
		ds.giveMap(usr);
		ds.giveClock(usr);
		ds.giveMap(gr);
		ds.giveClock(gr);
		
		gr.window();
	
		/*boolean var = true;
		while(var){
			Thread.sleep(1000);
				System.out.println(usr.test());
				if(usr.test()=="true"){
					System.out.println("it's ok");
				}
		}*/
	}

}     
