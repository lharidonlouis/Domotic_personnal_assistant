package objects;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import com.opencsv.CSVReader;

import counters.Clock;

/**
 * Classe de stockage de la Map d'objets et de la Clock
 */
public class DataStorage implements DbSetter, DbGiver {
	/**
	 * Map d'objets avec pour clef le nom
	 */
	private Map<String, Obj> objects;
	/**
	 * Clock
	 */
	private Clock clock;

	/* (non-Javadoc)
	 * @see objects.DbSetter#setMap(java.util.Map)
	 */
	@Override
	public void setMap(Map objects) {
		this.objects = objects;
	}

	/* (non-Javadoc)
	 * @see objects.DbGiver#giveMap(objects.DbSetter)
	 */
	@Override
	public void giveMap(DbSetter acceptMap) {
		acceptMap.setMap(objects);

	}

	/* (non-Javadoc)
	 * @see objects.DbGiver#giveClock(objects.DbSetter)
	 */
	@Override
	public void giveClock(DbSetter acceptclock) {
		acceptclock.setClock(clock);
	}

	/* (non-Javadoc)
	 * @see objects.DbSetter#setClock(counters.Clock)
	 */
	@Override
	public void setClock(Clock clock) {
		this.clock = clock;
	}

	/**
	 * Variable du chemin du fichier objet.csv
	 */
	private String OBJPATH = System.getProperty("user.dir") + "/object.csv";

	/**
	 * Recherche un objet par son nom
	 * @param name
	 * 	nom de l'objet à chercher
	 * @return l'objet au nom "name" si il existe, renvoie une erreur sinon
	 */
	public Obj searchByObjName(String name) {
		Obj result = null;
		if (objects.containsKey(name)) {
			result = (Obj) objects.get(name);
		}
		if (result == null) {
			throw new NoSuchElementException("Object " + name + " does not exists.");
		} else {
			return result;
		}
	}

	/**
	 * Initialisation des objets
	 * <p>
	 * Fonction qui lit les objets du csv, les définit, les initialise et les met dans la map de stockage.
	 * </p>
	 */
	public void readObject() {
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader(OBJPATH));
			String[] readingObject;
			while ((readingObject = reader.readNext()) != null) {
				Position pos_temp = new Position(Integer.parseInt(readingObject[1]),
						Integer.parseInt(readingObject[2]));
				Obj current = new Obj(pos_temp);
				int i = Integer.valueOf(readingObject[3]);
				for (int j = 0; j < i; j++) {
					// current.addInteraction("objects.actions."+readingObject[4+2*j],
					// readingObject[5+2*j]);
					current.addInteraction(readingObject[5 + 2 * j], readingObject[4 + 2 * j]);
				}
				current.iniStatus();

				objects.put(readingObject[0], current);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Affichage des objets
	 */
	public void display() {
		System.out.println("----------------------------");
		System.out.println("Liste des objets");
		Iterator iterator = objects.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapentry = (Map.Entry) iterator.next();
			Obj temp = objects.get(mapentry.getKey());
			System.out.println("appareil: " + mapentry.getKey() + temp.toString());
		}
		System.out.println("----------------------------");
	}

	/**
	 * Affichage du statu des objets
	 */
	public void displayStatus() {
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
		// test
	}

}
