package Main;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import counters.Clock;
import gui2.Graphic;
import objects.DataStorage;
import objects.Home;
import objects.Obj;
import objects.User;

/**
 * Classe principale
 */
public class Main {
	/**
	 * Fonction main
	 * @param args
	 * 	arguemtents
	 * @throws InterruptedException
	 * 	exception d'interruption
	 */
	public static void main(String[] args) throws InterruptedException {
		iniData();
		HashMap<String, Obj> objects = new HashMap<String, Obj>();
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
	/**
	 * 
	 */
	public static void iniData(){
		try {
			String OBJPATH = System.getProperty("user.dir") + "/log.csv";
			String OBJPATH2 = System.getProperty("user.dir") + "/log_REF.csv";
			CSVWriter writer = new CSVWriter(new FileWriter(OBJPATH, false), ',', CSVWriter.NO_QUOTE_CHARACTER);
			CSVReader reader = null;
			reader = new CSVReader(new FileReader(OBJPATH2));
			String[] readLine;
			while ((readLine = reader.readNext()) != null) {
				writer.writeNext(readLine);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
