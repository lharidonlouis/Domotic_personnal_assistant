package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JFrame;

import objects.Obj;
import objects.Status;

/**
 * Classe d'initalisation de la carte
 */
public class MapInit {
	/**
	 * Tableau entier de la map
	 */
	protected int tab[][] = new int[50][50];
	/**
	 * tableau de string de  la Map
	 */
	protected String tab2[][] = new String[50][50];

	/**
	 * Map map
	 */
	protected Map map;

	/**
	 * Initialisation de la map
	 * @param map
	 * 	map à définir
	 */
	public void initMap(Map map) {
		// Initialization of the grid
		this.map = map;

		for (int index1 = 0; index1 < 50; index1++) {
			for (int index2 = 0; index2 < 50; index2++) {
				tab[index1][index2] = 0;
			}
		}

		// outside walls

		for (int index = 0; index < 50; index++) {
			tab[index][0] = 1;
			tab[0][index] = 1;
			tab[index][49] = 1;
			tab[49][index] = 1;
		}

		// garage door and front door
		for (int index = 6; index <= 16; index++) {
			tab[49][index] = 0;
		}
		for (int index = 34; index <= 37; index++) {
			tab[49][index] = 0;
		}

		// walls house
		for (int i = 0; i < 50; i++) {
			tab[i][22] = 1;
		}

		// house's door
		for (int i = 5; i <= 7; i++) {
			tab[i][22] = 0;
		}

		for (int i = 25; i <= 27; i++) {
			tab[i][22] = 0;
		}

		for (int i = 40; i <= 42; i++) {
			tab[i][22] = 0;
		}

		// Inside walls

		for (int i = 0; i < 22; i++) {
			tab[13][i] = 1;
			tab[29][i] = 1;
		}

		// Inside walls

		for (int i = 0; i < 22; i++) {
			tab[13][i] = 1;
			tab[29][i] = 1;
		}

		Iterator entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String key = (String) entry.getKey();
			Obj value = (Obj) entry.getValue();
			Status var = value.getStatus();
			if (var.getOn()) {
				tab[value.getPos().getposY()][value.getPos().getposX()] = 2;
			}
			if (!var.getOn()) {
				tab[value.getPos().getposY()][value.getPos().getposX()] = 3;
			}
			if (var.getDetected()) {
				tab[value.getPos().getposY()][value.getPos().getposX()] = 4;
			}
			if (var.getProblem()) {
				tab[value.getPos().getposY()][value.getPos().getposX()] = 5;
			}

		}

	}

	/**
	 * Mise à jour des valeurs de la map
	 * @param map
	 * 	map à définir
	 */
	public void updateMapVal(Map map) {
		this.map = map;
		Iterator entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String key = (String) entry.getKey();
			Obj value = (Obj) entry.getValue();
			Status var = value.getStatus();
			if (var.getOn()) {
				tab[value.getPos().getposY()][value.getPos().getposX()] = 2;
			}
			if (!var.getOn()) {
				tab[value.getPos().getposY()][value.getPos().getposX()] = 3;
			}
			if (var.getDetected()) {
				tab[value.getPos().getposY()][value.getPos().getposX()] = 4;
			}
			if (var.getProblem()) {
				tab[value.getPos().getposY()][value.getPos().getposX()] = 5;
			}
		}
		entries = map.entrySet().iterator();
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				if (tab[i][j] > 1) {
					while (entries.hasNext()) {
						Map.Entry entry = (Map.Entry) entries.next();
						String key = (String) entry.getKey();
						Obj value = (Obj) entry.getValue();
						String var;
						if (value.getQT() > 0) {
							var = Integer.toString(value.getQT());
						} else {
							var = " ";
						}
						tab2[value.getPos().getposY()][value.getPos().getposX()] = var;
					}
				}
			}
		}

	}

	/**
	 * initialisation de la quantité de la Map
	 * @param map
	 * 	map à définir
	 */
	public void initQt(Map map) {
		// Initialization of the grid
		this.map = map;
		Iterator entries = map.entrySet().iterator();

		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				if (tab[i][j] > 1) {
					while (entries.hasNext()) {
						Map.Entry entry = (Map.Entry) entries.next();
						String key = (String) entry.getKey();
						Obj value = (Obj) entry.getValue();
						String var;
						if (value.getQT() > 0) {
							var = Integer.toString(value.getQT());
						} else {
							var = " ";
						}
						tab2[value.getPos().getposY()][value.getPos().getposX()] = var;
					}
				}
			}
		}
	}

}
