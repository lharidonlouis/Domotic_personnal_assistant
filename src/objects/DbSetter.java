package objects;

import java.util.Map;

import counters.Clock;

/**
 * Inerface Database Setter
 */
public interface DbSetter {
	/**
	 * fonction pour définir la map
	 * @param map
	 * 	Map à définir
	 */
	public void setMap(Map map);

	/**
	 * fonction pour définir la clock
	 * @param clock
	 * 	Clock à définir
	 */
	public void setClock(Clock clock);
}
