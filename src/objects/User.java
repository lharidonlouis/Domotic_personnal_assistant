package objects;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import com.opencsv.CSVWriter;

import counters.Clock;

/**
 * Utilisateur
 */
public class User implements DbSetter {
	/**
	* Constructeur
	*/
	private User() {

	}

	Map map;
	Clock clock;
	boolean testvar = false;

	/**
	 * Fonction d'action
	 *
	 * @param toDo
	 * 	Action à réaliser
	 * @param objToUse
	 *   Objet utilisé
	 * <p>Permet à lu'tilisateur de réaliser une action et de l'enregistrer dans le log
	 * </p>
	 */
	public void act(String toDo, String objToUse) {
		((Obj) map.get(objToUse)).do_i(toDo);
		try {
			String dir = System.getProperty("user.dir");
			String csv = dir + "/log.csv";
			CSVWriter writer = new CSVWriter(new FileWriter(csv, true), ',', CSVWriter.NO_QUOTE_CHARACTER);
			// Create record
			String[] record = (objToUse + "," + toDo + "," + clock.getMinute() + "," + clock.getHour() + ","
					+ clock.getDay() + "," + clock.getWeek()).split(",");
			// Write the record to file
			writer.writeNext(record);
			// close the writer
			writer.close();

		} catch (FileNotFoundException e) {
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

	/**
	 * Créer une instance unique
	 */
	private static class SingletonHolder {
		/** Instance unique non préinitialisée */
		private final static User instance = new User();
	}

	/**
	 * Point d'accès pour l'instance unique du singleton
	 * 
	 * @return l'instance de User
	 */
	public static User getInstance() {
		return SingletonHolder.instance;
	}

	@Override
	public void setMap(Map map) {
		this.map = map;
	}

	@Override
	public void setClock(Clock clock) {
		this.clock = clock;
	}
}
