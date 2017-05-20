package objects;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Objet
 */
public class Obj {

	/**
	 * Variable de la position
	 */
	private Position pos;
	/**
	 * Variable du statut
	 */
	public Status status;

	/**
	 * HashMap des intéractions
	 */
	HashMap<String, String> interactList = new HashMap<String, String>();

	/**
	 * Constructeur
	 * @param pos
	 * 	Variable de la position
	 * <p>
	 * Initialise aussi le statut
	 * </p>
	 */
	public Obj(Position pos) {
		this.pos = pos;
		status = new Status();
	}

	/**
	 * Retourne la position
	 * @return la position
	 */
	public Position getPos() {
		return pos;
	}

	/**
	 * définit la position
	 * @param pos
	 * 	position souhaitée
	 */
	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * initialise le statut
	 */
	public void iniStatus() {
		status.ini();
	}

	/**
	 * Ajout d'une intéraction
	 * @param name
	 * 	Nom de l'interaction à ajouter
	 * @param functname
	 * 	fonction réalisée par l'interaction à ajouter
	 */
	public void addInteraction(String name, String functname) {
		interactList.put(name, functname);
	}

	/**
	 * réaliser une fonction sur l'objet
	 * @param name
	 * 	nom de l'intéraction à faire
	 * <p>
	 * Lis un nom d'intéraction à réaliser, recherche dans la liste des interactions la fonction correspondante et la réalise.
	 * </p>
	 */
	public void do_i(String name) {
		Method m;
		try {
			m = this.getClass().getMethod(interactList.get(name));
			try {
				m.invoke(this);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Définit comme vrai le statut on
	 */
	public void Turn_On() {
		status.setOn(true);
	}

	/**
	 * Définit comme faux le statut on
	 */
	public void Turn_Off() {
		status.setOn(false);
	}

	/**
	 * Enlève un élément à la quantité de l'objet
	 */
	public void Remove() {
		status.decrease();
	}

	/**
	 * Ajoute un élément à la quantité de l'objet
	 */
	public void Add() {
		status.increase();
	}

	/**
	 * Définit le statut détecté comme vrai
	 */
	public void Detect() {
		status.setDetected(true);
	}

	/**
	 * Définit le statut détecté comme faux
	 */
	public void Undetect() {
		status.setDetected(false);
	}

	/**
	 * Définti la quantité
	 * @param val
	 * 	quantité à définir
	 */
	public void setQT(int val) {
		status.setQuantity(val);
	}

	/**
	 * Récupère la quantité
	 * @return la quantité de l'objet
	 */
	public int getQT() {
		return status.getQuantity();
	}

	/**
	 * Recupère la liste des intéractins
	 * @return la liste dse intéractions
	 */
	public String StringInte() {
		String var = "";
		Iterator iterator = interactList.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry mapentry = (Map.Entry) iterator.next();
			var += mapentry.getKey() + " ";
		}
		return var;
	}

	/**
	 * Récupère la HashMap d'actions
	 * @return la HashMap interactList
	 */
	public HashMap getActMap() {
		return interactList;
	}

	/**
	 * Récupère le statut
	 * @return le statut status de l'objet
	 */
	public Status getStatus() {
		return status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return pos.toString() + " " + StringInte();
	}
}
