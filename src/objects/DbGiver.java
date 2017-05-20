package objects;

/**
 * Interface DatabaseGiver
 */
public interface DbGiver {
	/**
	 * fonction pour donner la map
	 * @param acceptMap
	 * 	Classe utilisant l'interface DBSetter à qui donner la map
	 */
	public void giveMap(DbSetter acceptMap);

	/**
	 * fonction pour donner la clock
	 * @param acceptclock
	 * 	Classe utilisant l'interface DBSetter à qui donner la clock
	 */
	public void giveClock(DbSetter acceptclock);
}
